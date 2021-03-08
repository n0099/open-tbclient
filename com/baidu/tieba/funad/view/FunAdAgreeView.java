package com.baidu.tieba.funad.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.mutiprocess.f;
import com.baidu.tbadk.pageExtra.c;
import com.baidu.tbadk.pageExtra.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener alm;
    private int cardType;
    private cb eLr;
    private TBLottieAnimationView ffJ;
    private TextView ffK;
    private TBLottieAnimationView ffL;
    private TextView ffM;
    private AgreeData ffN;
    private e ffO;
    private ScaleAnimation ffP;
    private boolean ffQ;
    private boolean ffR;
    private int ffU;
    private int ffV;
    private int ffW;
    private String ffX;
    public View.OnClickListener ffY;
    private LinearLayout ffZ;
    private LinearLayout fga;
    private boolean fgb;
    private boolean fgc;
    private CustomMessageListener fgf;
    private a jVf;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes5.dex */
    public interface a {
        void f(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.ffN != null) {
            this.ffN.agreeType = agreeData.agreeType;
            this.ffN.hasAgree = agreeData.hasAgree;
            this.ffN.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public FunAdAgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ffU = R.raw.lottie_agree;
        this.ffV = R.raw.lottie_disagree;
        this.ffW = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgb = false;
        this.fgc = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.ffN != null && agreeData != null && FunAdAgreeView.this.ffO != null && !FunAdAgreeView.this.ffN.isInPost && FunAdAgreeView.this.ffO.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.ffN.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.ffN.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.ffN.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgf = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.ffN != null && !TextUtils.isEmpty(FunAdAgreeView.this.ffN.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.ffN.postId.equals(agreeData.postId) && !FunAdAgreeView.this.ffN.isInThread) {
                        if (FunAdAgreeView.this.ffQ) {
                            if (FunAdAgreeView.this.ffN.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.ffO.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        FunAdAgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FunAdAgreeView.this.bx(view);
                if (FunAdAgreeView.this.ffY != null) {
                    FunAdAgreeView.this.ffY.onClick(view);
                }
            }
        };
        init(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ffU = R.raw.lottie_agree;
        this.ffV = R.raw.lottie_disagree;
        this.ffW = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgb = false;
        this.fgc = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.ffN != null && agreeData != null && FunAdAgreeView.this.ffO != null && !FunAdAgreeView.this.ffN.isInPost && FunAdAgreeView.this.ffO.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.ffN.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.ffN.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.ffN.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgf = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.ffN != null && !TextUtils.isEmpty(FunAdAgreeView.this.ffN.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.ffN.postId.equals(agreeData.postId) && !FunAdAgreeView.this.ffN.isInThread) {
                        if (FunAdAgreeView.this.ffQ) {
                            if (FunAdAgreeView.this.ffN.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.ffO.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        FunAdAgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FunAdAgreeView.this.bx(view);
                if (FunAdAgreeView.this.ffY != null) {
                    FunAdAgreeView.this.ffY.onClick(view);
                }
            }
        };
        init(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ffU = R.raw.lottie_agree;
        this.ffV = R.raw.lottie_disagree;
        this.ffW = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgb = false;
        this.fgc = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.ffN != null && agreeData != null && FunAdAgreeView.this.ffO != null && !FunAdAgreeView.this.ffN.isInPost && FunAdAgreeView.this.ffO.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.ffN.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.ffN.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.ffN.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgf = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.ffN != null && !TextUtils.isEmpty(FunAdAgreeView.this.ffN.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.ffN.postId.equals(agreeData.postId) && !FunAdAgreeView.this.ffN.isInThread) {
                        if (FunAdAgreeView.this.ffQ) {
                            if (FunAdAgreeView.this.ffN.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.ffO.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        FunAdAgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FunAdAgreeView.this.bx(view);
                if (FunAdAgreeView.this.ffY != null) {
                    FunAdAgreeView.this.ffY.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.ffJ = new TBLottieAnimationView(context);
        this.ffJ.setId(R.id.img_agree);
        this.ffJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ffJ.setOnClickListener(this.mOnClickListener);
        this.ffJ.addAnimatorListener(this);
        this.ffK = new TextView(context);
        this.ffK.setTextSize(0, l.getDimens(context, R.dimen.T_X09));
        this.ffK.setOnClickListener(this.mOnClickListener);
        this.ffL = new TBLottieAnimationView(context);
        this.ffL.setId(R.id.img_disagree);
        this.ffL.addAnimatorListener(this);
        this.ffL.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ffL.setOnClickListener(this.mOnClickListener);
        this.ffM = new TextView(context);
        this.ffM.setText(R.string.fun_ad_agree_view_c_disagree);
        this.ffM.setTextSize(0, l.getDimens(context, R.dimen.T_X09));
        this.ffM.setOnClickListener(this.mOnClickListener);
        this.ffO = new e();
        this.ffO.uniqueId = getPageId();
        btL();
        setAgreeAnimationResource();
        setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    private void btL() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fga = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.ffJ);
        linearLayout.addView(this.ffK);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.ffZ = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.ffL);
        linearLayout2.addView(this.ffM);
        jS(true);
    }

    private void y(int i, int i2, int i3, int i4) {
        int i5 = -l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = l.getDimens(getContext(), R.dimen.tbds34);
        this.fga.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.fga.setLayoutParams(layoutParams);
        this.ffJ.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.ffK.setLayoutParams(layoutParams2);
        this.ffZ.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.ffZ.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.ffL.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.ffM.setLayoutParams(layoutParams5);
    }

    public void jS(boolean z) {
        if (z) {
            y(l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.fgb);
            return;
        }
        y(l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.fgb);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.fgf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fgf);
    }

    public void setTopicId(String str) {
        this.ffX = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.ffQ = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.ffR = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.ffJ;
    }

    public TextView getAgreeNumView() {
        return this.ffK;
    }

    public TextView getDisagreeNumView() {
        return this.ffM;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.ffL;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.ffN = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.ffN;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.ffJ, this.ffU);
        ap.a(this.ffL, this.ffV);
    }

    private String b(AgreeData agreeData) {
        return c(agreeData);
    }

    private String c(AgreeData agreeData) {
        long j = agreeData != null ? agreeData.agreeNum : 0L;
        if (j == 0) {
            return getContext().getString(R.string.fun_ad_agree_view_c_agree);
        }
        if (j > 0) {
            return au.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + au.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.ffK.setText(b(this.ffN));
        if (this.ffN.hasAgree) {
            if (this.ffN.agreeType == 2) {
                this.ffL.setProgress(0.0f);
                this.ffJ.setProgress(1.0f);
                this.ffK.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.ffM);
                return;
            }
            this.ffJ.setProgress(0.0f);
            this.ffL.setProgress(1.0f);
            setTextNormalColor(this.ffK);
            this.ffM.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        this.ffJ.setProgress(0.0f);
        this.ffL.setProgress(0.0f);
        setTextNormalColor(this.ffK);
        setTextNormalColor(this.ffM);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.ffR) {
            textView.setTextColor(ap.getColor(R.color.CAM_X0107));
        } else if (this.ffQ) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ap.getColor(this.ffW));
        }
    }

    public void jU(boolean z) {
        this.ffJ.setMinAndMaxProgress(0.0f, 1.0f);
        this.ffL.setMinAndMaxProgress(0.0f, 1.0f);
        this.ffK.setText(b(this.ffN));
        this.ffJ.clearColorFilter();
        this.ffL.clearColorFilter();
        if (z) {
            this.ffJ.playAnimation();
            this.ffL.cancelAnimation();
            this.ffL.setFrame(0);
        } else {
            this.ffL.playAnimation();
            this.ffJ.cancelAnimation();
            this.ffJ.setFrame(0);
        }
        if (this.ffN.hasAgree) {
            if (this.ffN.agreeType == 2) {
                this.ffK.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.ffM);
                return;
            }
            setTextNormalColor(this.ffK);
            this.ffM.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.ffK);
        setTextNormalColor(this.ffM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(View view) {
        if (this.ffN != null) {
            if (!this.ffQ || f.checkUpIsLogin(getContext())) {
                if (this.ffQ || bh.checkUpIsLogin(getContext())) {
                    if (view != this.ffK || this.fgc) {
                        if (view.getId() == this.ffJ.getId() || (this.fgc && view.getId() == this.ffK.getId())) {
                            this.ffJ.cancelAnimation();
                            if (this.ffN.hasAgree) {
                                if (this.ffN.agreeType == 2) {
                                    this.ffN.agreeType = 2;
                                    this.ffN.hasAgree = false;
                                    this.ffN.agreeNum--;
                                    updateUI();
                                } else {
                                    this.ffN.agreeType = 2;
                                    this.ffN.hasAgree = true;
                                    this.ffN.agreeNum++;
                                    jU(true);
                                    com.baidu.tieba.o.a.dDg().J(getTbPageContext());
                                }
                            } else {
                                this.ffN.agreeType = 2;
                                this.ffN.hasAgree = true;
                                this.ffN.agreeNum++;
                                jU(true);
                                com.baidu.tieba.o.a.dDg().J(getTbPageContext());
                            }
                            c bR = d.bR(this);
                            if (bR != null) {
                                this.ffN.objSource = bR.getCurrentPageKey();
                            }
                        } else if (view.getId() == this.ffL.getId()) {
                            this.ffL.cancelAnimation();
                            if (this.ffN.hasAgree) {
                                if (this.ffN.agreeType == 5) {
                                    this.ffN.agreeType = 5;
                                    this.ffN.hasAgree = false;
                                    updateUI();
                                } else {
                                    this.ffN.agreeType = 5;
                                    this.ffN.hasAgree = true;
                                    this.ffN.agreeNum--;
                                    jU(false);
                                }
                            } else {
                                this.ffN.agreeType = 5;
                                this.ffN.hasAgree = true;
                                jU(false);
                            }
                            c bR2 = d.bR(this);
                            if (bR2 != null) {
                                this.ffN.objSource = bR2.getCurrentPageKey();
                            }
                        }
                        if (this.alm != null) {
                            this.alm.onClick(view);
                        }
                    }
                }
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.ffP == null) {
            this.ffP = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ffP.setDuration(200L);
        }
        return this.ffP;
    }

    public BdUniqueId getPageId() {
        TbPageContext tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public TbPageContext getTbPageContext() {
        if (this.mPageContext == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.mPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.mPageContext;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setAgreeAlone(boolean z) {
        this.ffL.setVisibility(z ? 8 : 0);
        this.ffM.setVisibility(z ? 8 : 0);
        if (z && this.ffZ != null) {
            this.ffZ.setVisibility(8);
        }
        if (this.fgb != z && this.jVf != null) {
            this.jVf.f(this.ffL, z);
        }
        this.fgb = z;
    }

    public void setDisagreeShow(boolean z) {
        this.ffL.setVisibility(z ? 8 : 0);
        this.ffM.setVisibility(z ? 8 : 0);
        if (this.ffZ != null) {
            this.ffZ.setVisibility(z ? 8 : 0);
        }
        this.fgb = z;
    }

    public void setThreadData(cb cbVar) {
        this.eLr = cbVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.ffU = i;
        this.ffV = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.ffW = i;
        setTextNormalColor(this.ffK);
        setTextNormalColor(this.ffM);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.jVf = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.ffL;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.ffJ;
    }
}

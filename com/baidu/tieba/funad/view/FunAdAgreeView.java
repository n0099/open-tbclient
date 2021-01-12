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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.mutiprocess.f;
import com.baidu.tbadk.pageExtra.c;
import com.baidu.tbadk.pageExtra.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes14.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener ake;
    private int cardType;
    private bz eHK;
    private TBLottieAnimationView fbU;
    private TextView fbV;
    private TBLottieAnimationView fbW;
    private TextView fbX;
    private AgreeData fbY;
    private e fbZ;
    private ScaleAnimation fca;
    private boolean fcb;
    private boolean fcc;
    private int fcf;
    private int fcg;
    private int fch;
    private String fci;
    public View.OnClickListener fcj;
    private LinearLayout fck;
    private LinearLayout fcl;
    private boolean fcm;
    private boolean fcn;
    private CustomMessageListener fcr;
    private a jMv;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes14.dex */
    public interface a {
        void f(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.fbY != null) {
            this.fbY.agreeType = agreeData.agreeType;
            this.fbY.hasAgree = agreeData.hasAgree;
            this.fbY.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public FunAdAgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fcf = R.raw.lottie_agree;
        this.fcg = R.raw.lottie_disagree;
        this.fch = R.color.CAM_X0107;
        this.cardType = 1;
        this.fcm = false;
        this.fcn = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fbY != null && agreeData != null && FunAdAgreeView.this.fbZ != null && !FunAdAgreeView.this.fbY.isInPost && FunAdAgreeView.this.fbZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.fbY.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.fbY.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.fbY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fcr = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fbY != null && !TextUtils.isEmpty(FunAdAgreeView.this.fbY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.fbY.postId.equals(agreeData.postId) && !FunAdAgreeView.this.fbY.isInThread) {
                        if (FunAdAgreeView.this.fcb) {
                            if (FunAdAgreeView.this.fbY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fbZ.uniqueId == eVar.uniqueId) {
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
                FunAdAgreeView.this.bB(view);
                if (FunAdAgreeView.this.fcj != null) {
                    FunAdAgreeView.this.fcj.onClick(view);
                }
            }
        };
        init(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fcf = R.raw.lottie_agree;
        this.fcg = R.raw.lottie_disagree;
        this.fch = R.color.CAM_X0107;
        this.cardType = 1;
        this.fcm = false;
        this.fcn = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fbY != null && agreeData != null && FunAdAgreeView.this.fbZ != null && !FunAdAgreeView.this.fbY.isInPost && FunAdAgreeView.this.fbZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.fbY.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.fbY.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.fbY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fcr = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fbY != null && !TextUtils.isEmpty(FunAdAgreeView.this.fbY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.fbY.postId.equals(agreeData.postId) && !FunAdAgreeView.this.fbY.isInThread) {
                        if (FunAdAgreeView.this.fcb) {
                            if (FunAdAgreeView.this.fbY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fbZ.uniqueId == eVar.uniqueId) {
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
                FunAdAgreeView.this.bB(view);
                if (FunAdAgreeView.this.fcj != null) {
                    FunAdAgreeView.this.fcj.onClick(view);
                }
            }
        };
        init(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fcf = R.raw.lottie_agree;
        this.fcg = R.raw.lottie_disagree;
        this.fch = R.color.CAM_X0107;
        this.cardType = 1;
        this.fcm = false;
        this.fcn = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fbY != null && agreeData != null && FunAdAgreeView.this.fbZ != null && !FunAdAgreeView.this.fbY.isInPost && FunAdAgreeView.this.fbZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.fbY.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.fbY.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.fbY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fcr = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fbY != null && !TextUtils.isEmpty(FunAdAgreeView.this.fbY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.fbY.postId.equals(agreeData.postId) && !FunAdAgreeView.this.fbY.isInThread) {
                        if (FunAdAgreeView.this.fcb) {
                            if (FunAdAgreeView.this.fbY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fbZ.uniqueId == eVar.uniqueId) {
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
                FunAdAgreeView.this.bB(view);
                if (FunAdAgreeView.this.fcj != null) {
                    FunAdAgreeView.this.fcj.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.fbU = new TBLottieAnimationView(context);
        this.fbU.setId(R.id.img_agree);
        this.fbU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fbU.setOnClickListener(this.mOnClickListener);
        this.fbU.addAnimatorListener(this);
        this.fbV = new TextView(context);
        this.fbV.setTextSize(0, l.getDimens(context, R.dimen.T_X09));
        this.fbV.setOnClickListener(this.mOnClickListener);
        this.fbW = new TBLottieAnimationView(context);
        this.fbW.setId(R.id.img_disagree);
        this.fbW.addAnimatorListener(this);
        this.fbW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fbW.setOnClickListener(this.mOnClickListener);
        this.fbX = new TextView(context);
        this.fbX.setText(R.string.fun_ad_agree_view_c_disagree);
        this.fbX.setTextSize(0, l.getDimens(context, R.dimen.T_X09));
        this.fbX.setOnClickListener(this.mOnClickListener);
        this.fbZ = new e();
        this.fbZ.uniqueId = getPageId();
        bto();
        setAgreeAnimationResource();
        setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    private void bto() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fcl = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.fbU);
        linearLayout.addView(this.fbV);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.fck = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.fbW);
        linearLayout2.addView(this.fbX);
        jP(true);
    }

    private void y(int i, int i2, int i3, int i4) {
        int i5 = -l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = l.getDimens(getContext(), R.dimen.tbds34);
        this.fcl.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.fcl.setLayoutParams(layoutParams);
        this.fbU.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.fbV.setLayoutParams(layoutParams2);
        this.fck.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.fck.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.fbW.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.fbX.setLayoutParams(layoutParams5);
    }

    public void jP(boolean z) {
        if (z) {
            y(l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.fcm);
            return;
        }
        y(l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.fcm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.fcr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fcr);
    }

    public void setTopicId(String str) {
        this.fci = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.fcb = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.fcc = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.fbU;
    }

    public TextView getAgreeNumView() {
        return this.fbV;
    }

    public TextView getDisagreeNumView() {
        return this.fbX;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.fbW;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.fbY = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.fbY;
    }

    public void setAgreeAnimationResource() {
        ao.a(this.fbU, this.fcf);
        ao.a(this.fbW, this.fcg);
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
            return at.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + at.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.fbV.setText(b(this.fbY));
        if (this.fbY.hasAgree) {
            if (this.fbY.agreeType == 2) {
                this.fbW.setProgress(0.0f);
                this.fbU.setProgress(1.0f);
                this.fbV.setTextColor(ao.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fbX);
                return;
            }
            this.fbU.setProgress(0.0f);
            this.fbW.setProgress(1.0f);
            setTextNormalColor(this.fbV);
            this.fbX.setTextColor(ao.getColor(R.color.CAM_X0107));
            return;
        }
        this.fbU.setProgress(0.0f);
        this.fbW.setProgress(0.0f);
        setTextNormalColor(this.fbV);
        setTextNormalColor(this.fbX);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.fcc) {
            textView.setTextColor(ao.getColor(R.color.CAM_X0107));
        } else if (this.fcb) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ao.getColor(this.fch));
        }
    }

    public void jR(boolean z) {
        this.fbU.setMinAndMaxProgress(0.0f, 1.0f);
        this.fbW.setMinAndMaxProgress(0.0f, 1.0f);
        this.fbV.setText(b(this.fbY));
        this.fbU.clearColorFilter();
        this.fbW.clearColorFilter();
        if (z) {
            this.fbU.playAnimation();
            this.fbW.cancelAnimation();
            this.fbW.setFrame(0);
        } else {
            this.fbW.playAnimation();
            this.fbU.cancelAnimation();
            this.fbU.setFrame(0);
        }
        if (this.fbY.hasAgree) {
            if (this.fbY.agreeType == 2) {
                this.fbV.setTextColor(ao.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fbX);
                return;
            }
            setTextNormalColor(this.fbV);
            this.fbX.setTextColor(ao.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.fbV);
        setTextNormalColor(this.fbX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(View view) {
        if (this.fbY != null) {
            if (!this.fcb || f.checkUpIsLogin(getContext())) {
                if (this.fcb || bg.checkUpIsLogin(getContext())) {
                    if (view != this.fbV || this.fcn) {
                        if (view.getId() == this.fbU.getId() || (this.fcn && view.getId() == this.fbV.getId())) {
                            this.fbU.cancelAnimation();
                            if (this.fbY.hasAgree) {
                                if (this.fbY.agreeType == 2) {
                                    this.fbY.agreeType = 2;
                                    this.fbY.hasAgree = false;
                                    this.fbY.agreeNum--;
                                    updateUI();
                                } else {
                                    this.fbY.agreeType = 2;
                                    this.fbY.hasAgree = true;
                                    this.fbY.agreeNum++;
                                    jR(true);
                                    com.baidu.tieba.o.a.dAJ().F(getTbPageContext());
                                }
                            } else {
                                this.fbY.agreeType = 2;
                                this.fbY.hasAgree = true;
                                this.fbY.agreeNum++;
                                jR(true);
                                com.baidu.tieba.o.a.dAJ().F(getTbPageContext());
                            }
                            c bV = d.bV(this);
                            if (bV != null) {
                                this.fbY.objSource = bV.getCurrentPageKey();
                            }
                        } else if (view.getId() == this.fbW.getId()) {
                            this.fbW.cancelAnimation();
                            if (this.fbY.hasAgree) {
                                if (this.fbY.agreeType == 5) {
                                    this.fbY.agreeType = 5;
                                    this.fbY.hasAgree = false;
                                    updateUI();
                                } else {
                                    this.fbY.agreeType = 5;
                                    this.fbY.hasAgree = true;
                                    this.fbY.agreeNum--;
                                    jR(false);
                                }
                            } else {
                                this.fbY.agreeType = 5;
                                this.fbY.hasAgree = true;
                                jR(false);
                            }
                            c bV2 = d.bV(this);
                            if (bV2 != null) {
                                this.fbY.objSource = bV2.getCurrentPageKey();
                            }
                        }
                        if (this.ake != null) {
                            this.ake.onClick(view);
                        }
                    }
                }
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.fca == null) {
            this.fca = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fca.setDuration(200L);
        }
        return this.fca;
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
        this.fbW.setVisibility(z ? 8 : 0);
        this.fbX.setVisibility(z ? 8 : 0);
        if (z && this.fck != null) {
            this.fck.setVisibility(8);
        }
        if (this.fcm != z && this.jMv != null) {
            this.jMv.f(this.fbW, z);
        }
        this.fcm = z;
    }

    public void setDisagreeShow(boolean z) {
        this.fbW.setVisibility(z ? 8 : 0);
        this.fbX.setVisibility(z ? 8 : 0);
        if (this.fck != null) {
            this.fck.setVisibility(z ? 8 : 0);
        }
        this.fcm = z;
    }

    public void setThreadData(bz bzVar) {
        this.eHK = bzVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.fcf = i;
        this.fcg = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.fch = i;
        setTextNormalColor(this.fbV);
        setTextNormalColor(this.fbX);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.jMv = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.fbW;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.fbU;
    }
}

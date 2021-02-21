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
    private View.OnClickListener ajT;
    private int cardType;
    private cb eJQ;
    private LinearLayout feA;
    private LinearLayout feB;
    private boolean feC;
    private boolean feD;
    private CustomMessageListener feG;
    private TBLottieAnimationView fek;
    private TextView fel;
    private TBLottieAnimationView fem;
    private TextView fen;
    private AgreeData feo;
    private e fep;
    private ScaleAnimation feq;
    private boolean fer;
    private boolean fes;
    private int fev;
    private int few;
    private int fex;
    private String fey;
    public View.OnClickListener fez;
    private a jTN;
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
        if (agreeData != null && this.feo != null) {
            this.feo.agreeType = agreeData.agreeType;
            this.feo.hasAgree = agreeData.hasAgree;
            this.feo.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public FunAdAgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fev = R.raw.lottie_agree;
        this.few = R.raw.lottie_disagree;
        this.fex = R.color.CAM_X0107;
        this.cardType = 1;
        this.feC = false;
        this.feD = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.feo != null && agreeData != null && FunAdAgreeView.this.fep != null && !FunAdAgreeView.this.feo.isInPost && FunAdAgreeView.this.fep.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.feo.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.feo.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.feo.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.feG = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.feo != null && !TextUtils.isEmpty(FunAdAgreeView.this.feo.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.feo.postId.equals(agreeData.postId) && !FunAdAgreeView.this.feo.isInThread) {
                        if (FunAdAgreeView.this.fer) {
                            if (FunAdAgreeView.this.feo.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fep.uniqueId == eVar.uniqueId) {
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
                if (FunAdAgreeView.this.fez != null) {
                    FunAdAgreeView.this.fez.onClick(view);
                }
            }
        };
        init(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fev = R.raw.lottie_agree;
        this.few = R.raw.lottie_disagree;
        this.fex = R.color.CAM_X0107;
        this.cardType = 1;
        this.feC = false;
        this.feD = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.feo != null && agreeData != null && FunAdAgreeView.this.fep != null && !FunAdAgreeView.this.feo.isInPost && FunAdAgreeView.this.fep.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.feo.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.feo.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.feo.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.feG = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.feo != null && !TextUtils.isEmpty(FunAdAgreeView.this.feo.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.feo.postId.equals(agreeData.postId) && !FunAdAgreeView.this.feo.isInThread) {
                        if (FunAdAgreeView.this.fer) {
                            if (FunAdAgreeView.this.feo.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fep.uniqueId == eVar.uniqueId) {
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
                if (FunAdAgreeView.this.fez != null) {
                    FunAdAgreeView.this.fez.onClick(view);
                }
            }
        };
        init(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fev = R.raw.lottie_agree;
        this.few = R.raw.lottie_disagree;
        this.fex = R.color.CAM_X0107;
        this.cardType = 1;
        this.feC = false;
        this.feD = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.feo != null && agreeData != null && FunAdAgreeView.this.fep != null && !FunAdAgreeView.this.feo.isInPost && FunAdAgreeView.this.fep.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.feo.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.feo.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.feo.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.feG = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.feo != null && !TextUtils.isEmpty(FunAdAgreeView.this.feo.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.feo.postId.equals(agreeData.postId) && !FunAdAgreeView.this.feo.isInThread) {
                        if (FunAdAgreeView.this.fer) {
                            if (FunAdAgreeView.this.feo.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fep.uniqueId == eVar.uniqueId) {
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
                if (FunAdAgreeView.this.fez != null) {
                    FunAdAgreeView.this.fez.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.fek = new TBLottieAnimationView(context);
        this.fek.setId(R.id.img_agree);
        this.fek.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fek.setOnClickListener(this.mOnClickListener);
        this.fek.addAnimatorListener(this);
        this.fel = new TextView(context);
        this.fel.setTextSize(0, l.getDimens(context, R.dimen.T_X09));
        this.fel.setOnClickListener(this.mOnClickListener);
        this.fem = new TBLottieAnimationView(context);
        this.fem.setId(R.id.img_disagree);
        this.fem.addAnimatorListener(this);
        this.fem.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fem.setOnClickListener(this.mOnClickListener);
        this.fen = new TextView(context);
        this.fen.setText(R.string.fun_ad_agree_view_c_disagree);
        this.fen.setTextSize(0, l.getDimens(context, R.dimen.T_X09));
        this.fen.setOnClickListener(this.mOnClickListener);
        this.fep = new e();
        this.fep.uniqueId = getPageId();
        btI();
        setAgreeAnimationResource();
        setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    private void btI() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.feB = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.fek);
        linearLayout.addView(this.fel);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.feA = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.fem);
        linearLayout2.addView(this.fen);
        jS(true);
    }

    private void y(int i, int i2, int i3, int i4) {
        int i5 = -l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = l.getDimens(getContext(), R.dimen.tbds34);
        this.feB.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.feB.setLayoutParams(layoutParams);
        this.fek.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.fel.setLayoutParams(layoutParams2);
        this.feA.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.feA.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.fem.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.fen.setLayoutParams(layoutParams5);
    }

    public void jS(boolean z) {
        if (z) {
            y(l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.feC);
            return;
        }
        y(l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.feC);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.feG);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.feG);
    }

    public void setTopicId(String str) {
        this.fey = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.fer = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.fes = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.fek;
    }

    public TextView getAgreeNumView() {
        return this.fel;
    }

    public TextView getDisagreeNumView() {
        return this.fen;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.fem;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.feo = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.feo;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.fek, this.fev);
        ap.a(this.fem, this.few);
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
        this.fel.setText(b(this.feo));
        if (this.feo.hasAgree) {
            if (this.feo.agreeType == 2) {
                this.fem.setProgress(0.0f);
                this.fek.setProgress(1.0f);
                this.fel.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fen);
                return;
            }
            this.fek.setProgress(0.0f);
            this.fem.setProgress(1.0f);
            setTextNormalColor(this.fel);
            this.fen.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        this.fek.setProgress(0.0f);
        this.fem.setProgress(0.0f);
        setTextNormalColor(this.fel);
        setTextNormalColor(this.fen);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.fes) {
            textView.setTextColor(ap.getColor(R.color.CAM_X0107));
        } else if (this.fer) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ap.getColor(this.fex));
        }
    }

    public void jU(boolean z) {
        this.fek.setMinAndMaxProgress(0.0f, 1.0f);
        this.fem.setMinAndMaxProgress(0.0f, 1.0f);
        this.fel.setText(b(this.feo));
        this.fek.clearColorFilter();
        this.fem.clearColorFilter();
        if (z) {
            this.fek.playAnimation();
            this.fem.cancelAnimation();
            this.fem.setFrame(0);
        } else {
            this.fem.playAnimation();
            this.fek.cancelAnimation();
            this.fek.setFrame(0);
        }
        if (this.feo.hasAgree) {
            if (this.feo.agreeType == 2) {
                this.fel.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fen);
                return;
            }
            setTextNormalColor(this.fel);
            this.fen.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.fel);
        setTextNormalColor(this.fen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(View view) {
        if (this.feo != null) {
            if (!this.fer || f.checkUpIsLogin(getContext())) {
                if (this.fer || bh.checkUpIsLogin(getContext())) {
                    if (view != this.fel || this.feD) {
                        if (view.getId() == this.fek.getId() || (this.feD && view.getId() == this.fel.getId())) {
                            this.fek.cancelAnimation();
                            if (this.feo.hasAgree) {
                                if (this.feo.agreeType == 2) {
                                    this.feo.agreeType = 2;
                                    this.feo.hasAgree = false;
                                    this.feo.agreeNum--;
                                    updateUI();
                                } else {
                                    this.feo.agreeType = 2;
                                    this.feo.hasAgree = true;
                                    this.feo.agreeNum++;
                                    jU(true);
                                    com.baidu.tieba.o.a.dCY().J(getTbPageContext());
                                }
                            } else {
                                this.feo.agreeType = 2;
                                this.feo.hasAgree = true;
                                this.feo.agreeNum++;
                                jU(true);
                                com.baidu.tieba.o.a.dCY().J(getTbPageContext());
                            }
                            c bR = d.bR(this);
                            if (bR != null) {
                                this.feo.objSource = bR.getCurrentPageKey();
                            }
                        } else if (view.getId() == this.fem.getId()) {
                            this.fem.cancelAnimation();
                            if (this.feo.hasAgree) {
                                if (this.feo.agreeType == 5) {
                                    this.feo.agreeType = 5;
                                    this.feo.hasAgree = false;
                                    updateUI();
                                } else {
                                    this.feo.agreeType = 5;
                                    this.feo.hasAgree = true;
                                    this.feo.agreeNum--;
                                    jU(false);
                                }
                            } else {
                                this.feo.agreeType = 5;
                                this.feo.hasAgree = true;
                                jU(false);
                            }
                            c bR2 = d.bR(this);
                            if (bR2 != null) {
                                this.feo.objSource = bR2.getCurrentPageKey();
                            }
                        }
                        if (this.ajT != null) {
                            this.ajT.onClick(view);
                        }
                    }
                }
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.feq == null) {
            this.feq = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.feq.setDuration(200L);
        }
        return this.feq;
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
        this.fem.setVisibility(z ? 8 : 0);
        this.fen.setVisibility(z ? 8 : 0);
        if (z && this.feA != null) {
            this.feA.setVisibility(8);
        }
        if (this.feC != z && this.jTN != null) {
            this.jTN.f(this.fem, z);
        }
        this.feC = z;
    }

    public void setDisagreeShow(boolean z) {
        this.fem.setVisibility(z ? 8 : 0);
        this.fen.setVisibility(z ? 8 : 0);
        if (this.feA != null) {
            this.feA.setVisibility(z ? 8 : 0);
        }
        this.feC = z;
    }

    public void setThreadData(cb cbVar) {
        this.eJQ = cbVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.fev = i;
        this.few = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.fex = i;
        setTextNormalColor(this.fel);
        setTextNormalColor(this.fen);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.jTN = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.fem;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.fek;
    }
}

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
/* loaded from: classes15.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener akV;
    private int cardType;
    private bz eMv;
    private TBLottieAnimationView fgD;
    private TextView fgE;
    private TBLottieAnimationView fgF;
    private TextView fgG;
    private AgreeData fgH;
    private e fgI;
    private ScaleAnimation fgJ;
    private boolean fgK;
    private boolean fgL;
    private int fgO;
    private int fgP;
    private int fgQ;
    private String fgR;
    public View.OnClickListener fgS;
    private LinearLayout fgT;
    private LinearLayout fgU;
    private boolean fgV;
    private boolean fgW;
    private CustomMessageListener fgZ;
    private a jRa;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes15.dex */
    public interface a {
        void f(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.fgH != null) {
            this.fgH.agreeType = agreeData.agreeType;
            this.fgH.hasAgree = agreeData.hasAgree;
            this.fgH.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public FunAdAgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fgO = R.raw.lottie_agree;
        this.fgP = R.raw.lottie_disagree;
        this.fgQ = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgV = false;
        this.fgW = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fgH != null && agreeData != null && FunAdAgreeView.this.fgI != null && !FunAdAgreeView.this.fgH.isInPost && FunAdAgreeView.this.fgI.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.fgH.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.fgH.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.fgH.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgZ = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fgH != null && !TextUtils.isEmpty(FunAdAgreeView.this.fgH.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.fgH.postId.equals(agreeData.postId) && !FunAdAgreeView.this.fgH.isInThread) {
                        if (FunAdAgreeView.this.fgK) {
                            if (FunAdAgreeView.this.fgH.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fgI.uniqueId == eVar.uniqueId) {
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
                if (FunAdAgreeView.this.fgS != null) {
                    FunAdAgreeView.this.fgS.onClick(view);
                }
            }
        };
        init(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fgO = R.raw.lottie_agree;
        this.fgP = R.raw.lottie_disagree;
        this.fgQ = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgV = false;
        this.fgW = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fgH != null && agreeData != null && FunAdAgreeView.this.fgI != null && !FunAdAgreeView.this.fgH.isInPost && FunAdAgreeView.this.fgI.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.fgH.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.fgH.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.fgH.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgZ = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fgH != null && !TextUtils.isEmpty(FunAdAgreeView.this.fgH.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.fgH.postId.equals(agreeData.postId) && !FunAdAgreeView.this.fgH.isInThread) {
                        if (FunAdAgreeView.this.fgK) {
                            if (FunAdAgreeView.this.fgH.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fgI.uniqueId == eVar.uniqueId) {
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
                if (FunAdAgreeView.this.fgS != null) {
                    FunAdAgreeView.this.fgS.onClick(view);
                }
            }
        };
        init(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fgO = R.raw.lottie_agree;
        this.fgP = R.raw.lottie_disagree;
        this.fgQ = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgV = false;
        this.fgW = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fgH != null && agreeData != null && FunAdAgreeView.this.fgI != null && !FunAdAgreeView.this.fgH.isInPost && FunAdAgreeView.this.fgI.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (FunAdAgreeView.this.fgH.baijiahaoData != null && TextUtils.equals(str, FunAdAgreeView.this.fgH.baijiahaoData.oriUgcNid)) {
                                FunAdAgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = FunAdAgreeView.this.fgH.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            FunAdAgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgZ = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.funad.view.FunAdAgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (FunAdAgreeView.this.fgH != null && !TextUtils.isEmpty(FunAdAgreeView.this.fgH.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && FunAdAgreeView.this.fgH.postId.equals(agreeData.postId) && !FunAdAgreeView.this.fgH.isInThread) {
                        if (FunAdAgreeView.this.fgK) {
                            if (FunAdAgreeView.this.fgH.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (FunAdAgreeView.this.fgI.uniqueId == eVar.uniqueId) {
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
                if (FunAdAgreeView.this.fgS != null) {
                    FunAdAgreeView.this.fgS.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.fgD = new TBLottieAnimationView(context);
        this.fgD.setId(R.id.img_agree);
        this.fgD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fgD.setOnClickListener(this.mOnClickListener);
        this.fgD.addAnimatorListener(this);
        this.fgE = new TextView(context);
        this.fgE.setTextSize(0, l.getDimens(context, R.dimen.T_X09));
        this.fgE.setOnClickListener(this.mOnClickListener);
        this.fgF = new TBLottieAnimationView(context);
        this.fgF.setId(R.id.img_disagree);
        this.fgF.addAnimatorListener(this);
        this.fgF.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fgF.setOnClickListener(this.mOnClickListener);
        this.fgG = new TextView(context);
        this.fgG.setText(R.string.tb_ad_op_c_disagree);
        this.fgG.setTextSize(0, l.getDimens(context, R.dimen.T_X09));
        this.fgG.setOnClickListener(this.mOnClickListener);
        this.fgI = new e();
        this.fgI.uniqueId = getPageId();
        bxi();
        setAgreeAnimationResource();
        setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    private void bxi() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fgU = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.fgD);
        linearLayout.addView(this.fgE);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.fgT = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.fgF);
        linearLayout2.addView(this.fgG);
        jT(true);
    }

    private void y(int i, int i2, int i3, int i4) {
        int i5 = -l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = l.getDimens(getContext(), R.dimen.tbds34);
        this.fgU.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.fgU.setLayoutParams(layoutParams);
        this.fgD.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.fgE.setLayoutParams(layoutParams2);
        this.fgT.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.fgT.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.fgF.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.fgG.setLayoutParams(layoutParams5);
    }

    public void jT(boolean z) {
        if (z) {
            y(l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.fgV);
            return;
        }
        y(l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.fgV);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.fgZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fgZ);
    }

    public void setTopicId(String str) {
        this.fgR = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.fgK = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.fgL = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.fgD;
    }

    public TextView getAgreeNumView() {
        return this.fgE;
    }

    public TextView getDisagreeNumView() {
        return this.fgG;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.fgF;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.fgH = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.fgH;
    }

    public void setAgreeAnimationResource() {
        ao.a(this.fgD, this.fgO);
        ao.a(this.fgF, this.fgP);
    }

    private String b(AgreeData agreeData) {
        return c(agreeData);
    }

    private String c(AgreeData agreeData) {
        long j = agreeData != null ? agreeData.agreeNum : 0L;
        if (j == 0) {
            return getContext().getString(R.string.tb_ad_op_c_agree);
        }
        if (j > 0) {
            return at.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + at.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.fgE.setText(b(this.fgH));
        if (this.fgH.hasAgree) {
            if (this.fgH.agreeType == 2) {
                this.fgF.setProgress(0.0f);
                this.fgD.setProgress(1.0f);
                this.fgE.setTextColor(ao.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fgG);
                return;
            }
            this.fgD.setProgress(0.0f);
            this.fgF.setProgress(1.0f);
            setTextNormalColor(this.fgE);
            this.fgG.setTextColor(ao.getColor(R.color.CAM_X0107));
            return;
        }
        this.fgD.setProgress(0.0f);
        this.fgF.setProgress(0.0f);
        setTextNormalColor(this.fgE);
        setTextNormalColor(this.fgG);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.fgL) {
            textView.setTextColor(ao.getColor(R.color.CAM_X0107));
        } else if (this.fgK) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ao.getColor(this.fgQ));
        }
    }

    public void jV(boolean z) {
        this.fgD.setMinAndMaxProgress(0.0f, 1.0f);
        this.fgF.setMinAndMaxProgress(0.0f, 1.0f);
        this.fgE.setText(b(this.fgH));
        this.fgD.clearColorFilter();
        this.fgF.clearColorFilter();
        if (z) {
            this.fgD.playAnimation();
            this.fgF.cancelAnimation();
            this.fgF.setFrame(0);
        } else {
            this.fgF.playAnimation();
            this.fgD.cancelAnimation();
            this.fgD.setFrame(0);
        }
        if (this.fgH.hasAgree) {
            if (this.fgH.agreeType == 2) {
                this.fgE.setTextColor(ao.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fgG);
                return;
            }
            setTextNormalColor(this.fgE);
            this.fgG.setTextColor(ao.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.fgE);
        setTextNormalColor(this.fgG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(View view) {
        if (this.fgH != null) {
            if (!this.fgK || f.checkUpIsLogin(getContext())) {
                if (this.fgK || bg.checkUpIsLogin(getContext())) {
                    if (view != this.fgE || this.fgW) {
                        if (view.getId() == this.fgD.getId() || (this.fgW && view.getId() == this.fgE.getId())) {
                            this.fgD.cancelAnimation();
                            if (this.fgH.hasAgree) {
                                if (this.fgH.agreeType == 2) {
                                    this.fgH.agreeType = 2;
                                    this.fgH.hasAgree = false;
                                    this.fgH.agreeNum--;
                                    updateUI();
                                } else {
                                    this.fgH.agreeType = 2;
                                    this.fgH.hasAgree = true;
                                    this.fgH.agreeNum++;
                                    jV(true);
                                    com.baidu.tieba.o.a.dEB().F(getTbPageContext());
                                }
                            } else {
                                this.fgH.agreeType = 2;
                                this.fgH.hasAgree = true;
                                this.fgH.agreeNum++;
                                jV(true);
                                com.baidu.tieba.o.a.dEB().F(getTbPageContext());
                            }
                            c bV = d.bV(this);
                            if (bV != null) {
                                this.fgH.objSource = bV.getCurrentPageKey();
                            }
                        } else if (view.getId() == this.fgF.getId()) {
                            this.fgF.cancelAnimation();
                            if (this.fgH.hasAgree) {
                                if (this.fgH.agreeType == 5) {
                                    this.fgH.agreeType = 5;
                                    this.fgH.hasAgree = false;
                                    updateUI();
                                } else {
                                    this.fgH.agreeType = 5;
                                    this.fgH.hasAgree = true;
                                    this.fgH.agreeNum--;
                                    jV(false);
                                }
                            } else {
                                this.fgH.agreeType = 5;
                                this.fgH.hasAgree = true;
                                jV(false);
                            }
                            c bV2 = d.bV(this);
                            if (bV2 != null) {
                                this.fgH.objSource = bV2.getCurrentPageKey();
                            }
                        }
                        if (this.akV != null) {
                            this.akV.onClick(view);
                        }
                    }
                }
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.fgJ == null) {
            this.fgJ = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fgJ.setDuration(200L);
        }
        return this.fgJ;
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
        this.fgF.setVisibility(z ? 8 : 0);
        this.fgG.setVisibility(z ? 8 : 0);
        if (z && this.fgT != null) {
            this.fgT.setVisibility(8);
        }
        if (this.fgV != z && this.jRa != null) {
            this.jRa.f(this.fgF, z);
        }
        this.fgV = z;
    }

    public void setDisagreeShow(boolean z) {
        this.fgF.setVisibility(z ? 8 : 0);
        this.fgG.setVisibility(z ? 8 : 0);
        if (this.fgT != null) {
            this.fgT.setVisibility(z ? 8 : 0);
        }
        this.fgV = z;
    }

    public void setThreadData(bz bzVar) {
        this.eMv = bzVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.fgO = i;
        this.fgP = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.fgQ = i;
        setTextNormalColor(this.fgE);
        setTextNormalColor(this.fgG);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.jRa = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.fgF;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.fgD;
    }
}

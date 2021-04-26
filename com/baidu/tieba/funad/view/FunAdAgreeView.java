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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.a.c.e.p.l;
import d.a.i0.f0.f;
import d.a.i0.r.q.a2;
import d.a.j0.d3.h0.e;
/* loaded from: classes4.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    public View.OnClickListener A;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16725e;

    /* renamed from: f  reason: collision with root package name */
    public TBLottieAnimationView f16726f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16727g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f16728h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16729i;
    public AgreeData j;
    public e k;
    public ScaleAnimation l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public LinearLayout t;
    public LinearLayout u;
    public boolean v;
    public boolean w;
    public d x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e)) {
                return;
            }
            e eVar = (e) customResponsedMessage.getData();
            AgreeData agreeData = eVar.f53077b;
            if (FunAdAgreeView.this.j == null || agreeData == null || FunAdAgreeView.this.k == null || FunAdAgreeView.this.j.isInPost || FunAdAgreeView.this.k.f53076a == eVar.f53076a) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (FunAdAgreeView.this.j.baijiahaoData == null || !TextUtils.equals(str, FunAdAgreeView.this.j.baijiahaoData.oriUgcNid)) {
                    return;
                }
                FunAdAgreeView.this.m(agreeData);
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = FunAdAgreeView.this.j.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            FunAdAgreeView.this.m(agreeData);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e)) {
                return;
            }
            e eVar = (e) customResponsedMessage.getData();
            AgreeData agreeData = eVar.f53077b;
            if (FunAdAgreeView.this.j == null || TextUtils.isEmpty(FunAdAgreeView.this.j.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !FunAdAgreeView.this.j.postId.equals(agreeData.postId) || FunAdAgreeView.this.j.isInThread) {
                return;
            }
            if (FunAdAgreeView.this.m) {
                if (FunAdAgreeView.this.j.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (FunAdAgreeView.this.k.f53076a == eVar.f53076a) {
                return;
            }
            FunAdAgreeView.this.m(agreeData);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FunAdAgreeView.this.l(view);
            View.OnClickListener onClickListener = FunAdAgreeView.this.s;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(View view, boolean z);
    }

    public FunAdAgreeView(Context context) {
        super(context);
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.v = false;
        this.w = false;
        this.y = new a(2016528);
        this.z = new b(2016530);
        this.A = new c();
        i(context);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.n) {
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        } else if (this.m) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(SkinManager.getColor(this.q));
        }
    }

    public void f(boolean z) {
        if (z) {
            k(l.g(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.v);
            return;
        }
        k(l.g(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.v);
    }

    public final String g(AgreeData agreeData) {
        long j = agreeData != null ? agreeData.agreeNum : 0L;
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            return getContext().getString(R.string.fun_ad_agree_view_c_agree);
        }
        if (i2 > 0) {
            return StringHelper.numFormatOverWanNa(j);
        }
        return "-" + StringHelper.numFormatOverWanNa(-j);
    }

    public TextView getAgreeNumView() {
        return this.f16727g;
    }

    public AgreeData getData() {
        return this.j;
    }

    public TextView getDisagreeNumView() {
        return this.f16729i;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.f16726f;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.f16728h;
    }

    public BdUniqueId getPageId() {
        TbPageContext tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public Animation getScaleAnimation() {
        if (this.l == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.l = scaleAnimation;
            scaleAnimation.setDuration(200L);
        }
        return this.l;
    }

    public TbPageContext getTbPageContext() {
        if (this.f16725e == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.f16725e = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.f16725e = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.f16725e;
    }

    public final String h(AgreeData agreeData) {
        return g(agreeData);
    }

    public final void i(Context context) {
        setOrientation(0);
        TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
        this.f16726f = tBLottieAnimationView;
        tBLottieAnimationView.setId(R.id.img_agree);
        this.f16726f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f16726f.setOnClickListener(this.A);
        this.f16726f.addAnimatorListener(this);
        TextView textView = new TextView(context);
        this.f16727g = textView;
        textView.setTextSize(0, l.g(context, R.dimen.T_X09));
        this.f16727g.setOnClickListener(this.A);
        TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
        this.f16728h = tBLottieAnimationView2;
        tBLottieAnimationView2.setId(R.id.img_disagree);
        this.f16728h.addAnimatorListener(this);
        this.f16728h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f16728h.setOnClickListener(this.A);
        TextView textView2 = new TextView(context);
        this.f16729i = textView2;
        textView2.setText(R.string.fun_ad_agree_view_c_disagree);
        this.f16729i.setTextSize(0, l.g(context, R.dimen.T_X09));
        this.f16729i.setOnClickListener(this.A);
        e eVar = new e();
        this.k = eVar;
        eVar.f53076a = getPageId();
        j();
        setAgreeAnimationResource();
        setAgreeAlone(true);
        setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.u = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.f16726f);
        linearLayout.addView(this.f16727g);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.t = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.f16728h);
        linearLayout2.addView(this.f16729i);
        f(true);
    }

    public final void k(int i2, int i3, int i4, int i5) {
        int i6 = -l.g(getContext(), R.dimen.tbds24);
        int g2 = l.g(getContext(), R.dimen.tbds34);
        this.u.setGravity(i5);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
        float f2 = i4;
        layoutParams.weight = f2;
        this.u.setLayoutParams(layoutParams);
        this.f16726f.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i6;
        this.f16727g.setLayoutParams(layoutParams2);
        this.t.setGravity(i5);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
        layoutParams3.weight = f2;
        this.t.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
        layoutParams4.leftMargin = g2;
        this.f16728h.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i6;
        this.f16729i.setLayoutParams(layoutParams5);
    }

    public final void l(View view) {
        if (this.j == null) {
            return;
        }
        if (!this.m || f.a(getContext())) {
            if (this.m || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f16727g || this.w) {
                    if (view.getId() != this.f16726f.getId() && (!this.w || view.getId() != this.f16727g.getId())) {
                        if (view.getId() == this.f16728h.getId()) {
                            this.f16728h.cancelAnimation();
                            AgreeData agreeData = this.j;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    n();
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    o(false);
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                o(false);
                            }
                            d.a.i0.i0.c f2 = TbPageExtraHelper.f(this);
                            if (f2 != null) {
                                this.j.objSource = f2.a();
                            }
                        }
                    } else {
                        this.f16726f.cancelAnimation();
                        AgreeData agreeData2 = this.j;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                n();
                            } else {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                o(true);
                                d.a.j0.r2.a.g().l(getTbPageContext());
                            }
                        } else {
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            o(true);
                            d.a.j0.r2.a.g().l(getTbPageContext());
                        }
                        d.a.i0.i0.c f3 = TbPageExtraHelper.f(this);
                        if (f3 != null) {
                            this.j.objSource = f3.a();
                        }
                    }
                    View.OnClickListener onClickListener = this.r;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            }
        }
    }

    public final void m(AgreeData agreeData) {
        AgreeData agreeData2;
        if (agreeData == null || (agreeData2 = this.j) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        n();
    }

    public void n() {
        this.f16727g.setText(h(this.j));
        AgreeData agreeData = this.j;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                this.f16728h.setProgress(0.0f);
                this.f16726f.setProgress(1.0f);
                this.f16727g.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.f16729i);
                return;
            }
            this.f16726f.setProgress(0.0f);
            this.f16728h.setProgress(1.0f);
            setTextNormalColor(this.f16727g);
            this.f16729i.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            return;
        }
        this.f16726f.setProgress(0.0f);
        this.f16728h.setProgress(0.0f);
        setTextNormalColor(this.f16727g);
        setTextNormalColor(this.f16729i);
    }

    public void o(boolean z) {
        this.f16726f.setMinAndMaxProgress(0.0f, 1.0f);
        this.f16728h.setMinAndMaxProgress(0.0f, 1.0f);
        this.f16727g.setText(h(this.j));
        this.f16726f.clearColorFilter();
        this.f16728h.clearColorFilter();
        if (z) {
            this.f16726f.playAnimation();
            this.f16728h.cancelAnimation();
            this.f16728h.setFrame(0);
        } else {
            this.f16728h.playAnimation();
            this.f16726f.cancelAnimation();
            this.f16726f.setFrame(0);
        }
        AgreeData agreeData = this.j;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                this.f16727g.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.f16729i);
                return;
            }
            setTextNormalColor(this.f16727g);
            this.f16729i.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.f16727g);
        setTextNormalColor(this.f16729i);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.y);
        MessageManager.getInstance().registerListener(this.z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.y);
        MessageManager.getInstance().unRegisterListener(this.z);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        this.f16728h.setVisibility(z ? 8 : 0);
        this.f16729i.setVisibility(z ? 8 : 0);
        if (z && (linearLayout = this.t) != null) {
            linearLayout.setVisibility(8);
        }
        if (this.v != z && (dVar = this.x) != null) {
            dVar.a(this.f16728h, z);
        }
        this.v = z;
    }

    public void setAgreeAnimationResource() {
        SkinManager.setLottieAnimation(this.f16726f, this.o);
        SkinManager.setLottieAnimation(this.f16728h, this.p);
    }

    public void setData(AgreeData agreeData) {
        if (agreeData == null) {
            return;
        }
        this.j = agreeData;
        n();
    }

    public void setDisagreeShow(boolean z) {
        this.f16728h.setVisibility(z ? 8 : 0);
        this.f16729i.setVisibility(z ? 8 : 0);
        LinearLayout linearLayout = this.t;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 8 : 0);
        }
        this.v = z;
    }

    public void setNormalColorResourceId(int i2) {
        this.q = i2;
        setTextNormalColor(this.f16727g);
        setTextNormalColor(this.f16729i);
    }

    public void setResourceId(int i2, int i3) {
        this.o = i2;
        this.p = i3;
        setAgreeAnimationResource();
    }

    public void setThreadData(a2 a2Var) {
    }

    public void setVisibilityListener(d dVar) {
        this.x = dVar;
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.v = false;
        this.w = false;
        this.y = new a(2016528);
        this.z = new b(2016530);
        this.A = new c();
        i(context);
    }

    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.v = false;
        this.w = false;
        this.y = new a(2016528);
        this.z = new b(2016530);
        this.A = new c();
        i(context);
    }
}

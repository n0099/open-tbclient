package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.a.c.e.p.l;
import d.a.n0.v.j.g.d.b;
/* loaded from: classes4.dex */
public class AlaEffectPreviewView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f14094e;

    /* renamed from: f  reason: collision with root package name */
    public int f14095f;

    /* renamed from: g  reason: collision with root package name */
    public View f14096g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f14097h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14098i;
    public b.c j;
    public ObjectAnimator k;
    public LinearLayout l;
    public ImageView m;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Bitmap p;
            super.onLoaded((a) aVar, str, i2);
            if (aVar == null || (p = aVar.p()) == null) {
                return;
            }
            try {
                if (p.getConfig() == null) {
                    p = p.copy(Bitmap.Config.ARGB_8888, false);
                } else {
                    p = p.copy(p.getConfig(), false);
                }
            } catch (OutOfMemoryError e2) {
                BdLog.e(e2);
                if (p.getConfig() != null) {
                    return;
                }
                try {
                    p = p.copy(Bitmap.Config.RGB_565, false);
                } catch (OutOfMemoryError e3) {
                    BdLog.e(e3);
                    return;
                }
            }
            if (p == null) {
                return;
            }
            try {
                Bitmap g2 = d.a.c.e.p.d.d().g(p, l.k(AlaEffectPreviewView.this.getContext()), AlaEffectPreviewView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                if (g2 != p) {
                    p.recycle();
                }
                AlaEffectPreviewView.this.f14097h.setImageBitmap(g2);
            } catch (OutOfMemoryError e4) {
                BdLog.e(e4);
                if (p != null) {
                    p.recycle();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TimeInterpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return f2;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (AlaEffectPreviewView.this.j != null) {
                AlaEffectPreviewView.this.j.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class d extends FloatEvaluator {
        public d() {
        }

        public /* synthetic */ d(AlaEffectPreviewView alaEffectPreviewView, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.animation.TypeEvaluator
        public Float evaluate(float f2, Number number, Number number2) {
            float f3;
            float f4 = f2 * 3500.0f;
            if (f4 <= 500.0f) {
                f3 = (AlaEffectPreviewView.this.f14094e * ((f4 / 500.0f) - 1.0f)) + AlaEffectPreviewView.this.f14095f;
            } else {
                float f5 = 3500.0f - f4;
                if (f5 <= 500.0f) {
                    f3 = AlaEffectPreviewView.this.f14095f + (AlaEffectPreviewView.this.f14094e * (1.0f - (f5 / 500.0f)));
                } else {
                    f3 = AlaEffectPreviewView.this.f14095f;
                }
            }
            return Float.valueOf(f3);
        }
    }

    public AlaEffectPreviewView(Context context) {
        super(context);
        e();
    }

    public final void e() {
        this.f14096g = LinearLayout.inflate(getContext(), R.layout.ala_enter_effect_preview_view, this);
        this.f14097h = (ImageView) findViewById(R.id.ala_im_user_enter_icon_view);
        this.f14098i = (TextView) findViewById(R.id.ala_im_user_enter_content);
        this.l = (LinearLayout) findViewById(R.id.ala_enter_effect_content_layout);
        this.m = (ImageView) findViewById(R.id.ala_im_user_enter_tail);
    }

    public void f() {
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void g() {
        if (getMeasuredWidth() <= 0) {
            measure(0, 0);
        }
        int k = l.k(getContext());
        this.f14094e = k;
        this.f14095f = (k - getMeasuredWidth()) / 2;
        View view = this.f14096g;
        int i2 = this.f14094e;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "TranslationX", i2, -i2);
        this.k = ofFloat;
        ofFloat.setDuration(3500L);
        this.k.setInterpolator(new b());
        this.k.addListener(new c());
        this.k.setEvaluator(new d(this, null));
        this.k.start();
    }

    public void setAnimCompleteCallback(b.c cVar) {
        this.j = cVar;
    }

    public void setData(AlaEnterEffectData alaEnterEffectData) {
        GradientDrawable gradientDrawable;
        if (alaEnterEffectData == null) {
            return;
        }
        String str = alaEnterEffectData.content_first;
        String str2 = alaEnterEffectData.content_last;
        String currentAccountNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
        if (StringUtils.isNull(currentAccountNameShow)) {
            currentAccountNameShow = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (StringUtils.isNull(str) && StringUtils.isNull(str2)) {
            spannableStringBuilder.append((CharSequence) currentAccountNameShow);
            spannableStringBuilder.append((CharSequence) SpannableString.valueOf(getResources().getString(R.string.ala_contribute_rank_enter_suffix)));
        } else {
            if (!StringUtils.isNull(str)) {
                spannableStringBuilder.append((CharSequence) SpannableString.valueOf(str + " "));
            }
            spannableStringBuilder.append((CharSequence) currentAccountNameShow);
            if (!StringUtils.isNull(str2)) {
                spannableStringBuilder.append((CharSequence) SpannableString.valueOf(" " + str2));
            }
        }
        String str3 = alaEnterEffectData.icon_url;
        if (StringUtils.isNull(str3)) {
            this.f14097h.setVisibility(8);
        } else {
            this.f14097h.setVisibility(0);
            d.a.c.e.l.d.h().m(str3, 10, new a(), null);
        }
        this.f14098i.setText(spannableStringBuilder);
        String str4 = alaEnterEffectData.color;
        if (StringUtils.isNull(str4)) {
            str4 = "#B2FF5460";
        }
        try {
            if (!TextUtils.isEmpty(alaEnterEffectData.startColor) && !TextUtils.isEmpty(alaEnterEffectData.endColor)) {
                gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(alaEnterEffectData.startColor), Color.parseColor(alaEnterEffectData.endColor)});
            } else {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor(str4));
            }
            if (!TextUtils.isEmpty(alaEnterEffectData.strokeColor)) {
                gradientDrawable.setStroke(1, Color.parseColor(alaEnterEffectData.strokeColor));
            }
        } catch (IllegalArgumentException unused) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1291889568);
        }
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.l.setBackgroundDrawable(gradientDrawable);
        if (3 == alaEnterEffectData.categoryType) {
            this.m.setVisibility(0);
        }
    }

    public AlaEffectPreviewView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public AlaEffectPreviewView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }
}

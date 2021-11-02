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
import b.a.e.e.p.l;
import b.a.r0.w.l.g.d.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AlaEffectPreviewView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47211e;

    /* renamed from: f  reason: collision with root package name */
    public int f47212f;

    /* renamed from: g  reason: collision with root package name */
    public View f47213g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f47214h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47215i;
    public b.c j;
    public ObjectAnimator k;
    public LinearLayout l;
    public ImageView m;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEffectPreviewView f47216a;

        public a(AlaEffectPreviewView alaEffectPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEffectPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47216a = alaEffectPreviewView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Bitmap p;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
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
                    Bitmap g2 = b.a.e.e.p.d.d().g(p, l.k(this.f47216a.getContext()), this.f47216a.getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                    if (g2 != p) {
                        p.recycle();
                    }
                    this.f47216a.f47214h.setImageBitmap(g2);
                } catch (OutOfMemoryError e4) {
                    BdLog.e(e4);
                    if (p != null) {
                        p.recycle();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements TimeInterpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEffectPreviewView f47217a;

        public b(AlaEffectPreviewView alaEffectPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEffectPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47217a = alaEffectPreviewView;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? f2 : invokeF.floatValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaEffectPreviewView f47218e;

        public c(AlaEffectPreviewView alaEffectPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEffectPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47218e = alaEffectPreviewView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f47218e.j == null) {
                return;
            }
            this.f47218e.j.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends FloatEvaluator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaEffectPreviewView f47219a;

        public d(AlaEffectPreviewView alaEffectPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEffectPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47219a = alaEffectPreviewView;
        }

        public /* synthetic */ d(AlaEffectPreviewView alaEffectPreviewView, a aVar) {
            this(alaEffectPreviewView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.animation.TypeEvaluator
        public Float evaluate(float f2, Number number, Number number2) {
            InterceptResult invokeCommon;
            float f3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), number, number2})) == null) {
                float f4 = f2 * 3500.0f;
                if (f4 <= 500.0f) {
                    f3 = (this.f47219a.f47211e * ((f4 / 500.0f) - 1.0f)) + this.f47219a.f47212f;
                } else {
                    float f5 = 3500.0f - f4;
                    f3 = f5 <= 500.0f ? this.f47219a.f47212f + (this.f47219a.f47211e * (1.0f - (f5 / 500.0f))) : this.f47219a.f47212f;
                }
                return Float.valueOf(f3);
            }
            return (Float) invokeCommon.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaEffectPreviewView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f47213g = LinearLayout.inflate(getContext(), R.layout.ala_enter_effect_preview_view, this);
            this.f47214h = (ImageView) findViewById(R.id.ala_im_user_enter_icon_view);
            this.f47215i = (TextView) findViewById(R.id.ala_im_user_enter_content);
            this.l = (LinearLayout) findViewById(R.id.ala_enter_effect_content_layout);
            this.m = (ImageView) findViewById(R.id.ala_im_user_enter_tail);
        }
    }

    public void onDestory() {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (objectAnimator = this.k) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    public void setAnimCompleteCallback(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void setData(AlaEnterEffectData alaEnterEffectData) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, alaEnterEffectData) == null) || alaEnterEffectData == null) {
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
            this.f47214h.setVisibility(8);
        } else {
            this.f47214h.setVisibility(0);
            b.a.e.e.l.d.h().m(str3, 10, new a(this), null);
        }
        this.f47215i.setText(spannableStringBuilder);
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

    public void startAnimtion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (getMeasuredWidth() <= 0) {
                measure(0, 0);
            }
            int k = l.k(getContext());
            this.f47211e = k;
            this.f47212f = (k - getMeasuredWidth()) / 2;
            View view = this.f47213g;
            int i2 = this.f47211e;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "TranslationX", i2, -i2);
            this.k = ofFloat;
            ofFloat.setDuration(3500L);
            this.k.setInterpolator(new b(this));
            this.k.addListener(new c(this));
            this.k.setEvaluator(new d(this, null));
            this.k.start();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaEffectPreviewView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaEffectPreviewView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        e();
    }
}

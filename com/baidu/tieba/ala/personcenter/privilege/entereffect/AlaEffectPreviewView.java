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
import c.a.d.f.p.f;
import c.a.d.f.p.n;
import c.a.p0.c0.l.g.d.b;
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
/* loaded from: classes5.dex */
public class AlaEffectPreviewView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f31479b;

    /* renamed from: c  reason: collision with root package name */
    public View f31480c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f31481d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31482e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f31483f;

    /* renamed from: g  reason: collision with root package name */
    public ObjectAnimator f31484g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f31485h;
    public ImageView i;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEffectPreviewView a;

        public a(AlaEffectPreviewView alaEffectPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEffectPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEffectPreviewView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Bitmap p;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((a) aVar, str, i);
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
                    Bitmap g2 = f.d().g(p, n.k(this.a.getContext()), this.a.getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                    if (g2 != p) {
                        p.recycle();
                    }
                    this.a.f31481d.setImageBitmap(g2);
                } catch (OutOfMemoryError e4) {
                    BdLog.e(e4);
                    if (p != null) {
                        p.recycle();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TimeInterpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEffectPreviewView a;

        public b(AlaEffectPreviewView alaEffectPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEffectPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEffectPreviewView;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? f2 : invokeF.floatValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEffectPreviewView a;

        public c(AlaEffectPreviewView alaEffectPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEffectPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEffectPreviewView;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.a.f31483f == null) {
                return;
            }
            this.a.f31483f.a();
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

    /* loaded from: classes5.dex */
    public class d extends FloatEvaluator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEffectPreviewView a;

        public d(AlaEffectPreviewView alaEffectPreviewView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaEffectPreviewView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaEffectPreviewView;
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
                    f3 = (this.a.a * ((f4 / 500.0f) - 1.0f)) + this.a.f31479b;
                } else {
                    float f5 = 3500.0f - f4;
                    f3 = f5 <= 500.0f ? this.a.f31479b + (this.a.a * (1.0f - (f5 / 500.0f))) : this.a.f31479b;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.f31480c = LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d00f3, this);
            this.f31481d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901e2);
            this.f31482e = (TextView) findViewById(R.id.obfuscated_res_0x7f0901e1);
            this.f31485h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0901c7);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901e3);
        }
    }

    public void f() {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (objectAnimator = this.f31484g) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (getMeasuredWidth() <= 0) {
                measure(0, 0);
            }
            int k = n.k(getContext());
            this.a = k;
            this.f31479b = (k - getMeasuredWidth()) / 2;
            View view = this.f31480c;
            int i = this.a;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "TranslationX", i, -i);
            this.f31484g = ofFloat;
            ofFloat.setDuration(3500L);
            this.f31484g.setInterpolator(new b(this));
            this.f31484g.addListener(new c(this));
            this.f31484g.setEvaluator(new d(this, null));
            this.f31484g.start();
        }
    }

    public void setAnimCompleteCallback(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f31483f = cVar;
        }
    }

    public void setData(AlaEnterEffectData alaEnterEffectData) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, alaEnterEffectData) == null) || alaEnterEffectData == null) {
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
            spannableStringBuilder.append((CharSequence) SpannableString.valueOf(getResources().getString(R.string.obfuscated_res_0x7f0f01fe)));
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
            this.f31481d.setVisibility(8);
        } else {
            this.f31481d.setVisibility(0);
            c.a.d.f.l.d.h().m(str3, 10, new a(this), null);
        }
        this.f31482e.setText(spannableStringBuilder);
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
        this.f31485h.setBackgroundDrawable(gradientDrawable);
        if (3 == alaEnterEffectData.categoryType) {
            this.i.setVisibility(0);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public AlaEffectPreviewView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

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
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.kd;
import com.baidu.tieba.zd6;
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
    public int b;
    public View c;
    public ImageView d;
    public TextView e;
    public zd6.c f;
    public ObjectAnimator g;
    public LinearLayout h;
    public ImageView i;

    /* loaded from: classes5.dex */
    public class a extends BdResourceCallback<BdImage> {
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
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Bitmap rawBitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((a) bdImage, str, i);
                if (bdImage == null || (rawBitmap = bdImage.getRawBitmap()) == null) {
                    return;
                }
                try {
                    if (rawBitmap.getConfig() == null) {
                        rawBitmap = rawBitmap.copy(Bitmap.Config.ARGB_8888, false);
                    } else {
                        rawBitmap = rawBitmap.copy(rawBitmap.getConfig(), false);
                    }
                } catch (OutOfMemoryError e) {
                    BdLog.e(e);
                    if (rawBitmap.getConfig() == null) {
                        try {
                            rawBitmap = rawBitmap.copy(Bitmap.Config.RGB_565, false);
                        } catch (OutOfMemoryError e2) {
                            BdLog.e(e2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (rawBitmap == null) {
                    return;
                }
                try {
                    Bitmap f = kd.d().f(rawBitmap, BdUtilHelper.getEquipmentWidth(this.a.getContext()), this.a.getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                    if (f != rawBitmap) {
                        rawBitmap.recycle();
                    }
                    this.a.d.setImageBitmap(f);
                } catch (OutOfMemoryError e3) {
                    BdLog.e(e3);
                    if (rawBitmap != null) {
                        rawBitmap.recycle();
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

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) ? f : invokeF.floatValue;
        }

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
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaEffectPreviewView a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && this.a.f != null) {
                this.a.f.a();
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
        public Float evaluate(float f, Number number, Number number2) {
            InterceptResult invokeCommon;
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), number, number2})) == null) {
                float f3 = f * 3500.0f;
                if (f3 <= 500.0f) {
                    f2 = (this.a.a * ((f3 / 500.0f) - 1.0f)) + this.a.b;
                } else {
                    float f4 = 3500.0f - f3;
                    if (f4 <= 500.0f) {
                        f2 = this.a.b + (this.a.a * (1.0f - (f4 / 500.0f)));
                    } else {
                        f2 = this.a.b;
                    }
                }
                return Float.valueOf(f2);
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

    public void setAnimCompleteCallback(zd6.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f = cVar;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d00f9, this);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f09020e);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09020d);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0901f4);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f09020f);
        }
    }

    public void f() {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (objectAnimator = this.g) != null) {
            objectAnimator.cancel();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (getMeasuredWidth() <= 0) {
                measure(0, 0);
            }
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
            this.a = equipmentWidth;
            this.b = (equipmentWidth - getMeasuredWidth()) / 2;
            View view2 = this.c;
            int i = this.a;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "TranslationX", i, -i);
            this.g = ofFloat;
            ofFloat.setDuration(3500L);
            this.g.setInterpolator(new b(this));
            this.g.addListener(new c(this));
            this.g.setEvaluator(new d(this, null));
            this.g.start();
        }
    }

    public void setData(AlaEnterEffectData alaEnterEffectData) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, alaEnterEffectData) != null) || alaEnterEffectData == null) {
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
            spannableStringBuilder.append((CharSequence) SpannableString.valueOf(getResources().getString(R.string.obfuscated_res_0x7f0f0238)));
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
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
            BdResourceLoader.getInstance().loadResource(str3, 10, new a(this), null);
        }
        this.e.setText(spannableStringBuilder);
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
        this.h.setBackgroundDrawable(gradientDrawable);
        if (3 == alaEnterEffectData.categoryType) {
            this.i.setVisibility(0);
        }
    }
}

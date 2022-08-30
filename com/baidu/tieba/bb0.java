package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.refresh.LoadAnimStrategy;
import com.baidu.live.business.view.emotion.EmotionStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bb0 {
    public static /* synthetic */ Interceptable $ic;
    public static bb0 d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public va0 c;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final bb0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-924618628, "Lcom/baidu/tieba/bb0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-924618628, "Lcom/baidu/tieba/bb0$a;");
                    return;
                }
            }
            a = new bb0();
        }
    }

    public bb0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "day";
    }

    public static bb0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                d = a.a;
            }
            return d;
        }
        return (bb0) invokeV.objValue;
    }

    public int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        va0 va0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str2) || (va0Var = this.c) == null) {
                return -16777216;
            }
            return va0Var.a(context, str, str2);
        }
        return invokeLLL.intValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if ("recommend".equals(str)) {
                return EmotionStrategy.getInstance().recEmptyImageRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return EmotionStrategy.getInstance().emptyImageRes3;
            }
            if ("night".equals(this.b)) {
                return EmotionStrategy.getInstance().emptyImageRes1;
            }
            if ("dark".equals(this.b)) {
                return EmotionStrategy.getInstance().emptyImageRes2;
            }
            return EmotionStrategy.getInstance().emptyImageRes;
        }
        return invokeL.intValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if ("recommend".equals(str)) {
                return EmotionStrategy.getInstance().recErrorImageRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return EmotionStrategy.getInstance().errorImageRes3;
            }
            if ("night".equals(this.b)) {
                return EmotionStrategy.getInstance().errorImageRes1;
            }
            if ("dark".equals(this.b)) {
                return EmotionStrategy.getInstance().errorImageRes2;
            }
            return EmotionStrategy.getInstance().errorImageRes;
        }
        return invokeL.intValue;
    }

    public int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if ("recommend".equals(str)) {
                return EmotionStrategy.getInstance().recNetworkImageRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return EmotionStrategy.getInstance().networkImageRes3;
            }
            if ("night".equals(this.b)) {
                return EmotionStrategy.getInstance().networkImageRes1;
            }
            if ("dark".equals(this.b)) {
                return EmotionStrategy.getInstance().networkImageRes2;
            }
            return EmotionStrategy.getInstance().networkImageRes;
        }
        return invokeL.intValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? "recommend".equals(str) ? R.drawable.obfuscated_res_0x7f080d1d : (LiveFeedPageSdk.IMMERSION.equals(str) || LiveFeedPageSdk.VIDEO_BAR.equals(str)) ? R.drawable.obfuscated_res_0x7f080d1e : "night".equals(this.b) ? R.drawable.obfuscated_res_0x7f080d1f : "dark".equals(this.b) ? R.drawable.obfuscated_res_0x7f080d1e : R.drawable.obfuscated_res_0x7f080d1d : invokeL.intValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieRecRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieRes3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieRes1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieRes2;
            }
            return LoadAnimStrategy.getInstance().loadMoreLottieRes;
        }
        return (String) invokeL.objValue;
    }

    public int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieResRecId;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieResId3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieResId1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieResId2;
            }
            return LoadAnimStrategy.getInstance().loadMoreLottieResId;
        }
        return invokeL.intValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().loadingLottieRecRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().loadingLottieRes3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadingLottieRes1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadingLottieRes2;
            }
            return LoadAnimStrategy.getInstance().loadingLottieRes;
        }
        return (String) invokeL.objValue;
    }

    public int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().loadingLottieRecResId;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().loadingLottieResId3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadingLottieResId1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadingLottieResId2;
            }
            return LoadAnimStrategy.getInstance().loadingLottieResId;
        }
        return invokeL.intValue;
    }

    public int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (LiveFeedPageSdk.VIDEO_BAR.equals(str)) {
                return EmotionStrategy.getInstance().videoBarPlaceHolderRes;
            }
            if ("recommend".equals(str)) {
                return EmotionStrategy.getInstance().recPlaceHolderRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return EmotionStrategy.getInstance().placeHolderRes3;
            }
            if ("night".equals(this.b)) {
                return EmotionStrategy.getInstance().placeHolderRes1;
            }
            if ("dark".equals(this.b)) {
                return EmotionStrategy.getInstance().placeHolderRes2;
            }
            return EmotionStrategy.getInstance().placeHolderRes;
        }
        return invokeL.intValue;
    }

    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRecRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRes3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRes1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRes2;
            }
            return LoadAnimStrategy.getInstance().pullDownLottieRes;
        }
        return (String) invokeL.objValue;
    }

    public int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRecResId;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().pullDownLottieResId3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().pullDownLottieResId1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().pullDownLottieResId2;
            }
            return LoadAnimStrategy.getInstance().pullDownLottieResId;
        }
        return invokeL.intValue;
    }

    public GradientDrawable n(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, str)) == null) {
            float b = n80.b(context, 18.0f);
            float[] fArr = {b, b, b, b, b, b, b, b};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(fArr);
            gradientDrawable.setColor(a(context, str, "color_btn_fill"));
            gradientDrawable.setStroke(1, a(context, str, "color_btn_stroke"));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeLL.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? ("recommend".equals(str) || LiveFeedPageSdk.IMMERSION.equals(str)) ? R.drawable.obfuscated_res_0x7f080cd0 : "night".equals(this.b) ? R.drawable.obfuscated_res_0x7f080cd1 : "dark".equals(this.b) ? R.drawable.obfuscated_res_0x7f080cd0 : R.drawable.obfuscated_res_0x7f080ccf : invokeL.intValue;
    }

    public int p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if ("recommend".equals(str) || LiveFeedPageSdk.IMMERSION.equals(str)) {
                return R.drawable.obfuscated_res_0x7f080ce1;
            }
            if ("night".equals(this.b)) {
                return R.drawable.obfuscated_res_0x7f080ce2;
            }
            if ("dark".equals(this.b)) {
            }
            return R.drawable.obfuscated_res_0x7f080ce0;
        }
        return invokeL.intValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.a = str;
            if (s(str2)) {
                this.b = str2;
            }
            if ("baidu".equals(this.a)) {
                this.c = new ua0();
            } else if (LiveFeedPageSdk.HOST_HAOKAN.equals(this.a)) {
                this.c = new wa0();
            } else if (LiveFeedPageSdk.HOST_QUANMIN.equals(this.a)) {
                this.c = new ya0();
            } else if ("tieba".equals(this.a)) {
                this.c = new ab0();
            }
            this.c.b(str2);
        }
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? "day".equals(str) || "night".equals(str) || "dark".equals(str) : invokeL.booleanValue;
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && s(str)) {
            this.b = str;
            va0 va0Var = this.c;
            if (va0Var != null) {
                va0Var.b(str);
            }
        }
    }
}

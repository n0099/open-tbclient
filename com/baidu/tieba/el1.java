package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class el1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject a;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new JSONObject();
            H("material_type", str);
            H("material_url", str2);
        }

        public b A(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                try {
                    this.a.put("skip_btn_height", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b B(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                try {
                    this.a.put("skip_btn_type", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b C(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                try {
                    this.a.put("skip_btn_width", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b D(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                try {
                    this.a.put("skipTime", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b E(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                try {
                    this.a.put("small_logo_height", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b F(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                try {
                    this.a.put("small_logo_width", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b G(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
                try {
                    this.a.put("style", jSONObject);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                try {
                    this.a.put("ad_click_opt", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                try {
                    this.a.put("ad_label", str);
                    if (TextUtils.isEmpty(str)) {
                        this.a.put("hide_ad_logo", false);
                    }
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                try {
                    this.a.put("ad_label_height", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                try {
                    this.a.put("ad_label_width", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                try {
                    this.a.put("bottom_logo_height", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                try {
                    this.a.put("close_type", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
                try {
                    this.a.put("bitmapDisplayMode", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
                try {
                    this.a.put("full_screen", z);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                try {
                    this.a.put("gesture_lottie_direction", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                H("gesture_lottie_url", str);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048595, this, f)) == null) {
                try {
                    this.a.put("gesture_lottie_sensitivity", f);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeF.objValue;
        }

        public b m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
                try {
                    this.a.put("gesture_lottie_type", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b n(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
                try {
                    this.a.put("host_big_logo_res_id", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                try {
                    this.a.put("host_small_logo_res_id", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
                try {
                    this.a.put("show_host_small_logo", z);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b q(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, jSONObject)) == null) {
                try {
                    this.a.put("inner_style", jSONObject);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                H("lottie_url", str);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
                try {
                    this.a.put("mantleActionText", str);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b t(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
                try {
                    this.a.put("mantleBottomMargin", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b u(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                H("prod", str);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b v(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048605, this, f)) == null) {
                try {
                    this.a.put("shake_action_delay_time", f);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeF.objValue;
        }

        public b w(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
                try {
                    this.a.put("shake_direction_count", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b x(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
                try {
                    this.a.put("shake_update_interval", i);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b y(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
                try {
                    this.a.put("lottie_show", z);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b z(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
                try {
                    this.a.put("show_wifi_view", z);
                } catch (JSONException unused) {
                }
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public final void H(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
                try {
                    this.a.put(str, str2);
                } catch (Throwable unused) {
                }
            }
        }

        public el1 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new el1(this.a, null);
            }
            return (el1) invokeV.objValue;
        }
    }

    public el1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONObject;
    }

    public /* synthetic */ el1(JSONObject jSONObject, a aVar) {
        this(jSONObject);
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (JSONObject) invokeV.objValue;
    }
}

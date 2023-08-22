package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tieba.nx0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gy0 extends z01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> d;
    public final HashMap<String, String> e;

    public gy0() {
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
        this.d = new HashMap<>();
        this.e = new HashMap<>();
    }

    @Override // com.baidu.tieba.tx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new int[]{2, 4, 6};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z01
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.m();
            this.d.clear();
            this.e.clear();
        }
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (i() == null) {
                return "0";
            }
            return String.valueOf(i().C());
        }
        return (String) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (i() == null) {
                return "0";
            }
            return String.valueOf(i().D());
        }
        return (String) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!(i() instanceof zt0) || ((zt0) i()).l1() != 0) {
                return "0";
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z01, com.baidu.tieba.tx0
    public void a(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sw0Var) == null) {
            p(sw0Var);
        }
    }

    @Override // com.baidu.tieba.z01, com.baidu.tieba.tx0
    public void d(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sw0Var) == null) {
            p(sw0Var);
        }
    }

    @Override // com.baidu.tieba.z01, com.baidu.tieba.tx0
    public void q(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sw0Var) == null) {
            p(sw0Var);
        }
    }

    public final void p(@NonNull sw0 sw0Var) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, sw0Var) != null) || !w()) {
            return;
        }
        g01 g01Var = new g01();
        g01Var.h(sw0.a(sw0Var));
        g01Var.b(v());
        g01Var.c(s());
        g01Var.d(r());
        g01Var.e(u());
        g01Var.g(t());
        zt0 zt0Var = (zt0) i();
        if (zt0Var == null) {
            o1 = null;
        } else {
            o1 = zt0Var.o1();
        }
        if (o1 != null) {
            String extLog = o1.getExtLog();
            String str = this.d.get(extLog);
            String str2 = this.e.get(extLog);
            if (str == null) {
                JSONObject c = e31.c(extLog);
                String optString = c.optString("ad_extra_param");
                String optString2 = c.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                this.d.put(extLog, optString);
                this.e.put(extLog, optString2);
                str2 = optString2;
                str = optString;
            }
            g01Var.f(str);
            g01Var.a(str2);
        }
        nx0.a.a().a(g01Var);
        nx0.a.a().b(g01Var);
        sw0 sw0Var2 = g01Var.a;
        if (sw0Var2 != null) {
            sw0Var2.o();
        }
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (i() == null) {
                return "0";
            }
            if (i().K() != null && i().K().e > 0) {
                return String.valueOf(i().K().e);
            }
            return String.valueOf(i().r());
        }
        return (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (i() == null) {
                return "0";
            }
            if (i().K() != null) {
                i = i().K().d;
            } else {
                i = 0;
            }
            return String.valueOf(i);
        }
        return (String) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!(i() instanceof zt0)) {
                return false;
            }
            zt0 zt0Var = (zt0) i();
            if (zt0Var.o1() == null || TextUtils.isEmpty(zt0Var.o1().getExtLog())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}

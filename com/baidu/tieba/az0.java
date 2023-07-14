package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tieba.hy0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class az0 extends t11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> d;
    public final HashMap<String, String> e;

    public az0() {
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

    @Override // com.baidu.tieba.ny0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new int[]{2, 4, 6};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t11
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
            if (!(i() instanceof tu0) || ((tu0) i()).l1() != 0) {
                return "0";
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t11, com.baidu.tieba.ny0
    public void a(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mx0Var) == null) {
            p(mx0Var);
        }
    }

    @Override // com.baidu.tieba.t11, com.baidu.tieba.ny0
    public void d(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx0Var) == null) {
            p(mx0Var);
        }
    }

    @Override // com.baidu.tieba.t11, com.baidu.tieba.ny0
    public void q(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mx0Var) == null) {
            p(mx0Var);
        }
    }

    public final void p(@NonNull mx0 mx0Var) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, mx0Var) != null) || !w()) {
            return;
        }
        a11 a11Var = new a11();
        a11Var.h(mx0.a(mx0Var));
        a11Var.b(v());
        a11Var.c(s());
        a11Var.d(r());
        a11Var.e(u());
        a11Var.g(t());
        tu0 tu0Var = (tu0) i();
        if (tu0Var == null) {
            o1 = null;
        } else {
            o1 = tu0Var.o1();
        }
        if (o1 != null) {
            String extLog = o1.getExtLog();
            String str = this.d.get(extLog);
            String str2 = this.e.get(extLog);
            if (str == null) {
                JSONObject c = y31.c(extLog);
                String optString = c.optString("ad_extra_param");
                String optString2 = c.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                this.d.put(extLog, optString);
                this.e.put(extLog, optString2);
                str2 = optString2;
                str = optString;
            }
            a11Var.f(str);
            a11Var.a(str2);
        }
        hy0.a.a().a(a11Var);
        hy0.a.a().b(a11Var);
        mx0 mx0Var2 = a11Var.a;
        if (mx0Var2 != null) {
            mx0Var2.o();
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
            if (!(i() instanceof tu0)) {
                return false;
            }
            tu0 tu0Var = (tu0) i();
            if (tu0Var.o1() == null || TextUtils.isEmpty(tu0Var.o1().getExtLog())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tieba.ms0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ft0 extends uv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> d;
    public final HashMap<String, String> e;

    public ft0() {
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

    @Override // com.baidu.tieba.ss0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new int[]{2, 4, 6};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uv0
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
            return String.valueOf(i().D());
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
            return String.valueOf(i().E());
        }
        return (String) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!(i() instanceof zo0) || ((zo0) i()).g1() != 0) {
                return "0";
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.ss0
    public void a(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sr0Var) == null) {
            p(sr0Var);
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.ss0
    public void d(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sr0Var) == null) {
            p(sr0Var);
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.ss0
    public void q(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sr0Var) == null) {
            p(sr0Var);
        }
    }

    public final void p(@NonNull sr0 sr0Var) {
        BdVideoSeries j1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, sr0Var) != null) || !w()) {
            return;
        }
        bv0 bv0Var = new bv0();
        bv0Var.h(sr0.a(sr0Var));
        bv0Var.b(v());
        bv0Var.c(s());
        bv0Var.d(r());
        bv0Var.e(u());
        bv0Var.g(t());
        zo0 zo0Var = (zo0) i();
        if (zo0Var == null) {
            j1 = null;
        } else {
            j1 = zo0Var.j1();
        }
        if (j1 != null) {
            String extLog = j1.getExtLog();
            String str = this.d.get(extLog);
            String str2 = this.e.get(extLog);
            if (str == null) {
                JSONObject c = ux0.c(extLog);
                String optString = c.optString("ad_extra_param");
                String optString2 = c.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                this.d.put(extLog, optString);
                this.e.put(extLog, optString2);
                str2 = optString2;
                str = optString;
            }
            bv0Var.f(str);
            bv0Var.a(str2);
        }
        ms0.a.a().a(bv0Var);
        ms0.a.a().b(bv0Var);
        sr0 sr0Var2 = bv0Var.a;
        if (sr0Var2 != null) {
            sr0Var2.p();
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
            return String.valueOf(i().s());
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
            if (!(i() instanceof zo0)) {
                return false;
            }
            zo0 zo0Var = (zo0) i();
            if (zo0Var.j1() == null || TextUtils.isEmpty(zo0Var.j1().getExtLog())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gu0 {
    public static /* synthetic */ Interceptable $ic;
    public static String e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;
    public ArrayList b;
    public ArrayList c;
    public ArrayList d;

    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? "" : (String) invokeL.objValue;
    }

    public final int j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i != 1) {
                if (i != 6) {
                    if (i != 44) {
                        if (i != 22) {
                            return i != 23 ? -1 : 4;
                        }
                        return 1;
                    }
                    return 3;
                }
                return 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes4.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final gu0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-763925943, "Lcom/baidu/tieba/gu0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-763925943, "Lcom/baidu/tieba/gu0$b;");
                    return;
                }
            }
            a = new gu0(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public c(gu0 gu0Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu0Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }
    }

    public gu0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static gu0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (gu0) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String f = pz0.f();
            if (!TextUtils.isEmpty(f)) {
                this.d = q(f);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String g = pz0.g();
            if (!TextUtils.isEmpty(g)) {
                this.b = p(g);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String o = pz0.o();
            if (!TextUtils.isEmpty(o)) {
                this.c = q(o);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String p = pz0.p();
            if (!TextUtils.isEmpty(p)) {
                this.a = p(p);
            }
        }
    }

    public /* synthetic */ gu0(a aVar) {
        this();
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (k(4) && c() && a(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.b == null) {
                m();
            }
            ArrayList arrayList = this.b;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.a == null) {
                o();
            }
            ArrayList arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final ArrayList p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i, "");
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final ArrayList q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(new c(this, optJSONObject.optString("start_time", ""), optJSONObject.optString("end_time", "")));
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d == null) {
                l();
            }
            ArrayList arrayList = this.d;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (fz0.a(cVar.a, cVar.b)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c == null) {
                n();
            }
            ArrayList arrayList = this.c;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (fz0.a(cVar.a, cVar.b)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, str)) == null) {
            if (pz0.n()) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (i == 23) {
                if (!b(str)) {
                    return false;
                }
            } else if (!f(i, str)) {
                return false;
            }
            if (BdNetUtils.g() || !BdNetUtils.c()) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final boolean f(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, str)) == null) {
            if (k(j(i)) && g() && e(str)) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (TextUtils.isEmpty(e)) {
                e = i("video_pcdn_scene_control_android");
            }
            if (!TextUtils.isEmpty(e) && i < e.length() && i >= 0) {
                return "1".equals(String.valueOf(e.charAt(i)));
            }
            if (i >= 0 && i < 4) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }
}

package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ad.incentivevideo.net.GetAdFreeTimeModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/* loaded from: classes6.dex */
public class h66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h66 e;
    public transient /* synthetic */ FieldHolder $fh;
    public l66 a;
    public Stack<HashMap<AbsDataRecorder.Scene, AbsDataRecorder>> b;
    public Object c;
    public String d;

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends tn0<np0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h66 h66Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h66Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tn0
        public void onEvent(@NonNull np0 np0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, np0Var) == null) && "0".equals(np0Var.a)) {
                new GetAdFreeTimeModel().Z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-793299869, "Lcom/baidu/tieba/h66$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-793299869, "Lcom/baidu/tieba/h66$b;");
                    return;
                }
            }
            int[] iArr = new int[AbsDataRecorder.Scene.values().length];
            a = iArr;
            try {
                iArr[AbsDataRecorder.Scene.RECOMMEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbsDataRecorder.Scene.FRS_HOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbsDataRecorder.Scene.FRS_NEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h66() {
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
        if (this.b == null) {
            this.b = new Stack<>();
        }
    }

    public static h66 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (h66.class) {
                    if (e == null) {
                        e = new h66();
                    }
                }
            }
            return e;
        }
        return (h66) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap<AbsDataRecorder.Scene, AbsDataRecorder> hashMap = new HashMap<>();
            hashMap.put(AbsDataRecorder.Scene.FRS_HOT, null);
            hashMap.put(AbsDataRecorder.Scene.FRS_NEW, null);
            this.b.push(hashMap);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.b.isEmpty()) {
            this.b.pop();
        }
    }

    public final AbsDataRecorder j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                this.a = new l66();
            }
            return this.a;
        }
        return (AbsDataRecorder) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TbadkCoreApplication.isLogin() && TbadkCoreApplication.getCurrentMemberType() == 0 && g66.h().n()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.c != null) {
            return;
        }
        this.c = new Object();
        pn0.a().c(this.c, 1, new a(this, np0.class));
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            String e2 = e(i);
            String f = f(i);
            if (!StringUtils.isNull(e2)) {
                n95.m().H(e2);
            }
            if (!StringUtils.isNull(f)) {
                n95.m().H(f);
            }
        }
    }

    public AbsDataRecorder g(AbsDataRecorder.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, scene)) == null) {
            int i = b.a[scene.ordinal()];
            if (i != 1) {
                if (i != 2 && i != 3) {
                    return null;
                }
                return h(scene);
            }
            return j();
        }
        return (AbsDataRecorder) invokeL.objValue;
    }

    public boolean o(AbsDataRecorder.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, scene)) == null) {
            if (r() && g(scene) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.d = str;
        }
    }

    public final m66 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            m66 m66Var = new m66(i);
            m66Var.k(g66.h().g());
            m66Var.setTitle(g66.h().e());
            m66Var.i(g66.h().d());
            m66Var.h(g66.h().c());
            return m66Var;
        }
        return (m66) invokeI.objValue;
    }

    public final String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i == 1) {
                return n95.q("key_ad_incentive_video_watch_num_");
            }
            if (i == 2) {
                return n95.q("key_rec_ad_incentive_video_display_num_");
            }
            if (i == 3) {
                return n95.q("key_frs_ad_incentive_video_display_num_");
            }
            if (i == 4) {
                return n95.q("key_pb_ad_incentive_video_display_num_");
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i == 1) {
                return n95.q("key_ad_incentive_video_watch_time_");
            }
            if (i == 2) {
                return n95.q("key_rec_ad_incentive_video_display_time_");
            }
            if (i == 3) {
                return n95.q("key_frs_ad_incentive_video_display_time_");
            }
            if (i == 4) {
                return n95.q("key_pb_ad_incentive_video_display_time_");
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final int l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            String e2 = e(i);
            if (!TimeHelper.isSameDay(n95.m().o(f(i), 0L), System.currentTimeMillis())) {
                a(i);
                return 0;
            }
            return n95.m().n(e2, 0);
        }
        return invokeI.intValue;
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            String e2 = e(i);
            String f = f(i);
            if (!StringUtils.isNull(e2)) {
                n95.m().z(e2, n95.m().n(e2, 0) + 1);
            }
            if (!StringUtils.isNull(f)) {
                n95.m().A(f, System.currentTimeMillis());
            }
        }
    }

    public final AbsDataRecorder h(AbsDataRecorder.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, scene)) == null) {
            if (!this.b.isEmpty()) {
                HashMap<AbsDataRecorder.Scene, AbsDataRecorder> peek = this.b.peek();
                if (peek.get(scene) == null) {
                    if (scene == AbsDataRecorder.Scene.FRS_HOT) {
                        peek.put(scene, new j66());
                    } else if (scene == AbsDataRecorder.Scene.FRS_NEW) {
                        peek.put(scene, new k66());
                    }
                }
                return peek.get(scene);
            }
            return null;
        }
        return (AbsDataRecorder) invokeL.objValue;
    }

    public void n(List<vn> list, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048588, this, list, i, i2) != null) || list == null) {
            return;
        }
        if (i < 0) {
            list.add(d(i2));
        } else {
            yo8.b(list, d(i2), i);
        }
    }

    public boolean p(AbsDataRecorder.Scene scene) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, scene)) == null) {
            AbsDataRecorder g = g(scene);
            if (g == null) {
                return false;
            }
            int c = g.c();
            int k = g66.h().k(scene);
            int l = g66.h().l(scene);
            if (c == k || (c > k && (l <= 0 || (c - k) % l == 0))) {
                z = true;
            } else {
                z = false;
            }
            if (scene != AbsDataRecorder.Scene.RECOMMEND ? (scene == AbsDataRecorder.Scene.FRS_NEW || scene == AbsDataRecorder.Scene.FRS_HOT) && l(3) < g66.h().f() : l(2) < g66.h().j()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!o(scene) || !z || !z2 || l(1) >= g66.h().m()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (r() && l(4) < g66.h().i() && l(1) < g66.h().m()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            a(1);
            a(2);
            a(3);
            a(4);
            if (!TbadkCoreApplication.isLogin()) {
                g66.h().a();
            }
            this.a.a();
            this.b.clear();
        }
    }
}

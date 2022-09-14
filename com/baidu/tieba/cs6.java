package com.baidu.tieba;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.jf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class cs6 {
    public static /* synthetic */ Interceptable $ic;
    public static cs6 c;
    public transient /* synthetic */ FieldHolder $fh;
    public LruCache<String, String> a;
    public jf<String> b;

    /* loaded from: classes3.dex */
    public class a extends ep4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs6 a;

        public a(cs6 cs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs6Var;
        }

        @Override // com.baidu.tieba.ep4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity != null && activity.getClass().getName().equals("FrsActivity")) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : this.a.a.snapshot().entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append(",");
                }
                if (sb.length() <= 1) {
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
                this.a.b.a("transition_cache_key", sb.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jf.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs6 a;

        public b(cs6 cs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf.a
        /* renamed from: b */
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || str2 == null || str2.isEmpty()) {
                return;
            }
            for (String str3 : str2.split(",")) {
                String[] split = str3.split("=");
                if (split != null && split.length == 2) {
                    this.a.a.put(split[0], split[1]);
                }
            }
        }
    }

    public cs6() {
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
        this.a = new LruCache<>(10);
        zt4.f();
        this.b = zt4.g("tb.recently_vistited_forum_animation");
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new a(this));
        this.b.f("transition_cache_key", new b(this));
    }

    public static cs6 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (cs6.class) {
                    if (c == null) {
                        c = new cs6();
                    }
                }
            }
            return c;
        }
        return (cs6) invokeV.objValue;
    }

    public ds6 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return new ds6(null);
            }
            return new ds6(this.a.get(str));
        }
        return (ds6) invokeL.objValue;
    }

    public void e(String str, ds6 ds6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ds6Var) == null) {
            this.a.put(str, ds6Var.toString());
        }
    }
}

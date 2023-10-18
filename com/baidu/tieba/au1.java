package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.e93;
import com.baidu.tieba.tt1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class au1 extends tt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "Basic" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PreLoadSubPackageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p53 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ au1 d;

        /* loaded from: classes5.dex */
        public class a implements e93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CountDownLatch a;
            public final /* synthetic */ List b;
            public final /* synthetic */ String c;

            public a(c cVar, CountDownLatch countDownLatch, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, countDownLatch, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = countDownLatch;
                this.b = list;
                this.c = str;
            }

            @Override // com.baidu.tieba.e93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.countDown();
                    this.b.add(this.c);
                }
            }

            @Override // com.baidu.tieba.e93.e
            public void b(int i, ih3 ih3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                    this.a.countDown();
                    p22.o("PreLoadSubPackageApi", "downloadSubPackage fail, code=" + i);
                }
            }
        }

        public c(au1 au1Var, p53 p53Var, String str, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au1Var, p53Var, str, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = au1Var;
            this.a = p53Var;
            this.b = str;
            this.c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String l0 = this.a.l0();
                if (!TextUtils.isDigitsOnly(l0)) {
                    au1 au1Var = this.d;
                    String str = this.b;
                    au1Var.d(str, new qx1(202, "current version error:" + l0));
                    return;
                }
                List<pe4> k = md4.i().k(this.a.b, Integer.parseInt(l0));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i2 = 0; i2 < this.c.length(); i2++) {
                    String optString = this.c.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        if (au1.F(optString, k) && this.a.v0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String S = this.a.S(str2);
                        if (TextUtils.isEmpty(S)) {
                            countDownLatch.countDown();
                        } else {
                            p53 p53Var = this.a;
                            e93.l(p53Var.b, p53Var.l0(), "1", str2, S, null, new a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e) {
                        p22.d("PreLoadSubPackageApi", "loadSubPackages", e);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < this.c.length(); i3++) {
                    try {
                        String optString2 = this.c.optString(i3);
                        if (synchronizedList.contains(this.c.optString(i3))) {
                            i = 0;
                        } else {
                            i = 1001;
                        }
                        jSONObject.put(optString2, i);
                    } catch (Exception unused) {
                    }
                }
                this.d.d(this.b, new qx1(0, jSONObject));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements tt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au1 a;

        public a(au1 au1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au1Var;
        }

        @Override // com.baidu.tieba.tt1.a
        public qx1 a(p53 p53Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p53Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("root");
                if (TextUtils.isEmpty(optString)) {
                    p22.c("PreLoadSubPackageApi", "subPackage root is null");
                    return new qx1(202);
                }
                this.a.E(p53Var, optString, str);
                return new qx1(0);
            }
            return (qx1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au1 a;

        public b(au1 au1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au1Var;
        }

        @Override // com.baidu.tieba.tt1.a
        public qx1 a(p53 p53Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, p53Var, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    return new qx1(202);
                }
                this.a.C(p53Var, str, optJSONArray);
                return new qx1(0);
            }
            return (qx1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p53 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ au1 d;

        public d(au1 au1Var, p53 p53Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au1Var, p53Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = au1Var;
            this.a = p53Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.w0(this.b) && this.a.v0(this.b)) {
                    p22.i("PreLoadSubPackageApi", "subPackage have existed");
                    this.d.d(this.c, new qx1(1001, "subPackage have existed"));
                    return;
                }
                String S = this.a.S(this.b);
                if (TextUtils.isEmpty(S)) {
                    p22.i("PreLoadSubPackageApi", "subPackage cannot find aps key");
                    this.d.d(this.c, new qx1(202));
                    return;
                }
                this.d.D(this.a, this.b, S, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements e93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ au1 b;

        public e(au1 au1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = au1Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.e93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                p22.i("PreLoadSubPackageApi", "preload subPackage success");
                this.b.d(this.a, new qx1(0, "preload subPackage success"));
            }
        }

        @Override // com.baidu.tieba.e93.e
        public void b(int i, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                p22.c("PreLoadSubPackageApi", "preload subPackage failed");
                this.b.d(this.a, new qx1(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean F(@Nullable String str, @Nullable List<pe4> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (pe4 pe4Var : list) {
                    if (pe4Var != null && TextUtils.equals(pe4Var.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void D(p53 p53Var, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p53Var, str, str2, str3) == null) {
            e93.l(p53Var.b, p53Var.l0(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void C(p53 p53Var, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, p53Var, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, p53Var, str, jSONArray), "PreLoadSubPackageApi", 2);
        }
    }

    public final void E(p53 p53Var, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, p53Var, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, p53Var, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public qx1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#loadSubPackage", false);
            return m(str, true, new a(this));
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            r("#loadSubPackages", false);
            return m(str, true, new b(this));
        }
        return (qx1) invokeL.objValue;
    }
}

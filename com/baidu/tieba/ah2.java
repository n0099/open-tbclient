package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ah2 implements bh2, sg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gg2 a;
    public ip1 b;
    public volatile sg2[] c;
    public zg2 d;

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah2 a;

        public a(ah2 ah2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    public ah2(@NonNull zg2 zg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zg2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new gg2();
        this.b = br2.m();
        this.c = new sg2[]{new wg2(), new ug2(), new tg2(), new vg2()};
        this.d = zg2Var;
    }

    @Override // com.baidu.tieba.sg2
    public synchronized ArraySet<String> a() {
        InterceptResult invokeV;
        ArraySet<String> arraySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                t42.k("RecoveryPolicy", "renameAllPlatformFiles start");
                arraySet = new ArraySet<>();
                for (sg2 sg2Var : this.c) {
                    arraySet.addAll((ArraySet<? extends String>) sg2Var.a());
                }
                t42.k("RecoveryPolicy", "renameAllPlatformFiles end");
            }
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nk3.k(new a(this), "performRecovery");
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j43 e = j43.e();
            l43 l43Var = new l43(132);
            l43Var.d();
            e.h(l43Var);
        }
    }

    public void c(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arraySet) == null) && arraySet != null && !arraySet.isEmpty()) {
            t42.k("RecoveryPolicy", "deleteFiles start");
            Iterator<String> it = arraySet.iterator();
            while (it.hasNext()) {
                xn4.k(it.next());
            }
            t42.k("RecoveryPolicy", "deleteFiles end");
        }
    }

    public void f(Collection<String> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, collection) == null) && collection != null && !collection.isEmpty()) {
            t42.k("RecoveryPolicy", "resetAccredit appIds=" + collection);
            this.a.g(new ArrayList(collection));
        }
    }
}

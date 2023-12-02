package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class gtc implements koc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<koc> a;
    public volatile boolean b;

    public gtc() {
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

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.b) {
            synchronized (this) {
                if (!this.b && this.a != null) {
                    Set<koc> set = this.a;
                    this.a = null;
                    e(set);
                }
            }
        }
    }

    @Override // com.baidu.tieba.koc
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.b) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                this.b = true;
                Set<koc> set = this.a;
                this.a = null;
                e(set);
            }
        }
    }

    public static void e(Collection<koc> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, collection) != null) || collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (koc kocVar : collection) {
            try {
                kocVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        poc.d(arrayList);
    }

    public void a(koc kocVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) || kocVar.isUnsubscribed()) {
            return;
        }
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    if (this.a == null) {
                        this.a = new HashSet(4);
                    }
                    this.a.add(kocVar);
                    return;
                }
            }
        }
        kocVar.unsubscribe();
    }

    public void b(koc... kocVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kocVarArr) == null) {
            int i = 0;
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        if (this.a == null) {
                            this.a = new HashSet(kocVarArr.length);
                        }
                        int length = kocVarArr.length;
                        while (i < length) {
                            koc kocVar = kocVarArr[i];
                            if (!kocVar.isUnsubscribed()) {
                                this.a.add(kocVar);
                            }
                            i++;
                        }
                        return;
                    }
                }
            }
            int length2 = kocVarArr.length;
            while (i < length2) {
                kocVarArr[i].unsubscribe();
                i++;
            }
        }
    }

    public void d(koc kocVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, kocVar) == null) && !this.b) {
            synchronized (this) {
                if (!this.b && this.a != null) {
                    boolean remove = this.a.remove(kocVar);
                    if (remove) {
                        kocVar.unsubscribe();
                    }
                }
            }
        }
    }
}

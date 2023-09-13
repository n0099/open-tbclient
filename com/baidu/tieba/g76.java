package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class g76 {
    public static /* synthetic */ Interceptable $ic;
    public static g76 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;
    public List<nf5> b;

    /* loaded from: classes6.dex */
    public interface a {
        void x(List<nf5> list);
    }

    public g76() {
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
        this.a = new ArrayList();
    }

    public static synchronized g76 d() {
        InterceptResult invokeV;
        g76 g76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (g76.class) {
                if (c == null) {
                    c = new g76();
                }
                g76Var = c;
            }
            return g76Var;
        }
        return (g76) invokeV.objValue;
    }

    public List<nf5> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a aVar : this.a) {
                aVar.x(this.b);
            }
        }
    }

    public void a(nf5 nf5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nf5Var) == null) && this.b != null && nf5Var != null) {
            String a2 = nf5Var.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = "#";
                nf5Var.j("#");
            }
            String e = nf5Var.e();
            if (e == null) {
                e = "";
            }
            boolean z = false;
            boolean z2 = false;
            for (nf5 nf5Var2 : this.b) {
                if (e.equals(nf5Var2.e())) {
                    z = true;
                }
                if (a2.equals(nf5Var2.a())) {
                    z2 = true;
                }
            }
            if (z) {
                return;
            }
            if (!z2) {
                nf5 nf5Var3 = new nf5();
                nf5Var3.j(a2);
                this.b.add(nf5Var3);
            }
            this.b.add(nf5Var);
            Collections.sort(this.b, new ContactComparator());
            e();
        }
    }

    public void b(long j) {
        List<nf5> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || (list = this.b) == null) {
            return;
        }
        String str = null;
        Iterator<nf5> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            nf5 next = it.next();
            if (next.d() == j) {
                str = next.a();
                this.b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (nf5 nf5Var : this.b) {
                if (str.equals(nf5Var.a())) {
                    arrayList.add(nf5Var);
                }
            }
            if (arrayList.size() <= 1) {
                this.b.removeAll(arrayList);
            }
        }
        e();
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) && aVar != null && !this.a.contains(aVar)) {
            this.a.add(aVar);
        }
    }

    public void g(List<nf5> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) && aVar != null) {
            this.a.remove(aVar);
        }
    }
}

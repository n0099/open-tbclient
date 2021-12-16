package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import c.a.r0.t.f.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes11.dex */
public class ContactComparator implements Comparator<a>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAST_KEY = "#";
    public static final long serialVersionUID = 5856247139420779621L;
    public transient /* synthetic */ FieldHolder $fh;

    public ContactComparator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(a aVar, a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) {
            if (aVar == null) {
                return -1;
            }
            if (aVar2 == null) {
                return 1;
            }
            String a = aVar.a();
            String a2 = aVar2.a();
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2) && !a.equals(a2)) {
                if ("#".equals(a)) {
                    return 1;
                }
                if ("#".equals(a2)) {
                    return -1;
                }
                return a.compareToIgnoreCase(a2);
            }
            String f2 = aVar.f();
            String f3 = aVar2.f();
            if (TextUtils.isEmpty(f2)) {
                return -1;
            }
            if (TextUtils.isEmpty(f3)) {
                return 1;
            }
            String d2 = aVar.d();
            String d3 = aVar2.d();
            if (TextUtils.isEmpty(d2) || TextUtils.isEmpty(d3)) {
                return 0;
            }
            return d2.compareToIgnoreCase(d3);
        }
        return invokeLL.intValue;
    }
}

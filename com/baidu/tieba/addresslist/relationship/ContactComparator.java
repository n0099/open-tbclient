package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy4;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class ContactComparator implements Comparator<iy4>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAST_KEY = "#";
    public static final long serialVersionUID = 5856247139420779621L;
    public transient /* synthetic */ FieldHolder $fh;

    public ContactComparator() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(iy4 iy4Var, iy4 iy4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iy4Var, iy4Var2)) == null) {
            if (iy4Var == null) {
                return -1;
            }
            if (iy4Var2 == null) {
                return 1;
            }
            String a = iy4Var.a();
            String a2 = iy4Var2.a();
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2) && !a.equals(a2)) {
                if ("#".equals(a)) {
                    return 1;
                }
                if ("#".equals(a2)) {
                    return -1;
                }
                return a.compareToIgnoreCase(a2);
            }
            String f = iy4Var.f();
            String f2 = iy4Var2.f();
            if (TextUtils.isEmpty(f)) {
                return -1;
            }
            if (TextUtils.isEmpty(f2)) {
                return 1;
            }
            String d = iy4Var.d();
            String d2 = iy4Var2.d();
            if (TextUtils.isEmpty(d) || TextUtils.isEmpty(d2)) {
                return 0;
            }
            return d.compareToIgnoreCase(d2);
        }
        return invokeLL.intValue;
    }
}

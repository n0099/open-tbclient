package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.az4;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class ContactComparator implements Comparator<az4>, Serializable {
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
    public int compare(az4 az4Var, az4 az4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, az4Var, az4Var2)) == null) {
            if (az4Var == null) {
                return -1;
            }
            if (az4Var2 == null) {
                return 1;
            }
            String a = az4Var.a();
            String a2 = az4Var2.a();
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2) && !a.equals(a2)) {
                if ("#".equals(a)) {
                    return 1;
                }
                if ("#".equals(a2)) {
                    return -1;
                }
                return a.compareToIgnoreCase(a2);
            }
            String e = az4Var.e();
            String e2 = az4Var2.e();
            if (TextUtils.isEmpty(e)) {
                return -1;
            }
            if (TextUtils.isEmpty(e2)) {
                return 1;
            }
            String c = az4Var.c();
            String c2 = az4Var2.c();
            if (TextUtils.isEmpty(c) || TextUtils.isEmpty(c2)) {
                return 0;
            }
            return c.compareToIgnoreCase(c2);
        }
        return invokeLL.intValue;
    }
}

package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import com.baidu.tieba.b35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class ContactComparator implements Comparator, Serializable {
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
    public int compare(b35 b35Var, b35 b35Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, b35Var, b35Var2)) == null) {
            if (b35Var == null) {
                return -1;
            }
            if (b35Var2 == null) {
                return 1;
            }
            String a = b35Var.a();
            String a2 = b35Var2.a();
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2) && !a.equals(a2)) {
                if ("#".equals(a)) {
                    return 1;
                }
                if ("#".equals(a2)) {
                    return -1;
                }
                return a.compareToIgnoreCase(a2);
            }
            String e = b35Var.e();
            String e2 = b35Var2.e();
            if (TextUtils.isEmpty(e)) {
                return -1;
            }
            if (TextUtils.isEmpty(e2)) {
                return 1;
            }
            String c = b35Var.c();
            String c2 = b35Var2.c();
            if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(c2)) {
                return c.compareToIgnoreCase(c2);
            }
            return 0;
        }
        return invokeLL.intValue;
    }
}

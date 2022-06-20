package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ik5;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes3.dex */
public final class OrderedContactsComparator implements Comparator<ik5>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAST_KEY = "#";
    public static final long serialVersionUID = 1284474050586872045L;
    public transient /* synthetic */ FieldHolder $fh;

    public OrderedContactsComparator() {
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
    public int compare(ik5 ik5Var, ik5 ik5Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ik5Var, ik5Var2)) == null) {
            if (ik5Var == null) {
                return -1;
            }
            if (ik5Var2 == null) {
                return 1;
            }
            String b = ik5Var.b();
            String b2 = ik5Var2.b();
            if ("#".equals(b)) {
                return 1;
            }
            if ("#".equals(b2)) {
                return -1;
            }
            if (TextUtils.isEmpty(b) || TextUtils.isEmpty(b2)) {
                return 0;
            }
            return b.compareToIgnoreCase(b2);
        }
        return invokeLL.intValue;
    }
}

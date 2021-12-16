package com.baidu.tieba.addresslist.relationship;

import android.text.TextUtils;
import c.a.s0.x.f.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes11.dex */
public final class OrderedContactsComparator implements Comparator<e>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAST_KEY = "#";
    public static final long serialVersionUID = 1284474050586872045L;
    public transient /* synthetic */ FieldHolder $fh;

    public OrderedContactsComparator() {
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
    public int compare(e eVar, e eVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, eVar2)) == null) {
            if (eVar == null) {
                return -1;
            }
            if (eVar2 == null) {
                return 1;
            }
            String b2 = eVar.b();
            String b3 = eVar2.b();
            if ("#".equals(b2)) {
                return 1;
            }
            if ("#".equals(b3)) {
                return -1;
            }
            if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(b3)) {
                return 0;
            }
            return b2.compareToIgnoreCase(b3);
        }
        return invokeLL.intValue;
    }
}

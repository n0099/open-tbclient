package com.baidu.tieba.frs.tab;

import c.a.t0.d1.w2.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.LinkedList;
/* loaded from: classes12.dex */
public class TabData extends LinkedList<e> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_TAB_LOCATE_1 = 1;
    public static final int TYPE_TAB_LOCATE_2 = 2;
    public static final long serialVersionUID = -5491033066240609561L;
    public transient /* synthetic */ FieldHolder $fh;

    public TabData() {
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collection)) == null) {
            if (collection == null || collection.size() <= 0 || size() != collection.size()) {
                return false;
            }
            try {
                LinkedList linkedList = (LinkedList) collection;
                int size = size();
                for (int i2 = 0; i2 < size; i2++) {
                    e eVar = get(i2);
                    if (eVar == null || !eVar.equals(linkedList.get(i2))) {
                        return false;
                    }
                }
            } catch (Throwable unused) {
            }
            return super.containsAll(collection);
        }
        return invokeL.booleanValue;
    }
}

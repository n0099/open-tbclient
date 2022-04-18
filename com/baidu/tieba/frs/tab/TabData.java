package com.baidu.tieba.frs.tab;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.np6;
import java.util.Collection;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class TabData extends LinkedList<np6> {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                for (int i = 0; i < size; i++) {
                    np6 np6Var = get(i);
                    if (np6Var == null || !np6Var.equals(linkedList.get(i))) {
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

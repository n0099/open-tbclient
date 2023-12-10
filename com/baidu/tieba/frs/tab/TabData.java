package com.baidu.tieba.frs.tab;

import com.baidu.tieba.m58;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class TabData extends LinkedList<m58> {
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
                    m58 m58Var = get(i);
                    if (m58Var == null || !m58Var.equals(linkedList.get(i))) {
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

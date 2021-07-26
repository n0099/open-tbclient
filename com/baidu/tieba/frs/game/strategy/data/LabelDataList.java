package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.u0.r1.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumSubLabel;
/* loaded from: classes4.dex */
public class LabelDataList extends ArrayList<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LabelDataList() {
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

    public String getLabelName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Iterator<a> it = iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f64327a == i2) {
                    return next.f64328b;
                }
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public int getSelectedLabelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Iterator<a> it = iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f64329c) {
                    return next.f64327a;
                }
            }
            a aVar = (a) ListUtils.getItem(this, 0);
            if (aVar != null) {
                aVar.f64329c = true;
                return aVar.f64327a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void parseProtu(List<ForumSubLabel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            clear();
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (ForumSubLabel forumSubLabel : list) {
                if (forumSubLabel != null) {
                    a aVar = new a();
                    aVar.f64327a = forumSubLabel.id.intValue();
                    aVar.f64328b = forumSubLabel.sub_label_name;
                    add(aVar);
                }
            }
            if (isEmpty()) {
                return;
            }
            get(0).f64329c = true;
        }
    }

    public void setSelectedIndex(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (aVar = (a) ListUtils.getItem(this, i2)) == null) {
            return;
        }
        aVar.f64329c = true;
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next != aVar) {
                next.f64329c = false;
            }
        }
    }
}

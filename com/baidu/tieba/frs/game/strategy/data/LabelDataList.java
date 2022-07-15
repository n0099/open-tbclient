package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gj6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumSubLabel;
/* loaded from: classes3.dex */
public class LabelDataList extends ArrayList<gj6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LabelDataList() {
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

    public String getLabelName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Iterator<gj6> it = iterator();
            while (it.hasNext()) {
                gj6 next = it.next();
                if (next != null && next.a == i) {
                    return next.b;
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
            Iterator<gj6> it = iterator();
            while (it.hasNext()) {
                gj6 next = it.next();
                if (next != null && next.c) {
                    return next.a;
                }
            }
            gj6 gj6Var = (gj6) ListUtils.getItem(this, 0);
            if (gj6Var != null) {
                gj6Var.c = true;
                return gj6Var.a;
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
                    gj6 gj6Var = new gj6();
                    gj6Var.a = forumSubLabel.id.intValue();
                    gj6Var.b = forumSubLabel.sub_label_name;
                    add(gj6Var);
                }
            }
            if (isEmpty()) {
                return;
            }
            get(0).c = true;
        }
    }

    public void setSelectedIndex(int i) {
        gj6 gj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (gj6Var = (gj6) ListUtils.getItem(this, i)) == null) {
            return;
        }
        gj6Var.c = true;
        Iterator<gj6> it = iterator();
        while (it.hasNext()) {
            gj6 next = it.next();
            if (next != null && next != gj6Var) {
                next.c = false;
            }
        }
    }
}

package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ji6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumSubLabel;
/* loaded from: classes3.dex */
public class LabelDataList extends ArrayList<ji6> {
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
            Iterator<ji6> it = iterator();
            while (it.hasNext()) {
                ji6 next = it.next();
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
            Iterator<ji6> it = iterator();
            while (it.hasNext()) {
                ji6 next = it.next();
                if (next != null && next.c) {
                    return next.a;
                }
            }
            ji6 ji6Var = (ji6) ListUtils.getItem(this, 0);
            if (ji6Var != null) {
                ji6Var.c = true;
                return ji6Var.a;
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
                    ji6 ji6Var = new ji6();
                    ji6Var.a = forumSubLabel.id.intValue();
                    ji6Var.b = forumSubLabel.sub_label_name;
                    add(ji6Var);
                }
            }
            if (isEmpty()) {
                return;
            }
            get(0).c = true;
        }
    }

    public void setSelectedIndex(int i) {
        ji6 ji6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (ji6Var = (ji6) ListUtils.getItem(this, i)) == null) {
            return;
        }
        ji6Var.c = true;
        Iterator<ji6> it = iterator();
        while (it.hasNext()) {
            ji6 next = it.next();
            if (next != null && next != ji6Var) {
                next.c = false;
            }
        }
    }
}

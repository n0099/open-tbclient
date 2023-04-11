package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.wa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumSubLabel;
/* loaded from: classes4.dex */
public class LabelDataList extends ArrayList<wa7> {
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
            Iterator<wa7> it = iterator();
            while (it.hasNext()) {
                wa7 next = it.next();
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
            Iterator<wa7> it = iterator();
            while (it.hasNext()) {
                wa7 next = it.next();
                if (next != null && next.c) {
                    return next.a;
                }
            }
            wa7 wa7Var = (wa7) ListUtils.getItem(this, 0);
            if (wa7Var == null) {
                return 0;
            }
            wa7Var.c = true;
            return wa7Var.a;
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
                    wa7 wa7Var = new wa7();
                    wa7Var.a = forumSubLabel.id.intValue();
                    wa7Var.b = forumSubLabel.sub_label_name;
                    add(wa7Var);
                }
            }
            if (!isEmpty()) {
                get(0).c = true;
            }
        }
    }

    public void setSelectedIndex(int i) {
        wa7 wa7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (wa7Var = (wa7) ListUtils.getItem(this, i)) != null) {
            wa7Var.c = true;
            Iterator<wa7> it = iterator();
            while (it.hasNext()) {
                wa7 next = it.next();
                if (next != null && next != wa7Var) {
                    next.c = false;
                }
            }
        }
    }
}

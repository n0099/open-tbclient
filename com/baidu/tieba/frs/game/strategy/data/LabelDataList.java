package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.en6;
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
public class LabelDataList extends ArrayList {
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
            Iterator it = iterator();
            while (it.hasNext()) {
                en6 en6Var = (en6) it.next();
                if (en6Var != null && en6Var.a == i) {
                    return en6Var.b;
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
            Iterator it = iterator();
            while (it.hasNext()) {
                en6 en6Var = (en6) it.next();
                if (en6Var != null && en6Var.c) {
                    return en6Var.a;
                }
            }
            en6 en6Var2 = (en6) ListUtils.getItem(this, 0);
            if (en6Var2 == null) {
                return 0;
            }
            en6Var2.c = true;
            return en6Var2.a;
        }
        return invokeV.intValue;
    }

    public void parseProtu(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            clear();
            if (ListUtils.isEmpty(list)) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ForumSubLabel forumSubLabel = (ForumSubLabel) it.next();
                if (forumSubLabel != null) {
                    en6 en6Var = new en6();
                    en6Var.a = forumSubLabel.id.intValue();
                    en6Var.b = forumSubLabel.sub_label_name;
                    add(en6Var);
                }
            }
            if (!isEmpty()) {
                ((en6) get(0)).c = true;
            }
        }
    }

    public void setSelectedIndex(int i) {
        en6 en6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (en6Var = (en6) ListUtils.getItem(this, i)) != null) {
            en6Var.c = true;
            Iterator it = iterator();
            while (it.hasNext()) {
                en6 en6Var2 = (en6) it.next();
                if (en6Var2 != null && en6Var2 != en6Var) {
                    en6Var2.c = false;
                }
            }
        }
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class hn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                GameForumSubTab gameForumSubTab = (GameForumSubTab) it.next();
                on6 on6Var = new on6();
                if (gameForumSubTab != null) {
                    on6Var.a = gameForumSubTab.id.intValue();
                    on6Var.b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    on6Var.c = labelDataList;
                    arrayList.add(on6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List b(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                fn6 fn6Var = new fn6();
                ThreadData threadData = new ThreadData();
                fn6Var.c(threadData);
                threadData.parserProtobuf((ThreadInfo) list.get(i));
                threadData.parser_title();
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    qs4 qs4Var = new qs4();
                    qs4Var.h(threadData.getLegoCard());
                    linkedList.add(qs4Var);
                } else {
                    linkedList.add(fn6Var);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class ao7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<ho7> a(List<GameForumSubTab> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (GameForumSubTab gameForumSubTab : list) {
                ho7 ho7Var = new ho7();
                if (gameForumSubTab != null) {
                    ho7Var.a = gameForumSubTab.id.intValue();
                    ho7Var.b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    ho7Var.c = labelDataList;
                    arrayList.add(ho7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<yn> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                yn7 yn7Var = new yn7();
                ThreadData threadData = new ThreadData();
                yn7Var.c(threadData);
                threadData.parserProtobuf(list.get(i));
                threadData.parser_title();
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    l35 l35Var = new l35();
                    l35Var.e(threadData.getLegoCard());
                    linkedList.add(l35Var);
                } else {
                    linkedList.add(yn7Var);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }
}

package com.baidu.tieba.frs.game.strategy.message;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.data.b;
import com.baidu.tieba.frs.game.strategy.tab.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class a {
    public static List<e> cm(List<GameForumSubTab> list) {
        if (v.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (GameForumSubTab gameForumSubTab : list) {
            e eVar = new e();
            if (gameForumSubTab != null) {
                eVar.tabId = gameForumSubTab.id.intValue();
                eVar.tabName = gameForumSubTab.sub_tab_name;
                LabelDataList labelDataList = new LabelDataList();
                labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                eVar.extra = labelDataList;
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    public static List<m> cn(List<ThreadInfo> list) {
        if (v.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return linkedList;
            }
            b bVar = new b();
            bj bjVar = new bj();
            bVar.setThreadData(bjVar);
            bjVar.a(list.get(i2));
            bjVar.aAT();
            if (!TextUtils.isEmpty(bjVar.aBf())) {
                ae aeVar = new ae();
                aeVar.sg(bjVar.aBf());
                linkedList.add(aeVar);
            } else {
                linkedList.add(bVar);
            }
            i = i2 + 1;
        }
    }
}

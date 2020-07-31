package com.baidu.tieba.frs.game.strategy.message;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.data.b;
import com.baidu.tieba.frs.game.strategy.tab.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes16.dex */
public class a {
    public static List<e> cH(List<GameForumSubTab> list) {
        if (x.isEmpty(list)) {
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

    public static List<q> cI(List<ThreadInfo> list) {
        if (x.isEmpty(list)) {
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
            bv bvVar = new bv();
            bVar.setThreadData(bvVar);
            bvVar.a(list.get(i2));
            bvVar.aXj();
            if (!TextUtils.isEmpty(bvVar.aXv())) {
                aj ajVar = new aj();
                ajVar.wN(bvVar.aXv());
                linkedList.add(ajVar);
            } else {
                linkedList.add(bVar);
            }
            i = i2 + 1;
        }
    }
}

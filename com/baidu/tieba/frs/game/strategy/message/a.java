package com.baidu.tieba.frs.game.strategy.message;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.data.b;
import com.baidu.tieba.frs.game.strategy.tab.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {
    public static List<e> cq(List<GameForumSubTab> list) {
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

    public static List<m> cr(List<ThreadInfo> list) {
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
            bh bhVar = new bh();
            bVar.ai(bhVar);
            bhVar.a(list.get(i2));
            bhVar.setCurrentPage(3);
            bhVar.ajw();
            if (!TextUtils.isEmpty(bhVar.ajI())) {
                ad adVar = new ad();
                adVar.mP(bhVar.ajI());
                linkedList.add(adVar);
            } else {
                linkedList.add(bVar);
            }
            i = i2 + 1;
        }
    }
}

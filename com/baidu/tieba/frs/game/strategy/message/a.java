package com.baidu.tieba.frs.game.strategy.message;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.data.b;
import com.baidu.tieba.frs.game.strategy.tab.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class a {
    public static List<e> bj(List<GameForumSubTab> list) {
        if (v.w(list)) {
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

    public static List<h> bk(List<ThreadInfo> list) {
        if (v.w(list)) {
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
            bd bdVar = new bd();
            bVar.T(bdVar);
            bdVar.a(list.get(i2));
            bdVar.bU(3);
            bdVar.sx();
            if (!TextUtils.isEmpty(bdVar.sH())) {
                ac acVar = new ac();
                acVar.cI(bdVar.sH());
                linkedList.add(acVar);
            } else {
                linkedList.add(bVar);
            }
            i = i2 + 1;
        }
    }
}

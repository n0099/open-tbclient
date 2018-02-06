package com.baidu.tieba.frs.game.strategy.message;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.data.b;
import com.baidu.tieba.frs.game.strategy.tab.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class a {
    public static List<f> bp(List<GameForumSubTab> list) {
        if (v.E(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (GameForumSubTab gameForumSubTab : list) {
            f fVar = new f();
            if (gameForumSubTab != null) {
                fVar.tabId = gameForumSubTab.id.intValue();
                fVar.tabName = gameForumSubTab.sub_tab_name;
                LabelDataList labelDataList = new LabelDataList();
                labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                fVar.extra = labelDataList;
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    public static List<i> bq(List<ThreadInfo> list) {
        if (v.E(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
        for (int i = 0; i < list.size(); i++) {
            b bVar = new b();
            bd bdVar = new bd();
            bVar.T(bdVar);
            bdVar.a(list.get(i));
            bdVar.eW(3);
            bdVar.zW();
            if (bdVar.getThreadType() == 33 && !bdVar.zO()) {
                ar arVar = new ar();
                arVar.a(bdVar, 0);
                if (appResponseToIntentClass) {
                    linkedList.add(arVar);
                }
            } else if (!TextUtils.isEmpty(bdVar.Af())) {
                ab abVar = new ab();
                abVar.cU(bdVar.Af());
                linkedList.add(abVar);
            } else {
                linkedList.add(bVar);
            }
        }
        br(linkedList);
        return linkedList;
    }

    public static void br(List<i> list) {
        if (!v.E(list)) {
            for (int size = list.size() - 1; size >= 0; size--) {
                i iVar = list.get(size);
                if (iVar instanceof ar) {
                    az azVar = new az();
                    azVar.b((ar) iVar, -1);
                    list.remove(size);
                    list.add(size, azVar);
                }
            }
        }
    }
}

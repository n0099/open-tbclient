package com.baidu.tieba.homepage.hotTopic.tab;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes2.dex */
public class a {
    public static void a(View view, Object obj, int i, String str) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            com.baidu.tieba.homepage.hotTopic.tab.b.c cVar = (com.baidu.tieba.homepage.hotTopic.tab.b.c) obj;
            if (cVar.kdH) {
                aq aqVar = new aq("c13736");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.bwo();
                return;
            }
            aq aqVar2 = new aq("c13735");
            aqVar2.an("obj_locate", i);
            aqVar2.w("topic_id", cVar.topicId);
            aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bwo();
        } else if (obj instanceof e) {
            bz bzVar = ((e) obj).eMv;
            aq aqVar3 = new aq("c13738");
            aqVar3.dX("obj_type", str);
            aqVar3.dX("uid", TbadkCoreApplication.getCurrentAccount());
            if (bzVar != null) {
                aqVar3.dX("tid", bzVar.getTid());
                aqVar3.w("fid", bzVar.getFid());
            }
            aqVar3.bwo();
        } else if ((obj instanceof com.baidu.tbadk.core.data.a) && dh(view)) {
            bz boP = ((com.baidu.tbadk.core.data.a) obj).boP();
            aq aqVar4 = new aq("c13738");
            aqVar4.dX("obj_type", str);
            aqVar4.dX("uid", TbadkCoreApplication.getCurrentAccount());
            if (boP != null) {
                aqVar4.dX("tid", boP.getTid());
                aqVar4.w("fid", boP.getFid());
            }
            aqVar4.bwo();
        }
    }

    private static boolean dh(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            bz bzVar = ((e) obj).eMv;
            aq aqVar = new aq("c13825");
            aqVar.dX("obj_type", str);
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            if (bzVar != null) {
                aqVar.dX("tid", bzVar.getTid());
            }
            aqVar.bwo();
        } else if (obj instanceof com.baidu.tbadk.core.data.a) {
            bz boP = ((com.baidu.tbadk.core.data.a) obj).boP();
            aq aqVar2 = new aq("c13825");
            aqVar2.dX("obj_type", str);
            aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
            if (boP != null) {
                aqVar2.dX("tid", boP.getTid());
            }
            aqVar2.bwo();
        }
    }
}

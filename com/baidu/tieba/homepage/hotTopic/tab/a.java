package com.baidu.tieba.homepage.hotTopic.tab;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes21.dex */
public class a {
    public static void a(View view, Object obj, int i, String str) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            com.baidu.tieba.homepage.hotTopic.tab.b.c cVar = (com.baidu.tieba.homepage.hotTopic.tab.b.c) obj;
            if (cVar.iUA) {
                aq aqVar = new aq("c13736");
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.bki();
                return;
            }
            aq aqVar2 = new aq("c13735");
            aqVar2.ai("obj_locate", i);
            aqVar2.u("topic_id", cVar.topicId);
            aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bki();
        } else if (obj instanceof e) {
            bw bwVar = ((e) obj).dXg;
            aq aqVar3 = new aq("c13738");
            aqVar3.dF("obj_type", str);
            aqVar3.dF("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar3.dF("tid", bwVar.getTid());
                aqVar3.u("fid", bwVar.getFid());
            }
            aqVar3.bki();
        } else if ((obj instanceof AbsThreadDataSupport) && cz(view)) {
            bw bcY = ((AbsThreadDataSupport) obj).bcY();
            aq aqVar4 = new aq("c13738");
            aqVar4.dF("obj_type", str);
            aqVar4.dF("uid", TbadkCoreApplication.getCurrentAccount());
            if (bcY != null) {
                aqVar4.dF("tid", bcY.getTid());
                aqVar4.u("fid", bcY.getFid());
            }
            aqVar4.bki();
        }
    }

    private static boolean cz(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            bw bwVar = ((e) obj).dXg;
            aq aqVar = new aq("c13825");
            aqVar.dF("obj_type", str);
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar.dF("tid", bwVar.getTid());
            }
            aqVar.bki();
        } else if (obj instanceof AbsThreadDataSupport) {
            bw bcY = ((AbsThreadDataSupport) obj).bcY();
            aq aqVar2 = new aq("c13825");
            aqVar2.dF("obj_type", str);
            aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
            if (bcY != null) {
                aqVar2.dF("tid", bcY.getTid());
            }
            aqVar2.bki();
        }
    }
}

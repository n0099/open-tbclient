package com.baidu.tieba.homepage.hotTopic.tab;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes22.dex */
public class a {
    public static void a(View view, Object obj, int i, String str) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            com.baidu.tieba.homepage.hotTopic.tab.b.c cVar = (com.baidu.tieba.homepage.hotTopic.tab.b.c) obj;
            if (cVar.jBS) {
                aq aqVar = new aq("c13736");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.brk();
                return;
            }
            aq aqVar2 = new aq("c13735");
            aqVar2.al("obj_locate", i);
            aqVar2.w("topic_id", cVar.topicId);
            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.brk();
        } else if (obj instanceof e) {
            bw bwVar = ((e) obj).exA;
            aq aqVar3 = new aq("c13738");
            aqVar3.dR("obj_type", str);
            aqVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar3.dR("tid", bwVar.getTid());
                aqVar3.w("fid", bwVar.getFid());
            }
            aqVar3.brk();
        } else if ((obj instanceof AbsThreadDataSupport) && cM(view)) {
            bw bjZ = ((AbsThreadDataSupport) obj).bjZ();
            aq aqVar4 = new aq("c13738");
            aqVar4.dR("obj_type", str);
            aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bjZ != null) {
                aqVar4.dR("tid", bjZ.getTid());
                aqVar4.w("fid", bjZ.getFid());
            }
            aqVar4.brk();
        }
    }

    private static boolean cM(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            bw bwVar = ((e) obj).exA;
            aq aqVar = new aq("c13825");
            aqVar.dR("obj_type", str);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar.dR("tid", bwVar.getTid());
            }
            aqVar.brk();
        } else if (obj instanceof AbsThreadDataSupport) {
            bw bjZ = ((AbsThreadDataSupport) obj).bjZ();
            aq aqVar2 = new aq("c13825");
            aqVar2.dR("obj_type", str);
            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bjZ != null) {
                aqVar2.dR("tid", bjZ.getTid());
            }
            aqVar2.brk();
        }
    }
}

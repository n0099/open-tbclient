package com.baidu.tieba.homepage.hotTopic.tab;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes21.dex */
public class a {
    public static void a(View view, Object obj, int i, String str) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            com.baidu.tieba.homepage.hotTopic.tab.b.c cVar = (com.baidu.tieba.homepage.hotTopic.tab.b.c) obj;
            if (cVar.jCP) {
                ar arVar = new ar("c13736");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.bqy();
                return;
            }
            ar arVar2 = new ar("c13735");
            arVar2.ak("obj_locate", i);
            arVar2.w("topic_id", cVar.topicId);
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.bqy();
        } else if (obj instanceof e) {
            bx bxVar = ((e) obj).evQ;
            ar arVar3 = new ar("c13738");
            arVar3.dR("obj_type", str);
            arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bxVar != null) {
                arVar3.dR("tid", bxVar.getTid());
                arVar3.w("fid", bxVar.getFid());
            }
            arVar3.bqy();
        } else if ((obj instanceof com.baidu.tbadk.core.data.a) && cQ(view)) {
            bx bjd = ((com.baidu.tbadk.core.data.a) obj).bjd();
            ar arVar4 = new ar("c13738");
            arVar4.dR("obj_type", str);
            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bjd != null) {
                arVar4.dR("tid", bjd.getTid());
                arVar4.w("fid", bjd.getFid());
            }
            arVar4.bqy();
        }
    }

    private static boolean cQ(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            bx bxVar = ((e) obj).evQ;
            ar arVar = new ar("c13825");
            arVar.dR("obj_type", str);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bxVar != null) {
                arVar.dR("tid", bxVar.getTid());
            }
            arVar.bqy();
        } else if (obj instanceof com.baidu.tbadk.core.data.a) {
            bx bjd = ((com.baidu.tbadk.core.data.a) obj).bjd();
            ar arVar2 = new ar("c13825");
            arVar2.dR("obj_type", str);
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bjd != null) {
                arVar2.dR("tid", bjd.getTid());
            }
            arVar2.bqy();
        }
    }
}

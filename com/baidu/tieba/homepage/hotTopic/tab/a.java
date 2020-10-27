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
            if (cVar.jvV) {
                aq aqVar = new aq("c13736");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.boK();
                return;
            }
            aq aqVar2 = new aq("c13735");
            aqVar2.aj("obj_locate", i);
            aqVar2.w("topic_id", cVar.topicId);
            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.boK();
        } else if (obj instanceof e) {
            bw bwVar = ((e) obj).erH;
            aq aqVar3 = new aq("c13738");
            aqVar3.dR("obj_type", str);
            aqVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar3.dR("tid", bwVar.getTid());
                aqVar3.w("fid", bwVar.getFid());
            }
            aqVar3.boK();
        } else if ((obj instanceof AbsThreadDataSupport) && cH(view)) {
            bw bhz = ((AbsThreadDataSupport) obj).bhz();
            aq aqVar4 = new aq("c13738");
            aqVar4.dR("obj_type", str);
            aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bhz != null) {
                aqVar4.dR("tid", bhz.getTid());
                aqVar4.w("fid", bhz.getFid());
            }
            aqVar4.boK();
        }
    }

    private static boolean cH(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            bw bwVar = ((e) obj).erH;
            aq aqVar = new aq("c13825");
            aqVar.dR("obj_type", str);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar.dR("tid", bwVar.getTid());
            }
            aqVar.boK();
        } else if (obj instanceof AbsThreadDataSupport) {
            bw bhz = ((AbsThreadDataSupport) obj).bhz();
            aq aqVar2 = new aq("c13825");
            aqVar2.dR("obj_type", str);
            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (bhz != null) {
                aqVar2.dR("tid", bhz.getTid());
            }
            aqVar2.boK();
        }
    }
}

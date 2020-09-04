package com.baidu.tieba.homepage.hotTopic.tab;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes16.dex */
public class a {
    public static void a(View view, Object obj, int i, String str) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            com.baidu.tieba.homepage.hotTopic.tab.b.c cVar = (com.baidu.tieba.homepage.hotTopic.tab.b.c) obj;
            if (cVar.iLU) {
                aq aqVar = new aq("c13736");
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.bjn();
                return;
            }
            aq aqVar2 = new aq("c13735");
            aqVar2.ai("obj_locate", i);
            aqVar2.u("topic_id", cVar.topicId);
            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bjn();
        } else if (obj instanceof e) {
            bw bwVar = ((e) obj).dUW;
            aq aqVar3 = new aq("c13738");
            aqVar3.dD("obj_type", str);
            aqVar3.dD("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar3.dD("tid", bwVar.getTid());
                aqVar3.u("fid", bwVar.getFid());
            }
            aqVar3.bjn();
        } else if ((obj instanceof AbsThreadDataSupport) && cq(view)) {
            bw bce = ((AbsThreadDataSupport) obj).bce();
            aq aqVar4 = new aq("c13738");
            aqVar4.dD("obj_type", str);
            aqVar4.dD("uid", TbadkCoreApplication.getCurrentAccount());
            if (bce != null) {
                aqVar4.dD("tid", bce.getTid());
                aqVar4.u("fid", bce.getFid());
            }
            aqVar4.bjn();
        }
    }

    private static boolean cq(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            bw bwVar = ((e) obj).dUW;
            aq aqVar = new aq("c13825");
            aqVar.dD("obj_type", str);
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar.dD("tid", bwVar.getTid());
            }
            aqVar.bjn();
        } else if (obj instanceof AbsThreadDataSupport) {
            bw bce = ((AbsThreadDataSupport) obj).bce();
            aq aqVar2 = new aq("c13825");
            aqVar2.dD("obj_type", str);
            aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
            if (bce != null) {
                aqVar2.dD("tid", bce.getTid());
            }
            aqVar2.bjn();
        }
    }
}

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
            if (cVar.jjy) {
                aq aqVar = new aq("c13736");
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.bmR();
                return;
            }
            aq aqVar2 = new aq("c13735");
            aqVar2.aj("obj_locate", i);
            aqVar2.u("topic_id", cVar.topicId);
            aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bmR();
        } else if (obj instanceof e) {
            bw bwVar = ((e) obj).eji;
            aq aqVar3 = new aq("c13738");
            aqVar3.dK("obj_type", str);
            aqVar3.dK("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar3.dK("tid", bwVar.getTid());
                aqVar3.u("fid", bwVar.getFid());
            }
            aqVar3.bmR();
        } else if ((obj instanceof AbsThreadDataSupport) && cD(view)) {
            bw bfG = ((AbsThreadDataSupport) obj).bfG();
            aq aqVar4 = new aq("c13738");
            aqVar4.dK("obj_type", str);
            aqVar4.dK("uid", TbadkCoreApplication.getCurrentAccount());
            if (bfG != null) {
                aqVar4.dK("tid", bfG.getTid());
                aqVar4.u("fid", bfG.getFid());
            }
            aqVar4.bmR();
        }
    }

    private static boolean cD(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            bw bwVar = ((e) obj).eji;
            aq aqVar = new aq("c13825");
            aqVar.dK("obj_type", str);
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            if (bwVar != null) {
                aqVar.dK("tid", bwVar.getTid());
            }
            aqVar.bmR();
        } else if (obj instanceof AbsThreadDataSupport) {
            bw bfG = ((AbsThreadDataSupport) obj).bfG();
            aq aqVar2 = new aq("c13825");
            aqVar2.dK("obj_type", str);
            aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
            if (bfG != null) {
                aqVar2.dK("tid", bfG.getTid());
            }
            aqVar2.bmR();
        }
    }
}

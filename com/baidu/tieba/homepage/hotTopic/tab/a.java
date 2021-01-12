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
            if (cVar.jZc) {
                aq aqVar = new aq("c13736");
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.bsu();
                return;
            }
            aq aqVar2 = new aq("c13735");
            aqVar2.an("obj_locate", i);
            aqVar2.w("topic_id", cVar.topicId);
            aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.bsu();
        } else if (obj instanceof e) {
            bz bzVar = ((e) obj).eHK;
            aq aqVar3 = new aq("c13738");
            aqVar3.dW("obj_type", str);
            aqVar3.dW("uid", TbadkCoreApplication.getCurrentAccount());
            if (bzVar != null) {
                aqVar3.dW("tid", bzVar.getTid());
                aqVar3.w("fid", bzVar.getFid());
            }
            aqVar3.bsu();
        } else if ((obj instanceof com.baidu.tbadk.core.data.a) && dh(view)) {
            bz bkV = ((com.baidu.tbadk.core.data.a) obj).bkV();
            aq aqVar4 = new aq("c13738");
            aqVar4.dW("obj_type", str);
            aqVar4.dW("uid", TbadkCoreApplication.getCurrentAccount());
            if (bkV != null) {
                aqVar4.dW("tid", bkV.getTid());
                aqVar4.w("fid", bkV.getFid());
            }
            aqVar4.bsu();
        }
    }

    private static boolean dh(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            bz bzVar = ((e) obj).eHK;
            aq aqVar = new aq("c13825");
            aqVar.dW("obj_type", str);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            if (bzVar != null) {
                aqVar.dW("tid", bzVar.getTid());
            }
            aqVar.bsu();
        } else if (obj instanceof com.baidu.tbadk.core.data.a) {
            bz bkV = ((com.baidu.tbadk.core.data.a) obj).bkV();
            aq aqVar2 = new aq("c13825");
            aqVar2.dW("obj_type", str);
            aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
            if (bkV != null) {
                aqVar2.dW("tid", bkV.getTid());
            }
            aqVar2.bsu();
        }
    }
}

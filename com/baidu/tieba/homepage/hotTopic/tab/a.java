package com.baidu.tieba.homepage.hotTopic.tab;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes2.dex */
public class a {
    public static void a(View view, Object obj, int i, String str) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            com.baidu.tieba.homepage.hotTopic.tab.b.c cVar = (com.baidu.tieba.homepage.hotTopic.tab.b.c) obj;
            if (cVar.kiW) {
                ar arVar = new ar("c13736");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.bsR();
                return;
            }
            ar arVar2 = new ar("c13735");
            arVar2.aq("obj_locate", i);
            arVar2.v("topic_id", cVar.topicId);
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.bsR();
        } else if (obj instanceof e) {
            cb cbVar = ((e) obj).eLr;
            ar arVar3 = new ar("c13738");
            arVar3.dR("obj_type", str);
            arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (cbVar != null) {
                arVar3.dR("tid", cbVar.getTid());
                arVar3.v("fid", cbVar.getFid());
            }
            arVar3.bsR();
        } else if ((obj instanceof com.baidu.tbadk.core.data.a) && df(view)) {
            cb blp = ((com.baidu.tbadk.core.data.a) obj).blp();
            ar arVar4 = new ar("c13738");
            arVar4.dR("obj_type", str);
            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (blp != null) {
                arVar4.dR("tid", blp.getTid());
                arVar4.v("fid", blp.getFid());
            }
            arVar4.bsR();
        }
    }

    private static boolean df(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            cb cbVar = ((e) obj).eLr;
            ar arVar = new ar("c13825");
            arVar.dR("obj_type", str);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (cbVar != null) {
                arVar.dR("tid", cbVar.getTid());
            }
            arVar.bsR();
        } else if (obj instanceof com.baidu.tbadk.core.data.a) {
            cb blp = ((com.baidu.tbadk.core.data.a) obj).blp();
            ar arVar2 = new ar("c13825");
            arVar2.dR("obj_type", str);
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (blp != null) {
                arVar2.dR("tid", blp.getTid());
            }
            arVar2.bsR();
        }
    }
}

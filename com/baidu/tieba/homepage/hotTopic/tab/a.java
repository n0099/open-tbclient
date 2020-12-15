package com.baidu.tieba.homepage.hotTopic.tab;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes22.dex */
public class a {
    public static void a(View view, Object obj, int i, String str) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            com.baidu.tieba.homepage.hotTopic.tab.b.c cVar = (com.baidu.tieba.homepage.hotTopic.tab.b.c) obj;
            if (cVar.jQt) {
                ar arVar = new ar("c13736");
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.btT();
                return;
            }
            ar arVar2 = new ar("c13735");
            arVar2.al("obj_locate", i);
            arVar2.w("topic_id", cVar.topicId);
            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.btT();
        } else if (obj instanceof e) {
            by byVar = ((e) obj).eCR;
            ar arVar3 = new ar("c13738");
            arVar3.dY("obj_type", str);
            arVar3.dY("uid", TbadkCoreApplication.getCurrentAccount());
            if (byVar != null) {
                arVar3.dY("tid", byVar.getTid());
                arVar3.w("fid", byVar.getFid());
            }
            arVar3.btT();
        } else if ((obj instanceof com.baidu.tbadk.core.data.a) && cX(view)) {
            by bmn = ((com.baidu.tbadk.core.data.a) obj).bmn();
            ar arVar4 = new ar("c13738");
            arVar4.dY("obj_type", str);
            arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
            if (bmn != null) {
                arVar4.dY("tid", bmn.getTid());
                arVar4.w("fid", bmn.getFid());
            }
            arVar4.btT();
        }
    }

    private static boolean cX(View view) {
        int id = view.getId();
        return id == R.id.thread_card_root || id == R.id.thread_info_commont_container;
    }

    public static void a(View view, Object obj, String str) {
        if (obj instanceof e) {
            by byVar = ((e) obj).eCR;
            ar arVar = new ar("c13825");
            arVar.dY("obj_type", str);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            if (byVar != null) {
                arVar.dY("tid", byVar.getTid());
            }
            arVar.btT();
        } else if (obj instanceof com.baidu.tbadk.core.data.a) {
            by bmn = ((com.baidu.tbadk.core.data.a) obj).bmn();
            ar arVar2 = new ar("c13825");
            arVar2.dY("obj_type", str);
            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
            if (bmn != null) {
                arVar2.dY("tid", bmn.getTid());
            }
            arVar2.btT();
        }
    }
}

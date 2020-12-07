package com.baidu.tieba.homepage.tabfeed;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
/* loaded from: classes22.dex */
public class b {
    public static void MA(String str) {
        ar arVar = new ar(str);
        arVar.al("obj_type", 1);
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        t.csg().e(arVar);
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ar arVar = new ar(str);
            arVar.al("obj_type", 1);
            arVar.al("obj_locate", i);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.w("tid", specialColumnItemData.threadId);
            arVar.w("obj_id", specialColumnItemData.liveId);
            t.csg().e(arVar);
        } else if (obj instanceof MetaData) {
            ar arVar2 = new ar(str);
            arVar2.al("obj_type", 1);
            arVar2.al("obj_locate", i);
            arVar2.w("uid", ((MetaData) obj).getUserIdLong());
            t.csg().e(arVar2);
        } else if (obj instanceof bk) {
            ar arVar3 = new ar(str);
            arVar3.al("obj_type", 1);
            arVar3.al("obj_locate", i);
            arVar3.w("fid", ((bk) obj).getForumId());
            t.csg().e(arVar3);
        } else if (obj instanceof k) {
            ar arVar4 = new ar(str);
            arVar4.al("obj_type", 1);
            arVar4.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar4.al("obj_locate", i);
            arVar4.dY("obj_param1", ((k) obj).bmM());
            t.csg().e(arVar4);
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            ar arVar = new ar(str);
            arVar.al("obj_type", 2);
            arVar.al("obj_locate", i);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.w("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.c) obj).topicId);
            arVar.btT();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ar arVar2 = new ar(str);
            arVar2.al("obj_type", 2);
            arVar2.al("obj_locate", i);
            arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.w("tid", specialColumnItemData.threadId);
            arVar2.w("obj_id", specialColumnItemData.liveId);
            arVar2.btT();
        } else if (obj instanceof MetaData) {
            ar arVar3 = new ar(str);
            arVar3.al("obj_type", 2);
            arVar3.al("obj_locate", i);
            arVar3.w("uid", ((MetaData) obj).getUserIdLong());
            arVar3.btT();
        } else if (obj instanceof bk) {
            ar arVar4 = new ar(str);
            arVar4.al("obj_type", 2);
            arVar4.al("obj_locate", i);
            arVar4.w("fid", ((bk) obj).getForumId());
            arVar4.btT();
        } else if (obj instanceof k) {
            ar arVar5 = new ar(str);
            arVar5.al("obj_type", 2);
            arVar5.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar5.al("obj_locate", i);
            arVar5.dY("obj_param1", ((k) obj).bmM());
            arVar5.btT();
        } else if (obj instanceof Boolean) {
            ar arVar6 = new ar(str);
            arVar6.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar6.al("obj_locate", i);
            arVar6.btT();
        }
    }

    public static void a(View view, com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bmn() != null) {
            by bmn = aVar.bmn();
            if (bmn.bnv()) {
                TiebaStatic.log(l.f(bmn, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bmn, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bmn, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bmn, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bmn, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bmn, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bmn, str));
            }
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bmn() != null) {
            if (aVar.bmn().bnv()) {
                t.csg().e(l.b(aVar.bmn(), str));
            } else {
                t.csg().e(l.a(aVar.bmn(), str));
            }
        }
    }
}

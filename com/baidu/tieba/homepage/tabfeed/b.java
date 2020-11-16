package com.baidu.tieba.homepage.tabfeed;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
/* loaded from: classes21.dex */
public class b {
    public static void Lt(String str) {
        ar arVar = new ar(str);
        arVar.ak("obj_type", 1);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        t.cnT().e(arVar);
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ar arVar = new ar(str);
            arVar.ak("obj_type", 1);
            arVar.ak("obj_locate", i);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.w("tid", specialColumnItemData.threadId);
            arVar.w("obj_id", specialColumnItemData.liveId);
            t.cnT().e(arVar);
        } else if (obj instanceof MetaData) {
            ar arVar2 = new ar(str);
            arVar2.ak("obj_type", 1);
            arVar2.ak("obj_locate", i);
            arVar2.w("uid", ((MetaData) obj).getUserIdLong());
            t.cnT().e(arVar2);
        } else if (obj instanceof bj) {
            ar arVar3 = new ar(str);
            arVar3.ak("obj_type", 1);
            arVar3.ak("obj_locate", i);
            arVar3.w("fid", ((bj) obj).getForumId());
            t.cnT().e(arVar3);
        } else if (obj instanceof k) {
            ar arVar4 = new ar(str);
            arVar4.ak("obj_type", 1);
            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar4.ak("obj_locate", i);
            arVar4.dR("obj_param1", ((k) obj).bjz());
            t.cnT().e(arVar4);
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            ar arVar = new ar(str);
            arVar.ak("obj_type", 2);
            arVar.ak("obj_locate", i);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.w("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.c) obj).topicId);
            arVar.bqy();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ar arVar2 = new ar(str);
            arVar2.ak("obj_type", 2);
            arVar2.ak("obj_locate", i);
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.w("tid", specialColumnItemData.threadId);
            arVar2.w("obj_id", specialColumnItemData.liveId);
            arVar2.bqy();
        } else if (obj instanceof MetaData) {
            ar arVar3 = new ar(str);
            arVar3.ak("obj_type", 2);
            arVar3.ak("obj_locate", i);
            arVar3.w("uid", ((MetaData) obj).getUserIdLong());
            arVar3.bqy();
        } else if (obj instanceof bj) {
            ar arVar4 = new ar(str);
            arVar4.ak("obj_type", 2);
            arVar4.ak("obj_locate", i);
            arVar4.w("fid", ((bj) obj).getForumId());
            arVar4.bqy();
        } else if (obj instanceof k) {
            ar arVar5 = new ar(str);
            arVar5.ak("obj_type", 2);
            arVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar5.ak("obj_locate", i);
            arVar5.dR("obj_param1", ((k) obj).bjz());
            arVar5.bqy();
        } else if (obj instanceof Boolean) {
            ar arVar6 = new ar(str);
            arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar6.ak("obj_locate", i);
            arVar6.bqy();
        }
    }

    public static void a(View view, com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bjd() != null) {
            bx bjd = aVar.bjd();
            if (bjd.bki()) {
                TiebaStatic.log(l.f(bjd, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bjd, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bjd, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bjd, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bjd, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bjd, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bjd, str));
            }
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bjd() != null) {
            if (aVar.bjd().bki()) {
                t.cnT().e(l.b(aVar.bjd(), str));
            } else {
                t.cnT().e(l.a(aVar.bjd(), str));
            }
        }
    }
}

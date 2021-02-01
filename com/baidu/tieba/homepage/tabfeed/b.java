package com.baidu.tieba.homepage.tabfeed;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
/* loaded from: classes2.dex */
public class b {
    public static void Mg(String str) {
        ar arVar = new ar(str);
        arVar.ap("obj_type", 1);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        t.csu().e(arVar);
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ar arVar = new ar(str);
            arVar.ap("obj_type", 1);
            arVar.ap("obj_locate", i);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.v("tid", specialColumnItemData.threadId);
            arVar.v("obj_id", specialColumnItemData.liveId);
            t.csu().e(arVar);
        } else if (obj instanceof MetaData) {
            ar arVar2 = new ar(str);
            arVar2.ap("obj_type", 1);
            arVar2.ap("obj_locate", i);
            arVar2.v("uid", ((MetaData) obj).getUserIdLong());
            t.csu().e(arVar2);
        } else if (obj instanceof bn) {
            ar arVar3 = new ar(str);
            arVar3.ap("obj_type", 1);
            arVar3.ap("obj_locate", i);
            arVar3.v("fid", ((bn) obj).getForumId());
            t.csu().e(arVar3);
        } else if (obj instanceof l) {
            ar arVar4 = new ar(str);
            arVar4.ap("obj_type", 1);
            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar4.ap("obj_locate", i);
            arVar4.dR("obj_param1", ((l) obj).blK());
            t.csu().e(arVar4);
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            ar arVar = new ar(str);
            arVar.ap("obj_type", 2);
            arVar.ap("obj_locate", i);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.v("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.c) obj).topicId);
            arVar.bsO();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ar arVar2 = new ar(str);
            arVar2.ap("obj_type", 2);
            arVar2.ap("obj_locate", i);
            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar2.v("tid", specialColumnItemData.threadId);
            arVar2.v("obj_id", specialColumnItemData.liveId);
            arVar2.bsO();
        } else if (obj instanceof MetaData) {
            ar arVar3 = new ar(str);
            arVar3.ap("obj_type", 2);
            arVar3.ap("obj_locate", i);
            arVar3.v("uid", ((MetaData) obj).getUserIdLong());
            arVar3.bsO();
        } else if (obj instanceof bn) {
            ar arVar4 = new ar(str);
            arVar4.ap("obj_type", 2);
            arVar4.ap("obj_locate", i);
            arVar4.v("fid", ((bn) obj).getForumId());
            arVar4.bsO();
        } else if (obj instanceof l) {
            ar arVar5 = new ar(str);
            arVar5.ap("obj_type", 2);
            arVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar5.ap("obj_locate", i);
            arVar5.dR("obj_param1", ((l) obj).blK());
            arVar5.bsO();
        } else if (obj instanceof Boolean) {
            ar arVar6 = new ar(str);
            arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar6.ap("obj_locate", i);
            arVar6.bsO();
        }
    }

    public static void a(View view, com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bln() != null) {
            cb bln = aVar.bln();
            if (bln.bmv()) {
                TiebaStatic.log(m.f(bln, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(m.d(bln, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(m.c(bln, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(m.c(bln, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(m.g(bln, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(m.d(bln, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(m.e(bln, str));
            }
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bln() != null) {
            if (aVar.bln().bmv()) {
                t.csu().e(m.b(aVar.bln(), str));
            } else {
                t.csu().e(m.a(aVar.bln(), str));
            }
        }
    }
}

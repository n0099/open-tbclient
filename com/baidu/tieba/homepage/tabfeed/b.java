package com.baidu.tieba.homepage.tabfeed;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
/* loaded from: classes22.dex */
public class b {
    public static void LS(String str) {
        aq aqVar = new aq(str);
        aqVar.al("obj_type", 1);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        t.cor().e(aqVar);
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar = new aq(str);
            aqVar.al("obj_type", 1);
            aqVar.al("obj_locate", i);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("tid", specialColumnItemData.threadId);
            aqVar.w("obj_id", specialColumnItemData.liveId);
            t.cor().e(aqVar);
        } else if (obj instanceof MetaData) {
            aq aqVar2 = new aq(str);
            aqVar2.al("obj_type", 1);
            aqVar2.al("obj_locate", i);
            aqVar2.w("uid", ((MetaData) obj).getUserIdLong());
            t.cor().e(aqVar2);
        } else if (obj instanceof bi) {
            aq aqVar3 = new aq(str);
            aqVar3.al("obj_type", 1);
            aqVar3.al("obj_locate", i);
            aqVar3.w("fid", ((bi) obj).getForumId());
            t.cor().e(aqVar3);
        } else if (obj instanceof j) {
            aq aqVar4 = new aq(str);
            aqVar4.al("obj_type", 1);
            aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar4.al("obj_locate", i);
            aqVar4.dR("obj_param1", ((j) obj).bkx());
            t.cor().e(aqVar4);
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            aq aqVar = new aq(str);
            aqVar.al("obj_type", 2);
            aqVar.al("obj_locate", i);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.c) obj).topicId);
            aqVar.brk();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar2 = new aq(str);
            aqVar2.al("obj_type", 2);
            aqVar2.al("obj_locate", i);
            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.w("tid", specialColumnItemData.threadId);
            aqVar2.w("obj_id", specialColumnItemData.liveId);
            aqVar2.brk();
        } else if (obj instanceof MetaData) {
            aq aqVar3 = new aq(str);
            aqVar3.al("obj_type", 2);
            aqVar3.al("obj_locate", i);
            aqVar3.w("uid", ((MetaData) obj).getUserIdLong());
            aqVar3.brk();
        } else if (obj instanceof bi) {
            aq aqVar4 = new aq(str);
            aqVar4.al("obj_type", 2);
            aqVar4.al("obj_locate", i);
            aqVar4.w("fid", ((bi) obj).getForumId());
            aqVar4.brk();
        } else if (obj instanceof j) {
            aq aqVar5 = new aq(str);
            aqVar5.al("obj_type", 2);
            aqVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar5.al("obj_locate", i);
            aqVar5.dR("obj_param1", ((j) obj).bkx());
            aqVar5.brk();
        } else if (obj instanceof Boolean) {
            aq aqVar6 = new aq(str);
            aqVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar6.al("obj_locate", i);
            aqVar6.brk();
        }
    }

    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null) {
            bw bjZ = absThreadDataSupport.bjZ();
            if (bjZ.blg()) {
                TiebaStatic.log(l.f(bjZ, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bjZ, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bjZ, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bjZ, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bjZ, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bjZ, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bjZ, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null) {
            if (absThreadDataSupport.bjZ().blg()) {
                t.cor().e(l.b(absThreadDataSupport.bjZ(), str));
            } else {
                t.cor().e(l.a(absThreadDataSupport.bjZ(), str));
            }
        }
    }
}

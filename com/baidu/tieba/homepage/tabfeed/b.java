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
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
/* loaded from: classes21.dex */
public class b {
    public static void Ko(String str) {
        aq aqVar = new aq(str);
        aqVar.ai("obj_type", 1);
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        s.cfn().e(aqVar);
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar = new aq(str);
            aqVar.ai("obj_type", 1);
            aqVar.ai("obj_locate", i);
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.u("tid", specialColumnItemData.threadId);
            aqVar.u("obj_id", specialColumnItemData.liveId);
            s.cfn().e(aqVar);
        } else if (obj instanceof MetaData) {
            aq aqVar2 = new aq(str);
            aqVar2.ai("obj_type", 1);
            aqVar2.ai("obj_locate", i);
            aqVar2.u("uid", ((MetaData) obj).getUserIdLong());
            s.cfn().e(aqVar2);
        } else if (obj instanceof bi) {
            aq aqVar3 = new aq(str);
            aqVar3.ai("obj_type", 1);
            aqVar3.ai("obj_locate", i);
            aqVar3.u("fid", ((bi) obj).getForumId());
            s.cfn().e(aqVar3);
        } else if (obj instanceof j) {
            aq aqVar4 = new aq(str);
            aqVar4.ai("obj_type", 1);
            aqVar4.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar4.ai("obj_locate", i);
            aqVar4.dF("obj_param1", ((j) obj).bdv());
            s.cfn().e(aqVar4);
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            aq aqVar = new aq(str);
            aqVar.ai("obj_type", 2);
            aqVar.ai("obj_locate", i);
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.u("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.c) obj).topicId);
            aqVar.bki();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar2 = new aq(str);
            aqVar2.ai("obj_type", 2);
            aqVar2.ai("obj_locate", i);
            aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.u("tid", specialColumnItemData.threadId);
            aqVar2.u("obj_id", specialColumnItemData.liveId);
            aqVar2.bki();
        } else if (obj instanceof MetaData) {
            aq aqVar3 = new aq(str);
            aqVar3.ai("obj_type", 2);
            aqVar3.ai("obj_locate", i);
            aqVar3.u("uid", ((MetaData) obj).getUserIdLong());
            aqVar3.bki();
        } else if (obj instanceof bi) {
            aq aqVar4 = new aq(str);
            aqVar4.ai("obj_type", 2);
            aqVar4.ai("obj_locate", i);
            aqVar4.u("fid", ((bi) obj).getForumId());
            aqVar4.bki();
        } else if (obj instanceof j) {
            aq aqVar5 = new aq(str);
            aqVar5.ai("obj_type", 2);
            aqVar5.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar5.ai("obj_locate", i);
            aqVar5.dF("obj_param1", ((j) obj).bdv());
            aqVar5.bki();
        } else if (obj instanceof Boolean) {
            aq aqVar6 = new aq(str);
            aqVar6.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar6.ai("obj_locate", i);
            aqVar6.bki();
        }
    }

    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            bw bcY = absThreadDataSupport.bcY();
            if (bcY.bee()) {
                TiebaStatic.log(l.f(bcY, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bcY, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bcY, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bcY, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bcY, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bcY, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bcY, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            if (absThreadDataSupport.bcY().bee()) {
                s.cfn().e(l.b(absThreadDataSupport.bcY(), str));
            } else {
                s.cfn().e(l.a(absThreadDataSupport.bcY(), str));
            }
        }
    }
}

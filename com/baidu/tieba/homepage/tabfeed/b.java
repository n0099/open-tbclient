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
/* loaded from: classes22.dex */
public class b {
    public static void Ld(String str) {
        aq aqVar = new aq(str);
        aqVar.aj("obj_type", 1);
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        s.ciJ().e(aqVar);
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar = new aq(str);
            aqVar.aj("obj_type", 1);
            aqVar.aj("obj_locate", i);
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.u("tid", specialColumnItemData.threadId);
            aqVar.u("obj_id", specialColumnItemData.liveId);
            s.ciJ().e(aqVar);
        } else if (obj instanceof MetaData) {
            aq aqVar2 = new aq(str);
            aqVar2.aj("obj_type", 1);
            aqVar2.aj("obj_locate", i);
            aqVar2.u("uid", ((MetaData) obj).getUserIdLong());
            s.ciJ().e(aqVar2);
        } else if (obj instanceof bi) {
            aq aqVar3 = new aq(str);
            aqVar3.aj("obj_type", 1);
            aqVar3.aj("obj_locate", i);
            aqVar3.u("fid", ((bi) obj).getForumId());
            s.ciJ().e(aqVar3);
        } else if (obj instanceof j) {
            aq aqVar4 = new aq(str);
            aqVar4.aj("obj_type", 1);
            aqVar4.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar4.aj("obj_locate", i);
            aqVar4.dK("obj_param1", ((j) obj).bge());
            s.ciJ().e(aqVar4);
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            aq aqVar = new aq(str);
            aqVar.aj("obj_type", 2);
            aqVar.aj("obj_locate", i);
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.u("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.c) obj).topicId);
            aqVar.bmR();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar2 = new aq(str);
            aqVar2.aj("obj_type", 2);
            aqVar2.aj("obj_locate", i);
            aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.u("tid", specialColumnItemData.threadId);
            aqVar2.u("obj_id", specialColumnItemData.liveId);
            aqVar2.bmR();
        } else if (obj instanceof MetaData) {
            aq aqVar3 = new aq(str);
            aqVar3.aj("obj_type", 2);
            aqVar3.aj("obj_locate", i);
            aqVar3.u("uid", ((MetaData) obj).getUserIdLong());
            aqVar3.bmR();
        } else if (obj instanceof bi) {
            aq aqVar4 = new aq(str);
            aqVar4.aj("obj_type", 2);
            aqVar4.aj("obj_locate", i);
            aqVar4.u("fid", ((bi) obj).getForumId());
            aqVar4.bmR();
        } else if (obj instanceof j) {
            aq aqVar5 = new aq(str);
            aqVar5.aj("obj_type", 2);
            aqVar5.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar5.aj("obj_locate", i);
            aqVar5.dK("obj_param1", ((j) obj).bge());
            aqVar5.bmR();
        } else if (obj instanceof Boolean) {
            aq aqVar6 = new aq(str);
            aqVar6.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar6.aj("obj_locate", i);
            aqVar6.bmR();
        }
    }

    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            bw bfG = absThreadDataSupport.bfG();
            if (bfG.bgN()) {
                TiebaStatic.log(l.f(bfG, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bfG, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bfG, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bfG, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bfG, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bfG, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bfG, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            if (absThreadDataSupport.bfG().bgN()) {
                s.ciJ().e(l.b(absThreadDataSupport.bfG(), str));
            } else {
                s.ciJ().e(l.a(absThreadDataSupport.bfG(), str));
            }
        }
    }
}

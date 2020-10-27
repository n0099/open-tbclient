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
    public static void LB(String str) {
        aq aqVar = new aq(str);
        aqVar.aj("obj_type", 1);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        t.clQ().e(aqVar);
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar = new aq(str);
            aqVar.aj("obj_type", 1);
            aqVar.aj("obj_locate", i);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("tid", specialColumnItemData.threadId);
            aqVar.w("obj_id", specialColumnItemData.liveId);
            t.clQ().e(aqVar);
        } else if (obj instanceof MetaData) {
            aq aqVar2 = new aq(str);
            aqVar2.aj("obj_type", 1);
            aqVar2.aj("obj_locate", i);
            aqVar2.w("uid", ((MetaData) obj).getUserIdLong());
            t.clQ().e(aqVar2);
        } else if (obj instanceof bi) {
            aq aqVar3 = new aq(str);
            aqVar3.aj("obj_type", 1);
            aqVar3.aj("obj_locate", i);
            aqVar3.w("fid", ((bi) obj).getForumId());
            t.clQ().e(aqVar3);
        } else if (obj instanceof j) {
            aq aqVar4 = new aq(str);
            aqVar4.aj("obj_type", 1);
            aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar4.aj("obj_locate", i);
            aqVar4.dR("obj_param1", ((j) obj).bhX());
            t.clQ().e(aqVar4);
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            aq aqVar = new aq(str);
            aqVar.aj("obj_type", 2);
            aqVar.aj("obj_locate", i);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.c) obj).topicId);
            aqVar.boK();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar2 = new aq(str);
            aqVar2.aj("obj_type", 2);
            aqVar2.aj("obj_locate", i);
            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.w("tid", specialColumnItemData.threadId);
            aqVar2.w("obj_id", specialColumnItemData.liveId);
            aqVar2.boK();
        } else if (obj instanceof MetaData) {
            aq aqVar3 = new aq(str);
            aqVar3.aj("obj_type", 2);
            aqVar3.aj("obj_locate", i);
            aqVar3.w("uid", ((MetaData) obj).getUserIdLong());
            aqVar3.boK();
        } else if (obj instanceof bi) {
            aq aqVar4 = new aq(str);
            aqVar4.aj("obj_type", 2);
            aqVar4.aj("obj_locate", i);
            aqVar4.w("fid", ((bi) obj).getForumId());
            aqVar4.boK();
        } else if (obj instanceof j) {
            aq aqVar5 = new aq(str);
            aqVar5.aj("obj_type", 2);
            aqVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar5.aj("obj_locate", i);
            aqVar5.dR("obj_param1", ((j) obj).bhX());
            aqVar5.boK();
        } else if (obj instanceof Boolean) {
            aq aqVar6 = new aq(str);
            aqVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar6.aj("obj_locate", i);
            aqVar6.boK();
        }
    }

    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null) {
            bw bhz = absThreadDataSupport.bhz();
            if (bhz.biG()) {
                TiebaStatic.log(l.f(bhz, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bhz, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bhz, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bhz, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bhz, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bhz, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bhz, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null) {
            if (absThreadDataSupport.bhz().biG()) {
                t.clQ().e(l.b(absThreadDataSupport.bhz(), str));
            } else {
                t.clQ().e(l.a(absThreadDataSupport.bhz(), str));
            }
        }
    }
}

package com.baidu.tieba.homepage.tabfeed;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
/* loaded from: classes2.dex */
public class b {
    public static void Lr(String str) {
        aq aqVar = new aq(str);
        aqVar.an("obj_type", 1);
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        s.crj().e(aqVar);
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar = new aq(str);
            aqVar.an("obj_type", 1);
            aqVar.an("obj_locate", i);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("tid", specialColumnItemData.threadId);
            aqVar.w("obj_id", specialColumnItemData.liveId);
            s.crj().e(aqVar);
        } else if (obj instanceof MetaData) {
            aq aqVar2 = new aq(str);
            aqVar2.an("obj_type", 1);
            aqVar2.an("obj_locate", i);
            aqVar2.w("uid", ((MetaData) obj).getUserIdLong());
            s.crj().e(aqVar2);
        } else if (obj instanceof bl) {
            aq aqVar3 = new aq(str);
            aqVar3.an("obj_type", 1);
            aqVar3.an("obj_locate", i);
            aqVar3.w("fid", ((bl) obj).getForumId());
            s.crj().e(aqVar3);
        } else if (obj instanceof k) {
            aq aqVar4 = new aq(str);
            aqVar4.an("obj_type", 1);
            aqVar4.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar4.an("obj_locate", i);
            aqVar4.dW("obj_param1", ((k) obj).bls());
            s.crj().e(aqVar4);
        }
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.c) {
            aq aqVar = new aq(str);
            aqVar.an("obj_type", 2);
            aqVar.an("obj_locate", i);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.w("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.c) obj).topicId);
            aqVar.bsu();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            aq aqVar2 = new aq(str);
            aqVar2.an("obj_type", 2);
            aqVar2.an("obj_locate", i);
            aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar2.w("tid", specialColumnItemData.threadId);
            aqVar2.w("obj_id", specialColumnItemData.liveId);
            aqVar2.bsu();
        } else if (obj instanceof MetaData) {
            aq aqVar3 = new aq(str);
            aqVar3.an("obj_type", 2);
            aqVar3.an("obj_locate", i);
            aqVar3.w("uid", ((MetaData) obj).getUserIdLong());
            aqVar3.bsu();
        } else if (obj instanceof bl) {
            aq aqVar4 = new aq(str);
            aqVar4.an("obj_type", 2);
            aqVar4.an("obj_locate", i);
            aqVar4.w("fid", ((bl) obj).getForumId());
            aqVar4.bsu();
        } else if (obj instanceof k) {
            aq aqVar5 = new aq(str);
            aqVar5.an("obj_type", 2);
            aqVar5.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar5.an("obj_locate", i);
            aqVar5.dW("obj_param1", ((k) obj).bls());
            aqVar5.bsu();
        } else if (obj instanceof Boolean) {
            aq aqVar6 = new aq(str);
            aqVar6.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar6.an("obj_locate", i);
            aqVar6.bsu();
        }
    }

    public static void a(View view, com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bkV() != null) {
            bz bkV = aVar.bkV();
            if (bkV.bmc()) {
                TiebaStatic.log(l.f(bkV, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bkV, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bkV, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bkV, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bkV, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bkV, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bkV, str));
            }
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bkV() != null) {
            if (aVar.bkV().bmc()) {
                s.crj().e(l.b(aVar.bkV(), str));
            } else {
                s.crj().e(l.a(aVar.bkV(), str));
            }
        }
    }
}

package com.baidu.tieba.homepage.tabfeed;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
/* loaded from: classes9.dex */
public class b {
    public static void Gh(String str) {
        ao aoVar = new ao(str);
        aoVar.ag("obj_type", 1);
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        s.bOB().e(aoVar);
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ao aoVar = new ao(str);
            aoVar.ag("obj_type", 1);
            aoVar.ag("obj_locate", i);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.s("tid", specialColumnItemData.threadId);
            aoVar.s("obj_id", specialColumnItemData.liveId);
            s.bOB().e(aoVar);
        } else if (obj instanceof MetaData) {
            ao aoVar2 = new ao(str);
            aoVar2.ag("obj_type", 1);
            aoVar2.ag("obj_locate", i);
            aoVar2.s("uid", ((MetaData) obj).getUserIdLong());
            s.bOB().e(aoVar2);
        } else if (obj instanceof bg) {
            ao aoVar3 = new ao(str);
            aoVar3.ag("obj_type", 1);
            aoVar3.ag("obj_locate", i);
            aoVar3.s("fid", ((bg) obj).getForumId());
            s.bOB().e(aoVar3);
        } else if (obj instanceof j) {
            ao aoVar4 = new ao(str);
            aoVar4.ag("obj_type", 1);
            aoVar4.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar4.ag("obj_locate", i);
            aoVar4.dk("obj_param1", ((j) obj).aQm());
            s.bOB().e(aoVar4);
        }
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.b) {
            ao aoVar = new ao(str);
            aoVar.ag("obj_type", 2);
            aoVar.ag("obj_locate", i);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.s("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.b) obj).topicId);
            aoVar.aWN();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ao aoVar2 = new ao(str);
            aoVar2.ag("obj_type", 2);
            aoVar2.ag("obj_locate", i);
            aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar2.s("tid", specialColumnItemData.threadId);
            aoVar2.s("obj_id", specialColumnItemData.liveId);
            aoVar2.aWN();
        } else if (obj instanceof MetaData) {
            ao aoVar3 = new ao(str);
            aoVar3.ag("obj_type", 2);
            aoVar3.ag("obj_locate", i);
            aoVar3.s("uid", ((MetaData) obj).getUserIdLong());
            aoVar3.aWN();
        } else if (obj instanceof bg) {
            ao aoVar4 = new ao(str);
            aoVar4.ag("obj_type", 2);
            aoVar4.ag("obj_locate", i);
            aoVar4.s("fid", ((bg) obj).getForumId());
            aoVar4.aWN();
        } else if (obj instanceof j) {
            ao aoVar5 = new ao(str);
            aoVar5.ag("obj_type", 2);
            aoVar5.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar5.ag("obj_locate", i);
            aoVar5.dk("obj_param1", ((j) obj).aQm());
            aoVar5.aWN();
        } else if (obj instanceof Boolean) {
            ao aoVar6 = new ao(str);
            aoVar6.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar6.ag("obj_locate", i);
            aoVar6.aWN();
        }
    }

    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            bu aPS = absThreadDataSupport.aPS();
            if (aPS.aQV()) {
                TiebaStatic.log(l.f(aPS, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(aPS, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(aPS, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(aPS, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(aPS, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(aPS, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(aPS, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            if (absThreadDataSupport.aPS().aQV()) {
                s.bOB().e(l.b(absThreadDataSupport.aPS(), str));
            } else {
                s.bOB().e(l.a(absThreadDataSupport.aPS(), str));
            }
        }
    }
}

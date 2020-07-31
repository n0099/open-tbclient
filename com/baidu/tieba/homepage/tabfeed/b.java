package com.baidu.tieba.homepage.tabfeed;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData;
/* loaded from: classes16.dex */
public class b {
    public static void GT(String str) {
        ap apVar = new ap(str);
        apVar.ah("obj_type", 1);
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        s.bRL().e(apVar);
    }

    public static void c(String str, Object obj, int i) {
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ap apVar = new ap(str);
            apVar.ah("obj_type", 1);
            apVar.ah("obj_locate", i);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.t("tid", specialColumnItemData.threadId);
            apVar.t("obj_id", specialColumnItemData.liveId);
            s.bRL().e(apVar);
        } else if (obj instanceof MetaData) {
            ap apVar2 = new ap(str);
            apVar2.ah("obj_type", 1);
            apVar2.ah("obj_locate", i);
            apVar2.t("uid", ((MetaData) obj).getUserIdLong());
            s.bRL().e(apVar2);
        } else if (obj instanceof bh) {
            ap apVar3 = new ap(str);
            apVar3.ah("obj_type", 1);
            apVar3.ah("obj_locate", i);
            apVar3.t("fid", ((bh) obj).getForumId());
            s.bRL().e(apVar3);
        } else if (obj instanceof j) {
            ap apVar4 = new ap(str);
            apVar4.ah("obj_type", 1);
            apVar4.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar4.ah("obj_locate", i);
            apVar4.dn("obj_param1", ((j) obj).aUi());
            s.bRL().e(apVar4);
        }
    }

    public static void b(String str, Object obj, int i) {
        if (obj instanceof com.baidu.tieba.homepage.hotTopic.tab.b.b) {
            ap apVar = new ap(str);
            apVar.ah("obj_type", 2);
            apVar.ah("obj_locate", i);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.t("topic_id", ((com.baidu.tieba.homepage.hotTopic.tab.b.b) obj).topicId);
            apVar.baO();
        }
        if (obj instanceof SpecialColumnItemData) {
            SpecialColumnItemData specialColumnItemData = (SpecialColumnItemData) obj;
            ap apVar2 = new ap(str);
            apVar2.ah("obj_type", 2);
            apVar2.ah("obj_locate", i);
            apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar2.t("tid", specialColumnItemData.threadId);
            apVar2.t("obj_id", specialColumnItemData.liveId);
            apVar2.baO();
        } else if (obj instanceof MetaData) {
            ap apVar3 = new ap(str);
            apVar3.ah("obj_type", 2);
            apVar3.ah("obj_locate", i);
            apVar3.t("uid", ((MetaData) obj).getUserIdLong());
            apVar3.baO();
        } else if (obj instanceof bh) {
            ap apVar4 = new ap(str);
            apVar4.ah("obj_type", 2);
            apVar4.ah("obj_locate", i);
            apVar4.t("fid", ((bh) obj).getForumId());
            apVar4.baO();
        } else if (obj instanceof j) {
            ap apVar5 = new ap(str);
            apVar5.ah("obj_type", 2);
            apVar5.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar5.ah("obj_locate", i);
            apVar5.dn("obj_param1", ((j) obj).aUi());
            apVar5.baO();
        } else if (obj instanceof Boolean) {
            ap apVar6 = new ap(str);
            apVar6.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar6.ah("obj_locate", i);
            apVar6.baO();
        }
    }

    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            bv aTN = absThreadDataSupport.aTN();
            if (aTN.aUR()) {
                TiebaStatic.log(l.f(aTN, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(aTN, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(aTN, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(aTN, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(aTN, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(aTN, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(aTN, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            if (absThreadDataSupport.aTN().aUR()) {
                s.bRL().e(l.b(absThreadDataSupport.aTN(), str));
            } else {
                s.bRL().e(l.a(absThreadDataSupport.aTN(), str));
            }
        }
    }
}

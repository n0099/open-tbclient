package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.homepage.personalize.g;
import com.baidu.tieba.t.c;
/* loaded from: classes22.dex */
public class a {
    public static void a(by byVar, BdUniqueId bdUniqueId, int i) {
        boolean z;
        String str;
        int i2;
        if (byVar != null) {
            if (byVar.eMr) {
                str = byVar.eMs;
                i2 = 20;
                z = true;
            } else {
                z = false;
                str = null;
                i2 = 0;
            }
            String a2 = com.baidu.tieba.t.a.a(byVar.getTid(), str, "", byVar.getBaijiahaoData());
            ar a3 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a3 != null) {
                if (byVar.eMr) {
                    a3.delete("thread_type");
                    a3.al("thread_type", byVar.getThreadType());
                }
                if (byVar.bra()) {
                    a3.al("gua_type", 1);
                } else if (byVar.bqV() != null) {
                    a3.al("gua_type", 2);
                } else {
                    a3.al("gua_type", 0);
                }
                c.dOf().a(bdUniqueId, a2, a3);
                if (g.isEnabled()) {
                    g.Mz(a2);
                    if (g.cQd() >= 10) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                        g.setEnabled(false);
                    }
                }
            }
        }
    }

    public static void a(by byVar, BdUniqueId bdUniqueId, int i, int i2) {
        boolean z;
        String str;
        int i3;
        if (byVar != null) {
            if (byVar.eMr) {
                str = byVar.eMs;
                i3 = 20;
                z = true;
            } else {
                z = false;
                str = null;
                i3 = 0;
            }
            ar a2 = com.baidu.tieba.t.a.a(byVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a2 != null) {
                if (byVar.bra()) {
                    a2.al("gua_type", 1);
                } else if (byVar.bqV() != null) {
                    a2.al("gua_type", 2);
                    int indexOf = a2.getParams().indexOf("obj_locate");
                    if (indexOf >= 0) {
                        a2.getParams().remove(indexOf + 1);
                        a2.getParams().add(indexOf + 1, 16);
                    } else {
                        a2.al("obj_locate", 16);
                    }
                } else {
                    a2.al("gua_type", 0);
                }
                if (byVar.eMr) {
                    a2.delete("thread_type");
                    a2.al("thread_type", byVar.getThreadType());
                }
                c.dOf().b(bdUniqueId, a2);
                d(byVar, i2);
            }
        }
    }

    private static void d(by byVar, int i) {
        ar arVar = null;
        switch (i) {
            case 2:
                arVar = com.baidu.tieba.t.a.a("c13692", byVar, 1);
                break;
            case 9:
                arVar = com.baidu.tieba.t.a.a("c13693", byVar, 1);
                break;
        }
        TiebaStatic.log(arVar);
    }
}

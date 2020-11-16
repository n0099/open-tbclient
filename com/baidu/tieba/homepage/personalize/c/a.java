package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.homepage.personalize.g;
import com.baidu.tieba.t.c;
/* loaded from: classes21.dex */
public class a {
    public static void a(bx bxVar, BdUniqueId bdUniqueId, int i) {
        boolean z;
        String str;
        int i2;
        if (bxVar != null) {
            if (bxVar.eFp) {
                z = true;
                str = bxVar.eFq;
                i2 = 20;
            } else {
                z = false;
                str = null;
                i2 = 0;
            }
            String a2 = com.baidu.tieba.t.a.a(bxVar.getTid(), str, "", bxVar.getBaijiahaoData());
            ar a3 = com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a3 != null) {
                if (bxVar.eFp) {
                    a3.delete("thread_type");
                    a3.ak("thread_type", bxVar.getThreadType());
                }
                c.dIO().a(bdUniqueId, a2, a3);
                if (g.isEnabled()) {
                    g.Ls(a2);
                    if (g.cKN() >= 10) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                        g.setEnabled(false);
                    }
                }
            }
        }
    }

    public static void a(bx bxVar, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        int i3;
        boolean z = false;
        if (bxVar != null) {
            if (bxVar.eFp) {
                z = true;
                str = bxVar.eFq;
                i3 = 20;
            } else {
                str = null;
                i3 = 0;
            }
            ar a2 = com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a2 != null) {
                if (bxVar.eFp) {
                    a2.delete("thread_type");
                    a2.ak("thread_type", bxVar.getThreadType());
                }
                c.dIO().b(bdUniqueId, a2);
                d(bxVar, i2);
            }
        }
    }

    private static void d(bx bxVar, int i) {
        ar arVar = null;
        switch (i) {
            case 2:
                arVar = com.baidu.tieba.t.a.a("c13692", bxVar, 1);
                break;
            case 9:
                arVar = com.baidu.tieba.t.a.a("c13693", bxVar, 1);
                break;
        }
        TiebaStatic.log(arVar);
    }
}

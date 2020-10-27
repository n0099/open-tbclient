package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.homepage.personalize.g;
import com.baidu.tieba.s.c;
/* loaded from: classes22.dex */
public class a {
    public static void a(bw bwVar, BdUniqueId bdUniqueId, int i) {
        boolean z;
        String str;
        int i2;
        if (bwVar != null) {
            if (bwVar.eBi) {
                z = true;
                str = bwVar.eBj;
                i2 = 20;
            } else {
                z = false;
                str = null;
                i2 = 0;
            }
            String a2 = com.baidu.tieba.s.a.a(bwVar.getTid(), str, "", bwVar.getBaijiahaoData());
            aq a3 = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a3 != null) {
                if (bwVar.eBi) {
                    a3.delete("thread_type");
                    a3.aj("thread_type", bwVar.getThreadType());
                }
                c.dGv().a(bdUniqueId, a2, a3);
                if (g.isEnabled()) {
                    g.LA(a2);
                    if (g.cIG() >= 10) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                        g.setEnabled(false);
                    }
                }
            }
        }
    }

    public static void a(bw bwVar, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        int i3;
        boolean z = false;
        if (bwVar != null) {
            if (bwVar.eBi) {
                z = true;
                str = bwVar.eBj;
                i3 = 20;
            } else {
                str = null;
                i3 = 0;
            }
            aq a2 = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a2 != null) {
                if (bwVar.eBi) {
                    a2.delete("thread_type");
                    a2.aj("thread_type", bwVar.getThreadType());
                }
                c.dGv().b(bdUniqueId, a2);
                d(bwVar, i2);
            }
        }
    }

    private static void d(bw bwVar, int i) {
        aq aqVar = null;
        switch (i) {
            case 2:
                aqVar = com.baidu.tieba.s.a.a("c13692", bwVar, 1);
                break;
            case 9:
                aqVar = com.baidu.tieba.s.a.a("c13693", bwVar, 1);
                break;
        }
        TiebaStatic.log(aqVar);
    }
}

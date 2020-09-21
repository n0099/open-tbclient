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
/* loaded from: classes21.dex */
public class a {
    public static void a(bw bwVar, BdUniqueId bdUniqueId, int i) {
        boolean z;
        String str;
        int i2;
        if (bwVar != null) {
            if (bwVar.egC) {
                z = true;
                str = bwVar.egD;
                i2 = 20;
            } else {
                z = false;
                str = null;
                i2 = 0;
            }
            String a = com.baidu.tieba.s.a.a(bwVar.getTid(), str, "", bwVar.getBaijiahaoData());
            aq a2 = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a2 != null) {
                if (bwVar.egC) {
                    a2.delete("thread_type");
                    a2.ai("thread_type", bwVar.getThreadType());
                }
                c.dzC().a(bdUniqueId, a, a2);
                if (g.isEnabled()) {
                    g.Kn(a);
                    if (g.cBQ() >= 10) {
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
            if (bwVar.egC) {
                z = true;
                str = bwVar.egD;
                i3 = 20;
            } else {
                str = null;
                i3 = 0;
            }
            aq a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a != null) {
                if (bwVar.egC) {
                    a.delete("thread_type");
                    a.ai("thread_type", bwVar.getThreadType());
                }
                c.dzC().b(bdUniqueId, a);
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

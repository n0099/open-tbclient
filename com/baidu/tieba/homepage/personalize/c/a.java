package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.s.c;
/* loaded from: classes9.dex */
public class a {
    public static void a(bk bkVar, BdUniqueId bdUniqueId, int i) {
        String str;
        int i2;
        boolean z = false;
        if (bkVar != null) {
            if (bkVar.dHU) {
                z = true;
                str = bkVar.dHV;
                i2 = 20;
            } else {
                str = null;
                i2 = 0;
            }
            String a = com.baidu.tieba.s.a.a(bkVar.getTid(), str, "", bkVar.getBaijiahaoData());
            an a2 = com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a2 != null) {
                if (bkVar.dHU) {
                    a2.delete("thread_type");
                    a2.ag("thread_type", bkVar.getThreadType());
                }
                c.dcI().a(bdUniqueId, a, a2);
            }
        }
    }

    public static void a(bk bkVar, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        int i3;
        boolean z = false;
        if (bkVar != null) {
            if (bkVar.dHU) {
                z = true;
                str = bkVar.dHV;
                i3 = 20;
            } else {
                str = null;
                i3 = 0;
            }
            an a = com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a != null) {
                if (bkVar.dHU) {
                    a.delete("thread_type");
                    a.ag("thread_type", bkVar.getThreadType());
                }
                c.dcI().b(bdUniqueId, a);
                d(bkVar, i2);
            }
        }
    }

    private static void d(bk bkVar, int i) {
        an anVar = null;
        switch (i) {
            case 2:
                anVar = com.baidu.tieba.s.a.a("c13692", bkVar, 1);
                break;
            case 9:
                anVar = com.baidu.tieba.s.a.a("c13693", bkVar, 1);
                break;
        }
        TiebaStatic.log(anVar);
    }
}

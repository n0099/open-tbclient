package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.s.c;
/* loaded from: classes9.dex */
public class a {
    public static void a(bu buVar, BdUniqueId bdUniqueId, int i) {
        String str;
        int i2;
        boolean z = false;
        if (buVar != null) {
            if (buVar.dOG) {
                z = true;
                str = buVar.dOH;
                i2 = 20;
            } else {
                str = null;
                i2 = 0;
            }
            String a = com.baidu.tieba.s.a.a(buVar.getTid(), str, "", buVar.getBaijiahaoData());
            ao a2 = com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a2 != null) {
                if (buVar.dOG) {
                    a2.delete("thread_type");
                    a2.ag("thread_type", buVar.getThreadType());
                }
                c.dgY().a(bdUniqueId, a, a2);
            }
        }
    }

    public static void a(bu buVar, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        int i3;
        boolean z = false;
        if (buVar != null) {
            if (buVar.dOG) {
                z = true;
                str = buVar.dOH;
                i3 = 20;
            } else {
                str = null;
                i3 = 0;
            }
            ao a = com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a != null) {
                if (buVar.dOG) {
                    a.delete("thread_type");
                    a.ag("thread_type", buVar.getThreadType());
                }
                c.dgY().b(bdUniqueId, a);
                d(buVar, i2);
            }
        }
    }

    private static void d(bu buVar, int i) {
        ao aoVar = null;
        switch (i) {
            case 2:
                aoVar = com.baidu.tieba.s.a.a("c13692", buVar, 1);
                break;
            case 9:
                aoVar = com.baidu.tieba.s.a.a("c13693", buVar, 1);
                break;
        }
        TiebaStatic.log(aoVar);
    }
}

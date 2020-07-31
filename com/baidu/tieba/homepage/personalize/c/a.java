package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.s.c;
/* loaded from: classes16.dex */
public class a {
    public static void a(bv bvVar, BdUniqueId bdUniqueId, int i) {
        String str;
        int i2;
        boolean z = false;
        if (bvVar != null) {
            if (bvVar.dUS) {
                z = true;
                str = bvVar.dUT;
                i2 = 20;
            } else {
                str = null;
                i2 = 0;
            }
            String a = com.baidu.tieba.s.a.a(bvVar.getTid(), str, "", bvVar.getBaijiahaoData());
            ap a2 = com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a2 != null) {
                if (bvVar.dUS) {
                    a2.delete("thread_type");
                    a2.ah("thread_type", bvVar.getThreadType());
                }
                c.dkh().a(bdUniqueId, a, a2);
            }
        }
    }

    public static void a(bv bvVar, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        int i3;
        boolean z = false;
        if (bvVar != null) {
            if (bvVar.dUS) {
                z = true;
                str = bvVar.dUT;
                i3 = 20;
            } else {
                str = null;
                i3 = 0;
            }
            ap a = com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a != null) {
                if (bvVar.dUS) {
                    a.delete("thread_type");
                    a.ah("thread_type", bvVar.getThreadType());
                }
                c.dkh().b(bdUniqueId, a);
                d(bvVar, i2);
            }
        }
    }

    private static void d(bv bvVar, int i) {
        ap apVar = null;
        switch (i) {
            case 2:
                apVar = com.baidu.tieba.s.a.a("c13692", bvVar, 1);
                break;
            case 9:
                apVar = com.baidu.tieba.s.a.a("c13693", bvVar, 1);
                break;
        }
        TiebaStatic.log(apVar);
    }
}

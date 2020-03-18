package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.s.c;
/* loaded from: classes9.dex */
public class a {
    public static void a(bj bjVar, BdUniqueId bdUniqueId, int i) {
        String str;
        int i2;
        boolean z = false;
        if (bjVar != null) {
            if (bjVar.cUM) {
                z = true;
                str = bjVar.cUN;
                i2 = 20;
            } else {
                str = null;
                i2 = 0;
            }
            String a = com.baidu.tieba.s.a.a(bjVar.getTid(), str, "", bjVar.getBaijiahaoData());
            an a2 = com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a2 != null) {
                if (bjVar.cUM) {
                    a2.delete("thread_type");
                    a2.X("thread_type", bjVar.getThreadType());
                }
                c.cKv().a(bdUniqueId, a, a2);
            }
        }
    }

    public static void a(bj bjVar, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        int i3;
        boolean z = false;
        if (bjVar != null) {
            if (bjVar.cUM) {
                z = true;
                str = bjVar.cUN;
                i3 = 20;
            } else {
                str = null;
                i3 = 0;
            }
            an a = com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a != null) {
                if (bjVar.cUM) {
                    a.delete("thread_type");
                    a.X("thread_type", bjVar.getThreadType());
                }
                c.cKv().b(bdUniqueId, a);
            }
        }
    }
}

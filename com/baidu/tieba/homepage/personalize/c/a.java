package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.r.c;
/* loaded from: classes6.dex */
public class a {
    public static void a(bj bjVar, BdUniqueId bdUniqueId, int i) {
        String str;
        int i2;
        boolean z = false;
        if (bjVar != null) {
            if (bjVar.cQl) {
                z = true;
                str = bjVar.cQm;
                i2 = 20;
            } else {
                str = null;
                i2 = 0;
            }
            String a = com.baidu.tieba.r.a.a(bjVar.getTid(), str, "", bjVar.getBaijiahaoData());
            an a2 = com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a2 != null) {
                if (bjVar.cQl) {
                    a2.delete("thread_type");
                    a2.Z("thread_type", bjVar.getThreadType());
                }
                c.cHo().a(bdUniqueId, a, a2);
            }
        }
    }

    public static void a(bj bjVar, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        int i3;
        boolean z = false;
        if (bjVar != null) {
            if (bjVar.cQl) {
                z = true;
                str = bjVar.cQm;
                i3 = 20;
            } else {
                str = null;
                i3 = 0;
            }
            an a = com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a != null) {
                if (bjVar.cQl) {
                    a.delete("thread_type");
                    a.Z("thread_type", bjVar.getThreadType());
                }
                c.cHo().b(bdUniqueId, a);
            }
        }
    }
}

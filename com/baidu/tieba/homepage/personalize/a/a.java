package com.baidu.tieba.homepage.personalize.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.homepage.personalize.g;
import com.baidu.tieba.s.c;
/* loaded from: classes2.dex */
public class a {
    public static void a(bz bzVar, BdUniqueId bdUniqueId, int i) {
        boolean z;
        String str;
        int i2;
        if (bzVar != null) {
            if (bzVar.eRB) {
                str = bzVar.eRC;
                i2 = 20;
                z = true;
            } else {
                z = false;
                str = null;
                i2 = 0;
            }
            String a2 = com.baidu.tieba.s.a.a(bzVar.getTid(), str, "", bzVar.getBaijiahaoData());
            aq a3 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a3 != null) {
                if (bzVar.eRB) {
                    a3.delete("thread_type");
                    a3.an("thread_type", bzVar.getThreadType());
                }
                if (bzVar.bpJ()) {
                    a3.an("gua_type", 1);
                } else if (bzVar.bpE() != null) {
                    a3.an("gua_type", 2);
                } else {
                    a3.an("gua_type", 0);
                }
                c.dKg().a(bdUniqueId, a2, a3);
                if (g.isEnabled()) {
                    g.Lq(a2);
                    if (g.cPs() >= 10) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                        g.setEnabled(false);
                    }
                }
            }
        }
    }

    public static void a(bz bzVar, BdUniqueId bdUniqueId, int i, int i2) {
        boolean z;
        String str;
        int i3;
        if (bzVar != null) {
            if (bzVar.eRB) {
                str = bzVar.eRC;
                i3 = 20;
                z = true;
            } else {
                z = false;
                str = null;
                i3 = 0;
            }
            aq a2 = com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a2 != null) {
                if (bzVar.bpJ()) {
                    a2.an("gua_type", 1);
                } else if (bzVar.bpE() != null) {
                    a2.an("gua_type", 2);
                    int indexOf = a2.getParams().indexOf("obj_locate");
                    if (indexOf >= 0) {
                        a2.getParams().remove(indexOf + 1);
                        a2.getParams().add(indexOf + 1, 16);
                    } else {
                        a2.an("obj_locate", 16);
                    }
                } else {
                    a2.an("gua_type", 0);
                }
                if (bzVar.eRB) {
                    a2.delete("thread_type");
                    a2.an("thread_type", bzVar.getThreadType());
                }
                c.dKg().b(bdUniqueId, a2);
                d(bzVar, i2);
            }
        }
    }

    private static void d(bz bzVar, int i) {
        aq aqVar = null;
        switch (i) {
            case 2:
                aqVar = com.baidu.tieba.s.a.a("c13692", bzVar, 1);
                break;
            case 9:
                aqVar = com.baidu.tieba.s.a.a("c13693", bzVar, 1);
                break;
        }
        TiebaStatic.log(aqVar);
    }
}

package com.baidu.tieba.homepage.personalize.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.homepage.personalize.g;
import com.baidu.tieba.s.c;
/* loaded from: classes2.dex */
public class a {
    public static void a(cb cbVar, BdUniqueId bdUniqueId, int i) {
        boolean z;
        String str;
        int i2;
        if (cbVar != null) {
            if (cbVar.eVq) {
                str = cbVar.eVr;
                i2 = 20;
                z = true;
            } else {
                z = false;
                str = null;
                i2 = 0;
            }
            String a2 = com.baidu.tieba.s.a.a(cbVar.getTid(), str, "", cbVar.getBaijiahaoData());
            ar a3 = com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, z, str, (String) null, i2);
            if (a3 != null) {
                if (cbVar.eVq) {
                    a3.delete("thread_type");
                    a3.aq("thread_type", cbVar.getThreadType());
                }
                if (cbVar.bqd()) {
                    a3.aq("gua_type", 1);
                } else if (cbVar.bpY() != null) {
                    a3.aq("gua_type", 2);
                } else {
                    a3.aq("gua_type", 0);
                }
                c.dMH().a(bdUniqueId, a2, a3);
                if (g.isEnabled()) {
                    g.Mm(a2);
                    if (g.cRF() >= 10) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                        g.setEnabled(false);
                    }
                }
            }
        }
    }

    public static void a(cb cbVar, BdUniqueId bdUniqueId, int i, int i2) {
        boolean z;
        String str;
        int i3;
        if (cbVar != null) {
            if (cbVar.eVq) {
                str = cbVar.eVr;
                i3 = 20;
                z = true;
            } else {
                z = false;
                str = null;
                i3 = 0;
            }
            ar a2 = com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", i2, i, z, str, (String) null, i3);
            if (a2 != null) {
                if (cbVar.bqd()) {
                    a2.aq("gua_type", 1);
                } else if (cbVar.bpY() != null) {
                    a2.aq("gua_type", 2);
                    int indexOf = a2.getParams().indexOf("obj_locate");
                    if (indexOf >= 0) {
                        a2.getParams().remove(indexOf + 1);
                        a2.getParams().add(indexOf + 1, 16);
                    } else {
                        a2.aq("obj_locate", 16);
                    }
                } else {
                    a2.aq("gua_type", 0);
                }
                if (cbVar.eVq) {
                    a2.delete("thread_type");
                    a2.aq("thread_type", cbVar.getThreadType());
                }
                c.dMH().b(bdUniqueId, a2);
                d(cbVar, i2);
            }
        }
    }

    private static void d(cb cbVar, int i) {
        ar arVar = null;
        switch (i) {
            case 2:
                arVar = com.baidu.tieba.s.a.a("c13692", cbVar, 1);
                break;
            case 9:
                arVar = com.baidu.tieba.s.a.a("c13693", cbVar, 1);
                break;
        }
        TiebaStatic.log(arVar);
    }
}

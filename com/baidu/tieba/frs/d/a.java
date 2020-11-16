package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bx bxVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        boolean z2;
        int i3;
        String str2;
        ar a2;
        if (bxVar != null) {
            String str3 = null;
            int i4 = 0;
            boolean z3 = (bxVar.blW() == null || bxVar.blW().user_info == null || bxVar.blW().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bxVar.blW().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bxVar.blW().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = bxVar.getThreadType() == 41;
                if (z4) {
                    if (bxVar.bli() != null) {
                        str3 = bxVar.bli().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (bxVar.eFc) {
                        z = true;
                        str = bxVar.getId();
                        i2 = 14;
                    }
                    if (bxVar.eFp) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bxVar.eFq;
                        i3 = 17;
                    }
                    a2 = com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bxVar.eAb, z2, str2, (String) null, i3);
                    if (a2 == null) {
                        a2.ak("list_order", c.cEu().a(bVar));
                        a(a2, bxVar, tbPageTag);
                        if (bxVar.bnM()) {
                            a2.ak("gua_type", 1);
                        }
                        if (z3) {
                            a2.ak("obj_isofficial", bxVar.blW().user_info.is_official);
                        }
                        if (z3 || bxVar.eFc || bxVar.eFp) {
                            a2.delete("thread_type");
                            a2.ak("thread_type", bxVar.getThreadType());
                        }
                        a(a2, tbPageTag, true);
                        com.baidu.tieba.t.c.dIO().b(bdUniqueId, a2);
                        d(bxVar, i);
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i2 = i4;
            str = str3;
            z = z6;
            if (bxVar.eFc) {
            }
            if (bxVar.eFp) {
            }
            a2 = com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bxVar.eAb, z2, str2, (String) null, i3);
            if (a2 == null) {
            }
        }
    }

    private static void d(bx bxVar, int i) {
        ar arVar = null;
        switch (i) {
            case 2:
                arVar = com.baidu.tieba.t.a.a("c13692", bxVar, 2);
                break;
        }
        TiebaStatic.log(arVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bx bxVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        String str2;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        String str3;
        ar a2;
        if (bxVar != null) {
            boolean z3 = (bxVar.blW() == null || bxVar.blW().user_info == null || bxVar.blW().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bxVar.blW().frsLiveStageType == 0;
            if (z4) {
                str = String.valueOf(bxVar.blW().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z4) {
                z4 = bxVar.getThreadType() == 41;
                if (z4) {
                    if (bxVar.bli() != null) {
                        str = bxVar.bli().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str2 = str;
                    z = z5;
                    if (bxVar.eFc) {
                        str2 = bxVar.getId();
                        i2 = 14;
                        z = true;
                    }
                    if (bxVar.eFp) {
                        z2 = z;
                        i3 = i2;
                        str3 = str2;
                    } else {
                        str3 = bxVar.eFq;
                        i3 = 17;
                        z2 = true;
                    }
                    a2 = com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.FRS, "common_exp", bxVar.eAb, z2, str3, (String) null, i3);
                    if (a2 == null) {
                        a2.ak("list_order", c.cEu().a(bVar));
                        if (bxVar.bnM()) {
                            a2.ak("gua_type", 1);
                        }
                        a(a2, bxVar, tbPageTag);
                        if (z3) {
                            a2.ak("obj_isofficial", bxVar.blW().user_info.is_official);
                        }
                        if (z3 || bxVar.eFc || bxVar.eFp) {
                            a2.delete("thread_type");
                            a2.ak("thread_type", bxVar.getThreadType());
                        }
                        a(a2, tbPageTag, false);
                        com.baidu.tieba.t.c.dIO().a(bdUniqueId, com.baidu.tieba.t.a.a(bxVar.getTid(), str3, "", bxVar.getBaijiahaoData()), a2);
                        if (bxVar.eFc) {
                            a(bxVar, bdUniqueId, tbPageTag);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            str2 = str;
            z = z4;
            i2 = i;
            if (bxVar.eFc) {
            }
            if (bxVar.eFp) {
            }
            a2 = com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.FRS, "common_exp", bxVar.eAb, z2, str3, (String) null, i3);
            if (a2 == null) {
            }
        }
    }

    private static void a(ar arVar, TbPageTag tbPageTag, boolean z) {
        int i;
        int i2 = 3;
        if (arVar != null && tbPageTag != null) {
            if ("a070".equals(tbPageTag.locatePage)) {
                i = 1;
            } else if ("a071".equals(tbPageTag.locatePage)) {
                i = 2;
            } else if ("a072".equals(tbPageTag.locatePage)) {
                i = 3;
            } else if (502 == tbPageTag.tabId) {
                i = 5;
            } else if (92 == tbPageTag.tabType || 49 == tbPageTag.tabId || 1120 == tbPageTag.tabId || 1121 == tbPageTag.tabId) {
                i = 6;
            } else if (16 == tbPageTag.tabType) {
                i = 7;
            } else if (3 == tbPageTag.tabType) {
                i = 8;
            } else if (90 == tbPageTag.tabId) {
                i = 9;
            } else {
                i = tbPageTag.isGeneralTab == 1 ? 4 : 0;
            }
            if (z) {
                if (i > 0) {
                    arVar.delete("obj_name");
                    arVar.ak("obj_name", i);
                }
            } else if (i > 0) {
                arVar.delete("obj_locate");
                arVar.ak("obj_locate", i);
            }
            switch (tbPageTag.sortType) {
                case 1:
                    break;
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (i2 > 0) {
                if (i == 1 || i == 2) {
                    arVar.delete("list_order");
                    arVar.ak("list_order", i2);
                }
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<q> list, ForumData forumData, int i) {
        if (!y.isEmpty(list)) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) instanceof com.baidu.tieba.InjectPlugin.a) {
                    i2++;
                }
                if (i2 > 0) {
                    a(bdUniqueId, i2, forumData, i, 0);
                } else {
                    return;
                }
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, int i, ForumData forumData, int i2, int i3) {
        if (i > 0) {
            ar a2 = com.baidu.tieba.t.a.a(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!au.isEmpty(forumData.getId())) {
                    a2.dR("fid", forumData.getId());
                }
                if (!au.isEmpty(forumData.getName())) {
                    a2.dR("fname", forumData.getName());
                }
                if (!au.isEmpty(forumData.getFirst_class())) {
                    a2.dR("first_dir", forumData.getFirst_class());
                }
                if (!au.isEmpty(forumData.getSecond_class())) {
                    a2.dR("second_dir", forumData.getSecond_class());
                }
            }
            a2.ak("list_order", i2);
            com.baidu.tieba.t.c.dIO().b(bdUniqueId, a2);
        }
    }

    public static void a(bx bxVar, TbPageTag tbPageTag) {
        if (bxVar != null) {
            ar dR = new ar("common_click").dR("page_type", PageStayDurationConstants.PageName.FRS).ak("obj_isad", 1).ak("obj_adlocate", 15).dR("obj_id", bxVar.getId()).w("fid", bxVar.getFid()).ak("obj_floor", bxVar.eAb).dR("tid", bxVar.getId()).ak("thread_type", bxVar.getThreadType()).dR("first_dir", bxVar.bnm()).dR("second_dir", bxVar.bnn()).dR("nid", bxVar.getNid());
            a(dR, bxVar, tbPageTag);
            TiebaStatic.log(dR);
        }
    }

    private static void a(bx bxVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bxVar != null && bdUniqueId != null && bxVar.eFc) {
            boolean z = (bxVar.blC() == null || bxVar.blC().getUserId() == null || !bxVar.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bxVar.bmT() && bxVar.getFeedBackReasonMap() != null && !z) {
                ar dR = new ar("common_exp").dR("page_type", PageStayDurationConstants.PageName.FRS).ak("obj_isad", 1).ak("obj_adlocate", 15).dR("obj_id", bxVar.getId()).ak("obj_floor", bxVar.eAb).w("fid", bxVar.getFid()).ak("thread_type", bxVar.getThreadType()).dR("tid", bxVar.getId()).dR("first_dir", bxVar.bnm()).dR("second_dir", bxVar.bnn());
                a(dR, bxVar, tbPageTag);
                com.baidu.tieba.t.c.dIO().a(bdUniqueId, com.baidu.tieba.t.a.a(bxVar.getTid(), "", "", bxVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dR);
            }
        }
    }

    private static void a(ar arVar, bx bxVar, TbPageTag tbPageTag) {
        if (!au.isEmpty(bxVar.mRecomWeight)) {
            arVar.dR("recom_weight", bxVar.mRecomWeight);
        }
        if (!au.isEmpty(bxVar.mRecomExtra)) {
            arVar.dR("recom_extra", bxVar.mRecomExtra);
        }
        if (!au.isEmpty(bxVar.mRecomSource)) {
            arVar.dR(IntentConfig.RECOM_SOURCE, bxVar.mRecomSource);
        }
        if (!au.isEmpty(bxVar.mRecomAbTag)) {
            arVar.dR("recom_ab_tag", bxVar.mRecomAbTag);
        }
        arVar.ak("recom_type", bxVar.bnD());
        com.baidu.tbadk.pageInfo.c.a(arVar, tbPageTag);
    }
}

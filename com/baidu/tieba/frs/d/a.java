package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bw bwVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        boolean z2;
        int i3;
        String str2;
        aq a2;
        if (bwVar != null) {
            String str3 = null;
            int i4 = 0;
            boolean z3 = (bwVar.bmU() == null || bwVar.bmU().user_info == null || bwVar.bmU().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bwVar.bmU().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bwVar.bmU().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = bwVar.getThreadType() == 41;
                if (z4) {
                    if (bwVar.bmg() != null) {
                        str3 = bwVar.bmg().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (bwVar.eGK) {
                        z = true;
                        str = bwVar.getId();
                        i2 = 14;
                    }
                    if (bwVar.eGX) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bwVar.eGY;
                        i3 = 17;
                    }
                    a2 = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bwVar.eBK, z2, str2, (String) null, i3);
                    if (a2 == null) {
                        a2.al("list_order", c.cEP().a(bVar));
                        a(a2, bwVar, tbPageTag);
                        if (bwVar.boI()) {
                            a2.al("gua_type", 1);
                        }
                        if (z3) {
                            a2.al("obj_isofficial", bwVar.bmU().user_info.is_official);
                        }
                        if (z3 || bwVar.eGK || bwVar.eGX) {
                            a2.delete("thread_type");
                            a2.al("thread_type", bwVar.getThreadType());
                        }
                        a(a2, tbPageTag, true);
                        com.baidu.tieba.s.c.dIX().b(bdUniqueId, a2);
                        d(bwVar, i);
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i2 = i4;
            str = str3;
            z = z6;
            if (bwVar.eGK) {
            }
            if (bwVar.eGX) {
            }
            a2 = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bwVar.eBK, z2, str2, (String) null, i3);
            if (a2 == null) {
            }
        }
    }

    private static void d(bw bwVar, int i) {
        aq aqVar = null;
        switch (i) {
            case 2:
                aqVar = com.baidu.tieba.s.a.a("c13692", bwVar, 2);
                break;
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bw bwVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        String str2;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        String str3;
        aq a2;
        if (bwVar != null) {
            boolean z3 = (bwVar.bmU() == null || bwVar.bmU().user_info == null || bwVar.bmU().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bwVar.bmU().frsLiveStageType == 0;
            if (z4) {
                str = String.valueOf(bwVar.bmU().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z4) {
                z4 = bwVar.getThreadType() == 41;
                if (z4) {
                    if (bwVar.bmg() != null) {
                        str = bwVar.bmg().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str2 = str;
                    z = z5;
                    if (bwVar.eGK) {
                        str2 = bwVar.getId();
                        i2 = 14;
                        z = true;
                    }
                    if (bwVar.eGX) {
                        z2 = z;
                        i3 = i2;
                        str3 = str2;
                    } else {
                        str3 = bwVar.eGY;
                        i3 = 17;
                        z2 = true;
                    }
                    a2 = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_exp", bwVar.eBK, z2, str3, (String) null, i3);
                    if (a2 == null) {
                        a2.al("list_order", c.cEP().a(bVar));
                        if (bwVar.boI()) {
                            a2.al("gua_type", 1);
                        }
                        a(a2, bwVar, tbPageTag);
                        if (z3) {
                            a2.al("obj_isofficial", bwVar.bmU().user_info.is_official);
                        }
                        if (z3 || bwVar.eGK || bwVar.eGX) {
                            a2.delete("thread_type");
                            a2.al("thread_type", bwVar.getThreadType());
                        }
                        a(a2, tbPageTag, false);
                        com.baidu.tieba.s.c.dIX().a(bdUniqueId, com.baidu.tieba.s.a.a(bwVar.getTid(), str3, "", bwVar.getBaijiahaoData()), a2);
                        if (bwVar.eGK) {
                            a(bwVar, bdUniqueId, tbPageTag);
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
            if (bwVar.eGK) {
            }
            if (bwVar.eGX) {
            }
            a2 = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_exp", bwVar.eBK, z2, str3, (String) null, i3);
            if (a2 == null) {
            }
        }
    }

    private static void a(aq aqVar, TbPageTag tbPageTag, boolean z) {
        int i;
        int i2 = 3;
        if (aqVar != null && tbPageTag != null) {
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
                    aqVar.delete("obj_name");
                    aqVar.al("obj_name", i);
                }
            } else if (i > 0) {
                aqVar.delete("obj_locate");
                aqVar.al("obj_locate", i);
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
                    aqVar.delete("list_order");
                    aqVar.al("list_order", i2);
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
            aq a2 = com.baidu.tieba.s.a.a(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!at.isEmpty(forumData.getId())) {
                    a2.dR("fid", forumData.getId());
                }
                if (!at.isEmpty(forumData.getName())) {
                    a2.dR("fname", forumData.getName());
                }
                if (!at.isEmpty(forumData.getFirst_class())) {
                    a2.dR("first_dir", forumData.getFirst_class());
                }
                if (!at.isEmpty(forumData.getSecond_class())) {
                    a2.dR("second_dir", forumData.getSecond_class());
                }
            }
            a2.al("list_order", i2);
            com.baidu.tieba.s.c.dIX().b(bdUniqueId, a2);
        }
    }

    public static void a(bw bwVar, TbPageTag tbPageTag) {
        if (bwVar != null) {
            aq dR = new aq("common_click").dR("page_type", PageStayDurationConstants.PageName.FRS).al("obj_isad", 1).al("obj_adlocate", 15).dR("obj_id", bwVar.getId()).w("fid", bwVar.getFid()).al("obj_floor", bwVar.eBK).dR("tid", bwVar.getId()).al("thread_type", bwVar.getThreadType()).dR("first_dir", bwVar.boi()).dR("second_dir", bwVar.boj()).dR("nid", bwVar.getNid());
            a(dR, bwVar, tbPageTag);
            TiebaStatic.log(dR);
        }
    }

    private static void a(bw bwVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bwVar != null && bdUniqueId != null && bwVar.eGK) {
            boolean z = (bwVar.bmA() == null || bwVar.bmA().getUserId() == null || !bwVar.bmA().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bwVar.bnP() && bwVar.getFeedBackReasonMap() != null && !z) {
                aq dR = new aq("common_exp").dR("page_type", PageStayDurationConstants.PageName.FRS).al("obj_isad", 1).al("obj_adlocate", 15).dR("obj_id", bwVar.getId()).al("obj_floor", bwVar.eBK).w("fid", bwVar.getFid()).al("thread_type", bwVar.getThreadType()).dR("tid", bwVar.getId()).dR("first_dir", bwVar.boi()).dR("second_dir", bwVar.boj());
                a(dR, bwVar, tbPageTag);
                com.baidu.tieba.s.c.dIX().a(bdUniqueId, com.baidu.tieba.s.a.a(bwVar.getTid(), "", "", bwVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dR);
            }
        }
    }

    private static void a(aq aqVar, bw bwVar, TbPageTag tbPageTag) {
        if (!at.isEmpty(bwVar.mRecomWeight)) {
            aqVar.dR("recom_weight", bwVar.mRecomWeight);
        }
        if (!at.isEmpty(bwVar.mRecomExtra)) {
            aqVar.dR("recom_extra", bwVar.mRecomExtra);
        }
        if (!at.isEmpty(bwVar.mRecomSource)) {
            aqVar.dR(IntentConfig.RECOM_SOURCE, bwVar.mRecomSource);
        }
        if (!at.isEmpty(bwVar.mRecomAbTag)) {
            aqVar.dR("recom_ab_tag", bwVar.mRecomAbTag);
        }
        aqVar.al("recom_type", bwVar.boz());
        com.baidu.tbadk.pageInfo.c.a(aqVar, tbPageTag);
    }
}

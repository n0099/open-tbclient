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
/* loaded from: classes16.dex */
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
        aq a;
        if (bwVar != null) {
            String str3 = null;
            int i4 = 0;
            boolean z3 = (bwVar.beY() == null || bwVar.beY().user_info == null || bwVar.beY().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bwVar.beY().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bwVar.beY().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = bwVar.getThreadType() == 41;
                if (z4) {
                    if (bwVar.bek() != null) {
                        str3 = bwVar.bek().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (bwVar.eef) {
                        z = true;
                        str = bwVar.getId();
                        i2 = 14;
                    }
                    if (bwVar.eet) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bwVar.eeu;
                        i3 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bwVar.dZf, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.ai("list_order", c.csv().a(bVar));
                        a(a, bwVar, tbPageTag);
                        if (bwVar.bgM()) {
                            a.ai("gua_type", 1);
                        }
                        if (z3) {
                            a.ai("obj_isofficial", bwVar.beY().user_info.is_official);
                        }
                        if (z3 || bwVar.eef || bwVar.eet) {
                            a.delete("thread_type");
                            a.ai("thread_type", bwVar.getThreadType());
                        }
                        a(a, tbPageTag, true);
                        com.baidu.tieba.s.c.dvJ().b(bdUniqueId, a);
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
            if (bwVar.eef) {
            }
            if (bwVar.eet) {
            }
            a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bwVar.dZf, z2, str2, (String) null, i3);
            if (a == null) {
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
        aq a;
        if (bwVar != null) {
            boolean z3 = (bwVar.beY() == null || bwVar.beY().user_info == null || bwVar.beY().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bwVar.beY().frsLiveStageType == 0;
            if (z4) {
                str = String.valueOf(bwVar.beY().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z4) {
                z4 = bwVar.getThreadType() == 41;
                if (z4) {
                    if (bwVar.bek() != null) {
                        str = bwVar.bek().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str2 = str;
                    z = z5;
                    if (bwVar.eef) {
                        str2 = bwVar.getId();
                        i2 = 14;
                        z = true;
                    }
                    if (bwVar.eet) {
                        z2 = z;
                        i3 = i2;
                        str3 = str2;
                    } else {
                        str3 = bwVar.eeu;
                        i3 = 17;
                        z2 = true;
                    }
                    a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_exp", bwVar.dZf, z2, str3, (String) null, i3);
                    if (a == null) {
                        a.ai("list_order", c.csv().a(bVar));
                        if (bwVar.bgM()) {
                            a.ai("gua_type", 1);
                        }
                        a(a, bwVar, tbPageTag);
                        if (z3) {
                            a.ai("obj_isofficial", bwVar.beY().user_info.is_official);
                        }
                        if (z3 || bwVar.eef || bwVar.eet) {
                            a.delete("thread_type");
                            a.ai("thread_type", bwVar.getThreadType());
                        }
                        a(a, tbPageTag, false);
                        com.baidu.tieba.s.c.dvJ().a(bdUniqueId, com.baidu.tieba.s.a.a(bwVar.getTid(), str3, "", bwVar.getBaijiahaoData()), a);
                        if (bwVar.eef) {
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
            if (bwVar.eef) {
            }
            if (bwVar.eet) {
            }
            a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_exp", bwVar.dZf, z2, str3, (String) null, i3);
            if (a == null) {
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
            aqVar.delete("obj_name");
            aqVar.delete("obj_locate");
            if (z) {
                if (i > 0) {
                    aqVar.ai("obj_name", i);
                }
            } else if (i > 0) {
                aqVar.ai("obj_locate", i);
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
            aqVar.delete("list_order");
            if (i2 > 0) {
                if (i == 1 || i == 2) {
                    aqVar.ai("list_order", i2);
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
            aq a = com.baidu.tieba.s.a.a(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!at.isEmpty(forumData.getId())) {
                    a.dD("fid", forumData.getId());
                }
                if (!at.isEmpty(forumData.getName())) {
                    a.dD("fname", forumData.getName());
                }
                if (!at.isEmpty(forumData.getFirst_class())) {
                    a.dD("first_dir", forumData.getFirst_class());
                }
                if (!at.isEmpty(forumData.getSecond_class())) {
                    a.dD("second_dir", forumData.getSecond_class());
                }
            }
            a.ai("list_order", i2);
            com.baidu.tieba.s.c.dvJ().b(bdUniqueId, a);
        }
    }

    public static void a(bw bwVar, TbPageTag tbPageTag) {
        if (bwVar != null) {
            aq dD = new aq("common_click").dD("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).ai("obj_adlocate", 15).dD("obj_id", bwVar.getId()).u("fid", bwVar.getFid()).ai("obj_floor", bwVar.dZf).dD("tid", bwVar.getId()).ai("thread_type", bwVar.getThreadType()).dD("first_dir", bwVar.bgm()).dD("second_dir", bwVar.bgn()).dD("nid", bwVar.getNid());
            a(dD, bwVar, tbPageTag);
            TiebaStatic.log(dD);
        }
    }

    private static void a(bw bwVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bwVar != null && bdUniqueId != null && bwVar.eef) {
            boolean z = (bwVar.beE() == null || bwVar.beE().getUserId() == null || !bwVar.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bwVar.bfT() && bwVar.getFeedBackReasonMap() != null && !z) {
                aq dD = new aq("common_exp").dD("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).ai("obj_adlocate", 15).dD("obj_id", bwVar.getId()).ai("obj_floor", bwVar.dZf).u("fid", bwVar.getFid()).ai("thread_type", bwVar.getThreadType()).dD("tid", bwVar.getId()).dD("first_dir", bwVar.bgm()).dD("second_dir", bwVar.bgn());
                a(dD, bwVar, tbPageTag);
                com.baidu.tieba.s.c.dvJ().a(bdUniqueId, com.baidu.tieba.s.a.a(bwVar.getTid(), "", "", bwVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dD);
            }
        }
    }

    private static void a(aq aqVar, bw bwVar, TbPageTag tbPageTag) {
        if (!at.isEmpty(bwVar.mRecomWeight)) {
            aqVar.dD("recom_weight", bwVar.mRecomWeight);
        }
        if (!at.isEmpty(bwVar.mRecomExtra)) {
            aqVar.dD("recom_extra", bwVar.mRecomExtra);
        }
        if (!at.isEmpty(bwVar.mRecomSource)) {
            aqVar.dD(IntentConfig.RECOM_SOURCE, bwVar.mRecomSource);
        }
        if (!at.isEmpty(bwVar.mRecomAbTag)) {
            aqVar.dD("recom_ab_tag", bwVar.mRecomAbTag);
        }
        aqVar.ai("recom_type", bwVar.bgD());
        com.baidu.tbadk.pageInfo.c.a(aqVar, tbPageTag);
    }
}

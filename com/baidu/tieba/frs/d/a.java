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
    /* JADX WARN: Removed duplicated region for block: B:49:0x00db  */
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
                    if (bwVar.eeb) {
                        z = true;
                        str = bwVar.getId();
                        i2 = 14;
                    }
                    if (bwVar.eep) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bwVar.eeq;
                        i3 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bwVar.dZb, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.ai("list_order", c.csu().a(bVar));
                        a(a, bwVar, tbPageTag);
                        if (bwVar.bgM()) {
                            a.ai("gua_type", 1);
                        }
                        if (z3) {
                            a.ai("obj_isofficial", bwVar.beY().user_info.is_official);
                        }
                        if (z3 || bwVar.eeb || bwVar.eep) {
                            a.delete("thread_type");
                            a.ai("thread_type", bwVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.dvE().b(bdUniqueId, a);
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
            if (bwVar.eeb) {
            }
            if (bwVar.eep) {
            }
            a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bwVar.dZb, z2, str2, (String) null, i3);
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

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bw bwVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        boolean z2;
        int i2;
        String str2;
        aq a;
        if (bwVar != null) {
            String str3 = null;
            int i3 = 0;
            boolean z3 = (bwVar.beY() == null || bwVar.beY().user_info == null || bwVar.beY().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bwVar.beY().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bwVar.beY().live_id);
                i3 = 4;
            }
            if (!z4) {
                z4 = bwVar.getThreadType() == 41;
                if (z4) {
                    if (bwVar.bek() != null) {
                        str3 = bwVar.bek().getTaskId();
                    }
                    boolean z5 = z4;
                    i = 2;
                    str = str3;
                    z = z5;
                    if (bwVar.eeb) {
                        z = true;
                        str = bwVar.getId();
                        i = 14;
                    }
                    if (bwVar.eep) {
                        z2 = z;
                        i2 = i;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bwVar.eeq;
                        i2 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_exp", bwVar.dZb, z2, str2, (String) null, i2);
                    if (a == null) {
                        a.ai("list_order", c.csu().a(bVar));
                        if (bwVar.bgM()) {
                            a.ai("gua_type", 1);
                        }
                        a(a, bwVar, tbPageTag);
                        if (z3) {
                            a.ai("obj_isofficial", bwVar.beY().user_info.is_official);
                        }
                        if (z3 || bwVar.eeb || bwVar.eep) {
                            a.delete("thread_type");
                            a.ai("thread_type", bwVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.dvE().a(bdUniqueId, com.baidu.tieba.s.a.a(bwVar.getTid(), str2, "", bwVar.getBaijiahaoData()), a);
                        if (bwVar.eeb) {
                            a(bwVar, bdUniqueId, tbPageTag);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i = i3;
            str = str3;
            z = z6;
            if (bwVar.eeb) {
            }
            if (bwVar.eep) {
            }
            a = com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.FRS, "common_exp", bwVar.dZb, z2, str2, (String) null, i2);
            if (a == null) {
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
            com.baidu.tieba.s.c.dvE().b(bdUniqueId, a);
        }
    }

    public static void a(bw bwVar, TbPageTag tbPageTag) {
        if (bwVar != null) {
            aq dD = new aq("common_click").dD("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).ai("obj_adlocate", 15).dD("obj_id", bwVar.getId()).u("fid", bwVar.getFid()).ai("obj_floor", bwVar.dZb).dD("tid", bwVar.getId()).ai("thread_type", bwVar.getThreadType()).dD("first_dir", bwVar.bgm()).dD("second_dir", bwVar.bgn()).dD("nid", bwVar.getNid());
            a(dD, bwVar, tbPageTag);
            TiebaStatic.log(dD);
        }
    }

    private static void a(bw bwVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bwVar != null && bdUniqueId != null && bwVar.eeb) {
            boolean z = (bwVar.beE() == null || bwVar.beE().getUserId() == null || !bwVar.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bwVar.bfT() && bwVar.getFeedBackReasonMap() != null && !z) {
                aq dD = new aq("common_exp").dD("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).ai("obj_adlocate", 15).dD("obj_id", bwVar.getId()).ai("obj_floor", bwVar.dZb).u("fid", bwVar.getFid()).ai("thread_type", bwVar.getThreadType()).dD("tid", bwVar.getId()).dD("first_dir", bwVar.bgm()).dD("second_dir", bwVar.bgn());
                a(dD, bwVar, tbPageTag);
                com.baidu.tieba.s.c.dvE().a(bdUniqueId, com.baidu.tieba.s.a.a(bwVar.getTid(), "", "", bwVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dD);
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

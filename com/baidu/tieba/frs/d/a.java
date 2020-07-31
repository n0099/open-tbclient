package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bv bvVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        boolean z2;
        int i3;
        String str2;
        ap a;
        if (bvVar != null) {
            String str3 = null;
            int i4 = 0;
            boolean z3 = (bvVar.aWF() == null || bvVar.aWF().user_info == null || bvVar.aWF().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bvVar.aWF().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bvVar.aWF().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = bvVar.getThreadType() == 41;
                if (z4) {
                    if (bvVar.aVR() != null) {
                        str3 = bvVar.aVR().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (bvVar.dUF) {
                        z = true;
                        str = bvVar.getId();
                        i2 = 14;
                    }
                    if (bvVar.dUS) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bvVar.dUT;
                        i3 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bvVar.dPI, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.ah("list_order", c.chQ().a(bVar));
                        a(a, bvVar, tbPageTag);
                        if (z3) {
                            a.ah("obj_isofficial", bvVar.aWF().user_info.is_official);
                        }
                        if (z3 || bvVar.dUF || bvVar.dUS) {
                            a.delete("thread_type");
                            a.ah("thread_type", bvVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.dkh().b(bdUniqueId, a);
                        d(bvVar, i);
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i2 = i4;
            str = str3;
            z = z6;
            if (bvVar.dUF) {
            }
            if (bvVar.dUS) {
            }
            a = com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bvVar.dPI, z2, str2, (String) null, i3);
            if (a == null) {
            }
        }
    }

    private static void d(bv bvVar, int i) {
        ap apVar = null;
        switch (i) {
            case 2:
                apVar = com.baidu.tieba.s.a.a("c13692", bvVar, 2);
                break;
        }
        TiebaStatic.log(apVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bv bvVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        boolean z2;
        int i2;
        String str2;
        ap a;
        if (bvVar != null) {
            String str3 = null;
            int i3 = 0;
            boolean z3 = (bvVar.aWF() == null || bvVar.aWF().user_info == null || bvVar.aWF().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bvVar.aWF().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bvVar.aWF().live_id);
                i3 = 4;
            }
            if (!z4) {
                z4 = bvVar.getThreadType() == 41;
                if (z4) {
                    if (bvVar.aVR() != null) {
                        str3 = bvVar.aVR().getTaskId();
                    }
                    boolean z5 = z4;
                    i = 2;
                    str = str3;
                    z = z5;
                    if (bvVar.dUF) {
                        z = true;
                        str = bvVar.getId();
                        i = 14;
                    }
                    if (bvVar.dUS) {
                        z2 = z;
                        i2 = i;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bvVar.dUT;
                        i2 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.FRS, "common_exp", bvVar.dPI, z2, str2, (String) null, i2);
                    if (a == null) {
                        a.ah("list_order", c.chQ().a(bVar));
                        a(a, bvVar, tbPageTag);
                        if (z3) {
                            a.ah("obj_isofficial", bvVar.aWF().user_info.is_official);
                        }
                        if (z3 || bvVar.dUF || bvVar.dUS) {
                            a.delete("thread_type");
                            a.ah("thread_type", bvVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.dkh().a(bdUniqueId, com.baidu.tieba.s.a.a(bvVar.getTid(), str2, "", bvVar.getBaijiahaoData()), a);
                        if (bvVar.dUF) {
                            a(bvVar, bdUniqueId, tbPageTag);
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
            if (bvVar.dUF) {
            }
            if (bvVar.dUS) {
            }
            a = com.baidu.tieba.s.a.a(bvVar, PageStayDurationConstants.PageName.FRS, "common_exp", bvVar.dPI, z2, str2, (String) null, i2);
            if (a == null) {
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<q> list, ForumData forumData, int i) {
        if (!x.isEmpty(list)) {
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
            ap a = com.baidu.tieba.s.a.a(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!as.isEmpty(forumData.getId())) {
                    a.dn("fid", forumData.getId());
                }
                if (!as.isEmpty(forumData.getName())) {
                    a.dn("fname", forumData.getName());
                }
                if (!as.isEmpty(forumData.getFirst_class())) {
                    a.dn("first_dir", forumData.getFirst_class());
                }
                if (!as.isEmpty(forumData.getSecond_class())) {
                    a.dn("second_dir", forumData.getSecond_class());
                }
            }
            a.ah("list_order", i2);
            com.baidu.tieba.s.c.dkh().b(bdUniqueId, a);
        }
    }

    public static void a(bv bvVar, TbPageTag tbPageTag) {
        if (bvVar != null) {
            ap dn = new ap("common_click").dn("page_type", PageStayDurationConstants.PageName.FRS).ah("obj_isad", 1).ah("obj_adlocate", 15).dn("obj_id", bvVar.getId()).t("fid", bvVar.getFid()).ah("obj_floor", bvVar.dPI).dn("tid", bvVar.getId()).ah("thread_type", bvVar.getThreadType()).dn("first_dir", bvVar.aXT()).dn("second_dir", bvVar.aXU()).dn("nid", bvVar.getNid());
            a(dn, bvVar, tbPageTag);
            TiebaStatic.log(dn);
        }
    }

    private static void a(bv bvVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bvVar != null && bdUniqueId != null && bvVar.dUF) {
            boolean z = (bvVar.aWl() == null || bvVar.aWl().getUserId() == null || !bvVar.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bvVar.aXA() && bvVar.getFeedBackReasonMap() != null && !z) {
                ap dn = new ap("common_exp").dn("page_type", PageStayDurationConstants.PageName.FRS).ah("obj_isad", 1).ah("obj_adlocate", 15).dn("obj_id", bvVar.getId()).ah("obj_floor", bvVar.dPI).t("fid", bvVar.getFid()).ah("thread_type", bvVar.getThreadType()).dn("tid", bvVar.getId()).dn("first_dir", bvVar.aXT()).dn("second_dir", bvVar.aXU());
                a(dn, bvVar, tbPageTag);
                com.baidu.tieba.s.c.dkh().a(bdUniqueId, com.baidu.tieba.s.a.a(bvVar.getTid(), "", "", bvVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dn);
            }
        }
    }

    private static void a(ap apVar, bv bvVar, TbPageTag tbPageTag) {
        if (!as.isEmpty(bvVar.mRecomWeight)) {
            apVar.dn("recom_weight", bvVar.mRecomWeight);
        }
        if (!as.isEmpty(bvVar.mRecomExtra)) {
            apVar.dn("recom_extra", bvVar.mRecomExtra);
        }
        if (!as.isEmpty(bvVar.mRecomSource)) {
            apVar.dn(IntentConfig.RECOM_SOURCE, bvVar.mRecomSource);
        }
        if (!as.isEmpty(bvVar.mRecomAbTag)) {
            apVar.dn("recom_ab_tag", bvVar.mRecomAbTag);
        }
        apVar.ah("recom_type", bvVar.aYk());
        com.baidu.tbadk.pageInfo.c.a(apVar, tbPageTag);
    }
}

package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageInfo.TbPageTag;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bk bkVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        boolean z2;
        int i3;
        String str2;
        an a;
        if (bkVar != null) {
            String str3 = null;
            int i4 = 0;
            boolean z3 = (bkVar.aQS() == null || bkVar.aQS().user_info == null || bkVar.aQS().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bkVar.aQS().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bkVar.aQS().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = bkVar.getThreadType() == 41;
                if (z4) {
                    if (bkVar.aQd() != null) {
                        str3 = bkVar.aQd().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (bkVar.dHI) {
                        z = true;
                        str = bkVar.getId();
                        i2 = 14;
                    }
                    if (bkVar.dHU) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bkVar.dHV;
                        i3 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bkVar.dDb, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.ag("list_order", c.caY().a(bVar));
                        a(a, bkVar, tbPageTag);
                        if (z3) {
                            a.ag("obj_isofficial", bkVar.aQS().user_info.is_official);
                        }
                        if (z3 || bkVar.dHI || bkVar.dHU) {
                            a.delete("thread_type");
                            a.ag("thread_type", bkVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.dcI().b(bdUniqueId, a);
                        d(bkVar, i);
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i2 = i4;
            str = str3;
            z = z6;
            if (bkVar.dHI) {
            }
            if (bkVar.dHU) {
            }
            a = com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bkVar.dDb, z2, str2, (String) null, i3);
            if (a == null) {
            }
        }
    }

    private static void d(bk bkVar, int i) {
        an anVar = null;
        switch (i) {
            case 2:
                anVar = com.baidu.tieba.s.a.a("c13692", bkVar, 2);
                break;
        }
        TiebaStatic.log(anVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bk bkVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        boolean z2;
        int i2;
        String str2;
        an a;
        if (bkVar != null) {
            String str3 = null;
            int i3 = 0;
            boolean z3 = (bkVar.aQS() == null || bkVar.aQS().user_info == null || bkVar.aQS().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bkVar.aQS().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bkVar.aQS().live_id);
                i3 = 4;
            }
            if (!z4) {
                z4 = bkVar.getThreadType() == 41;
                if (z4) {
                    if (bkVar.aQd() != null) {
                        str3 = bkVar.aQd().getTaskId();
                    }
                    boolean z5 = z4;
                    i = 2;
                    str = str3;
                    z = z5;
                    if (bkVar.dHI) {
                        z = true;
                        str = bkVar.getId();
                        i = 14;
                    }
                    if (bkVar.dHU) {
                        z2 = z;
                        i2 = i;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bkVar.dHV;
                        i2 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.FRS, "common_exp", bkVar.dDb, z2, str2, (String) null, i2);
                    if (a == null) {
                        a.ag("list_order", c.caY().a(bVar));
                        a(a, bkVar, tbPageTag);
                        if (z3) {
                            a.ag("obj_isofficial", bkVar.aQS().user_info.is_official);
                        }
                        if (z3 || bkVar.dHI || bkVar.dHU) {
                            a.delete("thread_type");
                            a.ag("thread_type", bkVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.dcI().a(bdUniqueId, com.baidu.tieba.s.a.a(bkVar.getTid(), str2, "", bkVar.getBaijiahaoData()), a);
                        if (bkVar.dHI) {
                            a(bkVar, bdUniqueId, tbPageTag);
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
            if (bkVar.dHI) {
            }
            if (bkVar.dHU) {
            }
            a = com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.FRS, "common_exp", bkVar.dDb, z2, str2, (String) null, i2);
            if (a == null) {
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<o> list, ForumData forumData, int i) {
        if (!v.isEmpty(list)) {
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
            an b = com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!aq.isEmpty(forumData.getId())) {
                    b.dh("fid", forumData.getId());
                }
                if (!aq.isEmpty(forumData.getName())) {
                    b.dh("fname", forumData.getName());
                }
                if (!aq.isEmpty(forumData.getFirst_class())) {
                    b.dh("first_dir", forumData.getFirst_class());
                }
                if (!aq.isEmpty(forumData.getSecond_class())) {
                    b.dh("second_dir", forumData.getSecond_class());
                }
            }
            b.ag("list_order", i2);
            com.baidu.tieba.s.c.dcI().b(bdUniqueId, b);
        }
    }

    public static void a(bk bkVar, TbPageTag tbPageTag) {
        if (bkVar != null) {
            an dh = new an("common_click").dh("page_type", PageStayDurationConstants.PageName.FRS).ag("obj_isad", 1).ag("obj_adlocate", 15).dh("obj_id", bkVar.getId()).s("fid", bkVar.getFid()).ag("obj_floor", bkVar.dDb).dh("tid", bkVar.getId()).ag("thread_type", bkVar.getThreadType()).dh("first_dir", bkVar.aSh()).dh("second_dir", bkVar.aSi()).dh("nid", bkVar.getNid());
            a(dh, bkVar, tbPageTag);
            TiebaStatic.log(dh);
        }
    }

    private static void a(bk bkVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bkVar != null && bdUniqueId != null && bkVar.dHI) {
            boolean z = (bkVar.aQx() == null || bkVar.aQx().getUserId() == null || !bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bkVar.aRN() && bkVar.getFeedBackReasonMap() != null && !z) {
                an dh = new an("common_exp").dh("page_type", PageStayDurationConstants.PageName.FRS).ag("obj_isad", 1).ag("obj_adlocate", 15).dh("obj_id", bkVar.getId()).ag("obj_floor", bkVar.dDb).s("fid", bkVar.getFid()).ag("thread_type", bkVar.getThreadType()).dh("tid", bkVar.getId()).dh("first_dir", bkVar.aSh()).dh("second_dir", bkVar.aSi());
                a(dh, bkVar, tbPageTag);
                com.baidu.tieba.s.c.dcI().a(bdUniqueId, com.baidu.tieba.s.a.a(bkVar.getTid(), "", "", bkVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dh);
            }
        }
    }

    private static void a(an anVar, bk bkVar, TbPageTag tbPageTag) {
        if (!aq.isEmpty(bkVar.mRecomWeight)) {
            anVar.dh("recom_weight", bkVar.mRecomWeight);
        }
        if (!aq.isEmpty(bkVar.mRecomExtra)) {
            anVar.dh("recom_extra", bkVar.mRecomExtra);
        }
        if (!aq.isEmpty(bkVar.mRecomSource)) {
            anVar.dh(IntentConfig.RECOM_SOURCE, bkVar.mRecomSource);
        }
        if (!aq.isEmpty(bkVar.mRecomAbTag)) {
            anVar.dh("recom_ab_tag", bkVar.mRecomAbTag);
        }
        anVar.ag("recom_type", bkVar.aSA());
        com.baidu.tbadk.pageInfo.c.a(anVar, tbPageTag);
    }
}

package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageInfo.TbPageTag;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bj bjVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        boolean z2;
        int i3;
        String str2;
        an a;
        if (bjVar != null) {
            String str3 = null;
            int i4 = 0;
            boolean z3 = (bjVar.azX() == null || bjVar.azX().user_info == null || bjVar.azX().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bjVar.azX().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bjVar.azX().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = bjVar.getThreadType() == 41;
                if (z4) {
                    if (bjVar.azj() != null) {
                        str3 = bjVar.azj().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (bjVar.cPZ) {
                        z = true;
                        str = bjVar.getId();
                        i2 = 14;
                    }
                    if (bjVar.cQl) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bjVar.cQm;
                        i3 = 17;
                    }
                    a = com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bjVar.cLr, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.Z("list_order", c.bHd().a(bVar));
                        a(a, bjVar, tbPageTag);
                        if (z3) {
                            a.Z("obj_isofficial", bjVar.azX().user_info.is_official);
                        }
                        if (z3 || bjVar.cPZ || bjVar.cQl) {
                            a.delete("thread_type");
                            a.Z("thread_type", bjVar.getThreadType());
                        }
                        com.baidu.tieba.r.c.cHo().b(bdUniqueId, a);
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i2 = i4;
            str = str3;
            z = z6;
            if (bjVar.cPZ) {
            }
            if (bjVar.cQl) {
            }
            a = com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bjVar.cLr, z2, str2, (String) null, i3);
            if (a == null) {
            }
        }
    }

    public static void a(bj bjVar, BdUniqueId bdUniqueId, b bVar, int i, TbPageTag tbPageTag) {
        an a;
        if (bjVar != null && (a = com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_exp", i, false, null, null)) != null) {
            a.Z("list_order", c.bHd().a(bVar));
            a(a, bjVar, tbPageTag);
            com.baidu.tieba.r.c.cHo().a(bdUniqueId, com.baidu.tieba.r.a.a(bjVar.getTid(), "", "", bjVar.getBaijiahaoData()), a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bj bjVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        boolean z2;
        int i2;
        String str2;
        an a;
        if (bjVar != null) {
            String str3 = null;
            int i3 = 0;
            boolean z3 = (bjVar.azX() == null || bjVar.azX().user_info == null || bjVar.azX().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bjVar.azX().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bjVar.azX().live_id);
                i3 = 4;
            }
            if (!z4) {
                z4 = bjVar.getThreadType() == 41;
                if (z4) {
                    if (bjVar.azj() != null) {
                        str3 = bjVar.azj().getTaskId();
                    }
                    boolean z5 = z4;
                    i = 2;
                    str = str3;
                    z = z5;
                    if (bjVar.cPZ) {
                        z = true;
                        str = bjVar.getId();
                        i = 14;
                    }
                    if (bjVar.cQl) {
                        z2 = z;
                        i2 = i;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bjVar.cQm;
                        i2 = 17;
                    }
                    a = com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_exp", bjVar.cLr, z2, str2, (String) null, i2);
                    if (a == null) {
                        a.Z("list_order", c.bHd().a(bVar));
                        a(a, bjVar, tbPageTag);
                        if (z3) {
                            a.Z("obj_isofficial", bjVar.azX().user_info.is_official);
                        }
                        if (z3 || bjVar.cPZ || bjVar.cQl) {
                            a.delete("thread_type");
                            a.Z("thread_type", bjVar.getThreadType());
                        }
                        com.baidu.tieba.r.c.cHo().a(bdUniqueId, com.baidu.tieba.r.a.a(bjVar.getTid(), str2, "", bjVar.getBaijiahaoData()), a);
                        if (bjVar.cPZ) {
                            a(bjVar, bdUniqueId, tbPageTag);
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
            if (bjVar.cPZ) {
            }
            if (bjVar.cQl) {
            }
            a = com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_exp", bjVar.cLr, z2, str2, (String) null, i2);
            if (a == null) {
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<m> list, ForumData forumData, int i) {
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
            an b = com.baidu.tieba.r.a.b(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!aq.isEmpty(forumData.getId())) {
                    b.cp("fid", forumData.getId());
                }
                if (!aq.isEmpty(forumData.getName())) {
                    b.cp("fname", forumData.getName());
                }
                if (!aq.isEmpty(forumData.getFirst_class())) {
                    b.cp("first_dir", forumData.getFirst_class());
                }
                if (!aq.isEmpty(forumData.getSecond_class())) {
                    b.cp("second_dir", forumData.getSecond_class());
                }
            }
            b.Z("list_order", i2);
            com.baidu.tieba.r.c.cHo().b(bdUniqueId, b);
        }
    }

    public static void a(bj bjVar, TbPageTag tbPageTag) {
        if (bjVar != null) {
            an cp = new an("common_click").cp("page_type", PageStayDurationConstants.PageName.FRS).Z("obj_isad", 1).Z("obj_adlocate", 15).cp("obj_id", bjVar.getId()).s("fid", bjVar.getFid()).Z("obj_floor", bjVar.cLr).cp("tid", bjVar.getId()).Z("thread_type", bjVar.getThreadType()).cp("first_dir", bjVar.aBk()).cp("second_dir", bjVar.aBl());
            a(cp, bjVar, tbPageTag);
            TiebaStatic.log(cp);
        }
    }

    private static void a(bj bjVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bjVar != null && bdUniqueId != null && bjVar.cPZ) {
            boolean z = (bjVar.azE() == null || bjVar.azE().getUserId() == null || !bjVar.azE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.aAR() && bjVar.getFeedBackReasonMap() != null && !z) {
                an cp = new an("common_exp").cp("page_type", PageStayDurationConstants.PageName.FRS).Z("obj_isad", 1).Z("obj_adlocate", 15).cp("obj_id", bjVar.getId()).Z("obj_floor", bjVar.cLr).s("fid", bjVar.getFid()).Z("thread_type", bjVar.getThreadType()).cp("tid", bjVar.getId()).cp("first_dir", bjVar.aBk()).cp("second_dir", bjVar.aBl());
                a(cp, bjVar, tbPageTag);
                com.baidu.tieba.r.c.cHo().a(bdUniqueId, com.baidu.tieba.r.a.a(bjVar.getTid(), "", "", bjVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, cp);
            }
        }
    }

    private static void a(an anVar, bj bjVar, TbPageTag tbPageTag) {
        if (!aq.isEmpty(bjVar.mRecomWeight)) {
            anVar.cp("recom_weight", bjVar.mRecomWeight);
        }
        if (!aq.isEmpty(bjVar.mRecomExtra)) {
            anVar.cp("recom_extra", bjVar.mRecomExtra);
        }
        if (!aq.isEmpty(bjVar.mRecomSource)) {
            anVar.cp("recom_source", bjVar.mRecomSource);
        }
        if (!aq.isEmpty(bjVar.mRecomAbTag)) {
            anVar.cp("recom_ab_tag", bjVar.mRecomAbTag);
        }
        anVar.Z("recom_type", bjVar.aBF());
        com.baidu.tbadk.pageInfo.c.a(anVar, tbPageTag);
    }
}

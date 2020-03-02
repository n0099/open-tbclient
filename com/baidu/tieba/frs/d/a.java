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
/* loaded from: classes9.dex */
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
            boolean z3 = (bjVar.aCH() == null || bjVar.aCH().user_info == null || bjVar.aCH().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bjVar.aCH().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bjVar.aCH().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = bjVar.getThreadType() == 41;
                if (z4) {
                    if (bjVar.aBU() != null) {
                        str3 = bjVar.aBU().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (bjVar.cUm) {
                        z = true;
                        str = bjVar.getId();
                        i2 = 14;
                    }
                    if (bjVar.cUy) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bjVar.cUz;
                        i3 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bjVar.cPF, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.X("list_order", c.bJJ().a(bVar));
                        a(a, bjVar, tbPageTag);
                        if (z3) {
                            a.X("obj_isofficial", bjVar.aCH().user_info.is_official);
                        }
                        if (z3 || bjVar.cUm || bjVar.cUy) {
                            a.delete("thread_type");
                            a.X("thread_type", bjVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.cKa().b(bdUniqueId, a);
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i2 = i4;
            str = str3;
            z = z6;
            if (bjVar.cUm) {
            }
            if (bjVar.cUy) {
            }
            a = com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bjVar.cPF, z2, str2, (String) null, i3);
            if (a == null) {
            }
        }
    }

    public static void a(bj bjVar, BdUniqueId bdUniqueId, b bVar, int i, TbPageTag tbPageTag) {
        an a;
        if (bjVar != null && (a = com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_exp", i, false, null, null)) != null) {
            a.X("list_order", c.bJJ().a(bVar));
            a(a, bjVar, tbPageTag);
            com.baidu.tieba.s.c.cKa().a(bdUniqueId, com.baidu.tieba.s.a.a(bjVar.getTid(), "", "", bjVar.getBaijiahaoData()), a);
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
            boolean z3 = (bjVar.aCH() == null || bjVar.aCH().user_info == null || bjVar.aCH().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bjVar.aCH().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(bjVar.aCH().live_id);
                i3 = 4;
            }
            if (!z4) {
                z4 = bjVar.getThreadType() == 41;
                if (z4) {
                    if (bjVar.aBU() != null) {
                        str3 = bjVar.aBU().getTaskId();
                    }
                    boolean z5 = z4;
                    i = 2;
                    str = str3;
                    z = z5;
                    if (bjVar.cUm) {
                        z = true;
                        str = bjVar.getId();
                        i = 14;
                    }
                    if (bjVar.cUy) {
                        z2 = z;
                        i2 = i;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = bjVar.cUz;
                        i2 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_exp", bjVar.cPF, z2, str2, (String) null, i2);
                    if (a == null) {
                        a.X("list_order", c.bJJ().a(bVar));
                        a(a, bjVar, tbPageTag);
                        if (z3) {
                            a.X("obj_isofficial", bjVar.aCH().user_info.is_official);
                        }
                        if (z3 || bjVar.cUm || bjVar.cUy) {
                            a.delete("thread_type");
                            a.X("thread_type", bjVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.cKa().a(bdUniqueId, com.baidu.tieba.s.a.a(bjVar.getTid(), str2, "", bjVar.getBaijiahaoData()), a);
                        if (bjVar.cUm) {
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
            if (bjVar.cUm) {
            }
            if (bjVar.cUy) {
            }
            a = com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.FRS, "common_exp", bjVar.cPF, z2, str2, (String) null, i2);
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
            an b = com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!aq.isEmpty(forumData.getId())) {
                    b.cy("fid", forumData.getId());
                }
                if (!aq.isEmpty(forumData.getName())) {
                    b.cy("fname", forumData.getName());
                }
                if (!aq.isEmpty(forumData.getFirst_class())) {
                    b.cy("first_dir", forumData.getFirst_class());
                }
                if (!aq.isEmpty(forumData.getSecond_class())) {
                    b.cy("second_dir", forumData.getSecond_class());
                }
            }
            b.X("list_order", i2);
            com.baidu.tieba.s.c.cKa().b(bdUniqueId, b);
        }
    }

    public static void a(bj bjVar, TbPageTag tbPageTag) {
        if (bjVar != null) {
            an cy = new an("common_click").cy("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).X("obj_adlocate", 15).cy("obj_id", bjVar.getId()).s("fid", bjVar.getFid()).X("obj_floor", bjVar.cPF).cy("tid", bjVar.getId()).X("thread_type", bjVar.getThreadType()).cy("first_dir", bjVar.aDS()).cy("second_dir", bjVar.aDT());
            a(cy, bjVar, tbPageTag);
            TiebaStatic.log(cy);
        }
    }

    private static void a(bj bjVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (bjVar != null && bdUniqueId != null && bjVar.cUm) {
            boolean z = (bjVar.aCo() == null || bjVar.aCo().getUserId() == null || !bjVar.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.aDz() && bjVar.getFeedBackReasonMap() != null && !z) {
                an cy = new an("common_exp").cy("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).X("obj_adlocate", 15).cy("obj_id", bjVar.getId()).X("obj_floor", bjVar.cPF).s("fid", bjVar.getFid()).X("thread_type", bjVar.getThreadType()).cy("tid", bjVar.getId()).cy("first_dir", bjVar.aDS()).cy("second_dir", bjVar.aDT());
                a(cy, bjVar, tbPageTag);
                com.baidu.tieba.s.c.cKa().a(bdUniqueId, com.baidu.tieba.s.a.a(bjVar.getTid(), "", "", bjVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, cy);
            }
        }
    }

    private static void a(an anVar, bj bjVar, TbPageTag tbPageTag) {
        if (!aq.isEmpty(bjVar.mRecomWeight)) {
            anVar.cy("recom_weight", bjVar.mRecomWeight);
        }
        if (!aq.isEmpty(bjVar.mRecomExtra)) {
            anVar.cy("recom_extra", bjVar.mRecomExtra);
        }
        if (!aq.isEmpty(bjVar.mRecomSource)) {
            anVar.cy("recom_source", bjVar.mRecomSource);
        }
        if (!aq.isEmpty(bjVar.mRecomAbTag)) {
            anVar.cy("recom_ab_tag", bjVar.mRecomAbTag);
        }
        anVar.X("recom_type", bjVar.aEl());
        com.baidu.tbadk.pageInfo.c.a(anVar, tbPageTag);
    }
}

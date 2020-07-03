package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
    public static void a(bu buVar, int i, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i2;
        String str;
        boolean z;
        boolean z2;
        int i3;
        String str2;
        ao a;
        if (buVar != null) {
            String str3 = null;
            int i4 = 0;
            boolean z3 = (buVar.aSJ() == null || buVar.aSJ().user_info == null || buVar.aSJ().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && buVar.aSJ().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(buVar.aSJ().live_id);
                i4 = 4;
            }
            if (!z4) {
                z4 = buVar.getThreadType() == 41;
                if (z4) {
                    if (buVar.aRV() != null) {
                        str3 = buVar.aRV().getTaskId();
                    }
                    boolean z5 = z4;
                    i2 = 2;
                    str = str3;
                    z = z5;
                    if (buVar.dOu) {
                        z = true;
                        str = buVar.getId();
                        i2 = 14;
                    }
                    if (buVar.dOG) {
                        z2 = z;
                        i3 = i2;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = buVar.dOH;
                        i3 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.FRS, "common_click", i, buVar.dJw, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.ag("list_order", c.ceq().a(bVar));
                        a(a, buVar, tbPageTag);
                        if (z3) {
                            a.ag("obj_isofficial", buVar.aSJ().user_info.is_official);
                        }
                        if (z3 || buVar.dOu || buVar.dOG) {
                            a.delete("thread_type");
                            a.ag("thread_type", buVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.dgX().b(bdUniqueId, a);
                        d(buVar, i);
                        return;
                    }
                    return;
                }
            }
            boolean z6 = z4;
            i2 = i4;
            str = str3;
            z = z6;
            if (buVar.dOu) {
            }
            if (buVar.dOG) {
            }
            a = com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.FRS, "common_click", i, buVar.dJw, z2, str2, (String) null, i3);
            if (a == null) {
            }
        }
    }

    private static void d(bu buVar, int i) {
        ao aoVar = null;
        switch (i) {
            case 2:
                aoVar = com.baidu.tieba.s.a.a("c13692", buVar, 2);
                break;
        }
        TiebaStatic.log(aoVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bu buVar, BdUniqueId bdUniqueId, b bVar, TbPageTag tbPageTag) {
        int i;
        String str;
        boolean z;
        boolean z2;
        int i2;
        String str2;
        ao a;
        if (buVar != null) {
            String str3 = null;
            int i3 = 0;
            boolean z3 = (buVar.aSJ() == null || buVar.aSJ().user_info == null || buVar.aSJ().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && buVar.aSJ().frsLiveStageType == 0;
            if (z4) {
                str3 = String.valueOf(buVar.aSJ().live_id);
                i3 = 4;
            }
            if (!z4) {
                z4 = buVar.getThreadType() == 41;
                if (z4) {
                    if (buVar.aRV() != null) {
                        str3 = buVar.aRV().getTaskId();
                    }
                    boolean z5 = z4;
                    i = 2;
                    str = str3;
                    z = z5;
                    if (buVar.dOu) {
                        z = true;
                        str = buVar.getId();
                        i = 14;
                    }
                    if (buVar.dOG) {
                        z2 = z;
                        i2 = i;
                        str2 = str;
                    } else {
                        z2 = true;
                        str2 = buVar.dOH;
                        i2 = 17;
                    }
                    a = com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.FRS, "common_exp", buVar.dJw, z2, str2, (String) null, i2);
                    if (a == null) {
                        a.ag("list_order", c.ceq().a(bVar));
                        a(a, buVar, tbPageTag);
                        if (z3) {
                            a.ag("obj_isofficial", buVar.aSJ().user_info.is_official);
                        }
                        if (z3 || buVar.dOu || buVar.dOG) {
                            a.delete("thread_type");
                            a.ag("thread_type", buVar.getThreadType());
                        }
                        com.baidu.tieba.s.c.dgX().a(bdUniqueId, com.baidu.tieba.s.a.a(buVar.getTid(), str2, "", buVar.getBaijiahaoData()), a);
                        if (buVar.dOu) {
                            a(buVar, bdUniqueId, tbPageTag);
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
            if (buVar.dOu) {
            }
            if (buVar.dOG) {
            }
            a = com.baidu.tieba.s.a.a(buVar, PageStayDurationConstants.PageName.FRS, "common_exp", buVar.dJw, z2, str2, (String) null, i2);
            if (a == null) {
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<q> list, ForumData forumData, int i) {
        if (!w.isEmpty(list)) {
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
            ao b = com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!ar.isEmpty(forumData.getId())) {
                    b.dk("fid", forumData.getId());
                }
                if (!ar.isEmpty(forumData.getName())) {
                    b.dk("fname", forumData.getName());
                }
                if (!ar.isEmpty(forumData.getFirst_class())) {
                    b.dk("first_dir", forumData.getFirst_class());
                }
                if (!ar.isEmpty(forumData.getSecond_class())) {
                    b.dk("second_dir", forumData.getSecond_class());
                }
            }
            b.ag("list_order", i2);
            com.baidu.tieba.s.c.dgX().b(bdUniqueId, b);
        }
    }

    public static void a(bu buVar, TbPageTag tbPageTag) {
        if (buVar != null) {
            ao dk = new ao("common_click").dk("page_type", PageStayDurationConstants.PageName.FRS).ag("obj_isad", 1).ag("obj_adlocate", 15).dk("obj_id", buVar.getId()).s("fid", buVar.getFid()).ag("obj_floor", buVar.dJw).dk("tid", buVar.getId()).ag("thread_type", buVar.getThreadType()).dk("first_dir", buVar.aTX()).dk("second_dir", buVar.aTY()).dk("nid", buVar.getNid());
            a(dk, buVar, tbPageTag);
            TiebaStatic.log(dk);
        }
    }

    private static void a(bu buVar, BdUniqueId bdUniqueId, TbPageTag tbPageTag) {
        if (buVar != null && bdUniqueId != null && buVar.dOu) {
            boolean z = (buVar.aSp() == null || buVar.aSp().getUserId() == null || !buVar.aSp().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (buVar.aTE() && buVar.getFeedBackReasonMap() != null && !z) {
                ao dk = new ao("common_exp").dk("page_type", PageStayDurationConstants.PageName.FRS).ag("obj_isad", 1).ag("obj_adlocate", 15).dk("obj_id", buVar.getId()).ag("obj_floor", buVar.dJw).s("fid", buVar.getFid()).ag("thread_type", buVar.getThreadType()).dk("tid", buVar.getId()).dk("first_dir", buVar.aTX()).dk("second_dir", buVar.aTY());
                a(dk, buVar, tbPageTag);
                com.baidu.tieba.s.c.dgX().a(bdUniqueId, com.baidu.tieba.s.a.a(buVar.getTid(), "", "", buVar.getBaijiahaoData()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + 15, dk);
            }
        }
    }

    private static void a(ao aoVar, bu buVar, TbPageTag tbPageTag) {
        if (!ar.isEmpty(buVar.mRecomWeight)) {
            aoVar.dk("recom_weight", buVar.mRecomWeight);
        }
        if (!ar.isEmpty(buVar.mRecomExtra)) {
            aoVar.dk("recom_extra", buVar.mRecomExtra);
        }
        if (!ar.isEmpty(buVar.mRecomSource)) {
            aoVar.dk(IntentConfig.RECOM_SOURCE, buVar.mRecomSource);
        }
        if (!ar.isEmpty(buVar.mRecomAbTag)) {
            aoVar.dk("recom_ab_tag", buVar.mRecomAbTag);
        }
        aoVar.ag("recom_type", buVar.aUp());
        com.baidu.tbadk.pageInfo.c.a(aoVar, tbPageTag);
    }
}

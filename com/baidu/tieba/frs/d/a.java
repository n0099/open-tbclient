package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static BdUniqueId fQA;

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bh bhVar, int i, BdUniqueId bdUniqueId, b bVar) {
        int i2;
        String str;
        String str2;
        boolean z;
        int i3;
        int i4;
        an a;
        boolean z2 = true;
        if (bhVar != null) {
            boolean z3 = (bhVar.aiZ() == null || bhVar.aiZ().user_info == null || bhVar.aiZ().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bhVar.aiZ().frsLiveStageType == 0;
            if (z4) {
                str = String.valueOf(bhVar.aiZ().live_id);
                i2 = 4;
            } else {
                i2 = 0;
                str = null;
            }
            if (!z4) {
                z4 = bhVar.getThreadType() == 41;
                if (z4) {
                    if (bhVar.aim() != null) {
                        str = bhVar.aim().getTaskId();
                    }
                    str2 = str;
                    z = z4;
                    i3 = 2;
                    if (bhVar.ceC) {
                        z2 = z;
                        i4 = i3;
                    } else {
                        i4 = 14;
                    }
                    a = com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bhVar.cez, z2, str2, (String) null, i4);
                    if (a == null) {
                        a.O("list_order", c.bpJ().a(bVar));
                        if (z3) {
                            a.O("obj_isofficial", bhVar.aiZ().user_info.is_official);
                            a.delete("thread_type");
                            a.O("thread_type", bhVar.getThreadType());
                        }
                        com.baidu.tieba.q.c.cnk().b(bdUniqueId, a);
                        return;
                    }
                    return;
                }
            }
            str2 = str;
            z = z4;
            i3 = i2;
            if (bhVar.ceC) {
            }
            a = com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.FRS, "common_click", i, bhVar.cez, z2, str2, (String) null, i4);
            if (a == null) {
            }
        }
    }

    public static void a(bh bhVar, BdUniqueId bdUniqueId, b bVar, int i) {
        an a;
        if (bhVar != null && (a = com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.FRS, "common_exp", i, false, null, null)) != null) {
            a.O("list_order", c.bpJ().a(bVar));
            com.baidu.tieba.q.c.cnk().a(bdUniqueId, bhVar.getId(), a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bh bhVar, BdUniqueId bdUniqueId, b bVar) {
        int i;
        String str;
        String str2;
        boolean z;
        int i2;
        int i3;
        an a;
        boolean z2 = true;
        if (bhVar != null) {
            boolean z3 = (bhVar.aiZ() == null || bhVar.aiZ().user_info == null || bhVar.aiZ().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bhVar.aiZ().frsLiveStageType == 0;
            if (z4) {
                str = String.valueOf(bhVar.aiZ().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z4) {
                z4 = bhVar.getThreadType() == 41;
                if (z4) {
                    if (bhVar.aim() != null) {
                        str = bhVar.aim().getTaskId();
                    }
                    str2 = str;
                    z = z4;
                    i2 = 2;
                    if (bhVar.ceC) {
                        z2 = z;
                        i3 = i2;
                    } else {
                        i3 = 14;
                    }
                    a = com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.FRS, "common_exp", bhVar.cez, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.O("list_order", c.bpJ().a(bVar));
                        if (z3) {
                            a.O("obj_isofficial", bhVar.aiZ().user_info.is_official);
                            a.delete("thread_type");
                            a.O("thread_type", bhVar.getThreadType());
                        }
                        if (bhVar.ceC) {
                            a(bhVar, bdUniqueId, a);
                            return;
                        } else {
                            com.baidu.tieba.q.c.cnk().a(bdUniqueId, bhVar.getId(), a);
                            return;
                        }
                    }
                    return;
                }
            }
            str2 = str;
            z = z4;
            i2 = i;
            if (bhVar.ceC) {
            }
            a = com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.FRS, "common_exp", bhVar.cez, z2, str2, (String) null, i3);
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
            an b = com.baidu.tieba.q.a.b(PageStayDurationConstants.PageName.FRS, "common_fill", true, i, i3);
            if (forumData != null) {
                if (!aq.isEmpty(forumData.getId())) {
                    b.bS("fid", forumData.getId());
                }
                if (!aq.isEmpty(forumData.getName())) {
                    b.bS("fname", forumData.getName());
                }
                if (!aq.isEmpty(forumData.getFirst_class())) {
                    b.bS("first_dir", forumData.getFirst_class());
                }
                if (!aq.isEmpty(forumData.getSecond_class())) {
                    b.bS("second_dir", forumData.getSecond_class());
                }
            }
            b.O("list_order", i2);
            com.baidu.tieba.q.c.cnk().b(bdUniqueId, b);
        }
    }

    public static void cO(String str, String str2) {
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new an("common_click").bS("page_type", PageStayDurationConstants.PageName.FRS).O("obj_isad", 1).O("obj_adlocate", 15).bS("obj_id", str).bS("fid", str2));
        }
    }

    private static void a(bh bhVar, BdUniqueId bdUniqueId, an anVar) {
        if (bhVar != null && bdUniqueId != null && anVar != null) {
            if (fQA != bdUniqueId) {
                TiebaStatic.log(anVar);
                boolean z = (bhVar.aiG() == null || bhVar.aiG().getUserId() == null || !bhVar.aiG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
                if (bhVar.ajO() && bhVar.getFeedBackReasonMap() != null && !z) {
                    TiebaStatic.log(new an("common_exp").bS("page_type", PageStayDurationConstants.PageName.FRS).O("obj_isad", 1).O("obj_adlocate", 15).bS("obj_id", bhVar.getId()).p("fid", bhVar.getFid()));
                }
            }
            fQA = bdUniqueId;
        }
    }
}

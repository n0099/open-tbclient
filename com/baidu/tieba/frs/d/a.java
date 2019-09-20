package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static BdUniqueId fRh;

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
            boolean z3 = (bhVar.aeV() == null || bhVar.aeV().user_info == null || bhVar.aeV().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bhVar.aeV().frsLiveStageType == 0;
            if (z4) {
                str = String.valueOf(bhVar.aeV().live_id);
                i2 = 4;
            } else {
                i2 = 0;
                str = null;
            }
            if (!z4) {
                z4 = bhVar.getThreadType() == 41;
                if (z4) {
                    if (bhVar.aei() != null) {
                        str = bhVar.aei().getTaskId();
                    }
                    str2 = str;
                    z = z4;
                    i3 = 2;
                    if (bhVar.bMT) {
                        z2 = z;
                        i4 = i3;
                    } else {
                        i4 = 14;
                    }
                    a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_click", i, bhVar.bMQ, z2, str2, (String) null, i4);
                    if (a == null) {
                        a.P("list_order", c.bsF().a(bVar));
                        if (z3) {
                            a.P("obj_isofficial", bhVar.aeV().user_info.is_official);
                            a.nX("thread_type");
                            a.P("thread_type", bhVar.getThreadType());
                        }
                        com.baidu.tieba.q.c.cpt().b(bdUniqueId, a);
                        return;
                    }
                    return;
                }
            }
            str2 = str;
            z = z4;
            i3 = i2;
            if (bhVar.bMT) {
            }
            a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_click", i, bhVar.bMQ, z2, str2, (String) null, i4);
            if (a == null) {
            }
        }
    }

    public static void a(bh bhVar, BdUniqueId bdUniqueId, b bVar, int i) {
        an a;
        if (bhVar != null && (a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_exp", i, false, null, null)) != null) {
            a.P("list_order", c.bsF().a(bVar));
            com.baidu.tieba.q.c.cpt().a(bdUniqueId, bhVar.getId(), a);
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
            boolean z3 = (bhVar.aeV() == null || bhVar.aeV().user_info == null || bhVar.aeV().user_info.is_official != 2) ? false : true;
            boolean z4 = z3 && bhVar.aeV().frsLiveStageType == 0;
            if (z4) {
                str = String.valueOf(bhVar.aeV().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z4) {
                z4 = bhVar.getThreadType() == 41;
                if (z4) {
                    if (bhVar.aei() != null) {
                        str = bhVar.aei().getTaskId();
                    }
                    str2 = str;
                    z = z4;
                    i2 = 2;
                    if (bhVar.bMT) {
                        z2 = z;
                        i3 = i2;
                    } else {
                        i3 = 14;
                    }
                    a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_exp", bhVar.bMQ, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.P("list_order", c.bsF().a(bVar));
                        if (z3) {
                            a.P("obj_isofficial", bhVar.aeV().user_info.is_official);
                            a.nX("thread_type");
                            a.P("thread_type", bhVar.getThreadType());
                        }
                        if (bhVar.bMT) {
                            a(bhVar, bdUniqueId, a);
                            return;
                        } else {
                            com.baidu.tieba.q.c.cpt().a(bdUniqueId, bhVar.getId(), a);
                            return;
                        }
                    }
                    return;
                }
            }
            str2 = str;
            z = z4;
            i2 = i;
            if (bhVar.bMT) {
            }
            a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_exp", bhVar.bMQ, z2, str2, (String) null, i3);
            if (a == null) {
            }
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<m> list, ForumData forumData, int i) {
        if (!v.aa(list)) {
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
            an b = com.baidu.tieba.q.a.b("a006", "common_fill", true, i, i3);
            if (forumData != null) {
                if (!aq.isEmpty(forumData.getId())) {
                    b.bT("fid", forumData.getId());
                }
                if (!aq.isEmpty(forumData.getName())) {
                    b.bT(ImageViewerConfig.FORUM_NAME, forumData.getName());
                }
                if (!aq.isEmpty(forumData.getFirst_class())) {
                    b.bT("first_dir", forumData.getFirst_class());
                }
                if (!aq.isEmpty(forumData.getSecond_class())) {
                    b.bT("second_dir", forumData.getSecond_class());
                }
            }
            b.P("list_order", i2);
            com.baidu.tieba.q.c.cpt().b(bdUniqueId, b);
        }
    }

    public static void dd(String str, String str2) {
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new an("common_click").bT("page_type", "a006").P("obj_isad", 1).P("obj_adlocate", 15).bT(VideoPlayActivityConfig.OBJ_ID, str).bT("fid", str2));
        }
    }

    private static void a(bh bhVar, BdUniqueId bdUniqueId, an anVar) {
        if (bhVar != null && bdUniqueId != null && anVar != null) {
            if (fRh != bdUniqueId) {
                TiebaStatic.log(anVar);
                boolean z = (bhVar.aeC() == null || bhVar.aeC().getUserId() == null || !bhVar.aeC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
                if (bhVar.afL() && bhVar.adl() != null && !z) {
                    TiebaStatic.log(new an("common_exp").bT("page_type", "a006").P("obj_isad", 1).P("obj_adlocate", 15).bT(VideoPlayActivityConfig.OBJ_ID, bhVar.getId()).n("fid", bhVar.getFid()));
                }
            }
            fRh = bdUniqueId;
        }
    }
}

package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bh bhVar, int i, BdUniqueId bdUniqueId, b bVar) {
        int i2;
        String str;
        String str2;
        an a;
        int i3 = 2;
        if (bhVar != null) {
            boolean z = (bhVar.aeR() == null || bhVar.aeR().user_info == null || bhVar.aeR().user_info.is_official != 2) ? false : true;
            boolean z2 = z && bhVar.aeR().frsLiveStageType == 0;
            if (z2) {
                str = String.valueOf(bhVar.aeR().live_id);
                i2 = 4;
            } else {
                i2 = 0;
                str = null;
            }
            if (!z2) {
                z2 = bhVar.getThreadType() == 41;
                if (z2) {
                    if (bhVar.aee() != null) {
                        str = bhVar.aee().getTaskId();
                    }
                    str2 = str;
                    a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_click", i, bhVar.bMs, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.P("list_order", c.brS().a(bVar));
                        if (z) {
                            a.P("obj_isofficial", bhVar.aeR().user_info.is_official);
                            a.nV("thread_type");
                            a.P("thread_type", bhVar.getThreadType());
                        }
                        com.baidu.tieba.q.c.coG().b(bdUniqueId, a);
                        return;
                    }
                    return;
                }
            }
            i3 = i2;
            str2 = str;
            a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_click", i, bhVar.bMs, z2, str2, (String) null, i3);
            if (a == null) {
            }
        }
    }

    public static void a(bh bhVar, BdUniqueId bdUniqueId, b bVar, int i) {
        an a;
        if (bhVar != null && (a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_exp", i, false, null, null)) != null) {
            a.P("list_order", c.brS().a(bVar));
            com.baidu.tieba.q.c.coG().a(bdUniqueId, bhVar.getId(), a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bh bhVar, BdUniqueId bdUniqueId, b bVar) {
        int i;
        String str;
        String str2;
        an a;
        int i2 = 2;
        if (bhVar != null) {
            boolean z = (bhVar.aeR() == null || bhVar.aeR().user_info == null || bhVar.aeR().user_info.is_official != 2) ? false : true;
            boolean z2 = z && bhVar.aeR().frsLiveStageType == 0;
            if (z2) {
                str = String.valueOf(bhVar.aeR().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z2) {
                z2 = bhVar.getThreadType() == 41;
                if (z2) {
                    if (bhVar.aee() != null) {
                        str = bhVar.aee().getTaskId();
                    }
                    str2 = str;
                    a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_exp", bhVar.bMs, z2, str2, (String) null, i2);
                    if (a == null) {
                        a.P("list_order", c.brS().a(bVar));
                        if (z) {
                            a.P("obj_isofficial", bhVar.aeR().user_info.is_official);
                            a.nV("thread_type");
                            a.P("thread_type", bhVar.getThreadType());
                        }
                        com.baidu.tieba.q.c.coG().a(bdUniqueId, bhVar.getId(), a);
                        return;
                    }
                    return;
                }
            }
            i2 = i;
            str2 = str;
            a = com.baidu.tieba.q.a.a(bhVar, "a006", "common_exp", bhVar.bMs, z2, str2, (String) null, i2);
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
            com.baidu.tieba.q.c.coG().b(bdUniqueId, b);
        }
    }
}

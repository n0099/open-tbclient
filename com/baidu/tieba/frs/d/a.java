package com.baidu.tieba.frs.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bg bgVar, int i, BdUniqueId bdUniqueId, b bVar) {
        int i2;
        String str;
        String str2;
        am a;
        int i3 = 2;
        if (bgVar != null) {
            boolean z = (bgVar.adO() == null || bgVar.adO().user_info == null || bgVar.adO().user_info.is_official != 2) ? false : true;
            boolean z2 = z && bgVar.adO().frsLiveStageType == 0;
            if (z2) {
                str = String.valueOf(bgVar.adO().live_id);
                i2 = 4;
            } else {
                i2 = 0;
                str = null;
            }
            if (!z2) {
                z2 = bgVar.getThreadType() == 41;
                if (z2) {
                    if (bgVar.adb() != null) {
                        str = bgVar.adb().getTaskId();
                    }
                    str2 = str;
                    a = com.baidu.tieba.q.a.a(bgVar, "a006", "common_click", i, bgVar.bLn, z2, str2, (String) null, i3);
                    if (a == null) {
                        a.P("list_order", c.bpE().a(bVar));
                        if (z) {
                            a.P("obj_isofficial", bgVar.adO().user_info.is_official);
                            a.delete("thread_type");
                            a.P("thread_type", bgVar.getThreadType());
                        }
                        com.baidu.tieba.q.c.clw().b(bdUniqueId, a);
                        return;
                    }
                    return;
                }
            }
            i3 = i2;
            str2 = str;
            a = com.baidu.tieba.q.a.a(bgVar, "a006", "common_click", i, bgVar.bLn, z2, str2, (String) null, i3);
            if (a == null) {
            }
        }
    }

    public static void a(bg bgVar, BdUniqueId bdUniqueId, b bVar, int i) {
        am a;
        if (bgVar != null && (a = com.baidu.tieba.q.a.a(bgVar, "a006", "common_exp", i, false, null, null)) != null) {
            a.P("list_order", c.bpE().a(bVar));
            com.baidu.tieba.q.c.clw().a(bdUniqueId, bgVar.getId(), a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(bg bgVar, BdUniqueId bdUniqueId, b bVar) {
        int i;
        String str;
        String str2;
        am a;
        int i2 = 2;
        if (bgVar != null) {
            boolean z = (bgVar.adO() == null || bgVar.adO().user_info == null || bgVar.adO().user_info.is_official != 2) ? false : true;
            boolean z2 = z && bgVar.adO().frsLiveStageType == 0;
            if (z2) {
                str = String.valueOf(bgVar.adO().live_id);
                i = 4;
            } else {
                i = 0;
                str = null;
            }
            if (!z2) {
                z2 = bgVar.getThreadType() == 41;
                if (z2) {
                    if (bgVar.adb() != null) {
                        str = bgVar.adb().getTaskId();
                    }
                    str2 = str;
                    a = com.baidu.tieba.q.a.a(bgVar, "a006", "common_exp", bgVar.bLn, z2, str2, (String) null, i2);
                    if (a == null) {
                        a.P("list_order", c.bpE().a(bVar));
                        if (z) {
                            a.P("obj_isofficial", bgVar.adO().user_info.is_official);
                            a.delete("thread_type");
                            a.P("thread_type", bgVar.getThreadType());
                        }
                        com.baidu.tieba.q.c.clw().a(bdUniqueId, bgVar.getId(), a);
                        return;
                    }
                    return;
                }
            }
            i2 = i;
            str2 = str;
            a = com.baidu.tieba.q.a.a(bgVar, "a006", "common_exp", bgVar.bLn, z2, str2, (String) null, i2);
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
            am b = com.baidu.tieba.q.a.b("a006", "common_fill", true, i, i3);
            if (forumData != null) {
                if (!ap.isEmpty(forumData.getId())) {
                    b.bT("fid", forumData.getId());
                }
                if (!ap.isEmpty(forumData.getName())) {
                    b.bT(ImageViewerConfig.FORUM_NAME, forumData.getName());
                }
                if (!ap.isEmpty(forumData.getFirst_class())) {
                    b.bT("first_dir", forumData.getFirst_class());
                }
                if (!ap.isEmpty(forumData.getSecond_class())) {
                    b.bT("second_dir", forumData.getSecond_class());
                }
            }
            b.P("list_order", i2);
            com.baidu.tieba.q.c.clw().b(bdUniqueId, b);
        }
    }
}

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
    public static void a(bg bgVar, int i, BdUniqueId bdUniqueId, b bVar) {
        am a;
        if (bgVar != null && (a = com.baidu.tieba.q.a.a(bgVar, "a006", "common_click", i, bgVar.bDP, false, null, null)) != null) {
            a.T("list_order", c.bil().a(bVar));
            com.baidu.tieba.q.c.cdq().b(bdUniqueId, a);
        }
    }

    public static void a(bg bgVar, BdUniqueId bdUniqueId, b bVar, int i) {
        am a;
        if (bgVar != null && (a = com.baidu.tieba.q.a.a(bgVar, "a006", "common_exp", i, false, null, null)) != null) {
            a.T("list_order", c.bil().a(bVar));
            com.baidu.tieba.q.c.cdq().a(bdUniqueId, bgVar.getId(), a);
        }
    }

    public static void a(bg bgVar, BdUniqueId bdUniqueId, b bVar) {
        am a;
        if (bgVar != null && (a = com.baidu.tieba.q.a.a(bgVar, "a006", "common_exp", bgVar.bDP, false, null, null)) != null) {
            a.T("list_order", c.bil().a(bVar));
            com.baidu.tieba.q.c.cdq().a(bdUniqueId, bgVar.getId(), a);
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<m> list, ForumData forumData, int i) {
        if (!v.T(list)) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) instanceof com.baidu.tieba.InjectPlugin.a) {
                    i2++;
                }
            }
            if (i2 > 0) {
                am b = com.baidu.tieba.q.a.b("a006", "common_fill", true, i2);
                if (forumData != null) {
                    if (!ap.isEmpty(forumData.getId())) {
                        b.bJ(ImageViewerConfig.FORUM_ID, forumData.getId());
                    }
                    if (!ap.isEmpty(forumData.getName())) {
                        b.bJ(ImageViewerConfig.FORUM_NAME, forumData.getName());
                    }
                    if (!ap.isEmpty(forumData.getFirst_class())) {
                        b.bJ("first_dir", forumData.getFirst_class());
                    }
                    if (!ap.isEmpty(forumData.getSecond_class())) {
                        b.bJ("second_dir", forumData.getSecond_class());
                    }
                }
                b.T("list_order", i);
                com.baidu.tieba.q.c.cdq().b(bdUniqueId, b);
            }
        }
    }
}

package com.baidu.tieba.frs.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static void a(bb bbVar, int i, BdUniqueId bdUniqueId, b bVar) {
        am a;
        if (bbVar != null && (a = com.baidu.tieba.q.a.a(bbVar, "a006", "common_click", i, bbVar.avH, false, null, null)) != null) {
            a.x("list_order", c.aHz().a(bVar));
            com.baidu.tieba.q.c.bBT().b(bdUniqueId, a);
        }
    }

    public static void a(bb bbVar, BdUniqueId bdUniqueId, b bVar) {
        am a;
        if (bbVar != null && (a = com.baidu.tieba.q.a.a(bbVar, "a006", "common_exp", bbVar.avH, false, null, null)) != null) {
            a.x("list_order", c.aHz().a(bVar));
            com.baidu.tieba.q.c.bBT().a(bdUniqueId, bbVar.getId(), a);
        }
    }

    public static void a(BdUniqueId bdUniqueId, List<h> list, ForumData forumData, int i) {
        if (!v.I(list)) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) instanceof com.baidu.tieba.InjectPlugin.a) {
                    i2++;
                }
            }
            if (i2 > 0) {
                am b = com.baidu.tieba.q.a.b("a006", "common_fill", true, i2);
                if (forumData != null) {
                    if (!ao.isEmpty(forumData.getId())) {
                        b.aA(ImageViewerConfig.FORUM_ID, forumData.getId());
                    }
                    if (!ao.isEmpty(forumData.getName())) {
                        b.aA(ImageViewerConfig.FORUM_NAME, forumData.getName());
                    }
                    if (!ao.isEmpty(forumData.getFirst_class())) {
                        b.aA("first_dir", forumData.getFirst_class());
                    }
                    if (!ao.isEmpty(forumData.getSecond_class())) {
                        b.aA("second_dir", forumData.getSecond_class());
                    }
                }
                b.x("list_order", i);
                com.baidu.tieba.q.c.bBT().b(bdUniqueId, b);
            }
        }
    }
}

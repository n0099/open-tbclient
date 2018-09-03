package com.baidu.tieba.frs.worldcup;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.e;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
/* loaded from: classes2.dex */
public class c {
    public static void a(bb bbVar, String str, int i) {
        if (bbVar != null && !TextUtils.isEmpty(str) && bbVar.wB()) {
            TiebaStatic.log(new an("c13020").ae(ImageViewerConfig.FORUM_ID, str).ae("obj_name", bbVar.wz()).ae("tid", bbVar.getTid()).r("obj_locate", i));
        }
    }

    public static void b(bb bbVar, String str, int i) {
        if (bbVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new an("c13090").ae(ImageViewerConfig.FORUM_ID, str).ae("tid", bbVar.getTid()).r("obj_locate", i));
        }
    }

    public static void a(String str, int i, i iVar, p pVar, e eVar, i iVar2, d dVar) {
        a aVar = new a(str, i);
        if (iVar != null) {
            iVar.c(aVar);
        }
        if (pVar != null) {
            pVar.c(aVar);
        }
        if (eVar != null) {
            eVar.c(aVar);
        }
        if (iVar2 != null) {
            iVar2.c(aVar);
        }
        if (dVar != null) {
            dVar.c(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends ad<bb> {
        private int dLm;
        private String mForumId;

        public a(String str, int i) {
            this.mForumId = str;
            this.dLm = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.ad
        public void a(View view, bb bbVar, Object obj) {
            if (view != null && bbVar != null && (obj instanceof BdUniqueId)) {
                BdUniqueId bdUniqueId = (BdUniqueId) obj;
                if (bb.ahx.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.dLm);
                } else if (bb.ahA.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.dLm);
                } else if (bb.ahG.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.dLm);
                    if (this.dLm == 1) {
                        c.a(bbVar, this.mForumId, 2);
                    }
                } else if (bb.ahF.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.dLm);
                } else if (bb.ahz.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.dLm);
                }
            }
        }
    }

    public static void b(FragmentTabHost.b bVar, String str) {
        int i = 1;
        if (bVar != null) {
            int i2 = bVar.mType;
            if (i2 != 12) {
                if (i2 == 102) {
                    i = 4;
                } else if (i2 == 103) {
                    i = 3;
                } else if (i2 != 1) {
                    i = 0;
                } else {
                    i = 2;
                }
            }
            if (i > 0) {
                TiebaStatic.log(new an("c13086").r("obj_locate", i).ae(ImageViewerConfig.FORUM_ID, str));
            }
        }
    }
}

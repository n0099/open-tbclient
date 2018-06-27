package com.baidu.tieba.frs.worldcup;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bc;
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
    public static void a(bc bcVar, String str, int i) {
        if (bcVar != null && !TextUtils.isEmpty(str) && bcVar.wN()) {
            TiebaStatic.log(new an("c13020").ah(ImageViewerConfig.FORUM_ID, str).ah("obj_name", bcVar.wL()).ah("tid", bcVar.getTid()).r("obj_locate", i));
        }
    }

    public static void b(bc bcVar, String str, int i) {
        if (bcVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new an("c13090").ah(ImageViewerConfig.FORUM_ID, str).ah("tid", bcVar.getTid()).r("obj_locate", i));
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
    public static class a extends ad<bc> {
        private int dIB;
        private String mForumId;

        public a(String str, int i) {
            this.mForumId = str;
            this.dIB = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.ad
        public void a(View view, bc bcVar, Object obj) {
            if (view != null && bcVar != null && (obj instanceof BdUniqueId)) {
                BdUniqueId bdUniqueId = (BdUniqueId) obj;
                if (bc.aib.getId() == bdUniqueId.getId()) {
                    c.b(bcVar, this.mForumId, this.dIB);
                } else if (bc.aie.getId() == bdUniqueId.getId()) {
                    c.b(bcVar, this.mForumId, this.dIB);
                } else if (bc.aik.getId() == bdUniqueId.getId()) {
                    c.b(bcVar, this.mForumId, this.dIB);
                    if (this.dIB == 1) {
                        c.a(bcVar, this.mForumId, 2);
                    }
                } else if (bc.aij.getId() == bdUniqueId.getId()) {
                    c.b(bcVar, this.mForumId, this.dIB);
                } else if (bc.aid.getId() == bdUniqueId.getId()) {
                    c.b(bcVar, this.mForumId, this.dIB);
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
                TiebaStatic.log(new an("c13086").r("obj_locate", i).ah(ImageViewerConfig.FORUM_ID, str));
            }
        }
    }
}

package com.baidu.tieba.frs.worldcup;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.e;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
/* loaded from: classes6.dex */
public class c {
    public static void a(bb bbVar, String str, int i) {
        if (bbVar != null && !TextUtils.isEmpty(str) && bbVar.Bc()) {
            TiebaStatic.log(new am("c13020").aA(ImageViewerConfig.FORUM_ID, str).aA("obj_name", bbVar.Ba()).aA("tid", bbVar.getTid()).x("obj_locate", i));
        }
    }

    public static void b(bb bbVar, String str, int i) {
        if (bbVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new am("c13090").aA(ImageViewerConfig.FORUM_ID, str).aA("tid", bbVar.getTid()).x("obj_locate", i));
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

    /* loaded from: classes6.dex */
    public static class a extends ad<bb> {
        private int eiw;
        private String mForumId;

        public a(String str, int i) {
            this.mForumId = str;
            this.eiw = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.ad
        public void a(View view, bb bbVar, Object obj) {
            if (view != null && bbVar != null && (obj instanceof BdUniqueId)) {
                BdUniqueId bdUniqueId = (BdUniqueId) obj;
                if (bb.atg.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.eiw);
                } else if (bb.atj.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.eiw);
                } else if (bb.atp.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.eiw);
                    if (this.eiw == 1) {
                        c.a(bbVar, this.mForumId, 2);
                    }
                } else if (bb.ato.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.eiw);
                } else if (bb.ati.getId() == bdUniqueId.getId()) {
                    c.b(bbVar, this.mForumId, this.eiw);
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
                TiebaStatic.log(new am("c13086").x("obj_locate", i).aA(ImageViewerConfig.FORUM_ID, str));
            }
        }
    }
}

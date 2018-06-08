package com.baidu.tieba.frs.worldcup;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.e;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
/* loaded from: classes2.dex */
public class c {
    public static void a(bd bdVar, String str, int i) {
        if (bdVar != null && !TextUtils.isEmpty(str) && bdVar.wD()) {
            TiebaStatic.log(new am("c13020").ah(ImageViewerConfig.FORUM_ID, str).ah("obj_name", bdVar.wB()).ah("tid", bdVar.getTid()).r("obj_locate", i));
        }
    }

    public static void b(bd bdVar, String str, int i) {
        if (bdVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new am("c13090").ah(ImageViewerConfig.FORUM_ID, str).ah("tid", bdVar.getTid()).r("obj_locate", i));
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
    public static class a extends ab<bd> {
        private int dFh;
        private String mForumId;

        public a(String str, int i) {
            this.mForumId = str;
            this.dFh = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.card.ab
        public void a(View view, bd bdVar, Object obj) {
            if (view != null && bdVar != null && (obj instanceof BdUniqueId)) {
                BdUniqueId bdUniqueId = (BdUniqueId) obj;
                if (bd.ahJ.getId() == bdUniqueId.getId()) {
                    c.b(bdVar, this.mForumId, this.dFh);
                } else if (bd.ahM.getId() == bdUniqueId.getId()) {
                    c.b(bdVar, this.mForumId, this.dFh);
                } else if (bd.ahS.getId() == bdUniqueId.getId()) {
                    c.b(bdVar, this.mForumId, this.dFh);
                    if (this.dFh == 1) {
                        c.a(bdVar, this.mForumId, 2);
                    }
                } else if (bd.ahR.getId() == bdUniqueId.getId()) {
                    c.b(bdVar, this.mForumId, this.dFh);
                } else if (bd.ahL.getId() == bdUniqueId.getId()) {
                    c.b(bdVar, this.mForumId, this.dFh);
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
                TiebaStatic.log(new am("c13086").r("obj_locate", i).ah(ImageViewerConfig.FORUM_ID, str));
            }
        }
    }
}

package com.baidu.tieba.godSquare.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements by {
    final /* synthetic */ b bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bKk = bVar;
    }

    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        if (view != null) {
            nVar = this.bKk.bKj;
            if (nVar != null && (bVar instanceof h)) {
                h hVar = (h) bVar;
                if (hVar.author != null && !StringUtils.isNull(hVar.author.getUserId())) {
                    int id = view.getId();
                    nVar2 = this.bKk.bKj;
                    if (id == nVar2.aOX.getId()) {
                        TiebaStatic.log(new aw("c10803").s("obj_locate", 4).ac("obj_id", hVar.author.getUserId()));
                        return;
                    }
                    int id2 = view.getId();
                    nVar3 = this.bKk.bKj;
                    if (id2 != nVar3.getView().getId()) {
                        int id3 = view.getId();
                        nVar4 = this.bKk.bKj;
                        if (id3 != nVar4.aOY.getId()) {
                            return;
                        }
                    }
                    TiebaStatic.log(new aw("c10951").ac("obj_id", hVar.author.getUserId()));
                }
            }
        }
    }
}

package com.baidu.tieba.godSquare.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements by {
    final /* synthetic */ d bKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bKn = dVar;
    }

    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        if (view != null) {
            oVar = this.bKn.bKm;
            if (oVar != null && (bVar instanceof h)) {
                h hVar = (h) bVar;
                if (hVar.author != null && !StringUtils.isNull(hVar.author.getUserId())) {
                    int id = view.getId();
                    oVar2 = this.bKn.bKm;
                    if (id == oVar2.aOX.getId()) {
                        TiebaStatic.log(new aw("c10803").s("obj_locate", 4).ac("obj_id", hVar.author.getUserId()));
                        return;
                    }
                    int id2 = view.getId();
                    oVar3 = this.bKn.bKm;
                    if (id2 != oVar3.getView().getId()) {
                        int id3 = view.getId();
                        oVar4 = this.bKn.bKm;
                        if (id3 != oVar4.aOY.getId()) {
                            return;
                        }
                    }
                    TiebaStatic.log(new aw("c10951").ac("obj_id", hVar.author.getUserId()));
                }
            }
        }
    }
}

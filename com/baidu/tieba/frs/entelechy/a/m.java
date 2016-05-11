package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements by {
    final /* synthetic */ l bpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bpa = lVar;
    }

    @Override // com.baidu.tieba.card.by
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        com.baidu.tieba.frs.entelechy.c.s sVar;
        com.baidu.tieba.frs.entelechy.c.s sVar2;
        com.baidu.tieba.frs.entelechy.c.s sVar3;
        bx.Kg().ci(true);
        sVar = this.bpa.boY;
        if (sVar != null && view != null && (bVar instanceof com.baidu.tieba.card.a.l)) {
            com.baidu.tieba.card.a.l lVar = (com.baidu.tieba.card.a.l) bVar;
            if (lVar.aRG != null) {
                if (view instanceof TbImageView) {
                    TiebaStatic.log(new aw("c11004").ac("tid", lVar.aRG.getTid()));
                    return;
                }
                int id = view.getId();
                sVar2 = this.bpa.boY;
                if (id == sVar2.aOX.getId()) {
                    TiebaStatic.log(new aw("c10803").s("obj_locate", 7).ac("tid", lVar.aRG.getTid()));
                    return;
                }
                int id2 = view.getId();
                sVar3 = this.bpa.boY;
                if (id2 == sVar3.getView().getId()) {
                    TiebaStatic.log(new aw("c11004").ac("tid", lVar.aRG.getTid()));
                    TiebaStatic.log(new aw("c10806").s("obj_locate", 1).ac("tid", lVar.aRG.getId()));
                    return;
                }
                TiebaStatic.log(new aw("c11004").ac("tid", lVar.aRG.getTid()));
            }
        }
    }
}

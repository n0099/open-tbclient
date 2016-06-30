package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.frs.entelechy.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements bx {
    final /* synthetic */ t bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bJI = tVar;
    }

    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        q qVar;
        q qVar2;
        q qVar3;
        bw.Lg().cj(true);
        qVar = this.bJI.bJG;
        if (qVar != null && view != null && (bVar instanceof m)) {
            m mVar = (m) bVar;
            if (mVar.threadData != null) {
                if (view instanceof TbImageView) {
                    TiebaStatic.log(new ay("c11004").ab("tid", mVar.threadData.getTid()));
                    return;
                }
                int id = view.getId();
                qVar2 = this.bJI.bJG;
                if (id == qVar2.aSe.getId()) {
                    TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", mVar.threadData.getTid()));
                    return;
                }
                int id2 = view.getId();
                qVar3 = this.bJI.bJG;
                if (id2 == qVar3.getView().getId()) {
                    TiebaStatic.log(new ay("c11004").ab("tid", mVar.threadData.getTid()));
                    TiebaStatic.log(new ay("c10806").s("obj_locate", 1).ab("tid", mVar.threadData.getId()));
                    return;
                }
                TiebaStatic.log(new ay("c11004").ab("tid", mVar.threadData.getTid()));
            }
        }
    }
}

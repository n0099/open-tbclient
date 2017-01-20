package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cf<com.baidu.tieba.card.data.f> {
    final /* synthetic */ e cwi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cwi = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.f fVar) {
        com.baidu.tieba.card.d dVar;
        com.baidu.tieba.card.d dVar2;
        com.baidu.tieba.card.d dVar3;
        com.baidu.tieba.card.d dVar4;
        com.baidu.tieba.card.d dVar5;
        com.baidu.tieba.card.d dVar6;
        com.baidu.tieba.card.d dVar7;
        com.baidu.tieba.card.d dVar8;
        com.baidu.tieba.card.d dVar9;
        dVar = this.cwi.cwh;
        if (dVar != null) {
            dVar2 = this.cwi.cwh;
            if (dVar2.bkH != null && fVar != null && fVar.threadData != null && fVar.threadData.getId() != null) {
                int id = view.getId();
                dVar3 = this.cwi.cwh;
                if (id == dVar3.bkH.getView().getId()) {
                    TiebaStatic.log(new ar("c10806").s("obj_locate", 2).ab("tid", fVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                dVar4 = this.cwi.cwh;
                if (id2 == dVar4.bkH.bkM.getId()) {
                    TiebaStatic.log(new ar("c10803").ab("tid", fVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                dVar5 = this.cwi.cwh;
                if (id3 != dVar5.bkH.agJ.getId()) {
                    int id4 = view.getId();
                    dVar6 = this.cwi.cwh;
                    if (id4 != dVar6.bkH.bkL.getId()) {
                        int id5 = view.getId();
                        dVar7 = this.cwi.cwh;
                        if (id5 != dVar7.bkH.bkK.getId()) {
                            int id6 = view.getId();
                            dVar8 = this.cwi.cwh;
                            if (id6 == dVar8.bkH.bkR.getId()) {
                                TiebaStatic.log(new ar("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new ar("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                dVar9 = this.cwi.cwh;
                                if (id7 == dVar9.bkH.bkU.getBarNameTv().getId()) {
                                    TiebaStatic.log(new ar("c11008").s("obj_locate", 3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                TiebaStatic.log(new ar("c11008").s("obj_locate", 1));
            }
        }
    }
}

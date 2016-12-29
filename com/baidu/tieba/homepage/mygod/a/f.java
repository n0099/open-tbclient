package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cb<com.baidu.tieba.card.data.f> {
    final /* synthetic */ e cpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cpg = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
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
        dVar = this.cpg.cpf;
        if (dVar != null) {
            dVar2 = this.cpg.cpf;
            if (dVar2.baT != null && fVar != null && fVar.threadData != null && fVar.threadData.getId() != null) {
                int id = view.getId();
                dVar3 = this.cpg.cpf;
                if (id == dVar3.baT.getView().getId()) {
                    TiebaStatic.log(new at("c10806").s("obj_locate", 2).ab("tid", fVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                dVar4 = this.cpg.cpf;
                if (id2 == dVar4.baT.baZ.getId()) {
                    TiebaStatic.log(new at("c10803").ab("tid", fVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                dVar5 = this.cpg.cpf;
                if (id3 != dVar5.baT.ahw.getId()) {
                    int id4 = view.getId();
                    dVar6 = this.cpg.cpf;
                    if (id4 != dVar6.baT.baY.getId()) {
                        int id5 = view.getId();
                        dVar7 = this.cpg.cpf;
                        if (id5 != dVar7.baT.baV.getId()) {
                            int id6 = view.getId();
                            dVar8 = this.cpg.cpf;
                            if (id6 == dVar8.baT.bbd.getId()) {
                                TiebaStatic.log(new at("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new at("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                dVar9 = this.cpg.cpf;
                                if (id7 == dVar9.baT.bbg.getBarNameTv().getId()) {
                                    TiebaStatic.log(new at("c11008").s("obj_locate", 3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                TiebaStatic.log(new at("c11008").s("obj_locate", 1));
            }
        }
    }
}

package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cf<com.baidu.tieba.card.data.f> {
    final /* synthetic */ e cyy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cyy = eVar;
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
        dVar = this.cyy.cyx;
        if (dVar != null) {
            dVar2 = this.cyy.cyx;
            if (dVar2.btJ != null && fVar != null && fVar.threadData != null && fVar.threadData.getId() != null) {
                int id = view.getId();
                dVar3 = this.cyy.cyx;
                if (id == dVar3.btJ.getView().getId()) {
                    TiebaStatic.log(new as("c10806").s("obj_locate", 2).aa("tid", fVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                dVar4 = this.cyy.cyx;
                if (id2 == dVar4.btJ.btO.getId()) {
                    TiebaStatic.log(new as("c10803").aa("tid", fVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                dVar5 = this.cyy.cyx;
                if (id3 != dVar5.btJ.amq.getId()) {
                    int id4 = view.getId();
                    dVar6 = this.cyy.cyx;
                    if (id4 != dVar6.btJ.btN.getId()) {
                        int id5 = view.getId();
                        dVar7 = this.cyy.cyx;
                        if (id5 != dVar7.btJ.btM.getId()) {
                            int id6 = view.getId();
                            dVar8 = this.cyy.cyx;
                            if (id6 == dVar8.btJ.btT.getId()) {
                                TiebaStatic.log(new as("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new as("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                dVar9 = this.cyy.cyx;
                                if (id7 == dVar9.btJ.btW.getBarNameTv().getId()) {
                                    TiebaStatic.log(new as("c11008").s("obj_locate", 3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                TiebaStatic.log(new as("c11008").s("obj_locate", 1));
            }
        }
    }
}

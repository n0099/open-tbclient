package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cd<g> {
    final /* synthetic */ e cEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cEy = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, g gVar) {
        com.baidu.tieba.card.d dVar;
        com.baidu.tieba.card.d dVar2;
        com.baidu.tieba.card.d dVar3;
        com.baidu.tieba.card.d dVar4;
        com.baidu.tieba.card.d dVar5;
        com.baidu.tieba.card.d dVar6;
        com.baidu.tieba.card.d dVar7;
        com.baidu.tieba.card.d dVar8;
        com.baidu.tieba.card.d dVar9;
        dVar = this.cEy.cEx;
        if (dVar != null) {
            dVar2 = this.cEy.cEx;
            if (dVar2.aYE != null && gVar != null && gVar.threadData != null && gVar.threadData.getId() != null) {
                int id = view.getId();
                dVar3 = this.cEy.cEx;
                if (id == dVar3.aYE.getView().getId()) {
                    TiebaStatic.log(new ax("c10806").s("obj_locate", 2).ab("tid", gVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                dVar4 = this.cEy.cEx;
                if (id2 == dVar4.aYE.aYK.getId()) {
                    TiebaStatic.log(new ax("c10803").ab("tid", gVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                dVar5 = this.cEy.cEx;
                if (id3 != dVar5.aYE.ahv.getId()) {
                    int id4 = view.getId();
                    dVar6 = this.cEy.cEx;
                    if (id4 != dVar6.aYE.aYJ.getId()) {
                        int id5 = view.getId();
                        dVar7 = this.cEy.cEx;
                        if (id5 != dVar7.aYE.aYG.getId()) {
                            int id6 = view.getId();
                            dVar8 = this.cEy.cEx;
                            if (id6 == dVar8.aYE.aYO.getId()) {
                                TiebaStatic.log(new ax("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new ax("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                dVar9 = this.cEy.cEx;
                                if (id7 == dVar9.aYE.aYR.getBarNameTv().getId()) {
                                    TiebaStatic.log(new ax("c11008").s("obj_locate", 3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                TiebaStatic.log(new ax("c11008").s("obj_locate", 1));
            }
        }
    }
}

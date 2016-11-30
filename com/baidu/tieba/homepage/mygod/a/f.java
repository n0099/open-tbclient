package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.data.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends bz<g> {
    final /* synthetic */ e cJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cJL = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
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
        dVar = this.cJL.cJK;
        if (dVar != null) {
            dVar2 = this.cJL.cJK;
            if (dVar2.bbN != null && gVar != null && gVar.threadData != null && gVar.threadData.getId() != null) {
                int id = view.getId();
                dVar3 = this.cJL.cJK;
                if (id == dVar3.bbN.getView().getId()) {
                    TiebaStatic.log(new av("c10806").s("obj_locate", 2).ab("tid", gVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                dVar4 = this.cJL.cJK;
                if (id2 == dVar4.bbN.bbT.getId()) {
                    TiebaStatic.log(new av("c10803").ab("tid", gVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                dVar5 = this.cJL.cJK;
                if (id3 != dVar5.bbN.ahV.getId()) {
                    int id4 = view.getId();
                    dVar6 = this.cJL.cJK;
                    if (id4 != dVar6.bbN.bbS.getId()) {
                        int id5 = view.getId();
                        dVar7 = this.cJL.cJK;
                        if (id5 != dVar7.bbN.bbP.getId()) {
                            int id6 = view.getId();
                            dVar8 = this.cJL.cJK;
                            if (id6 == dVar8.bbN.bbX.getId()) {
                                TiebaStatic.log(new av("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new av("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                dVar9 = this.cJL.cJK;
                                if (id7 == dVar9.bbN.bca.getBarNameTv().getId()) {
                                    TiebaStatic.log(new av("c11008").s("obj_locate", 3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                TiebaStatic.log(new av("c11008").s("obj_locate", 1));
            }
        }
    }
}

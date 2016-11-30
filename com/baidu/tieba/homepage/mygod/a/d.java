package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.data.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends bz<g> {
    final /* synthetic */ c cJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cJI = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, g gVar) {
        com.baidu.tieba.card.e eVar;
        com.baidu.tieba.card.e eVar2;
        com.baidu.tieba.card.e eVar3;
        com.baidu.tieba.card.e eVar4;
        com.baidu.tieba.card.e eVar5;
        com.baidu.tieba.card.e eVar6;
        com.baidu.tieba.card.e eVar7;
        com.baidu.tieba.card.e eVar8;
        com.baidu.tieba.card.e eVar9;
        eVar = this.cJI.cJH;
        if (eVar != null) {
            eVar2 = this.cJI.cJH;
            if (eVar2.getView() != null && gVar != null && gVar.threadData != null && gVar.threadData.getId() != null) {
                int id = view.getId();
                eVar3 = this.cJI.cJH;
                if (id == eVar3.getView().getId()) {
                    TiebaStatic.log(new av("c10806").s("obj_locate", 2).ab("tid", gVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                eVar4 = this.cJI.cJH;
                if (id2 == eVar4.bbT.getId()) {
                    TiebaStatic.log(new av("c10803").ab("tid", gVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                eVar5 = this.cJI.cJH;
                if (id3 != eVar5.ahV.getId()) {
                    int id4 = view.getId();
                    eVar6 = this.cJI.cJH;
                    if (id4 != eVar6.bbS.getId()) {
                        int id5 = view.getId();
                        eVar7 = this.cJI.cJH;
                        if (id5 != eVar7.bbP.getId()) {
                            int id6 = view.getId();
                            eVar8 = this.cJI.cJH;
                            if (id6 == eVar8.bbX.getId()) {
                                TiebaStatic.log(new av("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new av("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                eVar9 = this.cJI.cJH;
                                if (id7 == eVar9.bca.getBarNameTv().getId()) {
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

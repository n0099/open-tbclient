package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cf<g> {
    final /* synthetic */ e cDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cDU = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
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
        dVar = this.cDU.cDT;
        if (dVar != null) {
            dVar2 = this.cDU.cDT;
            if (dVar2.aYa != null && gVar != null && gVar.threadData != null && gVar.threadData.getId() != null) {
                int id = view.getId();
                dVar3 = this.cDU.cDT;
                if (id == dVar3.aYa.getView().getId()) {
                    TiebaStatic.log(new ay("c10806").s("obj_locate", 2).ab("tid", gVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                dVar4 = this.cDU.cDT;
                if (id2 == dVar4.aYa.aYi.getId()) {
                    TiebaStatic.log(new ay("c10803").ab("tid", gVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                dVar5 = this.cDU.cDT;
                if (id3 != dVar5.aYa.ahN.getId()) {
                    int id4 = view.getId();
                    dVar6 = this.cDU.cDT;
                    if (id4 != dVar6.aYa.aYg.getId()) {
                        int id5 = view.getId();
                        dVar7 = this.cDU.cDT;
                        if (id5 != dVar7.aYa.aYd.getId()) {
                            int id6 = view.getId();
                            dVar8 = this.cDU.cDT;
                            if (id6 == dVar8.aYa.aYm.getId()) {
                                TiebaStatic.log(new ay("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new ay("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                dVar9 = this.cDU.cDT;
                                if (id7 == dVar9.aYa.aYp.getBarNameTv().getId()) {
                                    TiebaStatic.log(new ay("c11008").s("obj_locate", 3));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                TiebaStatic.log(new ay("c11008").s("obj_locate", 1));
            }
        }
    }
}

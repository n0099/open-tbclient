package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cf<com.baidu.tieba.card.data.f> {
    final /* synthetic */ e cxH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cxH = eVar;
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
        dVar = this.cxH.cxG;
        if (dVar != null) {
            dVar2 = this.cxH.cxG;
            if (dVar2.brz != null && fVar != null && fVar.threadData != null && fVar.threadData.getId() != null) {
                int id = view.getId();
                dVar3 = this.cxH.cxG;
                if (id == dVar3.brz.getView().getId()) {
                    TiebaStatic.log(new as("c10806").s("obj_locate", 2).Z("tid", fVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                dVar4 = this.cxH.cxG;
                if (id2 == dVar4.brz.brE.getId()) {
                    TiebaStatic.log(new as("c10803").Z("tid", fVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                dVar5 = this.cxH.cxG;
                if (id3 != dVar5.brz.amc.getId()) {
                    int id4 = view.getId();
                    dVar6 = this.cxH.cxG;
                    if (id4 != dVar6.brz.brD.getId()) {
                        int id5 = view.getId();
                        dVar7 = this.cxH.cxG;
                        if (id5 != dVar7.brz.brC.getId()) {
                            int id6 = view.getId();
                            dVar8 = this.cxH.cxG;
                            if (id6 == dVar8.brz.brJ.getId()) {
                                TiebaStatic.log(new as("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new as("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                dVar9 = this.cxH.cxG;
                                if (id7 == dVar9.brz.brM.getBarNameTv().getId()) {
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

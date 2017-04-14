package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cf<com.baidu.tieba.card.data.f> {
    final /* synthetic */ e cwh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cwh = eVar;
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
        dVar = this.cwh.cwg;
        if (dVar != null) {
            dVar2 = this.cwh.cwg;
            if (dVar2.brr != null && fVar != null && fVar.threadData != null && fVar.threadData.getId() != null) {
                int id = view.getId();
                dVar3 = this.cwh.cwg;
                if (id == dVar3.brr.getView().getId()) {
                    TiebaStatic.log(new as("c10806").s("obj_locate", 2).aa("tid", fVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                dVar4 = this.cwh.cwg;
                if (id2 == dVar4.brr.brw.getId()) {
                    TiebaStatic.log(new as("c10803").aa("tid", fVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                dVar5 = this.cwh.cwg;
                if (id3 != dVar5.brr.amq.getId()) {
                    int id4 = view.getId();
                    dVar6 = this.cwh.cwg;
                    if (id4 != dVar6.brr.brv.getId()) {
                        int id5 = view.getId();
                        dVar7 = this.cwh.cwg;
                        if (id5 != dVar7.brr.bru.getId()) {
                            int id6 = view.getId();
                            dVar8 = this.cwh.cwg;
                            if (id6 == dVar8.brr.brB.getId()) {
                                TiebaStatic.log(new as("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new as("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                dVar9 = this.cwh.cwg;
                                if (id7 == dVar9.brr.brE.getBarNameTv().getId()) {
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

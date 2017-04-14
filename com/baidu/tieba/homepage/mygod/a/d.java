package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends cf<com.baidu.tieba.card.data.f> {
    final /* synthetic */ c cwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cwe = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.f fVar) {
        com.baidu.tieba.card.e eVar;
        com.baidu.tieba.card.e eVar2;
        com.baidu.tieba.card.e eVar3;
        com.baidu.tieba.card.e eVar4;
        com.baidu.tieba.card.e eVar5;
        com.baidu.tieba.card.e eVar6;
        com.baidu.tieba.card.e eVar7;
        com.baidu.tieba.card.e eVar8;
        com.baidu.tieba.card.e eVar9;
        eVar = this.cwe.cwd;
        if (eVar != null) {
            eVar2 = this.cwe.cwd;
            if (eVar2.getView() != null && fVar != null && fVar.threadData != null && fVar.threadData.getId() != null) {
                int id = view.getId();
                eVar3 = this.cwe.cwd;
                if (id == eVar3.getView().getId()) {
                    TiebaStatic.log(new as("c10806").s("obj_locate", 2).aa("tid", fVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                eVar4 = this.cwe.cwd;
                if (id2 == eVar4.brw.getId()) {
                    TiebaStatic.log(new as("c10803").aa("tid", fVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                eVar5 = this.cwe.cwd;
                if (id3 != eVar5.amq.getId()) {
                    int id4 = view.getId();
                    eVar6 = this.cwe.cwd;
                    if (id4 != eVar6.brv.getId()) {
                        int id5 = view.getId();
                        eVar7 = this.cwe.cwd;
                        if (id5 != eVar7.bru.getId()) {
                            int id6 = view.getId();
                            eVar8 = this.cwe.cwd;
                            if (id6 == eVar8.brB.getId()) {
                                TiebaStatic.log(new as("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new as("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                eVar9 = this.cwe.cwd;
                                if (id7 == eVar9.brE.getBarNameTv().getId()) {
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

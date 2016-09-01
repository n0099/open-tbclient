package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends cf<g> {
    final /* synthetic */ c cDR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cDR = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
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
        eVar = this.cDR.cDQ;
        if (eVar != null) {
            eVar2 = this.cDR.cDQ;
            if (eVar2.getView() != null && gVar != null && gVar.threadData != null && gVar.threadData.getId() != null) {
                int id = view.getId();
                eVar3 = this.cDR.cDQ;
                if (id == eVar3.getView().getId()) {
                    TiebaStatic.log(new ay("c10806").s("obj_locate", 2).ab("tid", gVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                eVar4 = this.cDR.cDQ;
                if (id2 == eVar4.aYi.getId()) {
                    TiebaStatic.log(new ay("c10803").ab("tid", gVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                eVar5 = this.cDR.cDQ;
                if (id3 != eVar5.ahN.getId()) {
                    int id4 = view.getId();
                    eVar6 = this.cDR.cDQ;
                    if (id4 != eVar6.aYg.getId()) {
                        int id5 = view.getId();
                        eVar7 = this.cDR.cDQ;
                        if (id5 != eVar7.aYd.getId()) {
                            int id6 = view.getId();
                            eVar8 = this.cDR.cDQ;
                            if (id6 == eVar8.aYm.getId()) {
                                TiebaStatic.log(new ay("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new ay("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                eVar9 = this.cDR.cDQ;
                                if (id7 == eVar9.aYp.getBarNameTv().getId()) {
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

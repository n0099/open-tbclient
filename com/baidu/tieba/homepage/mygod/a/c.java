package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.g;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends bx<g> {
    final /* synthetic */ b csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.csI = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, g gVar) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        k kVar7;
        k kVar8;
        k kVar9;
        kVar = this.csI.csH;
        if (kVar != null) {
            kVar2 = this.csI.csH;
            if (kVar2.getView() != null && gVar != null && gVar.threadData != null && gVar.threadData.getId() != null) {
                int id = view.getId();
                kVar3 = this.csI.csH;
                if (id == kVar3.getView().getId()) {
                    TiebaStatic.log(new ay("c10806").s("obj_locate", 2).ab("tid", gVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                kVar4 = this.csI.csH;
                if (id2 == kVar4.aTa.getId()) {
                    TiebaStatic.log(new ay("c10803").ab("tid", gVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                kVar5 = this.csI.csH;
                if (id3 != kVar5.aeS.getId()) {
                    int id4 = view.getId();
                    kVar6 = this.csI.csH;
                    if (id4 != kVar6.aSY.getId()) {
                        int id5 = view.getId();
                        kVar7 = this.csI.csH;
                        if (id5 != kVar7.aSV.getId()) {
                            int id6 = view.getId();
                            kVar8 = this.csI.csH;
                            if (id6 == kVar8.aTe.getId()) {
                                TiebaStatic.log(new ay("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new ay("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                kVar9 = this.csI.csH;
                                if (id7 == kVar9.aTh.getBarNameTv().getId()) {
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

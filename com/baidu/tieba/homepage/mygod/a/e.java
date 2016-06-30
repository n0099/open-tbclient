package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.g;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements bx<g> {
    final /* synthetic */ d cqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cqg = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, g gVar) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        j jVar7;
        j jVar8;
        j jVar9;
        jVar = this.cqg.cqf;
        if (jVar != null) {
            jVar2 = this.cqg.cqf;
            if (jVar2.aRY != null && gVar != null && gVar.threadData != null && gVar.threadData.getId() != null) {
                int id = view.getId();
                jVar3 = this.cqg.cqf;
                if (id == jVar3.aRY.getView().getId()) {
                    TiebaStatic.log(new ay("c10806").s("obj_locate", 2).ab("tid", gVar.threadData.getId()));
                    return;
                }
                int id2 = view.getId();
                jVar4 = this.cqg.cqf;
                if (id2 == jVar4.aRY.aSe.getId()) {
                    TiebaStatic.log(new ay("c10803").ab("tid", gVar.threadData.getTid()).s("obj_locate", 1));
                    return;
                }
                int id3 = view.getId();
                jVar5 = this.cqg.cqf;
                if (id3 != jVar5.aRY.aee.getId()) {
                    int id4 = view.getId();
                    jVar6 = this.cqg.cqf;
                    if (id4 != jVar6.aRY.aSc.getId()) {
                        int id5 = view.getId();
                        jVar7 = this.cqg.cqf;
                        if (id5 != jVar7.aRY.aSb.getId()) {
                            int id6 = view.getId();
                            jVar8 = this.cqg.cqf;
                            if (id6 == jVar8.aRY.aSi.getId()) {
                                TiebaStatic.log(new ay("c11008").s("obj_locate", 4));
                                return;
                            } else if (view instanceof TbImageView) {
                                TiebaStatic.log(new ay("c11008").s("obj_locate", 2));
                                return;
                            } else {
                                int id7 = view.getId();
                                jVar9 = this.cqg.cqf;
                                if (id7 == jVar9.aRY.aSl.getBarNameTv().getId()) {
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

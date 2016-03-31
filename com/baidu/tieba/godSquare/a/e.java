package com.baidu.tieba.godSquare.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.card.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements cj {
    final /* synthetic */ d bKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bKi = dVar;
    }

    @Override // com.baidu.tieba.card.cj
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        if (view != null) {
            tVar = this.bKi.bKh;
            if (tVar != null && (bVar instanceof k)) {
                k kVar = (k) bVar;
                if (kVar.author != null && !StringUtils.isNull(kVar.author.getUserId())) {
                    int id = view.getId();
                    tVar2 = this.bKi.bKh;
                    if (id == tVar2.aSy.getId()) {
                        TiebaStatic.log(new aw("c10803").r("obj_locate", 4).ac("obj_id", kVar.author.getUserId()));
                        return;
                    }
                    int id2 = view.getId();
                    tVar3 = this.bKi.bKh;
                    if (id2 != tVar3.getView().getId()) {
                        int id3 = view.getId();
                        tVar4 = this.bKi.bKh;
                        if (id3 != tVar4.aSz.getId()) {
                            return;
                        }
                    }
                    TiebaStatic.log(new aw("c10951").ac("obj_id", kVar.author.getUserId()));
                }
            }
        }
    }
}

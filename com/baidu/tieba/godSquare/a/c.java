package com.baidu.tieba.godSquare.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.card.cj;
import com.baidu.tieba.card.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements cj {
    final /* synthetic */ b bKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bKf = bVar;
    }

    @Override // com.baidu.tieba.card.cj
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        if (view != null) {
            sVar = this.bKf.bKd;
            if (sVar != null && (bVar instanceof k)) {
                k kVar = (k) bVar;
                if (kVar.author != null && !StringUtils.isNull(kVar.author.getUserId())) {
                    int id = view.getId();
                    sVar2 = this.bKf.bKd;
                    if (id == sVar2.aSy.getId()) {
                        TiebaStatic.log(new aw("c10803").r("obj_locate", 4).ac("obj_id", kVar.author.getUserId()));
                        return;
                    }
                    int id2 = view.getId();
                    sVar3 = this.bKf.bKd;
                    if (id2 != sVar3.getView().getId()) {
                        int id3 = view.getId();
                        sVar4 = this.bKf.bKd;
                        if (id3 != sVar4.aSz.getId()) {
                            return;
                        }
                    }
                    TiebaStatic.log(new aw("c10951").ac("obj_id", kVar.author.getUserId()));
                }
            }
        }
    }
}

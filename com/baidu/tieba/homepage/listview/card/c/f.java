package com.baidu.tieba.homepage.listview.card.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.a.c;
import com.baidu.tbadk.core.view.viewpager.g;
import tbclient.PicTextItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements g.a<com.baidu.tbadk.core.view.viewpager.a.a, c.a> {
    final /* synthetic */ e bAb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bAb = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.g.a
    /* renamed from: a */
    public void c(c.a aVar, com.baidu.tbadk.core.view.viewpager.a.a aVar2) {
        d dVar;
        TbPageContext<?> tbPageContext;
        d dVar2;
        dVar = this.bAb.bAa;
        if (dVar != null && (aVar2 instanceof h)) {
            dVar2 = this.bAb.bAa;
            int a = y.a(dVar2.bzU, (h) aVar2);
            if (a >= 0) {
                com.baidu.tieba.homepage.fragment.data.d.D("c10557", a + 1);
            }
        }
        if (aVar2.wy() instanceof PicTextItem) {
            bf vD = bf.vD();
            tbPageContext = this.bAb.mPageContext;
            vD.b(tbPageContext, new String[]{((PicTextItem) aVar2.wy()).item_url});
        }
    }
}

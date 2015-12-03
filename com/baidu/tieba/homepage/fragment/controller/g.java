package com.baidu.tieba.homepage.fragment.controller;

import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.a.c;
import com.baidu.tbadk.core.view.viewpager.g;
import tbclient.PicTextItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements g.a<com.baidu.tbadk.core.view.viewpager.a.a, c.a> {
    final /* synthetic */ a bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bye = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.viewpager.g.a
    /* renamed from: a */
    public void c(c.a aVar, com.baidu.tbadk.core.view.viewpager.a.a aVar2) {
        com.baidu.tieba.homepage.fragment.data.b bVar;
        com.baidu.tieba.homepage.fragment.data.b bVar2;
        com.baidu.tieba.homepage.fragment.data.b bVar3;
        if (aVar2 instanceof com.baidu.tieba.homepage.listview.card.a.b) {
            bVar = this.bye.bxX;
            if (bVar != null) {
                bVar2 = this.bye.bxX;
                if (bVar2.TQ() != null) {
                    bVar3 = this.bye.bxX;
                    int a = y.a(bVar3.TQ().TZ(), (com.baidu.tieba.homepage.listview.card.a.b) aVar2);
                    if (a >= 0) {
                        com.baidu.tieba.homepage.fragment.data.d.D("c10541", a + 1);
                    }
                }
            }
        }
        if (aVar2.wy() instanceof PicTextItem) {
            bf.vD().b(this.bye.getPageContext(), new String[]{((PicTextItem) aVar2.wy()).item_url});
        }
    }
}

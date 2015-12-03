package com.baidu.tieba.homepage.listview.card.e;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.listview.card.e.b;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.homepage.listview.c<b> {
    private ArrayList<com.baidu.tieba.homepage.listview.card.e.a.a> bAr;
    private LinearLayout bAs;
    private final int bAt;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(tbPageContext, view);
        this.bAt = 3;
        this.mPageContext = tbPageContext;
        this.bAs = (LinearLayout) view.findViewById(n.f.hot_god_card_layout_root);
        this.bAr = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(b bVar) {
        if (bVar != null) {
            super.D(bVar);
            if (bVar.bAn != null) {
                if (y.k(bVar.bAn) > 3) {
                    bVar.bAn = bVar.bAn.subList(0, 3);
                }
                com.baidu.tieba.homepage.fragment.a.b.a(this.mPageContext.getPageActivity(), this.bAs, bVar.bAn, b.a.class, this.bAr, com.baidu.tieba.homepage.listview.card.e.a.a.class);
            }
        }
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        if (this.mSkinType != i && y.k(this.bAr) != 0) {
            Iterator<com.baidu.tieba.homepage.listview.card.e.a.a> it = this.bAr.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.listview.card.e.a.a next = it.next();
                if (next != null) {
                    next.cZ(i);
                }
            }
        }
        super.cZ(i);
    }
}

package com.baidu.tieba.homepage.listview.card.i;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.listview.card.i.b;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.homepage.listview.c<b> {
    private LinearLayout bAs;
    private final int bAt;
    private ArrayList<com.baidu.tieba.homepage.listview.card.i.a.a> bBQ;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(tbPageContext, view);
        this.bAt = 3;
        this.mPageContext = tbPageContext;
        this.bAs = (LinearLayout) view.findViewById(n.f.card_hot_video_layout);
        this.bBQ = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(b bVar) {
        super.D(bVar);
        if (bVar.bBO != null) {
            if (y.k(bVar.bBO) > 3) {
                bVar.bBO = bVar.bBO.subList(0, 3);
            }
            com.baidu.tieba.homepage.fragment.a.b.a(this.mPageContext.getPageActivity(), this.bAs, bVar.bBO, b.a.class, this.bBQ, com.baidu.tieba.homepage.listview.card.i.a.a.class);
        }
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        if (this.mSkinType != i && y.k(this.bBQ) != 0) {
            Iterator<com.baidu.tieba.homepage.listview.card.i.a.a> it = this.bBQ.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.listview.card.i.a.a next = it.next();
                if (next != null) {
                    next.cZ(i);
                }
            }
        }
        super.cZ(i);
    }
}

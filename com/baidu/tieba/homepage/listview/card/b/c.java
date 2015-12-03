package com.baidu.tieba.homepage.listview.card.b;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.multiItemViewPager.MultiItemViewPager;
import com.baidu.tieba.homepage.listview.card.b.b;
import com.baidu.tieba.homepage.listview.card.c.d;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.homepage.listview.c<b> {
    private final int bxZ;
    private MultiItemViewPager bzA;
    private com.baidu.tbadk.widget.multiItemViewPager.a bzB;
    private LinearLayout bzC;
    private HorizontalScrollView bzD;
    private ArrayList<com.baidu.tieba.homepage.listview.card.b.a.a> bzE;
    private final int bzF;
    private TbPageContext<?> mPageContext;

    public c(View view, TbPageContext<?> tbPageContext) {
        super(tbPageContext, view);
        this.bxZ = 4;
        this.bzF = 10;
        this.mPageContext = tbPageContext;
        this.bzA = (MultiItemViewPager) view.findViewById(n.f.fun_center_multi_item_viewpager);
        this.bzD = (HorizontalScrollView) view.findViewById(n.f.fun_center_horizontal_layout);
        this.bzC = (LinearLayout) view.findViewById(n.f.fun_center_horizontal_ll_layout);
        this.bzE = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(b bVar) {
        d.a aVar;
        super.D(bVar);
        this.byH.setVisibility(0);
        if (bVar != null && bVar.byY != null) {
            this.byH.setText(bVar.byY);
        }
        List<d.a> list = bVar.bzv;
        if (y.k(list) < 3) {
            this.bzA.setVisibility(8);
        } else {
            this.bzA.setVisibility(0);
            ArrayList<com.baidu.tbadk.widget.multiItemViewPager.c> arrayList = new ArrayList<>();
            for (int i = 0; i < 4 && (aVar = (d.a) y.b(list, i)) != null; i++) {
                com.baidu.tbadk.widget.multiItemViewPager.c cVar = new com.baidu.tbadk.widget.multiItemViewPager.c();
                cVar.aCH = aVar.byT;
                cVar.link = aVar.bzX;
                cVar.position = i + 1;
                arrayList.add(cVar);
            }
            this.bzB = new com.baidu.tbadk.widget.multiItemViewPager.a(this.mPageContext);
            this.bzB.ap("c10554", "obj_locate");
            this.bzB.setData(arrayList);
            this.bzA.setAdapter(this.bzB);
        }
        int k = y.k(bVar.bzw);
        if (k == 0) {
            this.bzD.setVisibility(8);
            return;
        }
        if (k >= 10) {
            bVar.bzw = bVar.bzw.subList(0, 10);
        }
        this.bzD.setVisibility(0);
        new ArrayList().addAll(bVar.bzw);
        com.baidu.tieba.homepage.fragment.a.b.a(this.mPageContext.getPageActivity(), this.bzC, bVar.bzw, b.a.class, this.bzE, com.baidu.tieba.homepage.listview.card.b.a.a.class);
        Iterator<com.baidu.tieba.homepage.listview.card.b.a.a> it = this.bzE.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.homepage.listview.card.b.a.a next = it.next();
            int a = y.a(this.bzE, next);
            if (a >= 0) {
                next.setPosition(a);
            }
        }
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        if (this.mSkinType != i) {
            Iterator<com.baidu.tieba.homepage.listview.card.b.a.a> it = this.bzE.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.homepage.listview.card.b.a.a next = it.next();
                if (next != null) {
                    next.cZ(i);
                }
            }
        }
        super.cZ(i);
    }
}

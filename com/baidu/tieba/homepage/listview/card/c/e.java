package com.baidu.tieba.homepage.listview.card.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.listview.card.c.d;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.homepage.listview.c<d> {
    private d bAa;
    public com.baidu.tbadk.core.view.viewpager.a.b bxY;
    private final int bxZ;
    public List<com.baidu.tieba.homepage.listview.a.c> bzY;
    private ViewGroup bzZ;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, View view) {
        super(tbPageContext, view);
        this.bxZ = 4;
        this.mPageContext = tbPageContext;
        this.bzZ = (ViewGroup) view.findViewById(n.f.hot_activity_card_root);
        this.bzY = new ArrayList();
    }

    private com.baidu.tbadk.core.view.viewpager.a.b Ud() {
        com.baidu.tbadk.core.view.viewpager.a.b bVar = new com.baidu.tbadk.core.view.viewpager.a.b(this.mPageContext.getPageActivity());
        bVar.setLayoutParams(new LinearLayout.LayoutParams(-1, k.d(this.mPageContext.getPageActivity(), n.d.ds240)));
        bVar.setMaxScrollCountLimit(4);
        bVar.setOnItemClickListener(new f(this));
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(d dVar) {
        super.D(dVar);
        if (this.bxY != null) {
            this.bzZ.removeView(this.bxY);
        }
        if (y.k(dVar.bzU) != 0) {
            com.baidu.tbadk.core.view.viewpager.a.b Ud = Ud();
            if (y.k(dVar.bzU) > 4) {
                dVar.bzU = dVar.bzU.subList(0, 4);
            }
            ArrayList arrayList = new ArrayList();
            for (h hVar : dVar.bzU) {
                arrayList.add(hVar);
            }
            Ud.setData(arrayList);
            this.bzZ.addView(Ud, 0);
            this.bxY = Ud;
        }
        ArrayList arrayList2 = new ArrayList();
        if (y.k(dVar.bzV) != 0) {
            ArrayList arrayList3 = new ArrayList();
            for (d.a aVar : dVar.bzV) {
                if (aVar != null) {
                    com.baidu.tieba.homepage.listview.a.a aVar2 = new com.baidu.tieba.homepage.listview.a.a();
                    aVar2.byT = aVar.byT;
                    aVar2.bzW = aVar.bzW;
                    aVar2.bCd = new g(this, dVar, aVar);
                    arrayList3.add(aVar2);
                }
            }
            com.baidu.tieba.homepage.listview.a.b bVar = new com.baidu.tieba.homepage.listview.a.b();
            bVar.awS = arrayList3;
            bVar.bCe = false;
            arrayList2.add(bVar);
        }
        com.baidu.tieba.homepage.fragment.a.b.a(this.mPageContext.getPageActivity(), this.bzZ, arrayList2, com.baidu.tieba.homepage.listview.a.b.class, this.bzY, com.baidu.tieba.homepage.listview.a.c.class);
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        com.baidu.tieba.homepage.listview.a.c cVar;
        if (this.mSkinType != i && (cVar = (com.baidu.tieba.homepage.listview.a.c) y.b(this.bzY, 0)) != null) {
            cVar.cZ(i);
        }
        super.cZ(i);
    }
}

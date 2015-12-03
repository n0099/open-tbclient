package com.baidu.tieba.homepage.listview.card.discover;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.listview.card.discover.h;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.homepage.listview.c<h> {
    private ViewGroup bzs;
    private List<k> bzt;

    public m(TbPageContext<?> tbPageContext, View view) {
        super(tbPageContext, view);
        this.bzs = null;
        this.bzt = null;
        this.bzs = (ViewGroup) view.findViewById(n.f.card_discover_root);
        this.bzt = new ArrayList();
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        if (this.mSkinType != i && this.bzt != null) {
            for (k kVar : this.bzt) {
                if (kVar != null) {
                    kVar.cZ(i);
                }
            }
        }
        super.cZ(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(h hVar) {
        super.D(hVar);
        if (hVar != null) {
            this.byN = hVar;
            this.byH.setVisibility(8);
            com.baidu.tieba.homepage.fragment.a.b.a(this.pageContext.getPageActivity(), this.bzs, hVar.bzc, h.a.class, this.bzt, k.class);
        }
    }
}

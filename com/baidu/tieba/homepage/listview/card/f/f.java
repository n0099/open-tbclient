package com.baidu.tieba.homepage.listview.card.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.listview.card.f.b;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.homepage.listview.c<b> {
    private List<c> bAQ;
    private ViewGroup bzZ;

    public f(TbPageContext<?> tbPageContext, View view) {
        super(tbPageContext, view);
        this.bzZ = null;
        this.bAQ = null;
        this.bzZ = (ViewGroup) view.findViewById(n.f.hot_thread_card_root);
        this.bAQ = new ArrayList();
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        if (this.mSkinType != i && this.bAQ != null) {
            for (c cVar : this.bAQ) {
                if (cVar != null) {
                    cVar.cZ(i);
                }
            }
        }
        super.cZ(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(b bVar) {
        super.D(bVar);
        if (bVar != null) {
            this.byH.setVisibility(0);
            this.byK.setVisibility(0);
            this.byH.setOnClickListener(new g(this, bVar));
            com.baidu.tieba.homepage.fragment.a.b.a(this.pageContext.getPageActivity(), this.bzZ, bVar.bAD, b.a.class, this.bAQ, c.class);
        }
    }
}

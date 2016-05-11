package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.c.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<ax, a> {
    private TbPageContext<?> DV;
    private int boP;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> boU;
    private com.baidu.adp.lib.f.b<TbImageView> boV;
    private w bpe;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boP = 0;
        this.boU = new com.baidu.adp.lib.f.b<>(new r(this), 6, 0);
        this.boV = new com.baidu.adp.lib.f.b<>(new s(this), 12, 0);
        this.DV = tbPageContext;
        this.boP = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public a b(ViewGroup viewGroup) {
        this.bpe = new w(this.DV);
        this.bpe.setConstrainLayoutPool(this.boU);
        this.bpe.setConstrainImagePool(this.boV);
        this.bpe.j(this.DV.getUniqueId());
        return new a(this.bpe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ax axVar, a aVar) {
        a(i, view, axVar, aVar);
        aVar.bpg.h(axVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bpe != null) {
            this.bpe.setFromCDN(z);
        }
    }

    private void a(int i, View view, ax axVar, a aVar) {
        MetaData author;
        if (axVar != null && aVar != null && (author = axVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                aVar.bpg.bkR.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.bpg.bpJ.getLayoutParams();
                layoutParams.topMargin = 0;
                aVar.bpg.bpJ.setLayoutParams(layoutParams);
                return;
            }
            aVar.bpg.bkR.setVisibility(0);
            aVar.bpg.bkR.setImageBitmap(null);
            aVar.bpg.bkR.c(themeCard.getCardImageUrlAndroid(), 10, false);
            aVar.bpg.bkR.setOnClickListener(new t(this, themeCard));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.bpg.bpJ.getLayoutParams();
            layoutParams2.topMargin = this.boP;
            aVar.bpg.bpJ.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public w bpg;

        public a(w wVar) {
            super(wVar.getView());
            this.bpg = wVar;
        }
    }
}

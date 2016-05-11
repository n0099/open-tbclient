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
import com.baidu.tieba.frs.entelechy.c.ak;
import com.baidu.tieba.frs.entelechy.c.al;
import com.baidu.tieba.frs.entelechy.c.am;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<ax, a> {
    private TbPageContext<?> DV;
    private int boP;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.boP = 0;
        this.DV = tbPageContext;
        this.boP = com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ax axVar, a aVar) {
        a(i, view, axVar, aVar);
        aVar.boR.h(axVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public a b(ViewGroup viewGroup) {
        am amVar = null;
        if (this.yd == ax.PX) {
            amVar = new ak(this.DV);
        } else if (this.yd == ax.PY) {
            amVar = new al(this.DV);
        }
        if (amVar != null) {
            amVar.j(this.DV.getUniqueId());
            amVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new a(amVar);
    }

    private void a(int i, View view, ax axVar, a aVar) {
        MetaData author;
        if (axVar != null && aVar != null && (author = axVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                aVar.boR.bkR.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.boR.bpJ.getLayoutParams();
                layoutParams.topMargin = 0;
                aVar.boR.bpJ.setLayoutParams(layoutParams);
            } else {
                aVar.boR.bkR.setVisibility(0);
                aVar.boR.bkR.setImageBitmap(null);
                aVar.boR.bkR.c(themeCard.getCardImageUrlAndroid(), 10, false);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.boR.bpJ.getLayoutParams();
                layoutParams2.topMargin = this.boP;
                aVar.boR.bpJ.setLayoutParams(layoutParams2);
            }
            aVar.boR.bkR.setOnClickListener(new h(this, themeCard));
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public am boR;

        public a(am amVar) {
            super(amVar.getView());
            this.boR = amVar;
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

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
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.frs.entelechy.view.ak;
import com.baidu.tieba.frs.entelechy.view.al;
import com.baidu.tieba.frs.entelechy.view.am;
import com.baidu.tieba.frs.entelechy.view.aw;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<be, a> implements aw, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> EA;
    private bx bKK;
    private int bKN;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bKN = 0;
        this.bKK = new l(this);
        this.EA = tbPageContext;
        this.bKN = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, be beVar, a aVar) {
        a(i, view, beVar, aVar);
        aVar.bKP.i(beVar);
        aVar.bKP.setForumName(this.mForumName);
        aVar.bKP.a(this.bKK);
        com.baidu.tieba.frs.h.b.aam().a(bSh, beVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public a a(ViewGroup viewGroup) {
        am amVar = null;
        if (this.yG == be.QG) {
            amVar = new ak(this.EA);
        } else if (this.yG == be.QH) {
            amVar = new al(this.EA);
        }
        if (amVar != null) {
            amVar.j(this.EA.getUniqueId());
            amVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new a(amVar);
    }

    private void a(int i, View view, be beVar, a aVar) {
        MetaData author;
        if (beVar != null && aVar != null && (author = beVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                aVar.bKP.bHg.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.bKP.bLY.getLayoutParams();
                layoutParams.topMargin = 0;
                aVar.bKP.bLY.setLayoutParams(layoutParams);
            } else {
                aVar.bKP.bHg.setVisibility(0);
                aVar.bKP.bHg.setImageBitmap(null);
                aVar.bKP.bHg.c(themeCard.getCardImageUrlAndroid(), 10, false);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.bKP.bLY.getLayoutParams();
                layoutParams2.topMargin = this.bKN;
                aVar.bKP.bLY.setLayoutParams(layoutParams2);
            }
            aVar.bKP.bHg.setOnClickListener(new m(this, themeCard));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aw
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public am bKP;

        public a(am amVar) {
            super(amVar.getView());
            this.bKP = amVar;
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

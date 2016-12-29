package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.frs.entelechy.view.as;
import com.baidu.tieba.frs.entelechy.view.bb;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<bg, com.baidu.tieba.card.a.a<as>> implements bb, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GO;
    private cb bES;
    private int bEU;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bEU = 0;
        this.bES = new l(this);
        this.GO = tbPageContext;
        this.bEU = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a<as> aVar) {
        if (aVar == null || aVar.Po() == null) {
            return null;
        }
        a(i, view, bgVar, aVar);
        aVar.Po().onBindDataToView(bgVar);
        aVar.Po().setForumName(this.mForumName);
        aVar.Po().setOnSubCardOnClickListenner(this.bES);
        com.baidu.tieba.frs.g.b.abq().a(bMV, bgVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        as asVar = null;
        if (this.AT == bg.Tu) {
            asVar = new com.baidu.tieba.frs.entelechy.view.ak(this.GO);
        } else if (this.AT == bg.Tv) {
            asVar = new com.baidu.tieba.frs.entelechy.view.al(this.GO);
        }
        if (asVar != null) {
            asVar.j(this.GO.getUniqueId());
            asVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.a.a(asVar);
    }

    private void a(int i, View view, bg bgVar, com.baidu.tieba.card.a.a<as> aVar) {
        if (bgVar != null && aVar != null) {
            bgVar.sB();
            MetaData author = bgVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.Po().bAE.setVisibility(8);
                } else {
                    aVar.Po().bAE.setVisibility(0);
                    aVar.Po().bAE.setImageBitmap(null);
                    aVar.Po().bAE.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.Po().bAE.setOnClickListener(new m(this, themeCard));
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.bb
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

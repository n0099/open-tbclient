package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.ag;
import com.baidu.tieba.frs.entelechy.view.ah;
import com.baidu.tieba.frs.entelechy.view.ao;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.b.a<ao>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajh;
    private int bYj;
    private ci bdp;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = true;
        this.bYj = 0;
        this.bdp = new l(this);
        this.ajh = tbPageContext;
        this.bYj = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.b.a<ao> aVar) {
        if (aVar == null || aVar.UY() == null) {
            return null;
        }
        a(i, view, blVar, aVar);
        aVar.UY().a(blVar);
        aVar.UY().setForumName(this.mForumName);
        aVar.UY().a(this.bdp);
        com.baidu.tieba.frs.d.b.adw().a(cfm, blVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = null;
        if (this.mType == bl.Xy) {
            aoVar = new ag(this.ajh, this.mPageId);
        } else if (this.mType == bl.Xz) {
            aoVar = new ah(this.ajh, this.mPageId);
        }
        if (aoVar != null) {
            aoVar.j(this.mPageId);
            aoVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.b.a(aoVar);
    }

    private void a(int i, View view, bl blVar, com.baidu.tieba.card.b.a<ao> aVar) {
        if (blVar != null && aVar != null) {
            blVar.ss();
            MetaData author = blVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.UY().bVW.setVisibility(8);
                } else {
                    aVar.UY().bVW.setVisibility(0);
                    aVar.UY().bVW.setImageBitmap(null);
                    aVar.UY().bVW.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.UY().bVW.setOnClickListener(new m(this, themeCard));
            }
        }
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

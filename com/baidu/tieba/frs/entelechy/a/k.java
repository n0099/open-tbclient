package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.ag;
import com.baidu.tieba.frs.entelechy.view.ah;
import com.baidu.tieba.frs.entelechy.view.ao;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<bk, com.baidu.tieba.card.b.a<ao>> implements cb, com.baidu.tieba.frs.c.e {
    private TbPageContext<?> ajr;
    private cd bSq;
    private int bSs;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = true;
        this.bSs = 0;
        this.bSq = new l(this);
        this.ajr = tbPageContext;
        this.bSs = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.tieba.card.b.a<ao> aVar) {
        if (aVar == null || aVar.TU() == null) {
            return null;
        }
        a(i, view, bkVar, aVar);
        aVar.TU().onBindDataToView(bkVar);
        aVar.TU().setForumName(this.mForumName);
        aVar.TU().setOnSubCardOnClickListenner(this.bSq);
        com.baidu.tieba.frs.c.b.acs().a(bZb, bkVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = null;
        if (this.mType == bk.XC) {
            aoVar = new ag(this.ajr, this.mPageId);
        } else if (this.mType == bk.XD) {
            aoVar = new ah(this.ajr, this.mPageId);
        }
        if (aoVar != null) {
            aoVar.j(this.mPageId);
            aoVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.b.a(aoVar);
    }

    private void a(int i, View view, bk bkVar, com.baidu.tieba.card.b.a<ao> aVar) {
        if (bkVar != null && aVar != null) {
            bkVar.sw();
            MetaData author = bkVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.TU().bQf.setVisibility(8);
                } else {
                    aVar.TU().bQf.setVisibility(0);
                    aVar.TU().bQf.setImageBitmap(null);
                    aVar.TU().bQf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.TU().bQf.setOnClickListener(new m(this, themeCard));
            }
        }
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

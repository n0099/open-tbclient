package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.ag;
import com.baidu.tieba.frs.entelechy.view.ah;
import com.baidu.tieba.frs.entelechy.view.ao;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<bm, com.baidu.tieba.card.b.a<ao>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajP;
    private ci bgj;
    private int cgs;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = true;
        this.cgs = 0;
        this.bgj = new l(this);
        this.ajP = tbPageContext;
        this.cgs = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bm bmVar, com.baidu.tieba.card.b.a<ao> aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        a(i, view, bmVar, aVar);
        aVar.Wp().a(bmVar);
        aVar.Wp().setForumName(this.mForumName);
        aVar.Wp().a(this.bgj);
        com.baidu.tieba.frs.d.b.aho().a(cnC, bmVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        ao aoVar = null;
        if (this.mType == bm.Xy) {
            aoVar = new ag(this.ajP, this.mPageId);
        } else if (this.mType == bm.Xz) {
            aoVar = new ah(this.ajP, this.mPageId);
        }
        if (aoVar != null) {
            aoVar.j(this.mPageId);
            aoVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.b.a(aoVar);
    }

    private void a(int i, View view, bm bmVar, com.baidu.tieba.card.b.a<ao> aVar) {
        if (bmVar != null && aVar != null) {
            bmVar.sp();
            MetaData author = bmVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.Wp().cee.setVisibility(8);
                } else {
                    aVar.Wp().cee.setVisibility(0);
                    aVar.Wp().cee.setImageBitmap(null);
                    aVar.Wp().cee.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.Wp().cee.setOnClickListener(new m(this, themeCard));
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

package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.entelechy.view.as;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.b.a<as>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> FY;
    private cf bLl;
    private int bLn;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bLn = 0;
        this.bLl = new l(this);
        this.FY = tbPageContext;
        this.bLn = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.b.a<as> aVar) {
        if (aVar == null || aVar.Sd() == null) {
            return null;
        }
        a(i, view, bhVar, aVar);
        aVar.Sd().onBindDataToView(bhVar);
        aVar.Sd().setForumName(this.mForumName);
        aVar.Sd().setOnSubCardOnClickListenner(this.bLl);
        com.baidu.tieba.frs.e.b.acx().a(bTj, bhVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        as asVar = null;
        if (this.mType == bh.SG) {
            asVar = new com.baidu.tieba.frs.entelechy.view.ak(this.FY);
        } else if (this.mType == bh.SH) {
            asVar = new com.baidu.tieba.frs.entelechy.view.al(this.FY);
        }
        if (asVar != null) {
            asVar.j(this.FY.getUniqueId());
            asVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.b.a(asVar);
    }

    private void a(int i, View view, bh bhVar, com.baidu.tieba.card.b.a<as> aVar) {
        if (bhVar != null && aVar != null) {
            bhVar.st();
            MetaData author = bhVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.Sd().bHZ.setVisibility(8);
                } else {
                    aVar.Sd().bHZ.setVisibility(0);
                    aVar.Sd().bHZ.setImageBitmap(null);
                    aVar.Sd().bHZ.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.Sd().bHZ.setOnClickListener(new m(this, themeCard));
            }
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

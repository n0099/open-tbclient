package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.entelechy.view.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<bi, com.baidu.tieba.card.b.a<as>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajT;
    private cf bSf;
    private int bSh;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bSh = 0;
        this.bSf = new l(this);
        this.ajT = tbPageContext;
        this.bSh = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.tieba.card.b.a<as> aVar) {
        if (aVar == null || aVar.Tz() == null) {
            return null;
        }
        a(i, view, biVar, aVar);
        aVar.Tz().onBindDataToView(biVar);
        aVar.Tz().setForumName(this.mForumName);
        aVar.Tz().setOnSubCardOnClickListenner(this.bSf);
        com.baidu.tieba.frs.e.b.adp().a(bYW, biVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        as asVar = null;
        if (this.mType == bi.Yj) {
            asVar = new com.baidu.tieba.frs.entelechy.view.ak(this.ajT);
        } else if (this.mType == bi.Yk) {
            asVar = new com.baidu.tieba.frs.entelechy.view.al(this.ajT);
        }
        if (asVar != null) {
            asVar.j(this.ajT.getUniqueId());
            asVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.b.a(asVar);
    }

    private void a(int i, View view, bi biVar, com.baidu.tieba.card.b.a<as> aVar) {
        if (biVar != null && aVar != null) {
            biVar.tm();
            MetaData author = biVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.Tz().bOX.setVisibility(8);
                } else {
                    aVar.Tz().bOX.setVisibility(0);
                    aVar.Tz().bOX.setImageBitmap(null);
                    aVar.Tz().bOX.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.Tz().bOX.setOnClickListener(new m(this, themeCard));
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

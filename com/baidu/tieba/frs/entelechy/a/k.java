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
    private TbPageContext<?> ajU;
    private cf bUw;
    private int bUy;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bUy = 0;
        this.bUw = new l(this);
        this.ajU = tbPageContext;
        this.bUy = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.tieba.card.b.a<as> aVar) {
        if (aVar == null || aVar.UB() == null) {
            return null;
        }
        a(i, view, biVar, aVar);
        aVar.UB().onBindDataToView(biVar);
        aVar.UB().setForumName(this.mForumName);
        aVar.UB().setOnSubCardOnClickListenner(this.bUw);
        com.baidu.tieba.frs.e.b.aeq().a(cbn, biVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        as asVar = null;
        if (this.mType == bi.Yk) {
            asVar = new com.baidu.tieba.frs.entelechy.view.ak(this.ajU);
        } else if (this.mType == bi.Yl) {
            asVar = new com.baidu.tieba.frs.entelechy.view.al(this.ajU);
        }
        if (asVar != null) {
            asVar.j(this.ajU.getUniqueId());
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
                    aVar.UB().bRo.setVisibility(8);
                } else {
                    aVar.UB().bRo.setVisibility(0);
                    aVar.UB().bRo.setImageBitmap(null);
                    aVar.UB().bRo.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.UB().bRo.setOnClickListener(new m(this, themeCard));
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

package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.entelechy.view.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<bj, com.baidu.tieba.card.b.a<as>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajF;
    private cf bSr;
    private int bSt;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bSt = 0;
        this.bSr = new l(this);
        this.ajF = tbPageContext;
        this.bSt = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.card.b.a<as> aVar) {
        if (aVar == null || aVar.Tb() == null) {
            return null;
        }
        a(i, view, bjVar, aVar);
        aVar.Tb().onBindDataToView(bjVar);
        aVar.Tb().setForumName(this.mForumName);
        aVar.Tb().setOnSubCardOnClickListenner(this.bSr);
        com.baidu.tieba.frs.e.b.adv().a(cav, bjVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        as asVar = null;
        if (this.mType == bj.XT) {
            asVar = new com.baidu.tieba.frs.entelechy.view.ak(this.ajF);
        } else if (this.mType == bj.XU) {
            asVar = new com.baidu.tieba.frs.entelechy.view.al(this.ajF);
        }
        if (asVar != null) {
            asVar.j(this.ajF.getUniqueId());
            asVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.b.a(asVar);
    }

    private void a(int i, View view, bj bjVar, com.baidu.tieba.card.b.a<as> aVar) {
        if (bjVar != null && aVar != null) {
            bjVar.sO();
            MetaData author = bjVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.Tb().bPi.setVisibility(8);
                } else {
                    aVar.Tb().bPi.setVisibility(0);
                    aVar.Tb().bPi.setImageBitmap(null);
                    aVar.Tb().bPi.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.Tb().bPi.setOnClickListener(new m(this, themeCard));
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

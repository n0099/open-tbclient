package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.an;
import com.baidu.tieba.frs.entelechy.view.ao;
import com.baidu.tieba.frs.entelechy.view.ap;
import com.baidu.tieba.frs.entelechy.view.az;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<bi, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private cd bVT;
    private int bVW;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bVW = 0;
        this.bVT = new j(this);
        this.GM = tbPageContext;
        this.bVW = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        a(i, view, biVar, aVar);
        aVar.bVY.onBindDataToView(biVar);
        aVar.bVY.setForumName(this.mForumName);
        aVar.bVY.setOnSubCardOnClickListenner(this.bVT);
        com.baidu.tieba.frs.g.b.afl().a(cdl, biVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public a a(ViewGroup viewGroup) {
        ap apVar = null;
        if (this.AV == bi.Tx) {
            apVar = new an(this.GM);
        } else if (this.AV == bi.Ty) {
            apVar = new ao(this.GM);
        }
        if (apVar != null) {
            apVar.j(this.GM.getUniqueId());
            apVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new a(apVar);
    }

    private void a(int i, View view, bi biVar, a aVar) {
        if (biVar != null && aVar != null) {
            biVar.sL();
            MetaData author = biVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.bVY.bSf.setVisibility(8);
                } else {
                    aVar.bVY.bSf.setVisibility(0);
                    aVar.bVY.bSf.setImageBitmap(null);
                    aVar.bVY.bSf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.bVY.bSf.setOnClickListener(new k(this, themeCard));
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public ap bVY;

        public a(ap apVar) {
            super(apVar.getView());
            this.bVY = apVar;
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

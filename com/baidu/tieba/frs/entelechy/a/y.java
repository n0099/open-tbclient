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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.view.au;
import com.baidu.tieba.u;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<az, a> implements au {
    private TbPageContext<?> Ea;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bHW;
    private com.baidu.adp.lib.f.b<TbImageView> bHX;
    private com.baidu.tieba.frs.entelechy.view.u bJM;
    private int bJi;
    private String mForumName;

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJi = 0;
        this.bHW = new com.baidu.adp.lib.f.b<>(new z(this), 6, 0);
        this.bHX = new com.baidu.adp.lib.f.b<>(new aa(this), 12, 0);
        this.Ea = tbPageContext;
        this.bJi = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: H */
    public a a(ViewGroup viewGroup) {
        this.bJM = new com.baidu.tieba.frs.entelechy.view.u(this.Ea);
        this.bJM.setConstrainLayoutPool(this.bHW);
        this.bJM.setConstrainImagePool(this.bHX);
        this.bJM.j(this.Ea.getUniqueId());
        return new a(this.bJM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, az azVar, a aVar) {
        a(i, view, azVar, aVar);
        aVar.bJO.h(azVar);
        aVar.bJO.setForumName(this.mForumName);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bJM != null) {
            this.bJM.setFromCDN(z);
        }
    }

    private void a(int i, View view, az azVar, a aVar) {
        MetaData author;
        if (azVar != null && aVar != null && (author = azVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo qZ = azVar.qZ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.bJO.aTK.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.bJO.aTc.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                aVar.bJO.bFR.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aVar.bJO.bKq.getLayoutParams();
                layoutParams3.topMargin = 0;
                aVar.bJO.bKq.setLayoutParams(layoutParams3);
                if (aVar.bJO.bGc != null) {
                    if (qZ != null) {
                        aVar.bJO.bGc.a(this.Ea, qZ, com.baidu.tieba.tbadkCore.d.a.a("FRS", "c0131", String.valueOf(azVar.getFid()), azVar.getForum_name(), azVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds16);
                    } else {
                        aVar.bJO.bGc.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds30);
                    }
                }
            } else {
                aVar.bJO.bFR.setVisibility(0);
                aVar.bJO.bFR.setImageBitmap(null);
                aVar.bJO.bFR.c(themeCard.getCardImageUrlAndroid(), 10, false);
                aVar.bJO.bFR.setOnClickListener(new ab(this, themeCard));
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) aVar.bJO.bKq.getLayoutParams();
                layoutParams4.topMargin = this.bJi;
                aVar.bJO.bKq.setLayoutParams(layoutParams4);
                aVar.bJO.bGc.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds30);
            }
            aVar.bJO.aTK.setLayoutParams(layoutParams);
            aVar.bJO.aTc.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.au
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.view.u bJO;

        public a(com.baidu.tieba.frs.entelechy.view.u uVar) {
            super(uVar.getView());
            this.bJO = uVar;
        }
    }
}

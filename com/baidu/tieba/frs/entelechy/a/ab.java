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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.frs.entelechy.view.aw;
import com.baidu.tieba.u;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.widget.ListView.a<be, a> implements aw, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> EA;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bJr;
    private com.baidu.adp.lib.f.b<TbImageView> bJs;
    private int bKN;
    private bx<be> bLl;
    private com.baidu.tieba.frs.entelechy.view.v bLr;
    private String mForumName;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKN = 0;
        this.bLl = new ac(this);
        this.bJr = new com.baidu.adp.lib.f.b<>(new ad(this), 6, 0);
        this.bJs = new com.baidu.adp.lib.f.b<>(new ae(this), 12, 0);
        this.EA = tbPageContext;
        this.bKN = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: H */
    public a a(ViewGroup viewGroup) {
        this.bLr = new com.baidu.tieba.frs.entelechy.view.v(this.EA);
        this.bLr.setConstrainLayoutPool(this.bJr);
        this.bLr.setConstrainImagePool(this.bJs);
        this.bLr.j(this.EA.getUniqueId());
        return new a(this.bLr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, be beVar, a aVar) {
        a(i, view, beVar, aVar);
        aVar.bLt.i(beVar);
        aVar.bLt.setForumName(this.mForumName);
        aVar.bLt.a(this.bLl);
        com.baidu.tieba.frs.h.b.aam().a(bSh, beVar);
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bLr != null) {
            this.bLr.setFromCDN(z);
        }
    }

    private void a(int i, View view, be beVar, a aVar) {
        MetaData author;
        if (beVar != null && aVar != null && (author = beVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo qP = beVar.qP();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.bLt.aUG.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.bLt.aTY.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                aVar.bLt.bHg.setVisibility(8);
                aVar.bLt.bLY.setPadding(aVar.bLt.bLY.getPaddingLeft(), 0, aVar.bLt.bLY.getPaddingRight(), aVar.bLt.bLY.getPaddingBottom());
                if (aVar.bLt.bHx != null) {
                    if (qP != null) {
                        aVar.bLt.bHx.a(this.EA, qP, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(beVar.getFid()), beVar.getForum_name(), beVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds16);
                    } else {
                        aVar.bLt.bHx.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds30);
                    }
                }
            } else {
                aVar.bLt.bHg.setVisibility(0);
                aVar.bLt.bHg.setImageBitmap(null);
                aVar.bLt.bHg.c(themeCard.getCardImageUrlAndroid(), 10, false);
                aVar.bLt.bHg.setOnClickListener(new af(this, themeCard));
                aVar.bLt.bLY.setPadding(aVar.bLt.bLY.getPaddingLeft(), this.bKN, aVar.bLt.bLY.getPaddingRight(), aVar.bLt.bLY.getPaddingBottom());
                aVar.bLt.bHx.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds30);
            }
            aVar.bLt.aUG.setLayoutParams(layoutParams);
            aVar.bLt.aTY.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aw
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.view.v bLt;

        public a(com.baidu.tieba.frs.entelechy.view.v vVar) {
            super(vVar.getView());
            this.bLt = vVar;
        }
    }
}

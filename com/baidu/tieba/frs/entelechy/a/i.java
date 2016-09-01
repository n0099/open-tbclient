package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.entelechy.view.an;
import com.baidu.tieba.frs.entelechy.view.ao;
import com.baidu.tieba.frs.entelechy.view.ap;
import com.baidu.tieba.frs.entelechy.view.az;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<bg, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private cf bVU;
    private int bVX;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bVX = 0;
        this.bVU = new j(this);
        this.GM = tbPageContext;
        this.bVX = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, a aVar) {
        a(i, view, bgVar, aVar);
        aVar.bVZ.onBindDataToView(bgVar);
        aVar.bVZ.setForumName(this.mForumName);
        aVar.bVZ.setOnSubCardOnClickListenner(this.bVU);
        com.baidu.tieba.frs.g.b.aeX().a(cdn, bgVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public a a(ViewGroup viewGroup) {
        ap apVar = null;
        if (this.AV == bg.Tp) {
            apVar = new an(this.GM);
        } else if (this.AV == bg.Tq) {
            apVar = new ao(this.GM);
        }
        if (apVar != null) {
            apVar.j(this.GM.getUniqueId());
            apVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new a(apVar);
    }

    private void a(int i, View view, bg bgVar, a aVar) {
        MetaData author;
        if (bgVar != null && aVar != null && (author = bgVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                aVar.bVZ.bSm.setVisibility(8);
            } else {
                aVar.bVZ.bSm.setVisibility(0);
                aVar.bVZ.bSm.setImageBitmap(null);
                aVar.bVZ.bSm.c(themeCard.getCardImageUrlAndroid(), 10, false);
            }
            aVar.bVZ.bSm.setOnClickListener(new k(this, themeCard));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public ap bVZ;

        public a(ap apVar) {
            super(apVar.getView());
            this.bVZ = apVar;
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

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
import com.baidu.tieba.frs.entelechy.view.ai;
import com.baidu.tieba.frs.entelechy.view.aj;
import com.baidu.tieba.frs.entelechy.view.ak;
import com.baidu.tieba.frs.entelechy.view.au;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<az, a> implements au {
    private TbPageContext<?> Ea;
    private int bJi;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bJi = 0;
        this.Ea = tbPageContext;
        this.bJi = com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, az azVar, a aVar) {
        a(i, view, azVar, aVar);
        aVar.bJk.h(azVar);
        aVar.bJk.setForumName(this.mForumName);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public a a(ViewGroup viewGroup) {
        ak akVar = null;
        if (this.yf == az.Ql) {
            akVar = new ai(this.Ea);
        } else if (this.yf == az.Qm) {
            akVar = new aj(this.Ea);
        }
        if (akVar != null) {
            akVar.j(this.Ea.getUniqueId());
            akVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new a(akVar);
    }

    private void a(int i, View view, az azVar, a aVar) {
        MetaData author;
        if (azVar != null && aVar != null && (author = azVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                aVar.bJk.bFR.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.bJk.bKq.getLayoutParams();
                layoutParams.topMargin = 0;
                aVar.bJk.bKq.setLayoutParams(layoutParams);
            } else {
                aVar.bJk.bFR.setVisibility(0);
                aVar.bJk.bFR.setImageBitmap(null);
                aVar.bJk.bFR.c(themeCard.getCardImageUrlAndroid(), 10, false);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.bJk.bKq.getLayoutParams();
                layoutParams2.topMargin = this.bJi;
                aVar.bJk.bKq.setLayoutParams(layoutParams2);
            }
            aVar.bJk.bFR.setOnClickListener(new l(this, themeCard));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.au
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public ak bJk;

        public a(ak akVar) {
            super(akVar.getView());
            this.bJk = akVar;
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

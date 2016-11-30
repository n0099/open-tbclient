package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.frs.entelechy.view.am;
import com.baidu.tieba.frs.entelechy.view.an;
import com.baidu.tieba.frs.entelechy.view.ao;
import com.baidu.tieba.frs.entelechy.view.ba;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<bk, a> implements ba, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> GO;
    private bz bZe;
    private int bZh;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        this.bZh = 0;
        this.bZe = new k(this);
        this.GO = tbPageContext;
        this.bZh = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        a(i, view, bkVar, aVar);
        aVar.bZj.onBindDataToView(bkVar);
        aVar.bZj.setForumName(this.mForumName);
        aVar.bZj.setOnSubCardOnClickListenner(this.bZe);
        com.baidu.tieba.frs.h.b.agV().a(chm, bkVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public a a(ViewGroup viewGroup) {
        ao aoVar = null;
        if (this.AV == bk.TT) {
            aoVar = new am(this.GO);
        } else if (this.AV == bk.TU) {
            aoVar = new an(this.GO);
        }
        if (aoVar != null) {
            aoVar.j(this.GO.getUniqueId());
            aoVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new a(aoVar);
    }

    private void a(int i, View view, bk bkVar, a aVar) {
        if (bkVar != null && aVar != null) {
            bkVar.sN();
            MetaData author = bkVar.getAuthor();
            if (author != null) {
                ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.bZj.bUs.setVisibility(8);
                } else {
                    aVar.bZj.bUs.setVisibility(0);
                    aVar.bZj.bUs.setImageBitmap(null);
                    aVar.bZj.bUs.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.bZj.bUs.setOnClickListener(new l(this, themeCard));
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public ao bZj;

        public a(ao aoVar) {
            super(aoVar.getView());
            this.bZj = aoVar;
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

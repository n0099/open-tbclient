package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i>> implements v, com.baidu.tieba.frs.e.c {
    private x bon;
    private int cEa;
    private String mForumName;
    private boolean mIsFromCDN;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = true;
        this.cEa = 0;
        this.bon = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.g.card_vote_header_image) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cPx, bhVar.rS());
                    } else {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 1);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.cEa = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i> aVar) {
        if (aVar == null || aVar.aaJ() == null) {
            return null;
        }
        a(i, view, bhVar, aVar);
        aVar.aaJ().a(bhVar);
        aVar.aaJ().setForumName(this.mForumName);
        aVar.aaJ().b(this.bon);
        com.baidu.tieba.frs.e.b.aot().a(cPx, bhVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.i iVar = null;
        if (this.mType == bh.Yz) {
            iVar = new com.baidu.tieba.frs.entelechy.view.f(this.mPageContext, this.mPageId);
        } else if (this.mType == bh.YA) {
            iVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        }
        if (iVar != null) {
            iVar.k(this.mPageId);
            iVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.a.a(iVar);
    }

    private void a(int i, View view, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i> aVar) {
        if (bhVar != null && aVar != null) {
            bhVar.st();
            MetaData rt = bhVar.rt();
            if (rt != null) {
                final ThemeCardInUserData themeCard = rt.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.aaJ().czY.setVisibility(8);
                } else {
                    aVar.aaJ().czY.setVisibility(0);
                    aVar.aaJ().czY.setImageBitmap(null);
                    aVar.aaJ().czY.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.aaJ().czY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(d.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

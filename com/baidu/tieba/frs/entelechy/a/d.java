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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v ciH;
    private int dHr;
    private String mForumName;
    private boolean mIsFromCDN;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = true;
        this.dHr = 0;
        this.ciH = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_vote_header_image) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dRe, bdVar.zs());
                    } else {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 1);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dHr = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i> aVar) {
        if (aVar == null || aVar.alp() == null) {
            return null;
        }
        a(i, view, bdVar, aVar);
        aVar.alp().a(bdVar);
        aVar.alp().setForumName(this.mForumName);
        aVar.alp().b(this.ciH);
        com.baidu.tieba.frs.d.b.ayP().a(dRe, bdVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.i iVar = null;
        if (this.mType == bd.aNn) {
            iVar = new com.baidu.tieba.frs.entelechy.view.f(this.mPageContext, this.mPageId);
        } else if (this.mType == bd.aNo) {
            iVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        }
        if (iVar != null) {
            iVar.j(this.mPageId);
            iVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.a.a(iVar);
    }

    private void a(int i, View view, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i> aVar) {
        if (bdVar != null && aVar != null) {
            bdVar.zP();
            MetaData yT = bdVar.yT();
            if (yT != null) {
                final ThemeCardInUserData themeCard = yT.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.alp().cWl.setVisibility(8);
                } else {
                    aVar.alp().cWl.setVisibility(0);
                    aVar.alp().cWl.setImageBitmap(null);
                    aVar.alp().cWl.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.alp().cWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(d.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}

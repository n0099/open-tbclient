package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i>> implements v, com.baidu.tieba.frs.e.c {
    private TbPageContext<?> alI;
    private x bkz;
    private int cnz;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = true;
        this.cnz = 0;
        this.bkz = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.card_vote_header_image) {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cvL, blVar.sd());
                    } else {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 1);
                    }
                }
            }
        };
        this.alI = tbPageContext;
        this.cnz = k.g(this.alI.getPageActivity(), d.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i> aVar) {
        if (aVar == null || aVar.Xc() == null) {
            return null;
        }
        a(i, view, blVar, aVar);
        aVar.Xc().a(blVar);
        aVar.Xc().setForumName(this.mForumName);
        aVar.Xc().a(this.bkz);
        com.baidu.tieba.frs.e.b.aiY().a(cvL, blVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.i iVar = null;
        if (this.mType == bl.Zl) {
            iVar = new com.baidu.tieba.frs.entelechy.view.f(this.alI, this.mPageId);
        } else if (this.mType == bl.Zm) {
            iVar = new com.baidu.tieba.frs.entelechy.view.g(this.alI, this.mPageId);
        }
        if (iVar != null) {
            iVar.j(this.mPageId);
            iVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.a.a(iVar);
    }

    private void a(int i, View view, bl blVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i> aVar) {
        if (blVar != null && aVar != null) {
            blVar.sD();
            MetaData author = blVar.getAuthor();
            if (author != null) {
                final ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.Xc().ckY.setVisibility(8);
                } else {
                    aVar.Xc().ckY.setVisibility(0);
                    aVar.Xc().ckY.setImageBitmap(null);
                    aVar.Xc().ckY.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.Xc().ckY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(d.this.alI.getPageActivity(), themeCard.getCardId())));
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

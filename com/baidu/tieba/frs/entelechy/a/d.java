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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<bj, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i>> implements v, com.baidu.tieba.frs.f.c {
    private x bkZ;
    private int cuM;
    private TbPageContext<?> mF;
    private String mForumName;
    private boolean mIsFromCDN;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mIsFromCDN = true;
        this.cuM = 0;
        this.bkZ = new x<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == d.h.card_vote_header_image) {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cEr, bjVar.rZ());
                    } else {
                        com.baidu.tieba.frs.f.b.alj().a(com.baidu.tieba.frs.f.c.cEr, bjVar, 1);
                    }
                }
            }
        };
        this.mF = tbPageContext;
        this.cuM = k.g(this.mF.getPageActivity(), d.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i> aVar) {
        if (aVar == null || aVar.Yy() == null) {
            return null;
        }
        a(i, view, bjVar, aVar);
        aVar.Yy().a(bjVar);
        aVar.Yy().setForumName(this.mForumName);
        aVar.Yy().b(this.bkZ);
        com.baidu.tieba.frs.f.b.alj().a(cEr, bjVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.i iVar = null;
        if (this.mType == bj.Ys) {
            iVar = new com.baidu.tieba.frs.entelechy.view.f(this.mF, this.mPageId);
        } else if (this.mType == bj.Yt) {
            iVar = new com.baidu.tieba.frs.entelechy.view.g(this.mF, this.mPageId);
        }
        if (iVar != null) {
            iVar.l(this.mPageId);
            iVar.setIsFromCDN(this.mIsFromCDN);
        }
        return new com.baidu.tieba.card.a.a(iVar);
    }

    private void a(int i, View view, bj bjVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.i> aVar) {
        if (bjVar != null && aVar != null) {
            bjVar.sz();
            MetaData author = bjVar.getAuthor();
            if (author != null) {
                final ThemeCardInUserData themeCard = author.getThemeCard();
                if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                    aVar.Yy().crf.setVisibility(8);
                } else {
                    aVar.Yy().crf.setVisibility(0);
                    aVar.Yy().crf.setImageBitmap(null);
                    aVar.Yy().crf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                }
                aVar.Yy().crf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.a.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(d.this.mF.getPageActivity(), themeCard.getCardId())));
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

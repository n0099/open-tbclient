package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.as;
import java.util.HashSet;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.a<bk, com.baidu.tieba.card.b.a<as>> implements cb, com.baidu.tieba.frs.c.e {
    private TbPageContext<?> ajr;
    private VoiceManager bOm;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSJ;
    private com.baidu.adp.lib.e.b<TbImageView> bSK;
    private as bSU;
    private HashSet<String> bSV;
    private cd<bk> bbX;
    private String mForumName;

    private void v(bk bkVar) {
        if (this.bSV == null) {
            this.bSV = new HashSet<>();
        }
        if (bkVar.getTid() != null && !this.bSV.contains(bkVar.getTid())) {
            this.bSV.add(bkVar.getTid());
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11662").s("obj_param1", 1).aa("post_id", bkVar.getTid()));
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bbX = new aa(this);
        this.bSJ = new com.baidu.adp.lib.e.b<>(new ab(this), 6, 0);
        this.bSK = new com.baidu.adp.lib.e.b<>(new ac(this), 12, 0);
        this.ajr = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a<as> onCreateViewHolder(ViewGroup viewGroup) {
        this.bSU = new as(this.ajr, this.mPageId);
        this.bSU.setConstrainLayoutPool(this.bSJ);
        this.bSU.setConstrainImagePool(this.bSK);
        this.bSU.j(this.mPageId);
        this.bSU.setVoiceManager(this.bOm);
        this.bSU.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.b.a<>(this.bSU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.tieba.card.b.a<as> aVar) {
        if (bkVar != null && bkVar.rg()) {
            v(bkVar);
        }
        if (aVar == null || aVar.TU() == null) {
            return null;
        }
        aVar.TU().onBindDataToView(bkVar);
        aVar.TU().setForumName(this.mForumName);
        aVar.TU().setOnSubCardOnClickListenner(this.bbX);
        com.baidu.tieba.frs.c.b.acs().a(bZb, bkVar);
        if (bkVar != null) {
            bkVar.sw();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bSU != null) {
            this.bSU.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bOm = voiceManager;
    }
}

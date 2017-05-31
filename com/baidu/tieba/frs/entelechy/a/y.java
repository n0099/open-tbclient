package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.aw;
import java.util.HashSet;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.b.a<aw>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajh;
    private VoiceManager bTZ;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bYA;
    private com.baidu.adp.lib.e.b<TbImageView> bYB;
    private aw bYM;
    private HashSet<String> bYN;
    private ci<bl> bdm;
    private String mForumName;

    private void A(bl blVar) {
        if (this.bYN == null) {
            this.bYN = new HashSet<>();
        }
        if (blVar.getTid() != null && !this.bYN.contains(blVar.getTid())) {
            this.bYN.add(blVar.getTid());
            TiebaStatic.log(new as("c11662").r("obj_param1", 1).Z("post_id", blVar.getTid()));
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bdm = new z(this);
        this.bYA = new com.baidu.adp.lib.e.b<>(new aa(this), 6, 0);
        this.bYB = new com.baidu.adp.lib.e.b<>(new ab(this), 12, 0);
        this.ajh = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a<aw> onCreateViewHolder(ViewGroup viewGroup) {
        this.bYM = new aw(this.ajh, this.mPageId);
        this.bYM.setConstrainLayoutPool(this.bYA);
        this.bYM.setConstrainImagePool(this.bYB);
        this.bYM.j(this.mPageId);
        this.bYM.setVoiceManager(this.bTZ);
        this.bYM.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.b.a<>(this.bYM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.b.a<aw> aVar) {
        if (blVar != null && blVar.rc()) {
            A(blVar);
        }
        if (aVar == null || aVar.UY() == null) {
            return null;
        }
        aVar.UY().a(blVar);
        aVar.UY().setForumName(this.mForumName);
        aVar.UY().a(this.bdm);
        com.baidu.tieba.frs.d.b.adw().a(cfm, blVar);
        if (blVar != null) {
            blVar.ss();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bYM != null) {
            this.bYM.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bTZ = voiceManager;
    }
}

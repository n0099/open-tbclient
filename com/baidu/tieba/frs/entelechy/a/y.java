package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.aw;
import java.util.HashSet;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<bm, com.baidu.tieba.card.b.a<aw>> implements cg, com.baidu.tieba.frs.d.e {
    private TbPageContext<?> ajP;
    private ci<bm> bgf;
    private VoiceManager cci;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> cgJ;
    private com.baidu.adp.lib.e.b<TbImageView> cgK;
    private aw cgV;
    private HashSet<String> cgW;
    private String mForumName;

    private void B(bm bmVar) {
        if (this.cgW == null) {
            this.cgW = new HashSet<>();
        }
        if (bmVar.getTid() != null && !this.cgW.contains(bmVar.getTid())) {
            this.cgW.add(bmVar.getTid());
            TiebaStatic.log(new au("c11662").r("obj_param1", 1).Z("post_id", bmVar.getTid()));
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgf = new z(this);
        this.cgJ = new com.baidu.adp.lib.e.b<>(new aa(this), 6, 0);
        this.cgK = new com.baidu.adp.lib.e.b<>(new ab(this), 12, 0);
        this.ajP = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a<aw> onCreateViewHolder(ViewGroup viewGroup) {
        this.cgV = new aw(this.ajP, this.mPageId);
        this.cgV.setConstrainLayoutPool(this.cgJ);
        this.cgV.setConstrainImagePool(this.cgK);
        this.cgV.j(this.mPageId);
        this.cgV.setVoiceManager(this.cci);
        this.cgV.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.b.a<>(this.cgV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bm bmVar, com.baidu.tieba.card.b.a<aw> aVar) {
        if (bmVar != null && bmVar.qZ()) {
            B(bmVar);
        }
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().a(bmVar);
        aVar.Wp().setForumName(this.mForumName);
        aVar.Wp().a(this.bgf);
        com.baidu.tieba.frs.d.b.aho().a(cnC, bmVar);
        if (bmVar != null) {
            bmVar.sp();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cgV != null) {
            this.cgV.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cci = voiceManager;
    }
}

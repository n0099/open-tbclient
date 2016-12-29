package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.frs.entelechy.view.bb;
import com.baidu.tieba.r;
import java.util.HashSet;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.a<bg, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.aa>> implements bb, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GO;
    private int bEU;
    private cb<bg> bFl;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bFm;
    private com.baidu.adp.lib.f.b<TbImageView> bFn;
    private com.baidu.tieba.frs.entelechy.view.aa bFx;
    private HashSet<String> bFy;
    private String mForumName;

    private void n(bg bgVar) {
        if (this.bFy == null) {
            this.bFy = new HashSet<>();
        }
        if (bgVar.getTid() != null && !this.bFy.contains(bgVar.getTid())) {
            this.bFy.add(bgVar.getTid());
            TiebaStatic.log(new at("c11662").s("obj_param1", 1).ab("post_id", bgVar.getTid()));
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bEU = 0;
        this.bFl = new aa(this);
        this.bFm = new com.baidu.adp.lib.f.b<>(new ab(this), 6, 0);
        this.bFn = new com.baidu.adp.lib.f.b<>(new ac(this), 12, 0);
        this.GO = tbPageContext;
        this.bEU = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.aa> a(ViewGroup viewGroup) {
        this.bFx = new com.baidu.tieba.frs.entelechy.view.aa(this.GO);
        this.bFx.setConstrainLayoutPool(this.bFm);
        this.bFx.setConstrainImagePool(this.bFn);
        this.bFx.j(this.GO.getUniqueId());
        return new com.baidu.tieba.card.a.a<>(this.bFx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.aa> aVar) {
        if (bgVar != null && bgVar.rn()) {
            n(bgVar);
        }
        if (aVar == null || aVar.Po() == null) {
            return null;
        }
        aVar.Po().onBindDataToView(bgVar);
        aVar.Po().setForumName(this.mForumName);
        aVar.Po().setOnSubCardOnClickListenner(this.bFl);
        com.baidu.tieba.frs.g.b.abq().a(bMV, bgVar);
        if (bgVar != null) {
            bgVar.sB();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bFx != null) {
            this.bFx.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.bb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}

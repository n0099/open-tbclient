package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
import java.util.HashSet;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.a<bj, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajF;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bSK;
    private com.baidu.adp.lib.e.b<TbImageView> bSL;
    private com.baidu.tieba.frs.entelechy.view.aa bSV;
    private HashSet<String> bSW;
    private int bSt;
    private cf<bj> baM;
    private String mForumName;

    private void r(bj bjVar) {
        if (this.bSW == null) {
            this.bSW = new HashSet<>();
        }
        if (bjVar.getTid() != null && !this.bSW.contains(bjVar.getTid())) {
            this.bSW.add(bjVar.getTid());
            TiebaStatic.log(new as("c11662").s("obj_param1", 1).Z("post_id", bjVar.getTid()));
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bSt = 0;
        this.baM = new aa(this);
        this.bSK = new com.baidu.adp.lib.e.b<>(new ab(this), 6, 0);
        this.bSL = new com.baidu.adp.lib.e.b<>(new ac(this), 12, 0);
        this.ajF = tbPageContext;
        this.bSt = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa> onCreateViewHolder(ViewGroup viewGroup) {
        this.bSV = new com.baidu.tieba.frs.entelechy.view.aa(this.ajF);
        this.bSV.setConstrainLayoutPool(this.bSK);
        this.bSV.setConstrainImagePool(this.bSL);
        this.bSV.j(this.ajF.getUniqueId());
        return new com.baidu.tieba.card.b.a<>(this.bSV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.card.b.a<com.baidu.tieba.frs.entelechy.view.aa> aVar) {
        if (bjVar != null && bjVar.ry()) {
            r(bjVar);
        }
        if (aVar == null || aVar.Tb() == null) {
            return null;
        }
        aVar.Tb().onBindDataToView(bjVar);
        aVar.Tb().setForumName(this.mForumName);
        aVar.Tb().setOnSubCardOnClickListenner(this.baM);
        com.baidu.tieba.frs.e.b.adv().a(cav, bjVar);
        if (bjVar != null) {
            bjVar.sO();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bSV != null) {
            this.bSV.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}

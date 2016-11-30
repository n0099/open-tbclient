package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.frs.entelechy.view.ba;
import com.baidu.tieba.frs.entelechy.view.w;
import com.baidu.tieba.r;
import java.util.HashSet;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.widget.ListView.a<bk, a> implements ba, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> GO;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bXs;
    private com.baidu.adp.lib.f.b<TbImageView> bXt;
    private bz<bk> bZL;
    private w bZR;
    private HashSet<String> bZS;
    private int bZh;
    private String mForumName;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZh = 0;
        this.bZL = new ae(this);
        this.bXs = new com.baidu.adp.lib.f.b<>(new af(this), 6, 0);
        this.bXt = new com.baidu.adp.lib.f.b<>(new ag(this), 12, 0);
        this.GO = tbPageContext;
        this.bZh = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds14);
    }

    private void i(bk bkVar) {
        if (this.bZS == null) {
            this.bZS = new HashSet<>();
        }
        if (bkVar.getTid() != null && !this.bZS.contains(bkVar.getTid())) {
            this.bZS.add(bkVar.getTid());
            TiebaStatic.log(new av("c11662").s("obj_param1", 1).ab("post_id", bkVar.getTid()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public a a(ViewGroup viewGroup) {
        this.bZR = new w(this.GO);
        this.bZR.setConstrainLayoutPool(this.bXs);
        this.bZR.setConstrainImagePool(this.bXt);
        this.bZR.j(this.GO.getUniqueId());
        return new a(this.bZR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        if (bkVar != null && bkVar.ry()) {
            i(bkVar);
        }
        aVar.bZU.onBindDataToView(bkVar);
        aVar.bZU.setForumName(this.mForumName);
        aVar.bZU.setOnSubCardOnClickListenner(this.bZL);
        com.baidu.tieba.frs.h.b.agV().a(chm, bkVar);
        if (bkVar != null) {
            bkVar.sN();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.bZR != null) {
            this.bZR.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public w bZU;

        public a(w wVar) {
            super(wVar.getView());
            this.bZU = wVar;
        }
    }
}

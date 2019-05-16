package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> implements com.baidu.tieba.a.f {
    private String Wt;
    public BdUniqueId cwh;
    private ab eUb;
    private com.baidu.tieba.card.l fXt;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eUb = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.fXt != null && a.this.fXt.getView() != null && jVar != null && jVar.abv() != null && !StringUtils.isNull(jVar.abv().getTid())) {
                    boolean z = view == a.this.fXt.aXs();
                    am amVar = new am("c12352");
                    amVar.P("obj_locate", z ? 1 : 2);
                    amVar.bT("obj_type", jVar.aXY());
                    amVar.bT("tid", jVar.threadData.getTid());
                    amVar.l("fid", jVar.threadData.getFid());
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == a.this.fXt.dBR.getCommentContainer() || view == a.this.fXt.dBS.cbw.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.P("obj_locate", 7);
                        amVar2.P("obj_type", 5);
                        amVar2.bT("tid", jVar.abv().getTid());
                        TiebaStatic.log(amVar2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.fXt = new com.baidu.tieba.card.l(this.mPageContext);
        this.fXt.dL(true);
        if (this.cwh != null) {
            this.fXt.k(this.cwh);
        }
        return new com.baidu.tieba.card.a.a<>(this.fXt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (jVar == null || aVar == null || aVar.aYp() == null) {
            return null;
        }
        jVar.ps(i + 1);
        t.aXM().b(jVar.uY("c12351"));
        if (aVar.aYp() instanceof com.baidu.tieba.a.e) {
            aVar.aYp().setPage(this.Wt);
        }
        aVar.aYp().a(jVar);
        aVar.aYp().d(this.eUb);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }
}

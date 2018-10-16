package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.v;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    public BdUniqueId aZt;
    private String bVS;
    private ad eio;
    private com.baidu.tieba.homepage.concern.view.a eis;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eio = new ad<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, j jVar) {
                if (view != null && c.this.eis != null && c.this.eis.getView() != null && jVar != null && jVar.YA() != null && !StringUtils.isNull(jVar.YA().getTid())) {
                    boolean z = view == c.this.eis.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.x("obj_locate", z ? 1 : 2);
                    amVar.ax("obj_type", jVar.aoB());
                    amVar.ax("tid", jVar.threadData.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.eis.bWf.getCommentContainer() || view == c.this.eis.bWS.aFS.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.x("obj_locate", 7);
                        amVar2.x("obj_type", 5);
                        amVar2.ax("tid", jVar.YA().getTid());
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
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.eis = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.aZt != null) {
            this.eis.j(this.aZt);
        }
        return new com.baidu.tieba.card.a.a<>(this.eis);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.aoP() == null) {
            return null;
        }
        jVar.jT(i + 1);
        v.aoo().a(jVar.mj("c12351"));
        if (aVar.aoP() instanceof com.baidu.tieba.a.e) {
            aVar.aoP().setPage(this.bVS);
        }
        aVar.aoP().a(jVar);
        aVar.aoP().b(this.eio);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}

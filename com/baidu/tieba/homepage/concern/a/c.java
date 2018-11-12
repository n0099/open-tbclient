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
    private String bWE;
    public BdUniqueId bag;
    private ad ejJ;
    private com.baidu.tieba.homepage.concern.view.a ejN;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ejJ = new ad<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, j jVar) {
                if (view != null && c.this.ejN != null && c.this.ejN.getView() != null && jVar != null && jVar.YL() != null && !StringUtils.isNull(jVar.YL().getTid())) {
                    boolean z = view == c.this.ejN.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.x("obj_locate", z ? 1 : 2);
                    amVar.ax("obj_type", jVar.aod());
                    amVar.ax("tid", jVar.threadData.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.ejN.bWR.getCommentContainer() || view == c.this.ejN.bXE.aGI.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.x("obj_locate", 7);
                        amVar2.x("obj_type", 5);
                        amVar2.ax("tid", jVar.YL().getTid());
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.ejN = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.bag != null) {
            this.ejN.j(this.bag);
        }
        return new com.baidu.tieba.card.a.a<>(this.ejN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.aor() == null) {
            return null;
        }
        jVar.km(i + 1);
        v.anQ().a(jVar.mk("c12351"));
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        aVar.aor().a(jVar);
        aVar.aor().b(this.ejJ);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}

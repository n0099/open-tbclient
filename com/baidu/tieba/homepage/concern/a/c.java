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
    public BdUniqueId bdH;
    private String caz;
    private ad etv;
    private com.baidu.tieba.homepage.concern.view.a etz;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.etv = new ad<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, j jVar) {
                if (view != null && c.this.etz != null && c.this.etz.getView() != null && jVar != null && jVar.ZT() != null && !StringUtils.isNull(jVar.ZT().getTid())) {
                    boolean z = view == c.this.etz.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.x("obj_locate", z ? 1 : 2);
                    amVar.aA("obj_type", jVar.aqF());
                    amVar.aA("tid", jVar.threadData.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.etz.caM.getCommentContainer() || view == c.this.etz.cbz.aKk.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.x("obj_locate", 7);
                        amVar2.x("obj_type", 5);
                        amVar2.aA("tid", jVar.ZT().getTid());
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.etz = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.bdH != null) {
            this.etz.j(this.bdH);
        }
        return new com.baidu.tieba.card.a.a<>(this.etz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.aqT() == null) {
            return null;
        }
        jVar.kP(i + 1);
        v.aqs().a(jVar.mM("c12351"));
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        aVar.aqT().a(jVar);
        aVar.aqT().b(this.etv);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }
}

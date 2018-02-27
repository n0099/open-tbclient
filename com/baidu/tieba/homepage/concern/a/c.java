package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> {
    public BdUniqueId bIv;
    public int cardShowType;
    private v efW;
    private com.baidu.tieba.homepage.concern.view.a ega;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cardShowType = 0;
        this.efW = new v<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, j jVar) {
                if (view != null && c.this.ega != null && c.this.ega.getView() != null && jVar != null && jVar.WD() != null && !StringUtils.isNull(jVar.WD().getTid())) {
                    boolean z = view == c.this.ega.getHeaderImg();
                    ak akVar = new ak("c12352");
                    akVar.s("obj_locate", z ? 1 : 2);
                    akVar.ab("obj_type", jVar.alD());
                    akVar.ab("tid", jVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                    if (view == c.this.ega.clX.getCommentContainer() || view == c.this.ega.cmL.bem.getCommentContainer()) {
                        ak akVar2 = new ak("c12942");
                        akVar2.s("obj_locate", 7);
                        akVar2.s("obj_type", 5);
                        akVar2.ab("tid", jVar.WD().getTid());
                        TiebaStatic.log(akVar2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.ega = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.bIv != null) {
            this.ega.j(this.bIv);
        }
        return new com.baidu.tieba.card.a.a<>(this.ega);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.alX() == null) {
            return null;
        }
        jVar.lD(i + 1);
        r.als().a(jVar.ky("c12351"));
        if (jVar.threadData != null) {
            jVar.threadData.aQo = this.cardShowType;
        }
        aVar.alX().a(jVar);
        aVar.alX().b(this.efW);
        return aVar.getView();
    }
}

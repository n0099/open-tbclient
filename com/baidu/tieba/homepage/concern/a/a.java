package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> {
    public BdUniqueId bII;
    public int cardShowType;
    private com.baidu.tieba.homepage.concern.view.e egh;
    private v<com.baidu.tieba.homepage.concern.b.b> egi;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cardShowType = 0;
        this.egi = new v<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.egh != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.dxT.getFid());
                    akVar.ab("tid", bVar.dxT.getTid());
                    akVar.s("obj_type", 4);
                    akVar.ab("obj_id", bVar.egJ.getUserId());
                    if ((a.this.egh.eha == null || view.getId() != a.this.egh.eha.getId()) && (a.this.egh.cmj.getHeaderImg() == null || view.getId() != a.this.egh.cmj.getHeaderImg().getId())) {
                        if (a.this.egh.egY != null && view.getId() == a.this.egh.egY.getId()) {
                            akVar.s("obj_locate", 3);
                        } else {
                            akVar.s("obj_locate", 2);
                        }
                    } else {
                        akVar.s("obj_locate", 1);
                    }
                    akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCr());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.egh = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bII != null) {
            this.egh.j(this.bII);
        }
        return new com.baidu.tieba.card.a.a<>(this.egh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.egJ == null || aVar == null || StringUtils.isNull(bVar.egJ.getName()) || StringUtils.isNull(bVar.egJ.getUserId())) {
            return null;
        }
        if (bVar.dxT != null) {
            bVar.dxT.aQz = this.cardShowType;
        }
        aVar.alY().a(bVar);
        aVar.alY().b(this.egi);
        aVar.alY().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        r.alt().a(new ak("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ab("obj_id", bVar.egJ.getUserId()).s("obj_type", 4).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCr()).ab("tid", bVar.dxT.getTid()));
        return aVar.getView();
    }
}

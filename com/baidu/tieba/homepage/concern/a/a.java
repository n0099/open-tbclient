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
    public BdUniqueId bIv;
    public int cardShowType;
    private com.baidu.tieba.homepage.concern.view.e efV;
    private v<com.baidu.tieba.homepage.concern.b.b> efW;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cardShowType = 0;
        this.efW = new v<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.efV != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.dxH.getFid());
                    akVar.ab("tid", bVar.dxH.getTid());
                    akVar.s("obj_type", 4);
                    akVar.ab("obj_id", bVar.egx.getUserId());
                    if ((a.this.efV.egO == null || view.getId() != a.this.efV.egO.getId()) && (a.this.efV.clW.getHeaderImg() == null || view.getId() != a.this.efV.clW.getHeaderImg().getId())) {
                        if (a.this.efV.egM != null && view.getId() == a.this.efV.egM.getId()) {
                            akVar.s("obj_locate", 3);
                        } else {
                            akVar.s("obj_locate", 2);
                        }
                    } else {
                        akVar.s("obj_locate", 1);
                    }
                    akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCq());
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
        this.efV = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bIv != null) {
            this.efV.j(this.bIv);
        }
        return new com.baidu.tieba.card.a.a<>(this.efV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.egx == null || aVar == null || StringUtils.isNull(bVar.egx.getName()) || StringUtils.isNull(bVar.egx.getUserId())) {
            return null;
        }
        if (bVar.dxH != null) {
            bVar.dxH.aQo = this.cardShowType;
        }
        aVar.alX().a(bVar);
        aVar.alX().b(this.efW);
        aVar.alX().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        r.als().a(new ak("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ab("obj_id", bVar.egx.getUserId()).s("obj_type", 4).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCq()).ab("tid", bVar.dxH.getTid()));
        return aVar.getView();
    }
}

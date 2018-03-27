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
    public BdUniqueId bIy;
    public int cardShowType;
    private com.baidu.tieba.homepage.concern.view.e egl;
    private v<com.baidu.tieba.homepage.concern.b.b> egm;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cardShowType = 0;
        this.egm = new v<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.egl != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.dxK.getFid());
                    akVar.ab("tid", bVar.dxK.getTid());
                    akVar.s("obj_type", 4);
                    akVar.ab("obj_id", bVar.egN.getUserId());
                    if ((a.this.egl.ehe == null || view.getId() != a.this.egl.ehe.getId()) && (a.this.egl.clZ.getHeaderImg() == null || view.getId() != a.this.egl.clZ.getHeaderImg().getId())) {
                        if (a.this.egl.ehc != null && view.getId() == a.this.egl.ehc.getId()) {
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
        this.egl = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bIy != null) {
            this.egl.j(this.bIy);
        }
        return new com.baidu.tieba.card.a.a<>(this.egl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.egN == null || aVar == null || StringUtils.isNull(bVar.egN.getName()) || StringUtils.isNull(bVar.egN.getUserId())) {
            return null;
        }
        if (bVar.dxK != null) {
            bVar.dxK.aQp = this.cardShowType;
        }
        aVar.alY().a(bVar);
        aVar.alY().b(this.egm);
        aVar.alY().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        r.alt().a(new ak("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ab("obj_id", bVar.egN.getUserId()).s("obj_type", 4).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCr()).ab("tid", bVar.dxK.getTid()));
        return aVar.getView();
    }
}

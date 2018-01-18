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
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> {
    public BdUniqueId bGw;
    private com.baidu.tieba.homepage.concern.view.e ebA;
    private v<com.baidu.tieba.homepage.concern.b.b> ebB;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.ebB = new v<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.ebA != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.duG.getFid());
                    akVar.ab("tid", bVar.duG.getTid());
                    akVar.s("obj_type", 4);
                    akVar.ab("obj_id", bVar.ecc.getUserId());
                    if ((a.this.ebA.ect == null || view.getId() != a.this.ebA.ect.getId()) && (a.this.ebA.ciK.getHeaderImg() == null || view.getId() != a.this.ebA.ciK.getHeaderImg().getId())) {
                        if (a.this.ebA.ecq != null && view.getId() == a.this.ebA.ecq.getId()) {
                            akVar.s("obj_locate", 3);
                        } else {
                            akVar.s("obj_locate", 2);
                        }
                    } else {
                        akVar.s("obj_locate", 1);
                    }
                    akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aAS());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.ebA = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bGw != null) {
            this.ebA.j(this.bGw);
        }
        return new com.baidu.tieba.card.a.a<>(this.ebA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.ecc == null || aVar == null || StringUtils.isNull(bVar.ecc.getName()) || StringUtils.isNull(bVar.ecc.getUserId())) {
            return null;
        }
        aVar.alk().a(bVar);
        aVar.alk().b(this.ebB);
        aVar.alk().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        s.akF().a(new ak("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ab("obj_id", bVar.ecc.getUserId()).s("obj_type", 4).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aAS()).ab("tid", bVar.duG.getTid()));
        return aVar.getView();
    }
}

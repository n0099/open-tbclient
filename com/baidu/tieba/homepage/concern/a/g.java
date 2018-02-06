package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<s>> {
    public BdUniqueId bII;
    private k cVI;
    public int cardShowType;
    private s dLf;
    private v egi;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cardShowType = 0;
        this.egi = new v<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                k kVar = g.this.cVI;
                if (view != null && g.this.dLf != null && g.this.dLf.getView() != null && kVar != null && kVar.WE() != null && !StringUtils.isNull(kVar.WE().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.dLf.getHeaderImg() == null || view.getId() != g.this.dLf.getHeaderImg().getId()) && (g.this.dLf.akS() == null || view.getId() != g.this.dLf.akS().getId())) {
                        if (view.getId() == g.this.dLf.cYC.getId()) {
                            akVar.s("obj_locate", 3);
                        } else {
                            akVar.s("obj_locate", 2);
                        }
                    } else {
                        akVar.s("obj_locate", 1);
                    }
                    akVar.s("obj_type", 5);
                    akVar.ab("tid", kVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
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
    public com.baidu.tieba.card.a.a<s> onCreateViewHolder(ViewGroup viewGroup) {
        this.dLf = new s(this.mPageContext);
        this.dLf.j(this.bII);
        this.dLf.eL(false);
        this.dLf.setIsFromConcern(true);
        this.dLf.b(this.egi);
        this.dLf.currentPageType = 1;
        if (this.dLf.cmk != null) {
            this.dLf.cmk.aQE = 1;
        }
        if (this.dLf.cmX != null && this.dLf.cmX.bez != null) {
            this.dLf.cmX.bez.aQE = 1;
        }
        if (this.dLf.cYC != null) {
            this.dLf.cYC.cZh = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dLf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<s> aVar) {
        if (kVar == null || aVar == null || aVar.alY() == null) {
            return null;
        }
        this.cVI = kVar;
        kVar.lD(i + 1);
        r.alt().a(kVar.kz("c12351"));
        be beVar = new be(kVar.WE());
        beVar.stType = "personalize_page";
        beVar.aQC = 9;
        beVar.aQD = 4;
        beVar.threadData.aQz = this.cardShowType;
        aVar.alY().a(beVar);
        return aVar.getView();
    }
}

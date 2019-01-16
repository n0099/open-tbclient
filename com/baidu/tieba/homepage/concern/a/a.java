package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> implements com.baidu.tieba.a.f {
    public BdUniqueId bes;
    private String cbk;
    private com.baidu.tieba.homepage.concern.view.e eua;
    private ad<com.baidu.tieba.homepage.concern.b.b> eub;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.eub = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.eua != null) {
                    am amVar = new am("c12407");
                    amVar.i(ImageViewerConfig.FORUM_ID, bVar.dAv.getFid());
                    amVar.aB("tid", bVar.dAv.getTid());
                    amVar.y("obj_type", 4);
                    amVar.aB(VideoPlayActivityConfig.OBJ_ID, bVar.euC.getUserId());
                    if ((a.this.eua.euU == null || view.getId() != a.this.eua.euU.getId()) && (a.this.eua.cbw.getHeaderImg() == null || view.getId() != a.this.eua.cbw.getHeaderImg().getId())) {
                        if (a.this.eua.euS != null && view.getId() == a.this.eua.euS.getId()) {
                            amVar.y("obj_locate", 3);
                        } else {
                            amVar.y("obj_locate", 2);
                        }
                    } else {
                        amVar.y("obj_locate", 1);
                    }
                    amVar.y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aLw());
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.eua = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bes != null) {
            this.eua.j(this.bes);
        }
        return new com.baidu.tieba.card.a.a<>(this.eua);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.euC == null || aVar == null || StringUtils.isNull(bVar.euC.getName()) || StringUtils.isNull(bVar.euC.getUserId())) {
            return null;
        }
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbk);
        }
        aVar.arr().a(bVar);
        aVar.arr().b(this.eub);
        aVar.arr().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aqP().a(new am("c12353").i("uid", TbadkCoreApplication.getCurrentAccountId()).aB(VideoPlayActivityConfig.OBJ_ID, bVar.euC.getUserId()).y("obj_type", 4).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aLw()).aB("tid", bVar.dAv.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }
}

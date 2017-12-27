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
    public BdUniqueId bGo;
    private com.baidu.tieba.homepage.concern.view.e eaq;
    private v<com.baidu.tieba.homepage.concern.b.b> ear;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.ear = new v<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.eaq != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.dqg.getFid());
                    akVar.ab("tid", bVar.dqg.getTid());
                    akVar.s("obj_type", 4);
                    akVar.ab("obj_id", bVar.eaS.getUserId());
                    if ((a.this.eaq.ebj == null || view.getId() != a.this.eaq.ebj.getId()) && (a.this.eaq.ciD.getHeaderImg() == null || view.getId() != a.this.eaq.ciD.getHeaderImg().getId())) {
                        if (a.this.eaq.ebg != null && view.getId() == a.this.eaq.ebg.getId()) {
                            akVar.s("obj_locate", 3);
                        } else {
                            akVar.s("obj_locate", 2);
                        }
                    } else {
                        akVar.s("obj_locate", 1);
                    }
                    akVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aAQ());
                    TiebaStatic.log(akVar);
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
        this.eaq = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bGo != null) {
            this.eaq.j(this.bGo);
        }
        return new com.baidu.tieba.card.a.a<>(this.eaq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.eaS == null || aVar == null || StringUtils.isNull(bVar.eaS.getName()) || StringUtils.isNull(bVar.eaS.getUserId())) {
            return null;
        }
        aVar.akh().a(bVar);
        aVar.akh().b(this.ear);
        aVar.akh().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        s.ajC().a(new ak("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ab("obj_id", bVar.eaS.getUserId()).s("obj_type", 4).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aAQ()).ab("tid", bVar.dqg.getTid()));
        return aVar.getView();
    }
}

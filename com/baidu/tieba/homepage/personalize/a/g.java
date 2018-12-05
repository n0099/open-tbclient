package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId bdE;
    private ad<com.baidu.tieba.card.data.h> dNp;
    private com.baidu.tieba.card.k evP;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.dNp = new ad<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && g.this.evP != null && g.this.evP.cUi != null && g.this.evP.cUi.cUm != null && g.this.evP.cUi.cUk != null && g.this.evP.cUi.getView() != null) {
                    if (view.getId() != g.this.evP.cUi.cUm.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == g.this.evP.cUi.getView().getId() || view.getId() == g.this.evP.cUi.cUk.getId()) && (view.getTag(e.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new am("c11005").aA(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(e.g.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new am("c10803").x("obj_locate", 6));
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
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.evP = new com.baidu.tieba.card.k(this.mPageContext, this.bdE);
        return new com.baidu.tieba.card.a.a(this.evP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        this.evP = aVar.aqe();
        aVar.aqe().a(hVar);
        aVar.aqe().b(this.dNp);
        aVar.aqe().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.apD().a(new am("c11006"));
        return aVar.getView();
    }

    public void oH(int i) {
        if (this.evP != null) {
            this.evP.d(this.mPageContext, i);
        }
    }
}

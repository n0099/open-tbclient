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
    public BdUniqueId bdH;
    private ad<com.baidu.tieba.card.data.h> dQd;
    private com.baidu.tieba.card.k eyI;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.dQd = new ad<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && g.this.eyI != null && g.this.eyI.cWY != null && g.this.eyI.cWY.cXc != null && g.this.eyI.cWY.cXa != null && g.this.eyI.cWY.getView() != null) {
                    if (view.getId() != g.this.eyI.cWY.cXc.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == g.this.eyI.cWY.getView().getId() || view.getId() == g.this.eyI.cWY.cXa.getId()) && (view.getTag(e.g.rec_god_item_root) instanceof String)) {
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.eyI = new com.baidu.tieba.card.k(this.mPageContext, this.bdH);
        return new com.baidu.tieba.card.a.a(this.eyI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        this.eyI = aVar.aqT();
        aVar.aqT().a(hVar);
        aVar.aqT().b(this.dQd);
        aVar.aqT().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aqs().a(new am("c11006"));
        return aVar.getView();
    }

    public void oU(int i) {
        if (this.eyI != null) {
            this.eyI.d(this.mPageContext, i);
        }
    }
}

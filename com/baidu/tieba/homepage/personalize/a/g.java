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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId aQJ;
    private com.baidu.tieba.card.k dQW;
    private ab<com.baidu.tieba.card.data.h> dlK;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.dlK = new ab<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && g.this.dQW != null && g.this.dQW.cxE != null && g.this.dQW.cxE.cxJ != null && g.this.dQW.cxE.cxH != null && g.this.dQW.cxE.getView() != null) {
                    if (view.getId() != g.this.dQW.cxE.cxJ.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == g.this.dQW.cxE.getView().getId() || view.getId() == g.this.dQW.cxE.cxH.getId()) && (view.getTag(d.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new am("c11005").ah(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new am("c10803").r("obj_locate", 6));
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
        this.dQW = new com.baidu.tieba.card.k(this.mPageContext, this.aQJ);
        return new com.baidu.tieba.card.a.a(this.dQW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        this.dQW = aVar.ajG();
        aVar.ajG().a(hVar);
        aVar.ajG().b(this.dlK);
        aVar.ajG().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.ajh().a(new am("c11006"));
        return aVar.getView();
    }

    public void my(int i) {
        if (this.dQW != null) {
            this.dQW.d(this.mPageContext, i);
        }
    }
}

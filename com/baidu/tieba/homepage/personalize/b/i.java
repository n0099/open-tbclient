package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f>> {
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private x<com.baidu.tieba.card.data.h> cQj;
    private com.baidu.tieba.card.f cTT;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.cQj = new x<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.b.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && i.this.cTT != null && i.this.cTT.bGn != null && i.this.cTT.bGn.bGt != null && i.this.cTT.bGn.bGq != null && i.this.cTT.bGn.getView() != null) {
                    if (view.getId() != i.this.cTT.bGn.bGt.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == i.this.cTT.bGn.getView().getId() || view.getId() == i.this.cTT.bGn.bGq.getId()) && (view.getTag(d.h.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new aj("c11005").aa("obj_id", (String) view.getTag(d.h.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new aj("c10803").r("obj_locate", 6));
                    }
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cTT = new com.baidu.tieba.card.f(this.alI, this.aOM);
        return new com.baidu.tieba.card.a.a(this.cTT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        this.cTT = aVar.Xc();
        aVar.Xc().a(hVar);
        aVar.Xc().a(this.cQj);
        aVar.Xc().d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        u.WB().a(new aj("c11006"));
        return aVar.getView();
    }

    public void kH(int i) {
        if (this.cTT != null) {
            this.cTT.d(this.alI, i);
        }
    }
}

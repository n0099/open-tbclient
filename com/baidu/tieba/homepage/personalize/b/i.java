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
    public BdUniqueId aON;
    private x<com.baidu.tieba.card.data.h> cSi;
    private com.baidu.tieba.card.f cVS;
    private TbPageContext<?> oV;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.cSi = new x<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.b.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && i.this.cVS != null && i.this.cVS.bGW != null && i.this.cVS.bGW.bHc != null && i.this.cVS.bGW.bGZ != null && i.this.cVS.bGW.getView() != null) {
                    if (view.getId() != i.this.cVS.bGW.bHc.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == i.this.cVS.bGW.getView().getId() || view.getId() == i.this.cVS.bGW.bGZ.getId()) && (view.getTag(d.h.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new aj("c11005").aa("obj_id", (String) view.getTag(d.h.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new aj("c10803").r("obj_locate", 6));
                    }
                }
            }
        };
        this.oV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cVS = new com.baidu.tieba.card.f(this.oV, this.aON);
        return new com.baidu.tieba.card.a.a(this.cVS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        this.cVS = aVar.Xy();
        aVar.Xy().a(hVar);
        aVar.Xy().b(this.cSi);
        aVar.Xy().d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        u.WX().a(new aj("c11006"));
        return aVar.getView();
    }

    public void kR(int i) {
        if (this.cVS != null) {
            this.cVS.d(this.oV, i);
        }
    }
}

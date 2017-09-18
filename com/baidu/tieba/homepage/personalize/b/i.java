package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f>> {
    public BdUniqueId aOu;
    private x<com.baidu.tieba.card.data.h> ctY;
    private com.baidu.tieba.card.f ddq;
    private TbPageContext<?> mF;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.ctY = new x<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.b.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && i.this.ddq != null && i.this.ddq.bKI != null && i.this.ddq.bKI.bKN != null && i.this.ddq.bKI.bKL != null && i.this.ddq.bKI.getView() != null) {
                    if (view.getId() != i.this.ddq.bKI.bKN.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == i.this.ddq.bKI.getView().getId() || view.getId() == i.this.ddq.bKI.bKL.getId()) && (view.getTag(d.h.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new ak("c11005").ad("obj_id", (String) view.getTag(d.h.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new ak("c10803").r("obj_locate", 6));
                    }
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.ddq = new com.baidu.tieba.card.f(this.mF, this.aOu);
        return new com.baidu.tieba.card.a.a(this.ddq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        this.ddq = aVar.YJ();
        aVar.YJ().a(hVar);
        aVar.YJ().b(this.ctY);
        aVar.YJ().d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        u.Yj().a(new ak("c11006"));
        return aVar.getView();
    }

    public void ll(int i) {
        if (this.ddq != null) {
            this.ddq.d(this.mF, i);
        }
    }
}

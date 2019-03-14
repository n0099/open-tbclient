package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<f, a> {
    private ab dqg;
    private com.baidu.tieba.godSquare.b.b fEA;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), f.elc);
        this.dqg = new ab() { // from class: com.baidu.tieba.godSquare.a.c.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                if (view != null && c.this.fEA != null && (bVar instanceof f)) {
                    f fVar = (f) bVar;
                    if (fVar.bBG != null && !StringUtils.isNull(fVar.bBG.getUserId())) {
                        if (view.getId() != c.this.fEA.fEI.getId()) {
                            if (view.getId() == c.this.fEA.getView().getId() || view.getId() == c.this.fEA.fAy.getId()) {
                                TiebaStatic.log(new am("c10951").bJ(VideoPlayActivityConfig.OBJ_ID, fVar.bBG.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new am("c10803").T("obj_locate", 4).bJ(VideoPlayActivityConfig.OBJ_ID, fVar.bBG.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fEA = new com.baidu.tieba.godSquare.b.b(this.mPageContext);
        this.fEA.i(this.mPageContext.getUniqueId());
        this.fEA.d(this.dqg);
        return new a(this.fEA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        if (aVar == null || aVar.fEC == null) {
            return null;
        }
        aVar.fEC.a(fVar);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public class a extends v.a {
        public com.baidu.tieba.godSquare.b.b fEC;

        public a(com.baidu.tieba.godSquare.b.b bVar) {
            super(bVar.getView());
            this.fEC = bVar;
        }
    }
}

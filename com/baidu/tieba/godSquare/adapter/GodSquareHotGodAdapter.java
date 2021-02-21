package com.baidu.tieba.godSquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.h;
/* loaded from: classes8.dex */
public class GodSquareHotGodAdapter extends com.baidu.adp.widget.ListView.a<h, ViewHolder> {
    private ab hnd;
    private com.baidu.tieba.godSquare.a.a jXM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public GodSquareHotGodAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.iAE);
        this.hnd = new ab() { // from class: com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && GodSquareHotGodAdapter.this.jXM != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.eRz != null && !StringUtils.isNull(hVar.eRz.getUserId())) {
                        if (view.getId() != GodSquareHotGodAdapter.this.jXM.jXX.getId()) {
                            if (view.getId() == GodSquareHotGodAdapter.this.jXM.getView().getId() || view.getId() == GodSquareHotGodAdapter.this.jXM.jSL.getId()) {
                                TiebaStatic.log(new ar("c10951").dR("obj_id", hVar.eRz.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ar("c10803").ap("obj_locate", 4).dR("obj_id", hVar.eRz.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public ViewHolder e(ViewGroup viewGroup) {
        this.jXM = new com.baidu.tieba.godSquare.a.a(this.mPageContext);
        this.jXM.l(this.mPageContext.getUniqueId());
        this.jXM.c(this.hnd);
        return new ViewHolder(this.jXM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.jXO == null) {
            return null;
        }
        viewHolder.jXO.a(hVar);
        return viewHolder.getView();
    }

    /* loaded from: classes8.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.godSquare.a.a jXO;

        public ViewHolder(com.baidu.tieba.godSquare.a.a aVar) {
            super(aVar.getView());
            this.jXO = aVar;
        }
    }
}

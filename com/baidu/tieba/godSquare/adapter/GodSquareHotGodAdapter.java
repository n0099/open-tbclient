package com.baidu.tieba.godSquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.h;
/* loaded from: classes8.dex */
public class GodSquareHotGodAdapter extends com.baidu.adp.widget.ListView.a<h, ViewHolder> {
    private aa hni;
    private com.baidu.tieba.godSquare.a.a jUB;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public GodSquareHotGodAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.izn);
        this.hni = new aa() { // from class: com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && GodSquareHotGodAdapter.this.jUB != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.eTY != null && !StringUtils.isNull(hVar.eTY.getUserId())) {
                        if (view.getId() != GodSquareHotGodAdapter.this.jUB.jUM.getId()) {
                            if (view.getId() == GodSquareHotGodAdapter.this.jUB.getView().getId() || view.getId() == GodSquareHotGodAdapter.this.jUB.jQg.getId()) {
                                TiebaStatic.log(new aq("c10951").dX("obj_id", hVar.eTY.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").an("obj_locate", 4).dX("obj_id", hVar.eTY.getUserId()));
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
        this.jUB = new com.baidu.tieba.godSquare.a.a(this.mPageContext);
        this.jUB.l(this.mPageContext.getUniqueId());
        this.jUB.c(this.hni);
        return new ViewHolder(this.jUB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.jUD == null) {
            return null;
        }
        viewHolder.jUD.a(hVar);
        return viewHolder.getView();
    }

    /* loaded from: classes8.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.godSquare.a.a jUD;

        public ViewHolder(com.baidu.tieba.godSquare.a.a aVar) {
            super(aVar.getView());
            this.jUD = aVar;
        }
    }
}

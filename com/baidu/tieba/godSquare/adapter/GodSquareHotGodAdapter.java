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
/* loaded from: classes7.dex */
public class GodSquareHotGodAdapter extends com.baidu.adp.widget.ListView.a<h, ViewHolder> {
    private aa hiC;
    private com.baidu.tieba.godSquare.a.a jPW;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public GodSquareHotGodAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.iuG);
        this.hiC = new aa() { // from class: com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && GodSquareHotGodAdapter.this.jPW != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.ePn != null && !StringUtils.isNull(hVar.ePn.getUserId())) {
                        if (view.getId() != GodSquareHotGodAdapter.this.jPW.jQh.getId()) {
                            if (view.getId() == GodSquareHotGodAdapter.this.jPW.getView().getId() || view.getId() == GodSquareHotGodAdapter.this.jPW.jLA.getId()) {
                                TiebaStatic.log(new aq("c10951").dW("obj_id", hVar.ePn.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new aq("c10803").an("obj_locate", 4).dW("obj_id", hVar.ePn.getUserId()));
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
        this.jPW = new com.baidu.tieba.godSquare.a.a(this.mPageContext);
        this.jPW.l(this.mPageContext.getUniqueId());
        this.jPW.c(this.hiC);
        return new ViewHolder(this.jPW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.jPY == null) {
            return null;
        }
        viewHolder.jPY.a(hVar);
        return viewHolder.getView();
    }

    /* loaded from: classes7.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.godSquare.a.a jPY;

        public ViewHolder(com.baidu.tieba.godSquare.a.a aVar) {
            super(aVar.getView());
            this.jPY = aVar;
        }
    }
}

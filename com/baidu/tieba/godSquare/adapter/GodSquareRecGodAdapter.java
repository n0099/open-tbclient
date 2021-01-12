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
import com.baidu.tieba.godSquare.a.b;
/* loaded from: classes7.dex */
public class GodSquareRecGodAdapter extends com.baidu.adp.widget.ListView.a<h, ViewHolder> {
    private aa hiC;
    private b jPZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public GodSquareRecGodAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.iuH);
        this.hiC = new aa() { // from class: com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && GodSquareRecGodAdapter.this.jPZ != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.ePn != null && !StringUtils.isNull(hVar.ePn.getUserId())) {
                        if (view.getId() != GodSquareRecGodAdapter.this.jPZ.jQh.getId()) {
                            if (view.getId() == GodSquareRecGodAdapter.this.jPZ.getView().getId() || view.getId() == GodSquareRecGodAdapter.this.jPZ.jLA.getId()) {
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
    /* renamed from: bQ */
    public ViewHolder e(ViewGroup viewGroup) {
        this.jPZ = new b(this.mPageContext);
        this.jPZ.l(this.mPageContext.getUniqueId());
        this.jPZ.c(this.hiC);
        return new ViewHolder(this.jPZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.jQb == null) {
            return null;
        }
        viewHolder.jQb.a(hVar);
        return viewHolder.getView();
    }

    /* loaded from: classes7.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public b jQb;

        public ViewHolder(b bVar) {
            super(bVar.getView());
            this.jQb = bVar;
        }
    }
}

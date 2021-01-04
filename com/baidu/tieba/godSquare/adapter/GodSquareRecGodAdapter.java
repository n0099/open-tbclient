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
/* loaded from: classes8.dex */
public class GodSquareRecGodAdapter extends com.baidu.adp.widget.ListView.a<h, ViewHolder> {
    private aa hni;
    private b jUE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public GodSquareRecGodAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.izo);
        this.hni = new aa() { // from class: com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter.1
            @Override // com.baidu.tieba.card.aa
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && GodSquareRecGodAdapter.this.jUE != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.eTY != null && !StringUtils.isNull(hVar.eTY.getUserId())) {
                        if (view.getId() != GodSquareRecGodAdapter.this.jUE.jUM.getId()) {
                            if (view.getId() == GodSquareRecGodAdapter.this.jUE.getView().getId() || view.getId() == GodSquareRecGodAdapter.this.jUE.jQg.getId()) {
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
    /* renamed from: bQ */
    public ViewHolder e(ViewGroup viewGroup) {
        this.jUE = new b(this.mPageContext);
        this.jUE.l(this.mPageContext.getUniqueId());
        this.jUE.c(this.hni);
        return new ViewHolder(this.jUE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.jUG == null) {
            return null;
        }
        viewHolder.jUG.a(hVar);
        return viewHolder.getView();
    }

    /* loaded from: classes8.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public b jUG;

        public ViewHolder(b bVar) {
            super(bVar.getView());
            this.jUG = bVar;
        }
    }
}

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
import com.baidu.tieba.godSquare.a.b;
/* loaded from: classes8.dex */
public class GodSquareRecGodAdapter extends com.baidu.adp.widget.ListView.a<h, ViewHolder> {
    private ab hnd;
    private b jXP;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public GodSquareRecGodAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.iAF);
        this.hnd = new ab() { // from class: com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && GodSquareRecGodAdapter.this.jXP != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.eRz != null && !StringUtils.isNull(hVar.eRz.getUserId())) {
                        if (view.getId() != GodSquareRecGodAdapter.this.jXP.jXX.getId()) {
                            if (view.getId() == GodSquareRecGodAdapter.this.jXP.getView().getId() || view.getId() == GodSquareRecGodAdapter.this.jXP.jSL.getId()) {
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
    /* renamed from: bQ */
    public ViewHolder e(ViewGroup viewGroup) {
        this.jXP = new b(this.mPageContext);
        this.jXP.l(this.mPageContext.getUniqueId());
        this.jXP.c(this.hnd);
        return new ViewHolder(this.jXP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.jXR == null) {
            return null;
        }
        viewHolder.jXR.a(hVar);
        return viewHolder.getView();
    }

    /* loaded from: classes8.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public b jXR;

        public ViewHolder(b bVar) {
            super(bVar.getView());
            this.jXR = bVar;
        }
    }
}

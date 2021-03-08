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
/* loaded from: classes7.dex */
public class GodSquareRecGodAdapter extends com.baidu.adp.widget.ListView.a<h, ViewHolder> {
    private ab hoN;
    private b jZR;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public GodSquareRecGodAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.iCo);
        this.hoN = new ab() { // from class: com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && GodSquareRecGodAdapter.this.jZR != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.eTa != null && !StringUtils.isNull(hVar.eTa.getUserId())) {
                        if (view.getId() != GodSquareRecGodAdapter.this.jZR.jZZ.getId()) {
                            if (view.getId() == GodSquareRecGodAdapter.this.jZR.getView().getId() || view.getId() == GodSquareRecGodAdapter.this.jZR.jUu.getId()) {
                                TiebaStatic.log(new ar("c10951").dR("obj_id", hVar.eTa.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ar("c10803").aq("obj_locate", 4).dR("obj_id", hVar.eTa.getUserId()));
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
        this.jZR = new b(this.mPageContext);
        this.jZR.l(this.mPageContext.getUniqueId());
        this.jZR.c(this.hoN);
        return new ViewHolder(this.jZR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.jZT == null) {
            return null;
        }
        viewHolder.jZT.a(hVar);
        return viewHolder.getView();
    }

    /* loaded from: classes7.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public b jZT;

        public ViewHolder(b bVar) {
            super(bVar.getView());
            this.jZT = bVar;
        }
    }
}

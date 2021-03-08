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
/* loaded from: classes7.dex */
public class GodSquareHotGodAdapter extends com.baidu.adp.widget.ListView.a<h, ViewHolder> {
    private ab hoN;
    private com.baidu.tieba.godSquare.a.a jZO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public GodSquareHotGodAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.iCn);
        this.hoN = new ab() { // from class: com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && GodSquareHotGodAdapter.this.jZO != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.eTa != null && !StringUtils.isNull(hVar.eTa.getUserId())) {
                        if (view.getId() != GodSquareHotGodAdapter.this.jZO.jZZ.getId()) {
                            if (view.getId() == GodSquareHotGodAdapter.this.jZO.getView().getId() || view.getId() == GodSquareHotGodAdapter.this.jZO.jUu.getId()) {
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
    /* renamed from: bO */
    public ViewHolder e(ViewGroup viewGroup) {
        this.jZO = new com.baidu.tieba.godSquare.a.a(this.mPageContext);
        this.jZO.l(this.mPageContext.getUniqueId());
        this.jZO.c(this.hoN);
        return new ViewHolder(this.jZO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        if (viewHolder == null || viewHolder.jZQ == null) {
            return null;
        }
        viewHolder.jZQ.a(hVar);
        return viewHolder.getView();
    }

    /* loaded from: classes7.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.godSquare.a.a jZQ;

        public ViewHolder(com.baidu.tieba.godSquare.a.a aVar) {
            super(aVar.getView());
            this.jZQ = aVar;
        }
    }
}

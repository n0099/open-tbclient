package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.b<u> {
    private View.OnClickListener aZD;
    private com.baidu.tieba.horizonalList.widget.c cVH;
    private HListView cVT;
    private List<com.baidu.tieba.horizonalList.widget.d> cVV;
    public v dZe;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aZD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akP() != null) {
                    d.this.akP().a(view, null);
                }
            }
        };
        this.cVT = new HListView(getContext());
        this.cVT.setHeaderDividersEnabled(false);
        this.cVT.setFooterDividersEnabled(false);
        this.cVT.setSelector(d.f.list_selector_transparent);
        this.dZe = new v(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cVH = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.frs_school_recommend_user, this.dZe);
        this.cVH.setOnClickListener(this.aZD);
        this.cVT.setAdapter((ListAdapter) this.cVH);
        this.cVu.addView(this.cVT);
        this.cVt.setVisibility(8);
        this.cVn.setTextSize(0, l.t(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cVT != null && this.cVH != null) {
            aj.r(this.cVn, d.C0141d.cp_cont_d);
            this.cVH.gi(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(u uVar) {
        super.a((d) uVar);
        if (uVar != null && !com.baidu.tbadk.core.util.v.E(uVar.getDataList())) {
            if (StringUtils.isNull(uVar.mGroupTitle)) {
                this.cVn.setText(getContext().getResources().getString(d.j.school_recommend));
            } else {
                this.cVn.setText(uVar.mGroupTitle);
            }
            if (aH(uVar.getDataList())) {
                this.cVV = uVar.getDataList();
                this.cVH.setData(this.cVV);
                this.cVH.notifyDataSetChanged();
            }
        }
    }

    private boolean aH(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.E(this.cVV) && com.baidu.tbadk.core.util.v.D(this.cVV) == com.baidu.tbadk.core.util.v.D(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.D(this.cVV); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(this.cVV, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
                if ((dVar instanceof ar) && (dVar2 instanceof ar) && !((ar) dVar).metaData.getUserId().equals(((ar) dVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

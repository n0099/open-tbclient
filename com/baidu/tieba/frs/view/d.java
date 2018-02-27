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
    private View.OnClickListener aZB;
    private com.baidu.tieba.horizonalList.widget.c cVE;
    private HListView cVQ;
    private List<com.baidu.tieba.horizonalList.widget.d> cVS;
    public v dYN;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aZB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akO() != null) {
                    d.this.akO().a(view, null);
                }
            }
        };
        this.cVQ = new HListView(getContext());
        this.cVQ.setHeaderDividersEnabled(false);
        this.cVQ.setFooterDividersEnabled(false);
        this.cVQ.setSelector(d.f.list_selector_transparent);
        this.dYN = new v(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cVE = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.frs_school_recommend_user, this.dYN);
        this.cVE.setOnClickListener(this.aZB);
        this.cVQ.setAdapter((ListAdapter) this.cVE);
        this.cVr.addView(this.cVQ);
        this.cVq.setVisibility(8);
        this.cVk.setTextSize(0, l.t(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cVQ != null && this.cVE != null) {
            aj.r(this.cVk, d.C0141d.cp_cont_d);
            this.cVE.gi(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(u uVar) {
        super.a((d) uVar);
        if (uVar != null && !com.baidu.tbadk.core.util.v.E(uVar.getDataList())) {
            if (StringUtils.isNull(uVar.mGroupTitle)) {
                this.cVk.setText(getContext().getResources().getString(d.j.school_recommend));
            } else {
                this.cVk.setText(uVar.mGroupTitle);
            }
            if (aH(uVar.getDataList())) {
                this.cVS = uVar.getDataList();
                this.cVE.setData(this.cVS);
                this.cVE.notifyDataSetChanged();
            }
        }
    }

    private boolean aH(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.E(this.cVS) && com.baidu.tbadk.core.util.v.D(this.cVS) == com.baidu.tbadk.core.util.v.D(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.D(this.cVS); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(this.cVS, i);
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

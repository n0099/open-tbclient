package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<s> {
    private View.OnClickListener bNw;
    private List<com.baidu.tieba.horizonalList.widget.c> bkQ;
    private com.baidu.tieba.horizonalList.widget.b egU;
    private HListView ehd;
    public t fzK;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bNw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQf() != null) {
                    d.this.aQf().a(view, null);
                }
            }
        };
        this.ehd = new HListView(getContext());
        this.ehd.setHeaderDividersEnabled(false);
        this.ehd.setFooterDividersEnabled(false);
        this.ehd.setSelector(d.f.list_selector_transparent);
        this.fzK = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.egU = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.frs_school_recommend_user, this.fzK);
        this.egU.setOnClickListener(this.bNw);
        this.ehd.setAdapter((ListAdapter) this.egU);
        this.efo.addView(this.ehd);
        this.efn.setVisibility(8);
        this.efh.setTextSize(0, l.h(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ehd != null && this.egU != null) {
            al.j(this.efh, d.C0277d.cp_cont_d);
            this.egU.hM(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.T(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.efh.setText(getContext().getResources().getString(d.j.school_recommend));
            } else {
                this.efh.setText(sVar.mGroupTitle);
            }
            if (bn(sVar.getDataList())) {
                this.bkQ = sVar.getDataList();
                this.egU.setData(this.bkQ);
                this.egU.notifyDataSetChanged();
            }
        }
    }

    private boolean bn(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.T(list)) {
            return false;
        }
        if (!v.T(this.bkQ) && v.S(this.bkQ) == v.S(list)) {
            for (int i = 0; i < v.S(this.bkQ); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.bkQ, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) v.c(list, i);
                if ((cVar instanceof an) && (cVar2 instanceof an) && !((an) cVar).metaData.getUserId().equals(((an) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

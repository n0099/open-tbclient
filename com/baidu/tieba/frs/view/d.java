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
    private View.OnClickListener bNu;
    private List<com.baidu.tieba.horizonalList.widget.c> bkN;
    private com.baidu.tieba.horizonalList.widget.b ehi;
    private HListView ehr;
    public t fzW;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bNu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQh() != null) {
                    d.this.aQh().a(view, null);
                }
            }
        };
        this.ehr = new HListView(getContext());
        this.ehr.setHeaderDividersEnabled(false);
        this.ehr.setFooterDividersEnabled(false);
        this.ehr.setSelector(d.f.list_selector_transparent);
        this.fzW = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.ehi = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.frs_school_recommend_user, this.fzW);
        this.ehi.setOnClickListener(this.bNu);
        this.ehr.setAdapter((ListAdapter) this.ehi);
        this.efC.addView(this.ehr);
        this.efB.setVisibility(8);
        this.efv.setTextSize(0, l.h(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ehr != null && this.ehi != null) {
            al.j(this.efv, d.C0277d.cp_cont_d);
            this.ehi.hN(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.T(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.efv.setText(getContext().getResources().getString(d.j.school_recommend));
            } else {
                this.efv.setText(sVar.mGroupTitle);
            }
            if (bp(sVar.getDataList())) {
                this.bkN = sVar.getDataList();
                this.ehi.setData(this.bkN);
                this.ehi.notifyDataSetChanged();
            }
        }
    }

    private boolean bp(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.T(list)) {
            return false;
        }
        if (!v.T(this.bkN) && v.S(this.bkN) == v.S(list)) {
            for (int i = 0; i < v.S(this.bkN); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.bkN, i);
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

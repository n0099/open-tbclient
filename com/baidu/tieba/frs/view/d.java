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
    private View.OnClickListener bNx;
    private List<com.baidu.tieba.horizonalList.widget.c> bkR;
    private com.baidu.tieba.horizonalList.widget.b egV;
    private HListView ehe;
    public t fzK;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bNx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQf() != null) {
                    d.this.aQf().a(view, null);
                }
            }
        };
        this.ehe = new HListView(getContext());
        this.ehe.setHeaderDividersEnabled(false);
        this.ehe.setFooterDividersEnabled(false);
        this.ehe.setSelector(d.f.list_selector_transparent);
        this.fzK = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.egV = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.frs_school_recommend_user, this.fzK);
        this.egV.setOnClickListener(this.bNx);
        this.ehe.setAdapter((ListAdapter) this.egV);
        this.efp.addView(this.ehe);
        this.efo.setVisibility(8);
        this.efi.setTextSize(0, l.h(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ehe != null && this.egV != null) {
            al.j(this.efi, d.C0277d.cp_cont_d);
            this.egV.hM(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.T(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.efi.setText(getContext().getResources().getString(d.j.school_recommend));
            } else {
                this.efi.setText(sVar.mGroupTitle);
            }
            if (bn(sVar.getDataList())) {
                this.bkR = sVar.getDataList();
                this.egV.setData(this.bkR);
                this.egV.notifyDataSetChanged();
            }
        }
    }

    private boolean bn(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.T(list)) {
            return false;
        }
        if (!v.T(this.bkR) && v.S(this.bkR) == v.S(list)) {
            for (int i = 0; i < v.S(this.bkR); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.bkR, i);
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

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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<s> {
    private View.OnClickListener bVi;
    private List<com.baidu.tieba.horizonalList.widget.c> bqT;
    private com.baidu.tieba.horizonalList.widget.b ewI;
    private HListView ewR;
    public t fQG;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bVi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aXo() != null) {
                    d.this.aXo().a(view, null);
                }
            }
        };
        this.ewR = new HListView(getContext());
        this.ewR.setHeaderDividersEnabled(false);
        this.ewR.setFooterDividersEnabled(false);
        this.ewR.setSelector(R.drawable.list_selector_transparent);
        this.fQG = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.ewI = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.fQG);
        this.ewI.setOnClickListener(this.bVi);
        this.ewR.setAdapter((ListAdapter) this.ewI);
        this.evc.addView(this.ewR);
        this.evb.setVisibility(8);
        this.euV.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ewR != null && this.ewI != null) {
            al.j(this.euV, R.color.cp_cont_d);
            this.ewI.iA(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.aa(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.euV.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.euV.setText(sVar.mGroupTitle);
            }
            if (bv(sVar.getDataList())) {
                this.bqT = sVar.getDataList();
                this.ewI.setData(this.bqT);
                this.ewI.notifyDataSetChanged();
            }
        }
    }

    private boolean bv(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.aa(list)) {
            return false;
        }
        if (!v.aa(this.bqT) && v.Z(this.bqT) == v.Z(list)) {
            for (int i = 0; i < v.Z(this.bqT); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.bqT, i);
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

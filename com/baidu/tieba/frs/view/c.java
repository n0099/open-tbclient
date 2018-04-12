package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<q> {
    private View.OnClickListener alg;
    private com.baidu.tieba.horizonalList.widget.b cnK;
    private HListView cnT;
    private List<com.baidu.tieba.horizonalList.widget.c> cnV;
    public r dtN;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.alg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, null);
                }
            }
        };
        this.cnT = new HListView(getContext());
        this.cnT.setHeaderDividersEnabled(false);
        this.cnT.setFooterDividersEnabled(false);
        this.cnT.setSelector(d.f.list_selector_transparent);
        this.dtN = new r(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cnK = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.frs_school_recommend_user, this.dtN);
        this.cnK.setOnClickListener(this.alg);
        this.cnT.setAdapter((ListAdapter) this.cnK);
        this.clX.addView(this.cnT);
        this.clW.setVisibility(8);
        this.clQ.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cnT != null && this.cnK != null) {
            ak.h(this.clQ, d.C0126d.cp_cont_d);
            this.cnK.di(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(q qVar) {
        super.a((c) qVar);
        if (qVar != null && !v.w(qVar.getDataList())) {
            if (StringUtils.isNull(qVar.mGroupTitle)) {
                this.clQ.setText(getContext().getResources().getString(d.k.school_recommend));
            } else {
                this.clQ.setText(qVar.mGroupTitle);
            }
            if (aC(qVar.getDataList())) {
                this.cnV = qVar.getDataList();
                this.cnK.setData(this.cnV);
                this.cnK.notifyDataSetChanged();
            }
        }
    }

    private boolean aC(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.w(list)) {
            return false;
        }
        if (!v.w(this.cnV) && v.v(this.cnV) == v.v(list)) {
            for (int i = 0; i < v.v(this.cnV); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.cnV, i);
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

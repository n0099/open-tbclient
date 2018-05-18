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
    private com.baidu.tieba.horizonalList.widget.b coQ;
    private HListView coZ;
    private List<com.baidu.tieba.horizonalList.widget.c> cpb;
    public r duS;

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
        this.coZ = new HListView(getContext());
        this.coZ.setHeaderDividersEnabled(false);
        this.coZ.setFooterDividersEnabled(false);
        this.coZ.setSelector(d.f.list_selector_transparent);
        this.duS = new r(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.coQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.frs_school_recommend_user, this.duS);
        this.coQ.setOnClickListener(this.alg);
        this.coZ.setAdapter((ListAdapter) this.coQ);
        this.cne.addView(this.coZ);
        this.cnd.setVisibility(8);
        this.cmX.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.coZ != null && this.coQ != null) {
            ak.h(this.cmX, d.C0126d.cp_cont_d);
            this.coQ.di(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(q qVar) {
        super.a((c) qVar);
        if (qVar != null && !v.w(qVar.getDataList())) {
            if (StringUtils.isNull(qVar.mGroupTitle)) {
                this.cmX.setText(getContext().getResources().getString(d.k.school_recommend));
            } else {
                this.cmX.setText(qVar.mGroupTitle);
            }
            if (aF(qVar.getDataList())) {
                this.cpb = qVar.getDataList();
                this.coQ.setData(this.cpb);
                this.coQ.notifyDataSetChanged();
            }
        }
    }

    private boolean aF(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.w(list)) {
            return false;
        }
        if (!v.w(this.cpb) && v.v(this.cpb) == v.v(list)) {
            for (int i = 0; i < v.v(this.cpb); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.cpb, i);
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

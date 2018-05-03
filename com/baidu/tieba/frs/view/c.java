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
    private com.baidu.tieba.horizonalList.widget.b cnH;
    private HListView cnQ;
    private List<com.baidu.tieba.horizonalList.widget.c> cnS;
    public r dtK;

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
        this.cnQ = new HListView(getContext());
        this.cnQ.setHeaderDividersEnabled(false);
        this.cnQ.setFooterDividersEnabled(false);
        this.cnQ.setSelector(d.f.list_selector_transparent);
        this.dtK = new r(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cnH = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.frs_school_recommend_user, this.dtK);
        this.cnH.setOnClickListener(this.alg);
        this.cnQ.setAdapter((ListAdapter) this.cnH);
        this.clU.addView(this.cnQ);
        this.clT.setVisibility(8);
        this.clN.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cnQ != null && this.cnH != null) {
            ak.h(this.clN, d.C0126d.cp_cont_d);
            this.cnH.dh(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(q qVar) {
        super.a((c) qVar);
        if (qVar != null && !v.w(qVar.getDataList())) {
            if (StringUtils.isNull(qVar.mGroupTitle)) {
                this.clN.setText(getContext().getResources().getString(d.k.school_recommend));
            } else {
                this.clN.setText(qVar.mGroupTitle);
            }
            if (aC(qVar.getDataList())) {
                this.cnS = qVar.getDataList();
                this.cnH.setData(this.cnS);
                this.cnH.notifyDataSetChanged();
            }
        }
    }

    private boolean aC(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.w(list)) {
            return false;
        }
        if (!v.w(this.cnS) && v.v(this.cnS) == v.v(list)) {
            for (int i = 0; i < v.v(this.cnS); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.cnS, i);
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

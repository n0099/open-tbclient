package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<t> {
    private View.OnClickListener Nh;
    private com.baidu.tieba.horizonalList.widget.b fIT;
    private HListView gQE;
    public u gQF;
    private List<com.baidu.tieba.horizonalList.widget.c> gQG;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Nh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.buE() != null) {
                    d.this.buE().a(view, null);
                }
            }
        };
        this.gQE = new HListView(getContext());
        this.gQE.setHeaderDividersEnabled(false);
        this.gQE.setFooterDividersEnabled(false);
        this.gQE.setSelector(R.drawable.list_selector_transparent);
        this.gQF = new u(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.fIT = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.gQF);
        this.fIT.setOnClickListener(this.Nh);
        this.gQE.setAdapter((ListAdapter) this.fIT);
        this.fHo.addView(this.gQE);
        this.fHn.setVisibility(8);
        this.fHh.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gQE != null && this.fIT != null) {
            am.setViewTextColor(this.fHh, (int) R.color.cp_cont_d);
            this.fIT.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(t tVar) {
        super.a((d) tVar);
        if (tVar != null && !v.isEmpty(tVar.getDataList())) {
            if (StringUtils.isNull(tVar.mGroupTitle)) {
                this.fHh.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.fHh.setText(tVar.mGroupTitle);
            }
            if (cu(tVar.getDataList())) {
                this.gQG = tVar.getDataList();
                this.fIT.setData(this.gQG);
                this.fIT.notifyDataSetChanged();
            }
        }
    }

    private boolean cu(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        if (!v.isEmpty(this.gQG) && v.getCount(this.gQG) == v.getCount(list)) {
            for (int i = 0; i < v.getCount(this.gQG); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.getItem(this.gQG, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) v.getItem(list, i);
                if ((cVar instanceof ao) && (cVar2 instanceof ao) && !((ao) cVar).metaData.getUserId().equals(((ao) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

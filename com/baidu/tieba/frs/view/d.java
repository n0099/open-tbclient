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
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.b<s> {
    private View.OnClickListener bXj;
    private List<com.baidu.tieba.horizonalList.widget.c> bse;
    private HListView eDH;
    private com.baidu.tieba.horizonalList.widget.b eDy;
    public t fYn;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bXj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aZU() != null) {
                    d.this.aZU().a(view, null);
                }
            }
        };
        this.eDH = new HListView(getContext());
        this.eDH.setHeaderDividersEnabled(false);
        this.eDH.setFooterDividersEnabled(false);
        this.eDH.setSelector(R.drawable.list_selector_transparent);
        this.fYn = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.eDy = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.fYn);
        this.eDy.setOnClickListener(this.bXj);
        this.eDH.setAdapter((ListAdapter) this.eDy);
        this.eBS.addView(this.eDH);
        this.eBR.setVisibility(8);
        this.eBL.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eDH != null && this.eDy != null) {
            am.j(this.eBL, R.color.cp_cont_d);
            this.eDy.iJ(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.aa(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.eBL.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.eBL.setText(sVar.mGroupTitle);
            }
            if (bx(sVar.getDataList())) {
                this.bse = sVar.getDataList();
                this.eDy.setData(this.bse);
                this.eDy.notifyDataSetChanged();
            }
        }
    }

    private boolean bx(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.aa(list)) {
            return false;
        }
        if (!v.aa(this.bse) && v.Z(this.bse) == v.Z(list)) {
            for (int i = 0; i < v.Z(this.bse); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.bse, i);
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

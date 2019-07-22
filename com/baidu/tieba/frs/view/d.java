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
    private View.OnClickListener bWk;
    private List<com.baidu.tieba.horizonalList.widget.c> brG;
    private com.baidu.tieba.horizonalList.widget.b eBI;
    private HListView eBR;
    public t fVG;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bWk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aZo() != null) {
                    d.this.aZo().a(view, null);
                }
            }
        };
        this.eBR = new HListView(getContext());
        this.eBR.setHeaderDividersEnabled(false);
        this.eBR.setFooterDividersEnabled(false);
        this.eBR.setSelector(R.drawable.list_selector_transparent);
        this.fVG = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.eBI = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.fVG);
        this.eBI.setOnClickListener(this.bWk);
        this.eBR.setAdapter((ListAdapter) this.eBI);
        this.eAc.addView(this.eBR);
        this.eAb.setVisibility(8);
        this.ezV.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eBR != null && this.eBI != null) {
            am.j(this.ezV, R.color.cp_cont_d);
            this.eBI.iG(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.aa(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.ezV.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.ezV.setText(sVar.mGroupTitle);
            }
            if (bx(sVar.getDataList())) {
                this.brG = sVar.getDataList();
                this.eBI.setData(this.brG);
                this.eBI.notifyDataSetChanged();
            }
        }
    }

    private boolean bx(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.aa(list)) {
            return false;
        }
        if (!v.aa(this.brG) && v.Z(this.brG) == v.Z(list)) {
            for (int i = 0; i < v.Z(this.brG); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.c(this.brG, i);
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

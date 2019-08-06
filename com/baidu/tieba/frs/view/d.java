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
    private View.OnClickListener bWq;
    private List<com.baidu.tieba.horizonalList.widget.c> brG;
    private com.baidu.tieba.horizonalList.widget.b eBP;
    private HListView eBY;
    public t fWw;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bWq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aZq() != null) {
                    d.this.aZq().a(view, null);
                }
            }
        };
        this.eBY = new HListView(getContext());
        this.eBY.setHeaderDividersEnabled(false);
        this.eBY.setFooterDividersEnabled(false);
        this.eBY.setSelector(R.drawable.list_selector_transparent);
        this.fWw = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.eBP = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.fWw);
        this.eBP.setOnClickListener(this.bWq);
        this.eBY.setAdapter((ListAdapter) this.eBP);
        this.eAj.addView(this.eBY);
        this.eAi.setVisibility(8);
        this.eAc.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eBY != null && this.eBP != null) {
            am.j(this.eAc, R.color.cp_cont_d);
            this.eBP.iG(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.aa(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.eAc.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.eAc.setText(sVar.mGroupTitle);
            }
            if (bx(sVar.getDataList())) {
                this.brG = sVar.getDataList();
                this.eBP.setData(this.brG);
                this.eBP.notifyDataSetChanged();
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

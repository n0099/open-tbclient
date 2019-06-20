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
    private View.OnClickListener bVj;
    private List<com.baidu.tieba.horizonalList.widget.c> bqT;
    private com.baidu.tieba.horizonalList.widget.b ewJ;
    private HListView ewS;
    public t fQJ;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bVj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aXr() != null) {
                    d.this.aXr().a(view, null);
                }
            }
        };
        this.ewS = new HListView(getContext());
        this.ewS.setHeaderDividersEnabled(false);
        this.ewS.setFooterDividersEnabled(false);
        this.ewS.setSelector(R.drawable.list_selector_transparent);
        this.fQJ = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.ewJ = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.fQJ);
        this.ewJ.setOnClickListener(this.bVj);
        this.ewS.setAdapter((ListAdapter) this.ewJ);
        this.evd.addView(this.ewS);
        this.evc.setVisibility(8);
        this.euW.setTextSize(0, l.g(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ewS != null && this.ewJ != null) {
            al.j(this.euW, R.color.cp_cont_d);
            this.ewJ.iA(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.aa(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.euW.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.euW.setText(sVar.mGroupTitle);
            }
            if (bv(sVar.getDataList())) {
                this.bqT = sVar.getDataList();
                this.ewJ.setData(this.bqT);
                this.ewJ.notifyDataSetChanged();
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

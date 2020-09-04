package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.c<aa> {
    private View.OnClickListener aiC;
    private com.baidu.tieba.horizonalList.widget.b hja;
    private HListView izq;
    public ab izr;
    private List<com.baidu.tieba.horizonalList.widget.c> izs;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cbA() != null) {
                    e.this.cbA().a(view, null);
                }
            }
        };
        this.izq = new HListView(getContext());
        this.izq.setHeaderDividersEnabled(false);
        this.izq.setFooterDividersEnabled(false);
        this.izq.setSelector(R.drawable.list_selector_transparent);
        this.izr = new ab(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.hja = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.izr);
        this.hja.setOnClickListener(this.aiC);
        this.izq.setAdapter((ListAdapter) this.hja);
        this.hhu.addView(this.izq);
        this.hht.setVisibility(8);
        this.hhn.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.izq != null && this.hja != null) {
            ap.setViewTextColor(this.hhn, (int) R.color.cp_cont_d);
            this.hja.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(aa aaVar) {
        super.a((e) aaVar);
        if (aaVar != null && !y.isEmpty(aaVar.getDataList())) {
            if (StringUtils.isNull(aaVar.mGroupTitle)) {
                this.hhn.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.hhn.setText(aaVar.mGroupTitle);
            }
            if (cT(aaVar.getDataList())) {
                this.izs = aaVar.getDataList();
                this.hja.setData(this.izs);
                this.hja.notifyDataSetChanged();
            }
        }
    }

    private boolean cT(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.izs) && y.getCount(this.izs) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.izs); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.izs, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) y.getItem(list, i);
                if ((cVar instanceof bb) && (cVar2 instanceof bb) && !((bb) cVar).metaData.getUserId().equals(((bb) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

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
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.c<aa> {
    private View.OnClickListener ajp;
    private com.baidu.tieba.horizonalList.widget.b hXq;
    private HListView jnW;
    public ab jnX;
    private List<com.baidu.tieba.horizonalList.widget.c> jnY;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cnT() != null) {
                    e.this.cnT().a(view, null);
                }
            }
        };
        this.jnW = new HListView(getContext());
        this.jnW.setHeaderDividersEnabled(false);
        this.jnW.setFooterDividersEnabled(false);
        this.jnW.setSelector(R.drawable.list_selector_transparent);
        this.jnX = new ab(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.hXq = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.jnX);
        this.hXq.setOnClickListener(this.ajp);
        this.jnW.setAdapter((ListAdapter) this.hXq);
        this.hVL.addView(this.jnW);
        this.hVK.setVisibility(8);
        this.hVE.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jnW != null && this.hXq != null) {
            ap.setViewTextColor(this.hVE, (int) R.color.cp_cont_d);
            this.hXq.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(aa aaVar) {
        super.a((e) aaVar);
        if (aaVar != null && !y.isEmpty(aaVar.getDataList())) {
            if (StringUtils.isNull(aaVar.mGroupTitle)) {
                this.hVE.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.hVE.setText(aaVar.mGroupTitle);
            }
            if (dt(aaVar.getDataList())) {
                this.jnY = aaVar.getDataList();
                this.hXq.setData(this.jnY);
                this.hXq.notifyDataSetChanged();
            }
        }
    }

    private boolean dt(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.jnY) && y.getCount(this.jnY) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.jnY); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.jnY, i);
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

package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsSchoolRecommendItemView;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.c<x> {
    private View.OnClickListener akV;
    private com.baidu.tieba.horizonalList.widget.b ivk;
    private HListView jOO;
    public FrsSchoolRecommendItemView jOP;
    private List<com.baidu.tieba.horizonalList.widget.c> jOQ;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.akV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cuC() != null) {
                    d.this.cuC().a(view, null);
                }
            }
        };
        this.jOO = new HListView(getContext());
        this.jOO.setHeaderDividersEnabled(false);
        this.jOO.setFooterDividersEnabled(false);
        this.jOO.setSelector(R.drawable.list_selector_transparent);
        this.jOP = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.ivk = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.jOP);
        this.ivk.setOnClickListener(this.akV);
        this.jOO.setAdapter((ListAdapter) this.ivk);
        this.itF.addView(this.jOO);
        this.itE.setVisibility(8);
        this.ity.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jOO != null && this.ivk != null) {
            ao.setViewTextColor(this.ity, R.color.CAM_X0109);
            this.ivk.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(x xVar) {
        super.a((d) xVar);
        if (xVar != null && !com.baidu.tbadk.core.util.x.isEmpty(xVar.getDataList())) {
            if (StringUtils.isNull(xVar.mGroupTitle)) {
                this.ity.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.ity.setText(xVar.mGroupTitle);
            }
            if (dK(xVar.getDataList())) {
                this.jOQ = xVar.getDataList();
                this.ivk.setData(this.jOQ);
                this.ivk.notifyDataSetChanged();
            }
        }
    }

    private boolean dK(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jOQ) && com.baidu.tbadk.core.util.x.getCount(this.jOQ) == com.baidu.tbadk.core.util.x.getCount(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.getCount(this.jOQ); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.x.getItem(this.jOQ, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.x.getItem(list, i);
                if ((cVar instanceof ay) && (cVar2 instanceof ay) && !((ay) cVar).metaData.getUserId().equals(((ay) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

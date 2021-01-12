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
    private View.OnClickListener ake;
    private com.baidu.tieba.horizonalList.widget.b iqD;
    private HListView jKi;
    public FrsSchoolRecommendItemView jKj;
    private List<com.baidu.tieba.horizonalList.widget.c> jKk;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ake = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cqL() != null) {
                    d.this.cqL().a(view, null);
                }
            }
        };
        this.jKi = new HListView(getContext());
        this.jKi.setHeaderDividersEnabled(false);
        this.jKi.setFooterDividersEnabled(false);
        this.jKi.setSelector(R.drawable.list_selector_transparent);
        this.jKj = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.iqD = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.jKj);
        this.iqD.setOnClickListener(this.ake);
        this.jKi.setAdapter((ListAdapter) this.iqD);
        this.ioY.addView(this.jKi);
        this.ioX.setVisibility(8);
        this.ioR.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jKi != null && this.iqD != null) {
            ao.setViewTextColor(this.ioR, R.color.CAM_X0109);
            this.iqD.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(x xVar) {
        super.a((d) xVar);
        if (xVar != null && !com.baidu.tbadk.core.util.x.isEmpty(xVar.getDataList())) {
            if (StringUtils.isNull(xVar.mGroupTitle)) {
                this.ioR.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.ioR.setText(xVar.mGroupTitle);
            }
            if (dK(xVar.getDataList())) {
                this.jKk = xVar.getDataList();
                this.iqD.setData(this.jKk);
                this.iqD.notifyDataSetChanged();
            }
        }
    }

    private boolean dK(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jKk) && com.baidu.tbadk.core.util.x.getCount(this.jKk) == com.baidu.tbadk.core.util.x.getCount(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.x.getCount(this.jKk); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.x.getItem(this.jKk, i);
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

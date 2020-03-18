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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<u> {
    private View.OnClickListener Ni;
    private com.baidu.tieba.horizonalList.widget.b fJQ;
    private HListView gRZ;
    public v gSa;
    private List<com.baidu.tieba.horizonalList.widget.c> gSb;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Ni = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.buM() != null) {
                    d.this.buM().a(view, null);
                }
            }
        };
        this.gRZ = new HListView(getContext());
        this.gRZ.setHeaderDividersEnabled(false);
        this.gRZ.setFooterDividersEnabled(false);
        this.gRZ.setSelector(R.drawable.list_selector_transparent);
        this.gSa = new v(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.fJQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.gSa);
        this.fJQ.setOnClickListener(this.Ni);
        this.gRZ.setAdapter((ListAdapter) this.fJQ);
        this.fIl.addView(this.gRZ);
        this.fIk.setVisibility(8);
        this.fIe.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gRZ != null && this.fJQ != null) {
            am.setViewTextColor(this.fIe, (int) R.color.cp_cont_d);
            this.fJQ.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(u uVar) {
        super.a((d) uVar);
        if (uVar != null && !com.baidu.tbadk.core.util.v.isEmpty(uVar.getDataList())) {
            if (StringUtils.isNull(uVar.mGroupTitle)) {
                this.fIe.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.fIe.setText(uVar.mGroupTitle);
            }
            if (cu(uVar.getDataList())) {
                this.gSb = uVar.getDataList();
                this.fJQ.setData(this.gSb);
                this.fJQ.notifyDataSetChanged();
            }
        }
    }

    private boolean cu(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gSb) && com.baidu.tbadk.core.util.v.getCount(this.gSb) == com.baidu.tbadk.core.util.v.getCount(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.getCount(this.gSb); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(this.gSb, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list, i);
                if ((cVar instanceof ap) && (cVar2 instanceof ap) && !((ap) cVar).metaData.getUserId().equals(((ap) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

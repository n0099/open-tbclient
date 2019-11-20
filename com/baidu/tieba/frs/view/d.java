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
    private List<com.baidu.tieba.horizonalList.widget.c> bJY;
    private View.OnClickListener clw;
    private com.baidu.tieba.horizonalList.widget.b eLo;
    private HListView eLx;
    public t fWR;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.clw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aZV() != null) {
                    d.this.aZV().a(view, null);
                }
            }
        };
        this.eLx = new HListView(getContext());
        this.eLx.setHeaderDividersEnabled(false);
        this.eLx.setFooterDividersEnabled(false);
        this.eLx.setSelector(R.drawable.list_selector_transparent);
        this.fWR = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.eLo = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.fWR);
        this.eLo.setOnClickListener(this.clw);
        this.eLx.setAdapter((ListAdapter) this.eLo);
        this.eJJ.addView(this.eLx);
        this.eJI.setVisibility(8);
        this.eJC.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eLx != null && this.eLo != null) {
            am.setViewTextColor(this.eJC, (int) R.color.cp_cont_d);
            this.eLo.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.isEmpty(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.eJC.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.eJC.setText(sVar.mGroupTitle);
            }
            if (bK(sVar.getDataList())) {
                this.bJY = sVar.getDataList();
                this.eLo.setData(this.bJY);
                this.eLo.notifyDataSetChanged();
            }
        }
    }

    private boolean bK(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        if (!v.isEmpty(this.bJY) && v.getCount(this.bJY) == v.getCount(list)) {
            for (int i = 0; i < v.getCount(this.bJY); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.getItem(this.bJY, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) v.getItem(list, i);
                if ((cVar instanceof an) && (cVar2 instanceof an) && !((an) cVar).metaData.getUserId().equals(((an) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

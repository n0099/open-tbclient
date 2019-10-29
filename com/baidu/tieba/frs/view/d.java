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
    private List<com.baidu.tieba.horizonalList.widget.c> bKP;
    private View.OnClickListener cmo;
    private com.baidu.tieba.horizonalList.widget.b eMf;
    private HListView eMo;
    public t fXI;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.cmo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aZX() != null) {
                    d.this.aZX().a(view, null);
                }
            }
        };
        this.eMo = new HListView(getContext());
        this.eMo.setHeaderDividersEnabled(false);
        this.eMo.setFooterDividersEnabled(false);
        this.eMo.setSelector(R.drawable.list_selector_transparent);
        this.fXI = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.eMf = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.fXI);
        this.eMf.setOnClickListener(this.cmo);
        this.eMo.setAdapter((ListAdapter) this.eMf);
        this.eKA.addView(this.eMo);
        this.eKz.setVisibility(8);
        this.eKt.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eMo != null && this.eMf != null) {
            am.setViewTextColor(this.eKt, (int) R.color.cp_cont_d);
            this.eMf.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((d) sVar);
        if (sVar != null && !v.isEmpty(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.eKt.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.eKt.setText(sVar.mGroupTitle);
            }
            if (bK(sVar.getDataList())) {
                this.bKP = sVar.getDataList();
                this.eMf.setData(this.bKP);
                this.eMf.notifyDataSetChanged();
            }
        }
    }

    private boolean bK(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        if (!v.isEmpty(this.bKP) && v.getCount(this.bKP) == v.getCount(list)) {
            for (int i = 0; i < v.getCount(this.bKP); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.getItem(this.bKP, i);
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

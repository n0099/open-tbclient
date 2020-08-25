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
    private View.OnClickListener aiA;
    private com.baidu.tieba.horizonalList.widget.b hiW;
    private HListView izk;
    public ab izl;
    private List<com.baidu.tieba.horizonalList.widget.c> izm;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cbz() != null) {
                    e.this.cbz().a(view, null);
                }
            }
        };
        this.izk = new HListView(getContext());
        this.izk.setHeaderDividersEnabled(false);
        this.izk.setFooterDividersEnabled(false);
        this.izk.setSelector(R.drawable.list_selector_transparent);
        this.izl = new ab(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.hiW = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.izl);
        this.hiW.setOnClickListener(this.aiA);
        this.izk.setAdapter((ListAdapter) this.hiW);
        this.hhq.addView(this.izk);
        this.hhp.setVisibility(8);
        this.hhj.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.izk != null && this.hiW != null) {
            ap.setViewTextColor(this.hhj, (int) R.color.cp_cont_d);
            this.hiW.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(aa aaVar) {
        super.a((e) aaVar);
        if (aaVar != null && !y.isEmpty(aaVar.getDataList())) {
            if (StringUtils.isNull(aaVar.mGroupTitle)) {
                this.hhj.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.hhj.setText(aaVar.mGroupTitle);
            }
            if (cT(aaVar.getDataList())) {
                this.izm = aaVar.getDataList();
                this.hiW.setData(this.izm);
                this.hiW.notifyDataSetChanged();
            }
        }
    }

    private boolean cT(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.izm) && y.getCount(this.izm) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.izm); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.izm, i);
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

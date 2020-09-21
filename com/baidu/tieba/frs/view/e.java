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
/* loaded from: classes21.dex */
public class e extends com.baidu.tieba.card.c<aa> {
    private View.OnClickListener aiW;
    private com.baidu.tieba.horizonalList.widget.b hqd;
    private HListView iGL;
    public ab iGM;
    private List<com.baidu.tieba.horizonalList.widget.c> iGN;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.ceP() != null) {
                    e.this.ceP().a(view, null);
                }
            }
        };
        this.iGL = new HListView(getContext());
        this.iGL.setHeaderDividersEnabled(false);
        this.iGL.setFooterDividersEnabled(false);
        this.iGL.setSelector(R.drawable.list_selector_transparent);
        this.iGM = new ab(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.hqd = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.iGM);
        this.hqd.setOnClickListener(this.aiW);
        this.iGL.setAdapter((ListAdapter) this.hqd);
        this.hoy.addView(this.iGL);
        this.hox.setVisibility(8);
        this.hor.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.iGL != null && this.hqd != null) {
            ap.setViewTextColor(this.hor, (int) R.color.cp_cont_d);
            this.hqd.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(aa aaVar) {
        super.a((e) aaVar);
        if (aaVar != null && !y.isEmpty(aaVar.getDataList())) {
            if (StringUtils.isNull(aaVar.mGroupTitle)) {
                this.hor.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.hor.setText(aaVar.mGroupTitle);
            }
            if (cZ(aaVar.getDataList())) {
                this.iGN = aaVar.getDataList();
                this.hqd.setData(this.iGN);
                this.hqd.notifyDataSetChanged();
            }
        }
    }

    private boolean cZ(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.iGN) && y.getCount(this.iGN) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.iGN); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.iGN, i);
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

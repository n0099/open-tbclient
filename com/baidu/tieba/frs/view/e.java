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
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.c<z> {
    private View.OnClickListener akt;
    private com.baidu.tieba.horizonalList.widget.b iiN;
    private HListView jCk;
    public aa jCl;
    private List<com.baidu.tieba.horizonalList.widget.c> jCm;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.crI() != null) {
                    e.this.crI().a(view, null);
                }
            }
        };
        this.jCk = new HListView(getContext());
        this.jCk.setHeaderDividersEnabled(false);
        this.jCk.setFooterDividersEnabled(false);
        this.jCk.setSelector(R.drawable.list_selector_transparent);
        this.jCl = new aa(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.iiN = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.jCl);
        this.iiN.setOnClickListener(this.akt);
        this.jCk.setAdapter((ListAdapter) this.iiN);
        this.ihi.addView(this.jCk);
        this.ihh.setVisibility(8);
        this.ihb.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jCk != null && this.iiN != null) {
            ap.setViewTextColor(this.ihb, (int) R.color.CAM_X0109);
            this.iiN.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(z zVar) {
        super.a((e) zVar);
        if (zVar != null && !y.isEmpty(zVar.getDataList())) {
            if (StringUtils.isNull(zVar.mGroupTitle)) {
                this.ihb.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.ihb.setText(zVar.mGroupTitle);
            }
            if (dC(zVar.getDataList())) {
                this.jCm = zVar.getDataList();
                this.iiN.setData(this.jCm);
                this.iiN.notifyDataSetChanged();
            }
        }
    }

    private boolean dC(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.jCm) && y.getCount(this.jCm) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.jCm); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.jCm, i);
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

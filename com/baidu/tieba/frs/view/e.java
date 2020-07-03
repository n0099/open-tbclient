package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.c<z> {
    private View.OnClickListener ahw;
    private com.baidu.tieba.horizonalList.widget.b gQx;
    private HListView iff;
    public aa ifg;
    private List<com.baidu.tieba.horizonalList.widget.c> ifh;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ahw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bOc() != null) {
                    e.this.bOc().a(view, null);
                }
            }
        };
        this.iff = new HListView(getContext());
        this.iff.setHeaderDividersEnabled(false);
        this.iff.setFooterDividersEnabled(false);
        this.iff.setSelector(R.drawable.list_selector_transparent);
        this.ifg = new aa(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.gQx = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.ifg);
        this.gQx.setOnClickListener(this.ahw);
        this.iff.setAdapter((ListAdapter) this.gQx);
        this.gOS.addView(this.iff);
        this.gOR.setVisibility(8);
        this.gOL.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.iff != null && this.gQx != null) {
            an.setViewTextColor(this.gOL, (int) R.color.cp_cont_d);
            this.gQx.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(z zVar) {
        super.a((e) zVar);
        if (zVar != null && !w.isEmpty(zVar.getDataList())) {
            if (StringUtils.isNull(zVar.mGroupTitle)) {
                this.gOL.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.gOL.setText(zVar.mGroupTitle);
            }
            if (cN(zVar.getDataList())) {
                this.ifh = zVar.getDataList();
                this.gQx.setData(this.ifh);
                this.gQx.notifyDataSetChanged();
            }
        }
    }

    private boolean cN(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (w.isEmpty(list)) {
            return false;
        }
        if (!w.isEmpty(this.ifh) && w.getCount(this.ifh) == w.getCount(list)) {
            for (int i = 0; i < w.getCount(this.ifh); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) w.getItem(this.ifh, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) w.getItem(list, i);
                if ((cVar instanceof az) && (cVar2 instanceof az) && !((az) cVar).metaData.getUserId().equals(((az) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

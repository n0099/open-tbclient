package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class cn extends bi<com.baidu.tieba.tbadkCore.ag> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public cn(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        co coVar = new co(null);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_official_account_item, null);
        coVar.aFv = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_fortune_bag_content);
        coVar.aFu = inflate.findViewById(com.baidu.tieba.w.frs_fortune_bag_item);
        coVar.aFw = inflate.findViewById(com.baidu.tieba.w.frs_my_service_item);
        coVar.aFx = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_my_service_content);
        inflate.setTag(coVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bi, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.ag agVar) {
        super.b(i, view, viewGroup, agVar);
        co coVar = (co) view.getTag();
        if (agVar.aeC()) {
            String aeD = agVar.aeD();
            if (aeD != null) {
                coVar.aFv.setText(aeD);
            } else if (this.aDH.aej() != null && this.aDH.aej().getName() != null) {
                coVar.aFv.setText(this.mContext.getString(com.baidu.tieba.z.get_fortune_hint_format, this.aDH.aej().getName()));
            }
            coVar.aFu.setTag(Integer.valueOf(i));
            coVar.aFu.setOnClickListener(this);
            coVar.aFu.setVisibility(0);
        } else {
            coVar.aFu.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.u aeE = agVar.aeE();
        if (aeE != null && aeE.aey() && !TextUtils.isEmpty(aeE.aez())) {
            coVar.aFx.setText(aeE.aez());
            coVar.aFw.setTag(Integer.valueOf(i));
            coVar.aFw.setOnClickListener(this);
            coVar.aFw.setVisibility(0);
        } else {
            coVar.aFw.setVisibility(8);
        }
        this.aDc.getLayoutMode().ab(this.mSkinType == 1);
        this.aDc.getLayoutMode().h(view);
        return view;
    }

    public int FW() {
        return com.baidu.tieba.w.frs_fortune_bag_item;
    }

    public int FX() {
        return com.baidu.tieba.w.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aDI != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            this.aDI.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) ay(intValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof co);
    }
}

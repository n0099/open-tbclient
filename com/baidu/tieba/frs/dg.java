package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dg extends bp<com.baidu.tieba.tbadkCore.aa, df> implements View.OnClickListener {
    private boolean bhJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public dg(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bhJ = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public df a(ViewGroup viewGroup) {
        return new df(LayoutInflater.from(this.mContext).inflate(n.h.frs_official_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.aa aaVar, df dfVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (com.baidu.tieba.tbadkCore.aa) dfVar);
        if (aaVar.aEz()) {
            String aEA = aaVar.aEA();
            if (aEA != null) {
                dfVar.bhG.setText(aEA);
            } else if (this.bdo.akG() != null && this.bdo.akG().getName() != null) {
                dfVar.bhG.setText(this.mContext.getString(n.j.get_fortune_hint_format, this.bdo.akG().getName()));
            }
            dfVar.bhF.setTag(Integer.valueOf(i));
            dfVar.bhF.setOnClickListener(this);
            dfVar.bhF.setVisibility(0);
        } else {
            dfVar.bhF.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q aEB = aaVar.aEB();
        if (aEB != null && aEB.aEv() && !TextUtils.isEmpty(aEB.aEw())) {
            dfVar.bhI.setText(aEB.aEw());
            dfVar.bhH.setTag(Integer.valueOf(i));
            dfVar.bhH.setOnClickListener(this);
            dfVar.bhH.setVisibility(0);
        } else {
            dfVar.bhH.setVisibility(8);
        }
        this.bbA.getLayoutMode().ac(this.mSkinType == 1);
        this.bbA.getLayoutMode().k(view);
        if (!this.bhJ && !aaVar.aEz()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int NA() {
        return n.g.frs_fortune_bag_item;
    }

    public int NC() {
        return n.g.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfE != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.bcq.getChildAt(intValue - (this.bcq.getFirstVisiblePosition() - this.bcq.getHeaderViewsCount()));
            this.bfE.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.z) au(intValue));
        }
    }
}

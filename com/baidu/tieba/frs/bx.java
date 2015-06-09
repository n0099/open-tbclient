package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class bx extends av<com.baidu.tieba.tbadkCore.aj, bw> implements View.OnClickListener {
    private boolean aOI;

    /* JADX INFO: Access modifiers changed from: protected */
    public bx(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aOI = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public bw a(ViewGroup viewGroup) {
        return new bw(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_official_account_item, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.aj ajVar, bw bwVar) {
        super.a(i, view, viewGroup, (ViewGroup) ajVar, (com.baidu.tieba.tbadkCore.aj) bwVar);
        if (ajVar.amR()) {
            String amS = ajVar.amS();
            if (amS != null) {
                bwVar.aOF.setText(amS);
            } else if (this.aLm.aas() != null && this.aLm.aas().getName() != null) {
                bwVar.aOF.setText(this.mContext.getString(com.baidu.tieba.t.get_fortune_hint_format, this.aLm.aas().getName()));
            }
            bwVar.aOE.setTag(Integer.valueOf(i));
            bwVar.aOE.setOnClickListener(this);
            bwVar.aOE.setVisibility(0);
        } else {
            bwVar.aOE.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.x amT = ajVar.amT();
        if (amT != null && amT.amN() && !TextUtils.isEmpty(amT.amO())) {
            bwVar.aOH.setText(amT.amO());
            bwVar.aOG.setTag(Integer.valueOf(i));
            bwVar.aOG.setOnClickListener(this);
            bwVar.aOG.setVisibility(0);
        } else {
            bwVar.aOG.setVisibility(8);
        }
        this.aMl.getLayoutMode().ab(this.mSkinType == 1);
        this.aMl.getLayoutMode().j(view);
        if (!this.aOI && !ajVar.amR()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int KV() {
        return com.baidu.tieba.q.frs_fortune_bag_item;
    }

    public int KX() {
        return com.baidu.tieba.q.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aMU != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            this.aMU.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) ay(intValue));
        }
    }
}

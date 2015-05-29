package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class bx extends av<com.baidu.tieba.tbadkCore.aj, bw> implements View.OnClickListener {
    private boolean aOH;

    /* JADX INFO: Access modifiers changed from: protected */
    public bx(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aOH = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
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
        if (ajVar.amQ()) {
            String amR = ajVar.amR();
            if (amR != null) {
                bwVar.aOE.setText(amR);
            } else if (this.aLl.aar() != null && this.aLl.aar().getName() != null) {
                bwVar.aOE.setText(this.mContext.getString(com.baidu.tieba.t.get_fortune_hint_format, this.aLl.aar().getName()));
            }
            bwVar.aOD.setTag(Integer.valueOf(i));
            bwVar.aOD.setOnClickListener(this);
            bwVar.aOD.setVisibility(0);
        } else {
            bwVar.aOD.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.x amS = ajVar.amS();
        if (amS != null && amS.amM() && !TextUtils.isEmpty(amS.amN())) {
            bwVar.aOG.setText(amS.amN());
            bwVar.aOF.setTag(Integer.valueOf(i));
            bwVar.aOF.setOnClickListener(this);
            bwVar.aOF.setVisibility(0);
        } else {
            bwVar.aOF.setVisibility(8);
        }
        this.aMk.getLayoutMode().ab(this.mSkinType == 1);
        this.aMk.getLayoutMode().j(view);
        if (!this.aOH && !ajVar.amQ()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int KU() {
        return com.baidu.tieba.q.frs_fortune_bag_item;
    }

    public int KW() {
        return com.baidu.tieba.q.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aMT != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            this.aMT.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) ay(intValue));
        }
    }
}

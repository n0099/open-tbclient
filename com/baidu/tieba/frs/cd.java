package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cd extends bd<com.baidu.tieba.tbadkCore.z, cc> implements View.OnClickListener {
    private boolean aXX;

    /* JADX INFO: Access modifiers changed from: protected */
    public cd(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXX = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: j */
    public cc a(ViewGroup viewGroup) {
        return new cc(LayoutInflater.from(this.mContext).inflate(i.g.frs_official_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.z zVar, cc ccVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tieba.tbadkCore.z) ccVar);
        if (zVar.atE()) {
            String atF = zVar.atF();
            if (atF != null) {
                ccVar.aXU.setText(atF);
            } else if (this.aUN.acP() != null && this.aUN.acP().getName() != null) {
                ccVar.aXU.setText(this.mContext.getString(i.h.get_fortune_hint_format, this.aUN.acP().getName()));
            }
            ccVar.aXT.setTag(Integer.valueOf(i));
            ccVar.aXT.setOnClickListener(this);
            ccVar.aXT.setVisibility(0);
        } else {
            ccVar.aXT.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p atG = zVar.atG();
        if (atG != null && atG.atA() && !TextUtils.isEmpty(atG.atB())) {
            ccVar.aXW.setText(atG.atB());
            ccVar.aXV.setTag(Integer.valueOf(i));
            ccVar.aXV.setOnClickListener(this);
            ccVar.aXV.setVisibility(0);
        } else {
            ccVar.aXV.setVisibility(8);
        }
        this.aSX.getLayoutMode().ad(this.mSkinType == 1);
        this.aSX.getLayoutMode().k(view);
        if (!this.aXX && !zVar.atE()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int Lz() {
        return i.f.frs_fortune_bag_item;
    }

    public int LB() {
        return i.f.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWB != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.aTO.getChildAt(intValue - (this.aTO.getFirstVisiblePosition() - this.aTO.getHeaderViewsCount()));
            this.aWB.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.x) aA(intValue));
        }
    }
}

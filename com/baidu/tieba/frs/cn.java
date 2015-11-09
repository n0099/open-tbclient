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
public class cn extends bn<com.baidu.tieba.tbadkCore.z, cm> implements View.OnClickListener {
    private boolean aXL;

    /* JADX INFO: Access modifiers changed from: protected */
    public cn(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXL = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public cm a(ViewGroup viewGroup) {
        return new cm(LayoutInflater.from(this.mContext).inflate(i.g.frs_official_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.z zVar, cm cmVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tieba.tbadkCore.z) cmVar);
        if (zVar.awG()) {
            String awH = zVar.awH();
            if (awH != null) {
                cmVar.aXI.setText(awH);
            } else if (this.aUe.afg() != null && this.aUe.afg().getName() != null) {
                cmVar.aXI.setText(this.mContext.getString(i.h.get_fortune_hint_format, this.aUe.afg().getName()));
            }
            cmVar.aXH.setTag(Integer.valueOf(i));
            cmVar.aXH.setOnClickListener(this);
            cmVar.aXH.setVisibility(0);
        } else {
            cmVar.aXH.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p awI = zVar.awI();
        if (awI != null && awI.awC() && !TextUtils.isEmpty(awI.awD())) {
            cmVar.aXK.setText(awI.awD());
            cmVar.aXJ.setTag(Integer.valueOf(i));
            cmVar.aXJ.setOnClickListener(this);
            cmVar.aXJ.setVisibility(0);
        } else {
            cmVar.aXJ.setVisibility(8);
        }
        this.aSm.getLayoutMode().ad(this.mSkinType == 1);
        this.aSm.getLayoutMode().k(view);
        if (!this.aXL && !zVar.awG()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int LJ() {
        return i.f.frs_fortune_bag_item;
    }

    public int LL() {
        return i.f.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWo != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.aTd.getChildAt(intValue - (this.aTd.getFirstVisiblePosition() - this.aTd.getHeaderViewsCount()));
            this.aWo.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) aA(intValue));
        }
    }
}

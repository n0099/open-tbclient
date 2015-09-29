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
    private boolean aXr;

    /* JADX INFO: Access modifiers changed from: protected */
    public cn(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXr = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
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
        if (zVar.avU()) {
            String avV = zVar.avV();
            if (avV != null) {
                cmVar.aXo.setText(avV);
            } else if (this.aTL.aeN() != null && this.aTL.aeN().getName() != null) {
                cmVar.aXo.setText(this.mContext.getString(i.h.get_fortune_hint_format, this.aTL.aeN().getName()));
            }
            cmVar.aXn.setTag(Integer.valueOf(i));
            cmVar.aXn.setOnClickListener(this);
            cmVar.aXn.setVisibility(0);
        } else {
            cmVar.aXn.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p avW = zVar.avW();
        if (avW != null && avW.avQ() && !TextUtils.isEmpty(avW.avR())) {
            cmVar.aXq.setText(avW.avR());
            cmVar.aXp.setTag(Integer.valueOf(i));
            cmVar.aXp.setOnClickListener(this);
            cmVar.aXp.setVisibility(0);
        } else {
            cmVar.aXp.setVisibility(8);
        }
        this.aRT.getLayoutMode().ad(this.mSkinType == 1);
        this.aRT.getLayoutMode().k(view);
        if (!this.aXr && !zVar.avU()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int Lx() {
        return i.f.frs_fortune_bag_item;
    }

    public int Lz() {
        return i.f.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVV != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.aSK.getChildAt(intValue - (this.aSK.getFirstVisiblePosition() - this.aSK.getHeaderViewsCount()));
            this.aVV.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.v) aA(intValue));
        }
    }
}

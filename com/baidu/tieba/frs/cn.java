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
    private boolean aXC;

    /* JADX INFO: Access modifiers changed from: protected */
    public cn(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXC = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
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
        if (zVar.awc()) {
            String awd = zVar.awd();
            if (awd != null) {
                cmVar.aXz.setText(awd);
            } else if (this.aTW.aeN() != null && this.aTW.aeN().getName() != null) {
                cmVar.aXz.setText(this.mContext.getString(i.h.get_fortune_hint_format, this.aTW.aeN().getName()));
            }
            cmVar.aXy.setTag(Integer.valueOf(i));
            cmVar.aXy.setOnClickListener(this);
            cmVar.aXy.setVisibility(0);
        } else {
            cmVar.aXy.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p awe = zVar.awe();
        if (awe != null && awe.avY() && !TextUtils.isEmpty(awe.avZ())) {
            cmVar.aXB.setText(awe.avZ());
            cmVar.aXA.setTag(Integer.valueOf(i));
            cmVar.aXA.setOnClickListener(this);
            cmVar.aXA.setVisibility(0);
        } else {
            cmVar.aXA.setVisibility(8);
        }
        this.aSe.getLayoutMode().ad(this.mSkinType == 1);
        this.aSe.getLayoutMode().k(view);
        if (!this.aXC && !zVar.awc()) {
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
        if (this.aWg != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.aSV.getChildAt(intValue - (this.aSV.getFirstVisiblePosition() - this.aSV.getHeaderViewsCount()));
            this.aWg.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) aA(intValue));
        }
    }
}

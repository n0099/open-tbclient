package com.baidu.tieba.frs.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.m;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bn;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends bn<com.baidu.tbadk.core.data.b, b> {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public b a(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(i.g.frs_locality_bar_big_image, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, b bVar2) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) bVar2);
        bVar2.baM.setPadding(0, i - this.aTQ == 0 ? this.aSR : this.aSS, 0, 0);
        this.aSe.getLayoutMode().ad(this.mSkinType == 1);
        this.aSe.getLayoutMode().k(view);
        if (!bVar.Uk && (this.aSe instanceof FrsActivity)) {
            bVar.Uk = true;
            ((FrsActivity) this.aSe).a(bVar, "show");
            ((FrsActivity) this.aSe).b(bVar, "show");
        }
        if (m.qX().qZ()) {
            bVar2.aHW.setVisibility(0);
            bVar2.aHW.d(bVar.Uj.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar2.aHW.setVisibility(8);
        }
        if (m.qX().rb() && !TextUtils.isEmpty(bVar.Uj.Uo)) {
            bVar2.baO.setVisibility(0);
            bVar2.baO.d(bVar.Uj.Uo, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar2.baO.setVisibility(8);
        }
        bVar2.aDl.setText(bVar.Uj.userName);
        if (StringUtils.isNull(bVar.Uj.Um)) {
            bVar2.alu.setVisibility(8);
        } else {
            bVar2.alu.setVisibility(0);
            bVar2.alu.setText(bVar.Uj.Um);
        }
        return view;
    }
}

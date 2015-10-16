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
public class e extends bn<com.baidu.tbadk.core.data.b, f> {
    public e(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public f a(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(i.g.frs_locality_bar_single_replenish, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) fVar);
        fVar.baM.setPadding(0, i - this.aTQ == 0 ? this.aSR : this.aSS, 0, 0);
        this.aSe.getLayoutMode().ad(this.mSkinType == 1);
        this.aSe.getLayoutMode().k(view);
        if (!bVar.Uk && (this.aSe instanceof FrsActivity)) {
            bVar.Uk = true;
            ((FrsActivity) this.aSe).a(bVar, "show");
            ((FrsActivity) this.aSe).b(bVar, "show");
        }
        if (m.qX().qZ()) {
            fVar.aHW.setVisibility(0);
            fVar.aHW.d(bVar.Uj.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aHW.setVisibility(8);
        }
        if (m.qX().rb() && !TextUtils.isEmpty(bVar.Uj.Uo)) {
            fVar.baO.setVisibility(0);
            fVar.baO.d(bVar.Uj.Uo, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.baO.setVisibility(8);
        }
        fVar.aDl.setText(bVar.Uj.userName);
        if (StringUtils.isNull(bVar.Uj.Um)) {
            fVar.alu.setVisibility(8);
        } else {
            fVar.alu.setVisibility(0);
            fVar.alu.setText(bVar.Uj.Um);
        }
        if (StringUtils.isNull(bVar.Uj.Ur)) {
            fVar.baP.setVisibility(8);
        } else {
            fVar.baP.setVisibility(0);
            fVar.baP.setText(bVar.Uj.Ur);
        }
        if (StringUtils.isNull(bVar.Uj.Us)) {
            fVar.baQ.setVisibility(8);
        } else {
            fVar.baQ.setVisibility(0);
            fVar.baQ.setText(bVar.Uj.Us);
        }
        return view;
    }
}

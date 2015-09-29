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
        fVar.baB.setPadding(0, i - this.aTF == 0 ? this.aSG : this.aSH, 0, 0);
        this.aRT.getLayoutMode().ad(this.mSkinType == 1);
        this.aRT.getLayoutMode().k(view);
        if (!bVar.Uj && (this.aRT instanceof FrsActivity)) {
            bVar.Uj = true;
            ((FrsActivity) this.aRT).a(bVar, "show");
            ((FrsActivity) this.aRT).b(bVar, "show");
        }
        if (m.qX().qZ()) {
            fVar.aHL.setVisibility(0);
            fVar.aHL.d(bVar.Ui.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aHL.setVisibility(8);
        }
        if (m.qX().rb() && !TextUtils.isEmpty(bVar.Ui.Un)) {
            fVar.baD.setVisibility(0);
            fVar.baD.d(bVar.Ui.Un, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.baD.setVisibility(8);
        }
        fVar.aDa.setText(bVar.Ui.userName);
        if (StringUtils.isNull(bVar.Ui.Ul)) {
            fVar.alt.setVisibility(8);
        } else {
            fVar.alt.setVisibility(0);
            fVar.alt.setText(bVar.Ui.Ul);
        }
        if (StringUtils.isNull(bVar.Ui.Uq)) {
            fVar.baE.setVisibility(8);
        } else {
            fVar.baE.setVisibility(0);
            fVar.baE.setText(bVar.Ui.Uq);
        }
        if (StringUtils.isNull(bVar.Ui.Ur)) {
            fVar.baF.setVisibility(8);
        } else {
            fVar.baF.setVisibility(0);
            fVar.baF.setText(bVar.Ui.Ur);
        }
        return view;
    }
}

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
        bVar2.baB.setPadding(0, i - this.aTF == 0 ? this.aSG : this.aSH, 0, 0);
        this.aRT.getLayoutMode().ad(this.mSkinType == 1);
        this.aRT.getLayoutMode().k(view);
        if (!bVar.Uj && (this.aRT instanceof FrsActivity)) {
            bVar.Uj = true;
            ((FrsActivity) this.aRT).a(bVar, "show");
            ((FrsActivity) this.aRT).b(bVar, "show");
        }
        if (m.qX().qZ()) {
            bVar2.aHL.setVisibility(0);
            bVar2.aHL.d(bVar.Ui.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar2.aHL.setVisibility(8);
        }
        if (m.qX().rb() && !TextUtils.isEmpty(bVar.Ui.Un)) {
            bVar2.baD.setVisibility(0);
            bVar2.baD.d(bVar.Ui.Un, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar2.baD.setVisibility(8);
        }
        bVar2.aDa.setText(bVar.Ui.userName);
        if (StringUtils.isNull(bVar.Ui.Ul)) {
            bVar2.alt.setVisibility(8);
        } else {
            bVar2.alt.setVisibility(0);
            bVar2.alt.setText(bVar.Ui.Ul);
        }
        return view;
    }
}

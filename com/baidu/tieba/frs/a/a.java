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
        bVar2.bbf.setPadding(0, i - this.aTY == 0 ? this.aSZ : this.aTa, 0, 0);
        this.aSm.getLayoutMode().ad(this.mSkinType == 1);
        this.aSm.getLayoutMode().k(view);
        if (!bVar.Ul && (this.aSm instanceof FrsActivity)) {
            bVar.Ul = true;
            ((FrsActivity) this.aSm).a(bVar, "show");
            ((FrsActivity) this.aSm).b(bVar, "show");
        }
        if (m.qV().qX()) {
            bVar2.aGQ.setVisibility(0);
            bVar2.aGQ.d(bVar.Uk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar2.aGQ.setVisibility(8);
        }
        if (m.qV().qZ() && !TextUtils.isEmpty(bVar.Uk.Up)) {
            bVar2.bbh.setVisibility(0);
            bVar2.bbh.d(bVar.Uk.Up, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar2.bbh.setVisibility(8);
        }
        bVar2.aCf.setText(bVar.Uk.userName);
        if (StringUtils.isNull(bVar.Uk.Un)) {
            bVar2.alz.setVisibility(8);
        } else {
            bVar2.alz.setVisibility(0);
            bVar2.alz.setText(bVar.Uk.Un);
        }
        return view;
    }
}

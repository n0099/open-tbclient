package com.baidu.tieba.frs.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends bm<com.baidu.tbadk.core.data.b, b> {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: C */
    public b a(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(n.g.frs_locality_bar_big_image, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, b bVar2) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) bVar2);
        bVar2.bhH.setPadding(0, i - this.aZm == 0 ? this.aYn : this.aYo, 0, 0);
        this.aXA.getLayoutMode().af(this.mSkinType == 1);
        this.aXA.getLayoutMode().k(view);
        if (!bVar.UB && (this.aXA instanceof FrsActivity)) {
            bVar.UB = true;
            ((FrsActivity) this.aXA).a(bVar, "show");
            ((FrsActivity) this.aXA).b(bVar, "show");
        }
        if (m.rh().rj()) {
            bVar2.aJP.setVisibility(0);
            bVar2.aJP.d(bVar.UA.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar2.aJP.setVisibility(8);
        }
        if (m.rh().rn() && !TextUtils.isEmpty(bVar.UA.UF)) {
            bVar2.bhJ.setVisibility(0);
            bVar2.bhJ.d(bVar.UA.UF, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar2.bhJ.setVisibility(8);
        }
        bVar2.aER.setText(bVar.UA.userName);
        bVar2.bhI.setText(ax.s(bVar.Uz));
        if (StringUtils.isNull(bVar.UA.UD)) {
            bVar2.agd.setVisibility(8);
        } else {
            bVar2.agd.setVisibility(0);
            bVar2.agd.setText(bVar.UA.UD);
        }
        return view;
    }
}

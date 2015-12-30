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
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends bp<com.baidu.tbadk.core.data.b, b> {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: H */
    public b a(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(n.h.frs_locality_bar_big_image, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, b bVar2) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) bVar2);
        bVar2.bly.setPadding(0, i - this.bdi == 0 ? this.bcm : this.bcn, 0, 0);
        this.bbA.getLayoutMode().ac(this.mSkinType == 1);
        this.bbA.getLayoutMode().k(view);
        if (!bVar.Vc && (this.bbA instanceof FrsActivity)) {
            bVar.Vc = true;
            ((FrsActivity) this.bbA).a(bVar, "show");
            ((FrsActivity) this.bbA).b(bVar, "show");
        }
        if (m.qQ().qS()) {
            bVar2.aLn.setVisibility(0);
            bVar2.aLn.d(bVar.Vb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar2.aLn.setVisibility(8);
        }
        if (m.qQ().qW() && !TextUtils.isEmpty(bVar.Vb.Vg)) {
            bVar2.blA.setVisibility(0);
            bVar2.blA.d(bVar.Vb.Vg, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar2.blA.setVisibility(8);
        }
        bVar2.aGr.setText(bVar.Vb.userName);
        bVar2.blz.setText(ax.s(bVar.Va));
        if (StringUtils.isNull(bVar.Vb.Ve)) {
            bVar2.ahk.setVisibility(8);
        } else {
            bVar2.ahk.setVisibility(0);
            bVar2.ahk.setText(bVar.Vb.Ve);
        }
        return view;
    }
}

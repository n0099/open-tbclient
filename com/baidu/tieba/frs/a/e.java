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
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends bp<com.baidu.tbadk.core.data.b, f> {
    public e(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: J */
    public f a(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(n.h.frs_locality_bar_single_replenish, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) fVar);
        fVar.bly.setPadding(0, i - this.bdi == 0 ? this.bcm : this.bcn, 0, 0);
        this.bbA.getLayoutMode().ac(this.mSkinType == 1);
        this.bbA.getLayoutMode().k(view);
        if (!bVar.Vc && (this.bbA instanceof FrsActivity)) {
            bVar.Vc = true;
            ((FrsActivity) this.bbA).a(bVar, "show");
            ((FrsActivity) this.bbA).b(bVar, "show");
        }
        if (m.qQ().qS()) {
            fVar.aLn.setVisibility(0);
            fVar.aLn.d(bVar.Vb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aLn.setVisibility(8);
        }
        if (m.qQ().qW() && !TextUtils.isEmpty(bVar.Vb.Vg)) {
            fVar.blA.setVisibility(0);
            fVar.blA.d(bVar.Vb.Vg, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.blA.setVisibility(8);
        }
        fVar.aGr.setText(bVar.Vb.userName);
        if (StringUtils.isNull(bVar.Vb.Ve)) {
            fVar.ahk.setVisibility(8);
        } else {
            fVar.ahk.setVisibility(0);
            fVar.ahk.setText(bVar.Vb.Ve);
        }
        if (StringUtils.isNull(bVar.Vb.Vj)) {
            fVar.blC.setVisibility(8);
        } else {
            fVar.blC.setVisibility(0);
            fVar.blC.setText(bVar.Vb.Vj);
        }
        if (StringUtils.isNull(bVar.Vb.Vk)) {
            fVar.blD.setVisibility(8);
        } else {
            fVar.blD.setVisibility(0);
            fVar.blD.setText(bVar.Vb.Vk);
        }
        return view;
    }
}

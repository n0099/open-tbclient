package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends bx<com.baidu.tbadk.core.data.c, b> {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(t.h.frs_locality_bar_big_image, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bVar);
        bVar.btm.setPadding(0, i - this.bkj == 0 ? this.bjn : this.bjo, 0, 0);
        this.bix.getLayoutMode().ab(this.mSkinType == 1);
        this.bix.getLayoutMode().x(view);
        if (!cVar.So && (this.bix instanceof FrsActivity)) {
            cVar.So = true;
            ((FrsActivity) this.bix).a(cVar, "show");
            ((FrsActivity) this.bix).b(cVar, "show");
        }
        if (l.qE().qG()) {
            bVar.aPn.setVisibility(0);
            bVar.aPn.c(cVar.Sn.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar.aPn.setVisibility(8);
        }
        if (l.qE().qK() && !TextUtils.isEmpty(cVar.Sn.Sw)) {
            bVar.bto.setVisibility(0);
            bVar.bto.c(cVar.Sn.Sw, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar.bto.setVisibility(8);
        }
        bVar.aKg.setText(cVar.Sn.userName);
        bVar.btn.setText(ay.w(cVar.Sm));
        if (StringUtils.isNull(cVar.Sn.Su)) {
            bVar.apE.setVisibility(8);
        } else {
            bVar.apE.setVisibility(0);
            bVar.apE.setText(cVar.Sn.Su);
        }
        return view;
    }
}

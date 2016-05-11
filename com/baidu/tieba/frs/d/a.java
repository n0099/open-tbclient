package com.baidu.tieba.frs.d;

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
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends bw<com.baidu.tbadk.core.data.c, b> {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(t.h.frs_locality_bar_big_image, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bVar);
        bVar.bsc.setPadding(0, i - this.bgj == 0 ? this.bfn : this.bfo, 0, 0);
        this.bek.getLayoutMode().ae(this.mSkinType == 1);
        this.bek.getLayoutMode().x(view);
        if (!cVar.Nc && (this.bek instanceof FrsActivity)) {
            cVar.Nc = true;
            ((FrsActivity) this.bek).a(cVar, "show");
            ((FrsActivity) this.bek).b(cVar, "show");
        }
        if (l.ob().od()) {
            bVar.aLx.setVisibility(0);
            bVar.aLx.c(cVar.Nb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar.aLx.setVisibility(8);
        }
        if (l.ob().oh() && !TextUtils.isEmpty(cVar.Nb.Nk)) {
            bVar.bse.setVisibility(0);
            bVar.bse.c(cVar.Nb.Nk, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar.bse.setVisibility(8);
        }
        bVar.aGp.setText(cVar.Nb.userName);
        bVar.bsd.setText(ay.x(cVar.Na));
        if (StringUtils.isNull(cVar.Nb.Ni)) {
            bVar.title.setVisibility(8);
        } else {
            bVar.title.setVisibility(0);
            bVar.title.setText(cVar.Nb.Ni);
        }
        return view;
    }
}

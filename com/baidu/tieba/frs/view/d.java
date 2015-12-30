package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bop = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bop.bnZ)) {
            com.baidu.tbadk.browser.f.a(this.bop.mContext.getPageActivity(), this.bop.mContext.getString(n.j.frs_badge_intro), this.bop.bnZ, true, false, false);
        }
    }
}

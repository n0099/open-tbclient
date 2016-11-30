package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c cme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.cme = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.cme.clG)) {
            com.baidu.tbadk.browser.f.a(this.cme.Gf.getPageActivity(), this.cme.Gf.getString(r.j.frs_badge_intro), this.cme.clG, true, false, false);
        }
    }
}

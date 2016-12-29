package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c bRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.bRo = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bRo.bQR)) {
            com.baidu.tbadk.browser.f.a(this.bRo.Gf.getPageActivity(), this.bRo.Gf.getString(r.j.frs_badge_intro), this.bRo.bQR, true, false, false);
        }
    }
}

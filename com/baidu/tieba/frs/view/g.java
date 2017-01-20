package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c bXS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.bXS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bXS.bXv)) {
            com.baidu.tbadk.browser.f.a(this.bXS.Fp.getPageActivity(), this.bXS.Fp.getString(r.l.frs_badge_intro), this.bXS.bXv, true, false, false);
        }
    }
}

package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c cfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.cfo = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.cfo.ceT)) {
            com.baidu.tbadk.browser.f.a(this.cfo.aaI.getPageActivity(), this.cfo.aaI.getString(w.l.frs_badge_intro), this.cfo.ceT, true, false, false);
        }
    }
}

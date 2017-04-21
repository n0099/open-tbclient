package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.cgf = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.cgf.cfK)) {
            com.baidu.tbadk.browser.f.a(this.cgf.aaY.getPageActivity(), this.cgf.aaY.getString(w.l.frs_badge_intro), this.cgf.cfK, true, false, false);
        }
    }
}

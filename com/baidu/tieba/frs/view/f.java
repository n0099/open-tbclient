package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c cgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.cgX = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.cgX.cgB)) {
            com.baidu.tbadk.browser.f.a(this.cgX.Gd.getPageActivity(), this.cgX.Gd.getString(r.j.frs_badge_intro), this.cgX.cgB, true, false, false);
        }
    }
}

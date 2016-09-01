package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c cgZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.cgZ = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.cgZ.cgD)) {
            com.baidu.tbadk.browser.f.a(this.cgZ.Gd.getPageActivity(), this.cgZ.Gd.getString(t.j.frs_badge_intro), this.cgZ.cgD, true, false, false);
        }
    }
}

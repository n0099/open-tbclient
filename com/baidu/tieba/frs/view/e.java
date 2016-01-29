package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ b brj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.brj = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.brj.bqT)) {
            com.baidu.tbadk.browser.f.a(this.brj.MR.getPageActivity(), this.brj.MR.getString(t.j.frs_badge_intro), this.brj.bqT, true, false, false);
        }
    }
}

package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ b bwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bwr = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bwr.bvW)) {
            com.baidu.tbadk.browser.f.a(this.bwr.MX.getPageActivity(), this.bwr.MX.getString(t.j.frs_badge_intro), this.bwr.bvW, true, false, false);
        }
    }
}

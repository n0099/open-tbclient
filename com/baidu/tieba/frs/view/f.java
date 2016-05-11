package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bwe = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bwe.bvJ)) {
            com.baidu.tbadk.browser.f.a(this.bwe.Do.getPageActivity(), this.bwe.Do.getString(t.j.frs_badge_intro), this.bwe.bvJ, true, false, false);
        }
    }
}

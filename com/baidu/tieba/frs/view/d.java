package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a aRp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aRp = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.aRp.aQV)) {
            com.baidu.tbadk.browser.f.a(this.aRp.LH.getPageActivity(), this.aRp.LH.getString(com.baidu.tieba.t.frs_badge_intro), this.aRp.aQV, true, false, false);
        }
    }
}

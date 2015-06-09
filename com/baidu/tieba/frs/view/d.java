package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a aRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aRq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.aRq.aQW)) {
            com.baidu.tbadk.browser.f.a(this.aRq.LH.getPageActivity(), this.aRq.LH.getString(com.baidu.tieba.t.frs_badge_intro), this.aRq.aQW, true, false, false);
        }
    }
}

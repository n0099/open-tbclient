package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a aPe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aPe = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.aPe.aOK)) {
            com.baidu.tbadk.browser.f.a(this.aPe.LP.getPageActivity(), this.aPe.LP.getString(y.frs_badge_intro), this.aPe.aOK, true, false, false);
        }
    }
}

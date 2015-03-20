package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a aON;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aON = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.aON.aOt)) {
            com.baidu.tbadk.browser.f.a(this.aON.LN.getPageActivity(), this.aON.LN.getString(y.frs_badge_intro), this.aON.aOt, true, false, false);
        }
    }
}

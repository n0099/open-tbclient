package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bTP = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bTP.bTu)) {
            com.baidu.tbadk.browser.f.a(this.bTP.Dp.getPageActivity(), this.bTP.Dp.getString(u.j.frs_badge_intro), this.bTP.bTu, true, false, false);
        }
    }
}

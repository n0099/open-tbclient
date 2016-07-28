package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bVP = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bVP.bVu)) {
            com.baidu.tbadk.browser.f.a(this.bVP.DQ.getPageActivity(), this.bVP.DQ.getString(u.j.frs_badge_intro), this.bVP.bVu, true, false, false);
        }
    }
}

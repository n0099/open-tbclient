package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ c cdO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.cdO = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.cdO.cdt)) {
            com.baidu.tbadk.browser.f.a(this.cdO.aaX.getPageActivity(), this.cdO.aaX.getString(w.l.frs_badge_intro), this.cdO.cdt, true, false, false);
        }
    }
}

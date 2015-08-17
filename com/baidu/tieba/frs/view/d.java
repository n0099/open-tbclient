package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bcO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bcO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bcO.bcy)) {
            com.baidu.tbadk.browser.f.a(this.bcO.LS.getPageActivity(), this.bcO.LS.getString(i.C0057i.frs_badge_intro), this.bcO.bcy, true, false, false);
        }
    }
}

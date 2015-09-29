package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bdc = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bdc.bcM)) {
            com.baidu.tbadk.browser.g.a(this.bdc.mContext.getPageActivity(), this.bdc.mContext.getString(i.h.frs_badge_intro), this.bdc.bcM, true, false, false);
        }
    }
}

package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bdi = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bdi.bcS)) {
            com.baidu.tbadk.browser.g.a(this.bdi.mContext.getPageActivity(), this.bdi.mContext.getString(i.h.frs_badge_intro), this.bdi.bcS, true, false, false);
        }
    }
}

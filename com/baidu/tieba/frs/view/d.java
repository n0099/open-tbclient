package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bdn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bdn = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bdn.bcX)) {
            com.baidu.tbadk.browser.g.a(this.bdn.mContext.getPageActivity(), this.bdn.mContext.getString(i.h.frs_badge_intro), this.bdn.bcX, true, false, false);
        }
    }
}

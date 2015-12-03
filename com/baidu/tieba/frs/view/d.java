package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bky = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bky.bki)) {
            com.baidu.tbadk.browser.f.a(this.bky.mContext.getPageActivity(), this.bky.mContext.getString(n.i.frs_badge_intro), this.bky.bki, true, false, false);
        }
    }
}

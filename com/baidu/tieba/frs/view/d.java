package com.baidu.tieba.frs.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bdS = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.bdS.bdC)) {
            com.baidu.tbadk.browser.g.a(this.bdS.mContext.getPageActivity(), this.bdS.mContext.getString(i.h.frs_badge_intro), this.bdS.bdC, true, false, false);
        }
    }
}

package com.baidu.tieba.im.randchat;

import android.view.View;
import com.baidu.tieba.im.randchat.WaitingTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v implements View.OnClickListener {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a(WaitingTipView.Type.WAIT_TIP, new Object[]{60L});
    }
}

package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class aa extends Handler {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        FrameLayout frameLayout;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.a.f();
                return;
            case 2:
                frameLayout = this.a.i;
                frameLayout.setVisibility(8);
                return;
            case 3:
                z = this.a.l;
                if (!z) {
                    this.a.e();
                }
                this.a.l = true;
                return;
            default:
                return;
        }
    }
}

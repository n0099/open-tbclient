package com.baidu.tieba.im.live;

import android.telephony.PhoneStateListener;
/* loaded from: classes.dex */
class o extends PhoneStateListener {
    final /* synthetic */ d a;

    private o(d dVar) {
        this.a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(d dVar, o oVar) {
        this(dVar);
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        switch (i) {
            case 0:
                this.a.e();
                break;
            case 1:
            case 2:
                this.a.d();
                break;
        }
        super.onCallStateChanged(i, str);
    }
}

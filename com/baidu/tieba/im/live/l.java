package com.baidu.tieba.im.live;

import android.telephony.PhoneStateListener;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class l extends PhoneStateListener {
    final /* synthetic */ b a;

    private l(b bVar) {
        this.a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(b bVar, l lVar) {
        this(bVar);
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        BdLog.d("PhoneState: " + i);
        switch (i) {
            case 0:
                this.a.e();
                break;
            case 1:
                this.a.d();
                break;
        }
        super.onCallStateChanged(i, str);
    }
}

package com.baidu.tbadk.live;

import android.telephony.PhoneStateListener;
/* loaded from: classes.dex */
class o extends PhoneStateListener {
    final /* synthetic */ LiveGroupManager Vu;

    private o(LiveGroupManager liveGroupManager) {
        this.Vu = liveGroupManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(LiveGroupManager liveGroupManager, o oVar) {
        this(liveGroupManager);
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        switch (i) {
            case 0:
                this.Vu.onEndCall();
                break;
            case 1:
            case 2:
                this.Vu.onIncomingOrPlacingCall();
                break;
        }
        super.onCallStateChanged(i, str);
    }
}

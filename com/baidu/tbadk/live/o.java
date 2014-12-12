package com.baidu.tbadk.live;

import android.telephony.PhoneStateListener;
/* loaded from: classes.dex */
class o extends PhoneStateListener {
    final /* synthetic */ LiveGroupManager abA;

    private o(LiveGroupManager liveGroupManager) {
        this.abA = liveGroupManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(LiveGroupManager liveGroupManager, o oVar) {
        this(liveGroupManager);
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        switch (i) {
            case 0:
                this.abA.onEndCall();
                break;
            case 1:
            case 2:
                this.abA.onIncomingOrPlacingCall();
                break;
        }
        super.onCallStateChanged(i, str);
    }
}

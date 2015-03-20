package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class j {
    private m agb;
    private l agc;
    private k agd;

    public j(String str, l lVar) {
        this.agb = null;
        this.agc = null;
        this.agd = null;
        this.agb = new m(this);
        this.agc = lVar;
        this.agb.sendEmptyMessageDelayed(0, 50000L);
        this.agd = new k(this, null);
        this.agd.setSelfExecute(true);
        this.agd.execute(String.valueOf(xx()) + str);
    }

    private String xx() {
        switch (com.baidu.adp.lib.util.k.iM()) {
            case 1:
                return "ping -c 3 -w 3000 ";
            case 2:
                return "ping -c 3 -w 10000 ";
            case 3:
                return "ping -c 3 -w 5000 ";
            default:
                return "ping -c 3 -w 5000 ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy() {
        if (this.agd != null) {
            this.agd.cancel(true);
        }
        if (this.agb != null) {
            this.agb.removeMessages(0);
        }
    }
}

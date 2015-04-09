package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class j {
    private m agj;
    private l agk;
    private k agl;

    public j(String str, l lVar) {
        this.agj = null;
        this.agk = null;
        this.agl = null;
        this.agj = new m(this);
        this.agk = lVar;
        this.agj.sendEmptyMessageDelayed(0, 50000L);
        this.agl = new k(this, null);
        this.agl.setSelfExecute(true);
        this.agl.execute(String.valueOf(xD()) + str);
    }

    private String xD() {
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
    public void xE() {
        if (this.agl != null) {
            this.agl.cancel(true);
        }
        if (this.agj != null) {
            this.agj.removeMessages(0);
        }
    }
}

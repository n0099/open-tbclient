package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class j {
    private m VY;
    private l VZ;
    private k Wa;

    public j(String str, l lVar) {
        this.VY = null;
        this.VZ = null;
        this.Wa = null;
        this.VY = new m(this);
        this.VZ = lVar;
        this.VY.sendEmptyMessageDelayed(0, 50000L);
        this.Wa = new k(this, null);
        this.Wa.setSelfExecute(true);
        this.Wa.execute(String.valueOf(um()) + str);
    }

    private String um() {
        switch (com.baidu.adp.lib.util.i.fk()) {
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
    public void un() {
        if (this.Wa != null) {
            this.Wa.cancel(true);
        }
        if (this.VY != null) {
            this.VY.removeMessages(0);
        }
    }
}

package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class j {
    private m Vt;
    private l Vu;
    private k Vv;

    public j(String str, l lVar) {
        this.Vt = null;
        this.Vu = null;
        this.Vv = null;
        this.Vt = new m(this);
        this.Vu = lVar;
        this.Vt.sendEmptyMessageDelayed(0, 50000L);
        this.Vv = new k(this, null);
        this.Vv.setSelfExecute(true);
        this.Vv.execute(String.valueOf(tV()) + str);
    }

    private String tV() {
        switch (com.baidu.adp.lib.util.i.fl()) {
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
    public void tW() {
        if (this.Vv != null) {
            this.Vv.cancel(true);
        }
        if (this.Vt != null) {
            this.Vt.removeMessages(0);
        }
    }
}

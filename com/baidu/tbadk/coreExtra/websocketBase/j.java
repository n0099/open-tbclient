package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class j {
    private m ahk;
    private l ahl;
    private k ahm;

    public j(String str, l lVar) {
        this.ahk = null;
        this.ahl = null;
        this.ahm = null;
        this.ahk = new m(this);
        this.ahl = lVar;
        this.ahk.sendEmptyMessageDelayed(0, 50000L);
        this.ahm = new k(this, null);
        this.ahm.setSelfExecute(true);
        this.ahm.execute(String.valueOf(yr()) + str);
    }

    private String yr() {
        switch (com.baidu.adp.lib.util.k.jc()) {
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
    public void ys() {
        if (this.ahm != null) {
            this.ahm.cancel(true);
        }
        if (this.ahk != null) {
            this.ahk.removeMessages(0);
        }
    }
}

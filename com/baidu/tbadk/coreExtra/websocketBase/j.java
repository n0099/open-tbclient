package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class j {
    private m PI;
    private l PJ;
    private k PK;

    public j(String str, l lVar) {
        this.PI = null;
        this.PJ = null;
        this.PK = null;
        this.PI = new m(this);
        this.PJ = lVar;
        this.PI.sendEmptyMessageDelayed(0, 50000L);
        this.PK = new k(this, null);
        this.PK.setSelfExecute(true);
        this.PK.execute(String.valueOf(qC()) + str);
    }

    private String qC() {
        switch (com.baidu.adp.lib.util.j.fm()) {
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
    public void qD() {
        if (this.PK != null) {
            this.PK.cancel(true);
        }
        if (this.PI != null) {
            this.PI.removeMessages(0);
        }
    }
}

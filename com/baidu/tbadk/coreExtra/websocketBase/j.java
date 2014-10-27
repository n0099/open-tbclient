package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class j {
    private m PE;
    private l PF;
    private k PG;

    public j(String str, l lVar) {
        this.PE = null;
        this.PF = null;
        this.PG = null;
        this.PE = new m(this);
        this.PF = lVar;
        this.PE.sendEmptyMessageDelayed(0, 50000L);
        this.PG = new k(this, null);
        this.PG.setSelfExecute(true);
        this.PG.execute(String.valueOf(qA()) + str);
    }

    private String qA() {
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
    public void qB() {
        if (this.PG != null) {
            this.PG.cancel(true);
        }
        if (this.PE != null) {
            this.PE.removeMessages(0);
        }
    }
}

package com.baidu.tbadk.coreExtra.websocketBase;
/* loaded from: classes.dex */
public class j {
    private m VV;
    private l VW;
    private k VX;

    public j(String str, l lVar) {
        this.VV = null;
        this.VW = null;
        this.VX = null;
        this.VV = new m(this);
        this.VW = lVar;
        this.VV.sendEmptyMessageDelayed(0, 50000L);
        this.VX = new k(this, null);
        this.VX.setSelfExecute(true);
        this.VX.execute(String.valueOf(ug()) + str);
    }

    private String ug() {
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
    public void uh() {
        if (this.VX != null) {
            this.VX.cancel(true);
        }
        if (this.VV != null) {
            this.VV.removeMessages(0);
        }
    }
}

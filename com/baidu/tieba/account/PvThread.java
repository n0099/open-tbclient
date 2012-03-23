package com.baidu.tieba.account;

import com.baidu.tieba.util.NetWork;
/* loaded from: classes.dex */
public class PvThread extends Thread {
    private String mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PvThread(String type) {
        this.mType = null;
        this.mType = type;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork network = new NetWork("http://c.tieba.baidu.com/c/s/pv");
        network.addPostData("st_type", this.mType);
        network.postNetData();
    }
}

package com.baidu.tieba.account;

import com.baidu.tieba.util.NetWork;
/* loaded from: classes.dex */
public class PvThread extends Thread {
    private String mParam;
    private String mType;

    public PvThread(String type) {
        this.mType = null;
        this.mParam = null;
        this.mType = type;
    }

    public PvThread(String type, String param) {
        this.mType = null;
        this.mParam = null;
        this.mType = type;
        this.mParam = param;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork network = new NetWork("http://c.tieba.baidu.com/c/s/pv");
        network.addPostData("st_type", this.mType);
        if (this.mParam != null) {
            network.addPostData("st_param", this.mParam);
        }
        network.postNetData();
    }
}

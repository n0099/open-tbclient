package com.baidu.tieba.account;

import com.baidu.tieba.util.NetWork;
/* loaded from: classes.dex */
public class PvImageThread extends Thread {
    private int imageNum;
    private int totalImageNum;
    private String type = null;

    public PvImageThread(int imageNum, int totalImageNum) {
        this.imageNum = 0;
        this.totalImageNum = 0;
        this.imageNum = imageNum;
        this.totalImageNum = totalImageNum;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        NetWork network = new NetWork("http://c.tieba.baidu.com/c/s/pv");
        network.addPostData("img_num", String.valueOf(this.imageNum));
        network.addPostData("img_total", String.valueOf(this.totalImageNum));
        if (this.type != null) {
            network.addPostData("img_type", this.type);
        }
        network.postNetData();
    }
}

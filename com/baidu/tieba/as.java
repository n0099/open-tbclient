package com.baidu.tieba;
/* loaded from: classes.dex */
class as extends Thread {
    private as() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.at atVar = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/m/register");
        atVar.c(false);
        atVar.a("channel_id", TiebaApplication.g().bc());
        atVar.a("channel_uid", TiebaApplication.g().bb());
        atVar.l();
    }
}

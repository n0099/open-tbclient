package com.baidu.tieba;
/* loaded from: classes.dex */
class as extends Thread {
    private as() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.am amVar = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/m/register");
        amVar.c(false);
        amVar.a("channel_id", TiebaApplication.h().bc());
        amVar.a("channel_uid", TiebaApplication.h().bb());
        amVar.l();
    }
}

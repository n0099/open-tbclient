package com.baidu.tieba;
/* loaded from: classes.dex */
class ar extends Thread {
    private ar() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.an anVar = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/m/register");
        anVar.c(false);
        anVar.a("channel_id", TiebaApplication.h().bc());
        anVar.a("channel_uid", TiebaApplication.h().bb());
        anVar.l();
    }
}

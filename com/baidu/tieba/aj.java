package com.baidu.tieba;
/* loaded from: classes.dex */
class aj extends Thread {
    private aj() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ag agVar = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/m/register");
        agVar.c(false);
        agVar.a("channel_id", TiebaApplication.g().bg());
        agVar.a("channel_uid", TiebaApplication.g().bf());
        agVar.j();
    }
}

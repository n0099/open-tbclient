package com.baidu.tieba;
/* loaded from: classes.dex */
class ao extends Thread {
    private ao() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ap apVar = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/m/register");
        apVar.c(false);
        apVar.a("channel_id", TiebaApplication.g().bb());
        apVar.a("channel_uid", TiebaApplication.g().ba());
        apVar.l();
    }
}

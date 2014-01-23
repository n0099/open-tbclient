package com.baidu.tieba;
/* loaded from: classes.dex */
class ar extends Thread {
    private ar() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ax axVar = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/m/register");
        axVar.c(false);
        axVar.a("channel_id", TiebaApplication.h().bb());
        axVar.a("channel_uid", TiebaApplication.h().ba());
        axVar.m();
    }
}

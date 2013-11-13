package com.baidu.tieba;
/* loaded from: classes.dex */
class al extends Thread {
    private al() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ap apVar = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/m/register");
        apVar.c(false);
        apVar.a("channel_id", TiebaApplication.g().ba());
        apVar.a("channel_uid", TiebaApplication.g().aZ());
        apVar.j();
    }
}

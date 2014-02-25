package com.baidu.tieba;
/* loaded from: classes.dex */
class ak extends Thread {
    private ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ak akVar) {
        this();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/m/register");
        baVar.c(false);
        baVar.a("channel_id", TiebaApplication.g().aY());
        baVar.a("channel_uid", TiebaApplication.g().aX());
        baVar.m();
    }
}

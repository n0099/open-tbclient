package com.baidu.tieba;
/* loaded from: classes.dex */
final class ak extends Thread {
    private ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(byte b) {
        this();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/m/register");
        baVar.c(false);
        baVar.a("channel_id", TiebaApplication.g().aQ());
        baVar.a("channel_uid", TiebaApplication.g().aP());
        baVar.l();
    }
}

package com.baidu.tbadk.receiver;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
final class a extends Thread {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(byte b) {
        this();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        ak akVar = new ak(String.valueOf(n.a) + "c/m/register");
        akVar.a().a().b = false;
        akVar.a("channel_id", TbadkApplication.j().S());
        akVar.a("channel_uid", TbadkApplication.j().R());
        akVar.i();
    }
}

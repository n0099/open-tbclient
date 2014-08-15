package com.baidu.tbadk.pluginArch;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements ServiceConnection {
    final /* synthetic */ ab a;

    private ac(ab abVar) {
        this.a = abVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(ab abVar, ac acVar) {
        this(abVar);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BdLog.i("Connected");
        ab.a(this.a, new Messenger(iBinder));
        ab.a(this.a);
        if (ab.b(this.a) == 2) {
            if (ab.c(this.a) != null) {
                ab.a(this.a, ab.c(this.a));
                ab.a(this.a, -1);
                ab.b(this.a, (String) null);
                this.a.c();
            }
        } else if (ab.b(this.a) == 3) {
            ab.d(this.a);
            ab.a(this.a, -1);
            this.a.c();
        } else if (ab.b(this.a) == 4 && ab.e(this.a) != null) {
            ab.a(this.a, ab.e(this.a));
            ab.a(this.a, -1);
            ab.b(this.a, (ConfigInfos) null);
            this.a.c();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ab.a(this.a, (Messenger) null);
    }
}

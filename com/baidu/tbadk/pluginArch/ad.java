package com.baidu.tbadk.pluginArch;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements ServiceConnection {
    final /* synthetic */ ac a;

    private ad(ac acVar) {
        this.a = acVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(ac acVar, ad adVar) {
        this(acVar);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BdLog.i("Connected");
        ac.a(this.a, new Messenger(iBinder));
        ac.a(this.a);
        if (ac.b(this.a) == 2) {
            if (ac.c(this.a) != null) {
                ac.a(this.a, ac.c(this.a));
                ac.a(this.a, -1);
                ac.b(this.a, (String) null);
                this.a.c();
            }
        } else if (ac.b(this.a) == 3) {
            ac.d(this.a);
            ac.a(this.a, -1);
            this.a.c();
        } else if (ac.b(this.a) == 4 && ac.e(this.a) != null) {
            ac.a(this.a, ac.e(this.a));
            ac.a(this.a, -1);
            ac.b(this.a, (ConfigInfos) null);
            this.a.c();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ac.a(this.a, (Messenger) null);
    }
}

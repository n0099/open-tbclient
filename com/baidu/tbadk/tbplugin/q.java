package com.baidu.tbadk.tbplugin;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* loaded from: classes.dex */
class q extends Handler {
    final /* synthetic */ o a;

    private q(o oVar) {
        this.a = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(o oVar, q qVar) {
        this(oVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 2:
                if (message.getData() != null) {
                    o.a(this.a, (PluginsConfig) message.getData().getSerializable("plugin_config"));
                    Iterator it = o.b(this.a).iterator();
                    while (it.hasNext()) {
                        r rVar = (r) ((WeakReference) it.next()).get();
                        if (rVar == null) {
                            it.remove();
                        } else {
                            rVar.a(o.c(this.a));
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}

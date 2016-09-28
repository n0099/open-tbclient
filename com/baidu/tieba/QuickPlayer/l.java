package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.view.Surface;
import com.baidu.tieba.QuickPlayer.a;
import com.baidu.tieba.QuickPlayer.j;
import com.baidu.tieba.play.CustomPlayerSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ServiceConnection {
    final /* synthetic */ j aLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aLC = jVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a aVar;
        int i;
        a aVar2;
        a aVar3;
        j.a aVar4;
        a aVar5;
        c cVar;
        c cVar2;
        this.aLC.aLx = true;
        this.aLC.aLp = a.AbstractBinderC0050a.b(iBinder);
        try {
            aVar = this.aLC.aLp;
            i = this.aLC.aLl;
            aVar.fE(i);
            aVar2 = this.aLC.aLp;
            aVar2.bZ(CustomPlayerSwitchStatic.bah() == 0);
            aVar3 = this.aLC.aLp;
            aVar4 = j.aLw;
            aVar3.a(aVar4);
            aVar5 = this.aLC.aLp;
            cVar = this.aLC.aLv;
            Uri uri = cVar.getUri();
            cVar2 = this.aLC.aLv;
            aVar5.a(uri, new Surface(cVar2.getSurfaceTexture()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.aLC.aLx = false;
    }
}

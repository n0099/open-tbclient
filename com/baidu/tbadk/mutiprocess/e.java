package com.baidu.tbadk.mutiprocess;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e implements d {
    private a ebO;
    private c ebP;
    private Application mApplication;
    private String mPackageName = null;
    private final i ebQ = new i();
    private final j ebR = new j();

    public e(Application application) {
        this.mApplication = application;
    }

    @Override // com.baidu.tbadk.mutiprocess.d
    public void a(c cVar) {
        this.ebP = cVar;
    }

    @Override // com.baidu.tbadk.mutiprocess.d
    public void publishEvent(com.baidu.tbadk.mutiprocess.a aVar) {
        c(aVar);
    }

    @Override // com.baidu.tbadk.mutiprocess.d
    public void startService() {
        registerReceiver();
    }

    private void registerReceiver() {
        try {
            unregisterReceiver();
            this.ebO = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
            this.mApplication.registerReceiver(this.ebO, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void unregisterReceiver() {
        try {
            if (this.ebO != null && this.mApplication != null) {
                this.mApplication.unregisterReceiver(this.ebO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.baidu.tbadk.mutiprocess.a V;
            if (intent != null && "intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) && (V = e.this.ebQ.V(intent)) != null) {
                int myPid = Process.myPid();
                int pid = V.getPid();
                if (V != null && V.getType() == 1) {
                    if (myPid == pid) {
                        return;
                    }
                } else if (V.getType() == 2) {
                    if (myPid != pid) {
                        return;
                    }
                } else if (V.getType() == 3 && !TbadkCoreApplication.getInst().isMainProcess(true)) {
                    return;
                }
                if (e.this.ebP != null) {
                    e.this.ebP.b(V);
                }
            }
        }
    }

    private void c(com.baidu.tbadk.mutiprocess.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("send multi-process message is null");
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.setAction("intent.action.ACTION.TB.MUTI_PROCESS");
            this.ebR.a(intent, aVar);
            this.mApplication.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPackageName() {
        if (this.mPackageName == null && this.mApplication != null) {
            this.mPackageName = this.mApplication.getPackageName();
        }
        return this.mPackageName;
    }
}

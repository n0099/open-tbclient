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
    private a dBD;
    private c dBE;
    private Application mApplication;
    private String mPackageName = null;
    private final i dBF = new i();
    private final j dBG = new j();

    public e(Application application) {
        this.mApplication = application;
    }

    @Override // com.baidu.tbadk.mutiprocess.d
    public void a(c cVar) {
        this.dBE = cVar;
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
            this.dBD = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
            this.mApplication.registerReceiver(this.dBD, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void unregisterReceiver() {
        try {
            if (this.dBD != null && this.mApplication != null) {
                this.mApplication.unregisterReceiver(this.dBD);
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
            com.baidu.tbadk.mutiprocess.a W;
            if (intent != null && "intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) && (W = e.this.dBF.W(intent)) != null) {
                int myPid = Process.myPid();
                int pid = W.getPid();
                if (W != null && W.getType() == 1) {
                    if (myPid == pid) {
                        return;
                    }
                } else if (W.getType() == 2) {
                    if (myPid != pid) {
                        return;
                    }
                } else if (W.getType() == 3 && !TbadkCoreApplication.getInst().isMainProcess(true)) {
                    return;
                }
                if (e.this.dBE != null) {
                    e.this.dBE.b(W);
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
            this.dBG.a(intent, aVar);
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

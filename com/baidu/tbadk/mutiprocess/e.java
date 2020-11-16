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
    private a fsx;
    private c fsy;
    private Application mApplication;
    private String mPackageName = null;
    private final i fsz = new i();
    private final j fsA = new j();

    public e(Application application) {
        this.mApplication = application;
    }

    @Override // com.baidu.tbadk.mutiprocess.d
    public void a(c cVar) {
        this.fsy = cVar;
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
            this.fsx = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("intent.action.ACTION.TB.MUTI_PROCESS");
            this.mApplication.registerReceiver(this.fsx, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void unregisterReceiver() {
        try {
            if (this.fsx != null && this.mApplication != null) {
                this.mApplication.unregisterReceiver(this.fsx);
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
            com.baidu.tbadk.mutiprocess.a H;
            if (intent != null && "intent.action.ACTION.TB.MUTI_PROCESS".equals(intent.getAction()) && (H = e.this.fsz.H(intent)) != null) {
                int myPid = Process.myPid();
                int pid = H.getPid();
                if (H != null && H.getType() == 1) {
                    if (myPid == pid) {
                        return;
                    }
                } else if (H.getType() == 2) {
                    if (myPid != pid) {
                        return;
                    }
                } else if (H.getType() == 3 && !TbadkCoreApplication.getInst().isMainProcess(true)) {
                    return;
                }
                if (e.this.fsy != null) {
                    e.this.fsy.b(H);
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
            this.fsA.a(intent, aVar);
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

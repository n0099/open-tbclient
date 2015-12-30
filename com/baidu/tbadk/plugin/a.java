package com.baidu.tbadk.plugin;

import android.app.ActivityManager;
import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginErrorTipActivity aAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginErrorTipActivity pluginErrorTipActivity) {
        this.aAW = pluginErrorTipActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashSet hashSet = new HashSet(10);
        HashSet hashSet2 = new HashSet(10);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) BdBaseApplication.getInst().getContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.startsWith(this.aAW.getApplication().getPackageName()) && runningAppProcessInfo.pid != Process.myPid() && hashSet.contains(runningAppProcessInfo.processName)) {
                    hashSet2.add(Integer.valueOf(runningAppProcessInfo.pid));
                }
            }
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            Process.killProcess(((Integer) it.next()).intValue());
        }
        Process.killProcess(Process.myPid());
    }
}

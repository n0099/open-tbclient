package com.baidu.tieba.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class q {
    private static q apt;
    private ContentObserver apu;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<u> mListeners = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable apv = new r(this);

    public static q Br() {
        if (apt == null) {
            apt = new q();
            apt.init(TbadkCoreApplication.m255getInst());
        }
        return apt;
    }

    private q() {
    }

    private void init(Context context) {
        this.mReceiver = new s(this);
        this.apu = new t(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.apu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            bj(true);
            return;
        }
        this.handler.removeCallbacks(this.apv);
        this.handler.postDelayed(this.apv, 2000L);
    }

    public void bj(boolean z) {
        Iterator<u> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().bk(z);
        }
    }

    public void a(u uVar) {
        if (uVar != null && !this.mListeners.contains(uVar)) {
            this.mListeners.add(uVar);
        }
    }

    public void b(u uVar) {
        if (this.mListeners.contains(uVar)) {
            this.mListeners.remove(uVar);
        }
    }

    public void removeAllListeners() {
        this.mListeners.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
        m255getInst.unregisterReceiver(this.mReceiver);
        m255getInst.getContentResolver().unregisterContentObserver(this.apu);
        apt = null;
    }
}

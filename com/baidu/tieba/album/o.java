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
public class o {
    private static o aqp;
    private ContentObserver aqq;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<s> aA = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable aqr = new p(this);

    public static o BT() {
        if (aqp == null) {
            aqp = new o();
            aqp.init(TbadkCoreApplication.m255getInst());
        }
        return aqp;
    }

    private o() {
    }

    private void init(Context context) {
        this.mReceiver = new q(this);
        this.aqq = new r(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.aqq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            bl(true);
            return;
        }
        this.handler.removeCallbacks(this.aqr);
        this.handler.postDelayed(this.aqr, 2000L);
    }

    public void bl(boolean z) {
        Iterator<s> it = this.aA.iterator();
        while (it.hasNext()) {
            it.next().bm(z);
        }
    }

    public void a(s sVar) {
        if (sVar != null && !this.aA.contains(sVar)) {
            this.aA.add(sVar);
        }
    }

    public void b(s sVar) {
        if (this.aA.contains(sVar)) {
            this.aA.remove(sVar);
        }
    }

    public void removeAllListeners() {
        this.aA.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
        m255getInst.unregisterReceiver(this.mReceiver);
        m255getInst.getContentResolver().unregisterContentObserver(this.aqq);
        aqp = null;
    }
}

package com.baidu.tieba.ala.alaar.sticker.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import com.baidu.tieba.ala.alaar.sticker.download.c;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes3.dex */
public class CaptureDownloadService extends Service {
    public static final String ACTION_CANCEL = "com.baidu.ugc.download.ACTION_CANCEL";
    public static final String ACTION_CANCEL_ALL = "com.baidu.ugc.download.ACTION_CANCEL_ALL";
    public static final String ACTION_DOWNLOAD = "com.baidu.ugc.download.ACTION_DOWNLOAD";
    public static final String ACTION_DOWNLOAD_BROAD_CAST = "com.baidu.ugc.download.ACTION_BROAD_CAST";
    public static final String ACTION_PAUSE = "com.baidu.ugc.download.ACTION_PAUSE";
    public static final String ACTION_PAUSE_ALL = "com.baidu.ugc.download.ACTION_PAUSE_ALL";
    public static final String EXTRA_FILE_INFO = "extra_file_info";
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_TAG = "extra_tag";
    private static final String TAG = "CaptureDownloadService";
    private b mDownloadManager;

    public static void start(Context context, String str, d dVar) {
        start(context, 0, str, dVar);
    }

    public static void start(Context context, int i, String str, d dVar) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_DOWNLOAD");
        intent.putExtra("extra_position", i);
        intent.putExtra("extra_tag", str);
        intent.putExtra("extra_file_info", dVar.toJson().toString());
        context.startService(intent);
    }

    public static void pause(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_PAUSE");
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    private void pause(String str) {
        this.mDownloadManager.pause(str);
    }

    public static void cancel(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_CANCEL");
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    private void cancel(String str) {
        this.mDownloadManager.cancel(str);
    }

    public static void pauseAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_PAUSE_ALL");
        context.startService(intent);
    }

    private void pauseAll() {
        this.mDownloadManager.pauseAll();
    }

    public static void cancelAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction("com.baidu.ugc.download.ACTION_CANCEL_ALL");
        context.startService(intent);
    }

    private void cancelAll() {
        this.mDownloadManager.cancelAll();
    }

    public static void destroy(Context context) {
        context.stopService(new Intent(context, CaptureDownloadService.class));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (r2.equals("com.baidu.ugc.download.ACTION_DOWNLOAD") != false) goto L6;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i, int i2) {
        char c = 0;
        if (intent != null) {
            String action = intent.getAction();
            int intExtra = intent.getIntExtra("extra_position", 0);
            d dVar = new d();
            dVar.parse(intent.getStringExtra("extra_file_info"));
            String stringExtra = intent.getStringExtra("extra_tag");
            switch (action.hashCode()) {
                case -2000112966:
                    if (action.equals("com.baidu.ugc.download.ACTION_CANCEL")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1148652932:
                    if (action.equals("com.baidu.ugc.download.ACTION_CANCEL_ALL")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -929888424:
                    if (action.equals("com.baidu.ugc.download.ACTION_PAUSE_ALL")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -707184440:
                    break;
                case 1610061206:
                    if (action.equals("com.baidu.ugc.download.ACTION_PAUSE")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    download(intExtra, dVar, stringExtra);
                    break;
                case 1:
                    pause(stringExtra);
                    break;
                case 2:
                    cancel(stringExtra);
                    break;
                case 3:
                    pauseAll();
                    break;
                case 4:
                    cancelAll();
                    break;
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    private void download(int i, d dVar, String str) {
        this.mDownloadManager.a(new c.a().yV(dVar.getUrl()).bkl(), str, new a(i, dVar, getApplicationContext()));
    }

    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.ala.alaar.sticker.download.a.a {
        private d eKd;
        private int mLastProgress;
        private long mLastTime;
        private LocalBroadcastManager mLocalBroadcastManager;
        private int mPosition;

        public a(int i, d dVar, Context context) {
            this.mPosition = i;
            this.eKd = dVar;
            this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(context);
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onProgress(long j, long j2, int i) {
            if (this.mLastTime == 0) {
                this.mLastTime = System.currentTimeMillis();
            }
            this.eKd.setStatus(3);
            this.eKd.setProgress(i);
            this.eKd.setDownloadPerSize(com.baidu.tieba.ala.alaar.sticker.b.b.getDownloadPerSize(j, j2));
            if (checkSendBroadLimit(i)) {
                a(this.eKd);
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onCompleted(String str) {
            this.eKd.setStatus(6);
            this.eKd.setProgress(100);
            this.eKd.setSavePath(str);
            a(this.eKd);
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onDownloadPaused() {
            this.eKd.setStatus(4);
            a(this.eKd);
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void onDownloadCanceled() {
            this.eKd.setStatus(0);
            this.eKd.setProgress(0);
            this.eKd.setDownloadPerSize("");
            a(this.eKd);
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
        public void a(DownloadException downloadException) {
            downloadException.printStackTrace();
            this.eKd.setStatus(5);
            a(this.eKd);
        }

        private void a(d dVar) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.ugc.download.ACTION_BROAD_CAST");
            intent.putExtra("extra_position", this.mPosition);
            intent.putExtra("extra_file_info", dVar.toJson().toString());
            this.mLocalBroadcastManager.sendBroadcast(intent);
        }

        private boolean checkSendBroadLimit(int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTime <= 300 || i == this.mLastProgress) {
                return false;
            }
            this.mLastTime = currentTimeMillis;
            this.mLastProgress = i;
            return true;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDownloadManager = b.bkk();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDownloadManager.pauseAll();
    }
}

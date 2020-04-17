package com.baidu.tieba.VideoCacheClient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.baidu.tieba.VideoCache.VideoCacheService;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
/* loaded from: classes9.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e exR;
    private Context mContext;
    private Handler mHandler;
    private long exS = 0;
    private boolean evs = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.VideoCacheClient.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof String) {
                    e.this.xD((String) message.obj);
                }
            } else if (message.what == 2) {
                if (message.obj instanceof String) {
                    e.this.xI((String) message.obj);
                }
            } else if (message.what == 3) {
                d.D(e.TAG, "got MSG_CHECK");
                e.this.bfG();
                e.this.mHandler.sendMessageDelayed(e.this.mHandler.obtainMessage(3), 5000L);
            } else if (message.what == 4) {
                e.this.bfH();
            } else if (message.what == 5 && (message.obj instanceof String)) {
                int i = message.arg1;
                e.this.aq((String) message.obj, i);
            }
            return true;
        }
    };
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.VideoCacheClient.e.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.evs = true;
            com.baidu.adp.lib.f.e.lb().removeCallbacks(e.this.evA);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            File file = new File(c.exE);
            if (file.exists()) {
                file.delete();
            }
            b.bfD().bfF();
            e.this.evs = false;
            com.baidu.adp.lib.f.e.lb().postDelayed(e.this.evA, 1000L);
        }
    };
    private Runnable evA = new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.evs) {
                e.this.beK();
                com.baidu.adp.lib.f.e.lb().postDelayed(e.this.evA, 1000L);
            }
        }
    };

    private e(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        HandlerThread handlerThread = new HandlerThread("video_cache_client_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.mHandlerCallback);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), 5000L);
    }

    public static e ec(Context context) {
        if (exR == null) {
            synchronized (e.class) {
                if (exR == null) {
                    exR = new e(context);
                }
            }
        }
        return exR;
    }

    public void ap(String str, int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.obj = str;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void xW(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void xX(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void cT(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://127.0.0.1:" + b.bfD().getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str + str2)).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.read();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(String str, int i) {
        cT(str, "?segment_postion=" + String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD(String str) {
        cT(str, "?file_access=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xI(String str) {
        cT(str, "?stop_cache=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfG() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.exS >= 86400000) {
            cT("", "delete_expired_files");
            this.exS = currentTimeMillis;
        }
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfH() {
        cT("", "clear_cache");
    }

    public void beK() {
        try {
            this.mContext.bindService(new Intent(this.mContext, VideoCacheService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

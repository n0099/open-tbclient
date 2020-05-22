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
    private static e eMy;
    private Context mContext;
    private Handler mHandler;
    private long eMz = 0;
    private boolean eJZ = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.VideoCacheClient.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof String) {
                    e.this.zm((String) message.obj);
                }
            } else if (message.what == 2) {
                if (message.obj instanceof String) {
                    e.this.zr((String) message.obj);
                }
            } else if (message.what == 3) {
                d.D(e.TAG, "got MSG_CHECK");
                e.this.blQ();
                e.this.mHandler.sendMessageDelayed(e.this.mHandler.obtainMessage(3), 5000L);
            } else if (message.what == 4) {
                e.this.blR();
            } else if (message.what == 5 && (message.obj instanceof String)) {
                int i = message.arg1;
                e.this.ar((String) message.obj, i);
            }
            return true;
        }
    };
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.VideoCacheClient.e.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.eJZ = true;
            com.baidu.adp.lib.f.e.ld().removeCallbacks(e.this.eKh);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            File file = new File(c.eMl);
            if (file.exists()) {
                file.delete();
            }
            b.blN().blP();
            e.this.eJZ = false;
            com.baidu.adp.lib.f.e.ld().postDelayed(e.this.eKh, 1000L);
        }
    };
    private Runnable eKh = new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.eJZ) {
                e.this.bkV();
                com.baidu.adp.lib.f.e.ld().postDelayed(e.this.eKh, 1000L);
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

    public static e eh(Context context) {
        if (eMy == null) {
            synchronized (e.class) {
                if (eMy == null) {
                    eMy = new e(context);
                }
            }
        }
        return eMy;
    }

    public void aq(String str, int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.obj = str;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void zF(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void zG(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void ds(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://127.0.0.1:" + b.blN().getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str + str2)).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.read();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(String str, int i) {
        ds(str, "?segment_postion=" + String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm(String str) {
        ds(str, "?file_access=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(String str) {
        ds(str, "?stop_cache=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eMz >= 86400000) {
            ds("", "delete_expired_files");
            this.eMz = currentTimeMillis;
        }
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blR() {
        ds("", "clear_cache");
    }

    public void bkV() {
        try {
            this.mContext.bindService(new Intent(this.mContext, VideoCacheService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

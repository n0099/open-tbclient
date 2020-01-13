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
/* loaded from: classes7.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e dTn;
    private Context mContext;
    private Handler mHandler;
    private long dTo = 0;
    private boolean dQK = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.VideoCacheClient.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof String) {
                    e.this.vV((String) message.obj);
                }
            } else if (message.what == 2) {
                if (message.obj instanceof String) {
                    e.this.wa((String) message.obj);
                }
            } else if (message.what == 3) {
                d.aK(e.TAG, "got MSG_CHECK");
                e.this.aVe();
                e.this.mHandler.sendMessageDelayed(e.this.mHandler.obtainMessage(3), 5000L);
            } else if (message.what == 4) {
                e.this.aVf();
            } else if (message.what == 5 && (message.obj instanceof String)) {
                int i = message.arg1;
                e.this.aj((String) message.obj, i);
            }
            return true;
        }
    };
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.VideoCacheClient.e.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.dQK = true;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(e.this.dQS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            File file = new File(c.dTa);
            if (file.exists()) {
                file.delete();
            }
            b.aVb().aVd();
            e.this.dQK = false;
            com.baidu.adp.lib.f.e.gx().postDelayed(e.this.dQS, 1000L);
        }
    };
    private Runnable dQS = new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.dQK) {
                e.this.aUh();
                com.baidu.adp.lib.f.e.gx().postDelayed(e.this.dQS, 1000L);
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

    public static e eo(Context context) {
        if (dTn == null) {
            synchronized (e.class) {
                if (dTn == null) {
                    dTn = new e(context);
                }
            }
        }
        return dTn;
    }

    public void ai(String str, int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.obj = str;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void wo(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void wp(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void cA(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://127.0.0.1:" + b.aVb().getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str + str2)).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.read();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str, int i) {
        cA(str, "?segment_postion=" + String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV(String str) {
        cA(str, "?file_access=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(String str) {
        cA(str, "?stop_cache=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVe() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dTo >= 86400000) {
            cA("", "delete_expired_files");
            this.dTo = currentTimeMillis;
        }
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVf() {
        cA("", "clear_cache");
    }

    public void aUh() {
        try {
            this.mContext.bindService(new Intent(this.mContext, VideoCacheService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

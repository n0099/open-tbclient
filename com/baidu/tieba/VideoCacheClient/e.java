package com.baidu.tieba.VideoCacheClient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoCache.VideoCacheService;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private static e bRX;
    private Context mContext;
    private Handler mHandler;
    private long mLastCheckTime = 0;
    private boolean bPr = false;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.VideoCacheClient.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof String) {
                    e.this.hG((String) message.obj);
                }
            } else if (message.what == 2) {
                if (message.obj instanceof String) {
                    e.this.hM((String) message.obj);
                }
            } else if (message.what == 3) {
                d.au(e.TAG, "got MSG_CHECK");
                e.this.Ua();
                e.this.mHandler.sendMessageDelayed(e.this.mHandler.obtainMessage(3), TbConfig.NOTIFY_SOUND_INTERVAL);
            } else if (message.what == 4) {
                e.this.Ub();
            } else if (message.what == 5 && (message.obj instanceof String)) {
                int i = message.arg1;
                e.this.K((String) message.obj, i);
            }
            return true;
        }
    };
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.VideoCacheClient.e.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.bPr = true;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(e.this.bPz);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            File file = new File(c.bRI);
            if (file.exists()) {
                file.delete();
            }
            b.TX().TZ();
            e.this.bPr = false;
            com.baidu.adp.lib.g.e.ns().postDelayed(e.this.bPz, 1000L);
        }
    };
    private Runnable bPz = new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.bPr) {
                e.this.Tf();
                com.baidu.adp.lib.g.e.ns().postDelayed(e.this.bPz, 1000L);
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
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public static e bp(Context context) {
        if (bRX == null) {
            synchronized (e.class) {
                if (bRX == null) {
                    bRX = new e(context);
                }
            }
        }
        return bRX;
    }

    public void J(String str, int i) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.obj = str;
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hZ(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void ia(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void av(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://127.0.0.1:" + b.TX().getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str + str2)).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.read();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, int i) {
        av(str, "?segment_postion=" + String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hG(String str) {
        av(str, "?file_access=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hM(String str) {
        av(str, "?stop_cache=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ua() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastCheckTime >= 86400000) {
            av("", "delete_expired_files");
            this.mLastCheckTime = currentTimeMillis;
        }
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ub() {
        av("", "clear_cache");
    }

    public void Tf() {
        try {
            this.mContext.bindService(new Intent(this.mContext, VideoCacheService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

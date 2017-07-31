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
    private static e aWP;
    private Context mContext;
    private Handler mHandler;
    private long mLastCheckTime = 0;
    private boolean aUG = false;
    private Handler.Callback aUR = new Handler.Callback() { // from class: com.baidu.tieba.VideoCacheClient.e.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof String) {
                    e.this.hh((String) message.obj);
                }
            } else if (message.what == 2) {
                if (message.obj instanceof String) {
                    e.this.hn((String) message.obj);
                }
            } else if (message.what == 3) {
                d.log(e.TAG, "got MSG_CHECK");
                e.this.KL();
                e.this.mHandler.sendMessageDelayed(e.this.mHandler.obtainMessage(3), TbConfig.NOTIFY_SOUND_INTERVAL);
            } else if (message.what == 4) {
                e.this.KM();
            }
            return true;
        }
    };
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.VideoCacheClient.e.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.this.aUG = true;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(e.this.aUI);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            File file = new File(c.aWC);
            if (file.exists()) {
                file.delete();
            }
            b.KI().KK();
            e.this.aUG = false;
            com.baidu.adp.lib.g.e.ga().postDelayed(e.this.aUI, 1000L);
        }
    };
    private Runnable aUI = new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.aUG) {
                e.this.JZ();
                com.baidu.adp.lib.g.e.ga().postDelayed(e.this.aUI, 1000L);
            }
        }
    };

    private e(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        HandlerThread handlerThread = new HandlerThread("video_cache_client_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aUR);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public static e ba(Context context) {
        if (aWP == null) {
            synchronized (e.class) {
                if (aWP == null) {
                    aWP = new e(context);
                }
            }
        }
        return aWP;
    }

    public void hA(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hB(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void at(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://127.0.0.1:" + b.KI().getPort() + "/video_cache?origin_url=" + URLEncoder.encode(str + str2)).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.read();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh(String str) {
        at(str, "?file_access=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(String str) {
        at(str, "?stop_cache=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KL() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastCheckTime >= 86400000) {
            at("", "delete_expired_files");
            this.mLastCheckTime = currentTimeMillis;
        }
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KM() {
        at("", "clear_cache");
    }

    public void JZ() {
        try {
            this.mContext.bindService(new Intent(this.mContext, VideoCacheService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

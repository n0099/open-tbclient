package com.baidu.tieba.VideoCacheClient;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoCache.VideoCacheService;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class f {
    private static final String TAG = f.class.getSimpleName();
    private static f aUC;
    private Context mContext;
    private Handler mHandler;
    private long mLastCheckTime = 0;
    private boolean aSq = false;
    private Handler.Callback aSC = new g(this);
    private ServiceConnection mServiceConnection = new h(this);
    private Runnable aSs = new i(this);

    private f(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        HandlerThread handlerThread = new HandlerThread("video_cache_client_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aSC);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public static f aZ(Context context) {
        if (aUC == null) {
            synchronized (f.class) {
                if (aUC == null) {
                    aUC = new f(context);
                }
            }
        }
        return aUC;
    }

    public void hp(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hq(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void at(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://127.0.0.1:" + c.Kw().getPort() + "/video_cache?origin_url=" + URLEncoder.encode(String.valueOf(str) + str2)).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.read();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gW(String str) {
        at(str, "?file_access=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(String str) {
        at(str, "?stop_cache=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kz() {
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
    public void KA() {
        at("", "clear_cache");
    }

    public void JN() {
        try {
            this.mContext.bindService(new Intent(this.mContext, VideoCacheService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

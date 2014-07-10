package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class FileDownloader extends Service {
    public static final int FILE_EXIST = 1;
    private static final String TAG_FILE = "file";
    private static final String TAG_INFO = "info";
    private static final String TAG_URL = "url";
    private g mDowndingTask = null;
    private int progress = 0;
    private String schedule = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler handler = new f(this);

    public static void download(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, FileDownloader.class);
        intent.putExtra(TAG_FILE, str2);
        intent.putExtra(TAG_URL, str);
        intent.putExtra(TAG_INFO, str3);
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeMessages(TbConfig.NET_MSG_GETLENTH);
        if (this.mDowndingTask != null) {
            this.mDowndingTask.cancel();
        }
        com.baidu.tbadk.core.util.bb.a(getBaseContext(), 10);
        com.baidu.tbadk.core.util.bb.a(getBaseContext(), 14);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String fileOfUrl;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(TAG_INFO);
            String stringExtra2 = intent.getStringExtra(TAG_URL);
            if (intent.getStringExtra(TAG_FILE) != null) {
                fileOfUrl = intent.getStringExtra(TAG_FILE);
            } else {
                fileOfUrl = getFileOfUrl(stringExtra2);
            }
            if (com.baidu.tbadk.core.util.z.d(fileOfUrl) != null) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, fileOfUrl), 100L);
            } else if (this.mDowndingTask == null) {
                this.mDowndingTask = new g(this, stringExtra2, fileOfUrl);
                this.mDowndingTask.execute(new String[0]);
                com.baidu.tbadk.core.util.bb.a(getBaseContext(), 10, (String) null, 0, "0/0", stringExtra, true);
            }
        }
        super.onStart(intent, i);
    }

    private String getFileOfUrl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }
}

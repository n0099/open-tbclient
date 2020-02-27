package com.baidu.tieba.ala.liveroom.task;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private static int fkH = 0;
    private static volatile c fkI = null;
    private long currLiveId;
    private long duration;
    private long now;
    private Handler handler = new Handler();
    Runnable fkJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.task.c.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + c.fkH + ", currLiveId=" + c.this.currLiveId + ", duration=" + c.this.duration);
            c.this.Wk();
            c.this.stopRecord();
        }
    };

    public static c bqw() {
        if (fkI == null) {
            synchronized (c.class) {
                if (fkI == null) {
                    fkI = new c();
                }
            }
        }
        return fkI;
    }

    public void cZ(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + fkH + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (bqx()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fkJ);
            this.handler.postDelayed(this.fkJ, 60000 - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + fkH + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.fkJ);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void da(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + fkH + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.fkJ);
        this.handler.postDelayed(this.fkJ, 60000 - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + fkH + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.fkJ);
    }

    private boolean bqx() {
        return fkH < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        Log.i("TaskHelper", "@@ report watchCount=" + fkH + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration + ", isNeed=" + bqx());
        if (bqx()) {
            HttpMessage httpMessage = new HttpMessage(1021127);
            httpMessage.addParam("live_id", this.currLiveId);
            httpMessage.addParam("client_ip", "");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(Context context, a aVar) {
        if (aVar != null) {
            fkH++;
            if (context != null && (context instanceof Activity) && aVar.fkw == 1 && !TextUtils.isEmpty(aVar.tips)) {
                e(context, aVar.tips, aVar.url, aVar.title);
            }
        }
    }

    private void e(final Context context, String str, final String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_task_result, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.PlayLevelDialog);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().getAttributes().gravity = 80;
        ((TextView) inflate.findViewById(a.g.tip_textView)).setText(str);
        TextView textView = (TextView) inflate.findViewById(a.g.right_textView);
        if (TextUtils.isEmpty(str3)) {
            str3 = "知道了";
        }
        textView.setText(str3);
        View findViewById = inflate.findViewById(a.g.result_layout);
        final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.task.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Activity activity = (Activity) context;
                    if (Build.VERSION.SDK_INT >= 17) {
                        if (!activity.isDestroyed() && !activity.isFinishing()) {
                            dialog.dismiss();
                        }
                    } else if (!activity.isFinishing()) {
                        dialog.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.handler.postDelayed(runnable, 3000L);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.task.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(str2)) {
                    BrowserHelper.startInternalWebActivity(context, str2);
                }
                c.this.handler.removeCallbacks(runnable);
                try {
                    dialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

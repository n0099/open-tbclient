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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
/* loaded from: classes4.dex */
public class c {
    private static int htr = 0;
    private static volatile c hts = null;
    private long currLiveId;
    private long duration;
    private Handler handler = new Handler();
    Runnable htt = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.task.c.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + c.htr + ", currLiveId=" + c.this.currLiveId + ", duration=" + c.this.duration);
            c.this.atR();
            c.this.stopRecord();
        }
    };
    private long now;

    public static c chq() {
        if (hts == null) {
            synchronized (c.class) {
                if (hts == null) {
                    hts = new c();
                }
            }
        }
        return hts;
    }

    public void fb(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (chr()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.htt);
            this.handler.postDelayed(this.htt, 60000 - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.htt);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void fc(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.htt);
        this.handler.postDelayed(this.htt, 60000 - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.htt);
    }

    private boolean chr() {
        return htr < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atR() {
        Log.i("TaskHelper", "@@ report watchCount=" + htr + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration + ", isNeed=" + chr());
        if (chr()) {
            HttpMessage httpMessage = new HttpMessage(1021127);
            httpMessage.addParam("live_id", this.currLiveId);
            httpMessage.addParam("client_ip", "");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(Context context, a aVar) {
        if (aVar != null) {
            htr++;
            if (context != null && (context instanceof Activity) && aVar.htg == 1 && !TextUtils.isEmpty(aVar.tips)) {
                e(context, aVar.tips, aVar.url, aVar.title);
            }
        }
    }

    private void e(final Context context, String str, final String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(a.g.dialog_task_result, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.i.PlayLevelDialog);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().getAttributes().gravity = 80;
        ((TextView) inflate.findViewById(a.f.tip_textView)).setText(str);
        TextView textView = (TextView) inflate.findViewById(a.f.right_textView);
        if (TextUtils.isEmpty(str3)) {
            str3 = "知道了";
        }
        textView.setText(str3);
        View findViewById = inflate.findViewById(a.f.result_layout);
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
        this.handler.postDelayed(runnable, IMConnection.RETRY_DELAY_TIMES);
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

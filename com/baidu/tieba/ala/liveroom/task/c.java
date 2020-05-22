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
    private static int geI = 0;
    private static volatile c geJ = null;
    private long currLiveId;
    private long duration;
    private long now;
    private Handler handler = new Handler();
    Runnable geK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.task.c.1
        @Override // java.lang.Runnable
        public void run() {
            Log.i("TaskHelper", "@@ reportRunnable haokan=" + c.geI + ", currLiveId=" + c.this.currLiveId + ", duration=" + c.this.duration);
            c.this.ahn();
            c.this.stopRecord();
        }
    };

    public static c bGo() {
        if (geJ == null) {
            synchronized (c.class) {
                if (geJ == null) {
                    geJ = new c();
                }
            }
        }
        return geJ;
    }

    public void dI(long j) {
        Log.i("TaskHelper", "@@ startRecord watchCount=" + geI + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (bGp()) {
            this.currLiveId = j;
            this.duration = 0L;
            this.now = System.currentTimeMillis();
            this.handler.removeCallbacks(this.geK);
            this.handler.postDelayed(this.geK, 60000 - this.duration);
        }
    }

    public void pauseRecord() {
        Log.i("TaskHelper", "@@ pauseRecord watchCount=" + geI + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.handler.removeCallbacks(this.geK);
        this.duration = System.currentTimeMillis() - this.now;
        if (this.duration < 0) {
            this.duration = 0L;
        }
    }

    public void dJ(long j) {
        Log.i("TaskHelper", "@@ resumeRecord watchCount=" + geI + ", currLiveId=" + this.currLiveId + ", liveId=" + j + ", duration=" + this.duration);
        if (this.currLiveId == 0 || this.currLiveId != j) {
            stopRecord();
            return;
        }
        this.now = System.currentTimeMillis();
        this.handler.removeCallbacks(this.geK);
        this.handler.postDelayed(this.geK, 60000 - this.duration);
    }

    public void stopRecord() {
        Log.i("TaskHelper", "@@ stopRecord watchCount=" + geI + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration);
        this.duration = 0L;
        this.currLiveId = 0L;
        this.handler.removeCallbacks(this.geK);
    }

    private boolean bGp() {
        return geI < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahn() {
        Log.i("TaskHelper", "@@ report watchCount=" + geI + ", currLiveId=" + this.currLiveId + ", duration=" + this.duration + ", isNeed=" + bGp());
        if (bGp()) {
            HttpMessage httpMessage = new HttpMessage(1021127);
            httpMessage.addParam("live_id", this.currLiveId);
            httpMessage.addParam("client_ip", "");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(Context context, a aVar) {
        if (aVar != null) {
            geI++;
            if (context != null && (context instanceof Activity) && aVar.gex == 1 && !TextUtils.isEmpty(aVar.tips)) {
                d(context, aVar.tips, aVar.url, aVar.title);
            }
        }
    }

    private void d(final Context context, String str, final String str2, String str3) {
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

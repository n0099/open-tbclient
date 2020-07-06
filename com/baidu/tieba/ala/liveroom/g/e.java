package com.baidu.tieba.ala.liveroom.g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.bc;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.tieba.ala.liveroom.data.LiveTaskResponseMessage;
/* loaded from: classes3.dex */
public class e {
    private bc fWG;
    private long gfK;
    private int gfL;
    private int gfM;
    private HttpMessageListener gfN = new HttpMessageListener(1021152) { // from class: com.baidu.tieba.ala.liveroom.g.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.hasError()) {
                if (e.this.gfM < 2) {
                    e.this.gfM++;
                    e.this.kX(false);
                } else {
                    return;
                }
            }
            if (httpResponsedMessage instanceof LiveTaskResponseMessage) {
                LiveTaskResponseMessage liveTaskResponseMessage = (LiveTaskResponseMessage) httpResponsedMessage;
                e.this.a(e.this.pageContext.getPageActivity(), liveTaskResponseMessage.message, liveTaskResponseMessage.btnText, TextUtils.isEmpty(liveTaskResponseMessage.scheme) ? liveTaskResponseMessage.url : liveTaskResponseMessage.scheme, liveTaskResponseMessage.ggK);
            }
        }
    };
    private CustomMessageListener gfO = new CustomMessageListener(2913124) { // from class: com.baidu.tieba.ala.liveroom.g.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fWG.aDj == 1) {
                e.this.gfL++;
                if (e.this.fWG.aDk <= e.this.gfL) {
                    e.this.kX(true);
                }
            }
        }
    };
    private CustomMessageListener gfP = new CustomMessageListener(2913126) { // from class: com.baidu.tieba.ala.liveroom.g.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.fWG.aDj == 2 && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                e.this.gfK = longValue + e.this.gfK;
                if (e.this.fWG.aDl <= e.this.gfK) {
                    e.this.kX(true);
                }
            }
        }
    };
    private Handler handler = new Handler(Looper.getMainLooper());
    private TbPageContext pageContext;

    public e(TbPageContext tbPageContext, bc bcVar) {
        this.pageContext = tbPageContext;
        this.fWG = bcVar;
        bEk();
    }

    public void s(q qVar) {
        if (this.fWG != null && this.fWG.aDg && qVar.mLiveInfo != null) {
            MessageManager.getInstance().registerListener(this.gfO);
            MessageManager.getInstance().registerListener(this.gfP);
            MessageManager.getInstance().registerListener(this.gfN);
            if (this.fWG.aDj == 3) {
                long j = this.fWG.aDm;
                LiveTimerManager.getInstance().addLiveTimerTask("live_task", qVar.mLiveInfo.live_id, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.g.e.1
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        e.this.kX(true);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, (j <= 0 ? 10L : j) * 1000, true);
            }
        }
    }

    public void onDestroy() {
        LiveTimerManager.getInstance().removeLiveTimerTask("live_task", true);
        MessageManager.getInstance().unRegisterListener(this.gfO);
        MessageManager.getInstance().unRegisterListener(this.gfP);
        MessageManager.getInstance().unRegisterListener(this.gfN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX(boolean z) {
        if (this.fWG != null) {
            if (z) {
                this.gfM = 0;
            }
            HttpMessage httpMessage = new HttpMessage(1021152);
            httpMessage.addParam("task", this.fWG.aDi);
            httpMessage.addParam("zid", ExtraParamsManager.getBaiduzid());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, String str, String str2, final String str3, long j) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (j <= 0) {
                j = 3;
            }
            View inflate = LayoutInflater.from(context).inflate(TbadkCoreApplication.getInst().isMobileBaidu() ? a.h.dialog_task_shoubai : a.h.dialog_task_default, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.j.PlayLevelDialog);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(true);
            dialog.getWindow().getAttributes().gravity = 17;
            ((TextView) inflate.findViewById(a.g.message_textView)).setText(str);
            ((TextView) inflate.findViewById(a.g.tip_textView)).setText(str2);
            View findViewById = inflate.findViewById(a.g.result_layout);
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.g.e.5
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
            this.handler.postDelayed(runnable, 1000 * j);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.e.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(str3)) {
                        BrowserHelper.startInternalWebActivity(context, str3);
                    }
                    e.this.handler.removeCallbacks(runnable);
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                dialog.show();
                onDestroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void bEk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021152, TbConfig.SERVER_ADDRESS + "ala/task/complete");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveTaskResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}

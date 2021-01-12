package com.baidu.tieba.ala.liveroom.h;

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
import com.baidu.live.data.br;
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class e {
    private br hnH;
    private long hxb;
    private int hxc;
    private int hxd;
    private TbPageContext pageContext;
    private HttpMessageListener hxe = new HttpMessageListener(1021152) { // from class: com.baidu.tieba.ala.liveroom.h.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.hasError()) {
                if (e.this.hxd < 2) {
                    e.this.hxd++;
                    e.this.nZ(false);
                } else {
                    return;
                }
            }
            if (httpResponsedMessage instanceof LiveTaskResponseMessage) {
                LiveTaskResponseMessage liveTaskResponseMessage = (LiveTaskResponseMessage) httpResponsedMessage;
                e.this.a(e.this.pageContext.getPageActivity(), liveTaskResponseMessage.message, liveTaskResponseMessage.btnText, TextUtils.isEmpty(liveTaskResponseMessage.scheme) ? liveTaskResponseMessage.url : liveTaskResponseMessage.scheme, liveTaskResponseMessage.hxL);
            }
        }
    };
    private CustomMessageListener hxf = new CustomMessageListener(2913124) { // from class: com.baidu.tieba.ala.liveroom.h.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hnH.aNe == 1) {
                e.this.hxc++;
                if (e.this.hnH.aNf <= e.this.hxc) {
                    e.this.nZ(true);
                }
            }
        }
    };
    private CustomMessageListener hxg = new CustomMessageListener(2913126) { // from class: com.baidu.tieba.ala.liveroom.h.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (e.this.hnH.aNe == 2 && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                e.this.hxb = longValue + e.this.hxb;
                if (e.this.hnH.aNg <= e.this.hxb) {
                    e.this.nZ(true);
                }
            }
        }
    };
    private Handler handler = new Handler(Looper.getMainLooper());

    public e(TbPageContext tbPageContext, br brVar) {
        this.pageContext = tbPageContext;
        this.hnH = brVar;
        cdE();
    }

    public void J(x xVar) {
        if (this.hnH != null && this.hnH.aNb && xVar.mLiveInfo != null) {
            MessageManager.getInstance().registerListener(this.hxf);
            MessageManager.getInstance().registerListener(this.hxg);
            MessageManager.getInstance().registerListener(this.hxe);
            if (this.hnH.aNe == 3) {
                long j = this.hnH.aNh;
                LiveTimerManager.getInstance().addLiveTimerTask("live_task", xVar.mLiveInfo.live_id, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.1
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        e.this.nZ(true);
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
        MessageManager.getInstance().unRegisterListener(this.hxf);
        MessageManager.getInstance().unRegisterListener(this.hxg);
        MessageManager.getInstance().unRegisterListener(this.hxe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ(boolean z) {
        if (this.hnH != null) {
            if (z) {
                this.hxd = 0;
            }
            HttpMessage httpMessage = new HttpMessage(1021152);
            httpMessage.addParam("task", this.hnH.aNd);
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
            View inflate = LayoutInflater.from(context).inflate(TbadkCoreApplication.getInst().isMobileBaidu() ? a.g.dialog_task_shoubai : a.g.dialog_task_default, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.i.PlayLevelDialog);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(true);
            dialog.getWindow().getAttributes().gravity = 17;
            ((TextView) inflate.findViewById(a.f.message_textView)).setText(str);
            ((TextView) inflate.findViewById(a.f.tip_textView)).setText(str2);
            View findViewById = inflate.findViewById(a.f.result_layout);
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.e.5
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
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.e.6
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
                onDestroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void cdE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021152, TbConfig.SERVER_ADDRESS + "ala/task/complete");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveTaskResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}

package com.baidu.tieba.ala.anchortask.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.an.c;
import com.baidu.live.d;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetNewAnchorAssistTaskInfoHttpResponseMessage;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes11.dex */
public class b {
    private ab alaLiveShowData;
    private Context context;
    private int gKT;
    public com.baidu.tieba.ala.anchortask.c.b gLc;
    private com.baidu.tieba.ala.anchortask.b.a gLd;
    private String gLe;
    private String gLf;
    private Handler handler = new Handler();
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(b.this.gLe)) {
                c cVar = new c();
                cVar.url = b.this.gLe;
                cVar.bWs = 510.0f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                b.this.bSF();
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.handler.postDelayed(b.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.bSF();
            b.this.handler.postDelayed(b.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private Runnable gLg = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gLd != null && d.xc().getBoolean("new_anchor_assist_task_show", true)) {
                c cVar = new c();
                cVar.url = b.this.gLd.gLj;
                cVar.bWs = 510.0f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                d.xc().putBoolean("new_anchor_assist_task_show", false);
            }
        }
    };
    private HttpMessageListener gKW = new HttpMessageListener(1021230) { // from class: com.baidu.tieba.ala.anchortask.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetNewAnchorAssistTaskInfoHttpResponseMessage) && b.this.gLc != null) {
                b.this.gLd = ((GetNewAnchorAssistTaskInfoHttpResponseMessage) httpResponsedMessage).gLd;
                if (b.this.gLd != null) {
                    b.this.gLe = b.this.gLd.gLe;
                    b.this.gLf = b.this.gLd.gLf;
                    b.this.gLc.gLM.setText(b.this.gLd.gLk + "");
                    b.this.gLc.gLL.setText(b.this.gLd.gLl + "");
                }
            }
        }
    };

    public b(Context context) {
        this.context = context;
        this.gLc = new com.baidu.tieba.ala.anchortask.c.b(context);
        initTasks();
        if (this.gLc.getView() != null) {
            this.gLc.getView().setOnClickListener(this.onClickListener);
        }
        this.handler.postDelayed(this.runnable, 10000L);
        this.handler.postDelayed(this.gLg, 11000L);
    }

    public void a(ab abVar) {
        this.alaLiveShowData = abVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021230, TbConfig.SERVER_ADDRESS + "ala/live/getNewAnchorAssistTaskInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetNewAnchorAssistTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gKW);
    }

    public void bSF() {
        if (this.alaLiveShowData != null) {
            long j = this.alaLiveShowData.mLiveInfo.live_id;
            long j2 = this.alaLiveShowData.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.b bVar = new com.baidu.tieba.ala.anchortask.message.b();
            bVar.setAnchorId(j2);
            bVar.setLiveId(j);
            bVar.setParams();
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gKW);
        if (this.gLc != null) {
            this.gLc.onDestroy();
        }
    }

    public void ua(int i) {
        this.gKT = i;
        if (i == 0) {
            this.handler.removeCallbacksAndMessages(null);
        }
    }
}

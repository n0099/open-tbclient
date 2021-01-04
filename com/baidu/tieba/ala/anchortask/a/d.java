package com.baidu.tieba.ala.anchortask.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetNewAnchorAssistTaskInfoHttpResponseMessage;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes11.dex */
public class d {
    private x alaLiveShowData;
    private Context context;
    private int gMP;
    public com.baidu.tieba.ala.anchortask.c.b gNc;
    private com.baidu.tieba.ala.anchortask.b.a gNd;
    private String gNe;
    private String gNf;
    private Handler handler = new Handler();
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(d.this.gNe)) {
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.url = d.this.gNe;
                cVar.bXf = 510.0f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                d.this.bVT();
                d.this.handler.removeCallbacksAndMessages(null);
                d.this.handler.postDelayed(d.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bVT();
            d.this.handler.postDelayed(d.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private Runnable gNg = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.d.3
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gNd != null && com.baidu.live.d.Ba().getBoolean("new_anchor_assist_task_show", true)) {
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.url = d.this.gNd.gNj;
                cVar.bXf = 510.0f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                com.baidu.live.d.Ba().putBoolean("new_anchor_assist_task_show", false);
            }
        }
    };
    private HttpMessageListener gMS = new HttpMessageListener(1021230) { // from class: com.baidu.tieba.ala.anchortask.a.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetNewAnchorAssistTaskInfoHttpResponseMessage) && d.this.gNc != null) {
                d.this.gNd = ((GetNewAnchorAssistTaskInfoHttpResponseMessage) httpResponsedMessage).gNd;
                if (d.this.gNd != null) {
                    d.this.gNe = d.this.gNd.gNe;
                    d.this.gNf = d.this.gNd.gNf;
                    d.this.gNc.gNM.setText(d.this.gNd.gNk + "");
                    d.this.gNc.gNL.setText(d.this.gNd.gNl + "");
                }
            }
        }
    };

    public d(Context context) {
        this.context = context;
        this.gNc = new com.baidu.tieba.ala.anchortask.c.b(context);
        initTasks();
        if (this.gNc.getView() != null) {
            this.gNc.getView().setOnClickListener(this.onClickListener);
        }
        this.handler.postDelayed(this.runnable, 10000L);
        this.handler.postDelayed(this.gNg, 11000L);
    }

    public void a(x xVar) {
        this.alaLiveShowData = xVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021230, TbConfig.SERVER_ADDRESS + "ala/live/getNewAnchorAssistTaskInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetNewAnchorAssistTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gMS);
    }

    public void bVT() {
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
        MessageManager.getInstance().unRegisterListener(this.gMS);
        if (this.gNc != null) {
            this.gNc.onDestroy();
        }
    }

    public void vA(int i) {
        this.gMP = i;
        if (i == 0) {
            this.handler.removeCallbacksAndMessages(null);
        }
    }
}

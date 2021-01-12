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
/* loaded from: classes10.dex */
public class d {
    private x alaLiveShowData;
    private Context context;
    private int gIj;
    public com.baidu.tieba.ala.anchortask.c.b gIw;
    private com.baidu.tieba.ala.anchortask.b.a gIx;
    private String gIy;
    private String gIz;
    private Handler handler = new Handler();
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(d.this.gIy)) {
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.url = d.this.gIy;
                cVar.bSt = 510.0f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                d.this.bSc();
                d.this.handler.removeCallbacksAndMessages(null);
                d.this.handler.postDelayed(d.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bSc();
            d.this.handler.postDelayed(d.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private Runnable gIA = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.d.3
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gIx != null && com.baidu.live.d.xf().getBoolean("new_anchor_assist_task_show", true)) {
                com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                cVar.url = d.this.gIx.gID;
                cVar.bSt = 510.0f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                com.baidu.live.d.xf().putBoolean("new_anchor_assist_task_show", false);
            }
        }
    };
    private HttpMessageListener gIm = new HttpMessageListener(1021230) { // from class: com.baidu.tieba.ala.anchortask.a.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetNewAnchorAssistTaskInfoHttpResponseMessage) && d.this.gIw != null) {
                d.this.gIx = ((GetNewAnchorAssistTaskInfoHttpResponseMessage) httpResponsedMessage).gIx;
                if (d.this.gIx != null) {
                    d.this.gIy = d.this.gIx.gIy;
                    d.this.gIz = d.this.gIx.gIz;
                    d.this.gIw.gJg.setText(d.this.gIx.gIE + "");
                    d.this.gIw.gJf.setText(d.this.gIx.gIF + "");
                }
            }
        }
    };

    public d(Context context) {
        this.context = context;
        this.gIw = new com.baidu.tieba.ala.anchortask.c.b(context);
        initTasks();
        if (this.gIw.getView() != null) {
            this.gIw.getView().setOnClickListener(this.onClickListener);
        }
        this.handler.postDelayed(this.runnable, 10000L);
        this.handler.postDelayed(this.gIA, 11000L);
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
        MessageManager.getInstance().registerListener(this.gIm);
    }

    public void bSc() {
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
        MessageManager.getInstance().unRegisterListener(this.gIm);
        if (this.gIw != null) {
            this.gIw.onDestroy();
        }
    }

    public void tU(int i) {
        this.gIj = i;
        if (i == 0) {
            this.handler.removeCallbacksAndMessages(null);
        }
    }
}

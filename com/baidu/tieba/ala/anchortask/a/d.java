package com.baidu.tieba.ala.anchortask.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetNewAnchorAssistTaskInfoHttpResponseMessage;
/* loaded from: classes4.dex */
public class d {
    private w alaLiveShowData;
    private Context context;
    private int gBf;
    public com.baidu.tieba.ala.anchortask.c.b gBq;
    private com.baidu.tieba.ala.anchortask.b.a gBr;
    private String gBs;
    private String gBt;
    private Handler handler = new Handler();
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(d.this.gBs)) {
                com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
                cVar.url = d.this.gBs;
                cVar.bRy = 510.0f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                d.this.bTo();
                d.this.handler.removeCallbacksAndMessages(null);
                d.this.handler.postDelayed(d.this.runnable, 60000L);
            }
        }
    };
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bTo();
            d.this.handler.postDelayed(d.this.runnable, 60000L);
        }
    };
    private Runnable gBu = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.d.3
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gBr != null && com.baidu.live.d.BM().getBoolean("new_anchor_assist_task_show", true)) {
                com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
                cVar.url = d.this.gBr.gBx;
                cVar.bRy = 510.0f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                com.baidu.live.d.BM().putBoolean("new_anchor_assist_task_show", false);
            }
        }
    };
    private HttpMessageListener gBi = new HttpMessageListener(1021230) { // from class: com.baidu.tieba.ala.anchortask.a.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetNewAnchorAssistTaskInfoHttpResponseMessage) && d.this.gBq != null) {
                d.this.gBr = ((GetNewAnchorAssistTaskInfoHttpResponseMessage) httpResponsedMessage).gBr;
                if (d.this.gBr != null) {
                    d.this.gBs = d.this.gBr.gBs;
                    d.this.gBt = d.this.gBr.gBt;
                    d.this.gBq.gCa.setText(d.this.gBr.gBy + "");
                    d.this.gBq.gBZ.setText(d.this.gBr.gBz + "");
                }
            }
        }
    };

    public d(Context context) {
        this.context = context;
        this.gBq = new com.baidu.tieba.ala.anchortask.c.b(context);
        initTasks();
        if (this.gBq.getView() != null) {
            this.gBq.getView().setOnClickListener(this.foP);
        }
        this.handler.postDelayed(this.runnable, 10000L);
        this.handler.postDelayed(this.gBu, 11000L);
    }

    public void a(w wVar) {
        this.alaLiveShowData = wVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021230, TbConfig.SERVER_ADDRESS + "ala/live/getNewAnchorAssistTaskInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetNewAnchorAssistTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gBi);
    }

    public void bTo() {
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
        MessageManager.getInstance().unRegisterListener(this.gBi);
        if (this.gBq != null) {
            this.gBq.onDestroy();
        }
    }

    public void vp(int i) {
        this.gBf = i;
        if (i == 0) {
            this.handler.removeCallbacksAndMessages(null);
        }
    }
}

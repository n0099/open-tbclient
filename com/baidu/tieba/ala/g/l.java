package com.baidu.tieba.ala.g;

import android.os.Handler;
import android.os.Looper;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.messages.GetPkInfoResponseMessage;
/* loaded from: classes11.dex */
public class l extends BdBaseModel {
    private int hUg;
    private long liveID;
    private HttpMessageListener messageListener;
    private long pkID;
    private long roomID;
    private long userID;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable hUh = new Runnable() { // from class: com.baidu.tieba.ala.g.l.3
        @Override // java.lang.Runnable
        public void run() {
            l.this.a(l.this.userID, l.this.pkID, l.this.roomID, l.this.liveID, l.this.hUg);
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void a(PkInfoData pkInfoData);

        void bw(int i, String str);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(long j, long j2, long j3, long j4, int i) {
        this.mHandler.removeCallbacks(this.hUh);
        this.userID = j;
        this.pkID = j2;
        this.roomID = j3;
        this.liveID = j4;
        this.hUg = i;
        HttpMessage httpMessage = new HttpMessage(1021213);
        httpMessage.addParam("anchor_id", j);
        httpMessage.addParam("pk_id", j2);
        httpMessage.addParam("room_id", j3);
        httpMessage.addParam("live_id", j4);
        httpMessage.addParam("is_host", i);
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        cme();
        b(aVar);
    }

    private void b(final a aVar) {
        this.messageListener = new HttpMessageListener(1021213) { // from class: com.baidu.tieba.ala.g.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1021213 && (httpResponsedMessage instanceof GetPkInfoResponseMessage)) {
                    final GetPkInfoResponseMessage getPkInfoResponseMessage = (GetPkInfoResponseMessage) httpResponsedMessage;
                    l.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.g.l.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!getPkInfoResponseMessage.isSuccess()) {
                                aVar.bw(getPkInfoResponseMessage.getError(), getPkInfoResponseMessage.getErrorString());
                                l.this.mHandler.postDelayed(l.this.hUh, 2000L);
                            } else if (getPkInfoResponseMessage.clT() == null) {
                                l.this.mHandler.postDelayed(l.this.hUh, 5000L);
                            } else {
                                aVar.a(getPkInfoResponseMessage.clT());
                                l.this.mHandler.postDelayed(l.this.hUh, getPkInfoResponseMessage.clT().pkInfoInterval);
                            }
                        }
                    });
                }
            }
        };
        registerListener(this.messageListener);
    }

    private void cme() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021213, TbConfig.SERVER_ADDRESS + "ala/pksolo/getPkInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GetPkInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cmf() {
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterTask(1021213);
    }

    public void cmg() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.g.l.2
            @Override // java.lang.Runnable
            public void run() {
                l.this.mHandler.removeCallbacks(l.this.hUh);
            }
        });
    }
}

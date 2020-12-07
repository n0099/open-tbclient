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
/* loaded from: classes4.dex */
public class l extends BdBaseModel {
    private Runnable hIo;
    boolean loop = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private HttpMessageListener messageListener;

    /* loaded from: classes4.dex */
    public interface a {
        void a(PkInfoData pkInfoData);

        void bo(int i, String str);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(final long j, final long j2, final long j3, final long j4, final int i) {
        this.loop = true;
        this.hIo = new Runnable() { // from class: com.baidu.tieba.ala.g.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.a(j, j2, j3, j4, i);
            }
        };
        HttpMessage httpMessage = new HttpMessage(1021213);
        httpMessage.addParam("anchor_id", j);
        httpMessage.addParam("pk_id", j2);
        httpMessage.addParam("room_id", j3);
        httpMessage.addParam("live_id", j4);
        httpMessage.addParam("is_host", i);
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        cmf();
        b(aVar);
    }

    private void b(final a aVar) {
        this.messageListener = new HttpMessageListener(1021213) { // from class: com.baidu.tieba.ala.g.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1021213 && (httpResponsedMessage instanceof GetPkInfoResponseMessage)) {
                    GetPkInfoResponseMessage getPkInfoResponseMessage = (GetPkInfoResponseMessage) httpResponsedMessage;
                    if (!getPkInfoResponseMessage.isSuccess()) {
                        aVar.bo(getPkInfoResponseMessage.getError(), getPkInfoResponseMessage.getErrorString());
                        if (l.this.loop) {
                            l.this.mHandler.postDelayed(l.this.hIo, 2000L);
                        }
                    } else if (getPkInfoResponseMessage.clU() != null) {
                        aVar.a(getPkInfoResponseMessage.clU());
                        if (l.this.loop) {
                            l.this.mHandler.postDelayed(l.this.hIo, getPkInfoResponseMessage.clU().pkInfoInterval);
                        }
                    } else if (l.this.loop) {
                        l.this.mHandler.postDelayed(l.this.hIo, 5000L);
                    }
                }
            }
        };
        registerListener(this.messageListener);
    }

    private void cmf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021213, TbConfig.SERVER_ADDRESS + "ala/pksolo/getPkInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GetPkInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cmg() {
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterTask(1021213);
    }

    public void hJ(boolean z) {
        this.loop = z;
    }

    public boolean isLoop() {
        return this.loop;
    }
}

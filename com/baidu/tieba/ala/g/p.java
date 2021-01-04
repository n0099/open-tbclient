package com.baidu.tieba.ala.g;

import android.os.Handler;
import android.os.Looper;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.messages.StartPkResponseMessage;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class p extends BdBaseModel {
    private HttpMessageListener messageListener;
    long userID = -1;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean loop = false;
    private Runnable hUz = new Runnable() { // from class: com.baidu.tieba.ala.g.p.2
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.userID != -1) {
                p.this.fL(p.this.userID);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void ak(ArrayList<String> arrayList);

        void bn(int i, String str);

        void cpc();

        void fM(long j);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void fL(long j) {
        this.loop = true;
        this.userID = j;
        HttpMessage httpMessage = new HttpMessage(1021210);
        httpMessage.addParam("anchor_id", j);
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        coZ();
        b(aVar);
    }

    private void b(final a aVar) {
        this.messageListener = new HttpMessageListener(1021210) { // from class: com.baidu.tieba.ala.g.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1021210) {
                    StartPkResponseMessage startPkResponseMessage = (StartPkResponseMessage) httpResponsedMessage;
                    if (!startPkResponseMessage.isSuccess()) {
                        aVar.bn(startPkResponseMessage.getError(), startPkResponseMessage.getErrorString());
                        p.this.mHandler.removeCallbacks(p.this.hUz);
                        p.this.mHandler.postDelayed(p.this.hUz, 2000L);
                    } else if (startPkResponseMessage.coO().isEmpty()) {
                        p.this.mHandler.removeCallbacks(p.this.hUz);
                        p.this.mHandler.postDelayed(p.this.hUz, 2000L);
                    } else if (startPkResponseMessage.coN() == 2) {
                        p.this.cpb();
                        aVar.cpc();
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("lodId", Long.valueOf(startPkResponseMessage.getLogId()));
                        AlaStatManager.getInstance().debug("pk_competition_match_failed", alaStatsItem);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("lodId", Long.valueOf(startPkResponseMessage.getLogId()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_match_failed", "author_liveroom", "").setContentExt(jSONObject));
                    } else if (startPkResponseMessage.coL() <= 0) {
                        if (p.this.loop) {
                            aVar.ak(startPkResponseMessage.coO());
                            p.this.mHandler.removeCallbacks(p.this.hUz);
                            p.this.mHandler.postDelayed(p.this.hUz, startPkResponseMessage.getInterval() * 1000);
                        }
                    } else {
                        p.this.cpb();
                        aVar.fM(startPkResponseMessage.coL());
                    }
                }
            }
        };
        registerListener(this.messageListener);
    }

    private void coZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021210, TbConfig.SERVER_ADDRESS + "ala/pksolo/startPk");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(StartPkResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cpa() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterTask(1021210);
    }

    public void cpb() {
        this.mHandler.removeCallbacks(this.hUz);
        this.loop = false;
    }
}

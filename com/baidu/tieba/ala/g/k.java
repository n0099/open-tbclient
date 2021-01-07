package com.baidu.tieba.ala.g;

import com.baidu.android.util.io.BaseJsonData;
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
import com.baidu.tieba.ala.messages.CancelPkResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class k extends BdBaseModel {
    private HttpMessageListener messageListener;

    /* loaded from: classes11.dex */
    public interface a {
        void bp(int i, String str);

        void coX();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void fK(long j) {
        HttpMessage httpMessage = new HttpMessage(1021212);
        httpMessage.addParam("anchor_id", j);
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        coV();
        b(aVar);
    }

    private void b(final a aVar) {
        this.messageListener = new HttpMessageListener(1021212) { // from class: com.baidu.tieba.ala.g.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021212 && (httpResponsedMessage instanceof CancelPkResponseMessage)) {
                    CancelPkResponseMessage cancelPkResponseMessage = (CancelPkResponseMessage) httpResponsedMessage;
                    if (cancelPkResponseMessage.getError() != 0 || !cancelPkResponseMessage.isSuccess()) {
                        aVar.bp(cancelPkResponseMessage.getError(), cancelPkResponseMessage.getErrorString());
                        return;
                    }
                    aVar.coX();
                    AlaStatsItem alaStatsItem = new AlaStatsItem();
                    alaStatsItem.addValue("lodId", Long.valueOf(cancelPkResponseMessage.getLogId()));
                    alaStatsItem.addValue(BaseJsonData.TAG_ERRNO, Integer.valueOf(cancelPkResponseMessage.getError()));
                    AlaStatManager.getInstance().debug("pk_competition_cancel_match", alaStatsItem);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("lodId", Long.valueOf(cancelPkResponseMessage.getLogId()));
                        jSONObject.putOpt(BaseJsonData.TAG_ERRNO, Integer.valueOf(cancelPkResponseMessage.getError()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_cancel_match", "author_liveroom", "").setContentExt(jSONObject));
                }
            }
        };
        registerListener(this.messageListener);
    }

    private void coV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021212, TbConfig.SERVER_ADDRESS + "ala/pksolo/cancelPk");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(CancelPkResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void coW() {
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterTask(1021212);
    }
}

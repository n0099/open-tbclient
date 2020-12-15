package com.baidu.tieba.ala;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject ggU;
    private HttpMessageListener ggV;
    private BdUniqueId ggW = BdUniqueId.gen();
    private BdUniqueId ggX = BdUniqueId.gen();
    private CustomMessageListener fVY = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetworkAvailableForImmediately() && a.this.ggU != null) {
                a.this.a(a.this.ggU, a.this.ggX);
            }
        }
    };
    private CustomMessageListener ggY = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.ala.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.dt((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        if (this.ggV == null) {
            this.ggV = new HttpMessageListener(1003390) { // from class: com.baidu.tieba.ala.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003390 && httpResponsedMessage.getError() == 0) {
                        a.this.ggU = null;
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ggV);
        MessageManager.getInstance().registerListener(this.fVY);
        this.ggY.setTag(tbPageContext.getUniqueId());
        this.ggY.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ggY);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ggV);
        MessageManager.getInstance().unRegisterListener(this.fVY);
        MessageManager.getInstance().unRegisterListener(this.ggY);
        this.ggU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.isNetworkAvailableForImmediately()) {
                a(jSONObject, this.ggW);
            } else {
                this.ggU = jSONObject;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, BdUniqueId bdUniqueId) {
        int i = 1;
        if (jSONObject != null) {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString("fid");
            String optString3 = jSONObject.optString("dislike_ids");
            String optString4 = jSONObject.optString("type");
            if ("ala_frs_stage_live_feed_back_type".equals(optString4)) {
                i = 2;
            } else if ("ala_frs_demo_hell_live_feed_back_type".equals(optString4)) {
            }
            HttpMessage httpMessage = new HttpMessage(1003390);
            httpMessage.addParam("thread_id", optString);
            httpMessage.addParam("forum_id", optString2);
            httpMessage.addParam("dislike_reason_id", optString3);
            httpMessage.addParam("reason_type", i);
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}

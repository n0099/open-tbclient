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
    private JSONObject fjZ;
    private HttpMessageListener fka;
    private BdUniqueId fkb = BdUniqueId.gen();
    private BdUniqueId fkc = BdUniqueId.gen();
    private CustomMessageListener eZV = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetworkAvailableForImmediately() && a.this.fjZ != null) {
                a.this.a(a.this.fjZ, a.this.fkc);
            }
        }
    };
    private CustomMessageListener fkd = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.ala.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.cY((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        if (this.fka == null) {
            this.fka = new HttpMessageListener(1003390) { // from class: com.baidu.tieba.ala.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003390 && httpResponsedMessage.getError() == 0) {
                        a.this.fjZ = null;
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.fka);
        MessageManager.getInstance().registerListener(this.eZV);
        this.fkd.setTag(tbPageContext.getUniqueId());
        this.fkd.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fkd);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fka);
        MessageManager.getInstance().unRegisterListener(this.eZV);
        MessageManager.getInstance().unRegisterListener(this.fkd);
        this.fjZ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.isNetworkAvailableForImmediately()) {
                a(jSONObject, this.fkb);
            } else {
                this.fjZ = jSONObject;
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

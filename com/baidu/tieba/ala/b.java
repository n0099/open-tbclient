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
public class b {
    private JSONObject grs;
    private HttpMessageListener grt;
    private BdUniqueId gru = BdUniqueId.gen();
    private BdUniqueId grv = BdUniqueId.gen();
    private CustomMessageListener gfE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetworkAvailableForImmediately() && b.this.grs != null) {
                b.this.a(b.this.grs, b.this.grv);
            }
        }
    };
    private CustomMessageListener grw = new CustomMessageListener(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.ala.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                b.this.dC((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        if (this.grt == null) {
            this.grt = new HttpMessageListener(1003390) { // from class: com.baidu.tieba.ala.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003390 && httpResponsedMessage.getError() == 0) {
                        b.this.grs = null;
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.grt);
        MessageManager.getInstance().registerListener(this.gfE);
        this.grw.setTag(tbPageContext.getUniqueId());
        this.grw.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.grw);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.grt);
        MessageManager.getInstance().unRegisterListener(this.gfE);
        MessageManager.getInstance().unRegisterListener(this.grw);
        this.grs = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.isNetworkAvailableForImmediately()) {
                a(jSONObject, this.gru);
            } else {
                this.grs = jSONObject;
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

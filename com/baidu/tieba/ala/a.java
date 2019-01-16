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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONObject bKO;
    private HttpMessageListener bKP;
    private BdUniqueId bKQ = BdUniqueId.gen();
    private BdUniqueId bKR = BdUniqueId.gen();
    private CustomMessageListener bxt = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.ala.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kK() && a.this.bKO != null) {
                a.this.a(a.this.bKO, a.this.bKR);
            }
        }
    };
    private CustomMessageListener bKS = new CustomMessageListener(2921324) { // from class: com.baidu.tieba.ala.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.R((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        if (this.bKP == null) {
            this.bKP = new HttpMessageListener(CmdConfigHttp.CMD_FRS_STAGE_FEED_BACK) { // from class: com.baidu.tieba.ala.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003390 && httpResponsedMessage.getError() == 0) {
                        a.this.bKO = null;
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bKP);
        MessageManager.getInstance().registerListener(this.bxt);
        this.bKS.setTag(tbPageContext.getUniqueId());
        this.bKS.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bKS);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bKP);
        MessageManager.getInstance().unRegisterListener(this.bxt);
        MessageManager.getInstance().unRegisterListener(this.bKS);
        this.bKO = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.kK()) {
                a(jSONObject, this.bKQ);
            } else {
                this.bKO = jSONObject;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, BdUniqueId bdUniqueId) {
        int i = 1;
        if (jSONObject != null) {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(ImageViewerConfig.FORUM_ID);
            String optString3 = jSONObject.optString("dislike_ids");
            String optString4 = jSONObject.optString("type");
            if ("ala_frs_stage_live_feed_back_type".equals(optString4)) {
                i = 2;
            } else if ("ala_frs_demo_hell_live_feed_back_type".equals(optString4)) {
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_STAGE_FEED_BACK);
            httpMessage.addParam("thread_id", optString);
            httpMessage.addParam("forum_id", optString2);
            httpMessage.addParam("dislike_reason_id", optString3);
            httpMessage.addParam("reason_type", i);
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}

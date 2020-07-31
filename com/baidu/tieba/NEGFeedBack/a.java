package com.baidu.tieba.NEGFeedBack;

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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONArray eZR;
    private HttpMessageListener eZS;
    private BdUniqueId eZT = BdUniqueId.gen();
    private BdUniqueId eZU = BdUniqueId.gen();
    private CustomMessageListener eZV = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetworkAvailableForImmediately() && a.this.eZR != null) {
                a.this.a(a.this.eZR, a.this.eZU);
            }
        }
    };
    private CustomMessageListener eZW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.cV((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.eZS == null) {
            this.eZS = new HttpMessageListener(1003184) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.eZR = null;
                    }
                }
            };
        }
        this.eZS.setTag(this.eZU);
        MessageManager.getInstance().registerListener(this.eZS);
        MessageManager.getInstance().registerListener(this.eZV);
        this.eZW.setTag(tbPageContext.getUniqueId());
        this.eZW.setSelfListener(true);
        this.eZW.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.eZW);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eZS);
        MessageManager.getInstance().unRegisterListener(this.eZV);
        MessageManager.getInstance().unRegisterListener(this.eZW);
        this.eZR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.isNetworkAvailableForImmediately()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.eZT);
                return;
            }
            if (this.eZR == null) {
                this.eZR = new JSONArray();
            }
            if (this.eZR.length() <= 100) {
                this.eZR.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1003184);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.mFrom);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

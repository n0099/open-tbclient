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
    private JSONArray fVU;
    private HttpMessageListener fVV;
    private BdUniqueId fVW = BdUniqueId.gen();
    private BdUniqueId fVX = BdUniqueId.gen();
    private CustomMessageListener fVY = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetworkAvailableForImmediately() && a.this.fVU != null) {
                a.this.a(a.this.fVU, a.this.fVX);
            }
        }
    };
    private CustomMessageListener fVZ = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.dq((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.fVV == null) {
            this.fVV = new HttpMessageListener(1003184) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.fVU = null;
                    }
                }
            };
        }
        this.fVV.setTag(this.fVX);
        MessageManager.getInstance().registerListener(this.fVV);
        MessageManager.getInstance().registerListener(this.fVY);
        this.fVZ.setTag(tbPageContext.getUniqueId());
        this.fVZ.setSelfListener(true);
        this.fVZ.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.fVZ);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fVV);
        MessageManager.getInstance().unRegisterListener(this.fVY);
        MessageManager.getInstance().unRegisterListener(this.fVZ);
        this.fVU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.isNetworkAvailableForImmediately()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.fVW);
                return;
            }
            if (this.fVU == null) {
                this.fVU = new JSONArray();
            }
            if (this.fVU.length() <= 100) {
                this.fVU.put(jSONObject);
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

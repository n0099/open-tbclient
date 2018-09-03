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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONArray biB;
    private HttpMessageListener biC;
    private BdUniqueId biD = BdUniqueId.gen();
    private BdUniqueId biE = BdUniqueId.gen();
    private CustomMessageListener biF = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.js() && a.this.biB != null) {
                a.this.a(a.this.biB, a.this.biE);
            }
        }
    };
    private CustomMessageListener biG = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.v((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.biC == null) {
            this.biC = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.biB = null;
                    }
                }
            };
        }
        this.biC.setTag(this.biE);
        MessageManager.getInstance().registerListener(this.biC);
        MessageManager.getInstance().registerListener(this.biF);
        this.biG.setTag(tbPageContext.getUniqueId());
        this.biG.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.biG);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.biC);
        MessageManager.getInstance().unRegisterListener(this.biF);
        MessageManager.getInstance().unRegisterListener(this.biG);
        this.biB = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.js()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.biD);
                return;
            }
            if (this.biB == null) {
                this.biB = new JSONArray();
            }
            if (this.biB.length() <= 100) {
                this.biB.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.mFrom);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

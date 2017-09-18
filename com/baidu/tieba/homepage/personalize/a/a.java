package com.baidu.tieba.homepage.personalize.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public JSONArray dbR;
    private HttpMessageListener dbS;
    private BdUniqueId dbT = BdUniqueId.gen();
    private BdUniqueId dbU = BdUniqueId.gen();
    private CustomMessageListener dbV = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.homepage.personalize.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.gW() && a.this.dbR != null) {
                a.this.a(a.this.dbR, a.this.dbU);
            }
        }
    };
    private CustomMessageListener dbW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.u((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a() {
        if (this.dbS == null) {
            this.dbS = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.dbR = null;
                    }
                }
            };
        }
        this.dbS.setTag(this.dbU);
        MessageManager.getInstance().registerListener(this.dbS);
        MessageManager.getInstance().registerListener(this.dbV);
        MessageManager.getInstance().registerListener(this.dbW);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dbS);
        MessageManager.getInstance().unRegisterListener(this.dbV);
        MessageManager.getInstance().unRegisterListener(this.dbW);
        this.dbR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gW()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.dbT);
                return;
            }
            if (this.dbR == null) {
                this.dbR = new JSONArray();
            }
            if (this.dbR.length() <= 100) {
                this.dbR.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

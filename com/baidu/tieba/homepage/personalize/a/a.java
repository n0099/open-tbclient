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
    public JSONArray cUu;
    private HttpMessageListener cUv;
    private BdUniqueId cUw = BdUniqueId.gen();
    private BdUniqueId cUx = BdUniqueId.gen();
    private CustomMessageListener cUy = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.homepage.personalize.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hf() && a.this.cUu != null) {
                a.this.a(a.this.cUu, a.this.cUx);
            }
        }
    };
    private CustomMessageListener cUz = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.p((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a() {
        if (this.cUv == null) {
            this.cUv = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cUu = null;
                    }
                }
            };
        }
        this.cUv.setTag(this.cUx);
        MessageManager.getInstance().registerListener(this.cUv);
        MessageManager.getInstance().registerListener(this.cUy);
        MessageManager.getInstance().registerListener(this.cUz);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cUv);
        MessageManager.getInstance().unRegisterListener(this.cUy);
        MessageManager.getInstance().unRegisterListener(this.cUz);
        this.cUu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.hf()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cUw);
                return;
            }
            if (this.cUu == null) {
                this.cUu = new JSONArray();
            }
            if (this.cUu.length() <= 100) {
                this.cUu.put(jSONObject);
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

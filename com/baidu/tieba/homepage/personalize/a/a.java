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
    public JSONArray cRc;
    private HttpMessageListener cRd;
    private BdUniqueId cRe = BdUniqueId.gen();
    private BdUniqueId cRf = BdUniqueId.gen();
    private CustomMessageListener cRg = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.homepage.personalize.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.gV() && a.this.cRc != null) {
                a.this.a(a.this.cRc, a.this.cRf);
            }
        }
    };
    private CustomMessageListener cRh = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.o((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a() {
        if (this.cRd == null) {
            this.cRd = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cRc = null;
                    }
                }
            };
        }
        this.cRd.setTag(this.cRf);
        MessageManager.getInstance().registerListener(this.cRd);
        MessageManager.getInstance().registerListener(this.cRg);
        MessageManager.getInstance().registerListener(this.cRh);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cRd);
        MessageManager.getInstance().unRegisterListener(this.cRg);
        MessageManager.getInstance().unRegisterListener(this.cRh);
        this.cRc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gV()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cRe);
                return;
            }
            if (this.cRc == null) {
                this.cRc = new JSONArray();
            }
            if (this.cRc.length() <= 100) {
                this.cRc.put(jSONObject);
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

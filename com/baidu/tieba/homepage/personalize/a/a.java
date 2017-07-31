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
    public JSONArray cSv;
    private HttpMessageListener cSw;
    private BdUniqueId cSx = BdUniqueId.gen();
    private BdUniqueId cSy = BdUniqueId.gen();
    private CustomMessageListener cSz = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.homepage.personalize.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hf() && a.this.cSv != null) {
                a.this.a(a.this.cSv, a.this.cSy);
            }
        }
    };
    private CustomMessageListener cSA = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.o((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a() {
        if (this.cSw == null) {
            this.cSw = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cSv = null;
                    }
                }
            };
        }
        this.cSw.setTag(this.cSy);
        MessageManager.getInstance().registerListener(this.cSw);
        MessageManager.getInstance().registerListener(this.cSz);
        MessageManager.getInstance().registerListener(this.cSA);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cSw);
        MessageManager.getInstance().unRegisterListener(this.cSz);
        MessageManager.getInstance().unRegisterListener(this.cSA);
        this.cSv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.hf()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cSx);
                return;
            }
            if (this.cSv == null) {
                this.cSv = new JSONArray();
            }
            if (this.cSv.length() <= 100) {
                this.cSv.put(jSONObject);
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

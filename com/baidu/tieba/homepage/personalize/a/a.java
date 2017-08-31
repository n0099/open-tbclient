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
    public JSONArray daX;
    private HttpMessageListener daY;
    private BdUniqueId daZ = BdUniqueId.gen();
    private BdUniqueId dba = BdUniqueId.gen();
    private CustomMessageListener dbb = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.homepage.personalize.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.gW() && a.this.daX != null) {
                a.this.a(a.this.daX, a.this.dba);
            }
        }
    };
    private CustomMessageListener dbc = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.homepage.personalize.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.u((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a() {
        if (this.daY == null) {
            this.daY = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.homepage.personalize.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.daX = null;
                    }
                }
            };
        }
        this.daY.setTag(this.dba);
        MessageManager.getInstance().registerListener(this.daY);
        MessageManager.getInstance().registerListener(this.dbb);
        MessageManager.getInstance().registerListener(this.dbc);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.daY);
        MessageManager.getInstance().unRegisterListener(this.dbb);
        MessageManager.getInstance().unRegisterListener(this.dbc);
        this.daX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gW()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.daZ);
                return;
            }
            if (this.daX == null) {
                this.daX = new JSONArray();
            }
            if (this.daX.length() <= 100) {
                this.daX.put(jSONObject);
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

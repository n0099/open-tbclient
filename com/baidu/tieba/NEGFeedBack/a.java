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
    private JSONArray cQF;
    private HttpMessageListener cQG;
    private BdUniqueId cQH = BdUniqueId.gen();
    private BdUniqueId cQI = BdUniqueId.gen();
    private CustomMessageListener cQJ = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jG() && a.this.cQF != null) {
                a.this.a(a.this.cQF, a.this.cQI);
            }
        }
    };
    private CustomMessageListener cQK = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.be((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.cQG == null) {
            this.cQG = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cQF = null;
                    }
                }
            };
        }
        this.cQG.setTag(this.cQI);
        MessageManager.getInstance().registerListener(this.cQG);
        MessageManager.getInstance().registerListener(this.cQJ);
        this.cQK.setTag(tbPageContext.getUniqueId());
        this.cQK.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cQK);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cQG);
        MessageManager.getInstance().unRegisterListener(this.cQJ);
        MessageManager.getInstance().unRegisterListener(this.cQK);
        this.cQF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.jG()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cQH);
                return;
            }
            if (this.cQF == null) {
                this.cQF = new JSONArray();
            }
            if (this.cQF.length() <= 100) {
                this.cQF.put(jSONObject);
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

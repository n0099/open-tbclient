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
    private JSONArray cQE;
    private HttpMessageListener cQF;
    private BdUniqueId cQG = BdUniqueId.gen();
    private BdUniqueId cQH = BdUniqueId.gen();
    private CustomMessageListener cQI = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jG() && a.this.cQE != null) {
                a.this.a(a.this.cQE, a.this.cQH);
            }
        }
    };
    private CustomMessageListener cQJ = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
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
        if (this.cQF == null) {
            this.cQF = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cQE = null;
                    }
                }
            };
        }
        this.cQF.setTag(this.cQH);
        MessageManager.getInstance().registerListener(this.cQF);
        MessageManager.getInstance().registerListener(this.cQI);
        this.cQJ.setTag(tbPageContext.getUniqueId());
        this.cQJ.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cQJ);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cQF);
        MessageManager.getInstance().unRegisterListener(this.cQI);
        MessageManager.getInstance().unRegisterListener(this.cQJ);
        this.cQE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.jG()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cQG);
                return;
            }
            if (this.cQE == null) {
                this.cQE = new JSONArray();
            }
            if (this.cQE.length() <= 100) {
                this.cQE.put(jSONObject);
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

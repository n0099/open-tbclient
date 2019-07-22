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
    private JSONArray cSb;
    private HttpMessageListener cSc;
    private BdUniqueId cSd = BdUniqueId.gen();
    private BdUniqueId cSe = BdUniqueId.gen();
    private CustomMessageListener cSf = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jQ() && a.this.cSb != null) {
                a.this.a(a.this.cSb, a.this.cSe);
            }
        }
    };
    private CustomMessageListener cSg = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
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
        if (this.cSc == null) {
            this.cSc = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cSb = null;
                    }
                }
            };
        }
        this.cSc.setTag(this.cSe);
        MessageManager.getInstance().registerListener(this.cSc);
        MessageManager.getInstance().registerListener(this.cSf);
        this.cSg.setTag(tbPageContext.getUniqueId());
        this.cSg.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cSg);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cSc);
        MessageManager.getInstance().unRegisterListener(this.cSf);
        MessageManager.getInstance().unRegisterListener(this.cSg);
        this.cSb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.jQ()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cSd);
                return;
            }
            if (this.cSb == null) {
                this.cSb = new JSONArray();
            }
            if (this.cSb.length() <= 100) {
                this.cSb.put(jSONObject);
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

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
    private JSONArray cTb;
    private HttpMessageListener cTc;
    private BdUniqueId cTd = BdUniqueId.gen();
    private BdUniqueId cTe = BdUniqueId.gen();
    private CustomMessageListener cTf = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jQ() && a.this.cTb != null) {
                a.this.a(a.this.cTb, a.this.cTe);
            }
        }
    };
    private CustomMessageListener cTg = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
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
        if (this.cTc == null) {
            this.cTc = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cTb = null;
                    }
                }
            };
        }
        this.cTc.setTag(this.cTe);
        MessageManager.getInstance().registerListener(this.cTc);
        MessageManager.getInstance().registerListener(this.cTf);
        this.cTg.setTag(tbPageContext.getUniqueId());
        this.cTg.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cTg);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cTc);
        MessageManager.getInstance().unRegisterListener(this.cTf);
        MessageManager.getInstance().unRegisterListener(this.cTg);
        this.cTb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.jQ()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cTd);
                return;
            }
            if (this.cTb == null) {
                this.cTb = new JSONArray();
            }
            if (this.cTb.length() <= 100) {
                this.cTb.put(jSONObject);
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

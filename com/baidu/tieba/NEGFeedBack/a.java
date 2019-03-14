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
    private JSONArray cIr;
    private HttpMessageListener cIs;
    private BdUniqueId cIt = BdUniqueId.gen();
    private BdUniqueId cIu = BdUniqueId.gen();
    private CustomMessageListener cIv = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kM() && a.this.cIr != null) {
                a.this.a(a.this.cIr, a.this.cIu);
            }
        }
    };
    private CustomMessageListener cIw = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.aS((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.cIs == null) {
            this.cIs = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cIr = null;
                    }
                }
            };
        }
        this.cIs.setTag(this.cIu);
        MessageManager.getInstance().registerListener(this.cIs);
        MessageManager.getInstance().registerListener(this.cIv);
        this.cIw.setTag(tbPageContext.getUniqueId());
        this.cIw.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cIw);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIs);
        MessageManager.getInstance().unRegisterListener(this.cIv);
        MessageManager.getInstance().unRegisterListener(this.cIw);
        this.cIr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.kM()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cIt);
                return;
            }
            if (this.cIr == null) {
                this.cIr = new JSONArray();
            }
            if (this.cIr.length() <= 100) {
                this.cIr.put(jSONObject);
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

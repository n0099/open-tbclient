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
    private JSONArray cIu;
    private HttpMessageListener cIv;
    private BdUniqueId cIw = BdUniqueId.gen();
    private BdUniqueId cIx = BdUniqueId.gen();
    private CustomMessageListener cIy = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kM() && a.this.cIu != null) {
                a.this.a(a.this.cIu, a.this.cIx);
            }
        }
    };
    private CustomMessageListener cIz = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
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
        if (this.cIv == null) {
            this.cIv = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.cIu = null;
                    }
                }
            };
        }
        this.cIv.setTag(this.cIx);
        MessageManager.getInstance().registerListener(this.cIv);
        MessageManager.getInstance().registerListener(this.cIy);
        this.cIz.setTag(tbPageContext.getUniqueId());
        this.cIz.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cIz);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIv);
        MessageManager.getInstance().unRegisterListener(this.cIy);
        MessageManager.getInstance().unRegisterListener(this.cIz);
        this.cIu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.kM()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cIw);
                return;
            }
            if (this.cIu == null) {
                this.cIu = new JSONArray();
            }
            if (this.cIu.length() <= 100) {
                this.cIu.put(jSONObject);
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

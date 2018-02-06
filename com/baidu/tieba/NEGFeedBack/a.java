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
    private JSONArray bOF;
    private HttpMessageListener bOG;
    private BdUniqueId bOH = BdUniqueId.gen();
    private BdUniqueId bOI = BdUniqueId.gen();
    private CustomMessageListener bOJ = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.ox() && a.this.bOF != null) {
                a.this.a(a.this.bOF, a.this.bOI);
            }
        }
    };
    private CustomMessageListener bOK = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.p((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.bOG == null) {
            this.bOG = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bOF = null;
                    }
                }
            };
        }
        this.bOG.setTag(this.bOI);
        MessageManager.getInstance().registerListener(this.bOG);
        MessageManager.getInstance().registerListener(this.bOJ);
        this.bOK.setTag(tbPageContext.getUniqueId());
        this.bOK.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bOK);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bOG);
        MessageManager.getInstance().unRegisterListener(this.bOJ);
        MessageManager.getInstance().unRegisterListener(this.bOK);
        this.bOF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.ox()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.bOH);
                return;
            }
            if (this.bOF == null) {
                this.bOF = new JSONArray();
            }
            if (this.bOF.length() <= 100) {
                this.bOF.put(jSONObject);
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

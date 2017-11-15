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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONArray aVn;
    private HttpMessageListener aVo;
    private BdUniqueId aVp = BdUniqueId.gen();
    private BdUniqueId aVq = BdUniqueId.gen();
    private CustomMessageListener aVr = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.gV() && a.this.aVn != null) {
                a.this.a(a.this.aVn, a.this.aVq);
            }
        }
    };
    private CustomMessageListener aVs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.m((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String aiB;

    public a(TbPageContext tbPageContext, String str) {
        this.aiB = str;
        if (this.aVo == null) {
            this.aVo = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.aVn = null;
                    }
                }
            };
        }
        this.aVo.setTag(this.aVq);
        MessageManager.getInstance().registerListener(this.aVo);
        MessageManager.getInstance().registerListener(this.aVr);
        this.aVs.setTag(tbPageContext.getUniqueId());
        this.aVs.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aVs);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aVo);
        MessageManager.getInstance().unRegisterListener(this.aVr);
        MessageManager.getInstance().unRegisterListener(this.aVs);
        this.aVn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.gV()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.aVp);
                return;
            }
            if (this.aVn == null) {
                this.aVn = new JSONArray();
            }
            if (this.aVn.length() <= 100) {
                this.aVn.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.aiB);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

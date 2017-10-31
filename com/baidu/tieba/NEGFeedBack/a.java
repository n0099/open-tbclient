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
    private JSONArray aVf;
    private HttpMessageListener aVg;
    private BdUniqueId aVh = BdUniqueId.gen();
    private BdUniqueId aVi = BdUniqueId.gen();
    private CustomMessageListener aVj = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.gV() && a.this.aVf != null) {
                a.this.a(a.this.aVf, a.this.aVi);
            }
        }
    };
    private CustomMessageListener aVk = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.l((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String aiB;

    public a(TbPageContext tbPageContext, String str) {
        this.aiB = str;
        if (this.aVg == null) {
            this.aVg = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.aVf = null;
                    }
                }
            };
        }
        this.aVg.setTag(this.aVi);
        MessageManager.getInstance().registerListener(this.aVg);
        MessageManager.getInstance().registerListener(this.aVj);
        this.aVk.setTag(tbPageContext.getUniqueId());
        this.aVk.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aVk);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aVg);
        MessageManager.getInstance().unRegisterListener(this.aVj);
        MessageManager.getInstance().unRegisterListener(this.aVk);
        this.aVf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.gV()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.aVh);
                return;
            }
            if (this.aVf == null) {
                this.aVf = new JSONArray();
            }
            if (this.aVf.length() <= 100) {
                this.aVf.put(jSONObject);
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

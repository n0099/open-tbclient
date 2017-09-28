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
    private JSONArray aVi;
    private HttpMessageListener aVj;
    private BdUniqueId aVk = BdUniqueId.gen();
    private BdUniqueId aVl = BdUniqueId.gen();
    private CustomMessageListener aVm = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.gV() && a.this.aVi != null) {
                a.this.a(a.this.aVi, a.this.aVl);
            }
        }
    };
    private CustomMessageListener aVn = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.j((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String aiq;

    public a(TbPageContext tbPageContext, String str) {
        this.aiq = str;
        if (this.aVj == null) {
            this.aVj = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.aVi = null;
                    }
                }
            };
        }
        this.aVj.setTag(this.aVl);
        MessageManager.getInstance().registerListener(this.aVj);
        MessageManager.getInstance().registerListener(this.aVm);
        this.aVn.setTag(tbPageContext.getUniqueId());
        this.aVn.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aVn);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aVj);
        MessageManager.getInstance().unRegisterListener(this.aVm);
        MessageManager.getInstance().unRegisterListener(this.aVn);
        this.aVi = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.gV()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.aVk);
                return;
            }
            if (this.aVi == null) {
                this.aVi = new JSONArray();
            }
            if (this.aVi.length() <= 100) {
                this.aVi.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.aiq);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

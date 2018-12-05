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
    private BdUniqueId bwA = BdUniqueId.gen();
    private BdUniqueId bwB = BdUniqueId.gen();
    private CustomMessageListener bwC = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kK() && a.this.bwy != null) {
                a.this.a(a.this.bwy, a.this.bwB);
            }
        }
    };
    private CustomMessageListener bwD = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.J((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private JSONArray bwy;
    private HttpMessageListener bwz;
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.bwz == null) {
            this.bwz = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bwy = null;
                    }
                }
            };
        }
        this.bwz.setTag(this.bwB);
        MessageManager.getInstance().registerListener(this.bwz);
        MessageManager.getInstance().registerListener(this.bwC);
        this.bwD.setTag(tbPageContext.getUniqueId());
        this.bwD.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bwD);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bwz);
        MessageManager.getInstance().unRegisterListener(this.bwC);
        MessageManager.getInstance().unRegisterListener(this.bwD);
        this.bwy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.kK()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.bwA);
                return;
            }
            if (this.bwy == null) {
                this.bwy = new JSONArray();
            }
            if (this.bwy.length() <= 100) {
                this.bwy.put(jSONObject);
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

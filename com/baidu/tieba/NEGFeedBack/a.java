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
    private JSONArray bsn;
    private HttpMessageListener bso;
    private BdUniqueId bsp = BdUniqueId.gen();
    private BdUniqueId bsq = BdUniqueId.gen();
    private CustomMessageListener bsr = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kM() && a.this.bsn != null) {
                a.this.a(a.this.bsn, a.this.bsq);
            }
        }
    };
    private CustomMessageListener bss = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.I((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.bso == null) {
            this.bso = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bsn = null;
                    }
                }
            };
        }
        this.bso.setTag(this.bsq);
        MessageManager.getInstance().registerListener(this.bso);
        MessageManager.getInstance().registerListener(this.bsr);
        this.bss.setTag(tbPageContext.getUniqueId());
        this.bss.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bss);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bso);
        MessageManager.getInstance().unRegisterListener(this.bsr);
        MessageManager.getInstance().unRegisterListener(this.bss);
        this.bsn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.kM()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.bsp);
                return;
            }
            if (this.bsn == null) {
                this.bsn = new JSONArray();
            }
            if (this.bsn.length() <= 100) {
                this.bsn.put(jSONObject);
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

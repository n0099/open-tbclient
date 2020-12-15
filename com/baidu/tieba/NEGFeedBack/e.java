package com.baidu.tieba.NEGFeedBack;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class e {
    private HttpMessageListener fVV;
    private String mFrom;
    private a fWT = null;
    private CustomMessageListener fVZ = new CustomMessageListener(2016489) { // from class: com.baidu.tieba.NEGFeedBack.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                e.this.dq((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage);
    }

    public e(String str) {
        this.mFrom = str;
        if (this.fVV == null) {
            this.fVV = new HttpMessageListener(CmdConfigHttp.CMD_NEG_DELETE_THREAD) { // from class: com.baidu.tieba.NEGFeedBack.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003185 && (httpResponsedMessage instanceof DeleteThreadHttpResponseMessage) && httpResponsedMessage.isSuccess() && e.this.fWT != null) {
                        e.this.fWT.a((DeleteThreadHttpResponseMessage) httpResponsedMessage);
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.fVV);
        MessageManager.getInstance().registerListener(this.fVZ);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.fVV);
        MessageManager.getInstance().registerListener(this.fVZ);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fVZ);
        MessageManager.getInstance().unRegisterListener(this.fVV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(JSONObject jSONObject) {
        if (jSONObject != null && j.isNetworkAvailableForImmediately()) {
            try {
                int i = jSONObject.getInt("type");
                String S = au.S(jSONObject.getJSONArray("thread_ids"));
                String S2 = au.S(jSONObject.getJSONArray(TiebaInitialize.LogFields.REASON));
                String string = jSONObject.getString("forum_id");
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
                httpMessage.addParam("type", i);
                httpMessage.addParam("thread_ids", S);
                httpMessage.addParam(TiebaInitialize.LogFields.REASON, S2);
                httpMessage.addParam("forum_id", string);
                httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.fWT = aVar;
    }
}

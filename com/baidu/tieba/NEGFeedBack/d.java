package com.baidu.tieba.NEGFeedBack;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private HttpMessageListener cIv;
    private String mFrom;
    private a cJh = null;
    private CustomMessageListener cIz = new CustomMessageListener(2016489) { // from class: com.baidu.tieba.NEGFeedBack.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                d.this.aS((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage);
    }

    public d(String str) {
        this.mFrom = str;
        if (this.cIv == null) {
            this.cIv = new HttpMessageListener(CmdConfigHttp.CMD_NEG_DELETE_THREAD) { // from class: com.baidu.tieba.NEGFeedBack.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003185 && (httpResponsedMessage instanceof DeleteThreadHttpResponseMessage) && httpResponsedMessage.isSuccess() && d.this.cJh != null) {
                        d.this.cJh.a((DeleteThreadHttpResponseMessage) httpResponsedMessage);
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.cIv);
        MessageManager.getInstance().registerListener(this.cIz);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.cIv);
        MessageManager.getInstance().registerListener(this.cIz);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIz);
        MessageManager.getInstance().unRegisterListener(this.cIv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(JSONObject jSONObject) {
        if (jSONObject != null && j.kM()) {
            try {
                int i = jSONObject.getInt("type");
                String x = ap.x(jSONObject.getJSONArray("thread_ids"));
                String x2 = ap.x(jSONObject.getJSONArray("reason"));
                String string = jSONObject.getString("forum_id");
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
                httpMessage.addParam("type", i);
                httpMessage.addParam("thread_ids", x);
                httpMessage.addParam("reason", x2);
                httpMessage.addParam("forum_id", string);
                httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.cJh = aVar;
    }
}

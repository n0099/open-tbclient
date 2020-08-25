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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class d {
    private HttpMessageListener flk;
    private String mFrom;
    private a flW = null;
    private CustomMessageListener flo = new CustomMessageListener(2016489) { // from class: com.baidu.tieba.NEGFeedBack.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                d.this.dc((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    /* loaded from: classes15.dex */
    public interface a {
        void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage);
    }

    public d(String str) {
        this.mFrom = str;
        if (this.flk == null) {
            this.flk = new HttpMessageListener(CmdConfigHttp.CMD_NEG_DELETE_THREAD) { // from class: com.baidu.tieba.NEGFeedBack.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003185 && (httpResponsedMessage instanceof DeleteThreadHttpResponseMessage) && httpResponsedMessage.isSuccess() && d.this.flW != null) {
                        d.this.flW.a((DeleteThreadHttpResponseMessage) httpResponsedMessage);
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.flk);
        MessageManager.getInstance().registerListener(this.flo);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.flk);
        MessageManager.getInstance().registerListener(this.flo);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.flo);
        MessageManager.getInstance().unRegisterListener(this.flk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(JSONObject jSONObject) {
        if (jSONObject != null && j.isNetworkAvailableForImmediately()) {
            try {
                int i = jSONObject.getInt("type");
                String R = at.R(jSONObject.getJSONArray("thread_ids"));
                String R2 = at.R(jSONObject.getJSONArray(TiebaInitialize.LogFields.REASON));
                String string = jSONObject.getString("forum_id");
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
                httpMessage.addParam("type", i);
                httpMessage.addParam("thread_ids", R);
                httpMessage.addParam(TiebaInitialize.LogFields.REASON, R2);
                httpMessage.addParam("forum_id", string);
                httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.flW = aVar;
    }
}

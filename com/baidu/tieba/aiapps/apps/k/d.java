package com.baidu.tieba.aiapps.apps.k;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.Map;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.aiapps.apps.k.a.a bKz;
    private Activity mActivity;
    private BdUniqueId mPageId = BdUniqueId.gen();
    public final Bundle mParams = new Bundle();
    public final Bundle mResult = new Bundle();
    private CustomMessageListener bKA = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.aiapps.apps.k.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof com.baidu.tbadk.pay.d) {
                    com.baidu.tbadk.pay.d dVar = (com.baidu.tbadk.pay.d) data;
                    if (getTag() == dVar.tag) {
                        d.this.mResult.putInt("result_code", dVar.type);
                        d.this.mResult.putString("result_msg", dVar.message);
                        d.this.bKz.o(d.this.mResult);
                        d.this.finish();
                    }
                }
            }
        }
    };

    public void G(Activity activity) {
        this.mActivity = activity;
    }

    public void a(com.baidu.tieba.aiapps.apps.k.a.a aVar) {
        this.bKz = aVar;
    }

    public boolean onExec() {
        this.bKA.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.bKA);
        int i = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        com.baidu.tbadk.pay.d dVar = new com.baidu.tbadk.pay.d();
        dVar.tag = this.mPageId;
        dVar.type = i;
        dVar.message = string;
        dVar.params = (Map) this.mParams.getSerializable("params");
        if (this.mActivity != null) {
            dVar.context = this.mActivity;
        }
        CustomMessage customMessage = new CustomMessage(2921381, dVar);
        customMessage.setTag(this.mPageId);
        MessageManager.getInstance().sendMessage(customMessage);
        return false;
    }

    protected void finish() {
        this.mActivity = null;
        this.bKz = null;
        MessageManager.getInstance().unRegisterListener(this.bKA);
    }
}

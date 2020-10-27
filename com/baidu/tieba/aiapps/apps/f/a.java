package com.baidu.tieba.aiapps.apps.f;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.pay.d;
import java.util.Map;
/* loaded from: classes25.dex */
public class a extends ActivityDelegation implements com.baidu.swan.apps.a.a {
    private com.baidu.tieba.aiapps.apps.f.a.a fRh;
    private Activity fRi;
    public Map<String, String> foU;
    private BdUniqueId mPageId = BdUniqueId.gen();
    private CustomMessageListener fRj = new CustomMessageListener(2921393) { // from class: com.baidu.tieba.aiapps.apps.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof d) {
                    d dVar = (d) data;
                    if (getTag() == dVar.tag || dVar.foV) {
                        a.this.mResult.putInt("result_code", dVar.type);
                        a.this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, dVar.message);
                        if (a.this.fRh != null) {
                            a.this.fRh.ah(a.this.mResult);
                        }
                        a.this.finish();
                    }
                }
            }
        }
    };

    public void a(com.baidu.tieba.aiapps.apps.f.a.a aVar) {
        this.fRh = aVar;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        this.fRj.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.fRj);
        int i = this.mParams.getInt("type");
        String string = this.mParams.getString("orderInfo");
        d dVar = new d();
        dVar.tag = this.mPageId;
        dVar.type = i;
        dVar.message = string;
        dVar.params = (Map) this.mParams.getSerializable("params");
        dVar.foU = this.foU;
        if (getAgent() != null) {
            dVar.context = getAgent();
        } else if (this.fRi != null) {
            dVar.context = this.fRi;
        } else {
            dVar.context = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        CustomMessage customMessage = new CustomMessage(2921393, dVar);
        customMessage.setTag(this.mPageId);
        boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
        this.mResult.putInt("result_code", sendMessage ? 0 : 1);
        this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        this.fRh = null;
        MessageManager.getInstance().unRegisterListener(this.fRj);
        super.finish();
    }

    @Override // com.baidu.swan.apps.a.a
    public void onResult(int i) {
        this.mResult.putInt("result_code", i);
        this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
        finish();
    }

    public void aj(Activity activity) {
        this.fRi = activity;
    }
}

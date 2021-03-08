package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.hotTopic.tab.net.HotTopicTabRequest;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class HotTopicTabModel extends BdBaseModel {
    private com.baidu.adp.framework.listener.a eEU;
    private String eVm;
    private b kiu;
    private final HashMap<String, List<n>> kiv;
    private boolean mIsLoading;

    public List<n> Mf(String str) {
        return this.kiv.get(str);
    }

    public List<n> cQT() {
        return Mf(this.eVm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eVm = "all";
        this.kiv = new HashMap<>();
        cQU();
    }

    private void cQU() {
        this.eEU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661) { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                HotTopicTabModel.this.mIsLoading = false;
                if (HotTopicTabModel.this.kiu != null && (responsedMessage instanceof com.baidu.tieba.homepage.hotTopic.tab.net.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    if (responsedMessage.getOrginalMessage() == null) {
                        HotTopicTabModel.this.kiu.a(-1, null);
                        return;
                    }
                    HotTopicTabRequest hotTopicTabRequest = (HotTopicTabRequest) responsedMessage.getOrginalMessage().getExtra();
                    com.baidu.tieba.homepage.hotTopic.tab.net.a aVar = (com.baidu.tieba.homepage.hotTopic.tab.net.a) responsedMessage;
                    if (!TextUtils.isEmpty(HotTopicTabModel.this.eVm)) {
                        HotTopicTabModel.this.kiv.put(HotTopicTabModel.this.eVm, aVar.getDataList());
                    }
                    HotTopicTabModel.this.kiu.a(responsedMessage.getError(), aVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPresenter(b bVar) {
        this.kiu = bVar;
    }

    public void setTabCode(String str) {
        this.eVm = str;
    }

    public String getTabCode() {
        return this.eVm;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.isNetworkAvailableForImmediately() || this.mIsLoading) {
            return false;
        }
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTabCode(this.eVm);
        hotTopicTabRequest.setTag(this.unique_id);
        this.mIsLoading = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        return this.mIsLoading;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.eEU.setTag(bdUniqueId);
        registerListener(this.eEU);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eEU);
        this.mIsLoading = false;
    }
}

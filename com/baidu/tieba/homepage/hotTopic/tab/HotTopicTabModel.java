package com.baidu.tieba.homepage.hotTopic.tab;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.hotTopic.tab.net.HotTopicTabRequest;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes21.dex */
public class HotTopicTabModel extends BdBaseModel {
    private com.baidu.adp.framework.listener.a dRa;
    private String eCq;
    private b iTY;
    private final HashMap<String, List<q>> iTZ;
    private boolean mIsLoading;

    public List<q> Kk(String str) {
        return this.iTZ.get(str);
    }

    public List<q> cBj() {
        return Kk(this.eCq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eCq = "all";
        this.iTZ = new HashMap<>();
        cBk();
    }

    private void cBk() {
        this.dRa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661) { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                HotTopicTabModel.this.mIsLoading = false;
                if (HotTopicTabModel.this.iTY != null && (responsedMessage instanceof com.baidu.tieba.homepage.hotTopic.tab.net.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    if (responsedMessage.getOrginalMessage() == null) {
                        HotTopicTabModel.this.iTY.a(-1, null);
                        return;
                    }
                    HotTopicTabRequest hotTopicTabRequest = (HotTopicTabRequest) responsedMessage.getOrginalMessage().getExtra();
                    com.baidu.tieba.homepage.hotTopic.tab.net.a aVar = (com.baidu.tieba.homepage.hotTopic.tab.net.a) responsedMessage;
                    if (!TextUtils.isEmpty(HotTopicTabModel.this.eCq)) {
                        HotTopicTabModel.this.iTZ.put(HotTopicTabModel.this.eCq, aVar.getDataList());
                    }
                    HotTopicTabModel.this.iTY.a(responsedMessage.getError(), aVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPresenter(b bVar) {
        this.iTY = bVar;
    }

    public void setTabCode(String str) {
        this.eCq = str;
    }

    public String bnB() {
        return this.eCq;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.isNetworkAvailableForImmediately() || this.mIsLoading) {
            return false;
        }
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTabCode(this.eCq);
        hotTopicTabRequest.setTag(this.unique_id);
        this.mIsLoading = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        return this.mIsLoading;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.dRa.setTag(bdUniqueId);
        registerListener(this.dRa);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dRa);
        this.mIsLoading = false;
    }
}

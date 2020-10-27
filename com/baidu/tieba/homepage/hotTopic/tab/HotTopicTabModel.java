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
/* loaded from: classes22.dex */
public class HotTopicTabModel extends BdBaseModel {
    private String eWT;
    private com.baidu.adp.framework.listener.a elx;
    private b jvt;
    private final HashMap<String, List<q>> jvu;
    private boolean mIsLoading;

    public List<q> Lx(String str) {
        return this.jvu.get(str);
    }

    public List<q> cHX() {
        return Lx(this.eWT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotTopicTabModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eWT = "all";
        this.jvu = new HashMap<>();
        cHY();
    }

    private void cHY() {
        this.elx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661) { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                HotTopicTabModel.this.mIsLoading = false;
                if (HotTopicTabModel.this.jvt != null && (responsedMessage instanceof com.baidu.tieba.homepage.hotTopic.tab.net.a) && HotTopicTabModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    if (responsedMessage.getOrginalMessage() == null) {
                        HotTopicTabModel.this.jvt.a(-1, null);
                        return;
                    }
                    HotTopicTabRequest hotTopicTabRequest = (HotTopicTabRequest) responsedMessage.getOrginalMessage().getExtra();
                    com.baidu.tieba.homepage.hotTopic.tab.net.a aVar = (com.baidu.tieba.homepage.hotTopic.tab.net.a) responsedMessage;
                    if (!TextUtils.isEmpty(HotTopicTabModel.this.eWT)) {
                        HotTopicTabModel.this.jvu.put(HotTopicTabModel.this.eWT, aVar.getDataList());
                    }
                    HotTopicTabModel.this.jvt.a(responsedMessage.getError(), aVar);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPresenter(b bVar) {
        this.jvt = bVar;
    }

    public void setTabCode(String str) {
        this.eWT = str;
    }

    public String bse() {
        return this.eWT;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!j.isNetworkAvailableForImmediately() || this.mIsLoading) {
            return false;
        }
        HotTopicTabRequest hotTopicTabRequest = new HotTopicTabRequest();
        hotTopicTabRequest.setTabCode(this.eWT);
        hotTopicTabRequest.setTag(this.unique_id);
        this.mIsLoading = MessageManager.getInstance().sendMessage(hotTopicTabRequest);
        return this.mIsLoading;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.elx.setTag(bdUniqueId);
        registerListener(this.elx);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.elx);
        this.mIsLoading = false;
    }
}

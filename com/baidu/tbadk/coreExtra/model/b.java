package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
/* loaded from: classes.dex */
public class b {
    private a eRq;
    private int eRr;
    private int eRs;
    private HttpMessageListener eRt = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.eRq != null) {
                    b.this.eRq.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    };
    private m mData;
    private l mFinalData;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, m mVar);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.eRt);
        this.eRr = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_common_category_version", 0);
        this.eRs = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l bsB() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.bqn() != null && this.eRs < this.mData.bqn().getVersion()) {
            lVar.setIcon(this.mData.bqn().getIcon());
            lVar.Cc(this.mData.bqn().getPopText());
            lVar.setTabCode(this.mData.bqn().bql());
            lVar.setTid(this.mData.bqn().getTid());
            lVar.qi(l.eOv);
        } else if (this.mData != null && this.mData.bqm() > 0 && this.eRr < this.mData.bqm()) {
            lVar.qi(l.eOu);
        } else {
            lVar.qi(l.eOt);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void qr(int i) {
        if (i == l.eOv) {
            if (this.mData.bqn() != null) {
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_special_category_version", this.mData.bqn().getVersion());
            }
        } else if (i == l.eOu) {
            com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_common_category_version", this.mData.bqm());
        }
    }
}

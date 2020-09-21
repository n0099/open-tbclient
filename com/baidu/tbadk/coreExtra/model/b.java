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
    private a eFj;
    private int eFk;
    private int eFl;
    private HttpMessageListener eFm = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.eFj != null) {
                    b.this.eFj.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
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
        MessageManager.getInstance().registerListener(this.eFm);
        this.eFk = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_common_category_version", 0);
        this.eFl = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l bpR() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.bnD() != null && this.eFl < this.mData.bnD().getVersion()) {
            lVar.setIcon(this.mData.bnD().getIcon());
            lVar.Bq(this.mData.bnD().getPopText());
            lVar.setTabCode(this.mData.bnD().bnB());
            lVar.setTid(this.mData.bnD().getTid());
            lVar.pK(l.eCo);
        } else if (this.mData != null && this.mData.bnC() > 0 && this.eFk < this.mData.bnC()) {
            lVar.pK(l.eCn);
        } else {
            lVar.pK(l.eCm);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void pT(int i) {
        if (i == l.eCo) {
            if (this.mData.bnD() != null) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_special_category_version", this.mData.bnD().getVersion());
            }
        } else if (i == l.eCn) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_common_category_version", this.mData.bnC());
        }
    }
}

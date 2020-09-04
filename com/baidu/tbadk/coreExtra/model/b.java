package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
/* loaded from: classes.dex */
public class b {
    private a eDe;
    private int eDf;
    private int eDg;
    private HttpMessageListener eDh = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.eDe != null) {
                    b.this.eDe.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    };
    private l mData;
    private k mFinalData;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, l lVar);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.eDh);
        this.eDf = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_common_category_version", 0);
        this.eDg = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public k boX() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        k kVar = new k();
        if (this.mData != null && this.mData.bmJ() != null && this.eDg < this.mData.bmJ().getVersion()) {
            kVar.setIcon(this.mData.bmJ().getIcon());
            kVar.AU(this.mData.bmJ().getPopText());
            kVar.setTabCode(this.mData.bmJ().bmH());
            kVar.setTid(this.mData.bmJ().getTid());
            kVar.px(k.eAj);
        } else if (this.mData != null && this.mData.bmI() > 0 && this.eDf < this.mData.bmI()) {
            kVar.px(k.eAi);
        } else {
            kVar.px(k.eAh);
        }
        this.mFinalData = kVar;
        return kVar;
    }

    public void pG(int i) {
        if (i == k.eAj) {
            if (this.mData.bmJ() != null) {
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_special_category_version", this.mData.bmJ().getVersion());
            }
        } else if (i == k.eAi) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_common_category_version", this.mData.bmI());
        }
    }
}

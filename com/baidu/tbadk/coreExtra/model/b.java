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
    private a feL;
    private int feM;
    private int feN;
    private HttpMessageListener feO = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.feL != null) {
                    b.this.feL.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
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
        MessageManager.getInstance().registerListener(this.feO);
        this.feM = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_common_category_version", 0);
        this.feN = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l bwk() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.btW() != null && this.feN < this.mData.btW().getVersion()) {
            lVar.setIcon(this.mData.btW().getIcon());
            lVar.Ci(this.mData.btW().getPopText());
            lVar.setTabCode(this.mData.btW().btU());
            lVar.setTid(this.mData.btW().getTid());
            lVar.rb(l.fbO);
        } else if (this.mData != null && this.mData.btV() > 0 && this.feM < this.mData.btV()) {
            lVar.rb(l.fbN);
        } else {
            lVar.rb(l.fbM);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void rk(int i) {
        if (i == l.fbO) {
            if (this.mData.btW() != null) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_special_category_version", this.mData.btW().getVersion());
            }
        } else if (i == l.fbN) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_common_category_version", this.mData.btV());
        }
    }
}

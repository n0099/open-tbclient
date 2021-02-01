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
    private a ftE;
    private int ftF;
    private int ftG;
    private HttpMessageListener ftH = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.ftE != null) {
                    b.this.ftE.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
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
        MessageManager.getInstance().registerListener(this.ftH);
        this.ftF = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_common_category_version", 0);
        this.ftG = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l byD() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.bwp() != null && this.ftG < this.mData.bwp().getVersion()) {
            lVar.setIcon(this.mData.bwp().getIcon());
            lVar.BT(this.mData.bwp().getPopText());
            lVar.setTabCode(this.mData.bwp().getTabCode());
            lVar.setTid(this.mData.bwp().getTid());
            lVar.qn(l.fqF);
        } else if (this.mData != null && this.mData.bwo() > 0 && this.ftF < this.mData.bwo()) {
            lVar.qn(l.fqE);
        } else {
            lVar.qn(l.fqD);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void qw(int i) {
        if (i == l.fqF) {
            if (this.mData.bwp() != null) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_special_category_version", this.mData.bwp().getVersion());
            }
        } else if (i == l.fqE) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_common_category_version", this.mData.bwo());
        }
    }
}

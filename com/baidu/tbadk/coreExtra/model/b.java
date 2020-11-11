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
    private a ffD;
    private int ffE;
    private int ffF;
    private HttpMessageListener ffG = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.ffD != null) {
                    b.this.ffD.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
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
        MessageManager.getInstance().registerListener(this.ffG);
        this.ffE = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_common_category_version", 0);
        this.ffF = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l bwU() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.buG() != null && this.ffF < this.mData.buG().getVersion()) {
            lVar.setIcon(this.mData.buG().getIcon());
            lVar.CJ(this.mData.buG().getPopText());
            lVar.setTabCode(this.mData.buG().buE());
            lVar.setTid(this.mData.buG().getTid());
            lVar.qD(l.fcH);
        } else if (this.mData != null && this.mData.buF() > 0 && this.ffE < this.mData.buF()) {
            lVar.qD(l.fcG);
        } else {
            lVar.qD(l.fcF);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void qM(int i) {
        if (i == l.fcH) {
            if (this.mData.buG() != null) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_special_category_version", this.mData.buG().getVersion());
            }
        } else if (i == l.fcG) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_common_category_version", this.mData.buF());
        }
    }
}

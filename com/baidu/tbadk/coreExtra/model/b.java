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
    private a eZM;
    private int eZN;
    private int eZO;
    private HttpMessageListener eZP = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.eZM != null) {
                    b.this.eZM.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
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
        MessageManager.getInstance().registerListener(this.eZP);
        this.eZN = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_common_category_version", 0);
        this.eZO = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l buu() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.bsg() != null && this.eZO < this.mData.bsg().getVersion()) {
            lVar.setIcon(this.mData.bsg().getIcon());
            lVar.Cv(this.mData.bsg().getPopText());
            lVar.setTabCode(this.mData.bsg().bse());
            lVar.setTid(this.mData.bsg().getTid());
            lVar.qt(l.eWR);
        } else if (this.mData != null && this.mData.bsf() > 0 && this.eZN < this.mData.bsf()) {
            lVar.qt(l.eWQ);
        } else {
            lVar.qt(l.eWP);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void qC(int i) {
        if (i == l.eWR) {
            if (this.mData.bsg() != null) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_special_category_version", this.mData.bsg().getVersion());
            }
        } else if (i == l.eWQ) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_common_category_version", this.mData.bsf());
        }
    }
}

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
    private a fmk;
    private int fml;
    private int fmm;
    private HttpMessageListener fmn = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.fmk != null) {
                    b.this.fmk.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
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
        MessageManager.getInstance().registerListener(this.fmn);
        this.fml = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_common_category_version", 0);
        this.fmm = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l bzK() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.bxw() != null && this.fmm < this.mData.bxw().getVersion()) {
            lVar.setIcon(this.mData.bxw().getIcon());
            lVar.CQ(this.mData.bxw().getPopText());
            lVar.setTabCode(this.mData.bxw().bxu());
            lVar.setTid(this.mData.bxw().getTid());
            lVar.rC(l.fjo);
        } else if (this.mData != null && this.mData.bxv() > 0 && this.fml < this.mData.bxv()) {
            lVar.rC(l.fjn);
        } else {
            lVar.rC(l.fjm);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void rL(int i) {
        if (i == l.fjo) {
            if (this.mData.bxw() != null) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_special_category_version", this.mData.bxw().getVersion());
            }
        } else if (i == l.fjn) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_common_category_version", this.mData.bxv());
        }
    }
}

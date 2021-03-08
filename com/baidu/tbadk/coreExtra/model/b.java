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
    private a fvd;
    private int fve;
    private int fvf;
    private HttpMessageListener fvg = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.fvd != null) {
                    b.this.fvd.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
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
        MessageManager.getInstance().registerListener(this.fvg);
        this.fve = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_common_category_version", 0);
        this.fvf = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l byG() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.bws() != null && this.fvf < this.mData.bws().getVersion()) {
            lVar.setIcon(this.mData.bws().getIcon());
            lVar.Ca(this.mData.bws().getPopText());
            lVar.setTabCode(this.mData.bws().getTabCode());
            lVar.setTid(this.mData.bws().getTid());
            lVar.qo(l.fsg);
        } else if (this.mData != null && this.mData.bwr() > 0 && this.fve < this.mData.bwr()) {
            lVar.qo(l.fsf);
        } else {
            lVar.qo(l.fse);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void qx(int i) {
        if (i == l.fsg) {
            if (this.mData.bws() != null) {
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_special_category_version", this.mData.bws().getVersion());
            }
        } else if (i == l.fsf) {
            com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_common_category_version", this.mData.bwr());
        }
    }
}

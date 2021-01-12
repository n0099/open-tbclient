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
    private a frl;
    private int frm;
    private int frn;
    private HttpMessageListener fro = new HttpMessageListener(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG) { // from class: com.baidu.tbadk.coreExtra.model.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.mData = channelConfigResponseMessage.getData();
                if (b.this.frl != null) {
                    b.this.frl.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
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
        MessageManager.getInstance().registerListener(this.fro);
        this.frm = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_common_category_version", 0);
        this.frn = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_special_category_version", 0);
    }

    public void startLoad() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }

    public l byl() {
        if (this.mFinalData != null) {
            return this.mFinalData;
        }
        if (this.mData == null) {
            return null;
        }
        l lVar = new l();
        if (this.mData != null && this.mData.bvX() != null && this.frn < this.mData.bvX().getVersion()) {
            lVar.setIcon(this.mData.bvX().getIcon());
            lVar.BC(this.mData.bvX().getPopText());
            lVar.setTabCode(this.mData.bvX().bvV());
            lVar.setTid(this.mData.bvX().getTid());
            lVar.qi(l.fom);
        } else if (this.mData != null && this.mData.bvW() > 0 && this.frm < this.mData.bvW()) {
            lVar.qi(l.fol);
        } else {
            lVar.qi(l.fok);
        }
        this.mFinalData = lVar;
        return lVar;
    }

    public void qr(int i) {
        if (i == l.fom) {
            if (this.mData.bvX() != null) {
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_special_category_version", this.mData.bvX().getVersion());
            }
        } else if (i == l.fol) {
            com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_common_category_version", this.mData.bvW());
        }
    }
}

package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.downloader.ResourceDownloader;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private InterfaceC0707a icx;
    private BdAsyncTask icy;
    private HttpMessageListener icz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetEnterEffectResponsedMessage) {
                final List<n> effectList = ((AlaGetEnterEffectResponsedMessage) httpResponsedMessage).getEffectList();
                if (x.isEmpty(effectList)) {
                    a.this.icx.a((AlaGetEnterEffectResponsedMessage) httpResponsedMessage);
                    return;
                }
                a.this.icy = new BdAsyncTask() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.1.1
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    protected Object doInBackground(Object[] objArr) {
                        for (n nVar : effectList) {
                            if (nVar instanceof AlaEnterEffectData) {
                                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                                if (alaEnterEffectData.type == 1 && alaEnterEffectData.gift != null && alaEnterEffectData.gift.giftZip != null) {
                                    if (ResourceDownloader.checkDirNeedToDownload(AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + alaEnterEffectData.gift.giftName)) {
                                        alaEnterEffectData.downLoadStatus = 100;
                                    } else {
                                        alaEnterEffectData.downLoadStatus = 101;
                                    }
                                }
                            }
                        }
                        return null;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public void onPostExecute(Object obj) {
                        super.onPostExecute(obj);
                        a.this.icx.a((AlaGetEnterEffectResponsedMessage) httpResponsedMessage);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public void onCancelled() {
                        super.onCancelled();
                        a.this.icx.a((AlaGetEnterEffectResponsedMessage) httpResponsedMessage);
                    }
                }.execute(new Object[0]);
            }
        }
    };
    private TbPageContext mPageContext;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0707a {
        void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage);
    }

    public a(TbPageContext tbPageContext, InterfaceC0707a interfaceC0707a) {
        this.mPageContext = tbPageContext;
        this.icx = interfaceC0707a;
        this.mPageContext.registerListener(this.icz);
    }

    public void cqf() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        this.mPageContext.sendMessage(httpMessage);
    }

    public void onDestory() {
        if (this.icy != null) {
            this.icy.cancel();
        }
    }
}

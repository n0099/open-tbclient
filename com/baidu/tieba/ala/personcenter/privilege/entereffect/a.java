package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.downloader.ResourceDownloader;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private InterfaceC0702a hGL;
    private BdAsyncTask hGM;
    private HttpMessageListener hGN = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetEnterEffectResponsedMessage) {
                final List<q> effectList = ((AlaGetEnterEffectResponsedMessage) httpResponsedMessage).getEffectList();
                if (y.isEmpty(effectList)) {
                    a.this.hGL.a((AlaGetEnterEffectResponsedMessage) httpResponsedMessage);
                    return;
                }
                a.this.hGM = new BdAsyncTask() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.1.1
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    protected Object doInBackground(Object[] objArr) {
                        for (q qVar : effectList) {
                            if (qVar instanceof AlaEnterEffectData) {
                                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) qVar;
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
                        a.this.hGL.a((AlaGetEnterEffectResponsedMessage) httpResponsedMessage);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public void onCancelled() {
                        super.onCancelled();
                        a.this.hGL.a((AlaGetEnterEffectResponsedMessage) httpResponsedMessage);
                    }
                }.execute(new Object[0]);
            }
        }
    };
    private TbPageContext mPageContext;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0702a {
        void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage);
    }

    public a(TbPageContext tbPageContext, InterfaceC0702a interfaceC0702a) {
        this.mPageContext = tbPageContext;
        this.hGL = interfaceC0702a;
        this.mPageContext.registerListener(this.hGN);
    }

    public void cjY() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        this.mPageContext.sendMessage(httpMessage);
    }

    public void onDestory() {
        if (this.hGM != null) {
            this.hGM.cancel();
        }
    }
}

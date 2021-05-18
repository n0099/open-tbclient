package com.baidu.tieba.face;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class SearchEmotionModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f14677e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f14678f = new a(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003330 || !(httpResponsedMessage instanceof SearchEmotionResponseMessage) || SearchEmotionModel.this.f14677e == null) {
                return;
            }
            SearchEmotionResponseMessage searchEmotionResponseMessage = (SearchEmotionResponseMessage) httpResponsedMessage;
            if (searchEmotionResponseMessage.getData() != null) {
                if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                    return;
                }
                SearchEmotionModel.this.f14677e.a((String) httpResponsedMessage.getOrginalMessage().getExtra(), searchEmotionResponseMessage.getData());
                return;
            }
            if (!TextUtils.isEmpty(searchEmotionResponseMessage.getErrorString())) {
                l.M(TbadkCoreApplication.getInst(), searchEmotionResponseMessage.getErrorString());
            }
            SearchEmotionModel.this.f14677e.onFail(searchEmotionResponseMessage.getError(), searchEmotionResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str, d.a.k0.k0.c.a aVar);

        void onFail(int i2, String str);
    }

    public SearchEmotionModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f14678f.setTag(getUniqueId());
        this.f14678f.setSelfListener(true);
        registerListener(this.f14678f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.f14677e = null;
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SEARCH_PB_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/search");
        tbHttpMessageTask.setResponsedClass(SearchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void t(String str, int i2, int i3, b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f14677e = bVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
        httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, str);
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        httpMessage.addParam("rn", i3);
        httpMessage.setExtra(str);
        sendMessage(httpMessage);
    }
}

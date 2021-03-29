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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class SearchEmotionModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f15553e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f15554f = new a(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003330 || !(httpResponsedMessage instanceof SearchEmotionResponseMessage) || SearchEmotionModel.this.f15553e == null) {
                return;
            }
            SearchEmotionResponseMessage searchEmotionResponseMessage = (SearchEmotionResponseMessage) httpResponsedMessage;
            if (searchEmotionResponseMessage.getData() != null) {
                if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                    return;
                }
                SearchEmotionModel.this.f15553e.a((String) httpResponsedMessage.getOrginalMessage().getExtra(), searchEmotionResponseMessage.getData());
                return;
            }
            if (!TextUtils.isEmpty(searchEmotionResponseMessage.getErrorString())) {
                l.L(TbadkCoreApplication.getInst(), searchEmotionResponseMessage.getErrorString());
            }
            SearchEmotionModel.this.f15553e.onFail(searchEmotionResponseMessage.getError(), searchEmotionResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str, d.b.i0.k0.c.a aVar);

        void onFail(int i, String str);
    }

    public SearchEmotionModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f15554f.setTag(getUniqueId());
        this.f15554f.setSelfListener(true);
        registerListener(this.f15554f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.f15553e = null;
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SEARCH_PB_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/search");
        tbHttpMessageTask.setResponsedClass(SearchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void t(String str, int i, int i2, b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f15553e = bVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
        httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, str);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("rn", i2);
        httpMessage.setExtra(str);
        sendMessage(httpMessage);
    }
}

package com.baidu.tieba.faceshop;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class EmotionPackageDetailModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d f15433e;

    /* renamed from: f  reason: collision with root package name */
    public e f15434f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f15435g = new a(CmdConfigHttp.CMD_EMOTION_PACKAGE_DETAIL);

    /* renamed from: h  reason: collision with root package name */
    public final HttpMessageListener f15436h = new b(CmdConfigHttp.CMD_DELETE_EMOTION_PACKAGE);

    /* renamed from: i  reason: collision with root package name */
    public final HttpMessageListener f15437i = new c(CmdConfigHttp.CMD_VOTE_EMOTION);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003346 || !(httpResponsedMessage instanceof PackageDetailResponseMessage) || EmotionPackageDetailModel.this.mLoadDataCallBack == null) {
                return;
            }
            PackageDetailResponseMessage packageDetailResponseMessage = (PackageDetailResponseMessage) httpResponsedMessage;
            if (EmotionPackageDetailModel.this.mLoadDataCallBack != null) {
                EmotionPackageDetailModel.this.mLoadDataCallBack.c(packageDetailResponseMessage.data);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003347 || EmotionPackageDetailModel.this.f15433e == null) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                EmotionPackageDetailModel.this.f15433e.onResult(true);
            } else {
                EmotionPackageDetailModel.this.f15433e.onResult(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003358 || EmotionPackageDetailModel.this.f15434f == null) {
                return;
            }
            EmotionPackageDetailModel.this.f15434f.a(httpResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onResult(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(HttpResponsedMessage httpResponsedMessage);
    }

    public EmotionPackageDetailModel() {
        setUniqueId(BdUniqueId.gen());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_EMOTION_PACKAGE_DETAIL, TbConfig.SERVER_ADDRESS + TbConfig.GET_NEW_PACKAGE_DETAIL);
        tbHttpMessageTask.setResponsedClass(PackageDetailResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_EMOTION_PACKAGE, TbConfig.SERVER_ADDRESS + TbConfig.DELETE_EMOTION_PACKAGE);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(CmdConfigHttp.CMD_VOTE_EMOTION, TbConfig.SERVER_ADDRESS + TbConfig.VOTE_EMOTION_PACKAGE);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        this.f15435g.setTag(getUniqueId());
        this.f15435g.setSelfListener(true);
        registerListener(this.f15435g);
        registerListener(this.f15436h);
        registerListener(this.f15437i);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f15435g);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_EMOTION_PACKAGE_DETAIL);
        MessageManager.getInstance().unRegisterListener(this.f15436h);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_DELETE_EMOTION_PACKAGE);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VOTE_EMOTION);
        MessageManager.getInstance().unRegisterListener(this.f15437i);
        return true;
    }

    public void x(int i2, d dVar) {
        if (i2 < 0) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_EMOTION_PACKAGE);
        httpMessage.addParam("package_id", i2);
        sendMessage(httpMessage);
        this.f15433e = dVar;
    }

    public void y(int i2) {
        if (i2 < 0) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_EMOTION_PACKAGE_DETAIL);
        httpMessage.addParam("id", i2);
        sendMessage(httpMessage);
    }

    public void z(int i2, e eVar) {
        if (i2 < 0) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VOTE_EMOTION);
        httpMessage.addParam(IntentConfig.PKG_ID, i2);
        sendMessage(httpMessage);
        this.f15434f = eVar;
    }
}

package com.baidu.tieba.faceshop;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class EmotionPackageDetailModel extends BdBaseModel {
    private a iOO;
    private b iOP;
    private final HttpMessageListener frq = new HttpMessageListener(1003346) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003346 && (httpResponsedMessage instanceof PackageDetailResponseMessage) && EmotionPackageDetailModel.this.mLoadDataCallBack != null) {
                PackageDetailResponseMessage packageDetailResponseMessage = (PackageDetailResponseMessage) httpResponsedMessage;
                if (EmotionPackageDetailModel.this.mLoadDataCallBack != null) {
                    EmotionPackageDetailModel.this.mLoadDataCallBack.callback(packageDetailResponseMessage.data);
                }
            }
        }
    };
    private final HttpMessageListener iOQ = new HttpMessageListener(1003347) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003347 && EmotionPackageDetailModel.this.iOO != null) {
                if (httpResponsedMessage.getError() == 0) {
                    EmotionPackageDetailModel.this.iOO.onResult(true);
                } else {
                    EmotionPackageDetailModel.this.iOO.onResult(false);
                }
            }
        }
    };
    private final HttpMessageListener iOR = new HttpMessageListener(1003358) { // from class: com.baidu.tieba.faceshop.EmotionPackageDetailModel.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003358 && EmotionPackageDetailModel.this.iOP != null) {
                EmotionPackageDetailModel.this.iOP.c(httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void onResult(boolean z);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void c(HttpResponsedMessage httpResponsedMessage);
    }

    public EmotionPackageDetailModel() {
        setUniqueId(BdUniqueId.gen());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003346, TbConfig.SERVER_ADDRESS + TbConfig.GET_NEW_PACKAGE_DETAIL);
        tbHttpMessageTask.setResponsedClass(PackageDetailResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1003347, TbConfig.SERVER_ADDRESS + TbConfig.DELETE_EMOTION_PACKAGE);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1003358, TbConfig.SERVER_ADDRESS + TbConfig.VOTE_EMOTION_PACKAGE);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        this.frq.setTag(getUniqueId());
        this.frq.setSelfListener(true);
        registerListener(this.frq);
        registerListener(this.iOQ);
        registerListener(this.iOR);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void loadData(int i) {
        if (i >= 0) {
            HttpMessage httpMessage = new HttpMessage(1003346);
            httpMessage.addParam("id", i);
            sendMessage(httpMessage);
        }
    }

    public void a(int i, a aVar) {
        if (i >= 0) {
            HttpMessage httpMessage = new HttpMessage(1003347);
            httpMessage.addParam("package_id", i);
            sendMessage(httpMessage);
            this.iOO = aVar;
        }
    }

    public void a(int i, b bVar) {
        if (i >= 0) {
            HttpMessage httpMessage = new HttpMessage(1003358);
            httpMessage.addParam("pkg_id", i);
            sendMessage(httpMessage);
            this.iOP = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.frq);
        MessageManager.getInstance().unRegisterTask(1003346);
        MessageManager.getInstance().unRegisterListener(this.iOQ);
        MessageManager.getInstance().unRegisterTask(1003347);
        MessageManager.getInstance().unRegisterTask(1003358);
        MessageManager.getInstance().unRegisterListener(this.iOR);
        return true;
    }
}

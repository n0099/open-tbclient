package com.baidu.tieba.ala.alaar.makeup;

import android.os.Build;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alaar.messages.AlaMakeupResponseMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class i extends BdBaseModel {
    private com.baidu.tieba.ala.alaar.makeup.a.c gbM;
    private BdUniqueId bou = BdUniqueId.gen();
    private HttpMessageListener gbN = new HttpMessageListener(1021225) { // from class: com.baidu.tieba.ala.alaar.makeup.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaMakeupResponseMessage) {
                i.this.e(httpResponsedMessage);
            }
        }
    };

    public void init() {
        bNb();
        registerListener();
    }

    public void onDestroy() {
        unregisterListener();
    }

    public void c(BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1021225);
        httpMessage.setTag(bdUniqueId);
        httpMessage.addParam("ar_token", com.baidu.live.d.AZ().getString("sp_ar_makeup_token", ""));
        String str = Build.MANUFACTURER + Constants.ACCEPT_TIME_SEPARATOR_SP + Build.HARDWARE + Constants.ACCEPT_TIME_SEPARATOR_SP + Build.BOARD + Constants.ACCEPT_TIME_SEPARATOR_SP + (b.eU(TbadkCoreApplication.getInst().getContext()) ? 1 : 0);
        httpMessage.addParam("uh", str);
        String str2 = Build.MODEL + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.RELEASE + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.SDK_INT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.BRAND.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "");
        httpMessage.addParam("ut", str2);
        httpMessage.addParam("arVersion", com.baidu.minivideo.arface.b.getVersion());
        MessageManager.getInstance().sendMessage(httpMessage);
        if (h.isDebug()) {
            h.d("MKNetLoader", "requestMakeupParams: " + str + ", " + str2);
        }
    }

    private void bNb() {
        String str = TbConfig.SERVER_ADDRESS + "ala/sys/getBeautyConf";
        if (h.isDebug()) {
            h.d("MKNetLoader", "registerFilterAndBeautyTask: " + str);
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021225, str);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaMakeupResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        if (h.isDebug()) {
            h.d("MKNetLoader", "registerListener: " + this.gbN);
        }
        registerListener(this.gbN);
    }

    private void unregisterListener() {
        if (h.isDebug()) {
            h.d("MKNetLoader", "unregisterListener: " + this.gbN);
        }
        MessageManager.getInstance().unRegisterListener(this.gbN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.c(i.this.bou);
            }
        });
        return true;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public void setLoadDataCallBack(BdLoadDataCallBack bdLoadDataCallBack) {
        super.setLoadDataCallBack(bdLoadDataCallBack);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null) {
            h.d("MKNetLoader", "onGetMakeup(HttpResponsedMessage msg == null");
            return;
        }
        AlaMakeupResponseMessage alaMakeupResponseMessage = (AlaMakeupResponseMessage) httpResponsedMessage;
        this.gbM = alaMakeupResponseMessage.bMW();
        if (h.isDebug()) {
            h.d("MKNetLoader", "onGetMakeup: " + (this.gbM == null ? "null" : Integer.valueOf(this.gbM.size())));
        }
        if (this.gbM != null && alaMakeupResponseMessage.getOrginalMessage() != null) {
            this.gbM.aEe = alaMakeupResponseMessage.getOrginalMessage().getTag();
        }
        if (this.gbM != null) {
            aB(this.gbM.aDW, com.baidu.minivideo.arface.a.getVersion());
        }
        if (this.mLoadDataCallBack != null) {
            this.mLoadDataCallBack.callback(this.gbM);
        }
    }

    public void aB(String str, int i) {
        if (!StringUtils.isNullObject(str)) {
            com.baidu.live.d.AZ().putString("sp_ar_makeup_token", str);
        }
        if (i > 0) {
            com.baidu.live.d.AZ().putInt("sp_ar_makeup_version", i);
        }
    }
}

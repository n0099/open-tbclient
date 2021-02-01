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
/* loaded from: classes11.dex */
public class i extends BdBaseModel {
    private com.baidu.tieba.ala.alaar.makeup.a.c gsh;
    private BdUniqueId aCW = BdUniqueId.gen();
    private HttpMessageListener gsi = new HttpMessageListener(1021214) { // from class: com.baidu.tieba.ala.alaar.makeup.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaMakeupResponseMessage) {
                i.this.g(httpResponsedMessage);
            }
        }
    };

    public void init() {
        bPt();
        registerListener();
    }

    public void onDestroy() {
        unregisterListener();
    }

    public void c(BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1021214);
        httpMessage.setTag(bdUniqueId);
        httpMessage.addParam("ar_token", com.baidu.live.d.xc().getString("sp_ar_makeup_token", ""));
        String str = Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (b.fR(TbadkCoreApplication.getInst().getContext()) ? 1 : 0);
        httpMessage.addParam("uh", str);
        String str2 = Build.MODEL + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.RELEASE + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.SDK_INT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.BRAND.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "");
        httpMessage.addParam("ut", str2);
        httpMessage.addParam("arVersion", com.baidu.minivideo.arface.b.getVersion());
        MessageManager.getInstance().sendMessage(httpMessage);
        if (h.isDebug()) {
            h.d("MKNetLoader", "requestMakeupParams: " + str + ", " + str2);
        }
    }

    private void bPt() {
        String str = TbConfig.SERVER_ADDRESS + "ala/sys/getBeautyConf";
        if (h.isDebug()) {
            h.d("MKNetLoader", "registerFilterAndBeautyTask: " + str);
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021214, str);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaMakeupResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        if (h.isDebug()) {
            h.d("MKNetLoader", "registerListener: " + this.gsi);
        }
        registerListener(this.gsi);
    }

    private void unregisterListener() {
        if (h.isDebug()) {
            h.d("MKNetLoader", "unregisterListener: " + this.gsi);
        }
        MessageManager.getInstance().unRegisterListener(this.gsi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.makeup.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.c(i.this.aCW);
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
    public void g(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null) {
            h.d("MKNetLoader", "onGetMakeup(HttpResponsedMessage msg == null");
            return;
        }
        AlaMakeupResponseMessage alaMakeupResponseMessage = (AlaMakeupResponseMessage) httpResponsedMessage;
        this.gsh = alaMakeupResponseMessage.bPo();
        if (h.isDebug()) {
            h.d("MKNetLoader", "onGetMakeup: " + (this.gsh == null ? "null" : Integer.valueOf(this.gsh.size())));
        }
        if (this.gsh != null && alaMakeupResponseMessage.getOrginalMessage() != null) {
            this.gsh.aCj = alaMakeupResponseMessage.getOrginalMessage().getTag();
        }
        if (this.gsh != null) {
            aF(this.gsh.aCb, com.baidu.minivideo.arface.a.getVersion());
        }
        if (this.mLoadDataCallBack != null) {
            this.mLoadDataCallBack.callback(this.gsh);
        }
    }

    public void aF(String str, int i) {
        if (!StringUtils.isNullObject(str)) {
            com.baidu.live.d.xc().putString("sp_ar_makeup_token", str);
        }
        if (i > 0) {
            com.baidu.live.d.xc().putInt("sp_ar_makeup_version", i);
        }
    }
}

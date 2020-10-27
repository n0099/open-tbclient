package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId gKX = BdUniqueId.gen();
    public static final BdUniqueId gKY = BdUniqueId.gen();
    private boolean bhu;
    private a gKU;
    private int gKZ;
    private PersonListActivity gLa;
    private int gLb;
    private int gLc;
    private String gLd;
    public HttpMessageListener gLe;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        e a(e eVar, boolean z);

        void aB(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.gKZ = 0;
        this.gLb = 0;
        this.gLe = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.gKU != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.gLa.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.gKU.aB(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bTf = ((ResponseNetPersonListMessage) httpResponsedMessage).bTf();
                    if (bTf != null) {
                        if (!StringUtils.isNull(bTf.ewv)) {
                            f.this.gLd = bTf.ewv;
                            f.this.gLc = bTf.type;
                        }
                        bTf.type = f.this.gLc;
                        bTf.ewv = f.this.gLd;
                    }
                    if (f.this.gKU != null) {
                        f.this.gKU.a(bTf, false);
                    }
                }
            }
        };
        this.gLa = personListActivity;
        this.bhu = false;
        this.mId = null;
        this.gKU = aVar;
        bMg();
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public void mu(boolean z) {
        this.bhu = z;
    }

    public boolean bTd() {
        return this.bhu;
    }

    private void bMg() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bhu) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.gLe);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bTe() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.bhu) {
            httpMessage.setTag(gKY);
        } else {
            httpMessage.setTag(gKX);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.gKZ != 0) {
            this.gKZ++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.gKZ));
        }
        httpMessage.addParam("tab", this.gLb);
        hashMap.put("page", String.valueOf(this.gKZ));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}

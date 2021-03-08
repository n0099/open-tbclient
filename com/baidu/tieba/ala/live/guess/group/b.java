package com.baidu.tieba.ala.live.guess.group;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.an.c;
import com.baidu.live.data.bm;
import com.baidu.live.guess.d;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class b implements d {
    private bm hiv;
    private CustomMessageListener hiw = new CustomMessageListener(2913298) { // from class: com.baidu.tieba.ala.live.guess.group.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bm)) {
                b.this.hiv = (bm) customResponsedMessage.getData();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mContext);
                    com.baidu.live.d.xf().putString("live_join_group", b.this.hiv.toUserId);
                    return;
                }
                b.this.bXF();
            }
        }
    };
    private HttpMessageListener hix = new HttpMessageListener(1021238) { // from class: com.baidu.tieba.ala.live.guess.group.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021238) {
                if ((httpResponsedMessage instanceof JoinGroupHttpResponseMessage) || httpResponsedMessage.hasError()) {
                    b.this.a((JoinGroupHttpResponseMessage) httpResponsedMessage);
                }
            }
        }
    };
    private Context mContext;

    public b() {
    }

    public b(Context context) {
        this.mContext = context;
    }

    static {
        bXE();
    }

    private static void bXE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021238, TbConfig.SERVER_QUANMIN_ADDRESS + "pubshow/team/addteam");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JoinGroupHttpResponseMessage.class);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bXu() {
        String string = com.baidu.live.d.xf().getString("live_join_group", "");
        if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(string)) {
            if (this.hiv == null) {
                this.hiv = new bm();
            }
            this.hiv.toUserId = string;
            bXF();
            com.baidu.live.d.xf().putString("live_join_group", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXF() {
        if (this.hiv != null) {
            if (TextUtils.isEmpty(this.hiv.aQA)) {
                this.hiv.aQA = TbadkCoreApplication.getCurrentAccount();
            }
            this.hiv.aQA = ExtraParamsManager.getEncryptionUserId(this.hiv.aQA);
            this.hiv.toUserId = ExtraParamsManager.getEncryptionUserId(this.hiv.toUserId);
            es(this.hiv.toUserId, this.hiv.aQA);
        }
    }

    private void es(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021238);
        httpMessage.addParam("to_user_id", str);
        httpMessage.addParam("from_user_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JoinGroupHttpResponseMessage joinGroupHttpResponseMessage) {
        if (joinGroupHttpResponseMessage != null) {
            if (joinGroupHttpResponseMessage.status == 0) {
                c cVar = new c();
                cVar.url = joinGroupHttpResponseMessage.url;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
            }
            BdUtilHelper.showToast(this.mContext, joinGroupHttpResponseMessage.msg);
        }
    }

    @Override // com.baidu.live.guess.d
    public void register() {
        MessageManager.getInstance().registerListener(this.hix);
        MessageManager.getInstance().registerListener(this.hiw);
    }

    @Override // com.baidu.live.guess.d
    public void unRegister() {
        MessageManager.getInstance().unRegisterListener(this.hix);
        MessageManager.getInstance().unRegisterListener(this.hiw);
    }
}

package com.baidu.tieba.ala.c;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.data.RedPktSendHttpResponseMessage;
import com.baidu.tieba.ala.data.p;
/* loaded from: classes7.dex */
public class c {
    private Activity activity;
    private d fST;
    private String liveId;
    private String roomId;
    private HttpMessageListener fSU = new HttpMessageListener(1021159) { // from class: com.baidu.tieba.ala.c.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (c.this.activity.isDestroyed() || c.this.activity.isFinishing()) {
                    return;
                }
            } else if (c.this.activity.isFinishing()) {
                return;
            }
            if ((httpResponsedMessage instanceof RedPktSendHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                com.baidu.live.m.a.a(c.this.liveId, ((RedPktSendHttpResponseMessage) httpResponsedMessage).fVi, ((RedPktSendHttpResponseMessage) httpResponsedMessage).fVj, "send_redpacket");
                c.this.activity.finish();
                return;
            }
            if (httpResponsedMessage.getError() == 3501) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(c.this.activity, 0L, "", true, "", true)));
            } else if (!TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                BdUtilHelper.showToast(c.this.activity, httpResponsedMessage.getErrorString());
            }
            if (c.this.fST != null) {
                c.this.fST.la(true);
            }
        }
    };
    private CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.c.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (c.this.activity.isDestroyed() || c.this.activity.isFinishing()) {
                    return;
                }
            } else if (c.this.activity.isFinishing()) {
                return;
            }
            c.this.activity.finish();
        }
    };

    public c(Activity activity) {
        this.activity = activity;
        initView();
        bIE();
    }

    private void initView() {
        if (this.activity != null && this.activity.getIntent() != null) {
            Intent intent = this.activity.getIntent();
            this.liveId = intent.getStringExtra("live_id");
            this.roomId = intent.getStringExtra("room_id");
        }
        this.fST = new d(this.activity, this);
    }

    private static void bID() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021159, TbConfig.SERVER_HOST + "liveserver/redpacket/send");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(RedPktSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bIE() {
        bID();
        MessageManager.getInstance().registerListener(this.fSU);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021159);
        MessageManager.getInstance().unRegisterListener(this.fSU);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
    }

    public View getView() {
        if (this.fST != null) {
            return this.fST.getView();
        }
        return null;
    }

    public void a(p pVar) {
        if (pVar != null) {
            pVar.gb(this.liveId);
            pVar.gS(this.roomId);
            pVar.setParams();
            MessageManager.getInstance().sendMessage(pVar);
            if (this.fST != null) {
                this.fST.la(false);
            }
        }
    }

    public void Fq() {
        if (this.fST != null) {
            this.fST.Fq();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fST != null) {
            this.fST.onKeyboardVisibilityChanged(z);
        }
    }
}

package com.baidu.tieba.ala.b;

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
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.data.RedPktSendHttpResponseMessage;
import com.baidu.tieba.ala.data.o;
/* loaded from: classes3.dex */
public class a {
    private Activity activity;
    private b eyp;
    private String liveId;
    private String roomId;
    private HttpMessageListener eyq = new HttpMessageListener(1021159) { // from class: com.baidu.tieba.ala.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (a.this.activity.isDestroyed() || a.this.activity.isFinishing()) {
                    return;
                }
            } else if (a.this.activity.isFinishing()) {
                return;
            }
            if ((httpResponsedMessage instanceof RedPktSendHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                com.baidu.live.l.a.a(a.this.liveId, ((RedPktSendHttpResponseMessage) httpResponsedMessage).eAB, ((RedPktSendHttpResponseMessage) httpResponsedMessage).eAC, "send_redpacket");
                a.this.activity.finish();
                return;
            }
            if (httpResponsedMessage.getError() == 3501) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(a.this.activity, 0L, "", true, "", true)));
            } else if (!TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                UtilHelper.showToast(a.this.activity, httpResponsedMessage.getErrorString());
            }
            if (a.this.eyp != null) {
                a.this.eyp.io(true);
            }
        }
    };
    private CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (a.this.activity.isDestroyed() || a.this.activity.isFinishing()) {
                    return;
                }
            } else if (a.this.activity.isFinishing()) {
                return;
            }
            a.this.activity.finish();
        }
    };

    public a(Activity activity) {
        this.activity = activity;
        initView();
        bef();
    }

    private void initView() {
        if (this.activity != null && this.activity.getIntent() != null) {
            Intent intent = this.activity.getIntent();
            this.liveId = intent.getStringExtra("live_id");
            this.roomId = intent.getStringExtra("room_id");
        }
        this.eyp = new b(this.activity, this);
    }

    private static void bee() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021159, TbConfig.SERVER_HOST + "liveserver/redpacket/send");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(RedPktSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bef() {
        bee();
        MessageManager.getInstance().registerListener(this.eyq);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021159);
        MessageManager.getInstance().unRegisterListener(this.eyq);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
    }

    public View getView() {
        if (this.eyp != null) {
            return this.eyp.getView();
        }
        return null;
    }

    public void a(o oVar) {
        if (oVar != null) {
            oVar.dO(this.liveId);
            oVar.dP(this.roomId);
            oVar.setParams();
            MessageManager.getInstance().sendMessage(oVar);
            if (this.eyp != null) {
                this.eyp.io(false);
            }
        }
    }

    public void ta() {
        if (this.eyp != null) {
            this.eyp.ta();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eyp != null) {
            this.eyp.onKeyboardVisibilityChanged(z);
        }
    }
}

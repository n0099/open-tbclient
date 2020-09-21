package com.baidu.tieba.ala.d;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.data.RedPktSendHttpResponseMessage;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes4.dex */
public class d {
    private Activity activity;
    private e fWk;
    private String liveId;
    private String roomId;
    private HttpMessageListener fWl = new HttpMessageListener(1021159) { // from class: com.baidu.tieba.ala.d.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (d.this.activity.isDestroyed() || d.this.activity.isFinishing()) {
                    return;
                }
            } else if (d.this.activity.isFinishing()) {
                return;
            }
            if (httpResponsedMessage instanceof RedPktSendHttpResponseMessage) {
                RedPktSendHttpResponseMessage redPktSendHttpResponseMessage = (RedPktSendHttpResponseMessage) httpResponsedMessage;
                long logId = redPktSendHttpResponseMessage.getLogId();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue(BaseJsonData.TAG_ERRNO, Integer.valueOf(redPktSendHttpResponseMessage.getError()));
                alaStatsItem.addValue("redpacketId", Long.valueOf(redPktSendHttpResponseMessage.fYz));
                AlaStatManager.getInstance().debug("redpacket_send_result", logId, "", alaStatsItem);
            }
            if ((httpResponsedMessage instanceof RedPktSendHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                com.baidu.live.n.a.a(d.this.liveId, ((RedPktSendHttpResponseMessage) httpResponsedMessage).fYz, ((RedPktSendHttpResponseMessage) httpResponsedMessage).fYA, "send_redpacket");
                d.this.activity.finish();
                try {
                    com.baidu.live.m.a.b(Long.parseLong(d.this.liveId), 8);
                    return;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (httpResponsedMessage.getError() == 3501) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(d.this.activity, 0L, "", true, "", true)));
            } else if (!TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                BdUtilHelper.showToast(d.this.activity, httpResponsedMessage.getErrorString());
            }
            if (d.this.fWk != null) {
                d.this.fWk.le(true);
            }
        }
    };
    private CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.d.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (d.this.activity.isDestroyed() || d.this.activity.isFinishing()) {
                    return;
                }
            } else if (d.this.activity.isFinishing()) {
                return;
            }
            d.this.activity.finish();
        }
    };

    public d(Activity activity) {
        this.activity = activity;
        initView();
        bJO();
    }

    private void initView() {
        if (this.activity != null && this.activity.getIntent() != null) {
            Intent intent = this.activity.getIntent();
            this.liveId = intent.getStringExtra("live_id");
            this.roomId = intent.getStringExtra("room_id");
        }
        this.fWk = new e(this.activity, this);
    }

    private static void bJN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021159, TbConfig.SERVER_HOST + "liveserver/redpacket/send");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(RedPktSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bJO() {
        bJN();
        MessageManager.getInstance().registerListener(this.fWl);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021159);
        MessageManager.getInstance().unRegisterListener(this.fWl);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
    }

    public View getView() {
        if (this.fWk != null) {
            return this.fWk.getView();
        }
        return null;
    }

    public void a(q qVar) {
        if (qVar != null) {
            qVar.gi(this.liveId);
            qVar.hg(this.roomId);
            qVar.setParams();
            MessageManager.getInstance().sendMessage(qVar);
            if (this.fWk != null) {
                this.fWk.le(false);
            }
        }
    }

    public void FQ() {
        if (this.fWk != null) {
            this.fWk.FQ();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fWk != null) {
            this.fWk.onKeyboardVisibilityChanged(z);
        }
    }
}

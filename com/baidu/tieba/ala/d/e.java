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
import com.baidu.tieba.ala.data.s;
/* loaded from: classes11.dex */
public class e {
    private Activity activity;
    private f gQX;
    private String liveId;
    private String roomId;
    private HttpMessageListener gQY = new HttpMessageListener(1021159) { // from class: com.baidu.tieba.ala.d.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (e.this.activity.isDestroyed() || e.this.activity.isFinishing()) {
                    return;
                }
            } else if (e.this.activity.isFinishing()) {
                return;
            }
            if (httpResponsedMessage instanceof RedPktSendHttpResponseMessage) {
                RedPktSendHttpResponseMessage redPktSendHttpResponseMessage = (RedPktSendHttpResponseMessage) httpResponsedMessage;
                long logId = redPktSendHttpResponseMessage.getLogId();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue(BaseJsonData.TAG_ERRNO, Integer.valueOf(redPktSendHttpResponseMessage.getError()));
                alaStatsItem.addValue("redpacketId", Long.valueOf(redPktSendHttpResponseMessage.gTv));
                AlaStatManager.getInstance().debug("redpacket_send_result", logId, "", alaStatsItem);
            }
            if ((httpResponsedMessage instanceof RedPktSendHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                com.baidu.live.q.a.a(e.this.liveId, ((RedPktSendHttpResponseMessage) httpResponsedMessage).gTv, ((RedPktSendHttpResponseMessage) httpResponsedMessage).gTw, "send_redpacket");
                e.this.activity.finish();
                try {
                    com.baidu.live.p.a.c(Long.parseLong(e.this.liveId), 8);
                    return;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (httpResponsedMessage.getError() == 3501) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(e.this.activity, 0L, "", true, "", true)));
            } else if (!TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                BdUtilHelper.showToast(e.this.activity, httpResponsedMessage.getErrorString());
            }
            if (e.this.gQX != null) {
                e.this.gQX.mY(true);
            }
        }
    };
    private CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.d.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (e.this.activity.isDestroyed() || e.this.activity.isFinishing()) {
                    return;
                }
            } else if (e.this.activity.isFinishing()) {
                return;
            }
            e.this.activity.finish();
        }
    };

    public e(Activity activity) {
        this.activity = activity;
        initView();
        bUc();
    }

    private void initView() {
        if (this.activity != null && this.activity.getIntent() != null) {
            Intent intent = this.activity.getIntent();
            this.liveId = intent.getStringExtra("live_id");
            this.roomId = intent.getStringExtra("room_id");
        }
        this.gQX = new f(this.activity, this);
    }

    private static void bUb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021159, TbConfig.SERVER_HOST + "liveserver/redpacket/send");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(RedPktSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bUc() {
        bUb();
        MessageManager.getInstance().registerListener(this.gQY);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021159);
        MessageManager.getInstance().unRegisterListener(this.gQY);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
    }

    public View getView() {
        if (this.gQX != null) {
            return this.gQX.getView();
        }
        return null;
    }

    public void a(s sVar) {
        if (sVar != null) {
            sVar.setLiveId(this.liveId);
            sVar.setRoomId(this.roomId);
            sVar.setParams();
            MessageManager.getInstance().sendMessage(sVar);
            if (this.gQX != null) {
                this.gQX.mY(false);
            }
        }
    }

    public void FN() {
        if (this.gQX != null) {
            this.gQX.FN();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gQX != null) {
            this.gQX.onKeyboardVisibilityChanged(z);
        }
    }
}

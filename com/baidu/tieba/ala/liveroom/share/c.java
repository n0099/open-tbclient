package com.baidu.tieba.ala.liveroom.share;

import android.os.Handler;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.model.a;
/* loaded from: classes3.dex */
public class c {
    private q aLQ;
    private BlueCircleProgressDialog bjG;
    private com.baidu.live.tieba.model.a gre;
    private a.InterfaceC0186a grf = new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.share.c.2
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bJl();
    }

    public void c(q qVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (qVar != null && qVar.axp != null && qVar.mLiveInfo != null) {
            this.aLQ = qVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(qVar.axp.userId + "", qVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                r rVar = new r();
                if (this.mPageContext != null) {
                    rVar.activity = this.mPageContext.getPageActivity();
                }
                rVar.axW = this.aLQ;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, rVar));
            }
        }
    }

    private void bJl() {
        this.mPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.liveroom.share.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aLQ != null && c.this.aLQ.axp != null && c.this.aLQ.axp.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aLQ.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aLQ.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                    c.this.bJm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJm() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", LogConfig.VALUE_LIVE_SHARE_TO));
    }

    private void bJn() {
        if (this.bjG != null) {
            this.bjG.setDialogVisiable(false);
        }
    }

    public void vH() {
        bJn();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gre != null) {
            this.gre.If();
        }
    }

    public void onDestroy() {
        bJn();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gre != null) {
            this.gre.If();
            this.gre.onDestroy();
        }
    }
}

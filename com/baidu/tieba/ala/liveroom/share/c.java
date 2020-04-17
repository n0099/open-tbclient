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
import com.baidu.live.data.n;
import com.baidu.live.data.o;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.model.a;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private n aDE;
    private BlueCircleProgressDialog aWX;
    private com.baidu.live.tieba.model.a fPk;
    private a.InterfaceC0125a fPl = new a.InterfaceC0125a() { // from class: com.baidu.tieba.ala.liveroom.share.c.2
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bzS();
    }

    public void c(n nVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (nVar != null && nVar.aqe != null && nVar.mLiveInfo != null) {
            this.aDE = nVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(nVar.aqe.userId + "", nVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                o oVar = new o();
                if (this.mPageContext != null) {
                    oVar.activity = this.mPageContext.getPageActivity();
                }
                oVar.aqK = this.aDE;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, oVar));
            }
        }
    }

    private void bzS() {
        this.mPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.liveroom.share.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aDE != null && c.this.aDE.aqe != null && c.this.aDE.aqe.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aDE.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aDE.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                    c.this.bzT();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzT() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1395", "click", "liveroom", LogConfig.VALUE_LIVE_SHARE_TO));
    }

    private void bzU() {
        if (this.aWX != null) {
            this.aWX.setDialogVisiable(false);
        }
    }

    public void ug() {
        bzU();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fPk != null) {
            this.fPk.Fc();
        }
    }

    public void onDestroy() {
        bzU();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fPk != null) {
            this.fPk.Fc();
            this.fPk.onDestroy();
        }
    }
}

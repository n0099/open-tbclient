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
import com.baidu.live.data.w;
import com.baidu.live.data.x;
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
/* loaded from: classes4.dex */
public class c {
    private w aFN;
    private BlueCircleProgressDialog bIB;
    private com.baidu.live.tieba.model.a hBQ;
    private a.InterfaceC0223a hBR = new a.InterfaceC0223a() { // from class: com.baidu.tieba.ala.liveroom.share.c.2
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ckr();
    }

    public void c(w wVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.h.sdk_neterror);
        } else if (wVar != null && wVar.aJV != null && wVar.mLiveInfo != null) {
            this.aFN = wVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(wVar.aJV.userId + "", wVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                x xVar = new x();
                if (this.mPageContext != null) {
                    xVar.activity = this.mPageContext.getPageActivity();
                }
                xVar.alaLiveShowData = this.aFN;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, xVar));
            }
        }
    }

    private void ckr() {
        this.mPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.liveroom.share.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aFN != null && c.this.aFN.aJV != null && c.this.aFN.aJV.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aFN.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aFN.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                    c.this.cks();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cks() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", LogConfig.VALUE_LIVE_SHARE_TO));
    }

    private void ckt() {
        if (this.bIB != null) {
            this.bIB.setDialogVisiable(false);
        }
    }

    public void En() {
        ckt();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hBQ != null) {
            this.hBQ.Vg();
        }
    }

    public void onDestroy() {
        ckt();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hBQ != null) {
            this.hBQ.Vg();
            this.hBQ.onDestroy();
        }
    }
}

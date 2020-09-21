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
import com.baidu.live.data.u;
import com.baidu.live.data.v;
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
    private u aAP;
    private BlueCircleProgressDialog bsR;
    private com.baidu.live.tieba.model.a gLU;
    private a.InterfaceC0195a gLV = new a.InterfaceC0195a() { // from class: com.baidu.tieba.ala.liveroom.share.c.2
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bXX();
    }

    public void c(u uVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (uVar != null && uVar.aEz != null && uVar.mLiveInfo != null) {
            this.aAP = uVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(uVar.aEz.userId + "", uVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                v vVar = new v();
                if (this.mPageContext != null) {
                    vVar.activity = this.mPageContext.getPageActivity();
                }
                vVar.alaLiveShowData = this.aAP;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, vVar));
            }
        }
    }

    private void bXX() {
        this.mPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.liveroom.share.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aAP != null && c.this.aAP.aEz != null && c.this.aAP.aEz.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aAP.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aAP.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                    c.this.bXY();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXY() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", LogConfig.VALUE_LIVE_SHARE_TO));
    }

    private void bXZ() {
        if (this.bsR != null) {
            this.bsR.setDialogVisiable(false);
        }
    }

    public void BQ() {
        bXZ();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gLU != null) {
            this.gLU.OH();
        }
    }

    public void onDestroy() {
        bXZ();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gLU != null) {
            this.gLU.OH();
            this.gLU.onDestroy();
        }
    }
}

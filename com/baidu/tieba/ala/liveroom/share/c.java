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
import com.baidu.live.data.r;
import com.baidu.live.data.s;
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
/* loaded from: classes7.dex */
public class c {
    private r aAh;
    private BlueCircleProgressDialog bpF;
    private com.baidu.live.tieba.model.a gIz;
    private TbPageContext mPageContext;
    private a.InterfaceC0195a gIA = new a.InterfaceC0195a() { // from class: com.baidu.tieba.ala.liveroom.share.c.2
    };
    private Handler mHandler = new Handler();

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bWo();
    }

    public void c(r rVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (rVar != null && rVar.aDE != null && rVar.mLiveInfo != null) {
            this.aAh = rVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(rVar.aDE.userId + "", rVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                s sVar = new s();
                if (this.mPageContext != null) {
                    sVar.activity = this.mPageContext.getPageActivity();
                }
                sVar.aEt = this.aAh;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, sVar));
            }
        }
    }

    private void bWo() {
        this.mPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.liveroom.share.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aAh != null && c.this.aAh.aDE != null && c.this.aAh.aDE.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aAh.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aAh.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                    c.this.bWp();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWp() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", LogConfig.VALUE_LIVE_SHARE_TO));
    }

    private void bWq() {
        if (this.bpF != null) {
            this.bpF.setDialogVisiable(false);
        }
    }

    public void BB() {
        bWq();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gIz != null) {
            this.gIz.Oe();
        }
    }

    public void onDestroy() {
        bWq();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gIz != null) {
            this.gIz.Oe();
            this.gIz.onDestroy();
        }
    }
}

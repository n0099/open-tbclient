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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.model.a;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private q aJj;
    private BlueCircleProgressDialog bev;
    private com.baidu.live.tieba.model.a gdZ;
    private a.InterfaceC0179a gea = new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.share.c.2
    };
    private Handler mHandler = new Handler();
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bGd();
    }

    public void c(q qVar, boolean z) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), a.i.sdk_neterror);
        } else if (qVar != null && qVar.avj != null && qVar.mLiveInfo != null) {
            this.aJj = qVar;
            LogManager.getMigrateFromTiebaLogger().doClickShareLog(qVar.avj.userId + "", qVar.mLiveInfo.live_id + "");
            if (TbadkCoreApplication.IS_SDK) {
                r rVar = new r();
                if (this.mPageContext != null) {
                    rVar.activity = this.mPageContext.getPageActivity();
                }
                rVar.avQ = this.aJj;
                MessageManager.getInstance().sendMessage(new CustomMessage(2913077, rVar));
            }
        }
    }

    private void bGd() {
        this.mPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.liveroom.share.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aJj != null && c.this.aJj.avj != null && c.this.aJj.avj.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aJj.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.share.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aJj.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                    c.this.bGe();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGe() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", LogConfig.VALUE_LIVE_SHARE_TO));
    }

    private void bGf() {
        if (this.bev != null) {
            this.bev.setDialogVisiable(false);
        }
    }

    public void vm() {
        bGf();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gdZ != null) {
            this.gdZ.GS();
        }
    }

    public void onDestroy() {
        bGf();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gdZ != null) {
            this.gdZ.GS();
            this.gdZ.onDestroy();
        }
    }
}

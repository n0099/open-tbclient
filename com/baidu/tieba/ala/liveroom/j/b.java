package com.baidu.tieba.ala.liveroom.j;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.n;
import com.baidu.tieba.ala.liveroom.j.a;
import com.baidu.tieba.ala.liveroom.q.e;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class b {
    private ViewGroup bIc;
    protected c hhV;
    private TimerTask hhW;
    private com.baidu.tieba.ala.liveroom.q.e hhX;
    private com.baidu.tieba.ala.liveroom.data.c hhY;
    private ApkData hhZ;
    private f hia;
    private a hib;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String gEO = "";
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a hif;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cbq();
            String str = null;
            String str2 = "";
            if (b.this.hia != null && b.this.hhZ != null) {
                ApkStatus a2 = b.this.hia.a(b.this.hhZ);
                if (a2 == ApkStatus.READY) {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_launch);
                    str2 = "gentazou";
                } else if (a2 == ApkStatus.NEED_UPDATE) {
                    b.this.mTbPageContext.showToast(a.h.ala_feedback_flow_low_version_tip);
                    return;
                } else if (a2 == ApkStatus.DOWNLOADED) {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_install);
                    str2 = "anzhuang";
                } else {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_download);
                    str2 = "xiazai";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.hif == null) {
                    this.hif = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.hif.a(new a.InterfaceC0677a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0677a
                        public void cbn() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0677a
                        public void cbo() {
                            if (b.this.hia != null && b.this.hhZ != null) {
                                b.this.hia.b(b.this.hhZ);
                            }
                        }
                    });
                }
                if (b.this.hhY != null && b.this.hhY.aHB != null) {
                    this.hif.HC(b.this.hhY.aHB);
                }
                if (b.this.hhY != null && b.this.hhY.portrait != null) {
                    this.hif.HB(b.this.hhY.getPortrait());
                }
                String str3 = "";
                if (b.this.hhY != null) {
                    str3 = b.this.hhY.getSubappType();
                }
                this.hif.HD(str);
                this.hif.setRoomId(b.this.roomId);
                this.hif.HE(str2);
                this.hif.HF(str3);
                this.hif.show();
                n.cY(true);
                if (b.this.hhY != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hhY.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hhY.getSubappType());
                }
            }
        }
    };
    CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
            }
        }
    };
    e.a hic = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hhY = cVar;
            if (b.this.hia != null) {
                b.this.hia.HF(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hhZ = new ApkData();
                b.this.hhZ.apkUrl = cVar.appUrl;
                b.this.hhZ.apkPackageName = cVar.packageName;
                b.this.hhZ.apkClipBoardScheme = cVar.hgu;
                b.this.hhZ.apkDeeplinkScheme = cVar.hgs;
                b.this.hhZ.apkOldDeeplinkScheme = cVar.hgt;
                g.we(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void bh(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes4.dex */
    public interface a {
        void bXg();

        void bXh();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hia = fVar;
        this.hib = aVar;
        MessageManager.getInstance().registerListener(this.guV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ak(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hhV == null) {
            this.hhV = new c(getPageContext(), this.fhp);
        }
        cbq();
        this.bIc = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hhV == null) {
            return null;
        }
        return this.hhV.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ak(viewGroup)) {
                if (this.hia == null || !this.hia.isDownloading()) {
                    if (!cbp()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hib != null) {
                        this.hib.bXg();
                    }
                    this.bIc.addView(this.hhV.getView(), layoutParams);
                    n.aW(this.roomId);
                    if (this.hhY != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hhY.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cbq()) {
                                n.cY(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cbp() {
        return (this.hhZ == null || TextUtils.isEmpty(this.hhZ.apkPackageName) || TextUtils.isEmpty(this.hhZ.apkUrl) || TextUtils.isEmpty(this.hhZ.apkDeeplinkScheme) || TextUtils.isEmpty(this.hhZ.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbq() {
        if (this.bIc == null || this.bIc.indexOfChild(this.hhV.getView()) < 0) {
            return false;
        }
        this.bIc.removeView(this.hhV.getView());
        g.wf(2913168);
        if (this.hib != null) {
            this.hib.bXh();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.guV);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.hhW != null) {
            this.hhW.cancel();
        }
        this.hhW = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.b(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.hhW, j);
    }

    public void b(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.hhX == null) {
                    b.this.hhX = new com.baidu.tieba.ala.liveroom.q.e(b.this.mTbPageContext, b.this.hic);
                }
                b.this.hhX.h(str, str2, j);
            }
        }, j2);
    }

    public void CD() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cbq()) {
            n.cY(false);
        }
    }

    public void cancel() {
        if (this.hhW != null) {
            this.hhW.cancel();
        }
        if (this.hhX != null) {
            this.hhX.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w Gz = aVar.hgk.Gz();
        AlaLiveInfoData cfQ = aVar.hgk.cfQ();
        if (n.aX(cfQ.room_id) && Gz != null && Gz.aHV != null && Gz.aHV.needToast == 1) {
            c(Gz.aHV.watchDurationMust, cfQ.live_id + "", cfQ.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w Gz = aVar.hgk.Gz();
        if (Gz != null && aVar != null && this.handler != null && Gz.aHV != null && Gz.aHV.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Gz.aHV.watchDurationMust) {
            AlaLiveInfoData cfQ = aVar.hgk.cfQ();
            if (n.aX(this.roomId)) {
                b(cfQ.live_id + "", cfQ.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

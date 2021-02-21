package com.baidu.tieba.ala.liveroom.i;

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
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.o;
import com.baidu.tieba.ala.liveroom.i.a;
import com.baidu.tieba.ala.liveroom.n.e;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class b {
    private ViewGroup bRb;
    protected c hDp;
    private com.baidu.tieba.ala.liveroom.n.e hDq;
    private com.baidu.tieba.ala.liveroom.data.c hDr;
    private f hDs;
    private a hDt;
    private ApkData hqc;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    private TimerTask mTimerTask;
    public String otherParams;
    private long roomId;
    private String gXT = "";
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.b.2
        private com.baidu.tieba.ala.liveroom.i.a hDw;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cfl();
            String str = null;
            String str2 = "";
            if (b.this.hDs != null && b.this.hqc != null) {
                ApkStatus b2 = b.this.hDs.b(b.this.hqc);
                if (b2 == ApkStatus.READY) {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_launch);
                    str2 = "gentazou";
                } else if (b2 == ApkStatus.NEED_UPDATE) {
                    b.this.mTbPageContext.showToast(a.h.ala_feedback_flow_low_version_tip);
                    return;
                } else if (b2 == ApkStatus.DOWNLOADED) {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_install);
                    str2 = "anzhuang";
                } else {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_download);
                    str2 = "xiazai";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.hDw == null) {
                    this.hDw = new com.baidu.tieba.ala.liveroom.i.a(b.this.getPageContext().getPageActivity());
                    this.hDw.a(new a.InterfaceC0667a() { // from class: com.baidu.tieba.ala.liveroom.i.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0667a
                        public void cfi() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0667a
                        public void cfj() {
                            if (b.this.hDs != null && b.this.hqc != null) {
                                b.this.hDs.c(b.this.hqc);
                            }
                        }
                    });
                }
                if (b.this.hDr != null && b.this.hDr.aIu != null) {
                    this.hDw.HL(b.this.hDr.aIu);
                }
                if (b.this.hDr != null && b.this.hDr.portrait != null) {
                    this.hDw.HK(b.this.hDr.getPortrait());
                }
                String str3 = "";
                if (b.this.hDr != null) {
                    str3 = b.this.hDr.getSubappType();
                }
                this.hDw.HM(str);
                this.hDw.setRoomId(b.this.roomId);
                this.hDw.HN(str2);
                this.hDw.HO(str3);
                this.hDw.show();
                o.dt(true);
                if (b.this.hDr != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hDr.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hDr.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.i.b.3
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
    e.a hDu = new e.a() { // from class: com.baidu.tieba.ala.liveroom.i.b.6
        @Override // com.baidu.tieba.ala.liveroom.n.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hDr = cVar;
            if (b.this.hDs != null) {
                b.this.hDs.HO(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hqc = new ApkData();
                b.this.hqc.apkUrl = cVar.appUrl;
                b.this.hqc.apkPackageName = cVar.packageName;
                b.this.hqc.apkClipBoardScheme = cVar.hBR;
                b.this.hqc.apkDeeplinkScheme = cVar.hBP;
                b.this.hqc.apkOldDeeplinkScheme = cVar.hBQ;
                g.vz(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.n.e.a
        public void bp(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes11.dex */
    public interface a {
        void caQ();

        void caR();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hDs = fVar;
        this.hDt = aVar;
        MessageManager.getInstance().registerListener(this.gNG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean au(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hDp == null) {
            this.hDp = new c(getPageContext(), this.onClickListener);
        }
        cfl();
        this.bRb = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hDp == null) {
            return null;
        }
        return this.hDp.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && au(viewGroup)) {
                if (this.hDs == null || !this.hDs.isDownloading()) {
                    if (!cfk()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hDt != null) {
                        this.hDt.caQ();
                    }
                    this.bRb.addView(this.hDp.getView(), layoutParams);
                    o.by(this.roomId);
                    if (this.hDr != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hDr.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cfl()) {
                                o.dt(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cfk() {
        return (this.hqc == null || TextUtils.isEmpty(this.hqc.apkPackageName) || TextUtils.isEmpty(this.hqc.apkUrl) || TextUtils.isEmpty(this.hqc.apkDeeplinkScheme) || TextUtils.isEmpty(this.hqc.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfl() {
        if (this.bRb == null || this.bRb.indexOfChild(this.hDp.getView()) < 0) {
            return false;
        }
        this.bRb.removeView(this.hDp.getView());
        g.vA(2913168);
        if (this.hDt != null) {
            this.hDt.caR();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gNG);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
        }
        this.mTimerTask = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.i.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.b(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.mTimerTask, j);
    }

    public void b(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.hDq == null) {
                    b.this.hDq = new com.baidu.tieba.ala.liveroom.n.e(b.this.mTbPageContext, b.this.hDu);
                }
                b.this.hDq.j(str, str2, j);
            }
        }, j2);
    }

    public void Ar() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cfl()) {
            o.dt(false);
        }
    }

    public void cancel() {
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
        }
        if (this.hDq != null) {
            this.hDq.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        ab Fm = aVar.hBH.Fm();
        AlaLiveInfoData cjG = aVar.hBH.cjG();
        if (o.bz(cjG.room_id) && Fm != null && Fm.aIQ != null && Fm.aIQ.needToast == 1) {
            c(Fm.aIQ.watchDurationMust, cjG.live_id + "", cjG.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        ab Fm = aVar.hBH.Fm();
        if (Fm != null && aVar != null && this.handler != null && Fm.aIQ != null && Fm.aIQ.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Fm.aIQ.watchDurationMust) {
            AlaLiveInfoData cjG = aVar.hBH.cjG();
            if (o.bz(this.roomId)) {
                b(cjG.live_id + "", cjG.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

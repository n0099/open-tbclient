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
/* loaded from: classes10.dex */
public class b {
    private ViewGroup bSB;
    protected c hEY;
    private com.baidu.tieba.ala.liveroom.n.e hEZ;
    private com.baidu.tieba.ala.liveroom.data.c hFa;
    private f hFb;
    private a hFc;
    private ApkData hrL;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    private TimerTask mTimerTask;
    public String otherParams;
    private long roomId;
    private String gZC = "";
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.b.2
        private com.baidu.tieba.ala.liveroom.i.a hFf;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cfr();
            String str = null;
            String str2 = "";
            if (b.this.hFb != null && b.this.hrL != null) {
                ApkStatus b = b.this.hFb.b(b.this.hrL);
                if (b == ApkStatus.READY) {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_launch);
                    str2 = "gentazou";
                } else if (b == ApkStatus.NEED_UPDATE) {
                    b.this.mTbPageContext.showToast(a.h.ala_feedback_flow_low_version_tip);
                    return;
                } else if (b == ApkStatus.DOWNLOADED) {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_install);
                    str2 = "anzhuang";
                } else {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_download);
                    str2 = "xiazai";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.hFf == null) {
                    this.hFf = new com.baidu.tieba.ala.liveroom.i.a(b.this.getPageContext().getPageActivity());
                    this.hFf.a(new a.InterfaceC0673a() { // from class: com.baidu.tieba.ala.liveroom.i.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0673a
                        public void cfo() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0673a
                        public void cfp() {
                            if (b.this.hFb != null && b.this.hrL != null) {
                                b.this.hFb.c(b.this.hrL);
                            }
                        }
                    });
                }
                if (b.this.hFa != null && b.this.hFa.aJU != null) {
                    this.hFf.HU(b.this.hFa.aJU);
                }
                if (b.this.hFa != null && b.this.hFa.portrait != null) {
                    this.hFf.HT(b.this.hFa.getPortrait());
                }
                String str3 = "";
                if (b.this.hFa != null) {
                    str3 = b.this.hFa.getSubappType();
                }
                this.hFf.HV(str);
                this.hFf.setRoomId(b.this.roomId);
                this.hFf.HW(str2);
                this.hFf.HX(str3);
                this.hFf.show();
                o.dt(true);
                if (b.this.hFa != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hFa.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hFa.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.i.b.3
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
    e.a hFd = new e.a() { // from class: com.baidu.tieba.ala.liveroom.i.b.6
        @Override // com.baidu.tieba.ala.liveroom.n.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hFa = cVar;
            if (b.this.hFb != null) {
                b.this.hFb.HX(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hrL = new ApkData();
                b.this.hrL.apkUrl = cVar.appUrl;
                b.this.hrL.apkPackageName = cVar.packageName;
                b.this.hrL.apkClipBoardScheme = cVar.hDA;
                b.this.hrL.apkDeeplinkScheme = cVar.hDy;
                b.this.hrL.apkOldDeeplinkScheme = cVar.hDz;
                g.vB(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.n.e.a
        public void bp(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes10.dex */
    public interface a {
        void caW();

        void caX();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hFb = fVar;
        this.hFc = aVar;
        MessageManager.getInstance().registerListener(this.gPp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean au(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hEY == null) {
            this.hEY = new c(getPageContext(), this.onClickListener);
        }
        cfr();
        this.bSB = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hEY == null) {
            return null;
        }
        return this.hEY.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && au(viewGroup)) {
                if (this.hFb == null || !this.hFb.isDownloading()) {
                    if (!cfq()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hFc != null) {
                        this.hFc.caW();
                    }
                    this.bSB.addView(this.hEY.getView(), layoutParams);
                    o.by(this.roomId);
                    if (this.hFa != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hFa.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cfr()) {
                                o.dt(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cfq() {
        return (this.hrL == null || TextUtils.isEmpty(this.hrL.apkPackageName) || TextUtils.isEmpty(this.hrL.apkUrl) || TextUtils.isEmpty(this.hrL.apkDeeplinkScheme) || TextUtils.isEmpty(this.hrL.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfr() {
        if (this.bSB == null || this.bSB.indexOfChild(this.hEY.getView()) < 0) {
            return false;
        }
        this.bSB.removeView(this.hEY.getView());
        g.vC(2913168);
        if (this.hFc != null) {
            this.hFc.caX();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gPp);
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
                if (b.this.hEZ == null) {
                    b.this.hEZ = new com.baidu.tieba.ala.liveroom.n.e(b.this.mTbPageContext, b.this.hFd);
                }
                b.this.hEZ.j(str, str2, j);
            }
        }, j2);
    }

    public void Au() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cfr()) {
            o.dt(false);
        }
    }

    public void cancel() {
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
        }
        if (this.hEZ != null) {
            this.hEZ.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        ab Fp = aVar.hDq.Fp();
        AlaLiveInfoData cjM = aVar.hDq.cjM();
        if (o.bz(cjM.room_id) && Fp != null && Fp.aKq != null && Fp.aKq.needToast == 1) {
            c(Fp.aKq.watchDurationMust, cjM.live_id + "", cjM.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        ab Fp = aVar.hDq.Fp();
        if (Fp != null && aVar != null && this.handler != null && Fp.aKq != null && Fp.aKq.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Fp.aKq.watchDurationMust) {
            AlaLiveInfoData cjM = aVar.hDq.cjM();
            if (o.bz(this.roomId)) {
                b(cjM.live_id + "", cjM.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

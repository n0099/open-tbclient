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
    protected c hDb;
    private com.baidu.tieba.ala.liveroom.n.e hDc;
    private com.baidu.tieba.ala.liveroom.data.c hDd;
    private f hDe;
    private a hDf;
    private ApkData hpO;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    private TimerTask mTimerTask;
    public String otherParams;
    private long roomId;
    private String gXF = "";
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.b.2
        private com.baidu.tieba.ala.liveroom.i.a hDi;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cfe();
            String str = null;
            String str2 = "";
            if (b.this.hDe != null && b.this.hpO != null) {
                ApkStatus b2 = b.this.hDe.b(b.this.hpO);
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
                if (this.hDi == null) {
                    this.hDi = new com.baidu.tieba.ala.liveroom.i.a(b.this.getPageContext().getPageActivity());
                    this.hDi.a(new a.InterfaceC0666a() { // from class: com.baidu.tieba.ala.liveroom.i.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0666a
                        public void cfb() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0666a
                        public void cfc() {
                            if (b.this.hDe != null && b.this.hpO != null) {
                                b.this.hDe.c(b.this.hpO);
                            }
                        }
                    });
                }
                if (b.this.hDd != null && b.this.hDd.aIu != null) {
                    this.hDi.HK(b.this.hDd.aIu);
                }
                if (b.this.hDd != null && b.this.hDd.portrait != null) {
                    this.hDi.HJ(b.this.hDd.getPortrait());
                }
                String str3 = "";
                if (b.this.hDd != null) {
                    str3 = b.this.hDd.getSubappType();
                }
                this.hDi.HL(str);
                this.hDi.setRoomId(b.this.roomId);
                this.hDi.HM(str2);
                this.hDi.HN(str3);
                this.hDi.show();
                o.dt(true);
                if (b.this.hDd != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hDd.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hDd.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.i.b.3
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
    e.a hDg = new e.a() { // from class: com.baidu.tieba.ala.liveroom.i.b.6
        @Override // com.baidu.tieba.ala.liveroom.n.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hDd = cVar;
            if (b.this.hDe != null) {
                b.this.hDe.HN(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hpO = new ApkData();
                b.this.hpO.apkUrl = cVar.appUrl;
                b.this.hpO.apkPackageName = cVar.packageName;
                b.this.hpO.apkClipBoardScheme = cVar.hBD;
                b.this.hpO.apkDeeplinkScheme = cVar.hBB;
                b.this.hpO.apkOldDeeplinkScheme = cVar.hBC;
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
        void caJ();

        void caK();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hDe = fVar;
        this.hDf = aVar;
        MessageManager.getInstance().registerListener(this.gNs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean au(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hDb == null) {
            this.hDb = new c(getPageContext(), this.onClickListener);
        }
        cfe();
        this.bRb = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hDb == null) {
            return null;
        }
        return this.hDb.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && au(viewGroup)) {
                if (this.hDe == null || !this.hDe.isDownloading()) {
                    if (!cfd()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hDf != null) {
                        this.hDf.caJ();
                    }
                    this.bRb.addView(this.hDb.getView(), layoutParams);
                    o.by(this.roomId);
                    if (this.hDd != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hDd.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cfe()) {
                                o.dt(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cfd() {
        return (this.hpO == null || TextUtils.isEmpty(this.hpO.apkPackageName) || TextUtils.isEmpty(this.hpO.apkUrl) || TextUtils.isEmpty(this.hpO.apkDeeplinkScheme) || TextUtils.isEmpty(this.hpO.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfe() {
        if (this.bRb == null || this.bRb.indexOfChild(this.hDb.getView()) < 0) {
            return false;
        }
        this.bRb.removeView(this.hDb.getView());
        g.vA(2913168);
        if (this.hDf != null) {
            this.hDf.caK();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gNs);
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
                if (b.this.hDc == null) {
                    b.this.hDc = new com.baidu.tieba.ala.liveroom.n.e(b.this.mTbPageContext, b.this.hDg);
                }
                b.this.hDc.j(str, str2, j);
            }
        }, j2);
    }

    public void Ar() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cfe()) {
            o.dt(false);
        }
    }

    public void cancel() {
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
        }
        if (this.hDc != null) {
            this.hDc.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        ab Fm = aVar.hBt.Fm();
        AlaLiveInfoData cjz = aVar.hBt.cjz();
        if (o.bz(cjz.room_id) && Fm != null && Fm.aIQ != null && Fm.aIQ.needToast == 1) {
            c(Fm.aIQ.watchDurationMust, cjz.live_id + "", cjz.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        ab Fm = aVar.hBt.Fm();
        if (Fm != null && aVar != null && this.handler != null && Fm.aIQ != null && Fm.aIQ.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Fm.aIQ.watchDurationMust) {
            AlaLiveInfoData cjz = aVar.hBt.cjz();
            if (o.bz(this.roomId)) {
                b(cjz.live_id + "", cjz.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

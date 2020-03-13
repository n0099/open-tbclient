package com.baidu.tieba.ala.liveroom.h;

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
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.n;
import com.baidu.tieba.ala.liveroom.h.a;
import com.baidu.tieba.ala.liveroom.m.d;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class b {
    private ViewGroup ewr;
    private com.baidu.tieba.ala.liveroom.m.d fbA;
    private com.baidu.tieba.ala.liveroom.data.c fbB;
    private ApkData fbC;
    private f fbD;
    private a fbE;
    protected c fby;
    private TimerTask fbz;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String eEo = "";
    private View.OnClickListener drw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.b.2
        private com.baidu.tieba.ala.liveroom.h.a fbH;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.blW();
            String str = null;
            String str2 = "";
            if (b.this.fbD != null && b.this.fbC != null) {
                ApkStatus a2 = b.this.fbD.a(b.this.fbC);
                if (a2 == ApkStatus.READY) {
                    str = b.this.mTbPageContext.getString(a.i.ala_feedback_flow_btn_launch);
                    str2 = "gentazou";
                } else if (a2 == ApkStatus.NEED_UPDATE) {
                    b.this.mTbPageContext.showToast(a.i.ala_feedback_flow_low_version_tip);
                    return;
                } else if (a2 == ApkStatus.DOWNLOADED) {
                    str = b.this.mTbPageContext.getString(a.i.ala_feedback_flow_btn_install);
                    str2 = "anzhuang";
                } else {
                    str = b.this.mTbPageContext.getString(a.i.ala_feedback_flow_btn_download);
                    str2 = "xiazai";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.fbH == null) {
                    this.fbH = new com.baidu.tieba.ala.liveroom.h.a(b.this.getPageContext().getPageActivity());
                    this.fbH.a(new a.InterfaceC0460a() { // from class: com.baidu.tieba.ala.liveroom.h.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0460a
                        public void blT() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0460a
                        public void blU() {
                            if (b.this.fbD != null && b.this.fbC != null) {
                                b.this.fbD.b(b.this.fbC);
                            }
                        }
                    });
                }
                if (b.this.fbB != null && b.this.fbB.adT != null) {
                    this.fbH.yY(b.this.fbB.adT);
                }
                if (b.this.fbB != null && b.this.fbB.portrait != null) {
                    this.fbH.yX(b.this.fbB.getPortrait());
                }
                String str3 = "";
                if (b.this.fbB != null) {
                    str3 = b.this.fbB.getSubappType();
                }
                this.fbH.yZ(str);
                this.fbH.setRoomId(b.this.roomId);
                this.fbH.za(str2);
                this.fbH.zb(str3);
                this.fbH.show();
                n.bx(true);
                if (b.this.fbB != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.fbB.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.fbB.getSubappType());
                }
            }
        }
    };
    CustomMessageListener evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.h.b.3
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
    d.a fbF = new d.a() { // from class: com.baidu.tieba.ala.liveroom.h.b.6
        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.fbB = cVar;
            if (b.this.fbD != null) {
                b.this.fbD.zb(cVar.faF);
            }
            if (cVar.needToast == 1) {
                b.this.fbC = new ApkData();
                b.this.fbC.apkUrl = cVar.appUrl;
                b.this.fbC.apkPackageName = cVar.packageName;
                b.this.fbC.apkClipBoardScheme = cVar.faE;
                b.this.fbC.apkDeeplinkScheme = cVar.faC;
                b.this.fbC.apkOldDeeplinkScheme = cVar.faD;
                g.pY(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void av(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes3.dex */
    public interface a {
        void biX();

        void biY();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.fbD = fVar;
        this.fbE = aVar;
        MessageManager.getInstance().registerListener(this.evY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fby == null) {
            this.fby = new c(getPageContext(), this.drw);
        }
        blW();
        this.ewr = viewGroup;
        return true;
    }

    public View getView() {
        if (this.fby == null) {
            return null;
        }
        return this.fby.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && X(viewGroup)) {
                if (this.fbD == null || !this.fbD.isDownloading()) {
                    if (!blV()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.fbE != null) {
                        this.fbE.biX();
                    }
                    this.ewr.addView(this.fby.getView(), layoutParams);
                    n.P(this.roomId);
                    if (this.fbB != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.fbB.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.blW()) {
                                n.bx(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean blV() {
        return (this.fbC == null || TextUtils.isEmpty(this.fbC.apkPackageName) || TextUtils.isEmpty(this.fbC.apkUrl) || TextUtils.isEmpty(this.fbC.apkDeeplinkScheme) || TextUtils.isEmpty(this.fbC.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blW() {
        if (this.ewr == null || this.ewr.indexOfChild(this.fby.getView()) < 0) {
            return false;
        }
        this.ewr.removeView(this.fby.getView());
        g.pZ(2913168);
        if (this.fbE != null) {
            this.fbE.biY();
        }
        return true;
    }

    public void b(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.fbz != null) {
            this.fbz.cancel();
        }
        this.fbz = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.h.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.fbz, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.fbA == null) {
                    b.this.fbA = new com.baidu.tieba.ala.liveroom.m.d(b.this.mTbPageContext, b.this.fbF);
                }
                b.this.fbA.f(str, str2, j);
            }
        }, j2);
    }

    public void pK() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (blW()) {
            n.bx(false);
        }
    }

    public void cancel() {
        if (this.fbz != null) {
            this.fbz.cancel();
        }
        if (this.fbA != null) {
            this.fbA.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        m yO = aVar.fav.yO();
        AlaLiveInfoData bpR = aVar.fav.bpR();
        if (n.Q(bpR.room_id) && yO != null && yO.Yp != null && yO.Yp.needToast == 1) {
            b(yO.Yp.watchDurationMust, bpR.live_id + "", bpR.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        m yO = aVar.fav.yO();
        if (yO != null && aVar != null && this.handler != null && yO.Yp != null && yO.Yp.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > yO.Yp.watchDurationMust) {
            AlaLiveInfoData bpR = aVar.fav.bpR();
            if (n.Q(this.roomId)) {
                a(bpR.live_id + "", bpR.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

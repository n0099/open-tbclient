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
    private ViewGroup ewN;
    protected c fbW;
    private TimerTask fbX;
    private com.baidu.tieba.ala.liveroom.m.d fbY;
    private com.baidu.tieba.ala.liveroom.data.c fbZ;
    private ApkData fca;
    private f fcb;
    private a fcc;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String eEK = "";
    private View.OnClickListener drJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.b.2
        private com.baidu.tieba.ala.liveroom.h.a fcf;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bmb();
            String str = null;
            String str2 = "";
            if (b.this.fcb != null && b.this.fca != null) {
                ApkStatus a2 = b.this.fcb.a(b.this.fca);
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
                if (this.fcf == null) {
                    this.fcf = new com.baidu.tieba.ala.liveroom.h.a(b.this.getPageContext().getPageActivity());
                    this.fcf.a(new a.InterfaceC0460a() { // from class: com.baidu.tieba.ala.liveroom.h.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0460a
                        public void blY() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0460a
                        public void blZ() {
                            if (b.this.fcb != null && b.this.fca != null) {
                                b.this.fcb.b(b.this.fca);
                            }
                        }
                    });
                }
                if (b.this.fbZ != null && b.this.fbZ.aed != null) {
                    this.fcf.yY(b.this.fbZ.aed);
                }
                if (b.this.fbZ != null && b.this.fbZ.portrait != null) {
                    this.fcf.yX(b.this.fbZ.getPortrait());
                }
                String str3 = "";
                if (b.this.fbZ != null) {
                    str3 = b.this.fbZ.getSubappType();
                }
                this.fcf.yZ(str);
                this.fcf.setRoomId(b.this.roomId);
                this.fcf.za(str2);
                this.fcf.zb(str3);
                this.fcf.show();
                n.by(true);
                if (b.this.fbZ != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.fbZ.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.fbZ.getSubappType());
                }
            }
        }
    };
    CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.h.b.3
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
    d.a fcd = new d.a() { // from class: com.baidu.tieba.ala.liveroom.h.b.6
        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.fbZ = cVar;
            if (b.this.fcb != null) {
                b.this.fcb.zb(cVar.fbd);
            }
            if (cVar.needToast == 1) {
                b.this.fca = new ApkData();
                b.this.fca.apkUrl = cVar.appUrl;
                b.this.fca.apkPackageName = cVar.packageName;
                b.this.fca.apkClipBoardScheme = cVar.fbc;
                b.this.fca.apkDeeplinkScheme = cVar.fba;
                b.this.fca.apkOldDeeplinkScheme = cVar.fbb;
                g.qa(2913168);
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
        void bjc();

        void bjd();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.fcb = fVar;
        this.fcc = aVar;
        MessageManager.getInstance().registerListener(this.ewu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fbW == null) {
            this.fbW = new c(getPageContext(), this.drJ);
        }
        bmb();
        this.ewN = viewGroup;
        return true;
    }

    public View getView() {
        if (this.fbW == null) {
            return null;
        }
        return this.fbW.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && X(viewGroup)) {
                if (this.fcb == null || !this.fcb.isDownloading()) {
                    if (!bma()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.fcc != null) {
                        this.fcc.bjc();
                    }
                    this.ewN.addView(this.fbW.getView(), layoutParams);
                    n.P(this.roomId);
                    if (this.fbZ != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.fbZ.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bmb()) {
                                n.by(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bma() {
        return (this.fca == null || TextUtils.isEmpty(this.fca.apkPackageName) || TextUtils.isEmpty(this.fca.apkUrl) || TextUtils.isEmpty(this.fca.apkDeeplinkScheme) || TextUtils.isEmpty(this.fca.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmb() {
        if (this.ewN == null || this.ewN.indexOfChild(this.fbW.getView()) < 0) {
            return false;
        }
        this.ewN.removeView(this.fbW.getView());
        g.qb(2913168);
        if (this.fcc != null) {
            this.fcc.bjd();
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
        if (this.fbX != null) {
            this.fbX.cancel();
        }
        this.fbX = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.h.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.fbX, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.fbY == null) {
                    b.this.fbY = new com.baidu.tieba.ala.liveroom.m.d(b.this.mTbPageContext, b.this.fcd);
                }
                b.this.fbY.f(str, str2, j);
            }
        }, j2);
    }

    public void pP() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bmb()) {
            n.by(false);
        }
    }

    public void cancel() {
        if (this.fbX != null) {
            this.fbX.cancel();
        }
        if (this.fbY != null) {
            this.fbY.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        m yT = aVar.faT.yT();
        AlaLiveInfoData bpW = aVar.faT.bpW();
        if (n.Q(bpW.room_id) && yT != null && yT.Yz != null && yT.Yz.needToast == 1) {
            b(yT.Yz.watchDurationMust, bpW.live_id + "", bpW.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        m yT = aVar.faT.yT();
        if (yT != null && aVar != null && this.handler != null && yT.Yz != null && yT.Yz.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > yT.Yz.watchDurationMust) {
            AlaLiveInfoData bpW = aVar.faT.bpW();
            if (n.Q(this.roomId)) {
                a(bpW.live_id + "", bpW.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

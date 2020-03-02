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
    private ViewGroup ewe;
    protected c fbl;
    private TimerTask fbm;
    private com.baidu.tieba.ala.liveroom.m.d fbn;
    private com.baidu.tieba.ala.liveroom.data.c fbo;
    private ApkData fbp;
    private f fbq;
    private a fbr;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String eEb = "";
    private View.OnClickListener dri = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.b.2
        private com.baidu.tieba.ala.liveroom.h.a fbu;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.blV();
            String str = null;
            String str2 = "";
            if (b.this.fbq != null && b.this.fbp != null) {
                ApkStatus a2 = b.this.fbq.a(b.this.fbp);
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
                if (this.fbu == null) {
                    this.fbu = new com.baidu.tieba.ala.liveroom.h.a(b.this.getPageContext().getPageActivity());
                    this.fbu.a(new a.InterfaceC0460a() { // from class: com.baidu.tieba.ala.liveroom.h.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0460a
                        public void blS() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0460a
                        public void blT() {
                            if (b.this.fbq != null && b.this.fbp != null) {
                                b.this.fbq.b(b.this.fbp);
                            }
                        }
                    });
                }
                if (b.this.fbo != null && b.this.fbo.adT != null) {
                    this.fbu.yX(b.this.fbo.adT);
                }
                if (b.this.fbo != null && b.this.fbo.portrait != null) {
                    this.fbu.yW(b.this.fbo.getPortrait());
                }
                String str3 = "";
                if (b.this.fbo != null) {
                    str3 = b.this.fbo.getSubappType();
                }
                this.fbu.yY(str);
                this.fbu.setRoomId(b.this.roomId);
                this.fbu.yZ(str2);
                this.fbu.za(str3);
                this.fbu.show();
                n.bx(true);
                if (b.this.fbo != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.fbo.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.fbo.getSubappType());
                }
            }
        }
    };
    CustomMessageListener evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.h.b.3
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
    d.a fbs = new d.a() { // from class: com.baidu.tieba.ala.liveroom.h.b.6
        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.fbo = cVar;
            if (b.this.fbq != null) {
                b.this.fbq.za(cVar.fas);
            }
            if (cVar.needToast == 1) {
                b.this.fbp = new ApkData();
                b.this.fbp.apkUrl = cVar.appUrl;
                b.this.fbp.apkPackageName = cVar.packageName;
                b.this.fbp.apkClipBoardScheme = cVar.far;
                b.this.fbp.apkDeeplinkScheme = cVar.fap;
                b.this.fbp.apkOldDeeplinkScheme = cVar.faq;
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
        void biW();

        void biX();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.fbq = fVar;
        this.fbr = aVar;
        MessageManager.getInstance().registerListener(this.evL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fbl == null) {
            this.fbl = new c(getPageContext(), this.dri);
        }
        blV();
        this.ewe = viewGroup;
        return true;
    }

    public View getView() {
        if (this.fbl == null) {
            return null;
        }
        return this.fbl.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && X(viewGroup)) {
                if (this.fbq == null || !this.fbq.isDownloading()) {
                    if (!blU()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.fbr != null) {
                        this.fbr.biW();
                    }
                    this.ewe.addView(this.fbl.getView(), layoutParams);
                    n.P(this.roomId);
                    if (this.fbo != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.fbo.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.blV()) {
                                n.bx(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean blU() {
        return (this.fbp == null || TextUtils.isEmpty(this.fbp.apkPackageName) || TextUtils.isEmpty(this.fbp.apkUrl) || TextUtils.isEmpty(this.fbp.apkDeeplinkScheme) || TextUtils.isEmpty(this.fbp.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blV() {
        if (this.ewe == null || this.ewe.indexOfChild(this.fbl.getView()) < 0) {
            return false;
        }
        this.ewe.removeView(this.fbl.getView());
        g.pZ(2913168);
        if (this.fbr != null) {
            this.fbr.biX();
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
        if (this.fbm != null) {
            this.fbm.cancel();
        }
        this.fbm = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.h.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.fbm, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.fbn == null) {
                    b.this.fbn = new com.baidu.tieba.ala.liveroom.m.d(b.this.mTbPageContext, b.this.fbs);
                }
                b.this.fbn.f(str, str2, j);
            }
        }, j2);
    }

    public void pK() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (blV()) {
            n.bx(false);
        }
    }

    public void cancel() {
        if (this.fbm != null) {
            this.fbm.cancel();
        }
        if (this.fbn != null) {
            this.fbn.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        m yO = aVar.fai.yO();
        AlaLiveInfoData bpQ = aVar.fai.bpQ();
        if (n.Q(bpQ.room_id) && yO != null && yO.Yp != null && yO.Yp.needToast == 1) {
            b(yO.Yp.watchDurationMust, bpQ.live_id + "", bpQ.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        m yO = aVar.fai.yO();
        if (yO != null && aVar != null && this.handler != null && yO.Yp != null && yO.Yp.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > yO.Yp.watchDurationMust) {
            AlaLiveInfoData bpQ = aVar.fai.bpQ();
            if (n.Q(this.roomId)) {
                a(bpQ.live_id + "", bpQ.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

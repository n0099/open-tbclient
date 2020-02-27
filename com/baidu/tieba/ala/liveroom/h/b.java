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
    private ViewGroup ewd;
    protected c fbk;
    private TimerTask fbl;
    private com.baidu.tieba.ala.liveroom.m.d fbm;
    private com.baidu.tieba.ala.liveroom.data.c fbn;
    private ApkData fbo;
    private f fbp;
    private a fbq;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String eEa = "";
    private View.OnClickListener drh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.b.2
        private com.baidu.tieba.ala.liveroom.h.a fbt;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.blT();
            String str = null;
            String str2 = "";
            if (b.this.fbp != null && b.this.fbo != null) {
                ApkStatus a2 = b.this.fbp.a(b.this.fbo);
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
                if (this.fbt == null) {
                    this.fbt = new com.baidu.tieba.ala.liveroom.h.a(b.this.getPageContext().getPageActivity());
                    this.fbt.a(new a.InterfaceC0460a() { // from class: com.baidu.tieba.ala.liveroom.h.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0460a
                        public void blQ() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0460a
                        public void blR() {
                            if (b.this.fbp != null && b.this.fbo != null) {
                                b.this.fbp.b(b.this.fbo);
                            }
                        }
                    });
                }
                if (b.this.fbn != null && b.this.fbn.adT != null) {
                    this.fbt.yX(b.this.fbn.adT);
                }
                if (b.this.fbn != null && b.this.fbn.portrait != null) {
                    this.fbt.yW(b.this.fbn.getPortrait());
                }
                String str3 = "";
                if (b.this.fbn != null) {
                    str3 = b.this.fbn.getSubappType();
                }
                this.fbt.yY(str);
                this.fbt.setRoomId(b.this.roomId);
                this.fbt.yZ(str2);
                this.fbt.za(str3);
                this.fbt.show();
                n.bx(true);
                if (b.this.fbn != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.fbn.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.fbn.getSubappType());
                }
            }
        }
    };
    CustomMessageListener evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.h.b.3
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
    d.a fbr = new d.a() { // from class: com.baidu.tieba.ala.liveroom.h.b.6
        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.fbn = cVar;
            if (b.this.fbp != null) {
                b.this.fbp.za(cVar.far);
            }
            if (cVar.needToast == 1) {
                b.this.fbo = new ApkData();
                b.this.fbo.apkUrl = cVar.appUrl;
                b.this.fbo.apkPackageName = cVar.packageName;
                b.this.fbo.apkClipBoardScheme = cVar.faq;
                b.this.fbo.apkDeeplinkScheme = cVar.fao;
                b.this.fbo.apkOldDeeplinkScheme = cVar.fap;
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
        void biU();

        void biV();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.fbp = fVar;
        this.fbq = aVar;
        MessageManager.getInstance().registerListener(this.evK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fbk == null) {
            this.fbk = new c(getPageContext(), this.drh);
        }
        blT();
        this.ewd = viewGroup;
        return true;
    }

    public View getView() {
        if (this.fbk == null) {
            return null;
        }
        return this.fbk.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && X(viewGroup)) {
                if (this.fbp == null || !this.fbp.isDownloading()) {
                    if (!blS()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.fbq != null) {
                        this.fbq.biU();
                    }
                    this.ewd.addView(this.fbk.getView(), layoutParams);
                    n.P(this.roomId);
                    if (this.fbn != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.fbn.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.blT()) {
                                n.bx(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean blS() {
        return (this.fbo == null || TextUtils.isEmpty(this.fbo.apkPackageName) || TextUtils.isEmpty(this.fbo.apkUrl) || TextUtils.isEmpty(this.fbo.apkDeeplinkScheme) || TextUtils.isEmpty(this.fbo.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blT() {
        if (this.ewd == null || this.ewd.indexOfChild(this.fbk.getView()) < 0) {
            return false;
        }
        this.ewd.removeView(this.fbk.getView());
        g.pZ(2913168);
        if (this.fbq != null) {
            this.fbq.biV();
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
        if (this.fbl != null) {
            this.fbl.cancel();
        }
        this.fbl = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.h.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.fbl, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.fbm == null) {
                    b.this.fbm = new com.baidu.tieba.ala.liveroom.m.d(b.this.mTbPageContext, b.this.fbr);
                }
                b.this.fbm.f(str, str2, j);
            }
        }, j2);
    }

    public void pK() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (blT()) {
            n.bx(false);
        }
    }

    public void cancel() {
        if (this.fbl != null) {
            this.fbl.cancel();
        }
        if (this.fbm != null) {
            this.fbm.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        m yN = aVar.fah.yN();
        AlaLiveInfoData bpO = aVar.fah.bpO();
        if (n.Q(bpO.room_id) && yN != null && yN.Yp != null && yN.Yp.needToast == 1) {
            b(yN.Yp.watchDurationMust, bpO.live_id + "", bpO.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        m yN = aVar.fah.yN();
        if (yN != null && aVar != null && this.handler != null && yN.Yp != null && yN.Yp.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > yN.Yp.watchDurationMust) {
            AlaLiveInfoData bpO = aVar.fah.bpO();
            if (n.Q(this.roomId)) {
                a(bpO.live_id + "", bpO.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

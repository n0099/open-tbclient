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
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.n;
import com.baidu.tieba.ala.liveroom.j.a;
import com.baidu.tieba.ala.liveroom.o.d;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class b {
    private ViewGroup fNw;
    protected c gmj;
    private TimerTask gmk;
    private com.baidu.tieba.ala.liveroom.o.d gml;
    private com.baidu.tieba.ala.liveroom.data.c gmm;
    private ApkData gmn;
    private f gmo;
    private a gmp;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String fNI = "";
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a gms;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bHH();
            String str = null;
            String str2 = "";
            if (b.this.gmo != null && b.this.gmn != null) {
                ApkStatus a2 = b.this.gmo.a(b.this.gmn);
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
                if (this.gms == null) {
                    this.gms = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.gms.a(new a.InterfaceC0582a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0582a
                        public void bHE() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0582a
                        public void bHF() {
                            if (b.this.gmo != null && b.this.gmn != null) {
                                b.this.gmo.b(b.this.gmn);
                            }
                        }
                    });
                }
                if (b.this.gmm != null && b.this.gmm.azw != null) {
                    this.gms.DC(b.this.gmm.azw);
                }
                if (b.this.gmm != null && b.this.gmm.portrait != null) {
                    this.gms.DB(b.this.gmm.getPortrait());
                }
                String str3 = "";
                if (b.this.gmm != null) {
                    str3 = b.this.gmm.getSubappType();
                }
                this.gms.DD(str);
                this.gms.setRoomId(b.this.roomId);
                this.gms.DE(str2);
                this.gms.DF(str3);
                this.gms.show();
                n.cw(true);
                if (b.this.gmm != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.gmm.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.gmm.getSubappType());
                }
            }
        }
    };
    CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    d.a gmq = new d.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.o.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.gmm = cVar;
            if (b.this.gmo != null) {
                b.this.gmo.DF(cVar.glk);
            }
            if (cVar.needToast == 1) {
                b.this.gmn = new ApkData();
                b.this.gmn.apkUrl = cVar.appUrl;
                b.this.gmn.apkPackageName = cVar.packageName;
                b.this.gmn.apkClipBoardScheme = cVar.glj;
                b.this.gmn.apkDeeplinkScheme = cVar.glh;
                b.this.gmn.apkOldDeeplinkScheme = cVar.gli;
                g.rL(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.o.d.a
        public void aV(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes4.dex */
    public interface a {
        void bEo();

        void bEp();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.gmo = fVar;
        this.gmp = aVar;
        MessageManager.getInstance().registerListener(this.fEy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ai(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gmj == null) {
            this.gmj = new c(getPageContext(), this.eve);
        }
        bHH();
        this.fNw = viewGroup;
        return true;
    }

    public View getView() {
        if (this.gmj == null) {
            return null;
        }
        return this.gmj.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ai(viewGroup)) {
                if (this.gmo == null || !this.gmo.isDownloading()) {
                    if (!bHG()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.gmp != null) {
                        this.gmp.bEo();
                    }
                    this.fNw.addView(this.gmj.getView(), layoutParams);
                    n.aw(this.roomId);
                    if (this.gmm != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.gmm.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bHH()) {
                                n.cw(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bHG() {
        return (this.gmn == null || TextUtils.isEmpty(this.gmn.apkPackageName) || TextUtils.isEmpty(this.gmn.apkUrl) || TextUtils.isEmpty(this.gmn.apkDeeplinkScheme) || TextUtils.isEmpty(this.gmn.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHH() {
        if (this.fNw == null || this.fNw.indexOfChild(this.gmj.getView()) < 0) {
            return false;
        }
        this.fNw.removeView(this.gmj.getView());
        g.rM(2913168);
        if (this.gmp != null) {
            this.gmp.bEp();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fEy);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.gmk != null) {
            this.gmk.cancel();
        }
        this.gmk = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.gmk, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.gml == null) {
                    b.this.gml = new com.baidu.tieba.ala.liveroom.o.d(b.this.mTbPageContext, b.this.gmq);
                }
                b.this.gml.h(str, str2, j);
            }
        }, j2);
    }

    public void wd() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bHH()) {
            n.cw(false);
        }
    }

    public void cancel() {
        if (this.gmk != null) {
            this.gmk.cancel();
        }
        if (this.gml != null) {
            this.gml.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        q FO = aVar.gla.FO();
        AlaLiveInfoData bLJ = aVar.gla.bLJ();
        if (n.ax(bLJ.room_id) && FO != null && FO.azh != null && FO.azh.needToast == 1) {
            c(FO.azh.watchDurationMust, bLJ.live_id + "", bLJ.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        q FO = aVar.gla.FO();
        if (FO != null && aVar != null && this.handler != null && FO.azh != null && FO.azh.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > FO.azh.watchDurationMust) {
            AlaLiveInfoData bLJ = aVar.gla.bLJ();
            if (n.ax(this.roomId)) {
                a(bLJ.live_id + "", bLJ.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

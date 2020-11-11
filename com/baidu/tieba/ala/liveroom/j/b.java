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
    private ViewGroup bJN;
    protected c hip;
    private TimerTask hiq;
    private com.baidu.tieba.ala.liveroom.q.e hir;
    private com.baidu.tieba.ala.liveroom.data.c his;
    private ApkData hit;
    private f hiu;
    private a hiv;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String gFh = "";
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a hiy;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cbX();
            String str = null;
            String str2 = "";
            if (b.this.hiu != null && b.this.hit != null) {
                ApkStatus a2 = b.this.hiu.a(b.this.hit);
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
                if (this.hiy == null) {
                    this.hiy = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.hiy.a(new a.InterfaceC0677a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0677a
                        public void cbU() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0677a
                        public void cbV() {
                            if (b.this.hiu != null && b.this.hit != null) {
                                b.this.hiu.b(b.this.hit);
                            }
                        }
                    });
                }
                if (b.this.his != null && b.this.his.aJm != null) {
                    this.hiy.Ib(b.this.his.aJm);
                }
                if (b.this.his != null && b.this.his.portrait != null) {
                    this.hiy.Ia(b.this.his.getPortrait());
                }
                String str3 = "";
                if (b.this.his != null) {
                    str3 = b.this.his.getSubappType();
                }
                this.hiy.Ic(str);
                this.hiy.setRoomId(b.this.roomId);
                this.hiy.Id(str2);
                this.hiy.Ie(str3);
                this.hiy.show();
                n.cW(true);
                if (b.this.his != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.his.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.his.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a hiw = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.his = cVar;
            if (b.this.hiu != null) {
                b.this.hiu.Ie(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hit = new ApkData();
                b.this.hit.apkUrl = cVar.appUrl;
                b.this.hit.apkPackageName = cVar.packageName;
                b.this.hit.apkClipBoardScheme = cVar.hgN;
                b.this.hit.apkDeeplinkScheme = cVar.hgL;
                b.this.hit.apkOldDeeplinkScheme = cVar.hgM;
                g.vG(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void bj(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes4.dex */
    public interface a {
        void bXN();

        void bXO();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hiu = fVar;
        this.hiv = aVar;
        MessageManager.getInstance().registerListener(this.gvo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ao(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hip == null) {
            this.hip = new c(getPageContext(), this.fii);
        }
        cbX();
        this.bJN = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hip == null) {
            return null;
        }
        return this.hip.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ao(viewGroup)) {
                if (this.hiu == null || !this.hiu.isDownloading()) {
                    if (!cbW()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hiv != null) {
                        this.hiv.bXN();
                    }
                    this.bJN.addView(this.hip.getView(), layoutParams);
                    n.aW(this.roomId);
                    if (this.his != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.his.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cbX()) {
                                n.cW(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cbW() {
        return (this.hit == null || TextUtils.isEmpty(this.hit.apkPackageName) || TextUtils.isEmpty(this.hit.apkUrl) || TextUtils.isEmpty(this.hit.apkDeeplinkScheme) || TextUtils.isEmpty(this.hit.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbX() {
        if (this.bJN == null || this.bJN.indexOfChild(this.hip.getView()) < 0) {
            return false;
        }
        this.bJN.removeView(this.hip.getView());
        g.vH(2913168);
        if (this.hiv != null) {
            this.hiv.bXO();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gvo);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.hiq != null) {
            this.hiq.cancel();
        }
        this.hiq = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.b(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.hiq, j);
    }

    public void b(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.hir == null) {
                    b.this.hir = new com.baidu.tieba.ala.liveroom.q.e(b.this.mTbPageContext, b.this.hiw);
                }
                b.this.hir.h(str, str2, j);
            }
        }, j2);
    }

    public void Dm() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cbX()) {
            n.cW(false);
        }
    }

    public void cancel() {
        if (this.hiq != null) {
            this.hiq.cancel();
        }
        if (this.hir != null) {
            this.hir.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w Hi = aVar.hgD.Hi();
        AlaLiveInfoData cgx = aVar.hgD.cgx();
        if (n.aX(cgx.room_id) && Hi != null && Hi.aJG != null && Hi.aJG.needToast == 1) {
            c(Hi.aJG.watchDurationMust, cgx.live_id + "", cgx.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w Hi = aVar.hgD.Hi();
        if (Hi != null && aVar != null && this.handler != null && Hi.aJG != null && Hi.aJG.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Hi.aJG.watchDurationMust) {
            AlaLiveInfoData cgx = aVar.hgD.cgx();
            if (n.aX(this.roomId)) {
                b(cgx.live_id + "", cgx.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

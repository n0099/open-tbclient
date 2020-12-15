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
import com.baidu.tieba.ala.liveroom.p.e;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class b {
    private ViewGroup bNk;
    private ApkData heu;
    protected c hrA;
    private TimerTask hrB;
    private com.baidu.tieba.ala.liveroom.p.e hrC;
    private com.baidu.tieba.ala.liveroom.data.c hrD;
    private f hrE;
    private a hrF;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String gNO = "";
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a hrI;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cfk();
            String str = null;
            String str2 = "";
            if (b.this.hrE != null && b.this.heu != null) {
                ApkStatus b = b.this.hrE.b(b.this.heu);
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
                if (this.hrI == null) {
                    this.hrI = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.hrI.a(new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0691a
                        public void cfh() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0691a
                        public void cfi() {
                            if (b.this.hrE != null && b.this.heu != null) {
                                b.this.hrE.c(b.this.heu);
                            }
                        }
                    });
                }
                if (b.this.hrD != null && b.this.hrD.aKm != null) {
                    this.hrI.Iq(b.this.hrD.aKm);
                }
                if (b.this.hrD != null && b.this.hrD.portrait != null) {
                    this.hrI.Ip(b.this.hrD.getPortrait());
                }
                String str3 = "";
                if (b.this.hrD != null) {
                    str3 = b.this.hrD.getSubappType();
                }
                this.hrI.Ir(str);
                this.hrI.setRoomId(b.this.roomId);
                this.hrI.Is(str2);
                this.hrI.It(str3);
                this.hrI.show();
                n.dm(true);
                if (b.this.hrD != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hrD.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hrD.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a hrG = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hrD = cVar;
            if (b.this.hrE != null) {
                b.this.hrE.It(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.heu = new ApkData();
                b.this.heu.apkUrl = cVar.appUrl;
                b.this.heu.apkPackageName = cVar.packageName;
                b.this.heu.apkClipBoardScheme = cVar.hqd;
                b.this.heu.apkDeeplinkScheme = cVar.hqb;
                b.this.heu.apkOldDeeplinkScheme = cVar.hqc;
                g.wJ(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void bh(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes4.dex */
    public interface a {
        void caY();

        void caZ();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hrE = fVar;
        this.hrF = aVar;
        MessageManager.getInstance().registerListener(this.gDG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ak(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hrA == null) {
            this.hrA = new c(getPageContext(), this.foP);
        }
        cfk();
        this.bNk = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hrA == null) {
            return null;
        }
        return this.hrA.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ak(viewGroup)) {
                if (this.hrE == null || !this.hrE.isDownloading()) {
                    if (!cfj()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hrF != null) {
                        this.hrF.caY();
                    }
                    this.bNk.addView(this.hrA.getView(), layoutParams);
                    n.bu(this.roomId);
                    if (this.hrD != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hrD.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cfk()) {
                                n.dm(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cfj() {
        return (this.heu == null || TextUtils.isEmpty(this.heu.apkPackageName) || TextUtils.isEmpty(this.heu.apkUrl) || TextUtils.isEmpty(this.heu.apkDeeplinkScheme) || TextUtils.isEmpty(this.heu.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfk() {
        if (this.bNk == null || this.bNk.indexOfChild(this.hrA.getView()) < 0) {
            return false;
        }
        this.bNk.removeView(this.hrA.getView());
        g.wK(2913168);
        if (this.hrF != null) {
            this.hrF.caZ();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gDG);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.hrB != null) {
            this.hrB.cancel();
        }
        this.hrB = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.b(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.hrB, j);
    }

    public void b(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.hrC == null) {
                    b.this.hrC = new com.baidu.tieba.ala.liveroom.p.e(b.this.mTbPageContext, b.this.hrG);
                }
                b.this.hrC.h(str, str2, j);
            }
        }, j2);
    }

    public void En() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cfk()) {
            n.dm(false);
        }
    }

    public void cancel() {
        if (this.hrB != null) {
            this.hrB.cancel();
        }
        if (this.hrC != null) {
            this.hrC.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w Iq = aVar.hpT.Iq();
        AlaLiveInfoData cjL = aVar.hpT.cjL();
        if (n.bv(cjL.room_id) && Iq != null && Iq.aKH != null && Iq.aKH.needToast == 1) {
            c(Iq.aKH.watchDurationMust, cjL.live_id + "", cjL.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w Iq = aVar.hpT.Iq();
        if (Iq != null && aVar != null && this.handler != null && Iq.aKH != null && Iq.aKH.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Iq.aKH.watchDurationMust) {
            AlaLiveInfoData cjL = aVar.hpT.cjL();
            if (n.bv(this.roomId)) {
                b(cjL.live_id + "", cjL.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

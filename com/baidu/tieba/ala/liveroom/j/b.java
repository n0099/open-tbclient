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
    private ApkData hes;
    private com.baidu.tieba.ala.liveroom.p.e hrA;
    private com.baidu.tieba.ala.liveroom.data.c hrB;
    private f hrC;
    private a hrD;
    protected c hry;
    private TimerTask hrz;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String gNM = "";
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a hrG;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cfj();
            String str = null;
            String str2 = "";
            if (b.this.hrC != null && b.this.hes != null) {
                ApkStatus b = b.this.hrC.b(b.this.hes);
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
                if (this.hrG == null) {
                    this.hrG = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.hrG.a(new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0691a
                        public void cfg() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0691a
                        public void cfh() {
                            if (b.this.hrC != null && b.this.hes != null) {
                                b.this.hrC.c(b.this.hes);
                            }
                        }
                    });
                }
                if (b.this.hrB != null && b.this.hrB.aKm != null) {
                    this.hrG.Iq(b.this.hrB.aKm);
                }
                if (b.this.hrB != null && b.this.hrB.portrait != null) {
                    this.hrG.Ip(b.this.hrB.getPortrait());
                }
                String str3 = "";
                if (b.this.hrB != null) {
                    str3 = b.this.hrB.getSubappType();
                }
                this.hrG.Ir(str);
                this.hrG.setRoomId(b.this.roomId);
                this.hrG.Is(str2);
                this.hrG.It(str3);
                this.hrG.show();
                n.dm(true);
                if (b.this.hrB != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hrB.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hrB.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a hrE = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hrB = cVar;
            if (b.this.hrC != null) {
                b.this.hrC.It(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hes = new ApkData();
                b.this.hes.apkUrl = cVar.appUrl;
                b.this.hes.apkPackageName = cVar.packageName;
                b.this.hes.apkClipBoardScheme = cVar.hqb;
                b.this.hes.apkDeeplinkScheme = cVar.hpZ;
                b.this.hes.apkOldDeeplinkScheme = cVar.hqa;
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
        void caX();

        void caY();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hrC = fVar;
        this.hrD = aVar;
        MessageManager.getInstance().registerListener(this.gDE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ak(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hry == null) {
            this.hry = new c(getPageContext(), this.foP);
        }
        cfj();
        this.bNk = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hry == null) {
            return null;
        }
        return this.hry.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ak(viewGroup)) {
                if (this.hrC == null || !this.hrC.isDownloading()) {
                    if (!cfi()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hrD != null) {
                        this.hrD.caX();
                    }
                    this.bNk.addView(this.hry.getView(), layoutParams);
                    n.bu(this.roomId);
                    if (this.hrB != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hrB.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cfj()) {
                                n.dm(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cfi() {
        return (this.hes == null || TextUtils.isEmpty(this.hes.apkPackageName) || TextUtils.isEmpty(this.hes.apkUrl) || TextUtils.isEmpty(this.hes.apkDeeplinkScheme) || TextUtils.isEmpty(this.hes.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfj() {
        if (this.bNk == null || this.bNk.indexOfChild(this.hry.getView()) < 0) {
            return false;
        }
        this.bNk.removeView(this.hry.getView());
        g.wK(2913168);
        if (this.hrD != null) {
            this.hrD.caY();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gDE);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.hrz != null) {
            this.hrz.cancel();
        }
        this.hrz = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.b(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.hrz, j);
    }

    public void b(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.hrA == null) {
                    b.this.hrA = new com.baidu.tieba.ala.liveroom.p.e(b.this.mTbPageContext, b.this.hrE);
                }
                b.this.hrA.h(str, str2, j);
            }
        }, j2);
    }

    public void En() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cfj()) {
            n.dm(false);
        }
    }

    public void cancel() {
        if (this.hrz != null) {
            this.hrz.cancel();
        }
        if (this.hrA != null) {
            this.hrA.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w Iq = aVar.hpR.Iq();
        AlaLiveInfoData cjK = aVar.hpR.cjK();
        if (n.bv(cjK.room_id) && Iq != null && Iq.aKH != null && Iq.aKH.needToast == 1) {
            c(Iq.aKH.watchDurationMust, cjK.live_id + "", cjK.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w Iq = aVar.hpR.Iq();
        if (Iq != null && aVar != null && this.handler != null && Iq.aKH != null && Iq.aKH.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Iq.aKH.watchDurationMust) {
            AlaLiveInfoData cjK = aVar.hpR.cjK();
            if (n.bv(this.roomId)) {
                b(cjK.live_id + "", cjK.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

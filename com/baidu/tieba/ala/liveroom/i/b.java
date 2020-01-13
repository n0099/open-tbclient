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
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.n;
import com.baidu.tieba.ala.liveroom.i.a;
import com.baidu.tieba.ala.liveroom.o.d;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class b {
    protected c eXB;
    private TimerTask eXC;
    private com.baidu.tieba.ala.liveroom.o.d eXD;
    private com.baidu.tieba.ala.liveroom.data.c eXE;
    private ApkData eXF;
    private f eXG;
    private a eXH;
    private ViewGroup erT;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String eAu = "";
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.b.2
        private com.baidu.tieba.ala.liveroom.i.a eXK;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bkf();
            String str = null;
            String str2 = "";
            if (b.this.eXG != null && b.this.eXF != null) {
                ApkStatus a2 = b.this.eXG.a(b.this.eXF);
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
                if (this.eXK == null) {
                    this.eXK = new com.baidu.tieba.ala.liveroom.i.a(b.this.getPageContext().getPageActivity());
                    this.eXK.a(new a.InterfaceC0449a() { // from class: com.baidu.tieba.ala.liveroom.i.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0449a
                        public void bkc() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0449a
                        public void bkd() {
                            if (b.this.eXG != null && b.this.eXF != null) {
                                b.this.eXG.b(b.this.eXF);
                            }
                        }
                    });
                }
                if (b.this.eXE != null && b.this.eXE.abO != null) {
                    this.eXK.yD(b.this.eXE.abO);
                }
                if (b.this.eXE != null && b.this.eXE.portrait != null) {
                    this.eXK.yC(b.this.eXE.getPortrait());
                }
                String str3 = "";
                if (b.this.eXE != null) {
                    str3 = b.this.eXE.getSubappType();
                }
                this.eXK.yE(str);
                this.eXK.setRoomId(b.this.roomId);
                this.eXK.yF(str2);
                this.eXK.yG(str3);
                this.eXK.show();
                n.bp(true);
                if (b.this.eXE != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.eXE.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.eXE.getSubappType());
                }
            }
        }
    };
    CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.i.b.3
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
    d.a eXI = new d.a() { // from class: com.baidu.tieba.ala.liveroom.i.b.6
        @Override // com.baidu.tieba.ala.liveroom.o.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.eXE = cVar;
            if (b.this.eXG != null) {
                b.this.eXG.yG(cVar.eWC);
            }
            if (cVar.needToast == 1) {
                b.this.eXF = new ApkData();
                b.this.eXF.apkUrl = cVar.appUrl;
                b.this.eXF.apkPackageName = cVar.packageName;
                b.this.eXF.apkClipBoardScheme = cVar.eWB;
                b.this.eXF.apkDeeplinkScheme = cVar.eWz;
                b.this.eXF.apkOldDeeplinkScheme = cVar.eWA;
                g.pQ(2913151);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.o.d.a
        public void at(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes2.dex */
    public interface a {
        void bgO();

        void bgP();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.eXG = fVar;
        this.eXH = aVar;
        MessageManager.getInstance().registerListener(this.erA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean af(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eXB == null) {
            this.eXB = new c(getPageContext(), this.dmY);
        }
        bkf();
        this.erT = viewGroup;
        return true;
    }

    public View getView() {
        if (this.eXB == null) {
            return null;
        }
        return this.eXB.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && af(viewGroup)) {
                if (this.eXG == null || !this.eXG.isDownloading()) {
                    if (!bke()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.eXH != null) {
                        this.eXH.bgO();
                    }
                    this.erT.addView(this.eXB.getView(), layoutParams);
                    n.L(this.roomId);
                    if (this.eXE != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.eXE.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bkf()) {
                                n.bp(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bke() {
        return (this.eXF == null || TextUtils.isEmpty(this.eXF.apkPackageName) || TextUtils.isEmpty(this.eXF.apkUrl) || TextUtils.isEmpty(this.eXF.apkDeeplinkScheme) || TextUtils.isEmpty(this.eXF.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkf() {
        if (this.erT == null || this.erT.indexOfChild(this.eXB.getView()) < 0) {
            return false;
        }
        this.erT.removeView(this.eXB.getView());
        g.pR(2913151);
        if (this.eXH != null) {
            this.eXH.bgP();
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
        if (this.eXC != null) {
            this.eXC.cancel();
        }
        this.eXC = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.i.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.eXC, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.eXD == null) {
                    b.this.eXD = new com.baidu.tieba.ala.liveroom.o.d(b.this.mTbPageContext, b.this.eXI);
                }
                b.this.eXD.f(str, str2, j);
            }
        }, j2);
    }

    public void oZ() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bkf()) {
            n.bp(false);
        }
    }

    public void cancel() {
        if (this.eXC != null) {
            this.eXC.cancel();
        }
        if (this.eXD != null) {
            this.eXD.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        l ww = aVar.eWr.ww();
        AlaLiveInfoData boc = aVar.eWr.boc();
        if (n.M(boc.room_id) && ww != null && ww.WD != null && ww.WD.needToast == 1) {
            b(ww.WD.watchDurationMust, boc.live_id + "", boc.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        l ww = aVar.eWr.ww();
        if (ww != null && aVar != null && this.handler != null && ww.WD != null && ww.WD.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > ww.WD.watchDurationMust) {
            AlaLiveInfoData boc = aVar.eWr.boc();
            if (n.M(this.roomId)) {
                a(boc.live_id + "", boc.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

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
import com.baidu.live.data.u;
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
    protected c gCn;
    private TimerTask gCo;
    private com.baidu.tieba.ala.liveroom.q.e gCp;
    private com.baidu.tieba.ala.liveroom.data.c gCq;
    private ApkData gCr;
    private f gCs;
    private a gCt;
    private ViewGroup gcM;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String gcY = "";
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a gCw;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bTd();
            String str = null;
            String str2 = "";
            if (b.this.gCs != null && b.this.gCr != null) {
                ApkStatus a2 = b.this.gCs.a(b.this.gCr);
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
                if (this.gCw == null) {
                    this.gCw = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.gCw.a(new a.InterfaceC0629a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0629a
                        public void bTa() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0629a
                        public void bTb() {
                            if (b.this.gCs != null && b.this.gCr != null) {
                                b.this.gCs.b(b.this.gCr);
                            }
                        }
                    });
                }
                if (b.this.gCq != null && b.this.gCq.aEQ != null) {
                    this.gCw.Gz(b.this.gCq.aEQ);
                }
                if (b.this.gCq != null && b.this.gCq.portrait != null) {
                    this.gCw.Gy(b.this.gCq.getPortrait());
                }
                String str3 = "";
                if (b.this.gCq != null) {
                    str3 = b.this.gCq.getSubappType();
                }
                this.gCw.GA(str);
                this.gCw.setRoomId(b.this.roomId);
                this.gCw.GB(str2);
                this.gCw.GC(str3);
                this.gCw.show();
                n.cG(true);
                if (b.this.gCq != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.gCq.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.gCq.getSubappType());
                }
            }
        }
    };
    CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a gCu = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.gCq = cVar;
            if (b.this.gCs != null) {
                b.this.gCs.GC(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.gCr = new ApkData();
                b.this.gCr.apkUrl = cVar.appUrl;
                b.this.gCr.apkPackageName = cVar.packageName;
                b.this.gCr.apkClipBoardScheme = cVar.gAD;
                b.this.gCr.apkDeeplinkScheme = cVar.gAB;
                b.this.gCr.apkOldDeeplinkScheme = cVar.gAC;
                g.uu(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void aT(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes4.dex */
    public interface a {
        void bPa();

        void bPb();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.gCs = fVar;
        this.gCt = aVar;
        MessageManager.getInstance().registerListener(this.fTe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ak(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gCn == null) {
            this.gCn = new c(getPageContext(), this.eHN);
        }
        bTd();
        this.gcM = viewGroup;
        return true;
    }

    public View getView() {
        if (this.gCn == null) {
            return null;
        }
        return this.gCn.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ak(viewGroup)) {
                if (this.gCs == null || !this.gCs.isDownloading()) {
                    if (!bTc()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.gCt != null) {
                        this.gCt.bPa();
                    }
                    this.gcM.addView(this.gCn.getView(), layoutParams);
                    n.ax(this.roomId);
                    if (this.gCq != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.gCq.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bTd()) {
                                n.cG(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bTc() {
        return (this.gCr == null || TextUtils.isEmpty(this.gCr.apkPackageName) || TextUtils.isEmpty(this.gCr.apkUrl) || TextUtils.isEmpty(this.gCr.apkDeeplinkScheme) || TextUtils.isEmpty(this.gCr.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bTd() {
        if (this.gcM == null || this.gcM.indexOfChild(this.gCn.getView()) < 0) {
            return false;
        }
        this.gcM.removeView(this.gCn.getView());
        g.uv(2913168);
        if (this.gCt != null) {
            this.gCt.bPb();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fTe);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.gCo != null) {
            this.gCo.cancel();
        }
        this.gCo = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.gCo, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.gCp == null) {
                    b.this.gCp = new com.baidu.tieba.ala.liveroom.q.e(b.this.mTbPageContext, b.this.gCu);
                }
                b.this.gCp.g(str, str2, j);
            }
        }, j2);
    }

    public void BQ() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bTd()) {
            n.cG(false);
        }
    }

    public void cancel() {
        if (this.gCo != null) {
            this.gCo.cancel();
        }
        if (this.gCp != null) {
            this.gCp.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        u Fq = aVar.gAu.Fq();
        AlaLiveInfoData bXx = aVar.gAu.bXx();
        if (n.ay(bXx.room_id) && Fq != null && Fq.aFo != null && Fq.aFo.needToast == 1) {
            c(Fq.aFo.watchDurationMust, bXx.live_id + "", bXx.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        u Fq = aVar.gAu.Fq();
        if (Fq != null && aVar != null && this.handler != null && Fq.aFo != null && Fq.aFo.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Fq.aFo.watchDurationMust) {
            AlaLiveInfoData bXx = aVar.gAu.bXx();
            if (n.ay(this.roomId)) {
                a(bXx.live_id + "", bXx.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

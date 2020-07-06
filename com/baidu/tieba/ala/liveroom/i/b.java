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
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.n;
import com.baidu.tieba.ala.liveroom.i.a;
import com.baidu.tieba.ala.liveroom.n.d;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class b {
    private ViewGroup fIb;
    protected c ghj;
    private TimerTask ghk;
    private com.baidu.tieba.ala.liveroom.n.d ghl;
    private com.baidu.tieba.ala.liveroom.data.c ghm;
    private ApkData ghn;
    private f gho;
    private a ghp;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String fIn = "";
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.b.2
        private com.baidu.tieba.ala.liveroom.i.a ghs;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bEx();
            String str = null;
            String str2 = "";
            if (b.this.gho != null && b.this.ghn != null) {
                ApkStatus a2 = b.this.gho.a(b.this.ghn);
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
                if (this.ghs == null) {
                    this.ghs = new com.baidu.tieba.ala.liveroom.i.a(b.this.getPageContext().getPageActivity());
                    this.ghs.a(new a.InterfaceC0572a() { // from class: com.baidu.tieba.ala.liveroom.i.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0572a
                        public void bEu() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.i.a.InterfaceC0572a
                        public void bEv() {
                            if (b.this.gho != null && b.this.ghn != null) {
                                b.this.gho.b(b.this.ghn);
                            }
                        }
                    });
                }
                if (b.this.ghm != null && b.this.ghm.ayj != null) {
                    this.ghs.CQ(b.this.ghm.ayj);
                }
                if (b.this.ghm != null && b.this.ghm.portrait != null) {
                    this.ghs.CP(b.this.ghm.getPortrait());
                }
                String str3 = "";
                if (b.this.ghm != null) {
                    str3 = b.this.ghm.getSubappType();
                }
                this.ghs.CR(str);
                this.ghs.setRoomId(b.this.roomId);
                this.ghs.CS(str2);
                this.ghs.CT(str3);
                this.ghs.show();
                n.cu(true);
                if (b.this.ghm != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.ghm.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.ghm.getSubappType());
                }
            }
        }
    };
    CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.i.b.3
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
    d.a ghq = new d.a() { // from class: com.baidu.tieba.ala.liveroom.i.b.6
        @Override // com.baidu.tieba.ala.liveroom.n.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.ghm = cVar;
            if (b.this.gho != null) {
                b.this.gho.CT(cVar.ggc);
            }
            if (cVar.needToast == 1) {
                b.this.ghn = new ApkData();
                b.this.ghn.apkUrl = cVar.appUrl;
                b.this.ghn.apkPackageName = cVar.packageName;
                b.this.ghn.apkClipBoardScheme = cVar.ggb;
                b.this.ghn.apkDeeplinkScheme = cVar.gfZ;
                b.this.ghn.apkOldDeeplinkScheme = cVar.gga;
                g.rv(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.n.d.a
        public void aT(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes3.dex */
    public interface a {
        void bBd();

        void bBe();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.gho = fVar;
        this.ghp = aVar;
        MessageManager.getInstance().registerListener(this.fzr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ah(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.ghj == null) {
            this.ghj = new c(getPageContext(), this.eoP);
        }
        bEx();
        this.fIb = viewGroup;
        return true;
    }

    public View getView() {
        if (this.ghj == null) {
            return null;
        }
        return this.ghj.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ah(viewGroup)) {
                if (this.gho == null || !this.gho.isDownloading()) {
                    if (!bEw()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.ghp != null) {
                        this.ghp.bBd();
                    }
                    this.fIb.addView(this.ghj.getView(), layoutParams);
                    n.aw(this.roomId);
                    if (this.ghm != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.ghm.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bEx()) {
                                n.cu(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bEw() {
        return (this.ghn == null || TextUtils.isEmpty(this.ghn.apkPackageName) || TextUtils.isEmpty(this.ghn.apkUrl) || TextUtils.isEmpty(this.ghn.apkDeeplinkScheme) || TextUtils.isEmpty(this.ghn.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEx() {
        if (this.fIb == null || this.fIb.indexOfChild(this.ghj.getView()) < 0) {
            return false;
        }
        this.fIb.removeView(this.ghj.getView());
        g.rw(2913168);
        if (this.ghp != null) {
            this.ghp.bBe();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fzr);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.ghk != null) {
            this.ghk.cancel();
        }
        this.ghk = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.i.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.ghk, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.ghl == null) {
                    b.this.ghl = new com.baidu.tieba.ala.liveroom.n.d(b.this.mTbPageContext, b.this.ghq);
                }
                b.this.ghl.g(str, str2, j);
            }
        }, j2);
    }

    public void vH() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bEx()) {
            n.cu(false);
        }
    }

    public void cancel() {
        if (this.ghk != null) {
            this.ghk.cancel();
        }
        if (this.ghl != null) {
            this.ghl.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        q FU = aVar.gfS.FU();
        AlaLiveInfoData bIE = aVar.gfS.bIE();
        if (n.ax(bIE.room_id) && FU != null && FU.axU != null && FU.axU.needToast == 1) {
            c(FU.axU.watchDurationMust, bIE.live_id + "", bIE.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        q FU = aVar.gfS.FU();
        if (FU != null && aVar != null && this.handler != null && FU.axU != null && FU.axU.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > FU.axU.watchDurationMust) {
            AlaLiveInfoData bIE = aVar.gfS.bIE();
            if (n.ax(this.roomId)) {
                a(bIE.live_id + "", bIE.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

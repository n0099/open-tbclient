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
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class b {
    private ViewGroup fZu;
    protected c gyY;
    private TimerTask gyZ;
    private com.baidu.tieba.ala.liveroom.p.e gza;
    private com.baidu.tieba.ala.liveroom.data.c gzb;
    private ApkData gzc;
    private f gzd;
    private a gze;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String fZG = "";
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a gzh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bRG();
            String str = null;
            String str2 = "";
            if (b.this.gzd != null && b.this.gzc != null) {
                ApkStatus a2 = b.this.gzd.a(b.this.gzc);
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
                if (this.gzh == null) {
                    this.gzh = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.gzh.a(new a.InterfaceC0633a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0633a
                        public void bRD() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0633a
                        public void bRE() {
                            if (b.this.gzd != null && b.this.gzc != null) {
                                b.this.gzd.b(b.this.gzc);
                            }
                        }
                    });
                }
                if (b.this.gzb != null && b.this.gzb.aDS != null) {
                    this.gzh.Ga(b.this.gzb.aDS);
                }
                if (b.this.gzb != null && b.this.gzb.portrait != null) {
                    this.gzh.FZ(b.this.gzb.getPortrait());
                }
                String str3 = "";
                if (b.this.gzb != null) {
                    str3 = b.this.gzb.getSubappType();
                }
                this.gzh.Gb(str);
                this.gzh.setRoomId(b.this.roomId);
                this.gzh.Gc(str2);
                this.gzh.Gd(str3);
                this.gzh.show();
                n.cE(true);
                if (b.this.gzb != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.gzb.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.gzb.getSubappType());
                }
            }
        }
    };
    CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a gzf = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.gzb = cVar;
            if (b.this.gzd != null) {
                b.this.gzd.Gd(cVar.gxo);
            }
            if (cVar.needToast == 1) {
                b.this.gzc = new ApkData();
                b.this.gzc.apkUrl = cVar.appUrl;
                b.this.gzc.apkPackageName = cVar.packageName;
                b.this.gzc.apkClipBoardScheme = cVar.gxn;
                b.this.gzc.apkDeeplinkScheme = cVar.gxl;
                b.this.gzc.apkOldDeeplinkScheme = cVar.gxm;
                g.ub(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void aT(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes7.dex */
    public interface a {
        void bNQ();

        void bNR();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.gzd = fVar;
        this.gze = aVar;
        MessageManager.getInstance().registerListener(this.fPP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean aj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gyY == null) {
            this.gyY = new c(getPageContext(), this.eFC);
        }
        bRG();
        this.fZu = viewGroup;
        return true;
    }

    public View getView() {
        if (this.gyY == null) {
            return null;
        }
        return this.gyY.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && aj(viewGroup)) {
                if (this.gzd == null || !this.gzd.isDownloading()) {
                    if (!bRF()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.gze != null) {
                        this.gze.bNQ();
                    }
                    this.fZu.addView(this.gyY.getView(), layoutParams);
                    n.ax(this.roomId);
                    if (this.gzb != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.gzb.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bRG()) {
                                n.cE(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bRF() {
        return (this.gzc == null || TextUtils.isEmpty(this.gzc.apkPackageName) || TextUtils.isEmpty(this.gzc.apkUrl) || TextUtils.isEmpty(this.gzc.apkDeeplinkScheme) || TextUtils.isEmpty(this.gzc.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bRG() {
        if (this.fZu == null || this.fZu.indexOfChild(this.gyY.getView()) < 0) {
            return false;
        }
        this.fZu.removeView(this.gyY.getView());
        g.uc(2913168);
        if (this.gze != null) {
            this.gze.bNR();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fPP);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.gyZ != null) {
            this.gyZ.cancel();
        }
        this.gyZ = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.gyZ, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.gza == null) {
                    b.this.gza = new com.baidu.tieba.ala.liveroom.p.e(b.this.mTbPageContext, b.this.gzf);
                }
                b.this.gza.g(str, str2, j);
            }
        }, j2);
    }

    public void BB() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bRG()) {
            n.cE(false);
        }
    }

    public void cancel() {
        if (this.gyZ != null) {
            this.gyZ.cancel();
        }
        if (this.gza != null) {
            this.gza.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        r LC = aVar.gxe.LC();
        AlaLiveInfoData bVM = aVar.gxe.bVM();
        if (n.ay(bVM.room_id) && LC != null && LC.aEp != null && LC.aEp.needToast == 1) {
            c(LC.aEp.watchDurationMust, bVM.live_id + "", bVM.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        r LC = aVar.gxe.LC();
        if (LC != null && aVar != null && this.handler != null && LC.aEp != null && LC.aEp.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > LC.aEp.watchDurationMust) {
            AlaLiveInfoData bVM = aVar.gxe.bVM();
            if (n.ay(this.roomId)) {
                a(bVM.live_id + "", bVM.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

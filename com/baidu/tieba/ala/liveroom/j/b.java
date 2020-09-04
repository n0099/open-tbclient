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
    private ViewGroup fZy;
    protected c gzc;
    private TimerTask gzd;
    private com.baidu.tieba.ala.liveroom.p.e gze;
    private com.baidu.tieba.ala.liveroom.data.c gzf;
    private ApkData gzg;
    private f gzh;
    private a gzi;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String fZK = "";
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a gzl;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bRH();
            String str = null;
            String str2 = "";
            if (b.this.gzh != null && b.this.gzg != null) {
                ApkStatus a2 = b.this.gzh.a(b.this.gzg);
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
                if (this.gzl == null) {
                    this.gzl = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.gzl.a(new a.InterfaceC0633a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0633a
                        public void bRE() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0633a
                        public void bRF() {
                            if (b.this.gzh != null && b.this.gzg != null) {
                                b.this.gzh.b(b.this.gzg);
                            }
                        }
                    });
                }
                if (b.this.gzf != null && b.this.gzf.aDU != null) {
                    this.gzl.Gb(b.this.gzf.aDU);
                }
                if (b.this.gzf != null && b.this.gzf.portrait != null) {
                    this.gzl.Ga(b.this.gzf.getPortrait());
                }
                String str3 = "";
                if (b.this.gzf != null) {
                    str3 = b.this.gzf.getSubappType();
                }
                this.gzl.Gc(str);
                this.gzl.setRoomId(b.this.roomId);
                this.gzl.Gd(str2);
                this.gzl.Ge(str3);
                this.gzl.show();
                n.cF(true);
                if (b.this.gzf != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.gzf.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.gzf.getSubappType());
                }
            }
        }
    };
    CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a gzj = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.gzf = cVar;
            if (b.this.gzh != null) {
                b.this.gzh.Ge(cVar.gxs);
            }
            if (cVar.needToast == 1) {
                b.this.gzg = new ApkData();
                b.this.gzg.apkUrl = cVar.appUrl;
                b.this.gzg.apkPackageName = cVar.packageName;
                b.this.gzg.apkClipBoardScheme = cVar.gxr;
                b.this.gzg.apkDeeplinkScheme = cVar.gxp;
                b.this.gzg.apkOldDeeplinkScheme = cVar.gxq;
                g.ub(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void aS(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes7.dex */
    public interface a {
        void bNR();

        void bNS();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.gzh = fVar;
        this.gzi = aVar;
        MessageManager.getInstance().registerListener(this.fPT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean aj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gzc == null) {
            this.gzc = new c(getPageContext(), this.eFG);
        }
        bRH();
        this.fZy = viewGroup;
        return true;
    }

    public View getView() {
        if (this.gzc == null) {
            return null;
        }
        return this.gzc.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && aj(viewGroup)) {
                if (this.gzh == null || !this.gzh.isDownloading()) {
                    if (!bRG()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.gzi != null) {
                        this.gzi.bNR();
                    }
                    this.fZy.addView(this.gzc.getView(), layoutParams);
                    n.ax(this.roomId);
                    if (this.gzf != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.gzf.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bRH()) {
                                n.cF(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bRG() {
        return (this.gzg == null || TextUtils.isEmpty(this.gzg.apkPackageName) || TextUtils.isEmpty(this.gzg.apkUrl) || TextUtils.isEmpty(this.gzg.apkDeeplinkScheme) || TextUtils.isEmpty(this.gzg.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bRH() {
        if (this.fZy == null || this.fZy.indexOfChild(this.gzc.getView()) < 0) {
            return false;
        }
        this.fZy.removeView(this.gzc.getView());
        g.uc(2913168);
        if (this.gzi != null) {
            this.gzi.bNS();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fPT);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.gzd != null) {
            this.gzd.cancel();
        }
        this.gzd = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.gzd, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.gze == null) {
                    b.this.gze = new com.baidu.tieba.ala.liveroom.p.e(b.this.mTbPageContext, b.this.gzj);
                }
                b.this.gze.g(str, str2, j);
            }
        }, j2);
    }

    public void BB() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bRH()) {
            n.cF(false);
        }
    }

    public void cancel() {
        if (this.gzd != null) {
            this.gzd.cancel();
        }
        if (this.gze != null) {
            this.gze.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        r LC = aVar.gxi.LC();
        AlaLiveInfoData bVN = aVar.gxi.bVN();
        if (n.ay(bVN.room_id) && LC != null && LC.aEr != null && LC.aEr.needToast == 1) {
            c(LC.aEr.watchDurationMust, bVN.live_id + "", bVN.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        r LC = aVar.gxi.LC();
        if (LC != null && aVar != null && this.handler != null && LC.aEr != null && LC.aEr.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > LC.aEr.watchDurationMust) {
            AlaLiveInfoData bVN = aVar.gxi.bVN();
            if (n.ay(this.roomId)) {
                a(bVN.live_id + "", bVN.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

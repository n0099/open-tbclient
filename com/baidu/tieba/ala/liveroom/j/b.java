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
    private ViewGroup bEg;
    protected c hct;
    private TimerTask hcu;
    private com.baidu.tieba.ala.liveroom.q.e hcv;
    private com.baidu.tieba.ala.liveroom.data.c hcw;
    private ApkData hcx;
    private f hcy;
    private a hcz;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String gzt = "";
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a hcC;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bZv();
            String str = null;
            String str2 = "";
            if (b.this.hcy != null && b.this.hcx != null) {
                ApkStatus a2 = b.this.hcy.a(b.this.hcx);
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
                if (this.hcC == null) {
                    this.hcC = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.hcC.a(new a.InterfaceC0663a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0663a
                        public void bZs() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0663a
                        public void bZt() {
                            if (b.this.hcy != null && b.this.hcx != null) {
                                b.this.hcy.b(b.this.hcx);
                            }
                        }
                    });
                }
                if (b.this.hcw != null && b.this.hcw.aIv != null) {
                    this.hcC.HK(b.this.hcw.aIv);
                }
                if (b.this.hcw != null && b.this.hcw.portrait != null) {
                    this.hcC.HJ(b.this.hcw.getPortrait());
                }
                String str3 = "";
                if (b.this.hcw != null) {
                    str3 = b.this.hcw.getSubappType();
                }
                this.hcC.HL(str);
                this.hcC.setRoomId(b.this.roomId);
                this.hcC.HM(str2);
                this.hcC.HN(str3);
                this.hcC.show();
                n.cP(true);
                if (b.this.hcw != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hcw.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hcw.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a hcA = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hcw = cVar;
            if (b.this.hcy != null) {
                b.this.hcy.HN(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hcx = new ApkData();
                b.this.hcx.apkUrl = cVar.appUrl;
                b.this.hcx.apkPackageName = cVar.packageName;
                b.this.hcx.apkClipBoardScheme = cVar.haK;
                b.this.hcx.apkDeeplinkScheme = cVar.haI;
                b.this.hcx.apkOldDeeplinkScheme = cVar.haJ;
                g.vt(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void bf(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes4.dex */
    public interface a {
        void bVn();

        void bVo();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hcy = fVar;
        this.hcz = aVar;
        MessageManager.getInstance().registerListener(this.gpA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean am(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hct == null) {
            this.hct = new c(getPageContext(), this.fcr);
        }
        bZv();
        this.bEg = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hct == null) {
            return null;
        }
        return this.hct.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && am(viewGroup)) {
                if (this.hcy == null || !this.hcy.isDownloading()) {
                    if (!bZu()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hcz != null) {
                        this.hcz.bVn();
                    }
                    this.bEg.addView(this.hct.getView(), layoutParams);
                    n.aA(this.roomId);
                    if (this.hcw != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hcw.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bZv()) {
                                n.cP(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bZu() {
        return (this.hcx == null || TextUtils.isEmpty(this.hcx.apkPackageName) || TextUtils.isEmpty(this.hcx.apkUrl) || TextUtils.isEmpty(this.hcx.apkDeeplinkScheme) || TextUtils.isEmpty(this.hcx.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZv() {
        if (this.bEg == null || this.bEg.indexOfChild(this.hct.getView()) < 0) {
            return false;
        }
        this.bEg.removeView(this.hct.getView());
        g.vu(2913168);
        if (this.hcz != null) {
            this.hcz.bVo();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.hcu != null) {
            this.hcu.cancel();
        }
        this.hcu = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.b(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.hcu, j);
    }

    public void b(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.hcv == null) {
                    b.this.hcv = new com.baidu.tieba.ala.liveroom.q.e(b.this.mTbPageContext, b.this.hcA);
                }
                b.this.hcv.h(str, str2, j);
            }
        }, j2);
    }

    public void CT() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bZv()) {
            n.cP(false);
        }
    }

    public void cancel() {
        if (this.hcu != null) {
            this.hcu.cancel();
        }
        if (this.hcv != null) {
            this.hcv.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w GH = aVar.haB.GH();
        AlaLiveInfoData cdW = aVar.haB.cdW();
        if (n.aB(cdW.room_id) && GH != null && GH.aIP != null && GH.aIP.needToast == 1) {
            c(GH.aIP.watchDurationMust, cdW.live_id + "", cdW.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        w GH = aVar.haB.GH();
        if (GH != null && aVar != null && this.handler != null && GH.aIP != null && GH.aIP.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > GH.aIP.watchDurationMust) {
            AlaLiveInfoData cdW = aVar.haB.cdW();
            if (n.aB(this.roomId)) {
                b(cdW.live_id + "", cdW.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

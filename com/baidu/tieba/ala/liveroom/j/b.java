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
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.o;
import com.baidu.tieba.ala.liveroom.j.a;
import com.baidu.tieba.ala.liveroom.p.e;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class b {
    private ViewGroup bRX;
    private a hDA;
    protected c hDw;
    private com.baidu.tieba.ala.liveroom.p.e hDx;
    private com.baidu.tieba.ala.liveroom.data.c hDy;
    private f hDz;
    private ApkData hqh;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    private TimerTask mTimerTask;
    public String otherParams;
    private long roomId;
    private String gZB = "";
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a hDD;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cib();
            String str = null;
            String str2 = "";
            if (b.this.hDz != null && b.this.hqh != null) {
                ApkStatus b2 = b.this.hDz.b(b.this.hqh);
                if (b2 == ApkStatus.READY) {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_launch);
                    str2 = "gentazou";
                } else if (b2 == ApkStatus.NEED_UPDATE) {
                    b.this.mTbPageContext.showToast(a.h.ala_feedback_flow_low_version_tip);
                    return;
                } else if (b2 == ApkStatus.DOWNLOADED) {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_install);
                    str2 = "anzhuang";
                } else {
                    str = b.this.mTbPageContext.getString(a.h.ala_feedback_flow_btn_download);
                    str2 = "xiazai";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.hDD == null) {
                    this.hDD = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.hDD.a(new a.InterfaceC0683a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0683a
                        public void chY() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0683a
                        public void chZ() {
                            if (b.this.hDz != null && b.this.hqh != null) {
                                b.this.hDz.c(b.this.hqh);
                            }
                        }
                    });
                }
                if (b.this.hDy != null && b.this.hDy.aKL != null) {
                    this.hDD.Ir(b.this.hDy.aKL);
                }
                if (b.this.hDy != null && b.this.hDy.portrait != null) {
                    this.hDD.Iq(b.this.hDy.getPortrait());
                }
                String str3 = "";
                if (b.this.hDy != null) {
                    str3 = b.this.hDy.getSubappType();
                }
                this.hDD.Is(str);
                this.hDD.setRoomId(b.this.roomId);
                this.hDD.It(str2);
                this.hDD.Iu(str3);
                this.hDD.show();
                o.dp(true);
                if (b.this.hDy != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hDy.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hDy.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a hDB = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hDy = cVar;
            if (b.this.hDz != null) {
                b.this.hDz.Iu(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hqh = new ApkData();
                b.this.hqh.apkUrl = cVar.appUrl;
                b.this.hqh.apkPackageName = cVar.packageName;
                b.this.hqh.apkClipBoardScheme = cVar.hBZ;
                b.this.hqh.apkDeeplinkScheme = cVar.hBX;
                b.this.hqh.apkOldDeeplinkScheme = cVar.hBY;
                g.wU(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void bj(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes11.dex */
    public interface a {
        void cdF();

        void cdG();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hDz = fVar;
        this.hDA = aVar;
        MessageManager.getInstance().registerListener(this.gPs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean aw(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hDw == null) {
            this.hDw = new c(getPageContext(), this.onClickListener);
        }
        cib();
        this.bRX = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hDw == null) {
            return null;
        }
        return this.hDw.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && aw(viewGroup)) {
                if (this.hDz == null || !this.hDz.isDownloading()) {
                    if (!cia()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hDA != null) {
                        this.hDA.cdF();
                    }
                    this.bRX.addView(this.hDw.getView(), layoutParams);
                    o.bu(this.roomId);
                    if (this.hDy != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hDy.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cib()) {
                                o.dp(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cia() {
        return (this.hqh == null || TextUtils.isEmpty(this.hqh.apkPackageName) || TextUtils.isEmpty(this.hqh.apkUrl) || TextUtils.isEmpty(this.hqh.apkDeeplinkScheme) || TextUtils.isEmpty(this.hqh.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cib() {
        if (this.bRX == null || this.bRX.indexOfChild(this.hDw.getView()) < 0) {
            return false;
        }
        this.bRX.removeView(this.hDw.getView());
        g.wV(2913168);
        if (this.hDA != null) {
            this.hDA.cdG();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gPs);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
        }
        this.mTimerTask = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.b(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.mTimerTask, j);
    }

    public void b(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.hDx == null) {
                    b.this.hDx = new com.baidu.tieba.ala.liveroom.p.e(b.this.mTbPageContext, b.this.hDB);
                }
                b.this.hDx.i(str, str2, j);
            }
        }, j2);
    }

    public void DC() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cib()) {
            o.dp(false);
        }
    }

    public void cancel() {
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
        }
        if (this.hDx != null) {
            this.hDx.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        x HR = aVar.hBP.HR();
        AlaLiveInfoData cmy = aVar.hBP.cmy();
        if (o.bv(cmy.room_id) && HR != null && HR.aLh != null && HR.aLh.needToast == 1) {
            c(HR.aLh.watchDurationMust, cmy.live_id + "", cmy.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        x HR = aVar.hBP.HR();
        if (HR != null && aVar != null && this.handler != null && HR.aLh != null && HR.aLh.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > HR.aLh.watchDurationMust) {
            AlaLiveInfoData cmy = aVar.hBP.cmy();
            if (o.bv(this.roomId)) {
                b(cmy.live_id + "", cmy.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

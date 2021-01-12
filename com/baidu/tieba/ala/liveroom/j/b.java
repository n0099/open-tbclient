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
/* loaded from: classes10.dex */
public class b {
    private ViewGroup bNl;
    private ApkData hlA;
    protected c hyQ;
    private com.baidu.tieba.ala.liveroom.p.e hyR;
    private com.baidu.tieba.ala.liveroom.data.c hyS;
    private f hyT;
    private a hyU;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    private TimerTask mTimerTask;
    public String otherParams;
    private long roomId;
    private String gUV = "";
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a hyX;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cej();
            String str = null;
            String str2 = "";
            if (b.this.hyT != null && b.this.hlA != null) {
                ApkStatus b2 = b.this.hyT.b(b.this.hlA);
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
                if (this.hyX == null) {
                    this.hyX = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.hyX.a(new a.InterfaceC0666a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0666a
                        public void ceg() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0666a
                        public void ceh() {
                            if (b.this.hyT != null && b.this.hlA != null) {
                                b.this.hyT.c(b.this.hlA);
                            }
                        }
                    });
                }
                if (b.this.hyS != null && b.this.hyS.aFY != null) {
                    this.hyX.Hg(b.this.hyS.aFY);
                }
                if (b.this.hyS != null && b.this.hyS.portrait != null) {
                    this.hyX.Hf(b.this.hyS.getPortrait());
                }
                String str3 = "";
                if (b.this.hyS != null) {
                    str3 = b.this.hyS.getSubappType();
                }
                this.hyX.Hh(str);
                this.hyX.setRoomId(b.this.roomId);
                this.hyX.Hi(str2);
                this.hyX.Hj(str3);
                this.hyX.show();
                o.dl(true);
                if (b.this.hyS != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.hyS.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.hyS.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a hyV = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.hyS = cVar;
            if (b.this.hyT != null) {
                b.this.hyT.Hj(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.hlA = new ApkData();
                b.this.hlA.apkUrl = cVar.appUrl;
                b.this.hlA.apkPackageName = cVar.packageName;
                b.this.hlA.apkClipBoardScheme = cVar.hxt;
                b.this.hlA.apkDeeplinkScheme = cVar.hxr;
                b.this.hlA.apkOldDeeplinkScheme = cVar.hxs;
                g.vo(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.p.e.a
        public void bk(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes10.dex */
    public interface a {
        void bZN();

        void bZO();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.hyT = fVar;
        this.hyU = aVar;
        MessageManager.getInstance().registerListener(this.gKM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean aw(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.hyQ == null) {
            this.hyQ = new c(getPageContext(), this.onClickListener);
        }
        cej();
        this.bNl = viewGroup;
        return true;
    }

    public View getView() {
        if (this.hyQ == null) {
            return null;
        }
        return this.hyQ.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && aw(viewGroup)) {
                if (this.hyT == null || !this.hyT.isDownloading()) {
                    if (!cei()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.hyU != null) {
                        this.hyU.bZN();
                    }
                    this.bNl.addView(this.hyQ.getView(), layoutParams);
                    o.bu(this.roomId);
                    if (this.hyS != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.hyS.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.cej()) {
                                o.dl(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean cei() {
        return (this.hlA == null || TextUtils.isEmpty(this.hlA.apkPackageName) || TextUtils.isEmpty(this.hlA.apkUrl) || TextUtils.isEmpty(this.hlA.apkDeeplinkScheme) || TextUtils.isEmpty(this.hlA.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cej() {
        if (this.bNl == null || this.bNl.indexOfChild(this.hyQ.getView()) < 0) {
            return false;
        }
        this.bNl.removeView(this.hyQ.getView());
        g.vp(2913168);
        if (this.hyU != null) {
            this.hyU.bZO();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gKM);
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
                if (b.this.hyR == null) {
                    b.this.hyR = new com.baidu.tieba.ala.liveroom.p.e(b.this.mTbPageContext, b.this.hyV);
                }
                b.this.hyR.i(str, str2, j);
            }
        }, j2);
    }

    public void zH() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (cej()) {
            o.dl(false);
        }
    }

    public void cancel() {
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
        }
        if (this.hyR != null) {
            this.hyR.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        x DW = aVar.hxj.DW();
        AlaLiveInfoData ciG = aVar.hxj.ciG();
        if (o.bv(ciG.room_id) && DW != null && DW.aGu != null && DW.aGu.needToast == 1) {
            c(DW.aGu.watchDurationMust, ciG.live_id + "", ciG.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        x DW = aVar.hxj.DW();
        if (DW != null && aVar != null && this.handler != null && DW.aGu != null && DW.aGu.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > DW.aGu.watchDurationMust) {
            AlaLiveInfoData ciG = aVar.hxj.ciG();
            if (o.bv(this.roomId)) {
                b(ciG.live_id + "", ciG.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

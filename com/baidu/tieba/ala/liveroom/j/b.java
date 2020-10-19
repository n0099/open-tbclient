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
    private ViewGroup bBk;
    protected c gQG;
    private TimerTask gQH;
    private com.baidu.tieba.ala.liveroom.q.e gQI;
    private com.baidu.tieba.ala.liveroom.data.c gQJ;
    private ApkData gQK;
    private f gQL;
    private a gQM;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String gpo = "";
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
        private com.baidu.tieba.ala.liveroom.j.a gQP;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bWw();
            String str = null;
            String str2 = "";
            if (b.this.gQL != null && b.this.gQK != null) {
                ApkStatus a2 = b.this.gQL.a(b.this.gQK);
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
                if (this.gQP == null) {
                    this.gQP = new com.baidu.tieba.ala.liveroom.j.a(b.this.getPageContext().getPageActivity());
                    this.gQP.a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.liveroom.j.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0647a
                        public void bWt() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0647a
                        public void bWu() {
                            if (b.this.gQL != null && b.this.gQK != null) {
                                b.this.gQL.b(b.this.gQK);
                            }
                        }
                    });
                }
                if (b.this.gQJ != null && b.this.gQJ.aHU != null) {
                    this.gQP.Hl(b.this.gQJ.aHU);
                }
                if (b.this.gQJ != null && b.this.gQJ.portrait != null) {
                    this.gQP.Hk(b.this.gQJ.getPortrait());
                }
                String str3 = "";
                if (b.this.gQJ != null) {
                    str3 = b.this.gQJ.getSubappType();
                }
                this.gQP.Hm(str);
                this.gQP.setRoomId(b.this.roomId);
                this.gQP.Hn(str2);
                this.gQP.Ho(str3);
                this.gQP.show();
                n.cJ(true);
                if (b.this.gQJ != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.gQJ.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.gQJ.getSubappType());
                }
            }
        }
    };
    CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.b.3
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
    e.a gQN = new e.a() { // from class: com.baidu.tieba.ala.liveroom.j.b.6
        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.gQJ = cVar;
            if (b.this.gQL != null) {
                b.this.gQL.Ho(cVar.subappType);
            }
            if (cVar.needToast == 1) {
                b.this.gQK = new ApkData();
                b.this.gQK.apkUrl = cVar.appUrl;
                b.this.gQK.apkPackageName = cVar.packageName;
                b.this.gQK.apkClipBoardScheme = cVar.gOW;
                b.this.gQK.apkDeeplinkScheme = cVar.gOU;
                b.this.gQK.apkOldDeeplinkScheme = cVar.gOV;
                g.uZ(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.q.e.a
        public void bd(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes4.dex */
    public interface a {
        void bSr();

        void bSs();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.gQL = fVar;
        this.gQM = aVar;
        MessageManager.getInstance().registerListener(this.gfx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean am(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gQG == null) {
            this.gQG = new c(getPageContext(), this.eTU);
        }
        bWw();
        this.bBk = viewGroup;
        return true;
    }

    public View getView() {
        if (this.gQG == null) {
            return null;
        }
        return this.gQG.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && am(viewGroup)) {
                if (this.gQL == null || !this.gQL.isDownloading()) {
                    if (!bWv()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.gQM != null) {
                        this.gQM.bSr();
                    }
                    this.bBk.addView(this.gQG.getView(), layoutParams);
                    n.ay(this.roomId);
                    if (this.gQJ != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.gQJ.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bWw()) {
                                n.cJ(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bWv() {
        return (this.gQK == null || TextUtils.isEmpty(this.gQK.apkPackageName) || TextUtils.isEmpty(this.gQK.apkUrl) || TextUtils.isEmpty(this.gQK.apkDeeplinkScheme) || TextUtils.isEmpty(this.gQK.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bWw() {
        if (this.bBk == null || this.bBk.indexOfChild(this.gQG.getView()) < 0) {
            return false;
        }
        this.bBk.removeView(this.gQG.getView());
        g.va(2913168);
        if (this.gQM != null) {
            this.gQM.bSs();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gfx);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.gQH != null) {
            this.gQH.cancel();
        }
        this.gQH = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.j.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.gQH, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.gQI == null) {
                    b.this.gQI = new com.baidu.tieba.ala.liveroom.q.e(b.this.mTbPageContext, b.this.gQN);
                }
                b.this.gQI.h(str, str2, j);
            }
        }, j2);
    }

    public void CN() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bWw()) {
            n.cJ(false);
        }
    }

    public void cancel() {
        if (this.gQH != null) {
            this.gQH.cancel();
        }
        if (this.gQI != null) {
            this.gQI.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        u Gm = aVar.gON.Gm();
        AlaLiveInfoData caS = aVar.gON.caS();
        if (n.az(caS.room_id) && Gm != null && Gm.aIs != null && Gm.aIs.needToast == 1) {
            c(Gm.aIs.watchDurationMust, caS.live_id + "", caS.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        u Gm = aVar.gON.Gm();
        if (Gm != null && aVar != null && this.handler != null && Gm.aIs != null && Gm.aIs.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Gm.aIs.watchDurationMust) {
            AlaLiveInfoData caS = aVar.gON.caS();
            if (n.az(this.roomId)) {
                a(caS.live_id + "", caS.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

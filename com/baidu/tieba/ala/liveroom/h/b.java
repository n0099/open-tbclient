package com.baidu.tieba.ala.liveroom.h;

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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.apk.ApkData;
import com.baidu.live.tbadk.apk.ApkStatus;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.n;
import com.baidu.tieba.ala.liveroom.h.a;
import com.baidu.tieba.ala.liveroom.m.d;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class b {
    protected c fGk;
    private TimerTask fGl;
    private com.baidu.tieba.ala.liveroom.m.d fGm;
    private com.baidu.tieba.ala.liveroom.data.c fGn;
    private ApkData fGo;
    private f fGp;
    private a fGq;
    private ViewGroup faV;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String fjk = "";
    private View.OnClickListener dRK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.b.2
        private com.baidu.tieba.ala.liveroom.h.a fGt;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bvp();
            String str = null;
            String str2 = "";
            if (b.this.fGp != null && b.this.fGo != null) {
                ApkStatus a2 = b.this.fGp.a(b.this.fGo);
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
                if (this.fGt == null) {
                    this.fGt = new com.baidu.tieba.ala.liveroom.h.a(b.this.getPageContext().getPageActivity());
                    this.fGt.a(new a.InterfaceC0516a() { // from class: com.baidu.tieba.ala.liveroom.h.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0516a
                        public void bvm() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0516a
                        public void bvn() {
                            if (b.this.fGp != null && b.this.fGo != null) {
                                b.this.fGp.b(b.this.fGo);
                            }
                        }
                    });
                }
                if (b.this.fGn != null && b.this.fGn.arc != null) {
                    this.fGt.AJ(b.this.fGn.arc);
                }
                if (b.this.fGn != null && b.this.fGn.portrait != null) {
                    this.fGt.AI(b.this.fGn.getPortrait());
                }
                String str3 = "";
                if (b.this.fGn != null) {
                    str3 = b.this.fGn.getSubappType();
                }
                this.fGt.AK(str);
                this.fGt.setRoomId(b.this.roomId);
                this.fGt.AL(str2);
                this.fGt.AM(str3);
                this.fGt.show();
                n.cc(true);
                if (b.this.fGn != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.fGn.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.fGn.getSubappType());
                }
            }
        }
    };
    CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.h.b.3
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
    d.a fGr = new d.a() { // from class: com.baidu.tieba.ala.liveroom.h.b.6
        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.fGn = cVar;
            if (b.this.fGp != null) {
                b.this.fGp.AM(cVar.fFr);
            }
            if (cVar.needToast == 1) {
                b.this.fGo = new ApkData();
                b.this.fGo.apkUrl = cVar.appUrl;
                b.this.fGo.apkPackageName = cVar.packageName;
                b.this.fGo.apkClipBoardScheme = cVar.fFq;
                b.this.fGo.apkDeeplinkScheme = cVar.fFo;
                b.this.fGo.apkOldDeeplinkScheme = cVar.fFp;
                g.qt(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void aK(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes3.dex */
    public interface a {
        void bsu();

        void bsv();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.fGp = fVar;
        this.fGq = aVar;
        MessageManager.getInstance().registerListener(this.faq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean Y(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fGk == null) {
            this.fGk = new c(getPageContext(), this.dRK);
        }
        bvp();
        this.faV = viewGroup;
        return true;
    }

    public View getView() {
        if (this.fGk == null) {
            return null;
        }
        return this.fGk.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && Y(viewGroup)) {
                if (this.fGp == null || !this.fGp.isDownloading()) {
                    if (!bvo()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.fGq != null) {
                        this.fGq.bsu();
                    }
                    this.faV.addView(this.fGk.getView(), layoutParams);
                    n.ar(this.roomId);
                    if (this.fGn != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.fGn.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bvp()) {
                                n.cc(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bvo() {
        return (this.fGo == null || TextUtils.isEmpty(this.fGo.apkPackageName) || TextUtils.isEmpty(this.fGo.apkUrl) || TextUtils.isEmpty(this.fGo.apkDeeplinkScheme) || TextUtils.isEmpty(this.fGo.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvp() {
        if (this.faV == null || this.faV.indexOfChild(this.fGk.getView()) < 0) {
            return false;
        }
        this.faV.removeView(this.fGk.getView());
        g.qu(2913168);
        if (this.fGq != null) {
            this.fGq.bsv();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.faq);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.fGl != null) {
            this.fGl.cancel();
        }
        this.fGl = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.h.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.fGl, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.fGm == null) {
                    b.this.fGm = new com.baidu.tieba.ala.liveroom.m.d(b.this.mTbPageContext, b.this.fGr);
                }
                b.this.fGm.f(str, str2, j);
            }
        }, j2);
    }

    public void uf() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bvp()) {
            n.cc(false);
        }
    }

    public void cancel() {
        if (this.fGl != null) {
            this.fGl.cancel();
        }
        if (this.fGm != null) {
            this.fGm.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        com.baidu.live.data.n DM = aVar.fFh.DM();
        AlaLiveInfoData bzp = aVar.fFh.bzp();
        if (n.as(bzp.room_id) && DM != null && DM.aqP != null && DM.aqP.needToast == 1) {
            c(DM.aqP.watchDurationMust, bzp.live_id + "", bzp.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        com.baidu.live.data.n DM = aVar.fFh.DM();
        if (DM != null && aVar != null && this.handler != null && DM.aqP != null && DM.aqP.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > DM.aqP.watchDurationMust) {
            AlaLiveInfoData bzp = aVar.fFh.bzp();
            if (n.as(this.roomId)) {
                a(bzp.live_id + "", bzp.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

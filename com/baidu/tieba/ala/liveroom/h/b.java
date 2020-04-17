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
    protected c fGf;
    private TimerTask fGg;
    private com.baidu.tieba.ala.liveroom.m.d fGh;
    private com.baidu.tieba.ala.liveroom.data.c fGi;
    private ApkData fGj;
    private f fGk;
    private a fGl;
    private ViewGroup faQ;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String fjf = "";
    private View.OnClickListener dRF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.b.2
        private com.baidu.tieba.ala.liveroom.h.a fGo;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bvr();
            String str = null;
            String str2 = "";
            if (b.this.fGk != null && b.this.fGj != null) {
                ApkStatus a2 = b.this.fGk.a(b.this.fGj);
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
                if (this.fGo == null) {
                    this.fGo = new com.baidu.tieba.ala.liveroom.h.a(b.this.getPageContext().getPageActivity());
                    this.fGo.a(new a.InterfaceC0495a() { // from class: com.baidu.tieba.ala.liveroom.h.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0495a
                        public void bvo() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0495a
                        public void bvp() {
                            if (b.this.fGk != null && b.this.fGj != null) {
                                b.this.fGk.b(b.this.fGj);
                            }
                        }
                    });
                }
                if (b.this.fGi != null && b.this.fGi.aqW != null) {
                    this.fGo.AG(b.this.fGi.aqW);
                }
                if (b.this.fGi != null && b.this.fGi.portrait != null) {
                    this.fGo.AF(b.this.fGi.getPortrait());
                }
                String str3 = "";
                if (b.this.fGi != null) {
                    str3 = b.this.fGi.getSubappType();
                }
                this.fGo.AH(str);
                this.fGo.setRoomId(b.this.roomId);
                this.fGo.AI(str2);
                this.fGo.AJ(str3);
                this.fGo.show();
                n.cc(true);
                if (b.this.fGi != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.fGi.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.fGi.getSubappType());
                }
            }
        }
    };
    CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.h.b.3
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
    d.a fGm = new d.a() { // from class: com.baidu.tieba.ala.liveroom.h.b.6
        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.fGi = cVar;
            if (b.this.fGk != null) {
                b.this.fGk.AJ(cVar.fFm);
            }
            if (cVar.needToast == 1) {
                b.this.fGj = new ApkData();
                b.this.fGj.apkUrl = cVar.appUrl;
                b.this.fGj.apkPackageName = cVar.packageName;
                b.this.fGj.apkClipBoardScheme = cVar.fFl;
                b.this.fGj.apkDeeplinkScheme = cVar.fFj;
                b.this.fGj.apkOldDeeplinkScheme = cVar.fFk;
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
        void bsw();

        void bsx();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.fGk = fVar;
        this.fGl = aVar;
        MessageManager.getInstance().registerListener(this.fal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean Y(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fGf == null) {
            this.fGf = new c(getPageContext(), this.dRF);
        }
        bvr();
        this.faQ = viewGroup;
        return true;
    }

    public View getView() {
        if (this.fGf == null) {
            return null;
        }
        return this.fGf.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && Y(viewGroup)) {
                if (this.fGk == null || !this.fGk.isDownloading()) {
                    if (!bvq()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.fGl != null) {
                        this.fGl.bsw();
                    }
                    this.faQ.addView(this.fGf.getView(), layoutParams);
                    n.ar(this.roomId);
                    if (this.fGi != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.fGi.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bvr()) {
                                n.cc(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bvq() {
        return (this.fGj == null || TextUtils.isEmpty(this.fGj.apkPackageName) || TextUtils.isEmpty(this.fGj.apkUrl) || TextUtils.isEmpty(this.fGj.apkDeeplinkScheme) || TextUtils.isEmpty(this.fGj.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvr() {
        if (this.faQ == null || this.faQ.indexOfChild(this.fGf.getView()) < 0) {
            return false;
        }
        this.faQ.removeView(this.fGf.getView());
        g.qu(2913168);
        if (this.fGl != null) {
            this.fGl.bsx();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fal);
    }

    public void b(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.fGg != null) {
            this.fGg.cancel();
        }
        this.fGg = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.h.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.fGg, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.fGh == null) {
                    b.this.fGh = new com.baidu.tieba.ala.liveroom.m.d(b.this.mTbPageContext, b.this.fGm);
                }
                b.this.fGh.f(str, str2, j);
            }
        }, j2);
    }

    public void ug() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bvr()) {
            n.cc(false);
        }
    }

    public void cancel() {
        if (this.fGg != null) {
            this.fGg.cancel();
        }
        if (this.fGh != null) {
            this.fGh.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        com.baidu.live.data.n DN = aVar.fFc.DN();
        AlaLiveInfoData bzr = aVar.fFc.bzr();
        if (n.as(bzr.room_id) && DN != null && DN.aqJ != null && DN.aqJ.needToast == 1) {
            b(DN.aqJ.watchDurationMust, bzr.live_id + "", bzr.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        com.baidu.live.data.n DN = aVar.fFc.DN();
        if (DN != null && aVar != null && this.handler != null && DN.aqJ != null && DN.aqJ.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > DN.aqJ.watchDurationMust) {
            AlaLiveInfoData bzr = aVar.fFc.bzr();
            if (n.as(this.roomId)) {
                a(bzr.live_id + "", bzr.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

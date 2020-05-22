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
import com.baidu.live.data.q;
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
    protected c fUf;
    private TimerTask fUg;
    private com.baidu.tieba.ala.liveroom.m.d fUh;
    private com.baidu.tieba.ala.liveroom.data.c fUi;
    private ApkData fUj;
    private f fUk;
    private a fUl;
    private ViewGroup fox;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String fwR = "";
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.b.2
        private com.baidu.tieba.ala.liveroom.h.a fUo;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bBo();
            String str = null;
            String str2 = "";
            if (b.this.fUk != null && b.this.fUj != null) {
                ApkStatus a2 = b.this.fUk.a(b.this.fUj);
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
                if (this.fUo == null) {
                    this.fUo = new com.baidu.tieba.ala.liveroom.h.a(b.this.getPageContext().getPageActivity());
                    this.fUo.a(new a.InterfaceC0563a() { // from class: com.baidu.tieba.ala.liveroom.h.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0563a
                        public void bBl() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0563a
                        public void bBm() {
                            if (b.this.fUk != null && b.this.fUj != null) {
                                b.this.fUk.b(b.this.fUj);
                            }
                        }
                    });
                }
                if (b.this.fUi != null && b.this.fUi.awb != null) {
                    this.fUo.Cr(b.this.fUi.awb);
                }
                if (b.this.fUi != null && b.this.fUi.portrait != null) {
                    this.fUo.Cq(b.this.fUi.getPortrait());
                }
                String str3 = "";
                if (b.this.fUi != null) {
                    str3 = b.this.fUi.getSubappType();
                }
                this.fUo.Cs(str);
                this.fUo.setRoomId(b.this.roomId);
                this.fUo.Ct(str2);
                this.fUo.Cu(str3);
                this.fUo.show();
                n.co(true);
                if (b.this.fUi != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.fUi.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.fUi.getSubappType());
                }
            }
        }
    };
    CustomMessageListener fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.h.b.3
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
    d.a fUm = new d.a() { // from class: com.baidu.tieba.ala.liveroom.h.b.6
        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.fUi = cVar;
            if (b.this.fUk != null) {
                b.this.fUk.Cu(cVar.fTl);
            }
            if (cVar.needToast == 1) {
                b.this.fUj = new ApkData();
                b.this.fUj.apkUrl = cVar.appUrl;
                b.this.fUj.apkPackageName = cVar.packageName;
                b.this.fUj.apkClipBoardScheme = cVar.fTk;
                b.this.fUj.apkDeeplinkScheme = cVar.fTi;
                b.this.fUj.apkOldDeeplinkScheme = cVar.fTj;
                g.qU(2913168);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, null));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void aP(int i, String str) {
            b.this.mTbPageContext.showToast(str);
        }
    };
    private Handler handler = new Handler();

    /* loaded from: classes3.dex */
    public interface a {
        void byp();

        void byq();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.fUk = fVar;
        this.fUl = aVar;
        MessageManager.getInstance().registerListener(this.fnT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean af(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fUf == null) {
            this.fUf = new c(getPageContext(), this.ege);
        }
        bBo();
        this.fox = viewGroup;
        return true;
    }

    public View getView() {
        if (this.fUf == null) {
            return null;
        }
        return this.fUf.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && af(viewGroup)) {
                if (this.fUk == null || !this.fUk.isDownloading()) {
                    if (!bBn()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.fUl != null) {
                        this.fUl.byp();
                    }
                    this.fox.addView(this.fUf.getView(), layoutParams);
                    n.aw(this.roomId);
                    if (this.fUi != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.fUi.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bBo()) {
                                n.co(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bBn() {
        return (this.fUj == null || TextUtils.isEmpty(this.fUj.apkPackageName) || TextUtils.isEmpty(this.fUj.apkUrl) || TextUtils.isEmpty(this.fUj.apkDeeplinkScheme) || TextUtils.isEmpty(this.fUj.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBo() {
        if (this.fox == null || this.fox.indexOfChild(this.fUf.getView()) < 0) {
            return false;
        }
        this.fox.removeView(this.fUf.getView());
        g.qV(2913168);
        if (this.fUl != null) {
            this.fUl.byq();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.fUg != null) {
            this.fUg.cancel();
        }
        this.fUg = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.h.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.fUg, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.fUh == null) {
                    b.this.fUh = new com.baidu.tieba.ala.liveroom.m.d(b.this.mTbPageContext, b.this.fUm);
                }
                b.this.fUh.f(str, str2, j);
            }
        }, j2);
    }

    public void vm() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bBo()) {
            n.co(false);
        }
    }

    public void cancel() {
        if (this.fUg != null) {
            this.fUg.cancel();
        }
        if (this.fUh != null) {
            this.fUh.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        q Fk = aVar.fTb.Fk();
        AlaLiveInfoData bFv = aVar.fTb.bFv();
        if (n.ax(bFv.room_id) && Fk != null && Fk.avO != null && Fk.avO.needToast == 1) {
            c(Fk.avO.watchDurationMust, bFv.live_id + "", bFv.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        q Fk = aVar.fTb.Fk();
        if (Fk != null && aVar != null && this.handler != null && Fk.avO != null && Fk.avO.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Fk.avO.watchDurationMust) {
            AlaLiveInfoData bFv = aVar.fTb.bFv();
            if (n.ax(this.roomId)) {
                a(bFv.live_id + "", bFv.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

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
    protected c fUq;
    private TimerTask fUr;
    private com.baidu.tieba.ala.liveroom.m.d fUs;
    private com.baidu.tieba.ala.liveroom.data.c fUt;
    private ApkData fUu;
    private f fUv;
    private a fUw;
    private ViewGroup foI;
    protected TbPageContext mTbPageContext;
    private Timer mTimer;
    public String otherParams;
    private long roomId;
    private String fxc = "";
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.b.2
        private com.baidu.tieba.ala.liveroom.h.a fUz;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bBq();
            String str = null;
            String str2 = "";
            if (b.this.fUv != null && b.this.fUu != null) {
                ApkStatus a2 = b.this.fUv.a(b.this.fUu);
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
                if (this.fUz == null) {
                    this.fUz = new com.baidu.tieba.ala.liveroom.h.a(b.this.getPageContext().getPageActivity());
                    this.fUz.a(new a.InterfaceC0563a() { // from class: com.baidu.tieba.ala.liveroom.h.b.2.1
                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0563a
                        public void bBn() {
                        }

                        @Override // com.baidu.tieba.ala.liveroom.h.a.InterfaceC0563a
                        public void bBo() {
                            if (b.this.fUv != null && b.this.fUu != null) {
                                b.this.fUv.b(b.this.fUu);
                            }
                        }
                    });
                }
                if (b.this.fUt != null && b.this.fUt.awb != null) {
                    this.fUz.Cr(b.this.fUt.awb);
                }
                if (b.this.fUt != null && b.this.fUt.portrait != null) {
                    this.fUz.Cq(b.this.fUt.getPortrait());
                }
                String str3 = "";
                if (b.this.fUt != null) {
                    str3 = b.this.fUt.getSubappType();
                }
                this.fUz.Cs(str);
                this.fUz.setRoomId(b.this.roomId);
                this.fUz.Ct(str2);
                this.fUz.Cu(str3);
                this.fUz.show();
                n.co(true);
                if (b.this.fUt != null) {
                    LogManager.getFeedDiversionLogger().doClickGuideFloatLayerLog(b.this.roomId + "", b.this.fUt.getSubappType());
                    LogManager.getFeedDiversionLogger().doDisplayGuideDialogLog(b.this.roomId + "", b.this.fUt.getSubappType());
                }
            }
        }
    };
    CustomMessageListener foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.h.b.3
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
    d.a fUx = new d.a() { // from class: com.baidu.tieba.ala.liveroom.h.b.6
        @Override // com.baidu.tieba.ala.liveroom.m.d.a
        public void a(com.baidu.tieba.ala.liveroom.data.c cVar) {
            b.this.fUt = cVar;
            if (b.this.fUv != null) {
                b.this.fUv.Cu(cVar.fTw);
            }
            if (cVar.needToast == 1) {
                b.this.fUu = new ApkData();
                b.this.fUu.apkUrl = cVar.appUrl;
                b.this.fUu.apkPackageName = cVar.packageName;
                b.this.fUu.apkClipBoardScheme = cVar.fTv;
                b.this.fUu.apkDeeplinkScheme = cVar.fTt;
                b.this.fUu.apkOldDeeplinkScheme = cVar.fTu;
                g.qW(2913168);
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
        void byr();

        void bys();
    }

    public b(TbPageContext tbPageContext, String str, f fVar, a aVar) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        this.fUv = fVar;
        this.fUw = aVar;
        MessageManager.getInstance().registerListener(this.foe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean af(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fUq == null) {
            this.fUq = new c(getPageContext(), this.ege);
        }
        bBq();
        this.foI = viewGroup;
        return true;
    }

    public View getView() {
        if (this.fUq == null) {
            return null;
        }
        return this.fUq.getView();
    }

    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) != 2) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && af(viewGroup)) {
                if (this.fUv == null || !this.fUv.isDownloading()) {
                    if (!bBp()) {
                        BdLog.e("apk download data invalid");
                        return;
                    }
                    if (this.fUw != null) {
                        this.fUw.byr();
                    }
                    this.foI.addView(this.fUq.getView(), layoutParams);
                    n.aw(this.roomId);
                    if (this.fUt != null) {
                        LogManager.getFeedDiversionLogger().doDisplayGuideFloatLayerLog(this.roomId + "", this.fUt.getSubappType());
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bBq()) {
                                n.co(false);
                            }
                        }
                    }, 5000L);
                }
            }
        }
    }

    private boolean bBp() {
        return (this.fUu == null || TextUtils.isEmpty(this.fUu.apkPackageName) || TextUtils.isEmpty(this.fUu.apkUrl) || TextUtils.isEmpty(this.fUu.apkDeeplinkScheme) || TextUtils.isEmpty(this.fUu.apkClipBoardScheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBq() {
        if (this.foI == null || this.foI.indexOfChild(this.fUq.getView()) < 0) {
            return false;
        }
        this.foI.removeView(this.fUq.getView());
        g.qX(2913168);
        if (this.fUw != null) {
            this.fUw.bys();
        }
        return true;
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.foe);
    }

    public void c(long j, final String str, final String str2, final long j2) {
        if (j <= 0) {
            j = 30000;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        if (this.fUr != null) {
            this.fUr.cancel();
        }
        this.fUr = new TimerTask() { // from class: com.baidu.tieba.ala.liveroom.h.b.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b.this.a(str, str2, j2, 0L);
            }
        };
        this.mTimer.schedule(this.fUr, j);
    }

    public void a(final String str, final String str2, final long j, long j2) {
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.fUs == null) {
                    b.this.fUs = new com.baidu.tieba.ala.liveroom.m.d(b.this.mTbPageContext, b.this.fUx);
                }
                b.this.fUs.f(str, str2, j);
            }
        }, j2);
    }

    public void vm() {
        cancel();
        this.handler.removeCallbacksAndMessages(null);
        if (bBq()) {
            n.co(false);
        }
    }

    public void cancel() {
        if (this.fUr != null) {
            this.fUr.cancel();
        }
        if (this.fUs != null) {
            this.fUs.cancelLoadData();
        }
    }

    public void b(com.baidu.tieba.ala.liveroom.data.a aVar) {
        q Fk = aVar.fTm.Fk();
        AlaLiveInfoData bFx = aVar.fTm.bFx();
        if (n.ax(bFx.room_id) && Fk != null && Fk.avO != null && Fk.avO.needToast == 1) {
            c(Fk.avO.watchDurationMust, bFx.live_id + "", bFx.user_id + "", aVar.enterTime);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.a aVar) {
        q Fk = aVar.fTm.Fk();
        if (Fk != null && aVar != null && this.handler != null && Fk.avO != null && Fk.avO.needToast == 1 && System.currentTimeMillis() - (aVar.enterTime * 1000) > Fk.avO.watchDurationMust) {
            AlaLiveInfoData bFx = aVar.fTm.bFx();
            if (n.ax(this.roomId)) {
                a(bFx.live_id + "", bFx.user_id + "", aVar.enterTime, 5000L);
            }
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }
}

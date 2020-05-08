package com.baidu.tieba.advert.sdk;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.g.d;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes10.dex */
public class c {
    private CustomMessageTask eCT = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bho();
    }

    public void xB() {
        this.eCT.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.eCT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.aHq() != null && dVar.aHq().getContext() != null) {
            final com.baidu.tbadk.g.c aHr = dVar.aHr();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void LH() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHr != null) {
                        aHr.sZ("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void pB() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHr != null) {
                        aHr.aHn();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHr != null) {
                        aHr.aHp();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup LI() {
                    return dVar.aHq();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHr != null) {
                        aHr.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void LJ() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void LK() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHr != null) {
                        aHr.sZ("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.Le().a(dVar.aHq().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                aHr.sZ("oom");
            }
        }
    }

    private void bho() {
        com.baidu.prologue.a.b.a.brU.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes10.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context Lg() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lh() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Li() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lj() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String baK = ag.baK();
            if (TextUtils.isEmpty(baK)) {
                baK = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + baK);
            }
            return baK;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lk() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Ll() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lm() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.ay(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Ln() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.djW;
            }
            if (cookie != null) {
                String[] split = cookie.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                for (String str : split) {
                    if (str.contains("BAIDUID=")) {
                        return str.trim().substring(8);
                    }
                }
            }
            return "";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lo() {
            int[] LG = com.baidu.prologue.business.b.LF().LG();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(LG[0]), String.valueOf(LG[1]), "android", Lh(), String.valueOf(LG[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lp() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean Lq() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lr() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String pw() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean Ls() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Lt() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().dMx;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Lu() {
            AppPosInfo cOb = com.baidu.tieba.recapp.d.a.cNY().cOb();
            if (cOb != null) {
                return cOb.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] Lv() {
            AppPosInfo cOb;
            if (com.baidu.tieba.recapp.d.a.cNY() != null && (cOb = com.baidu.tieba.recapp.d.a.cNY().cOb()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + cOb.longitude + "|" + cOb.latitude);
                }
                return new String[]{cOb.longitude, cOb.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String Lw() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String Lx() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int Ly() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int Lz() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int LA() {
            return R.drawable.pic_splash_logo;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean a(String str, com.baidu.prologue.c.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, str));
            return true;
        }

        @Override // com.baidu.prologue.a.b.a
        public String LB() {
            return w.bax();
        }

        @Override // com.baidu.prologue.a.b.a
        public int LC() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String LD() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

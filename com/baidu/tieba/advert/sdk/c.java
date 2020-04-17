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
    private CustomMessageTask eCO = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bhq();
    }

    public void xC() {
        this.eCO.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.eCO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.aHs() != null && dVar.aHs().getContext() != null) {
            final com.baidu.tbadk.g.c aHt = dVar.aHt();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void LI() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHt != null) {
                        aHt.sW("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void pB() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHt != null) {
                        aHt.aHp();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHt != null) {
                        aHt.aHr();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup LJ() {
                    return dVar.aHs();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHt != null) {
                        aHt.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void LK() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void LL() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aHt != null) {
                        aHt.sW("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.Lf().a(dVar.aHs().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                aHt.sW("oom");
            }
        }
    }

    private void bhq() {
        com.baidu.prologue.a.b.a.brQ.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes10.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context Lh() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Li() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lj() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lk() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String baM = ag.baM();
            if (TextUtils.isEmpty(baM)) {
                baM = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + baM);
            }
            return baM;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Ll() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lm() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Ln() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aK(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lo() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.djS;
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
        public String Lp() {
            int[] LH = com.baidu.prologue.business.b.LG().LH();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(LH[0]), String.valueOf(LH[1]), "android", Li(), String.valueOf(LH[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Lq() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean Lr() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Ls() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String pw() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean Lt() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Lu() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().dMt;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Lv() {
            AppPosInfo cOe = com.baidu.tieba.recapp.d.a.cOb().cOe();
            if (cOe != null) {
                return cOe.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] Lw() {
            AppPosInfo cOe;
            if (com.baidu.tieba.recapp.d.a.cOb() != null && (cOe = com.baidu.tieba.recapp.d.a.cOb().cOe()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + cOe.longitude + "|" + cOe.latitude);
                }
                return new String[]{cOe.longitude, cOe.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String Lx() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String Ly() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int Lz() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int LA() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int LB() {
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
        public String LC() {
            return w.baz();
        }

        @Override // com.baidu.prologue.a.b.a
        public int LD() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String LE() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

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
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes10.dex */
public class c {
    private CustomMessageTask fbO = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bqb();
    }

    public void xp() {
        this.fbO.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.fbO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.aOH() != null && dVar.aOH().getContext() != null) {
            final com.baidu.tbadk.g.c aOI = dVar.aOI();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void Pa() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aOI != null) {
                        aOI.uN("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void pY() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aOI != null) {
                        aOI.aOE();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aOI != null) {
                        aOI.aOG();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup Pb() {
                    return dVar.aOH();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aOI != null) {
                        aOI.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void Pc() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void Pd() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aOI != null) {
                        aOI.uN("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.Ox().a(dVar.aOH().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                aOI.uN("oom");
            }
        }
    }

    private void bqb() {
        com.baidu.prologue.a.b.a.bEl.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes10.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context Oz() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OA() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OB() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OC() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bjj = ah.bjj();
            if (TextUtils.isEmpty(bjj)) {
                bjj = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bjj);
            }
            return bjj;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OD() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OE() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OF() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aJ(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OG() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.dDc;
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
        public String OH() {
            int[] OZ = com.baidu.prologue.business.b.OY().OZ();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(OZ[0]), String.valueOf(OZ[1]), "android", OA(), String.valueOf(OZ[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OI() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean OJ() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OK() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String pT() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean OL() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String OM() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().ejy;
        }

        @Override // com.baidu.prologue.a.b.a
        public String ON() {
            AppPosInfo cZI = com.baidu.tieba.recapp.d.a.cZF().cZI();
            if (cZI != null) {
                return cZI.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] OO() {
            AppPosInfo cZI;
            if (com.baidu.tieba.recapp.d.a.cZF() != null && (cZI = com.baidu.tieba.recapp.d.a.cZF().cZI()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + cZI.longitude + "|" + cZI.latitude);
                }
                return new String[]{cZI.longitude, cZI.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String OP() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String OQ() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int OR() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int OS() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int OT() {
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
        public String OU() {
            return x.biW();
        }

        @Override // com.baidu.prologue.a.b.a
        public int OV() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String OW() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

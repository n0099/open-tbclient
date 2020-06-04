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
    private CustomMessageTask eRD = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bnB();
    }

    public void Fv() {
        this.eRD.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.eRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.aNe() != null && dVar.aNe().getContext() != null) {
            final com.baidu.tbadk.g.c aNf = dVar.aNf();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void NU() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aNf != null) {
                        aNf.uF("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void pH() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aNf != null) {
                        aNf.aNb();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aNf != null) {
                        aNf.aNd();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup NV() {
                    return dVar.aNe();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aNf != null) {
                        aNf.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void NW() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void NX() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aNf != null) {
                        aNf.uF("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.Nr().a(dVar.aNe().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                aNf.uF("oom");
            }
        }
    }

    private void bnB() {
        com.baidu.prologue.a.b.a.bzx.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes10.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context Nt() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Nu() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Nv() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Nw() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bgW = ah.bgW();
            if (TextUtils.isEmpty(bgW)) {
                bgW = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bgW);
            }
            return bgW;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Nx() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Ny() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Nz() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aI(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String NA() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.dxW;
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
        public String NB() {
            int[] NT = com.baidu.prologue.business.b.NS().NT();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(NT[0]), String.valueOf(NT[1]), "android", Nu(), String.valueOf(NT[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String NC() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean ND() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String NE() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String pC() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean NF() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String NG() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().eaO;
        }

        @Override // com.baidu.prologue.a.b.a
        public String NH() {
            AppPosInfo cVs = com.baidu.tieba.recapp.d.a.cVp().cVs();
            if (cVs != null) {
                return cVs.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] NI() {
            AppPosInfo cVs;
            if (com.baidu.tieba.recapp.d.a.cVp() != null && (cVs = com.baidu.tieba.recapp.d.a.cVp().cVs()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + cVs.longitude + "|" + cVs.latitude);
                }
                return new String[]{cVs.longitude, cVs.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String NJ() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String NK() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int NL() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int NM() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int NN() {
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
        public String NO() {
            return x.bgJ();
        }

        @Override // com.baidu.prologue.a.b.a
        public int NP() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String NQ() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

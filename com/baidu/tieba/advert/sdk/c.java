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
import com.baidu.tbadk.util.aj;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes23.dex */
public class c {
    private CustomMessageTask gdm = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bNs();
    }

    public void registerTask() {
        this.gdm.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gdm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.bls() != null && dVar.bls().getContext() != null) {
            final com.baidu.tbadk.g.c blt = dVar.blt();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void aeJ() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (blt != null) {
                        blt.Aq("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void rF() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (blt != null) {
                        blt.blp();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (blt != null) {
                        blt.blr();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup aeK() {
                    return dVar.bls();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (blt != null) {
                        blt.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void aeL() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void aeM() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (blt != null) {
                        blt.Aq("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.aeg().a(dVar.bls().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                blt.Aq("oom");
            }
        }
    }

    private void bNs() {
        com.baidu.prologue.a.b.a.clZ.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes23.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context aei() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aej() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aek() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String ael() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bGX = aj.bGX();
            if (TextUtils.isEmpty(bGX)) {
                bGX = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bGX);
            }
            return bGX;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aem() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aen() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aeo() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.by(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aep() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.eAk;
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
        public String aeq() {
            int[] aeI = com.baidu.prologue.business.b.aeH().aeI();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(aeI[0]), String.valueOf(aeI[1]), "android", aej(), String.valueOf(aeI[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aer() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean aes() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aet() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String rA() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean aeu() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String aev() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().fje;
        }

        @Override // com.baidu.prologue.a.b.a
        public String aew() {
            AppPosInfo dGb = com.baidu.tieba.recapp.d.a.dFX().dGb();
            if (dGb != null) {
                return dGb.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] aex() {
            AppPosInfo dGb;
            if (com.baidu.tieba.recapp.d.a.dFX() != null && (dGb = com.baidu.tieba.recapp.d.a.dFX().dGb()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + dGb.longitude + "|" + dGb.latitude);
                }
                return new String[]{dGb.longitude, dGb.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String aey() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String aez() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int aeA() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int aeB() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int aeC() {
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
        public String aeD() {
            return com.baidu.helios.b.al(TbadkCoreApplication.getInst()).zj();
        }

        @Override // com.baidu.prologue.a.b.a
        public int aeE() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String aeF() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

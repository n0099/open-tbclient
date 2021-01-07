package com.baidu.tieba.advert.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.g.d;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes8.dex */
public class c {
    private CustomMessageTask gmF = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bPM();
    }

    public void registerTask() {
        this.gmF.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gmF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.bnR() != null && dVar.bnR().getContext() != null) {
            final com.baidu.tbadk.g.c bnS = dVar.bnS();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void agG() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bnS != null) {
                        bnS.Ao("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void rg() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bnS != null) {
                        bnS.onAdDismiss();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bnS != null) {
                        bnS.bnQ();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup agH() {
                    return dVar.bnR();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bnS != null) {
                        bnS.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void agI() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void agJ() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bnS != null) {
                        bnS.Ao("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.agd().a(dVar.bnR().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bnS.Ao("oom");
            }
        }
    }

    private void bPM() {
        com.baidu.prologue.a.b.a.ctd.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes8.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context agf() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String agg() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String agh() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String agi() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bJr = ai.bJr();
            if (TextUtils.isEmpty(bJr)) {
                bJr = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bJr);
            }
            return bJr;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String agj() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String agk() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String agl() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.bM(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String agm() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.eJN;
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
        public String agn() {
            int[] agF = com.baidu.prologue.business.b.agE().agF();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(agF[0]), String.valueOf(agF[1]), HttpConstants.OS_TYPE_VALUE, agg(), String.valueOf(agF[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String ago() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean agp() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String agq() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String rc() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean agr() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String ags() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().fsN;
        }

        @Override // com.baidu.prologue.a.b.a
        public String agt() {
            AppPosInfo dFS = com.baidu.tieba.recapp.c.a.dFO().dFS();
            if (dFS != null) {
                return dFS.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] agu() {
            AppPosInfo dFS;
            if (com.baidu.tieba.recapp.c.a.dFO() != null && (dFS = com.baidu.tieba.recapp.c.a.dFO().dFS()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + dFS.longitude + "|" + dFS.latitude);
                }
                return new String[]{dFS.longitude, dFS.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String agv() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String agw() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int agx() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int agy() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int agz() {
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
        public String agA() {
            return com.baidu.helios.b.ak(TbadkCoreApplication.getInst()).yA();
        }

        @Override // com.baidu.prologue.a.b.a
        public int agB() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String agC() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

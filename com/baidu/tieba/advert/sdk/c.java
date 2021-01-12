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
/* loaded from: classes7.dex */
public class c {
    private CustomMessageTask ghX = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bLU();
    }

    public void registerTask() {
        this.ghX.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ghX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.bjX() != null && dVar.bjX().getContext() != null) {
            final com.baidu.tbadk.g.c bjY = dVar.bjY();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void acM() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bjY != null) {
                        bjY.zd("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void rg() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bjY != null) {
                        bjY.onAdDismiss();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bjY != null) {
                        bjY.bjW();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup acN() {
                    return dVar.bjX();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bjY != null) {
                        bjY.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void acO() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void acP() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bjY != null) {
                        bjY.zd("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.acj().a(dVar.bjX().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bjY.zd("oom");
            }
        }
    }

    private void bLU() {
        com.baidu.prologue.a.b.a.cop.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes7.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context acl() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String acm() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String acn() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String aco() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bFz = ai.bFz();
            if (TextUtils.isEmpty(bFz)) {
                bFz = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bFz);
            }
            return bFz;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String acp() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String acq() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String acr() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.bL(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String acs() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.eFc;
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
        public String act() {
            int[] acL = com.baidu.prologue.business.b.acK().acL();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(acL[0]), String.valueOf(acL[1]), HttpConstants.OS_TYPE_VALUE, acm(), String.valueOf(acL[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String acu() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean acv() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String acw() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String rc() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean acx() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String acy() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().foc;
        }

        @Override // com.baidu.prologue.a.b.a
        public String acz() {
            AppPosInfo dCa = com.baidu.tieba.recapp.c.a.dBW().dCa();
            if (dCa != null) {
                return dCa.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] acA() {
            AppPosInfo dCa;
            if (com.baidu.tieba.recapp.c.a.dBW() != null && (dCa = com.baidu.tieba.recapp.c.a.dBW().dCa()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + dCa.longitude + "|" + dCa.latitude);
                }
                return new String[]{dCa.longitude, dCa.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String acB() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String acC() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int acD() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int acE() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int acF() {
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
        public String acG() {
            return com.baidu.helios.b.aj(TbadkCoreApplication.getInst()).uF();
        }

        @Override // com.baidu.prologue.a.b.a
        public int acH() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String acI() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

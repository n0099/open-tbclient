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
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes22.dex */
public class c {
    private CustomMessageTask fVc = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bJK();
    }

    public void registerTask() {
        this.fVc.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.fVc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.bii() != null && dVar.bii().getContext() != null) {
            final com.baidu.tbadk.g.c bij = dVar.bij();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void abB() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bij != null) {
                        bij.zJ("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void rD() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bij != null) {
                        bij.bif();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bij != null) {
                        bij.bih();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup abC() {
                    return dVar.bii();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bij != null) {
                        bij.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void abD() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void abE() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bij != null) {
                        bij.zJ("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.aaY().a(dVar.bii().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bij.zJ("oom");
            }
        }
    }

    private void bJK() {
        com.baidu.prologue.a.b.a.cft.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes22.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context aba() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abb() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abc() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abd() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bDw = ai.bDw();
            if (TextUtils.isEmpty(bDw)) {
                bDw = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bDw);
            }
            return bDw;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abe() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abf() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abg() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aS(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abh() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.eti;
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
        public String abi() {
            int[] abA = com.baidu.prologue.business.b.abz().abA();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(abA[0]), String.valueOf(abA[1]), "android", abb(), String.valueOf(abA[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abj() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean abk() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abl() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String ry() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean abm() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String abn() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().fbE;
        }

        @Override // com.baidu.prologue.a.b.a
        public String abo() {
            AppPosInfo dAK = com.baidu.tieba.recapp.d.a.dAG().dAK();
            if (dAK != null) {
                return dAK.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] abp() {
            AppPosInfo dAK;
            if (com.baidu.tieba.recapp.d.a.dAG() != null && (dAK = com.baidu.tieba.recapp.d.a.dAG().dAK()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + dAK.longitude + "|" + dAK.latitude);
                }
                return new String[]{dAK.longitude, dAK.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String abq() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String abr() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int abs() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int abt() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int abu() {
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
        public String abv() {
            return com.baidu.helios.b.aj(TbadkCoreApplication.getInst()).zr();
        }

        @Override // com.baidu.prologue.a.b.a
        public int abw() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String abx() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

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
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes23.dex */
public class c {
    private CustomMessageTask fVv = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bKr();
    }

    public void registerTask() {
        this.fVv.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.fVv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.biO() != null && dVar.biO().getContext() != null) {
            final com.baidu.tbadk.g.c biP = dVar.biP();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void ack() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (biP != null) {
                        biP.zP("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void rD() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (biP != null) {
                        biP.biL();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (biP != null) {
                        biP.biN();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup acl() {
                    return dVar.biO();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (biP != null) {
                        biP.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void acm() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void acn() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (biP != null) {
                        biP.zP("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.abH().a(dVar.biO().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                biP.zP("oom");
            }
        }
    }

    private void bKr() {
        com.baidu.prologue.a.b.a.che.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes23.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context abJ() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abK() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abL() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abM() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bEd = aj.bEd();
            if (TextUtils.isEmpty(bEd)) {
                bEd = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bEd);
            }
            return bEd;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abN() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abO() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abP() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aS(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abQ() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.euN;
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
        public String abR() {
            int[] acj = com.baidu.prologue.business.b.aci().acj();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(acj[0]), String.valueOf(acj[1]), "android", abK(), String.valueOf(acj[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abS() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean abT() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String abU() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String ry() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean abV() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String abW() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().fcx;
        }

        @Override // com.baidu.prologue.a.b.a
        public String abX() {
            AppPosInfo dBg = com.baidu.tieba.recapp.d.a.dBc().dBg();
            if (dBg != null) {
                return dBg.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] abY() {
            AppPosInfo dBg;
            if (com.baidu.tieba.recapp.d.a.dBc() != null && (dBg = com.baidu.tieba.recapp.d.a.dBc().dBg()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + dBg.longitude + "|" + dBg.latitude);
                }
                return new String[]{dBg.longitude, dBg.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String abZ() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String aca() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int acb() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int acc() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int acd() {
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
        public String ace() {
            return y.bDP();
        }

        @Override // com.baidu.prologue.a.b.a
        public int acf() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String acg() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

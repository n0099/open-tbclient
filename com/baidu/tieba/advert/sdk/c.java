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
    private CustomMessageTask fHk = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bFZ();
    }

    public void registerTask() {
        this.fHk.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.fHk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.bev() != null && dVar.bev().getContext() != null) {
            final com.baidu.tbadk.g.c bew = dVar.bew();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void XR() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bew != null) {
                        bew.zi("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void rD() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bew != null) {
                        bew.bes();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bew != null) {
                        bew.beu();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup XS() {
                    return dVar.bev();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bew != null) {
                        bew.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void XT() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void XU() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bew != null) {
                        bew.zi("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.Xo().a(dVar.bev().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bew.zi("oom");
            }
        }
    }

    private void bFZ() {
        com.baidu.prologue.a.b.a.bSV.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes23.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context Xq() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Xr() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Xs() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Xt() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bzL = aj.bzL();
            if (TextUtils.isEmpty(bzL)) {
                bzL = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bzL);
            }
            return bzL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Xu() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Xv() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Xw() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aS(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Xx() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.egw;
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
        public String Xy() {
            int[] XQ = com.baidu.prologue.business.b.XP().XQ();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(XQ[0]), String.valueOf(XQ[1]), "android", Xr(), String.valueOf(XQ[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Xz() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean XA() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String XB() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String ry() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean XC() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String XD() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().eOl;
        }

        @Override // com.baidu.prologue.a.b.a
        public String XE() {
            AppPosInfo dvx = com.baidu.tieba.recapp.d.a.dvt().dvx();
            if (dvx != null) {
                return dvx.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] XF() {
            AppPosInfo dvx;
            if (com.baidu.tieba.recapp.d.a.dvt() != null && (dvx = com.baidu.tieba.recapp.d.a.dvt().dvx()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + dvx.longitude + "|" + dvx.latitude);
                }
                return new String[]{dvx.longitude, dvx.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String XG() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String XH() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int XI() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int XJ() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int XK() {
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
        public String XL() {
            return y.bzx();
        }

        @Override // com.baidu.prologue.a.b.a
        public int XM() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String XN() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

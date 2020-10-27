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
    private CustomMessageTask fPF = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bHS();
    }

    public void registerTask() {
        this.fPF.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.fPF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.bgo() != null && dVar.bgo().getContext() != null) {
            final com.baidu.tbadk.g.c bgp = dVar.bgp();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void ZL() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bgp != null) {
                        bgp.zB("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void rD() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bgp != null) {
                        bgp.bgl();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bgp != null) {
                        bgp.bgn();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup ZM() {
                    return dVar.bgo();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bgp != null) {
                        bgp.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void ZN() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void ZO() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bgp != null) {
                        bgp.zB("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.Zi().a(dVar.bgo().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bgp.zB("oom");
            }
        }
    }

    private void bHS() {
        com.baidu.prologue.a.b.a.cbs.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes23.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context Zk() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zl() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zm() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zn() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bBE = aj.bBE();
            if (TextUtils.isEmpty(bBE)) {
                bBE = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bBE);
            }
            return bBE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zo() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zp() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zq() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aS(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zr() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.eoU;
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
        public String Zs() {
            int[] ZK = com.baidu.prologue.business.b.ZJ().ZK();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(ZK[0]), String.valueOf(ZK[1]), "android", Zl(), String.valueOf(ZK[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zt() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean Zu() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Zv() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String ry() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean Zw() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Zx() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().eWH;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Zy() {
            AppPosInfo dyE = com.baidu.tieba.recapp.d.a.dyA().dyE();
            if (dyE != null) {
                return dyE.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] Zz() {
            AppPosInfo dyE;
            if (com.baidu.tieba.recapp.d.a.dyA() != null && (dyE = com.baidu.tieba.recapp.d.a.dyA().dyE()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + dyE.longitude + "|" + dyE.latitude);
                }
                return new String[]{dyE.longitude, dyE.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String ZA() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String ZB() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int ZC() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int ZD() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int ZE() {
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
        public String ZF() {
            return y.bBq();
        }

        @Override // com.baidu.prologue.a.b.a
        public int ZG() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String ZH() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

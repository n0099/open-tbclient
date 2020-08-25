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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes17.dex */
public class c {
    private CustomMessageTask frL = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bCa();
    }

    public void registerTask() {
        this.frL.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.frL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.baT() != null && dVar.baT().getContext() != null) {
            final com.baidu.tbadk.g.c baU = dVar.baU();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void Vl() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (baU != null) {
                        baU.ya("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void ry() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (baU != null) {
                        baU.baQ();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (baU != null) {
                        baU.baS();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup Vm() {
                    return dVar.baT();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (baU != null) {
                        baU.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void Vn() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void Vo() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (baU != null) {
                        baU.ya("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.UI().a(dVar.baT().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                baU.ya("oom");
            }
        }
    }

    private void bCa() {
        com.baidu.prologue.a.b.a.bKi.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes17.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context UK() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UL() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UM() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UN() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bvR = ai.bvR();
            if (TextUtils.isEmpty(bvR)) {
                bvR = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bvR);
            }
            return bvR;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UO() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UP() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UQ() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aP(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UR() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.dSg;
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
        public String US() {
            int[] Vk = com.baidu.prologue.business.b.Vj().Vk();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(Vk[0]), String.valueOf(Vk[1]), "android", UL(), String.valueOf(Vk[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UT() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean UU() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String UV() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String rt() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean UW() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String UX() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().ezW;
        }

        @Override // com.baidu.prologue.a.b.a
        public String UY() {
            AppPosInfo doa = com.baidu.tieba.recapp.d.a.dnW().doa();
            if (doa != null) {
                return doa.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] UZ() {
            AppPosInfo doa;
            if (com.baidu.tieba.recapp.d.a.dnW() != null && (doa = com.baidu.tieba.recapp.d.a.dnW().doa()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + doa.longitude + "|" + doa.latitude);
                }
                return new String[]{doa.longitude, doa.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String Va() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String Vb() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int Vc() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int Vd() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int Ve() {
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
        public String Vf() {
            return x.bvD();
        }

        @Override // com.baidu.prologue.a.b.a
        public int Vg() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Vh() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

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
/* loaded from: classes22.dex */
public class c {
    private CustomMessageTask fvb = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bDn();
    }

    public void registerTask() {
        this.fvb.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.fvb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.bbN() != null && dVar.bbN().getContext() != null) {
            final com.baidu.tbadk.g.c bbO = dVar.bbO();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void VU() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bbO != null) {
                        bbO.yw("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void rD() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bbO != null) {
                        bbO.bbK();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bbO != null) {
                        bbO.bbM();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup VV() {
                    return dVar.bbN();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bbO != null) {
                        bbO.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void VW() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void VX() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (bbO != null) {
                        bbO.yw("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.Vr().a(dVar.bbN().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bbO.yw("oom");
            }
        }
    }

    private void bDn() {
        com.baidu.prologue.a.b.a.bMm.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes22.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context Vt() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Vu() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Vv() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Vw() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bxb = aj.bxb();
            if (TextUtils.isEmpty(bxb)) {
                bxb = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bxb);
            }
            return bxb;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Vx() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Vy() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String Vz() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aO(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String VA() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.dUu;
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
        public String VB() {
            int[] VT = com.baidu.prologue.business.b.VS().VT();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(VT[0]), String.valueOf(VT[1]), "android", Vu(), String.valueOf(VT[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String VC() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean VD() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String VE() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String ry() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean VF() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String VG() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().eCe;
        }

        @Override // com.baidu.prologue.a.b.a
        public String VH() {
            AppPosInfo drM = com.baidu.tieba.recapp.d.a.drI().drM();
            if (drM != null) {
                return drM.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] VI() {
            AppPosInfo drM;
            if (com.baidu.tieba.recapp.d.a.drI() != null && (drM = com.baidu.tieba.recapp.d.a.drI().drM()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + drM.longitude + "|" + drM.latitude);
                }
                return new String[]{drM.longitude, drM.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String VJ() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String VK() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int VL() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int VM() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int VN() {
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
        public String VO() {
            return y.bwN();
        }

        @Override // com.baidu.prologue.a.b.a
        public int VP() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String VQ() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

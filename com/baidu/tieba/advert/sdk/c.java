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
/* loaded from: classes17.dex */
public class c {
    private CustomMessageTask fgq = new CustomMessageTask(2156676, new CustomMessageTask.CustomRunnable<d>() { // from class: com.baidu.tieba.advert.sdk.c.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<d> customMessage) {
            if (customMessage != null) {
                c.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public c() {
        bte();
    }

    public void registerTask() {
        this.fgq.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.fgq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d dVar) {
        if (dVar != null && dVar.aSC() != null && dVar.aSC().getContext() != null) {
            final com.baidu.tbadk.g.c aSD = dVar.aSD();
            com.baidu.prologue.business.d dVar2 = new com.baidu.prologue.business.d() { // from class: com.baidu.tieba.advert.sdk.c.2
                @Override // com.baidu.prologue.business.d
                public void Pp() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aSD != null) {
                        aSD.vP("load fail");
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void pZ() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aSD != null) {
                        aSD.aSz();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void onAdShow() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aSD != null) {
                        aSD.aSB();
                    }
                }

                @Override // com.baidu.prologue.business.d
                @NonNull
                public ViewGroup Pq() {
                    return dVar.aSC();
                }

                @Override // com.baidu.prologue.business.d
                public void onAdClick() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aSD != null) {
                        aSD.onAdClick();
                    }
                }

                @Override // com.baidu.prologue.business.d
                public void Pr() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                }

                @Override // com.baidu.prologue.business.d
                public void Ps() {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("");
                    }
                    if (aSD != null) {
                        aSD.vP("play error");
                    }
                }
            };
            try {
                if (BdLog.isDebugMode()) {
                    BdLog.e("new bes splash load");
                }
                com.baidu.prologue.a.OM().a(dVar.aSC().getContext(), dVar2);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                aSD.vP("oom");
            }
        }
    }

    private void bte() {
        com.baidu.prologue.a.b.a.bEI.set(new a(TbadkCoreApplication.getInst()));
    }

    /* loaded from: classes17.dex */
    public class a implements com.baidu.prologue.a.b.a {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public Context OO() {
            return this.mContext;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OP() {
            return TbConfig.getVersion();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OQ() {
            return Build.VERSION.RELEASE;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OR() {
            return TbadkCoreApplication.getInst().getCuidGalaxy2();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String userAgent() {
            String bnd = ah.bnd();
            if (TextUtils.isEmpty(bnd)) {
                bnd = "bdtb for Android " + TbConfig.getVersion();
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("userAgent=" + bnd);
            }
            return bnd;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OS() {
            return Build.MODEL;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OT() {
            return TbadkCoreApplication.getInst().getImei();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OU() {
            return TbadkCoreApplication.getInst().getPackageName();
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String androidId() {
            return com.baidu.prologue.a.c.c.aK(this.mContext);
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OV() {
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.dIZ;
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
        public String OW() {
            int[] Po = com.baidu.prologue.business.b.Pn().Po();
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{String.valueOf(Po[0]), String.valueOf(Po[1]), "android", OP(), String.valueOf(Po[2])});
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OX() {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                return "";
            }
            return currentAccount;
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean OY() {
            return false;
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String OZ() {
            return "2";
        }

        @Override // com.baidu.prologue.a.b.a
        @NonNull
        public String pU() {
            return "1481698145541";
        }

        @Override // com.baidu.prologue.a.b.a
        public boolean Pa() {
            return this.mContext.getResources().getConfiguration().orientation == 2;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Pb() {
            if (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getAdAdSense() == null) {
                return null;
            }
            return TbadkCoreApplication.getInst().getAdAdSense().epK;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Pc() {
            AppPosInfo dcQ = com.baidu.tieba.recapp.d.a.dcN().dcQ();
            if (dcQ != null) {
                return dcQ.coordinate_type;
            }
            return null;
        }

        @Override // com.baidu.prologue.a.b.a
        public String[] Pd() {
            AppPosInfo dcQ;
            if (com.baidu.tieba.recapp.d.a.dcN() != null && (dcQ = com.baidu.tieba.recapp.d.a.dcN().dcQ()) != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("" + dcQ.longitude + "|" + dcQ.latitude);
                }
                return new String[]{dcQ.longitude, dcQ.latitude};
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("0, 0");
            }
            return new String[]{"0", "0"};
        }

        @Override // com.baidu.prologue.a.b.a
        public String Pe() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public String Pf() {
            return "1099a";
        }

        @Override // com.baidu.prologue.a.b.a
        public int Pg() {
            return R.drawable.bg_bes_splash_logo_white;
        }

        @Override // com.baidu.prologue.a.b.a
        public int Ph() {
            return R.drawable.bg_bes_splash_logo_blue;
        }

        @Override // com.baidu.prologue.a.b.a
        public int Pi() {
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
        public String Pj() {
            return x.bmQ();
        }

        @Override // com.baidu.prologue.a.b.a
        public int Pk() {
            return 5000;
        }

        @Override // com.baidu.prologue.a.b.a
        public String Pl() {
            return "http://afd.baidu.com/afd/entry";
        }
    }
}

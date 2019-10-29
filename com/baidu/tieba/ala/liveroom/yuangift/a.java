package com.baidu.tieba.ala.liveroom.yuangift;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c;
import com.baidu.live.data.af;
import com.baidu.live.data.ap;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.b.b;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import com.baidu.live.gift.g;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityConfig;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityOpaqueConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.data.BuyYinjiInfo;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.pay.PayManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.util.PageDialogHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.i;
import com.baidu.live.utils.o;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static a esy = null;
    private String aiq;
    private long currLiveId;
    private Dialog egu;
    private CashGiftHttpResponseMessage esA;
    private boolean esB;
    private String esC;
    private WeakReference<Context> esD;
    private String esE;
    private long esF;
    HttpMessageListener esG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST) { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof CashGiftHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                a.this.esA = (CashGiftHttpResponseMessage) httpResponsedMessage;
                a.this.esF = a.this.esA.dubi / 100;
                a.this.co(a.this.currLiveId);
            }
        }
    };
    private AlaDynamicGiftLayout esz;
    private View mContentView;
    private String mOtherParams;
    private long mRoomId;

    public static a aWZ() {
        if (esy == null) {
            synchronized (a.class) {
                if (esy == null) {
                    esy = new a();
                }
            }
        }
        return esy;
    }

    public void aAm() {
        if (this.egu != null && this.egu.isShowing()) {
            Context context = this.egu.getContext();
            if (context != null && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                } else if (activity.isFinishing()) {
                    return;
                }
            }
            try {
                this.egu.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.esz != null) {
            this.esz.onDestroy();
        }
        this.esz = null;
        this.egu = null;
        aXb();
    }

    public void a(Context context, long j, String str, long j2, String str2, String str3) {
        ap apVar;
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) {
            this.esD = new WeakReference<>(context);
            this.esE = str;
            this.mRoomId = j2;
            this.aiq = str2;
            this.mOtherParams = str3;
            this.currLiveId = j;
            af afVar = com.baidu.live.l.a.uA().akM;
            if (afVar != null && (apVar = afVar.Uh) != null && apVar.Vj) {
                this.esC = "no_show_trace_cash_gift_today_" + i.b(new Date());
                if (!c.np().getBoolean(this.esC, false)) {
                    if (this.egu != null && this.egu.isShowing()) {
                        if (this.esA != null && this.esA.est != null && b.rc().ci(this.esA.previewGiftId + "") && b.rc().ci(this.esA.est.pc())) {
                            try {
                                if (dl(context)) {
                                    this.egu.show();
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    aXa();
                }
            }
        }
    }

    public void cr(String str, String str2) {
        JSONArray jSONArray;
        try {
            String string = c.np().getString("show_trace_cash_gift", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str2, str);
            jSONObject.put(str, str2);
            jSONArray.put(jSONObject);
            c.np().putString("show_trace_cash_gift", jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, final long j, final long j2, final String str, final String str2) {
        if (context != null && this.esA != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                } else if (activity.isFinishing()) {
                    return;
                }
            }
            if (this.egu != null && this.egu.isShowing()) {
                try {
                    this.egu.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            View inflate = LayoutInflater.from(context).inflate(a.h.dialog_oneyuan_gift, (ViewGroup) null);
            this.mContentView = inflate.findViewById(a.g.main_layout);
            this.egu = new Dialog(context, a.j.FlowerGuideDialogStyle);
            this.egu.requestWindowFeature(1);
            this.egu.setCancelable(true);
            this.egu.setContentView(inflate);
            this.egu.setCanceledOnTouchOutside(false);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.img_gift_bg);
            final ImageView imageView = (ImageView) inflate.findViewById(a.g.img_gift_switch_show);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.esB = !a.this.esB;
                    c.np().putBoolean(a.this.esC, a.this.esB);
                    if (a.this.esB) {
                        imageView.setImageResource(a.f.icon_live_operatechoose_s);
                    } else {
                        imageView.setImageResource(a.f.icon_live_operatechoose_n);
                    }
                }
            });
            float dimensionPixelSize = (BdUtilHelper.getScreenDimensions(context)[0] * 1.0f) / context.getResources().getDimensionPixelSize(a.e.sdk_ds750);
            a(context, this.esA.previewGiftId, (FrameLayout) inflate.findViewById(a.g.giftAnim_layout), dimensionPixelSize);
            inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IntentConfig payWalletActivityConfig;
                    LogManager.getYuanPackageLogger().doClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.esF);
                    if (ViewHelper.checkUpIsLogin(context)) {
                        String str3 = a.this.esA.iconId;
                        String str4 = a.this.esA.nonMemberT + "";
                        String str5 = (a.this.esA.dubi / 100) + "";
                        String str6 = (a.this.esA.nonMemberT / 1000) + "";
                        if (Build.VERSION.SDK_INT >= 28 && !com.baidu.live.utils.c.at(context)) {
                            payWalletActivityConfig = new PayWalletActivityOpaqueConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        } else {
                            payWalletActivityConfig = new PayWalletActivityConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        }
                        PayManager.getInstance().doPayByWallet(payWalletActivityConfig);
                        a.this.aAm();
                    }
                }
            });
            this.egu.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onDismiss");
                    if (a.this.esz != null) {
                        a.this.esz.onDestroy();
                    }
                }
            });
            this.egu.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onShow");
                    if (a.this.esz != null) {
                        a.this.esz.startAnim();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.i("YuanGiftHelper", "@@ doClose");
                    a.this.aAm();
                    LogManager.getYuanPackageLogger().doCloseClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.esF);
                }
            });
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.6
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str3, boolean z) {
                    if (context instanceof Activity) {
                        Activity activity2 = (Activity) context;
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (activity2.isDestroyed() || activity2.isFinishing()) {
                                return;
                            }
                        } else if (activity2.isFinishing()) {
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "YuanGiftDialog"));
                        LogManager.getYuanPackageLogger().doDisplayOneGiftBagLog(j + "", j2 + "", str, str2, a.this.esF);
                        if (a.this.egu != null && !a.this.egu.isShowing()) {
                            a.this.egu.show();
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            if (!TextUtils.isEmpty(this.esA.esu)) {
                tbImageView.startLoad(this.esA.esu, 12, false);
            }
        }
    }

    private void a(Context context, int i, ViewGroup viewGroup, float f) {
        int i2;
        try {
            d dVar = new d(i + "", 1L, null, "", "", "", "", "", false, "", "");
            dVar.as(false);
            com.baidu.live.gift.c cC = b.rc().cC(i + "");
            if (cC != null && !ListUtils.isEmpty(cC.getDynamicGiftPicPathList())) {
                int i3 = cC.Wm.Wl.repeatCount;
                cC.Wm.Wl.repeatCount = BdStatsConstant.ErrorCode.ERR_LOG_FAST;
                if (this.esz != null) {
                    this.esz.onDestroy();
                }
                this.esz = new AlaDynamicGiftLayout(context);
                int dimensionPixelSize = (int) (context.getResources().getDimensionPixelSize(a.e.sdk_ds480) * f);
                int i4 = cC.Wm.Wl.width;
                int i5 = cC.Wm.Wl.height;
                if (i5 > 0) {
                    float f2 = (dimensionPixelSize * 1.0f) / i5;
                    if (i4 >= i5) {
                        i2 = (int) (f2 * 1334.0f);
                    } else {
                        i2 = (int) (f2 * 750.0f);
                    }
                    viewGroup.getLayoutParams().width = (i4 * dimensionPixelSize) / i5;
                    viewGroup.getLayoutParams().height = dimensionPixelSize;
                    viewGroup.setLayoutParams(viewGroup.getLayoutParams());
                    viewGroup.addView(this.esz, new ViewGroup.LayoutParams(-1, -1));
                    this.esz.setData(cC, dVar, i2, dimensionPixelSize);
                    this.esz.setBigGiftCallBack(new com.baidu.live.gift.biggift.b() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.7
                        @Override // com.baidu.live.gift.biggift.b
                        public void onStart() {
                        }

                        @Override // com.baidu.live.gift.biggift.b
                        public void ba(int i6) {
                        }

                        @Override // com.baidu.live.gift.biggift.b
                        public void onEnd() {
                            if (a.this.egu != null && a.this.egu.isShowing() && a.this.esz != null) {
                                a.this.esz.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.7.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (a.this.esz != null) {
                                            a.this.esz.startAnim();
                                        }
                                    }
                                });
                            }
                        }
                    });
                    cC.Wm.Wl.repeatCount = i3;
                }
            }
        } catch (OutOfMemoryError e) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
        }
    }

    private void aXa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_HOST + "liveserver/liveActivity/cashgift");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(CashGiftHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.esG);
        MessageManager.getInstance().sendMessage(new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST));
    }

    private void aXb() {
        MessageManager.getInstance().unRegisterListener(this.esG);
        MessageManager.getInstance().unRegisterTask(1021130);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void co(final long j) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        long j2;
        if (this.esA != null) {
            final String b = i.b(new Date());
            final String str = "date_" + this.esA.esx;
            HashMap hashMap = new HashMap();
            hashMap.put("test_yuan_package", false);
            Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
            boolean booleanValue = process.containsKey("test_yuan_package") ? ((Boolean) process.get("test_yuan_package")).booleanValue() : false;
            String string = c.np().getString("show_trace_cash_gift", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray2 = booleanValue ? null : jSONArray;
                if (jSONArray2 != null) {
                    HashSet hashSet = new HashSet();
                    int i = 0;
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                        if (optJSONObject != null) {
                            if (!TextUtils.isEmpty(optJSONObject.optString(b))) {
                                i++;
                            }
                            if (this.esA.UF == -1 || i < this.esA.UF) {
                                String optString = optJSONObject.optString(str);
                                if (!TextUtils.isEmpty(optString)) {
                                    hashSet.add(optString);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    if (this.esA.UG != -1) {
                        if (hashSet.size() <= this.esA.UG) {
                            if (hashSet.size() == this.esA.UG && i == 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                j2 = (!booleanValue ? 5 : this.esA.UH) * 1000;
                if (j2 <= 0) {
                    j2 = 180000;
                }
                LiveTimerManager.getInstance().addLiveTimerTask(this.esE, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.9
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        if (a.this.esA != null && a.this.esA.est != null && j == a.this.currLiveId) {
                            boolean ci = b.rc().ci(a.this.esA.previewGiftId + "");
                            boolean ci2 = b.rc().ci(a.this.esA.est.pc());
                            if (ci && ci2 && a.this.esD != null && a.this.esD.get() != null) {
                                Context context = (Context) a.this.esD.get();
                                if (a.this.dl(context)) {
                                    a.this.b(context, j, a.this.mRoomId, a.this.aiq, a.this.mOtherParams);
                                    a.this.cr(b, str);
                                }
                            }
                        }
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, j2, true);
            }
            jSONArray = null;
            if (booleanValue) {
            }
            if (jSONArray2 != null) {
            }
            j2 = (!booleanValue ? 5 : this.esA.UH) * 1000;
            if (j2 <= 0) {
            }
            LiveTimerManager.getInstance().addLiveTimerTask(this.esE, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.9
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    if (a.this.esA != null && a.this.esA.est != null && j == a.this.currLiveId) {
                        boolean ci = b.rc().ci(a.this.esA.previewGiftId + "");
                        boolean ci2 = b.rc().ci(a.this.esA.est.pc());
                        if (ci && ci2 && a.this.esD != null && a.this.esD.get() != null) {
                            Context context = (Context) a.this.esD.get();
                            if (a.this.dl(context)) {
                                a.this.b(context, j, a.this.mRoomId, a.this.aiq, a.this.mOtherParams);
                                a.this.cr(b, str);
                            }
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, j2, true);
        }
    }

    public void a(int i, int i2, Intent intent, com.baidu.live.data.i iVar, String str) {
        if (25042 == i && intent != null && iVar != null && this.esA != null) {
            a(intent.getIntExtra("result_code", -1), intent.getIntExtra("result_payinfo_status", -1), intent.getStringExtra("result_tbean_num"), this.esA.est, iVar, str);
        }
    }

    private void a(int i, int i2, String str, g gVar, com.baidu.live.data.i iVar, String str2) {
        switch (i) {
            case 0:
                Log.i("LiveViewController", "@@ handlePayResult 成功");
                a(true, i2, str, gVar, iVar, str2);
                return;
            case 1:
                Log.i("LiveViewController", "@@ handlePayResult 取消");
                HashMap hashMap = new HashMap();
                hashMap.put("test_yuan_package_paysucc", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey("test_yuan_package_paysucc")) {
                    a(((Boolean) process.get("test_yuan_package_paysucc")).booleanValue(), i2, str, gVar, iVar, str2);
                    return;
                } else {
                    a(false, i2, str, gVar, iVar, str2);
                    return;
                }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                Log.i("LiveViewController", "@@ handlePayResult 其他");
                a(false, i2, str, gVar, iVar, str2);
                return;
            default:
                return;
        }
    }

    private void a(boolean z, int i, String str, g gVar, com.baidu.live.data.i iVar, String str2) {
        if (z) {
            BuyYinjiInfo buyYinjiInfo = new BuyYinjiInfo();
            buyYinjiInfo.setTBeanNum(str);
            buyYinjiInfo.setStatus(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS, buyYinjiInfo));
            BdUtilHelper.getCustomToast().showToast("购买成功", 0);
            if (iVar.mLiveInfo.live_id == this.currLiveId && gVar != null) {
                gVar.setSceneFrom(o.wu());
                a(gVar, 1L, iVar, str2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098));
                return;
            }
            return;
        }
        BdUtilHelper.getCustomToast().showToast("购买失败", 0);
        aAm();
    }

    private void a(g gVar, long j, com.baidu.live.data.i iVar, String str) {
        b.rc().b(gVar, j, iVar.Ps.userId + "", iVar.Ps.userName, iVar.mLiveInfo.live_id + "", iVar.mLiveInfo.room_id + "", iVar.mLiveInfo.appId + "", iVar.mLiveInfo.feed_id + "", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dl(Context context) {
        return UtilHelper.getRealScreenOrientation(context) != 2;
    }

    public void pC() {
        if (this.egu != null && this.egu.isShowing() && this.mContentView != null && UtilHelper.getRealScreenOrientation(this.egu.getContext()) == 2) {
            aAm();
        }
    }
}

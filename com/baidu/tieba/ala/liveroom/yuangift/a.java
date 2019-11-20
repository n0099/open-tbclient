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
    private static a erH = null;
    private String ahX;
    private long currLiveId;
    private Dialog efD;
    private AlaDynamicGiftLayout erI;
    private CashGiftHttpResponseMessage erJ;
    private boolean erK;
    private String erL;
    private WeakReference<Context> erM;
    private String erN;
    private long erO;
    HttpMessageListener erP = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST) { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof CashGiftHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                a.this.erJ = (CashGiftHttpResponseMessage) httpResponsedMessage;
                a.this.erO = a.this.erJ.dubi / 100;
                a.this.cn(a.this.currLiveId);
            }
        }
    };
    private View mContentView;
    private String mOtherParams;
    private long mRoomId;

    public static a aWX() {
        if (erH == null) {
            synchronized (a.class) {
                if (erH == null) {
                    erH = new a();
                }
            }
        }
        return erH;
    }

    public void aAk() {
        if (this.efD != null && this.efD.isShowing()) {
            Context context = this.efD.getContext();
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
                this.efD.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.erI != null) {
            this.erI.onDestroy();
        }
        this.erI = null;
        this.efD = null;
        aWZ();
    }

    public void a(Context context, long j, String str, long j2, String str2, String str3) {
        ap apVar;
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) {
            this.erM = new WeakReference<>(context);
            this.erN = str;
            this.mRoomId = j2;
            this.ahX = str2;
            this.mOtherParams = str3;
            this.currLiveId = j;
            af afVar = com.baidu.live.l.a.uB().aku;
            if (afVar != null && (apVar = afVar.TO) != null && apVar.UQ) {
                this.erL = "no_show_trace_cash_gift_today_" + i.b(new Date());
                if (!c.np().getBoolean(this.erL, false)) {
                    if (this.efD != null && this.efD.isShowing()) {
                        if (this.erJ != null && this.erJ.erC != null && b.rd().ci(this.erJ.previewGiftId + "") && b.rd().ci(this.erJ.erC.pc())) {
                            try {
                                if (dl(context)) {
                                    this.efD.show();
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
                    aWY();
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
        if (context != null && this.erJ != null) {
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
            if (this.efD != null && this.efD.isShowing()) {
                try {
                    this.efD.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            View inflate = LayoutInflater.from(context).inflate(a.h.dialog_oneyuan_gift, (ViewGroup) null);
            this.mContentView = inflate.findViewById(a.g.main_layout);
            this.efD = new Dialog(context, a.j.FlowerGuideDialogStyle);
            this.efD.requestWindowFeature(1);
            this.efD.setCancelable(true);
            this.efD.setContentView(inflate);
            this.efD.setCanceledOnTouchOutside(false);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.img_gift_bg);
            final ImageView imageView = (ImageView) inflate.findViewById(a.g.img_gift_switch_show);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.erK = !a.this.erK;
                    c.np().putBoolean(a.this.erL, a.this.erK);
                    if (a.this.erK) {
                        imageView.setImageResource(a.f.icon_live_operatechoose_s);
                    } else {
                        imageView.setImageResource(a.f.icon_live_operatechoose_n);
                    }
                }
            });
            float dimensionPixelSize = (BdUtilHelper.getScreenDimensions(context)[0] * 1.0f) / context.getResources().getDimensionPixelSize(a.e.sdk_ds750);
            a(context, this.erJ.previewGiftId, (FrameLayout) inflate.findViewById(a.g.giftAnim_layout), dimensionPixelSize);
            inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IntentConfig payWalletActivityConfig;
                    LogManager.getYuanPackageLogger().doClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.erO);
                    if (ViewHelper.checkUpIsLogin(context)) {
                        String str3 = a.this.erJ.iconId;
                        String str4 = a.this.erJ.nonMemberT + "";
                        String str5 = (a.this.erJ.dubi / 100) + "";
                        String str6 = (a.this.erJ.nonMemberT / 1000) + "";
                        if (Build.VERSION.SDK_INT >= 28 && !com.baidu.live.utils.c.at(context)) {
                            payWalletActivityConfig = new PayWalletActivityOpaqueConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        } else {
                            payWalletActivityConfig = new PayWalletActivityConfig(context, 2, "0", str3, str5, str6, true, str4, false, PageDialogHelper.PayForm.NOT_SET, null, null, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY);
                        }
                        PayManager.getInstance().doPayByWallet(payWalletActivityConfig);
                        a.this.aAk();
                    }
                }
            });
            this.efD.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onDismiss");
                    if (a.this.erI != null) {
                        a.this.erI.onDestroy();
                    }
                }
            });
            this.efD.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Log.i("YuanGiftHelper", "@@ onShow");
                    if (a.this.erI != null) {
                        a.this.erI.startAnim();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.i("YuanGiftHelper", "@@ doClose");
                    a.this.aAk();
                    LogManager.getYuanPackageLogger().doCloseClickOneGiftBagLog(j + "", j2 + "", str, str2, a.this.erO);
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
                        LogManager.getYuanPackageLogger().doDisplayOneGiftBagLog(j + "", j2 + "", str, str2, a.this.erO);
                        if (a.this.efD != null && !a.this.efD.isShowing()) {
                            a.this.efD.show();
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            if (!TextUtils.isEmpty(this.erJ.erD)) {
                tbImageView.startLoad(this.erJ.erD, 12, false);
            }
        }
    }

    private void a(Context context, int i, ViewGroup viewGroup, float f) {
        int i2;
        try {
            d dVar = new d(i + "", 1L, null, "", "", "", "", "", false, "", "");
            dVar.as(false);
            com.baidu.live.gift.c cC = b.rd().cC(i + "");
            if (cC != null && !ListUtils.isEmpty(cC.getDynamicGiftPicPathList())) {
                int i3 = cC.VT.VS.repeatCount;
                cC.VT.VS.repeatCount = BdStatsConstant.ErrorCode.ERR_LOG_FAST;
                if (this.erI != null) {
                    this.erI.onDestroy();
                }
                this.erI = new AlaDynamicGiftLayout(context);
                int dimensionPixelSize = (int) (context.getResources().getDimensionPixelSize(a.e.sdk_ds480) * f);
                int i4 = cC.VT.VS.width;
                int i5 = cC.VT.VS.height;
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
                    viewGroup.addView(this.erI, new ViewGroup.LayoutParams(-1, -1));
                    this.erI.setData(cC, dVar, i2, dimensionPixelSize);
                    this.erI.setBigGiftCallBack(new com.baidu.live.gift.biggift.b() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.7
                        @Override // com.baidu.live.gift.biggift.b
                        public void onStart() {
                        }

                        @Override // com.baidu.live.gift.biggift.b
                        public void ba(int i6) {
                        }

                        @Override // com.baidu.live.gift.biggift.b
                        public void onEnd() {
                            if (a.this.efD != null && a.this.efD.isShowing() && a.this.erI != null) {
                                a.this.erI.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.7.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (a.this.erI != null) {
                                            a.this.erI.startAnim();
                                        }
                                    }
                                });
                            }
                        }
                    });
                    cC.VT.VS.repeatCount = i3;
                }
            }
        } catch (OutOfMemoryError e) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
        }
    }

    private void aWY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_HOST + "liveserver/liveActivity/cashgift");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(CashGiftHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.erP);
        MessageManager.getInstance().sendMessage(new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST));
    }

    private void aWZ() {
        MessageManager.getInstance().unRegisterListener(this.erP);
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
    public void cn(final long j) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        long j2;
        if (this.erJ != null) {
            final String b = i.b(new Date());
            final String str = "date_" + this.erJ.erG;
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
                            if (this.erJ.Ul == -1 || i < this.erJ.Ul) {
                                String optString = optJSONObject.optString(str);
                                if (!TextUtils.isEmpty(optString)) {
                                    hashSet.add(optString);
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    if (this.erJ.Um != -1) {
                        if (hashSet.size() <= this.erJ.Um) {
                            if (hashSet.size() == this.erJ.Um && i == 0) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                j2 = (!booleanValue ? 5 : this.erJ.Un) * 1000;
                if (j2 <= 0) {
                    j2 = 180000;
                }
                LiveTimerManager.getInstance().addLiveTimerTask(this.erN, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.9
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        if (a.this.erJ != null && a.this.erJ.erC != null && j == a.this.currLiveId) {
                            boolean ci = b.rd().ci(a.this.erJ.previewGiftId + "");
                            boolean ci2 = b.rd().ci(a.this.erJ.erC.pc());
                            if (ci && ci2 && a.this.erM != null && a.this.erM.get() != null) {
                                Context context = (Context) a.this.erM.get();
                                if (a.this.dl(context)) {
                                    a.this.b(context, j, a.this.mRoomId, a.this.ahX, a.this.mOtherParams);
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
            j2 = (!booleanValue ? 5 : this.erJ.Un) * 1000;
            if (j2 <= 0) {
            }
            LiveTimerManager.getInstance().addLiveTimerTask(this.erN, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.yuangift.a.9
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    if (a.this.erJ != null && a.this.erJ.erC != null && j == a.this.currLiveId) {
                        boolean ci = b.rd().ci(a.this.erJ.previewGiftId + "");
                        boolean ci2 = b.rd().ci(a.this.erJ.erC.pc());
                        if (ci && ci2 && a.this.erM != null && a.this.erM.get() != null) {
                            Context context = (Context) a.this.erM.get();
                            if (a.this.dl(context)) {
                                a.this.b(context, j, a.this.mRoomId, a.this.ahX, a.this.mOtherParams);
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
        if (25042 == i && intent != null && iVar != null && this.erJ != null) {
            a(intent.getIntExtra("result_code", -1), intent.getIntExtra("result_payinfo_status", -1), intent.getStringExtra("result_tbean_num"), this.erJ.erC, iVar, str);
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
                gVar.setSceneFrom(o.wv());
                a(gVar, 1L, iVar, str2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098));
                return;
            }
            return;
        }
        BdUtilHelper.getCustomToast().showToast("购买失败", 0);
        aAk();
    }

    private void a(g gVar, long j, com.baidu.live.data.i iVar, String str) {
        b.rd().b(gVar, j, iVar.OR.userId + "", iVar.OR.userName, iVar.mLiveInfo.live_id + "", iVar.mLiveInfo.room_id + "", iVar.mLiveInfo.appId + "", iVar.mLiveInfo.feed_id + "", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dl(Context context) {
        return UtilHelper.getRealScreenOrientation(context) != 2;
    }

    public void pC() {
        if (this.efD != null && this.efD.isShowing() && this.mContentView != null && UtilHelper.getRealScreenOrientation(this.efD.getContext()) == 2) {
            aAk();
        }
    }
}

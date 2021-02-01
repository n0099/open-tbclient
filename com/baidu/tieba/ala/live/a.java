package com.baidu.tieba.ala.live;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.data.PayChannelData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.IChannelPayController;
import com.baidu.live.tbadk.util.PageDialogHelper;
import com.baidu.tieba.ala.live.c.a;
import com.baidu.tieba.ala.live.c.c;
/* loaded from: classes11.dex */
public class a implements IChannelPayController {
    private BaseActivity bVA;
    private PayConfig mCurPayConfig;
    private com.baidu.tieba.ala.live.c.a mPayController;

    public a(PayChannelData payChannelData) {
        this.bVA = payChannelData.getBaseActivity();
        Log.d(IChannelPayController.TAG, "-->mPayController  构造函数");
        this.mPayController = c.c(this.bVA);
        this.mPayController.a(new a.InterfaceC0646a() { // from class: com.baidu.tieba.ala.live.a.1
            @Override // com.baidu.tieba.ala.live.c.a.InterfaceC0646a
            public void GZ(String str) {
            }

            @Override // com.baidu.tieba.ala.live.c.a.InterfaceC0646a
            public void a(boolean z, Intent intent) {
                Intent intent2 = new Intent();
                int intExtra = intent.getIntExtra("result_code", -1);
                String stringExtra = intent.getStringExtra("result_order_id");
                if (!TextUtils.isEmpty(stringExtra)) {
                    intent2.putExtra("transitionId", stringExtra);
                }
                intent2.putExtra("total", (intent.getIntExtra("result_tbean_num", 0) / 10) + "");
                if (intExtra == 0) {
                    intent2.putExtra("status", 0);
                    intent2.putExtra("message", "充值成功");
                } else if (intExtra == 1) {
                    intent2.putExtra("status", -2);
                    intent2.putExtra("message", "取消充值");
                } else {
                    intent2.putExtra("status", -1);
                    intent2.putExtra("message", "充值失败");
                }
                Log.d(IChannelPayController.TAG, "-->mPayController  onPayResultUpdate isSuc:" + z);
                ExtraParamsManager.getInstance();
                ExtraParamsManager.handleResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent2);
            }
        });
    }

    @Override // com.baidu.live.tbadk.pay.channel.interfaces.IChannelPayController
    public void pay(PayChannelData payChannelData) {
        String str = "0";
        String str2 = "0";
        String iconId = payChannelData.getIconId();
        try {
            str = (Integer.valueOf(payChannelData.getPrice()).intValue() / 100) + "";
            str2 = (Integer.valueOf(payChannelData.getPrice()).intValue() * 10) + "";
        } catch (NumberFormatException e) {
        }
        String from = payChannelData.getFrom();
        int payType = payChannelData.getPayType();
        String liveId = payChannelData.getLiveId();
        Log.d(IChannelPayController.TAG, "-->mPayController  pay--- propsId:" + iconId + ", money:" + str + ", propsMon:1, tBeanNum:" + str2 + ", from:" + from);
        this.mCurPayConfig = new PayConfig(payType, "0", iconId, str, "1", true, str2, false, PageDialogHelper.PayForm.NOT_SET, null, null, from, liveId);
        this.mPayController.Hj(payChannelData.getChannel());
        this.mPayController.setShowToast(payChannelData.getShowToast());
        this.mPayController.d(this.mCurPayConfig);
    }

    @Override // com.baidu.live.tbadk.pay.channel.interfaces.IChannelPayController
    public void release() {
        this.bVA = null;
        this.mPayController = null;
    }
}

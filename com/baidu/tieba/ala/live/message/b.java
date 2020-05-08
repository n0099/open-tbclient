package com.baidu.tieba.ala.live.message;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.bn;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    public b() {
        super(1003029);
    }

    public void a(int i, int i2, String str, int i3, int i4, int i5, String str2, String str3, String str4) {
        int i6;
        addParam("pay_type", i);
        addParam("is_left", i2);
        addParam("order_url", "");
        addParam("mobile", i2);
        addParam("is_autopay", i5);
        addParam("payment_pos_key", str2);
        int subappVersionCode = TbConfig.getSubappVersionCode();
        String str5 = (String) ExtraParamsManager.doProcessGeneric("hideWechatPay", "", String.class);
        if ((str5 != null && !TextUtils.equals(str5, "0")) || subappVersionCode <= 0) {
            i6 = 1;
        } else {
            addParam("app_version", subappVersionCode);
            i6 = 0;
        }
        addParam("no_wechat", i6);
        bn bnVar = new bn();
        bnVar.props_id = JavaTypesHelper.toInt(str, 0);
        bnVar.new_props_id = str;
        bnVar.money = i3;
        bnVar.axs = i4;
        bnVar.wars_name = "";
        bnVar.wars_item = "";
        addParam("wares", bnVar.toJson());
        if (!StringUtils.isNull(str3)) {
            addParam("refer_page", str3);
        }
        if (!StringUtils.isNull(str4)) {
            addParam("click_zone", str4);
        }
    }
}

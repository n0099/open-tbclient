package com.baidu.tieba.ala.live.message;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.cr;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    public b() {
        super(1003029);
    }

    public void a(int i, int i2, String str, int i3, int i4, int i5, String str2, String str3, String str4, String str5) {
        int i6;
        addParam("pay_type", i);
        addParam("is_left", i2);
        addParam("order_url", "");
        addParam("mobile", i2);
        addParam("is_autopay", i5);
        addParam("payment_pos_key", str2);
        int subappVersionCode = TbConfig.getSubappVersionCode();
        String str6 = (String) ExtraParamsManager.doProcessGeneric("hideWechatPay", "", String.class);
        if ((str6 != null && !TextUtils.equals(str6, "0")) || subappVersionCode <= 0) {
            i6 = 1;
        } else {
            addParam("app_version", subappVersionCode);
            i6 = 0;
        }
        addParam("no_wechat", i6);
        cr crVar = new cr();
        crVar.props_id = JavaTypesHelper.toInt(str, 0);
        crVar.new_props_id = str;
        crVar.money = i3;
        crVar.aSs = i4;
        crVar.wars_name = "";
        crVar.wars_item = "";
        addParam("wares", crVar.toJson());
        if (!StringUtils.isNull(str3)) {
            addParam("refer_page", str3);
        }
        if (!StringUtils.isNull(str4)) {
            addParam("click_zone", str4);
        }
        if (!StringUtils.isNull(str5)) {
            addParam("live_id", str5);
        }
        String baiduzid = ExtraParamsManager.getBaiduzid();
        if (baiduzid != null) {
            addParam("zid", baiduzid);
        }
        if (TbadkCoreApplication.getInst().getIsYuyinRoom()) {
            addParam("is_jiaoyou", 1);
        }
    }
}

package com.baidu.tieba.ala.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.av;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class a extends HttpMessage {
    public a() {
        super(1003029);
    }

    public void a(int i, int i2, String str, int i3, int i4, int i5, String str2, String str3, String str4) {
        addParam("pay_type", i);
        addParam("is_left", i2);
        addParam("order_url", "");
        addParam("mobile", i2);
        addParam("is_autopay", i5);
        addParam("payment_pos_key", str2);
        int i6 = 1;
        int subappVersionCode = TbConfig.getSubappVersionCode();
        if (subappVersionCode > 0) {
            addParam("app_version", subappVersionCode);
            i6 = 0;
        }
        addParam("no_wechat", i6);
        av avVar = new av();
        avVar.props_id = JavaTypesHelper.toInt(str, 0);
        avVar.new_props_id = str;
        avVar.Vb = i3;
        avVar.Vc = i4;
        avVar.wars_name = "";
        avVar.wars_item = "";
        addParam("wares", avVar.toJson());
        if (!StringUtils.isNull(str3)) {
            addParam("refer_page", str3);
        }
        if (!StringUtils.isNull(str4)) {
            addParam("click_zone", str4);
        }
    }
}

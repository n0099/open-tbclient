package com.baidu.tieba.ala.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.be;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class b extends HttpMessage {
    public b() {
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
        be beVar = new be();
        beVar.props_id = JavaTypesHelper.toInt(str, 0);
        beVar.new_props_id = str;
        beVar.money = i3;
        beVar.acy = i4;
        beVar.wars_name = "";
        beVar.wars_item = "";
        addParam("wares", beVar.toJson());
        if (!StringUtils.isNull(str3)) {
            addParam("refer_page", str3);
        }
        if (!StringUtils.isNull(str4)) {
            addParam("click_zone", str4);
        }
    }
}

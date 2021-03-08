package com.baidu.tieba.ala.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.db;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public a() {
        super(1003411);
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
        if (subappVersionCode > 0) {
            addParam("app_version", subappVersionCode);
            i6 = 0;
        } else {
            i6 = 1;
        }
        addParam("no_wechat", i6);
        db dbVar = new db();
        dbVar.props_id = JavaTypesHelper.toInt(str, 0);
        dbVar.new_props_id = str;
        dbVar.money = i3;
        dbVar.aUx = i4;
        dbVar.wars_name = "";
        dbVar.wars_item = "";
        addParam("wares", dbVar.toJson());
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

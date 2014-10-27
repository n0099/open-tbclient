package com.baidu.tieba.d.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class a extends i {
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final int bHi;
    public final int bHj;
    public final int bHk;
    public final b[] bHl;
    public b bHm;
    public final String ext_info;
    public final String first_name;
    public final String id;
    public final String ios_url;
    public final String name;
    public final String pos_name;
    public final String price;
    public final String second_name;
    public final String url;
    public final String user_id;
    public final String verify;
    public final int zp;

    public a() {
        this.id = null;
        this.name = null;
        this.bHi = 0;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.zp = 0;
        this.abtest = null;
        this.bHj = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.bHk = 0;
        this.bHl = null;
        this.bHm = null;
    }

    public a(JSONObject jSONObject) {
        a aVar = (a) i.objectWithJsonStr(jSONObject.toString(), a.class);
        this.id = aVar.id;
        this.name = aVar.name;
        this.bHi = aVar.bHi;
        this.url = aVar.url;
        this.ios_url = aVar.ios_url;
        this.apk_url = aVar.apk_url;
        this.apk_name = aVar.apk_name;
        this.pos_name = aVar.pos_name;
        this.first_name = aVar.first_name;
        this.second_name = aVar.second_name;
        this.zp = aVar.zp;
        this.abtest = aVar.abtest;
        this.bHj = aVar.bHj;
        this.user_id = aVar.user_id;
        this.verify = aVar.verify;
        this.ext_info = aVar.ext_info;
        this.price = aVar.price;
        this.bHk = aVar.bHk;
        this.bHl = aVar.bHl;
        if (this.bHl != null && this.bHl.length > 0) {
            this.bHm = this.bHl[0];
        } else {
            this.bHm = null;
        }
    }

    public a(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.bHi = 0;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.zp = 0;
            this.price = null;
            this.abtest = null;
            this.bHj = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.bHk = 0;
            this.bHl = null;
            this.bHm = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.bHi = app.url_type.intValue();
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.zp = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.bHj = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.bHk = app.app_time.intValue();
        this.bHl = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.bHm = new b(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean jF() {
        if (this.bHi == 2) {
            return false;
        }
        return jG() || jH();
    }

    public boolean jG() {
        return (this.bHi != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean jH() {
        return this.bHi == 1 && !StringUtils.isNull(this.url);
    }
}

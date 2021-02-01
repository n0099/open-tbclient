package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.OrderList;
/* loaded from: classes9.dex */
public class a {
    private String activityUrl;
    private long createTime;
    private long iCH;
    private long iCI;
    private long iCJ;
    private String iCK;
    private String iCL;
    private String iCM;
    private String orderId;
    private long sceneId;
    private int status;
    private String title;
    private String userName;
    private String userNickName;

    public void a(OrderList orderList) {
        if (orderList != null) {
            this.orderId = orderList.order_id;
            this.sceneId = orderList.scene_id.intValue();
            this.iCH = orderList.scores.longValue();
            this.status = orderList.status.intValue();
            this.createTime = orderList.create_time.longValue();
            this.iCI = orderList.finish_time.longValue();
            this.title = orderList.title;
            this.iCJ = orderList.money.longValue();
            this.iCK = orderList.preg_field;
            this.iCL = orderList.activity_desc;
            this.activityUrl = orderList.activity_url;
            this.iCM = orderList.button_name;
        }
    }

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.orderId = jSONObject.optString("order_id");
            this.sceneId = jSONObject.optLong("scene_id");
            this.iCH = jSONObject.optLong("scores");
            this.status = jSONObject.optInt("status");
            this.createTime = jSONObject.optLong("create_time");
            this.iCI = jSONObject.optLong("finish_time");
            this.title = jSONObject.optString("title");
            this.iCJ = jSONObject.optLong("money");
            this.iCK = jSONObject.optString("preg_field");
            this.userName = jSONObject.optString("user_name");
            this.userNickName = jSONObject.optString("user_nickname");
            this.iCL = jSONObject.optString("activity_desc");
            this.activityUrl = jSONObject.optString("activity_url");
            this.iCM = jSONObject.optString("button_name");
        }
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long ctp() {
        return this.iCH;
    }

    public int getStatus() {
        return this.status;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long ctq() {
        return this.iCI;
    }

    public String getTitle() {
        return this.title;
    }

    public long ctr() {
        return this.iCJ;
    }

    public String cts() {
        return this.iCL;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String ctt() {
        return this.iCM;
    }

    public String ctu() {
        return StringUtils.isNull(this.userNickName) ? this.userName : this.userNickName;
    }
}

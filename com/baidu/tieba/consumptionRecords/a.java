package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.OrderList;
/* loaded from: classes9.dex */
public class a {
    private String activityUrl;
    private long createTime;
    private long iCV;
    private long iCW;
    private long iCX;
    private String iCY;
    private String iCZ;
    private String iDa;
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
            this.iCV = orderList.scores.longValue();
            this.status = orderList.status.intValue();
            this.createTime = orderList.create_time.longValue();
            this.iCW = orderList.finish_time.longValue();
            this.title = orderList.title;
            this.iCX = orderList.money.longValue();
            this.iCY = orderList.preg_field;
            this.iCZ = orderList.activity_desc;
            this.activityUrl = orderList.activity_url;
            this.iDa = orderList.button_name;
        }
    }

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.orderId = jSONObject.optString("order_id");
            this.sceneId = jSONObject.optLong("scene_id");
            this.iCV = jSONObject.optLong("scores");
            this.status = jSONObject.optInt("status");
            this.createTime = jSONObject.optLong("create_time");
            this.iCW = jSONObject.optLong("finish_time");
            this.title = jSONObject.optString("title");
            this.iCX = jSONObject.optLong("money");
            this.iCY = jSONObject.optString("preg_field");
            this.userName = jSONObject.optString("user_name");
            this.userNickName = jSONObject.optString("user_nickname");
            this.iCZ = jSONObject.optString("activity_desc");
            this.activityUrl = jSONObject.optString("activity_url");
            this.iDa = jSONObject.optString("button_name");
        }
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long ctw() {
        return this.iCV;
    }

    public int getStatus() {
        return this.status;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long ctx() {
        return this.iCW;
    }

    public String getTitle() {
        return this.title;
    }

    public long cty() {
        return this.iCX;
    }

    public String ctz() {
        return this.iCZ;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String ctA() {
        return this.iDa;
    }

    public String ctB() {
        return StringUtils.isNull(this.userNickName) ? this.userName : this.userNickName;
    }
}

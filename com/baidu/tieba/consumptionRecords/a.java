package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.OrderList;
/* loaded from: classes8.dex */
public class a {
    private String activityUrl;
    private long createTime;
    private long iwX;
    private long iwY;
    private long iwZ;
    private String ixa;
    private String ixb;
    private String ixc;
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
            this.iwX = orderList.scores.longValue();
            this.status = orderList.status.intValue();
            this.createTime = orderList.create_time.longValue();
            this.iwY = orderList.finish_time.longValue();
            this.title = orderList.title;
            this.iwZ = orderList.money.longValue();
            this.ixa = orderList.preg_field;
            this.ixb = orderList.activity_desc;
            this.activityUrl = orderList.activity_url;
            this.ixc = orderList.button_name;
        }
    }

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.orderId = jSONObject.optString("order_id");
            this.sceneId = jSONObject.optLong("scene_id");
            this.iwX = jSONObject.optLong("scores");
            this.status = jSONObject.optInt("status");
            this.createTime = jSONObject.optLong("create_time");
            this.iwY = jSONObject.optLong("finish_time");
            this.title = jSONObject.optString("title");
            this.iwZ = jSONObject.optLong("money");
            this.ixa = jSONObject.optString("preg_field");
            this.userName = jSONObject.optString("user_name");
            this.userNickName = jSONObject.optString("user_nickname");
            this.ixb = jSONObject.optString("activity_desc");
            this.activityUrl = jSONObject.optString("activity_url");
            this.ixc = jSONObject.optString("button_name");
        }
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long csd() {
        return this.iwX;
    }

    public int getStatus() {
        return this.status;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long cse() {
        return this.iwY;
    }

    public String getTitle() {
        return this.title;
    }

    public long csf() {
        return this.iwZ;
    }

    public String csg() {
        return this.ixb;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String csh() {
        return this.ixc;
    }

    public String csi() {
        return StringUtils.isNull(this.userNickName) ? this.userName : this.userNickName;
    }
}

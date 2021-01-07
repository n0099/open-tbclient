package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.OrderList;
/* loaded from: classes9.dex */
public class a {
    private String activityUrl;
    private long createTime;
    private long iBE;
    private long iBF;
    private long iBG;
    private String iBH;
    private String iBI;
    private String iBJ;
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
            this.iBE = orderList.scores.longValue();
            this.status = orderList.status.intValue();
            this.createTime = orderList.create_time.longValue();
            this.iBF = orderList.finish_time.longValue();
            this.title = orderList.title;
            this.iBG = orderList.money.longValue();
            this.iBH = orderList.preg_field;
            this.iBI = orderList.activity_desc;
            this.activityUrl = orderList.activity_url;
            this.iBJ = orderList.button_name;
        }
    }

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.orderId = jSONObject.optString("order_id");
            this.sceneId = jSONObject.optLong("scene_id");
            this.iBE = jSONObject.optLong("scores");
            this.status = jSONObject.optInt("status");
            this.createTime = jSONObject.optLong("create_time");
            this.iBF = jSONObject.optLong("finish_time");
            this.title = jSONObject.optString("title");
            this.iBG = jSONObject.optLong("money");
            this.iBH = jSONObject.optString("preg_field");
            this.userName = jSONObject.optString("user_name");
            this.userNickName = jSONObject.optString("user_nickname");
            this.iBI = jSONObject.optString("activity_desc");
            this.activityUrl = jSONObject.optString("activity_url");
            this.iBJ = jSONObject.optString("button_name");
        }
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long cvV() {
        return this.iBE;
    }

    public int getStatus() {
        return this.status;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long cvW() {
        return this.iBF;
    }

    public String getTitle() {
        return this.title;
    }

    public long cvX() {
        return this.iBG;
    }

    public String cvY() {
        return this.iBI;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String cvZ() {
        return this.iBJ;
    }

    public String cwa() {
        return StringUtils.isNull(this.userNickName) ? this.userName : this.userNickName;
    }
}

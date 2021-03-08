package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
import tbclient.OrderList;
/* loaded from: classes8.dex */
public class a {
    private String activityUrl;
    private long createTime;
    private long iEE;
    private long iEF;
    private long iEG;
    private String iEH;
    private String iEI;
    private String iEJ;
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
            this.iEE = orderList.scores.longValue();
            this.status = orderList.status.intValue();
            this.createTime = orderList.create_time.longValue();
            this.iEF = orderList.finish_time.longValue();
            this.title = orderList.title;
            this.iEG = orderList.money.longValue();
            this.iEH = orderList.preg_field;
            this.iEI = orderList.activity_desc;
            this.activityUrl = orderList.activity_url;
            this.iEJ = orderList.button_name;
        }
    }

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.orderId = jSONObject.optString("order_id");
            this.sceneId = jSONObject.optLong("scene_id");
            this.iEE = jSONObject.optLong("scores");
            this.status = jSONObject.optInt("status");
            this.createTime = jSONObject.optLong("create_time");
            this.iEF = jSONObject.optLong("finish_time");
            this.title = jSONObject.optString("title");
            this.iEG = jSONObject.optLong("money");
            this.iEH = jSONObject.optString("preg_field");
            this.userName = jSONObject.optString("user_name");
            this.userNickName = jSONObject.optString("user_nickname");
            this.iEI = jSONObject.optString("activity_desc");
            this.activityUrl = jSONObject.optString("activity_url");
            this.iEJ = jSONObject.optString("button_name");
        }
    }

    public String getOrderId() {
        return this.orderId;
    }

    public long ctC() {
        return this.iEE;
    }

    public int getStatus() {
        return this.status;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long ctD() {
        return this.iEF;
    }

    public String getTitle() {
        return this.title;
    }

    public long ctE() {
        return this.iEG;
    }

    public String ctF() {
        return this.iEI;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String ctG() {
        return this.iEJ;
    }

    public String ctH() {
        return StringUtils.isNull(this.userNickName) ? this.userName : this.userNickName;
    }
}

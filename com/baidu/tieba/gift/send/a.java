package com.baidu.tieba.gift.send;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes9.dex */
public class a {
    private int aXz;
    private String goodsName;
    private int jXo;
    private int jXp;
    private long jXq;
    private String jXr;
    private int jXs;
    private String jXt;
    private long jXu;
    private int jXv;
    private int jXw;
    private long jXx;
    private long jXy;
    private String orderId;
    private int payType;
    private long timeStamp;
    private long userId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.timeStamp = dataRes.timestamp.intValue();
            this.goodsName = dataRes.goods_name;
            this.jXo = dataRes.scene_id.intValue();
            this.jXp = dataRes.goods_user_level.intValue();
            this.jXq = dataRes.goods_duration.intValue();
            this.jXr = dataRes.goods_pic;
            this.jXs = dataRes.terminal.intValue();
            this.orderId = dataRes.order_id;
            this.jXt = dataRes.goods_unit;
            this.jXu = dataRes.tdou_num.intValue();
            this.jXv = dataRes.goods_price.intValue();
            this.jXw = dataRes.goods_num.intValue();
            this.payType = dataRes.pay_type.intValue();
            this.userId = dataRes.user_id.longValue();
            this.jXx = dataRes.tb_timestamp.intValue();
            this.jXy = dataRes.open_id.longValue();
            this.aXz = dataRes.gift_count.intValue();
        }
    }

    public PaymentConfirmRequestData cOn() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.jXu);
        paymentConfirmRequestData.setOpen_id(this.jXy);
        paymentConfirmRequestData.setOrder_id(this.orderId);
        paymentConfirmRequestData.setScene_id(this.jXo);
        paymentConfirmRequestData.setGoods_name(this.goodsName);
        paymentConfirmRequestData.setGoods_pic(this.jXr);
        paymentConfirmRequestData.setTerminal("" + this.jXs);
        paymentConfirmRequestData.setGoods_num(this.jXw);
        paymentConfirmRequestData.setGoods_unit(this.jXt);
        paymentConfirmRequestData.setGoods_duration(this.jXq);
        paymentConfirmRequestData.setGoods_user_level(this.jXp);
        paymentConfirmRequestData.setPay_type(this.payType);
        return paymentConfirmRequestData;
    }

    public String getOrderId() {
        return this.orderId;
    }
}

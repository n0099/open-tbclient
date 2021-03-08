package com.baidu.tieba.gift.send;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes8.dex */
public class a {
    private int aYZ;
    private String goodsName;
    private long jZA;
    private int jZq;
    private int jZr;
    private long jZs;
    private String jZt;
    private int jZu;
    private String jZv;
    private long jZw;
    private int jZx;
    private int jZy;
    private long jZz;
    private String orderId;
    private int payType;
    private long timeStamp;
    private long userId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.timeStamp = dataRes.timestamp.intValue();
            this.goodsName = dataRes.goods_name;
            this.jZq = dataRes.scene_id.intValue();
            this.jZr = dataRes.goods_user_level.intValue();
            this.jZs = dataRes.goods_duration.intValue();
            this.jZt = dataRes.goods_pic;
            this.jZu = dataRes.terminal.intValue();
            this.orderId = dataRes.order_id;
            this.jZv = dataRes.goods_unit;
            this.jZw = dataRes.tdou_num.intValue();
            this.jZx = dataRes.goods_price.intValue();
            this.jZy = dataRes.goods_num.intValue();
            this.payType = dataRes.pay_type.intValue();
            this.userId = dataRes.user_id.longValue();
            this.jZz = dataRes.tb_timestamp.intValue();
            this.jZA = dataRes.open_id.longValue();
            this.aYZ = dataRes.gift_count.intValue();
        }
    }

    public PaymentConfirmRequestData cOu() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.jZw);
        paymentConfirmRequestData.setOpen_id(this.jZA);
        paymentConfirmRequestData.setOrder_id(this.orderId);
        paymentConfirmRequestData.setScene_id(this.jZq);
        paymentConfirmRequestData.setGoods_name(this.goodsName);
        paymentConfirmRequestData.setGoods_pic(this.jZt);
        paymentConfirmRequestData.setTerminal("" + this.jZu);
        paymentConfirmRequestData.setGoods_num(this.jZy);
        paymentConfirmRequestData.setGoods_unit(this.jZv);
        paymentConfirmRequestData.setGoods_duration(this.jZs);
        paymentConfirmRequestData.setGoods_user_level(this.jZr);
        paymentConfirmRequestData.setPay_type(this.payType);
        return paymentConfirmRequestData;
    }

    public String getOrderId() {
        return this.orderId;
    }
}

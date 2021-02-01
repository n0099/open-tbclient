package com.baidu.tieba.gift.send;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes9.dex */
public class a {
    private int aXz;
    private String goodsName;
    private int jXa;
    private int jXb;
    private long jXc;
    private String jXd;
    private int jXe;
    private String jXf;
    private long jXg;
    private int jXh;
    private int jXi;
    private long jXj;
    private long jXk;
    private String orderId;
    private int payType;
    private long timeStamp;
    private long userId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.timeStamp = dataRes.timestamp.intValue();
            this.goodsName = dataRes.goods_name;
            this.jXa = dataRes.scene_id.intValue();
            this.jXb = dataRes.goods_user_level.intValue();
            this.jXc = dataRes.goods_duration.intValue();
            this.jXd = dataRes.goods_pic;
            this.jXe = dataRes.terminal.intValue();
            this.orderId = dataRes.order_id;
            this.jXf = dataRes.goods_unit;
            this.jXg = dataRes.tdou_num.intValue();
            this.jXh = dataRes.goods_price.intValue();
            this.jXi = dataRes.goods_num.intValue();
            this.payType = dataRes.pay_type.intValue();
            this.userId = dataRes.user_id.longValue();
            this.jXj = dataRes.tb_timestamp.intValue();
            this.jXk = dataRes.open_id.longValue();
            this.aXz = dataRes.gift_count.intValue();
        }
    }

    public PaymentConfirmRequestData cOg() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.jXg);
        paymentConfirmRequestData.setOpen_id(this.jXk);
        paymentConfirmRequestData.setOrder_id(this.orderId);
        paymentConfirmRequestData.setScene_id(this.jXa);
        paymentConfirmRequestData.setGoods_name(this.goodsName);
        paymentConfirmRequestData.setGoods_pic(this.jXd);
        paymentConfirmRequestData.setTerminal("" + this.jXe);
        paymentConfirmRequestData.setGoods_num(this.jXi);
        paymentConfirmRequestData.setGoods_unit(this.jXf);
        paymentConfirmRequestData.setGoods_duration(this.jXc);
        paymentConfirmRequestData.setGoods_user_level(this.jXb);
        paymentConfirmRequestData.setPay_type(this.payType);
        return paymentConfirmRequestData;
    }

    public String getOrderId() {
        return this.orderId;
    }
}

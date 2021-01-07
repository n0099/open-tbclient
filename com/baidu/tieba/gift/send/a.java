package com.baidu.tieba.gift.send;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes9.dex */
public class a {
    private int aZh;
    private String goodsName;
    private int jUd;
    private int jUe;
    private long jUf;
    private String jUg;
    private int jUh;
    private String jUi;
    private long jUj;
    private int jUk;
    private int jUl;
    private long jUm;
    private long jUn;
    private String orderId;
    private int payType;
    private long timeStamp;
    private long userId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.timeStamp = dataRes.timestamp.intValue();
            this.goodsName = dataRes.goods_name;
            this.jUd = dataRes.scene_id.intValue();
            this.jUe = dataRes.goods_user_level.intValue();
            this.jUf = dataRes.goods_duration.intValue();
            this.jUg = dataRes.goods_pic;
            this.jUh = dataRes.terminal.intValue();
            this.orderId = dataRes.order_id;
            this.jUi = dataRes.goods_unit;
            this.jUj = dataRes.tdou_num.intValue();
            this.jUk = dataRes.goods_price.intValue();
            this.jUl = dataRes.goods_num.intValue();
            this.payType = dataRes.pay_type.intValue();
            this.userId = dataRes.user_id.longValue();
            this.jUm = dataRes.tb_timestamp.intValue();
            this.jUn = dataRes.open_id.longValue();
            this.aZh = dataRes.gift_count.intValue();
        }
    }

    public PaymentConfirmRequestData cQb() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.jUj);
        paymentConfirmRequestData.setOpen_id(this.jUn);
        paymentConfirmRequestData.setOrder_id(this.orderId);
        paymentConfirmRequestData.setScene_id(this.jUd);
        paymentConfirmRequestData.setGoods_name(this.goodsName);
        paymentConfirmRequestData.setGoods_pic(this.jUg);
        paymentConfirmRequestData.setTerminal("" + this.jUh);
        paymentConfirmRequestData.setGoods_num(this.jUl);
        paymentConfirmRequestData.setGoods_unit(this.jUi);
        paymentConfirmRequestData.setGoods_duration(this.jUf);
        paymentConfirmRequestData.setGoods_user_level(this.jUe);
        paymentConfirmRequestData.setPay_type(this.payType);
        return paymentConfirmRequestData;
    }

    public String getOrderId() {
        return this.orderId;
    }
}

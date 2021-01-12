package com.baidu.tieba.gift.send;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes8.dex */
public class a {
    private int aUu;
    private String goodsName;
    private long jPA;
    private String jPB;
    private int jPC;
    private String jPD;
    private long jPE;
    private int jPF;
    private int jPG;
    private long jPH;
    private long jPI;
    private int jPy;
    private int jPz;
    private String orderId;
    private int payType;
    private long timeStamp;
    private long userId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.timeStamp = dataRes.timestamp.intValue();
            this.goodsName = dataRes.goods_name;
            this.jPy = dataRes.scene_id.intValue();
            this.jPz = dataRes.goods_user_level.intValue();
            this.jPA = dataRes.goods_duration.intValue();
            this.jPB = dataRes.goods_pic;
            this.jPC = dataRes.terminal.intValue();
            this.orderId = dataRes.order_id;
            this.jPD = dataRes.goods_unit;
            this.jPE = dataRes.tdou_num.intValue();
            this.jPF = dataRes.goods_price.intValue();
            this.jPG = dataRes.goods_num.intValue();
            this.payType = dataRes.pay_type.intValue();
            this.userId = dataRes.user_id.longValue();
            this.jPH = dataRes.tb_timestamp.intValue();
            this.jPI = dataRes.open_id.longValue();
            this.aUu = dataRes.gift_count.intValue();
        }
    }

    public PaymentConfirmRequestData cMj() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.jPE);
        paymentConfirmRequestData.setOpen_id(this.jPI);
        paymentConfirmRequestData.setOrder_id(this.orderId);
        paymentConfirmRequestData.setScene_id(this.jPy);
        paymentConfirmRequestData.setGoods_name(this.goodsName);
        paymentConfirmRequestData.setGoods_pic(this.jPB);
        paymentConfirmRequestData.setTerminal("" + this.jPC);
        paymentConfirmRequestData.setGoods_num(this.jPG);
        paymentConfirmRequestData.setGoods_unit(this.jPD);
        paymentConfirmRequestData.setGoods_duration(this.jPA);
        paymentConfirmRequestData.setGoods_user_level(this.jPz);
        paymentConfirmRequestData.setPay_type(this.payType);
        return paymentConfirmRequestData;
    }

    public String getOrderId() {
        return this.orderId;
    }
}

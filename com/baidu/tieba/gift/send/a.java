package com.baidu.tieba.gift.send;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes.dex */
public class a {
    private int Vu;
    private String bxe;
    private int bxf;
    private int bxg;
    private long bxh;
    private String bxi;
    private int bxj;
    private String bxk;
    private long bxl;
    private int bxm;
    private int bxn;
    private long bxo;
    private long openId;
    private String orderId;
    private int payType;
    private long timeStamp;
    private long userId;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.timeStamp = dataRes.timestamp.intValue();
            this.bxe = dataRes.goods_name;
            this.bxf = dataRes.scene_id.intValue();
            this.bxg = dataRes.goods_user_level.intValue();
            this.bxh = dataRes.goods_duration.intValue();
            this.bxi = dataRes.goods_pic;
            this.bxj = dataRes.terminal.intValue();
            this.orderId = dataRes.order_id;
            this.bxk = dataRes.goods_unit;
            this.bxl = dataRes.tdou_num.intValue();
            this.bxm = dataRes.goods_price.intValue();
            this.bxn = dataRes.goods_num.intValue();
            this.payType = dataRes.pay_type.intValue();
            this.userId = dataRes.user_id.longValue();
            this.bxo = dataRes.tb_timestamp.intValue();
            this.openId = dataRes.open_id.longValue();
            this.Vu = dataRes.gift_count.intValue();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0029: IGET  (r2v0 int A[REMOVE]) = (r3v0 'this' com.baidu.tieba.gift.send.a A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.gift.send.a.bxj int)] */
    public PaymentConfirmRequestData Ty() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.bxl);
        paymentConfirmRequestData.setOpen_id(this.openId);
        paymentConfirmRequestData.setOrder_id(this.orderId);
        paymentConfirmRequestData.setScene_id(this.bxf);
        paymentConfirmRequestData.setGoods_name(this.bxe);
        paymentConfirmRequestData.setGoods_pic(this.bxi);
        paymentConfirmRequestData.setTerminal(new StringBuilder().append(this.bxj).toString());
        paymentConfirmRequestData.setGoods_num(this.bxn);
        paymentConfirmRequestData.setGoods_unit(this.bxk);
        paymentConfirmRequestData.setGoods_duration(this.bxh);
        paymentConfirmRequestData.setGoods_user_level(this.bxg);
        paymentConfirmRequestData.setPay_type(this.payType);
        return paymentConfirmRequestData;
    }

    public String getOrderId() {
        return this.orderId;
    }
}

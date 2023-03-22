package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class ib7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public long d;
    public String e;
    public int f;
    public String g;
    public String h;
    public long i;
    public int j;
    public int k;
    public long l;
    public int m;

    public ib7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public PaymentConfirmRequestData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
            paymentConfirmRequestData.setTdou_num(this.i);
            paymentConfirmRequestData.setOpen_id(this.l);
            paymentConfirmRequestData.setOrder_id(this.g);
            paymentConfirmRequestData.setScene_id(this.b);
            paymentConfirmRequestData.setGoods_name(this.a);
            paymentConfirmRequestData.setGoods_pic(this.e);
            paymentConfirmRequestData.setTerminal("" + this.f);
            paymentConfirmRequestData.setGoods_num((long) this.j);
            paymentConfirmRequestData.setGoods_unit(this.h);
            paymentConfirmRequestData.setGoods_duration(this.d);
            paymentConfirmRequestData.setGoods_user_level(this.c);
            paymentConfirmRequestData.setPay_type(this.k);
            paymentConfirmRequestData.setCurrency(this.m);
            return paymentConfirmRequestData;
        }
        return (PaymentConfirmRequestData) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) != null) || dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.a = dataRes.goods_name;
        this.b = dataRes.scene_id.intValue();
        this.c = dataRes.goods_user_level.intValue();
        this.d = dataRes.goods_duration.intValue();
        this.e = dataRes.goods_pic;
        this.f = dataRes.terminal.intValue();
        this.g = dataRes.order_id;
        this.h = dataRes.goods_unit;
        this.i = dataRes.tdou_num.intValue();
        dataRes.goods_price.intValue();
        this.j = dataRes.goods_num.intValue();
        this.k = dataRes.pay_type.intValue();
        dataRes.user_id.longValue();
        dataRes.tb_timestamp.intValue();
        this.l = dataRes.open_id.longValue();
        dataRes.gift_count.intValue();
        this.m = dataRes.currency.intValue();
    }
}

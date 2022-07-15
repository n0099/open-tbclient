package com.baidu.tieba.gift.giftTab;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xo4;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetGiftListByCategoryId.DataRes;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdResIdl;
import tbclient.GetGiftListByCategoryId.PresentGiftListByCategoryId1;
/* loaded from: classes3.dex */
public class CategoryGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int categoryId;
    public ArrayList<xo4> giftList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryGiftListHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getCategoryId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.categoryId : invokeV.intValue;
    }

    public ArrayList<xo4> getGiftList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.giftList : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetGiftListByCategoryIdResIdl getGiftListByCategoryIdResIdl;
        List<PresentGiftListByCategoryId1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getGiftListByCategoryIdResIdl = (GetGiftListByCategoryIdResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListByCategoryIdResIdl.class)) == null) {
            return;
        }
        Error error = getGiftListByCategoryIdResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getGiftListByCategoryIdResIdl.error.usermsg);
        }
        DataRes dataRes = getGiftListByCategoryIdResIdl.data;
        if (dataRes != null && (list = dataRes.gift_list) != null && list.size() > 0) {
            this.giftList = new ArrayList<>();
            for (PresentGiftListByCategoryId1 presentGiftListByCategoryId1 : getGiftListByCategoryIdResIdl.data.gift_list) {
                if (presentGiftListByCategoryId1 != null) {
                    xo4 xo4Var = new xo4();
                    xo4Var.a = presentGiftListByCategoryId1.gift_id.intValue();
                    xo4Var.b = presentGiftListByCategoryId1.gift_name;
                    xo4Var.c = presentGiftListByCategoryId1.price.intValue();
                    xo4Var.d = presentGiftListByCategoryId1.thumbnail_url;
                    presentGiftListByCategoryId1.ios_price.intValue();
                    xo4Var.e = presentGiftListByCategoryId1.gift_desc;
                    xo4Var.f = presentGiftListByCategoryId1.activity_type.intValue();
                    xo4Var.g = presentGiftListByCategoryId1.mark_url;
                    xo4Var.h = presentGiftListByCategoryId1.begin_time.intValue();
                    xo4Var.i = presentGiftListByCategoryId1.end_time.intValue();
                    xo4Var.j = presentGiftListByCategoryId1.discount.intValue();
                    presentGiftListByCategoryId1.ios_discount.intValue();
                    presentGiftListByCategoryId1.proportion.intValue();
                    presentGiftListByCategoryId1.pitch_on.intValue();
                    xo4Var.k = presentGiftListByCategoryId1.gift_count.intValue();
                    xo4Var.q = presentGiftListByCategoryId1.currency_unit.intValue();
                    xo4Var.s = presentGiftListByCategoryId1.currency.intValue();
                    this.giftList.add(xo4Var);
                }
            }
        }
        if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof CategoryGiftListRequest)) {
            return;
        }
        this.categoryId = ((CategoryGiftListRequest) getOrginalMessage().getExtra()).getCategoryId();
    }
}

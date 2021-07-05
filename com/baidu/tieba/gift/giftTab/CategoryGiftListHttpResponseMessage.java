package com.baidu.tieba.gift.giftTab;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.r0.r.q.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetGiftListByCategoryId.DataRes;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdResIdl;
import tbclient.GetGiftListByCategoryId.PresentGiftListByCategoryId1;
/* loaded from: classes5.dex */
public class CategoryGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int categoryId;
    public ArrayList<j0> giftList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryGiftListHttpResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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

    public ArrayList<j0> getGiftList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.giftList : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetGiftListByCategoryIdResIdl getGiftListByCategoryIdResIdl;
        List<PresentGiftListByCategoryId1> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getGiftListByCategoryIdResIdl = (GetGiftListByCategoryIdResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListByCategoryIdResIdl.class)) == null) {
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
                    j0 j0Var = new j0();
                    j0Var.f55981a = presentGiftListByCategoryId1.gift_id.intValue();
                    j0Var.f55982b = presentGiftListByCategoryId1.gift_name;
                    j0Var.f55983c = presentGiftListByCategoryId1.price.intValue();
                    j0Var.f55984d = presentGiftListByCategoryId1.thumbnail_url;
                    presentGiftListByCategoryId1.ios_price.intValue();
                    j0Var.f55985e = presentGiftListByCategoryId1.gift_desc;
                    j0Var.f55986f = presentGiftListByCategoryId1.activity_type.intValue();
                    j0Var.f55987g = presentGiftListByCategoryId1.mark_url;
                    j0Var.f55988h = presentGiftListByCategoryId1.begin_time.intValue();
                    j0Var.f55989i = presentGiftListByCategoryId1.end_time.intValue();
                    j0Var.j = presentGiftListByCategoryId1.discount.intValue();
                    presentGiftListByCategoryId1.ios_discount.intValue();
                    presentGiftListByCategoryId1.proportion.intValue();
                    presentGiftListByCategoryId1.pitch_on.intValue();
                    j0Var.k = presentGiftListByCategoryId1.gift_count.intValue();
                    j0Var.q = presentGiftListByCategoryId1.currency_unit.intValue();
                    j0Var.s = presentGiftListByCategoryId1.currency.intValue();
                    this.giftList.add(j0Var);
                }
            }
        }
        if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof CategoryGiftListRequest)) {
            return;
        }
        this.categoryId = ((CategoryGiftListRequest) getOrginalMessage().getExtra()).getCategoryId();
    }
}

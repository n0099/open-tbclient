package com.baidu.tieba.gift.giftTab;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.az7;
import com.baidu.tieba.f35;
import com.baidu.tieba.g35;
import com.baidu.tieba.wy7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetGiftList.DataRes;
import tbclient.GetGiftList.GetGiftListResIdl;
import tbclient.GetGiftList.PresentCategoryList;
import tbclient.GetGiftList.PresentGiftList1;
import tbclient.GetGiftList.PresentNumInfo;
import tbclient.GetGiftList.UrlTitle;
/* loaded from: classes6.dex */
public class DefaultGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String addFreeUrl;
    public ArrayList<wy7> categoryList;
    public int currencyType;
    public int freeChance;
    public ArrayList<f35> giftList;
    public ArrayList<az7> numberList;
    public long sceneId;
    public g35 urlTitleData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultGiftListHttpResponseMessage(int i) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetGiftListResIdl getGiftListResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (getGiftListResIdl = (GetGiftListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListResIdl.class)) == null) {
            return;
        }
        Error error = getGiftListResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getGiftListResIdl.error.usermsg);
        }
        DataRes dataRes = getGiftListResIdl.data;
        if (dataRes != null) {
            this.addFreeUrl = dataRes.addfree_url;
            this.freeChance = dataRes.free_chance.intValue();
            this.sceneId = getGiftListResIdl.data.scene_id.intValue();
            this.currencyType = getGiftListResIdl.data.currency_type.intValue();
            g35 g35Var = new g35();
            this.urlTitleData = g35Var;
            DataRes dataRes2 = getGiftListResIdl.data;
            UrlTitle urlTitle = dataRes2.currency_txt;
            g35Var.a = urlTitle.name;
            g35Var.b = urlTitle.url;
            List<PresentGiftList1> list = dataRes2.gift_list;
            if (list != null && list.size() > 0) {
                this.giftList = new ArrayList<>();
                for (PresentGiftList1 presentGiftList1 : getGiftListResIdl.data.gift_list) {
                    if (presentGiftList1 != null) {
                        f35 f35Var = new f35();
                        f35Var.a = presentGiftList1.gift_id.intValue();
                        f35Var.b = presentGiftList1.gift_name;
                        f35Var.c = presentGiftList1.price.intValue();
                        f35Var.d = presentGiftList1.thumbnail_url;
                        presentGiftList1.ios_price.intValue();
                        f35Var.e = presentGiftList1.gift_desc;
                        f35Var.f = presentGiftList1.activity_type.intValue();
                        f35Var.g = presentGiftList1.mark_url;
                        f35Var.h = presentGiftList1.begin_time.intValue();
                        f35Var.i = presentGiftList1.end_time.intValue();
                        f35Var.j = presentGiftList1.discount.intValue();
                        presentGiftList1.ios_discount.intValue();
                        presentGiftList1.proportion.intValue();
                        presentGiftList1.pitch_on.intValue();
                        f35Var.k = presentGiftList1.gift_count.intValue();
                        f35Var.q = presentGiftList1.currency_unit.intValue();
                        f35Var.s = presentGiftList1.currency.intValue();
                        this.giftList.add(f35Var);
                    }
                }
            }
            List<PresentCategoryList> list2 = getGiftListResIdl.data.list;
            if (list2 != null && list2.size() > 0) {
                this.categoryList = new ArrayList<>();
                for (PresentCategoryList presentCategoryList : getGiftListResIdl.data.list) {
                    if (presentCategoryList != null) {
                        wy7 wy7Var = new wy7();
                        wy7Var.d(presentCategoryList);
                        this.categoryList.add(wy7Var);
                    }
                }
            }
            List<PresentNumInfo> list3 = getGiftListResIdl.data.num_info;
            if (list3 != null && list3.size() > 0) {
                this.numberList = new ArrayList<>();
                for (PresentNumInfo presentNumInfo : getGiftListResIdl.data.num_info) {
                    if (presentNumInfo != null) {
                        az7 az7Var = new az7();
                        az7Var.c(presentNumInfo);
                        this.numberList.add(az7Var);
                    }
                }
            }
        }
    }

    public String getAddFreeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.addFreeUrl;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<wy7> getCategoryList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.categoryList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getFreeChance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.freeChance;
        }
        return invokeV.intValue;
    }

    public ArrayList<f35> getGiftList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.giftList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<az7> getGiftNumberList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.numberList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public long getSceneId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.sceneId;
        }
        return invokeV.longValue;
    }

    public void setSceneId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.sceneId = j;
        }
    }
}

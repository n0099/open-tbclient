package com.baidu.tieba.gift.giftTab;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as6;
import com.repackage.jp4;
import com.repackage.kp4;
import com.repackage.wr6;
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
/* loaded from: classes3.dex */
public class DefaultGiftListSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String addFreeUrl;
    public ArrayList<wr6> categoryList;
    public int currencyType;
    public int freeChance;
    public ArrayList<jp4> giftList;
    public ArrayList<as6> numberList;
    public long sceneId;
    public kp4 urlTitleData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultGiftListSocketResponseMessage() {
        super(309054);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public String getAddFreeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.addFreeUrl : (String) invokeV.objValue;
    }

    public ArrayList<wr6> getCategoryList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.categoryList : (ArrayList) invokeV.objValue;
    }

    public int getFreeChance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.freeChance : invokeV.intValue;
    }

    public ArrayList<jp4> getGiftList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.giftList : (ArrayList) invokeV.objValue;
    }

    public ArrayList<as6> getGiftNumberList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.numberList : (ArrayList) invokeV.objValue;
    }

    public long getSceneId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.sceneId : invokeV.longValue;
    }

    public void setSceneId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.sceneId = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetGiftListResIdl getGiftListResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getGiftListResIdl = (GetGiftListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListResIdl.class)) == null) {
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
            kp4 kp4Var = new kp4();
            this.urlTitleData = kp4Var;
            DataRes dataRes2 = getGiftListResIdl.data;
            UrlTitle urlTitle = dataRes2.currency_txt;
            kp4Var.a = urlTitle.name;
            kp4Var.b = urlTitle.url;
            List<PresentGiftList1> list = dataRes2.gift_list;
            if (list != null && list.size() > 0) {
                this.giftList = new ArrayList<>();
                for (PresentGiftList1 presentGiftList1 : getGiftListResIdl.data.gift_list) {
                    if (presentGiftList1 != null) {
                        jp4 jp4Var = new jp4();
                        jp4Var.a = presentGiftList1.gift_id.intValue();
                        jp4Var.b = presentGiftList1.gift_name;
                        jp4Var.c = presentGiftList1.price.intValue();
                        jp4Var.d = presentGiftList1.thumbnail_url;
                        presentGiftList1.ios_price.intValue();
                        jp4Var.e = presentGiftList1.gift_desc;
                        jp4Var.f = presentGiftList1.activity_type.intValue();
                        jp4Var.g = presentGiftList1.mark_url;
                        jp4Var.h = presentGiftList1.begin_time.intValue();
                        jp4Var.i = presentGiftList1.end_time.intValue();
                        jp4Var.j = presentGiftList1.discount.intValue();
                        presentGiftList1.ios_discount.intValue();
                        presentGiftList1.proportion.intValue();
                        presentGiftList1.pitch_on.intValue();
                        jp4Var.k = presentGiftList1.gift_count.intValue();
                        jp4Var.q = presentGiftList1.currency_unit.intValue();
                        jp4Var.s = presentGiftList1.currency.intValue();
                        this.giftList.add(jp4Var);
                    }
                }
            }
            List<PresentCategoryList> list2 = getGiftListResIdl.data.list;
            if (list2 != null && list2.size() > 0) {
                this.categoryList = new ArrayList<>();
                for (PresentCategoryList presentCategoryList : getGiftListResIdl.data.list) {
                    if (presentCategoryList != null) {
                        wr6 wr6Var = new wr6();
                        wr6Var.d(presentCategoryList);
                        this.categoryList.add(wr6Var);
                    }
                }
            }
            List<PresentNumInfo> list3 = getGiftListResIdl.data.num_info;
            if (list3 == null || list3.size() <= 0) {
                return;
            }
            this.numberList = new ArrayList<>();
            for (PresentNumInfo presentNumInfo : getGiftListResIdl.data.num_info) {
                if (presentNumInfo != null) {
                    as6 as6Var = new as6();
                    as6Var.c(presentNumInfo);
                    this.numberList.add(as6Var);
                }
            }
        }
    }
}

package com.baidu.tieba.gift.giftTab;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a77;
import com.baidu.tieba.cy4;
import com.baidu.tieba.dy4;
import com.baidu.tieba.w67;
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
/* loaded from: classes4.dex */
public class DefaultGiftListSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String addFreeUrl;
    public ArrayList<w67> categoryList;
    public int currencyType;
    public int freeChance;
    public ArrayList<cy4> giftList;
    public ArrayList<a77> numberList;
    public long sceneId;
    public dy4 urlTitleData;

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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.addFreeUrl;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<w67> getCategoryList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.categoryList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getFreeChance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.freeChance;
        }
        return invokeV.intValue;
    }

    public ArrayList<cy4> getGiftList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.giftList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<a77> getGiftNumberList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.numberList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public long getSceneId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.sceneId;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetGiftListResIdl getGiftListResIdl = (GetGiftListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListResIdl.class);
            if (getGiftListResIdl == null) {
                return null;
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
                dy4 dy4Var = new dy4();
                this.urlTitleData = dy4Var;
                DataRes dataRes2 = getGiftListResIdl.data;
                UrlTitle urlTitle = dataRes2.currency_txt;
                dy4Var.a = urlTitle.name;
                dy4Var.b = urlTitle.url;
                List<PresentGiftList1> list = dataRes2.gift_list;
                if (list != null && list.size() > 0) {
                    this.giftList = new ArrayList<>();
                    for (PresentGiftList1 presentGiftList1 : getGiftListResIdl.data.gift_list) {
                        if (presentGiftList1 != null) {
                            cy4 cy4Var = new cy4();
                            cy4Var.a = presentGiftList1.gift_id.intValue();
                            cy4Var.b = presentGiftList1.gift_name;
                            cy4Var.c = presentGiftList1.price.intValue();
                            cy4Var.d = presentGiftList1.thumbnail_url;
                            presentGiftList1.ios_price.intValue();
                            cy4Var.e = presentGiftList1.gift_desc;
                            cy4Var.f = presentGiftList1.activity_type.intValue();
                            cy4Var.g = presentGiftList1.mark_url;
                            cy4Var.h = presentGiftList1.begin_time.intValue();
                            cy4Var.i = presentGiftList1.end_time.intValue();
                            cy4Var.j = presentGiftList1.discount.intValue();
                            presentGiftList1.ios_discount.intValue();
                            presentGiftList1.proportion.intValue();
                            presentGiftList1.pitch_on.intValue();
                            cy4Var.k = presentGiftList1.gift_count.intValue();
                            cy4Var.q = presentGiftList1.currency_unit.intValue();
                            cy4Var.s = presentGiftList1.currency.intValue();
                            this.giftList.add(cy4Var);
                        }
                    }
                }
                List<PresentCategoryList> list2 = getGiftListResIdl.data.list;
                if (list2 != null && list2.size() > 0) {
                    this.categoryList = new ArrayList<>();
                    for (PresentCategoryList presentCategoryList : getGiftListResIdl.data.list) {
                        if (presentCategoryList != null) {
                            w67 w67Var = new w67();
                            w67Var.d(presentCategoryList);
                            this.categoryList.add(w67Var);
                        }
                    }
                }
                List<PresentNumInfo> list3 = getGiftListResIdl.data.num_info;
                if (list3 != null && list3.size() > 0) {
                    this.numberList = new ArrayList<>();
                    for (PresentNumInfo presentNumInfo : getGiftListResIdl.data.num_info) {
                        if (presentNumInfo != null) {
                            a77 a77Var = new a77();
                            a77Var.c(presentNumInfo);
                            this.numberList.add(a77Var);
                        }
                    }
                }
            }
            return getGiftListResIdl;
        }
        return invokeIL.objValue;
    }

    public void setSceneId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.sceneId = j;
        }
    }
}

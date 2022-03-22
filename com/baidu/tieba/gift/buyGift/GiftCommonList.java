package com.baidu.tieba.gift.buyGift;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetGiftCommonList.DataRes;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
import tbclient.GetGiftCommonList.GiftList;
import tbclient.GetGiftCommonList.Item;
@Deprecated
/* loaded from: classes5.dex */
public class GiftCommonList implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1719387618953489739L;
    public transient /* synthetic */ FieldHolder $fh;
    public String errmsg;
    public int errorno;
    public GiftInfo gift_info;
    public String usermsg;

    /* loaded from: classes5.dex */
    public static class GiftInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4908690864725277352L;
        public transient /* synthetic */ FieldHolder $fh;
        public List<TypeInfo> list;
        public List<NumInfo> num_info;
        public int version;

        public GiftInfo() {
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

        public List<NumInfo> getNumInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.num_info == null) {
                    this.num_info = new ArrayList();
                }
                return this.num_info;
            }
            return (List) invokeV.objValue;
        }

        public List<TypeInfo> getTypeInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.list == null) {
                    this.list = new ArrayList();
                }
                return this.list;
            }
            return (List) invokeV.objValue;
        }

        public int getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.version : invokeV.intValue;
        }

        public void setNumInfo(List<NumInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.num_info = list;
            }
        }

        public void setTypeInfo(List<TypeInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
                this.list = list;
            }
        }

        public void setVersion(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.version = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class GiftItem implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -628875343878681499L;
        public transient /* synthetic */ FieldHolder $fh;
        public int gift_id;
        public String name;
        public String play_url;
        public int price;
        public String thumbnail_url;

        public GiftItem() {
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

        public int getGiftId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.gift_id : invokeV.intValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.play_url : (String) invokeV.objValue;
        }

        public int getPrice() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.price : invokeV.intValue;
        }

        public String getThumbnailUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.thumbnail_url : (String) invokeV.objValue;
        }

        public void setGiftId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.gift_id = i;
            }
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.name = str;
            }
        }

        public void setPlayUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.play_url = str;
            }
        }

        public void setPrice(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.price = i;
            }
        }

        public void setThumbnailUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.thumbnail_url = str;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class NumInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6308284942592196517L;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;
        public int num;

        public NumInfo() {
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

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public int getNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.num : invokeV.intValue;
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.name = str;
            }
        }

        public void setNum(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.num = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class TypeInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8689340701873734582L;
        public transient /* synthetic */ FieldHolder $fh;
        public List<GiftItem> item;
        public int type_id;
        public String type_name;

        public TypeInfo() {
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

        public List<GiftItem> getGiftItems() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.item == null) {
                    this.item = new ArrayList();
                }
                return this.item;
            }
            return (List) invokeV.objValue;
        }

        public int getTypeId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type_id : invokeV.intValue;
        }

        public String getTypeName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.type_name : (String) invokeV.objValue;
        }

        public void setGiftItems(List<GiftItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.item = list;
            }
        }

        public void setTypeId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.type_id = i;
            }
        }

        public void setTypeName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.type_name = str;
            }
        }
    }

    public GiftCommonList() {
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

    public String getErrMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.errmsg : (String) invokeV.objValue;
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.errorno : invokeV.intValue;
    }

    public GiftInfo getGiftInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.gift_info : (GiftInfo) invokeV.objValue;
    }

    public String getUserMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.usermsg : (String) invokeV.objValue;
    }

    public void parseProto(GetGiftCommonListResIdl getGiftCommonListResIdl) {
        DataRes dataRes;
        tbclient.GetGiftCommonList.GiftInfo giftInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, getGiftCommonListResIdl) == null) || getGiftCommonListResIdl == null) {
            return;
        }
        Error error = getGiftCommonListResIdl.error;
        if (error != null) {
            this.errmsg = error.errmsg;
            this.errorno = error.errorno.intValue();
            this.usermsg = getGiftCommonListResIdl.error.usermsg;
        }
        if (this.errorno != 0 || (dataRes = getGiftCommonListResIdl.data) == null || (giftInfo = dataRes.gift_info) == null) {
            return;
        }
        this.gift_info = new GiftInfo();
        List<GiftList> list = giftInfo.list;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (GiftList giftList : list) {
                TypeInfo typeInfo = new TypeInfo();
                typeInfo.setTypeId(giftList.type_id.intValue());
                typeInfo.setTypeName(giftList.type_name);
                if (giftList.item != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Item item : giftList.item) {
                        GiftItem giftItem = new GiftItem();
                        giftItem.setName(item.name);
                        giftItem.setPrice(item.price.intValue());
                        giftItem.setGiftId(item.gift_id.intValue());
                        giftItem.setPlayUrl(item.play_url);
                        giftItem.setThumbnailUrl(item.thumbnail_url);
                        arrayList2.add(giftItem);
                    }
                    typeInfo.setGiftItems(arrayList2);
                }
                arrayList.add(typeInfo);
            }
            this.gift_info.setTypeInfo(arrayList);
        }
        List<tbclient.GetGiftCommonList.NumInfo> list2 = giftInfo.num_info;
        if (list2 != null) {
            ArrayList arrayList3 = new ArrayList();
            for (tbclient.GetGiftCommonList.NumInfo numInfo : list2) {
                NumInfo numInfo2 = new NumInfo();
                numInfo2.setName(numInfo.name);
                numInfo2.setNum(numInfo.num.intValue());
                arrayList3.add(numInfo2);
            }
            this.gift_info.setNumInfo(arrayList3);
        }
    }

    public void setErrMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.errmsg = str;
        }
    }

    public void setErrorNo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.errorno = i;
        }
    }

    public void setGiftInfo(GiftInfo giftInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, giftInfo) == null) {
            this.gift_info = giftInfo;
        }
    }

    public void setUserMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.usermsg = str;
        }
    }
}

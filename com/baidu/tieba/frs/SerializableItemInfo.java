package com.baidu.tieba.frs;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes4.dex */
public class SerializableItemInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALL = "all";
    public transient /* synthetic */ FieldHolder $fh;
    public double averageScore;
    public String brief;
    public double icon_size;
    public String icon_url;
    public Integer id;
    public int isSchool;
    public String name;
    public SerializableItemTableInfo score;
    public List<String> tags;

    public SerializableItemInfo() {
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

    public double getAverageScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.averageScore : invokeV.doubleValue;
    }

    public String getBrief() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.brief : (String) invokeV.objValue;
    }

    public double getIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.icon_size : invokeV.doubleValue;
    }

    public String getIcon_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.icon_url : (String) invokeV.objValue;
    }

    public Integer getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.id : (Integer) invokeV.objValue;
    }

    public int getIsSchool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isSchool : invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public SerializableItemTableInfo getScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.score : (SerializableItemTableInfo) invokeV.objValue;
    }

    public List<String> getTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.tags : (List) invokeV.objValue;
    }

    public void setAverageScore(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d)}) == null) {
            this.averageScore = d;
        }
    }

    public void setBrief(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.brief = str;
        }
    }

    public void setIconSize(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d)}) == null) {
            this.icon_size = d;
        }
    }

    public void setIcon_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.icon_url = str;
        }
    }

    public void setId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, num) == null) {
            this.id = num;
        }
    }

    public void setIsSchool(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.isSchool = i;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.name = str;
        }
    }

    public void setScore(SerializableItemTableInfo serializableItemTableInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, serializableItemTableInfo) == null) {
            this.score = serializableItemTableInfo;
        }
    }

    public void setTags(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.tags = list;
        }
    }

    public SerializableItemInfo(ItemInfo itemInfo) {
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {itemInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (itemInfo == null) {
            return;
        }
        this.id = itemInfo.id;
        this.name = itemInfo.name;
        this.icon_url = itemInfo.icon_url;
        this.brief = itemInfo.brief;
        this.tags = itemInfo.tags;
        this.icon_size = itemInfo.icon_size.doubleValue();
        this.score = new SerializableItemTableInfo(itemInfo.score);
        this.isSchool = itemInfo.is_school.intValue();
        ItemTable itemTable = itemInfo.score;
        if (itemTable == null || (list = itemTable.item_point) == null) {
            return;
        }
        for (ItemPoint itemPoint : list) {
            if (itemPoint.time_intval.equals("all")) {
                this.averageScore = itemPoint.point.doubleValue();
                return;
            }
        }
    }
}

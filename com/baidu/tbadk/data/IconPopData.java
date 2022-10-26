package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.Loop.IconPop;
/* loaded from: classes3.dex */
public class IconPopData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String category_id;
    public String ext;
    public String forum_list;
    public Long icon_id;
    public String intro;
    public String intro_url;
    public String is_advanced;
    public String is_force;
    public String is_new_style;
    public String level;
    public boolean mHadShow;
    public long mUid;
    public String name;
    public String pay_pic_pad;
    public String pay_pic_pc;
    public String pic;
    public String pic120;
    public String pic160;
    public String pic78;
    public String sprite;
    public String status;
    public String time_interval;
    public String title;
    public String title_url;
    public String type;
    public String weight;
    public String yb_price;

    public IconPopData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.icon_id = -1L;
        this.mHadShow = false;
        this.mUid = TbadkCoreApplication.getCurrentAccountId();
    }

    public String getCategory_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.category_id;
        }
        return (String) invokeV.objValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.ext;
        }
        return (String) invokeV.objValue;
    }

    public String getForum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.forum_list;
        }
        return (String) invokeV.objValue;
    }

    public Long getIcon_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.icon_id;
        }
        return (Long) invokeV.objValue;
    }

    public String getIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.intro;
        }
        return (String) invokeV.objValue;
    }

    public String getIntro_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.intro_url;
        }
        return (String) invokeV.objValue;
    }

    public String getIs_advanced() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.is_advanced;
        }
        return (String) invokeV.objValue;
    }

    public String getIs_force() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.is_force;
        }
        return (String) invokeV.objValue;
    }

    public String getIs_new_style() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.is_new_style;
        }
        return (String) invokeV.objValue;
    }

    public String getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.level;
        }
        return (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public String getPay_pic_pad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.pay_pic_pad;
        }
        return (String) invokeV.objValue;
    }

    public String getPay_pic_pc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.pay_pic_pc;
        }
        return (String) invokeV.objValue;
    }

    public String getPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.pic;
        }
        return (String) invokeV.objValue;
    }

    public String getPic120() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.pic120;
        }
        return (String) invokeV.objValue;
    }

    public String getPic160() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.pic160;
        }
        return (String) invokeV.objValue;
    }

    public String getPic78() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.pic78;
        }
        return (String) invokeV.objValue;
    }

    public String getSprite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.sprite;
        }
        return (String) invokeV.objValue;
    }

    public String getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.status;
        }
        return (String) invokeV.objValue;
    }

    public String getTime_interval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.time_interval;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.title_url;
        }
        return (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.type;
        }
        return (String) invokeV.objValue;
    }

    public Long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return Long.valueOf(this.mUid);
        }
        return (Long) invokeV.objValue;
    }

    public String getWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.weight;
        }
        return (String) invokeV.objValue;
    }

    public String getYb_price() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.yb_price;
        }
        return (String) invokeV.objValue;
    }

    public boolean isHadShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mHadShow;
        }
        return invokeV.booleanValue;
    }

    public void parserProtobuf(IconPop iconPop) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, iconPop) != null) || iconPop == null) {
            return;
        }
        this.icon_id = iconPop.icon_id;
        this.name = iconPop.name;
        this.level = iconPop.level;
        this.weight = iconPop.weight;
        this.pic = iconPop.pic;
        this.sprite = iconPop.sprite;
        this.status = iconPop.status;
        this.type = iconPop.type;
        this.category_id = iconPop.category_id;
        this.time_interval = iconPop.time_interval;
        this.is_force = iconPop.is_force;
        this.is_advanced = iconPop.is_advanced;
        this.ext = iconPop.ext;
        this.title = iconPop.title;
        this.title_url = iconPop.title_url;
        this.intro = iconPop.intro;
        this.intro_url = iconPop.intro_url;
        this.forum_list = iconPop.forum_list;
        this.pay_pic_pc = iconPop.pay_pic_pc;
        this.pay_pic_pad = iconPop.pay_pic_pad;
        this.yb_price = iconPop.yb_price;
        this.is_new_style = iconPop.is_new_style;
        this.pic78 = iconPop.pic78;
        this.pic120 = iconPop.pic120;
        this.pic160 = iconPop.pic160;
    }

    public void setCategory_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.category_id = str;
        }
    }

    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.ext = str;
        }
    }

    public void setForum_list(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.forum_list = str;
        }
    }

    public void setHadShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.mHadShow = z;
        }
    }

    public void setIcon_id(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, l) == null) {
            this.icon_id = l;
        }
    }

    public void setIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.intro = str;
        }
    }

    public void setIntro_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.intro_url = str;
        }
    }

    public void setIs_advanced(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.is_advanced = str;
        }
    }

    public void setIs_force(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.is_force = str;
        }
    }

    public void setIs_new_style(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.is_new_style = str;
        }
    }

    public void setLevel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.level = str;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.name = str;
        }
    }

    public void setPay_pic_pad(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.pay_pic_pad = str;
        }
    }

    public void setPay_pic_pc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.pay_pic_pc = str;
        }
    }

    public void setPic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.pic = str;
        }
    }

    public void setPic120(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.pic120 = str;
        }
    }

    public void setPic160(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.pic160 = str;
        }
    }

    public void setPic78(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.pic78 = str;
        }
    }

    public void setSprite(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.sprite = str;
        }
    }

    public void setStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.status = str;
        }
    }

    public void setTime_interval(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.time_interval = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.title = str;
        }
    }

    public void setTitle_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.title_url = str;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.type = str;
        }
    }

    public void setWeight(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.weight = str;
        }
    }

    public void setYb_price(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.yb_price = str;
        }
    }
}

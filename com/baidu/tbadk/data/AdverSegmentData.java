package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.hi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes4.dex */
public class AdverSegmentData implements Comparable<AdverSegmentData>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3218263913492238871L;
    public transient /* synthetic */ FieldHolder $fh;
    public String adSegmentId;
    public String clickStatisticsUrl;
    public String floatingText;
    public int floonumber;
    public String jumpExternalPackageName;
    public String jumpExternalScheme;
    public String jumpLink;
    public String mDisplayAdIcon;
    public String pic;
    public String picClick;
    public long time;
    public String viewStatisticsUrl;

    public AdverSegmentData() {
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

    public String getAdSegmentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.adSegmentId;
        }
        return (String) invokeV.objValue;
    }

    public String getClickStatisticsUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.clickStatisticsUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getFloatingText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.floatingText;
        }
        return (String) invokeV.objValue;
    }

    public int getFloonumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.floonumber;
        }
        return invokeV.intValue;
    }

    public String getJumpExternalPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.jumpExternalPackageName;
        }
        return (String) invokeV.objValue;
    }

    public String getJumpExternalScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.jumpExternalScheme;
        }
        return (String) invokeV.objValue;
    }

    public String getJumpLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.jumpLink;
        }
        return (String) invokeV.objValue;
    }

    public String getPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.pic;
        }
        return (String) invokeV.objValue;
    }

    public String getPicClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.picClick;
        }
        return (String) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.time;
        }
        return invokeV.longValue;
    }

    public String getViewStatisticsUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.viewStatisticsUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean isDisplayAdIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return !"0".equals(this.mDisplayAdIcon);
        }
        return invokeV.booleanValue;
    }

    private void handleStaticUrl() {
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (StringUtils.isNull(this.viewStatisticsUrl) && StringUtils.isNull(this.clickStatisticsUrl)) {
                return;
            }
            String c = hi.c(TbadkApplication.getInst().getAndroidId());
            String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            StringBuilder sb = new StringBuilder();
            sb.append("&ANDROIDID=");
            String str = "";
            if (c == null) {
                lowerCase = "";
            } else {
                lowerCase = c.toLowerCase();
            }
            sb.append(lowerCase);
            sb.append("&OAID=");
            if (lastCachedOid != null) {
                str = lastCachedOid.toUpperCase();
            }
            sb.append(str);
            String sb2 = sb.toString();
            if (!StringUtils.isNull(this.viewStatisticsUrl) && !this.viewStatisticsUrl.contains("ANDROIDID") && !this.viewStatisticsUrl.contains("OAID")) {
                this.viewStatisticsUrl += sb2;
            }
            if (!StringUtils.isNull(this.clickStatisticsUrl) && !this.clickStatisticsUrl.contains("ANDROIDID") && !this.clickStatisticsUrl.contains("OAID")) {
                this.clickStatisticsUrl += sb2;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(AdverSegmentData adverSegmentData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adverSegmentData)) == null) {
            if (getTime() > adverSegmentData.getTime()) {
                return -1;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public void setAdSegmentId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.adSegmentId = str;
        }
    }

    public void setFloatingText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.floatingText = str;
        }
    }

    public void setFloonumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.floonumber = i;
        }
    }

    public void setJumpLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.jumpLink = str;
        }
    }

    public void setPic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.pic = str;
        }
    }

    public void setPicClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.picClick = str;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.time = j;
        }
    }

    public void parse(Advertisement advertisement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, advertisement) == null) {
            this.time = advertisement.time.longValue();
            this.pic = advertisement.pic;
            this.picClick = advertisement.pic_click;
            this.jumpLink = advertisement.jump_link;
            this.adSegmentId = advertisement.advertisement_id;
            this.viewStatisticsUrl = advertisement.view_statistics_url;
            this.clickStatisticsUrl = advertisement.click_statistics_url;
            this.floatingText = advertisement.floating_text;
            this.jumpExternalScheme = advertisement.scheme;
            this.jumpExternalPackageName = advertisement.package_name;
            this.mDisplayAdIcon = advertisement.display_ad_icon;
            handleStaticUrl();
        }
    }

    public void parseJSONObject(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            this.pic = jSONObject.optString("pic");
            this.picClick = jSONObject.optString("pic_click");
            this.jumpLink = jSONObject.optString("jump_link");
            this.adSegmentId = jSONObject.optString("advertisement_id");
            this.viewStatisticsUrl = jSONObject.optString("view_statistics_url");
            this.clickStatisticsUrl = jSONObject.optString("click_statistics_url");
            this.floatingText = jSONObject.optString("floating_text");
            this.jumpExternalScheme = jSONObject.optString("scheme");
            this.jumpExternalPackageName = jSONObject.optString("package_name");
            this.mDisplayAdIcon = jSONObject.optString("display_ad_icon");
            handleStaticUrl();
        }
    }
}

package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.Loop.YyLiveInfoSimple;
import tbclient.YyExt;
/* loaded from: classes4.dex */
public class LiveRemindRecommendData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PAGE_LOCATE_BIG_PIC = 2;
    public static final int PAGE_LOCATE_BIG_RECOM_LIVE_CHANNEL = 4;
    public static final int PAGE_LOCATE_HOMEPAGE = 1;
    public static final int PAGE_LOCATE_TOP_FLOAT_VIEW = 0;
    public static final int PAGE_LOCATE_VIDEO_CHANNEL = 3;
    public static final int PAGE_LOCATE_VIDEO_CHANNEL_MIDDLE = 2;
    public static final int PAGE_LOCATE_VIDEO_CHANNEL_RECOMMON = 1;
    public static final long serialVersionUID = -2948583989203992664L;
    public transient /* synthetic */ FieldHolder $fh;
    public int dayMaxNum;
    public String desc;
    public int disappearSecond;
    public int disappearType;
    public String feedId;
    public String liveIconScheme;
    public String liveIconSrc;
    public String mBtnText;
    public Long mRoomId;
    public int minStepSecond;
    public String portrait;
    public int remindType;
    public int showPage;
    public int singleOpenMaxNum;
    public String title;
    public String userName;
    public YyExtData yyExtData;

    public LiveRemindRecommendData() {
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
        this.yyExtData = new YyExtData();
    }

    public String getBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBtnText;
        }
        return (String) invokeV.objValue;
    }

    public int getDayMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dayMaxNum;
        }
        return invokeV.intValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.desc;
        }
        return (String) invokeV.objValue;
    }

    public int getDisappearSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.disappearSecond;
        }
        return invokeV.intValue;
    }

    public int getDisappearType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.disappearType;
        }
        return invokeV.intValue;
    }

    public String getFeedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.feedId;
        }
        return (String) invokeV.objValue;
    }

    public String getLiveIconScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.liveIconScheme;
        }
        return (String) invokeV.objValue;
    }

    public String getLiveIconSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.liveIconSrc;
        }
        return (String) invokeV.objValue;
    }

    public int getMinStepSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.minStepSecond;
        }
        return invokeV.intValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.portrait;
        }
        return (String) invokeV.objValue;
    }

    public int getRemindType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.remindType;
        }
        return invokeV.intValue;
    }

    public Long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mRoomId;
        }
        return (Long) invokeV.objValue;
    }

    public int getShowPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.showPage;
        }
        return invokeV.intValue;
    }

    public int getSingleOpenMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.singleOpenMaxNum;
        }
        return invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.userName;
        }
        return (String) invokeV.objValue;
    }

    public YyExtData getYyExtData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.yyExtData;
        }
        return (YyExtData) invokeV.objValue;
    }

    public void parserProtobuf(YyLiveInfoSimple yyLiveInfoSimple) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, yyLiveInfoSimple) != null) || yyLiveInfoSimple == null) {
            return;
        }
        this.liveIconSrc = yyLiveInfoSimple.icon_url;
        this.liveIconScheme = yyLiveInfoSimple.icon_scheme;
        this.disappearType = yyLiveInfoSimple.disappear_type.intValue();
        this.disappearSecond = yyLiveInfoSimple.disappear_second.intValue();
        this.desc = yyLiveInfoSimple.desc;
        this.singleOpenMaxNum = yyLiveInfoSimple.single_open_max_num.intValue();
        this.dayMaxNum = yyLiveInfoSimple.day_max_num.intValue();
        this.minStepSecond = yyLiveInfoSimple.min_step_second.intValue();
        this.userName = yyLiveInfoSimple.user_name;
        this.portrait = yyLiveInfoSimple.portrait;
        this.title = yyLiveInfoSimple.title;
        parserYyExt(yyLiveInfoSimple.yy_ext);
        this.mRoomId = yyLiveInfoSimple.room_id;
        this.mBtnText = yyLiveInfoSimple.btn_text;
        this.feedId = yyLiveInfoSimple.feed_id;
        this.remindType = yyLiveInfoSimple.remind_type.intValue();
        this.showPage = yyLiveInfoSimple.show_page.intValue();
    }

    public void parserYyExt(YyExt yyExt) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, yyExt) == null) && yyExt != null) {
            YyExtData yyExtData = this.yyExtData;
            yyExtData.mSid = yyExt.sid;
            yyExtData.mSsid = yyExt.ssid;
            yyExtData.mTemplateId = yyExt.template_id;
            yyExtData.mYyUid = yyExt.yy_uid;
            boolean z = true;
            if (yyExt.is_yy_game.intValue() != 1) {
                z = false;
            }
            yyExtData.isYyGame = z;
            YyExtData yyExtData2 = this.yyExtData;
            yyExtData2.mRankShow = yyExt.rank_show;
            yyExtData2.streamInfo = yyExt.stream_info;
            yyExtData2.mIconUrl = yyExt.icon_url;
        }
    }

    public void setBtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mBtnText = str;
        }
    }

    public void setDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.desc = str;
        }
    }

    public void setFeedId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.feedId = str;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setRoomId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, l) == null) {
            this.mRoomId = l;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.title = str;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.userName = str;
        }
    }

    public void setYyExtData(YyExtData yyExtData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, yyExtData) == null) {
            this.yyExtData = yyExtData;
        }
    }
}

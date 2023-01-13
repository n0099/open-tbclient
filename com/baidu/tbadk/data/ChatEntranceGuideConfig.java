package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.Loop.ChatroomGuide;
import tbclient.Loop.ChatroomGuideConfig;
/* loaded from: classes3.dex */
public class ChatEntranceGuideConfig extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6332357317863550550L;
    public transient /* synthetic */ FieldHolder $fh;
    public GuideConfig hotConfig;
    public int hotNum;
    public GuideConfig manualConfig;

    /* loaded from: classes3.dex */
    public static class GuideConfig extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2296860213510279970L;
        public transient /* synthetic */ FieldHolder $fh;
        public String collapseBackGroundDay;
        public String collapseBackGroundNight;
        public String collapseIconDay;
        public String collapseIconNight;
        public String expendArrowDay;
        public String expendArrowNight;
        public String expendBackGroundDay;
        public String expendBackGroundNight;
        public String expendIconDay;
        public String expendIconNight;

        public GuideConfig() {
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

        public String getCollapseBackGroundDay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.collapseBackGroundDay;
            }
            return (String) invokeV.objValue;
        }

        public String getCollapseBackGroundNight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.collapseBackGroundNight;
            }
            return (String) invokeV.objValue;
        }

        public String getCollapseIconDay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.collapseIconDay;
            }
            return (String) invokeV.objValue;
        }

        public String getCollapseIconNight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.collapseIconNight;
            }
            return (String) invokeV.objValue;
        }

        public String getExpendArrowDay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.expendArrowDay;
            }
            return (String) invokeV.objValue;
        }

        public String getExpendArrowNight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.expendArrowNight;
            }
            return (String) invokeV.objValue;
        }

        public String getExpendBackGroundDay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.expendBackGroundDay;
            }
            return (String) invokeV.objValue;
        }

        public String getExpendBackGroundNight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.expendBackGroundNight;
            }
            return (String) invokeV.objValue;
        }

        public String getExpendIconDay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.expendIconDay;
            }
            return (String) invokeV.objValue;
        }

        public String getExpendIconNight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.expendIconNight;
            }
            return (String) invokeV.objValue;
        }

        public void parseProto(ChatroomGuideConfig chatroomGuideConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048586, this, chatroomGuideConfig) != null) || chatroomGuideConfig == null) {
                return;
            }
            this.expendIconDay = chatroomGuideConfig.icon_day;
            this.expendIconNight = chatroomGuideConfig.icon_night;
            this.expendBackGroundDay = chatroomGuideConfig.bkgrd_day;
            this.expendBackGroundNight = chatroomGuideConfig.bkgrd_night;
            this.expendArrowDay = chatroomGuideConfig.btnon_day;
            this.expendArrowNight = chatroomGuideConfig.btnon_night;
            this.collapseBackGroundDay = chatroomGuideConfig.small_bkgrd_day;
            this.collapseBackGroundNight = chatroomGuideConfig.small_bkgrd_night;
            this.collapseIconDay = chatroomGuideConfig.small_icon_day;
            this.collapseIconNight = chatroomGuideConfig.small_icon_night;
        }
    }

    public ChatEntranceGuideConfig() {
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

    public GuideConfig getHotConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.hotConfig;
        }
        return (GuideConfig) invokeV.objValue;
    }

    public int getHotNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.hotNum;
        }
        return invokeV.intValue;
    }

    public GuideConfig getManualConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.manualConfig;
        }
        return (GuideConfig) invokeV.objValue;
    }

    public void parseProto(ChatroomGuide chatroomGuide) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, chatroomGuide) != null) || chatroomGuide == null) {
            return;
        }
        this.hotNum = chatroomGuide.hot_num.intValue();
        if (chatroomGuide.hot_config != null) {
            GuideConfig guideConfig = new GuideConfig();
            this.hotConfig = guideConfig;
            guideConfig.parseProto(chatroomGuide.hot_config);
        }
        if (chatroomGuide.manual_config != null) {
            GuideConfig guideConfig2 = new GuideConfig();
            this.manualConfig = guideConfig2;
            guideConfig2.parseProto(chatroomGuide.manual_config);
        }
    }
}

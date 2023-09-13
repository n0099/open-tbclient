package com.baidu.tieba.im.data;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
import protobuf.MsgInfo;
/* loaded from: classes6.dex */
public final class GamePlaySendCardMsgData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String audio_url;
    public String avatar;
    public String btn_toast;
    public String btn_txt;
    public int duration;
    public SendCardFollowInfo follow;
    public int good_rate;
    public String intro_txt;
    public String nickname;
    public int order_num;
    public String sex;
    public List<SendCardTagInfo> tags;

    /* loaded from: classes6.dex */
    public static final class SendCardFollowInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String btn_txt;
        public String intro_txt;
        public String personal_home_page;

        public SendCardFollowInfo() {
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

        public String getBtn_txt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.btn_txt;
            }
            return (String) invokeV.objValue;
        }

        public String getIntro_txt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.intro_txt;
            }
            return (String) invokeV.objValue;
        }

        public String getPersonal_home_page() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.personal_home_page;
            }
            return (String) invokeV.objValue;
        }

        public void setBtn_txt(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.btn_txt = str;
            }
        }

        public void setIntro_txt(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.intro_txt = str;
            }
        }

        public void setPersonal_home_page(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.personal_home_page = str;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class SendCardTagInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String tag_bg_color;
        public String tag_color;
        public String tag_img;
        public String tag_name;

        public SendCardTagInfo() {
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

        public String getTag_bg_color() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.tag_bg_color;
            }
            return (String) invokeV.objValue;
        }

        public String getTag_color() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.tag_color;
            }
            return (String) invokeV.objValue;
        }

        public String getTag_img() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.tag_img;
            }
            return (String) invokeV.objValue;
        }

        public String getTag_name() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.tag_name;
            }
            return (String) invokeV.objValue;
        }

        public void setTag_bg_color(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.tag_bg_color = str;
            }
        }

        public void setTag_color(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.tag_color = str;
            }
        }

        public void setTag_img(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.tag_img = str;
            }
        }

        public void setTag_name(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.tag_name = str;
            }
        }
    }

    public GamePlaySendCardMsgData() {
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

    public String getAudio_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.audio_url;
        }
        return (String) invokeV.objValue;
    }

    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.avatar;
        }
        return (String) invokeV.objValue;
    }

    public String getBtn_toast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.btn_toast;
        }
        return (String) invokeV.objValue;
    }

    public String getBtn_txt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.btn_txt;
        }
        return (String) invokeV.objValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.duration;
        }
        return invokeV.intValue;
    }

    public SendCardFollowInfo getFollow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.follow;
        }
        return (SendCardFollowInfo) invokeV.objValue;
    }

    public int getGood_rate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.good_rate;
        }
        return invokeV.intValue;
    }

    public String getIntro_txt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.intro_txt;
        }
        return (String) invokeV.objValue;
    }

    public String getNickname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.nickname;
        }
        return (String) invokeV.objValue;
    }

    public int getOrder_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.order_num;
        }
        return invokeV.intValue;
    }

    public String getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.sex;
        }
        return (String) invokeV.objValue;
    }

    public List<SendCardTagInfo> getTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.tags;
        }
        return (List) invokeV.objValue;
    }

    public static GamePlaySendCardMsgData parseFromJsonStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return (GamePlaySendCardMsgData) OrmObject.objectWithJsonStr(str, GamePlaySendCardMsgData.class);
        }
        return (GamePlaySendCardMsgData) invokeL.objValue;
    }

    @Nullable
    public static GamePlaySendCardMsgData parseFromMsgInfo(MsgInfo msgInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, msgInfo)) == null) {
            if (msgInfo != null && !StringUtils.isNull(msgInfo.content)) {
                return (GamePlaySendCardMsgData) OrmObject.objectWithJsonStr(msgInfo.content, GamePlaySendCardMsgData.class);
            }
            return null;
        }
        return (GamePlaySendCardMsgData) invokeL.objValue;
    }

    public void setAudio_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.audio_url = str;
        }
    }

    public void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.avatar = str;
        }
    }

    public void setBtn_toast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.btn_toast = str;
        }
    }

    public void setBtn_txt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.btn_txt = str;
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.duration = i;
        }
    }

    public void setFollow(SendCardFollowInfo sendCardFollowInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sendCardFollowInfo) == null) {
            this.follow = sendCardFollowInfo;
        }
    }

    public void setGood_rate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.good_rate = i;
        }
    }

    public void setIntro_txt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.intro_txt = str;
        }
    }

    public void setNickname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.nickname = str;
        }
    }

    public void setOrder_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.order_num = i;
        }
    }

    public void setSex(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.sex = str;
        }
    }

    public void setTags(List<SendCardTagInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            this.tags = list;
        }
    }
}

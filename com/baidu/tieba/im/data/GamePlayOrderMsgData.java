package com.baidu.tieba.im.data;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.og;
import com.repackage.sa7;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.MsgInfo;
/* loaded from: classes3.dex */
public final class GamePlayOrderMsgData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6848718201885944849L;
    public transient /* synthetic */ FieldHolder $fh;
    public int clickBtn;
    public ContentInfo content_info;
    public String content_title;
    public long gid;
    public long god_id;
    public int hasRead;
    public String icon;
    public boolean isLast;
    public int is_god;
    public String main_btn;
    public ButtonActionParams main_btn_action_params;
    public long mid;
    public String order_id;
    public long peiwan_msg_type;
    public String second_btn;
    public ButtonActionParams second_btn_action_params;
    public String title;
    public String title_intro;
    public long user_id;

    /* loaded from: classes3.dex */
    public static final class ButtonActionParams extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -335888920495926025L;
        public transient /* synthetic */ FieldHolder $fh;
        public String avatar;
        public String finish_example_image;
        public String game_id;
        public String game_name;
        public String method;
        public String order_amount;
        public String order_status;
        public String play_price;
        public String play_times;
        public String unit;
        public String uri;
        public String user_name;

        public ButtonActionParams() {
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

        public String getAvatar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.avatar : (String) invokeV.objValue;
        }

        public String getFinish_example_image() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.finish_example_image : (String) invokeV.objValue;
        }

        public String getGame_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.game_id : (String) invokeV.objValue;
        }

        public String getGame_name() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.game_name : (String) invokeV.objValue;
        }

        public String getMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.method : (String) invokeV.objValue;
        }

        public String getOrder_amount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.order_amount : (String) invokeV.objValue;
        }

        public String getOrder_status() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.order_status : (String) invokeV.objValue;
        }

        public String getPlay_price() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.play_price : (String) invokeV.objValue;
        }

        public String getPlay_times() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.play_times : (String) invokeV.objValue;
        }

        public String getUnit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.unit : (String) invokeV.objValue;
        }

        public String getUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.uri : (String) invokeV.objValue;
        }

        public String getUser_name() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.user_name : (String) invokeV.objValue;
        }

        public void setAvatar(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.avatar = str;
            }
        }

        public void setFinish_example_image(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.finish_example_image = str;
            }
        }

        public void setGame_id(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.game_id = str;
            }
        }

        public void setGame_name(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.game_name = str;
            }
        }

        public void setMethod(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
                this.method = str;
            }
        }

        public void setOrder_amount(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
                this.order_amount = str;
            }
        }

        public void setOrder_status(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
                this.order_status = str;
            }
        }

        public void setPlay_price(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
                this.play_price = str;
            }
        }

        public void setPlay_times(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
                this.play_times = str;
            }
        }

        public void setUnit(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
                this.unit = str;
            }
        }

        public void setUri(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
                this.uri = str;
            }
        }

        public void setUser_name(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
                this.user_name = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class ContentInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -539795134006538216L;
        public transient /* synthetic */ FieldHolder $fh;
        public String amount;
        public String price;

        public ContentInfo() {
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

        public String getAmount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.amount : (String) invokeV.objValue;
        }

        public String getPrice() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.price : (String) invokeV.objValue;
        }

        public void setAmount(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.amount = str;
            }
        }

        public void setPrice(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.price = str;
            }
        }
    }

    public GamePlayOrderMsgData() {
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
        this.clickBtn = 0;
        this.isLast = false;
        this.hasRead = 0;
    }

    public static GamePlayOrderMsgData parseFromJsonStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return (GamePlayOrderMsgData) OrmObject.objectWithJsonStr(str, GamePlayOrderMsgData.class);
        }
        return (GamePlayOrderMsgData) invokeL.objValue;
    }

    @Nullable
    public static GamePlayOrderMsgData parseFromMsgInfo(MsgInfo msgInfo, boolean z) {
        InterceptResult invokeLZ;
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, msgInfo, z)) == null) {
            if (msgInfo == null || StringUtils.isNull(msgInfo.content)) {
                return null;
            }
            GamePlayOrderMsgData gamePlayOrderMsgData = (GamePlayOrderMsgData) OrmObject.objectWithJsonStr(msgInfo.content, GamePlayOrderMsgData.class);
            if (gamePlayOrderMsgData != null) {
                if (og.g(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                    longValue = msgInfo.userId.longValue();
                } else {
                    longValue = msgInfo.toUid.longValue();
                }
                gamePlayOrderMsgData.setGid(longValue);
                gamePlayOrderMsgData.setUser_id(msgInfo.userId.longValue());
                gamePlayOrderMsgData.setLast(z);
                gamePlayOrderMsgData.setMid(sa7.a(msgInfo.msgId.longValue()));
            }
            return gamePlayOrderMsgData;
        }
        return (GamePlayOrderMsgData) invokeLZ.objValue;
    }

    public int getClickBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.clickBtn : invokeV.intValue;
    }

    public ContentInfo getContent_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.content_info : (ContentInfo) invokeV.objValue;
    }

    public String getContent_title() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.content_title : (String) invokeV.objValue;
    }

    public long getGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.gid : invokeV.longValue;
    }

    public long getGod_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.god_id : invokeV.longValue;
    }

    public int getHasRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hasRead : invokeV.intValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.icon : (String) invokeV.objValue;
    }

    public int getIs_god() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.is_god : invokeV.intValue;
    }

    public String getMain_btn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.main_btn : (String) invokeV.objValue;
    }

    public ButtonActionParams getMain_btn_action_params() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.main_btn_action_params : (ButtonActionParams) invokeV.objValue;
    }

    public long getMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mid : invokeV.longValue;
    }

    public String getOrder_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.order_id : (String) invokeV.objValue;
    }

    public long getPeiwan_msg_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.peiwan_msg_type : invokeV.longValue;
    }

    public String getSecond_btn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.second_btn : (String) invokeV.objValue;
    }

    public ButtonActionParams getSecond_btn_action_params() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.second_btn_action_params : (ButtonActionParams) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public String getTitle_intro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.title_intro : (String) invokeV.objValue;
    }

    public long getUser_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.user_id : invokeV.longValue;
    }

    public boolean hasRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.hasRead == 1 : invokeV.booleanValue;
    }

    public boolean isLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.isLast : invokeV.booleanValue;
    }

    public void setClickBtn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.clickBtn = i;
        }
    }

    public void setContent_info(ContentInfo contentInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, contentInfo) == null) {
            this.content_info = contentInfo;
        }
    }

    public void setContent_title(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.content_title = str;
        }
    }

    public void setGid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.gid = j;
        }
    }

    public void setGod_id(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.god_id = j;
        }
    }

    public void setHasRead(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.hasRead = i;
        }
    }

    public void setIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.icon = str;
        }
    }

    public void setIs_god(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.is_god = i;
        }
    }

    public void setLast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.isLast = z;
        }
    }

    public void setMain_btn(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.main_btn = str;
        }
    }

    public void setMain_btn_action_params(ButtonActionParams buttonActionParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, buttonActionParams) == null) {
            this.main_btn_action_params = buttonActionParams;
        }
    }

    public void setMid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.mid = j;
        }
    }

    public void setOrder_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.order_id = str;
        }
    }

    public void setPeiwan_msg_type(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.peiwan_msg_type = j;
        }
    }

    public void setSecond_btn(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.second_btn = str;
        }
    }

    public void setSecond_btn_action_params(ButtonActionParams buttonActionParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, buttonActionParams) == null) {
            this.second_btn_action_params = buttonActionParams;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.title = str;
        }
    }

    public void setTitle_intro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.title_intro = str;
        }
    }

    public void setUser_id(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
            this.user_id = j;
        }
    }

    public String toEncodeContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("order_id", getOrder_id());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public void setHasRead(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.hasRead = z ? 1 : 0;
        }
    }
}

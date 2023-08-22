package com.baidu.tieba.im.lib.socket.msg.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class TopBubbleData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXCELLENT = "excellent";
    public static final String NOTICE = "notice";
    public static final long serialVersionUID = 1710946903693581029L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("content")
    public String content;
    public int excellentMsgOperation;
    @SerializedName("icon")
    public String icon;
    @SerializedName("jump_to")
    public String jumpTo;
    @SerializedName("msg_id")
    public String msgId;
    @SerializedName("msg_key")
    public String msgKey;
    @SerializedName("msg_min_version")
    public String msgMinVersion;
    @SerializedName("msg_type")
    public String msgType;
    @SerializedName("top_bubble_type")
    public String topBubbleType;
    @SerializedName("username")
    public String userName;
    @SerializedName("version_key")
    public String versionKey;

    public TopBubbleData() {
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

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.icon;
        }
        return (String) invokeV.objValue;
    }

    public String getJumpTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.jumpTo;
        }
        return (String) invokeV.objValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return JavaTypesHelper.toLong(this.msgId, 0L);
        }
        return invokeV.longValue;
    }

    public String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.msgKey;
        }
        return (String) invokeV.objValue;
    }

    public String getMsgMinVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.msgMinVersion;
        }
        return (String) invokeV.objValue;
    }

    public String getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.msgType;
        }
        return (String) invokeV.objValue;
    }

    public String getTopBubbleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.topBubbleType;
        }
        return (String) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.userName;
        }
        return (String) invokeV.objValue;
    }

    public String getVersionKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.versionKey;
        }
        return (String) invokeV.objValue;
    }

    public boolean isNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "notice".equals(this.topBubbleType);
        }
        return invokeV.booleanValue;
    }

    public boolean isSetExcellent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.excellentMsgOperation == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.content = str;
        }
    }

    public void setExcellentMsgOperation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.excellentMsgOperation = i;
        }
    }

    public void setIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.icon = str;
        }
    }

    public void setJumpTo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.jumpTo = str;
        }
    }

    public void setMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.msgKey = str;
        }
    }

    public void setMsgMinVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.msgMinVersion = str;
        }
    }

    public void setMsgType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.msgType = str;
        }
    }

    public void setTopBubbleType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.topBubbleType = str;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.userName = str;
        }
    }

    public void setVersionKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.versionKey = str;
        }
    }
}

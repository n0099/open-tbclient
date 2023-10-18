package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.R;
import com.baidu.tieba.hr5;
import com.baidu.tieba.i65;
import com.baidu.tieba.if8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public class TbVoiceMsg extends TbNormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FORMAT_MP3 = 2;
    public static final int MSG_TYPE = 3;
    public static final String VOICE_THUMBNAIL_TEXT;
    public static final long serialVersionUID = -8477601556340635939L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("during_time")
    @if8
    public String during;
    public boolean isLocal;
    @hr5(deserialize = false, serialize = false)
    public String path;
    @hr5(deserialize = false, serialize = false)
    public String vid;
    @hr5(deserialize = false, serialize = false)
    public VoiceData.VoiceModel voiceModel;
    public int voiceStatus;
    @SerializedName("voice_url")
    @if8
    public String voiceUrl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(932191643, "Lcom/baidu/tieba/im/lib/socket/msg/TbVoiceMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(932191643, "Lcom/baidu/tieba/im/lib/socket/msg/TbVoiceMsg;");
                return;
            }
        }
        VOICE_THUMBNAIL_TEXT = TbadkApplication.getInst().getString(R.string.last_msg_voice);
    }

    public TbVoiceMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isLocal = false;
        setType(3);
    }

    public String getDuring() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.during;
        }
        return (String) invokeV.objValue;
    }

    public int getIntDuring() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return JavaTypesHelper.toInt(this.during, 0);
        }
        return invokeV.intValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.path;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return VOICE_THUMBNAIL_TEXT;
        }
        return (CharSequence) invokeV.objValue;
    }

    public String getVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.vid;
        }
        return (String) invokeV.objValue;
    }

    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.voiceModel;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    public int getVoiceStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.voiceStatus;
        }
        return invokeV.intValue;
    }

    public String getVoiceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.voiceUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean isInvalidAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return StringUtils.isNull(this.voiceUrl);
        }
        return invokeV.booleanValue;
    }

    public boolean isLocal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.isLocal;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public static TbVoiceMsg create(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            TbVoiceMsg tbVoiceMsg = new TbVoiceMsg();
            tbVoiceMsg.during = String.valueOf(i);
            tbVoiceMsg.vid = str;
            tbVoiceMsg.path = i65.b(str);
            tbVoiceMsg.voiceStatus = 1;
            return tbVoiceMsg;
        }
        return (TbVoiceMsg) invokeLI.objValue;
    }

    public void setDuring(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.during = str;
        }
    }

    public void setLocal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.isLocal = z;
        }
    }

    public void setPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.path = str;
        }
    }

    public void setVid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.vid = str;
        }
    }

    public void setVoiceModel(@NonNull VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, voiceModel) == null) {
            this.voiceModel = voiceModel;
        }
    }

    public void setVoiceStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.voiceStatus = i;
        }
    }

    public void setVoiceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.voiceUrl = str;
        }
    }
}

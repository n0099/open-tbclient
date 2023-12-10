package com.baidu.tieba.im.lib.socket.msg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ot5;
import com.baidu.tieba.sv8;
import com.baidu.tieba.tv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public abstract class TbBaseImageMsg extends TbNormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("big_size")
    @sv8
    public String bigSize;
    @tv8
    @SerializedName("big_src")
    public String bigSrc;
    @ot5(deserialize = false, serialize = false)
    public final String imgThumbnailText;
    @SerializedName("bsize")
    @sv8
    public String thumbSize;
    @tv8
    @SerializedName("src")
    public String thumbUrl;

    public void onUploadImageSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public TbBaseImageMsg() {
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
        this.imgThumbnailText = TbadkApplication.getInst().getString(R.string.last_msg_pic);
    }

    public String getBigSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bigSize;
        }
        return (String) invokeV.objValue;
    }

    public String getBigSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bigSrc;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.thumbSize;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.thumbUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean isInvalidAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (StringUtils.isNull(this.thumbUrl)) {
                return true;
            }
            return !this.thumbUrl.startsWith("http");
        }
        return invokeV.booleanValue;
    }

    public void setBigSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.bigSize = str;
        }
    }

    public void setBigSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.bigSrc = str;
        }
    }

    public void setThumbSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.thumbSize = str;
        }
    }

    public void setThumbUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.thumbUrl = str;
        }
    }
}

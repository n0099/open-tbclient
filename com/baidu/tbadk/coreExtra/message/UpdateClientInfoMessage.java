package com.baidu.tbadk.coreExtra.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.ByteString;
import d.a.c.e.m.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import protobuf.UpdateClientInfo.DataReq;
import protobuf.UpdateClientInfo.UpdateClientInfoReqIdl;
/* loaded from: classes3.dex */
public class UpdateClientInfoMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bduss;
    public final Map<String, String> device;
    public int height;
    public double lat;
    public double lng;
    public Integer pub_env;
    public byte[] secretKey;
    public String stoken;
    public int width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateClientInfoMessage() {
        super(1001);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.device = new HashMap();
        try {
            if (TbadkCoreApplication.getInst().getLocationShared()) {
                this.lat = b.b(TbadkCoreApplication.getInst().getLocationLat(), 0.0d);
                this.lng = b.b(TbadkCoreApplication.getInst().getLocationLng(), 0.0d);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void addUserInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.device.put(str, str2);
        }
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.bduss = this.bduss;
            builder.device = getDevice();
            builder.stoken = this.stoken;
            builder.secretKey = ByteString.of(this.secretKey);
            builder.height = Integer.valueOf(this.height);
            builder.width = Integer.valueOf(this.width);
            builder.lat = Double.valueOf(this.lat);
            builder.lng = Double.valueOf(this.lng);
            builder.pub_env = this.pub_env;
            UpdateClientInfoReqIdl.Builder builder2 = new UpdateClientInfoReqIdl.Builder();
            builder2.cuid = TbadkCoreApplication.getUniqueIdentifier();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeV.objValue;
    }

    public String getDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return new JSONObject(this.device).toString();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void setBduss(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.bduss = str;
            this.stoken = str2;
        }
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.height = i2;
        }
    }

    public void setLat(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.lat = d2;
        }
    }

    public void setLng(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.lng = d2;
        }
    }

    public void setPub_env(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
            this.pub_env = num;
        }
    }

    public void setSecretKey(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) {
            this.secretKey = bArr;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.width = i2;
        }
    }
}

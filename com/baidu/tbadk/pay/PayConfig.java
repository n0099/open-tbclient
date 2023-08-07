package com.baidu.tbadk.pay;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class PayConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAYMENT_POS_KEY_MANGA = "37";
    public static final int PAYTYPE_MEMBER = 1;
    public static final int PAYTYPE_TDOU = 2;
    public static final long serialVersionUID = 1473520404420820966L;
    public transient /* synthetic */ FieldHolder $fh;
    public int fromScene;
    public int isAutoPay;
    public String mClickZone;
    public String mIsLeft;
    public String mMoney;
    public String mOrderInfo;
    public String mPayChannel;
    public int mPayType;
    public String mPropsId;
    public String mPropsMon;
    public String mReferPage;
    public String mVipType;
    public long orderCompleteTime;
    public String paymentPosKey;

    public PayConfig() {
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
        this.mOrderInfo = "";
        this.paymentPosKey = "";
    }

    public String getClickZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mClickZone;
        }
        return (String) invokeV.objValue;
    }

    public int getFromScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.fromScene;
        }
        return invokeV.intValue;
    }

    public String getIsLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mIsLeft;
        }
        return (String) invokeV.objValue;
    }

    public String getMoney() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mMoney;
        }
        return (String) invokeV.objValue;
    }

    public String getPayChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPayChannel;
        }
        return (String) invokeV.objValue;
    }

    public int getPayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPayType;
        }
        return invokeV.intValue;
    }

    public String getPropsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPropsId;
        }
        return (String) invokeV.objValue;
    }

    public String getPropsMon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mPropsMon;
        }
        return (String) invokeV.objValue;
    }

    public String getReferPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mReferPage;
        }
        return (String) invokeV.objValue;
    }

    public String getVipType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mVipType;
        }
        return (String) invokeV.objValue;
    }

    public int isAutoPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isAutoPay;
        }
        return invokeV.intValue;
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, Boolean.valueOf(z), str5, str6};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mReferPage = str5;
        this.mClickZone = str6;
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, boolean z2, PageDialogHelper.PayForm payForm, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2), payForm, str5, str6};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mReferPage = str5;
        this.mClickZone = str6;
    }

    public PayConfig setAutoPay(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.isAutoPay = i;
            return this;
        }
        return (PayConfig) invokeI.objValue;
    }

    public PayConfig setClickZone(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.mClickZone = str;
            return this;
        }
        return (PayConfig) invokeL.objValue;
    }

    public PayConfig setFromScene(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.fromScene = i;
            return this;
        }
        return (PayConfig) invokeI.objValue;
    }

    public PayConfig setIsLeft(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.mIsLeft = str;
            return this;
        }
        return (PayConfig) invokeL.objValue;
    }

    public PayConfig setMoney(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.mMoney = str;
            return this;
        }
        return (PayConfig) invokeL.objValue;
    }

    public PayConfig setPayChannel(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.mPayChannel = str;
            return this;
        }
        return (PayConfig) invokeL.objValue;
    }

    public PayConfig setPayType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.mPayType = i;
            return this;
        }
        return (PayConfig) invokeI.objValue;
    }

    public PayConfig setPropsId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.mPropsId = str;
            return this;
        }
        return (PayConfig) invokeL.objValue;
    }

    public PayConfig setPropsMon(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            this.mPropsMon = str;
            return this;
        }
        return (PayConfig) invokeL.objValue;
    }

    public PayConfig setReferPage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.mReferPage = str;
            return this;
        }
        return (PayConfig) invokeL.objValue;
    }

    public PayConfig setVipType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.mVipType = str;
            return this;
        }
        return (PayConfig) invokeL.objValue;
    }
}

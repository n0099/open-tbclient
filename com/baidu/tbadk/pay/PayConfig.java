package com.baidu.tbadk.pay;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PayConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAYMENT_POS_KEY_DUIBA = "1634";
    public static final String PAYMENT_POS_KEY_MANGA = "37";
    public static final int PAYTYPE_MEMBER = 1;
    public static final int PAYTYPE_PAY_DIRECT = 3;
    public static final int PAYTYPE_TDOU = 2;
    public static final int PAYTYPE_TYPE_CARDBOX = 4;
    public static final long serialVersionUID = 1473520404420820966L;
    public transient /* synthetic */ FieldHolder $fh;
    public int isAutoPay;
    public int isFromDecreaseGiftStepStrategy;
    public String mClickZone;
    public int mFrom;
    public String mIsLeft;
    public boolean mIsPay;
    public boolean mIsPayDialog;
    public String mMoney;
    public String mOrderInfo;
    public String mOrderName;
    public PageDialogHelper$PayForm mPayForm;
    public int mPayType;
    public String mPropsId;
    public String mPropsMon;
    public String mReferPage;
    public String mTitle;
    public long orderCompleteTime;
    public String paymentPosKey;
    public int tBeanNum;

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, Boolean.valueOf(z), str5, str6};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        this.mPayForm = PageDialogHelper$PayForm.NOT_SET;
        this.isFromDecreaseGiftStepStrategy = 0;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mReferPage = str5;
        this.mClickZone = str6;
    }

    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mFrom : invokeV.intValue;
    }

    public String getIsLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIsLeft : (String) invokeV.objValue;
    }

    public boolean getIsPayDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsPayDialog : invokeV.booleanValue;
    }

    public String getMoney() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMoney : (String) invokeV.objValue;
    }

    public String getOrderName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mOrderName : (String) invokeV.objValue;
    }

    public int getPayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPayType : invokeV.intValue;
    }

    public String getPropsId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPropsId : (String) invokeV.objValue;
    }

    public String getPropsMon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPropsMon : (String) invokeV.objValue;
    }

    public int getTBeanNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.tBeanNum : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public int isAutoPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isAutoPay : invokeV.intValue;
    }

    public int isFromDecreaseGiftStepStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isFromDecreaseGiftStepStrategy : invokeV.intValue;
    }

    public boolean isIsPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIsPay : invokeV.booleanValue;
    }

    public void setAutoPay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.isAutoPay = i;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mFrom = i;
        }
    }

    public void setFromDecreaseGiftStepStrategy(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.isFromDecreaseGiftStepStrategy = i;
        }
    }

    public void setIsLeft(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mIsLeft = str;
        }
    }

    public void setIsPay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mIsPay = z;
        }
    }

    public void setMoney(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mMoney = str;
        }
    }

    public void setOrderName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mOrderName = str;
        }
    }

    public void setPayType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mPayType = i;
        }
    }

    public void setPropsId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mPropsId = str;
        }
    }

    public void setPropsMon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mPropsMon = str;
        }
    }

    public void setTBeanNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.tBeanNum = i;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.mTitle = str;
        }
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, boolean z2, PageDialogHelper$PayForm pageDialogHelper$PayForm, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2), pageDialogHelper$PayForm, str5, str6};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        PageDialogHelper$PayForm pageDialogHelper$PayForm2 = PageDialogHelper$PayForm.NOT_SET;
        this.mPayForm = pageDialogHelper$PayForm2;
        this.isFromDecreaseGiftStepStrategy = 0;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mReferPage = str5;
        this.mClickZone = str6;
        pageDialogHelper$PayForm = pageDialogHelper$PayForm == null ? pageDialogHelper$PayForm2 : pageDialogHelper$PayForm;
        if (pageDialogHelper$PayForm == PageDialogHelper$PayForm.NOT_SET) {
            this.mIsPayDialog = z2;
        } else if (pageDialogHelper$PayForm == PageDialogHelper$PayForm.NORMAL) {
            this.mIsPayDialog = false;
        } else if (pageDialogHelper$PayForm == PageDialogHelper$PayForm.DIALOG) {
            this.mIsPayDialog = true;
        }
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, PageDialogHelper$PayForm pageDialogHelper$PayForm, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i), str, str2, str3, str4, Boolean.valueOf(z), str5, Boolean.valueOf(z2), pageDialogHelper$PayForm, str6, str7};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        this.mPayForm = PageDialogHelper$PayForm.NOT_SET;
        this.isFromDecreaseGiftStepStrategy = 0;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mOrderName = str5;
        this.mReferPage = str6;
        this.mClickZone = str7;
        this.tBeanNum = Integer.parseInt(str5);
        pageDialogHelper$PayForm = pageDialogHelper$PayForm == null ? PageDialogHelper$PayForm.NOT_SET : pageDialogHelper$PayForm;
        if (pageDialogHelper$PayForm == PageDialogHelper$PayForm.NOT_SET) {
            this.mIsPayDialog = z2;
        } else if (pageDialogHelper$PayForm == PageDialogHelper$PayForm.NORMAL) {
            this.mIsPayDialog = false;
        } else if (pageDialogHelper$PayForm == PageDialogHelper$PayForm.DIALOG) {
            this.mIsPayDialog = true;
        }
    }
}

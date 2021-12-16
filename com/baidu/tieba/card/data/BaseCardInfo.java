package com.baidu.tieba.card.data;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.e.j;
import c.a.e.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public abstract class BaseCardInfo implements n, k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean forceNoTest;
    public boolean isFirstFloor;
    public SupportType mSupportType;
    public boolean needTopMargin;
    public int position;
    public j trigger;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class SupportType {
        public static final /* synthetic */ SupportType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SupportType BOTTOM;
        public static final SupportType CONTENT;
        public static final SupportType EXTEND;
        public static final SupportType FULL;
        public static final SupportType NONE;
        public static final SupportType TOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(259581587, "Lcom/baidu/tieba/card/data/BaseCardInfo$SupportType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(259581587, "Lcom/baidu/tieba/card/data/BaseCardInfo$SupportType;");
                    return;
                }
            }
            NONE = new SupportType(PolyActivity.NONE_PANEL_TYPE, 0);
            FULL = new SupportType(PolyActivity.FULL_PANEL_TYPE, 1);
            TOP = new SupportType("TOP", 2);
            CONTENT = new SupportType("CONTENT", 3);
            BOTTOM = new SupportType("BOTTOM", 4);
            SupportType supportType = new SupportType("EXTEND", 5);
            EXTEND = supportType;
            $VALUES = new SupportType[]{NONE, FULL, TOP, CONTENT, BOTTOM, supportType};
        }

        public SupportType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SupportType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SupportType) Enum.valueOf(SupportType.class, str) : (SupportType) invokeL.objValue;
        }

        public static SupportType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SupportType[]) $VALUES.clone() : (SupportType[]) invokeV.objValue;
        }
    }

    public BaseCardInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.needTopMargin = false;
        this.isFirstFloor = false;
        this.mSupportType = SupportType.NONE;
    }

    public j getTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.trigger : (j) invokeV.objValue;
    }

    @Override // c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean isSupportBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSupportType == SupportType.BOTTOM : invokeV.booleanValue;
    }

    public boolean isSupportContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSupportType == SupportType.CONTENT : invokeV.booleanValue;
    }

    public boolean isSupportExtend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSupportType == SupportType.EXTEND : invokeV.booleanValue;
    }

    public boolean isSupportFull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSupportType == SupportType.FULL : invokeV.booleanValue;
    }

    public boolean isSupportNone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSupportType == SupportType.NONE : invokeV.booleanValue;
    }

    public boolean isSupportTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSupportType == SupportType.TOP : invokeV.booleanValue;
    }

    public void setSupportType(SupportType supportType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, supportType) == null) {
            this.mSupportType = supportType;
        }
    }

    @Override // c.a.e.k
    public void setTrigger(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
            this.trigger = jVar;
        }
    }
}

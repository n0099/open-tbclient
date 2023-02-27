package com.baidu.tieba.card.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.xo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes3.dex */
public abstract class BaseCardInfo implements Cdo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean forceNoTest;
    public boolean isFirstFloor;
    public SupportType mSupportType;
    public boolean needTopMargin;
    public int position;
    public xo trigger;

    @Override // com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean isHighLight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            NONE = new SupportType(HlsPlaylistParser.METHOD_NONE, 0);
            FULL = new SupportType("FULL", 1);
            TOP = new SupportType("TOP", 2);
            CONTENT = new SupportType("CONTENT", 3);
            BOTTOM = new SupportType("BOTTOM", 4);
            SupportType supportType = new SupportType("EXTEND", 5);
            EXTEND = supportType;
            $VALUES = new SupportType[]{NONE, FULL, TOP, CONTENT, BOTTOM, supportType};
        }

        public SupportType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SupportType) Enum.valueOf(SupportType.class, str);
            }
            return (SupportType) invokeL.objValue;
        }

        public static SupportType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SupportType[]) $VALUES.clone();
            }
            return (SupportType[]) invokeV.objValue;
        }
    }

    public BaseCardInfo() {
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
        this.needTopMargin = false;
        this.isFirstFloor = false;
        this.mSupportType = SupportType.NONE;
    }

    public xo getTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.trigger;
        }
        return (xo) invokeV.objValue;
    }

    public boolean isSupportBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mSupportType == SupportType.BOTTOM) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mSupportType == SupportType.CONTENT) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportExtend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mSupportType == SupportType.EXTEND) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportFull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mSupportType == SupportType.FULL) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportNone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mSupportType == SupportType.NONE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mSupportType == SupportType.TOP) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSupportType(SupportType supportType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, supportType) == null) {
            this.mSupportType = supportType;
        }
    }

    public void setTrigger(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xoVar) == null) {
            this.trigger = xoVar;
        }
    }
}

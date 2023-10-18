package com.baidu.tbadk.coreExtra.messageCenter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes5.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public int i;
        public boolean j;

        public a(NewsRemindMessage newsRemindMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newsRemindMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = false;
            this.i = 0;
            this.j = false;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i && this.j == aVar.j) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return Objects.hash(Integer.valueOf(this.a), Boolean.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Boolean.valueOf(this.h), Integer.valueOf(this.i), Boolean.valueOf(this.j));
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsRemindMessage() {
        super(2001626);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mData = new a(this);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NewsRemindMessage)) {
                return false;
            }
            return Objects.equals(this.mData, ((NewsRemindMessage) obj).mData);
        }
        return invokeL.booleanValue;
    }

    public void setChatCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048588, this, i) != null) {
            return;
        }
        this.mData.g = i;
    }

    public void setHasChatRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(1048589, this, z) != null) {
            return;
        }
        this.mData.h = z;
    }

    public void setHasMsgRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(1048590, this, z) != null) {
            return;
        }
        this.mData.b = z;
    }

    public void setHasNotificationRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(1048591, this, z) != null) {
            return;
        }
        this.mData.j = z;
    }

    public void setMsgAgreeCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048592, this, i) != null) {
            return;
        }
        this.mData.c = i;
    }

    public void setMsgAtCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048593, this, i) != null) {
            return;
        }
        this.mData.e = i;
    }

    public void setMsgCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048594, this, i) != null) {
            return;
        }
        this.mData.a = i;
    }

    public void setMsgFansCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048595, this, i) != null) {
            return;
        }
        this.mData.f = i;
    }

    public void setMsgReplyCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048596, this, i) != null) {
            return;
        }
        this.mData.d = i;
    }

    public void setNotificationCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048597, this, i) != null) {
            return;
        }
        this.mData.i = i;
    }

    public int getChatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData.g;
        }
        return invokeV.intValue;
    }

    public int getMsgAgreeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mData.c;
        }
        return invokeV.intValue;
    }

    public int getMsgAtCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mData.e;
        }
        return invokeV.intValue;
    }

    public int getMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mData.a;
        }
        return invokeV.intValue;
    }

    public int getMsgFansCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mData.f;
        }
        return invokeV.intValue;
    }

    public int getMsgReplyCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mData.d;
        }
        return invokeV.intValue;
    }

    public int getNotificationCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mData.i;
        }
        return invokeV.intValue;
    }

    public boolean hasChatRemind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mData.h;
        }
        return invokeV.booleanValue;
    }

    public boolean hasMsgRemind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mData.b;
        }
        return invokeV.booleanValue;
    }

    public boolean hasNotificationRemind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mData.j;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return Objects.hash(this.mData);
        }
        return invokeV.intValue;
    }
}

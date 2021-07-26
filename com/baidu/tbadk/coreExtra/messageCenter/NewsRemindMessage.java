package com.baidu.tbadk.coreExtra.messageCenter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f12875a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12876b;

        /* renamed from: c  reason: collision with root package name */
        public int f12877c;

        /* renamed from: d  reason: collision with root package name */
        public int f12878d;

        /* renamed from: e  reason: collision with root package name */
        public int f12879e;

        /* renamed from: f  reason: collision with root package name */
        public int f12880f;

        /* renamed from: g  reason: collision with root package name */
        public int f12881g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12882h;

        /* renamed from: i  reason: collision with root package name */
        public int f12883i;
        public boolean j;

        public a(NewsRemindMessage newsRemindMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newsRemindMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12875a = 0;
            this.f12876b = false;
            this.f12877c = 0;
            this.f12878d = 0;
            this.f12879e = 0;
            this.f12880f = 0;
            this.f12881g = 0;
            this.f12882h = false;
            this.f12883i = 0;
            this.j = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsRemindMessage() {
        super(2001626);
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
        this.mData = new a(this);
    }

    public int getChatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mData.f12881g : invokeV.intValue;
    }

    public int getMsgAgreeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData.f12877c : invokeV.intValue;
    }

    public int getMsgAtCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData.f12879e : invokeV.intValue;
    }

    public int getMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mData.f12875a : invokeV.intValue;
    }

    public int getMsgFansCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mData.f12880f : invokeV.intValue;
    }

    public int getMsgReplyCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mData.f12878d : invokeV.intValue;
    }

    public int getNotificationCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mData.f12883i : invokeV.intValue;
    }

    public boolean hasChatRemind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mData.f12882h : invokeV.booleanValue;
    }

    public boolean hasMsgRemind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mData.f12876b : invokeV.booleanValue;
    }

    public boolean hasNotificationRemind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mData.j : invokeV.booleanValue;
    }

    public void setChatCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mData.f12881g = i2;
        }
    }

    public void setHasChatRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mData.f12882h = z;
        }
    }

    public void setHasMsgRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mData.f12876b = z;
        }
    }

    public void setHasNotificationRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mData.j = z;
        }
    }

    public void setMsgAgreeCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mData.f12877c = i2;
        }
    }

    public void setMsgAtCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mData.f12879e = i2;
        }
    }

    public void setMsgCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mData.f12875a = i2;
        }
    }

    public void setMsgFansCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mData.f12880f = i2;
        }
    }

    public void setMsgReplyCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mData.f12878d = i2;
        }
    }

    public void setNotificationCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mData.f12883i = i2;
        }
    }
}

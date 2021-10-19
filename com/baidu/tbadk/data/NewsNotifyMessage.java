package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f48261a;

        /* renamed from: b  reason: collision with root package name */
        public int f48262b;

        /* renamed from: c  reason: collision with root package name */
        public int f48263c;

        /* renamed from: d  reason: collision with root package name */
        public int f48264d;

        /* renamed from: e  reason: collision with root package name */
        public int f48265e;

        /* renamed from: f  reason: collision with root package name */
        public int f48266f;

        /* renamed from: g  reason: collision with root package name */
        public int f48267g;

        /* renamed from: h  reason: collision with root package name */
        public int f48268h;

        /* renamed from: i  reason: collision with root package name */
        public int f48269i;

        /* renamed from: j  reason: collision with root package name */
        public int f48270j;

        public a(NewsNotifyMessage newsNotifyMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newsNotifyMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48261a = 0;
            this.f48262b = 0;
            this.f48263c = 0;
            this.f48264d = 0;
            this.f48265e = 0;
            this.f48266f = 0;
            this.f48267g = 0;
            this.f48268h = 0;
            this.f48269i = 0;
            this.f48270j = 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsNotifyMessage() {
        super(2001120);
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

    public int getMsgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mData.f48261a : invokeV.intValue;
    }

    public int getMsgAtme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData.f48263c : invokeV.intValue;
    }

    public int getMsgBookmark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData.f48266f : invokeV.intValue;
    }

    public int getMsgChat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mData.f48264d : invokeV.intValue;
    }

    public int getMsgFans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mData.f48265e : invokeV.intValue;
    }

    public int getMsgGiftNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mData.f48267g : invokeV.intValue;
    }

    public int getMsgOfficialMerge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mData.f48270j : invokeV.intValue;
    }

    public int getMsgPrivateChat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mData.f48268h : invokeV.intValue;
    }

    public int getMsgReplyme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mData.f48262b : invokeV.intValue;
    }

    public int getMsgStrangerChat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mData.f48269i : invokeV.intValue;
    }

    public void setMsgAgree(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mData.f48261a = i2;
        }
    }

    public void setMsgAtme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mData.f48263c = i2;
        }
    }

    public void setMsgBookmark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mData.f48266f = i2;
        }
    }

    public void setMsgChat(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mData.f48264d = i2;
        }
    }

    public void setMsgFans(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mData.f48265e = i2;
        }
    }

    public void setMsgGiftNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mData.f48267g = i2;
        }
    }

    public void setMsgOfficialMerge(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mData.f48270j = i2;
        }
    }

    public void setMsgPrivateChat(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mData.f48268h = i2;
        }
    }

    public void setMsgReplyme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mData.f48262b = i2;
        }
    }

    public void setMsgStrangerChat(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mData.f48269i = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsNotifyMessage(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(2001120);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i9 = newInitContext.flag;
            if ((i9 & 1) != 0) {
                int i10 = i9 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.mData = aVar;
        aVar.f48261a = i2;
        this.mData.f48262b = i3;
        this.mData.f48263c = i4;
        this.mData.f48264d = i5;
        this.mData.f48266f = i6;
        this.mData.f48267g = i7;
        this.mData.f48268h = i8;
    }
}

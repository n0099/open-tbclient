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
        public int f48101a;

        /* renamed from: b  reason: collision with root package name */
        public int f48102b;

        /* renamed from: c  reason: collision with root package name */
        public int f48103c;

        /* renamed from: d  reason: collision with root package name */
        public int f48104d;

        /* renamed from: e  reason: collision with root package name */
        public int f48105e;

        /* renamed from: f  reason: collision with root package name */
        public int f48106f;

        /* renamed from: g  reason: collision with root package name */
        public int f48107g;

        /* renamed from: h  reason: collision with root package name */
        public int f48108h;

        /* renamed from: i  reason: collision with root package name */
        public int f48109i;

        /* renamed from: j  reason: collision with root package name */
        public int f48110j;

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
            this.f48101a = 0;
            this.f48102b = 0;
            this.f48103c = 0;
            this.f48104d = 0;
            this.f48105e = 0;
            this.f48106f = 0;
            this.f48107g = 0;
            this.f48108h = 0;
            this.f48109i = 0;
            this.f48110j = 0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mData.f48101a : invokeV.intValue;
    }

    public int getMsgAtme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData.f48103c : invokeV.intValue;
    }

    public int getMsgBookmark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData.f48106f : invokeV.intValue;
    }

    public int getMsgChat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mData.f48104d : invokeV.intValue;
    }

    public int getMsgFans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mData.f48105e : invokeV.intValue;
    }

    public int getMsgGiftNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mData.f48107g : invokeV.intValue;
    }

    public int getMsgOfficialMerge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mData.f48110j : invokeV.intValue;
    }

    public int getMsgPrivateChat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mData.f48108h : invokeV.intValue;
    }

    public int getMsgReplyme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mData.f48102b : invokeV.intValue;
    }

    public int getMsgStrangerChat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mData.f48109i : invokeV.intValue;
    }

    public void setMsgAgree(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mData.f48101a = i2;
        }
    }

    public void setMsgAtme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mData.f48103c = i2;
        }
    }

    public void setMsgBookmark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mData.f48106f = i2;
        }
    }

    public void setMsgChat(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mData.f48104d = i2;
        }
    }

    public void setMsgFans(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mData.f48105e = i2;
        }
    }

    public void setMsgGiftNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mData.f48107g = i2;
        }
    }

    public void setMsgOfficialMerge(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mData.f48110j = i2;
        }
    }

    public void setMsgPrivateChat(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mData.f48108h = i2;
        }
    }

    public void setMsgReplyme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mData.f48102b = i2;
        }
    }

    public void setMsgStrangerChat(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mData.f48109i = i2;
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
        aVar.f48101a = i2;
        this.mData.f48102b = i3;
        this.mData.f48103c = i4;
        this.mData.f48104d = i5;
        this.mData.f48106f = i6;
        this.mData.f48107g = i7;
        this.mData.f48108h = i8;
    }
}

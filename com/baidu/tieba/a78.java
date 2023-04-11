package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.orderlist.OrderLinkList;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputViewController;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a78 implements c78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ChatRoomDetail a;
    @NonNull
    public final OrderLinkList<o68> b;
    @NonNull
    public final GroupInputViewController c;

    public a78(@NonNull GroupInputViewController groupInputViewController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupInputViewController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = groupInputViewController;
        this.b = new OrderLinkList<>();
    }

    @Override // com.baidu.tieba.c78
    public void d(@NonNull List<o68> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && list.size() > 0) {
            for (o68 o68Var : list) {
                o68Var.b(i(o68Var.d()));
                o68Var.h(false);
                this.b.insert(o68Var);
            }
        }
    }

    @Override // com.baidu.tieba.c78
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.b.c(i(i));
        }
    }

    @Override // com.baidu.tieba.c78
    public void b(@NonNull o68 o68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o68Var) == null) {
            o68Var.b(i(o68Var.d()));
            o68Var.h(false);
            this.b.insert(o68Var);
        }
    }

    @Override // com.baidu.tieba.c78
    public void g(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, chatRoomDetail) == null) {
            this.a = chatRoomDetail;
        }
    }

    @Override // com.baidu.tieba.c78
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            o68 f = f();
            if (f == null) {
                return false;
            }
            this.c.d1(f.c());
            this.c.s1(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c78
    @Nullable
    public o68 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.b();
        }
        return (o68) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c78
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            int i2 = i(i);
            o68 a = this.b.a(i2);
            if (i == 7011 && a != null && a.e()) {
                a.f(h(i));
            }
            if (a == null) {
                o68 o68Var = new o68();
                o68Var.g(i);
                o68Var.b(i2);
                o68Var.f(h(i));
                o68Var.h(true);
                this.b.insert(o68Var);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"StringFormatMatches"})
    public final String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i != 102) {
                if (i != 7003) {
                    if (i != 7005) {
                        if (i != 7007) {
                            switch (i) {
                                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_POST /* 7011 */:
                                    ChatRoomDetail chatRoomDetail = this.a;
                                    if (chatRoomDetail != null) {
                                        return String.format(b78.g, Integer.valueOf(chatRoomDetail.getExtraInfo().getTalkThresholdLevel()));
                                    }
                                    break;
                                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW /* 7012 */:
                                    return b78.b;
                                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_ONLY_MANAGER_CAN_TALK /* 7013 */:
                                    return b78.e;
                            }
                            return "";
                        }
                        return b78.c;
                    }
                    return b78.d;
                }
                return b78.f;
            }
            return b78.a;
        }
        return (String) invokeI.objValue;
    }

    public final int i(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i != 102) {
                switch (i) {
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE /* 7003 */:
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE /* 7004 */:
                        i2 = 5;
                        break;
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL /* 7005 */:
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL /* 7006 */:
                        i2 = 7;
                        break;
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN /* 7007 */:
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN /* 7008 */:
                        i2 = 8;
                        break;
                    default:
                        switch (i) {
                            case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_POST /* 7011 */:
                                i2 = 4;
                                break;
                            case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW /* 7012 */:
                                i2 = 9;
                                break;
                            case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_ONLY_MANAGER_CAN_TALK /* 7013 */:
                                i2 = 6;
                                break;
                            default:
                                i2 = 0;
                                break;
                        }
                }
            } else {
                i2 = 10;
            }
            if (i2 != 0) {
                return i2;
            }
            throw new IllegalArgumentException("The type of the banned msg is unknown!");
        }
        return invokeI.intValue;
    }
}

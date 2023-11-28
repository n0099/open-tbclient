package com.baidu.tieba;

import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947596099, "Lcom/baidu/tieba/b59;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947596099, "Lcom/baidu/tieba/b59;");
        }
    }

    @JvmStatic
    public static final zn8 a(ChatRoomDetail.BasicInfo info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, info)) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            zn8 zn8Var = new zn8(0L, null, 3, null);
            zn8Var.c(info.getForumId());
            zn8Var.d(info.getForumName());
            return zn8Var;
        }
        return (zn8) invokeL.objValue;
    }

    @JvmStatic
    public static final co8 b(long j, ChatRoomDetail roomDetail) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, roomDetail)) == null) {
            Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
            co8 co8Var = new co8(0L, 0, 0, null, null, 31, null);
            co8Var.i(j);
            co8Var.f(roomDetail.getUserInfo().getIdentityRole());
            co8Var.j(roomDetail.getExtraInfo().getTalkThresholdLevel());
            co8Var.g(roomDetail.getMaskInfoList());
            co8Var.h(roomDetail.getQuickTalk());
            return co8Var;
        }
        return (co8) invokeJL.objValue;
    }
}

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
public final class eu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947746945, "Lcom/baidu/tieba/eu8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947746945, "Lcom/baidu/tieba/eu8;");
        }
    }

    @JvmStatic
    public static final md8 a(ChatRoomDetail.BasicInfo info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, info)) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            md8 md8Var = new md8(0L, null, 3, null);
            md8Var.c(info.getForumId());
            md8Var.d(info.getForumName());
            return md8Var;
        }
        return (md8) invokeL.objValue;
    }

    @JvmStatic
    public static final pd8 b(long j, ChatRoomDetail roomDetail) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, roomDetail)) == null) {
            Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
            pd8 pd8Var = new pd8(0L, 0, 0, null, null, 31, null);
            pd8Var.i(j);
            pd8Var.f(roomDetail.getUserInfo().getIdentityRole());
            pd8Var.j(roomDetail.getExtraInfo().getTalkThresholdLevel());
            pd8Var.g(roomDetail.getMaskInfoList());
            pd8Var.h(roomDetail.getQuickTalk());
            return pd8Var;
        }
        return (pd8) invokeJL.objValue;
    }
}

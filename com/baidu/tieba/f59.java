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
public final class f59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947715263, "Lcom/baidu/tieba/f59;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947715263, "Lcom/baidu/tieba/f59;");
        }
    }

    @JvmStatic
    public static final do8 a(ChatRoomDetail.BasicInfo info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, info)) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            do8 do8Var = new do8(0L, null, 3, null);
            do8Var.c(info.getForumId());
            do8Var.d(info.getForumName());
            return do8Var;
        }
        return (do8) invokeL.objValue;
    }

    @JvmStatic
    public static final go8 b(long j, ChatRoomDetail roomDetail) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, roomDetail)) == null) {
            Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
            go8 go8Var = new go8(0L, 0, 0, null, null, 31, null);
            go8Var.i(j);
            go8Var.f(roomDetail.getUserInfo().getIdentityRole());
            go8Var.j(roomDetail.getExtraInfo().getTalkThresholdLevel());
            go8Var.g(roomDetail.getMaskInfoList());
            go8Var.h(roomDetail.getQuickTalk());
            return go8Var;
        }
        return (go8) invokeJL.objValue;
    }
}

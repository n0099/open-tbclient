package com.baidu.tieba;

import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947745054, "Lcom/baidu/tieba/g59;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947745054, "Lcom/baidu/tieba/g59;");
        }
    }

    @JvmStatic
    public static final eo8 a(ChatRoomDetail.BasicInfo info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, info)) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            eo8 eo8Var = new eo8(0L, null, 3, null);
            eo8Var.c(info.getForumId());
            eo8Var.d(info.getForumName());
            return eo8Var;
        }
        return (eo8) invokeL.objValue;
    }

    @JvmStatic
    public static final ho8 b(long j, ChatRoomDetail roomDetail) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, roomDetail)) == null) {
            Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
            ho8 ho8Var = new ho8(0L, 0, 0, null, null, 31, null);
            ho8Var.i(j);
            ho8Var.f(roomDetail.getUserInfo().getIdentityRole());
            ho8Var.j(roomDetail.getExtraInfo().getTalkThresholdLevel());
            ho8Var.g(roomDetail.getMaskInfoList());
            ho8Var.h(roomDetail.getQuickTalk());
            return ho8Var;
        }
        return (ho8) invokeJL.objValue;
    }
}

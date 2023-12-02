package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.TbAtUserInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bv8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public IChatRoomEnterListener.AtUserInfo a(TbAtUserInfo tbInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbInfo)) == null) {
            Intrinsics.checkNotNullParameter(tbInfo, "tbInfo");
            IChatRoomEnterListener.AtUserInfo atUserInfo = new IChatRoomEnterListener.AtUserInfo();
            if (tbInfo.getAtType() == TbAtUserInfo.AtType.ALL) {
                str = "all";
            } else {
                str = "user";
            }
            atUserInfo.atType = str;
            atUserInfo.atBdUk = zv8.b(tbInfo.getAtUid());
            atUserInfo.atName = tbInfo.getAtName();
            atUserInfo.atPortrait = tbInfo.getAtPortrait();
            atUserInfo.atPosition = String.valueOf(tbInfo.getAtPosition());
            return atUserInfo;
        }
        return (IChatRoomEnterListener.AtUserInfo) invokeL.objValue;
    }

    public TbAtUserInfo b(IChatRoomEnterListener.AtUserInfo sdkInfo) {
        InterceptResult invokeL;
        TbAtUserInfo.AtType atType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkInfo)) == null) {
            Intrinsics.checkNotNullParameter(sdkInfo, "sdkInfo");
            TbAtUserInfo tbAtUserInfo = new TbAtUserInfo();
            if (TextUtils.equals(sdkInfo.atType, "all")) {
                atType = TbAtUserInfo.AtType.ALL;
            } else {
                atType = TbAtUserInfo.AtType.USER;
            }
            tbAtUserInfo.setAtType(atType);
            String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(sdkInfo.atBdUk);
            Intrinsics.checkNotNullExpressionValue(bdUidFromBdUK, "getBdUidFromBdUK(sdkInfo.atBdUk)");
            tbAtUserInfo.setAtUid(Long.parseLong(bdUidFromBdUK));
            String str = sdkInfo.atBdUk;
            Intrinsics.checkNotNullExpressionValue(str, "sdkInfo.atBdUk");
            tbAtUserInfo.setAtUid(zv8.a(str));
            String atName = sdkInfo.atName;
            Intrinsics.checkNotNullExpressionValue(atName, "atName");
            tbAtUserInfo.setAtName(atName);
            String atPortrait = sdkInfo.atPortrait;
            Intrinsics.checkNotNullExpressionValue(atPortrait, "atPortrait");
            tbAtUserInfo.setAtPortrait(atPortrait);
            String atPosition = sdkInfo.atPosition;
            Intrinsics.checkNotNullExpressionValue(atPosition, "atPosition");
            tbAtUserInfo.setAtPosition(Integer.parseInt(atPosition));
            return tbAtUserInfo;
        }
        return (TbAtUserInfo) invokeL.objValue;
    }
}

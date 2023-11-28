package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.lib.socket.msg.TbActivitySysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbEffectGuidanceSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbEmojiReplySysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbExcellentSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbNoUISysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbNoticeModifySysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbRecallSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbShareChatRoomSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbShareCommonCardSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbShareForumSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbShareThreadSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSubscribeSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextGenImageUpdateSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTipsSysMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class cv8 extends zu8<TbSysMsg, UnSupportedMsg> {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688324, "Lcom/baidu/tieba/cv8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688324, "Lcom/baidu/tieba/cv8;");
                return;
            }
        }
        f = new a(null);
    }

    public /* synthetic */ cv8(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final Triple<Class<TbSysMsg>, Class<UnSupportedMsg>, cv8> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Triple<>(TbSysMsg.class, UnSupportedMsg.class, new cv8(null));
            }
            return (Triple) invokeV.objValue;
        }
    }

    public cv8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j(7019, TbEffectGuidanceSysMsg.class);
        j(7018, TbExcellentSysMsg.class);
        List<Integer> MSG_TYPE_LIST = TbNoUISysMsg.MSG_TYPE_LIST;
        Intrinsics.checkNotNullExpressionValue(MSG_TYPE_LIST, "MSG_TYPE_LIST");
        k(MSG_TYPE_LIST, TbNoUISysMsg.class);
        j(7001, TbNoticeModifySysMsg.class);
        List<Integer> MSG_TYPE_LIST2 = TbRecallSysMsg.MSG_TYPE_LIST;
        Intrinsics.checkNotNullExpressionValue(MSG_TYPE_LIST2, "MSG_TYPE_LIST");
        k(MSG_TYPE_LIST2, TbRecallSysMsg.class);
        j(-7015, TbSubscribeSysMsg.class);
        j(7014, TbTextGenImageUpdateSysMsg.class);
        List<Integer> MSG_TYPE_LIST3 = TbTipsSysMsg.MSG_TYPE_LIST;
        Intrinsics.checkNotNullExpressionValue(MSG_TYPE_LIST3, "MSG_TYPE_LIST");
        k(MSG_TYPE_LIST3, TbTipsSysMsg.class);
        j(7020, TbShareChatRoomSysMsg.class);
        j(7021, TbShareCommonCardSysMsg.class);
        j(7009, TbShareForumSysMsg.class);
        j(7010, TbShareThreadSysMsg.class);
        j(20000, TbEmojiReplySysMsg.class);
        j(7022, TbActivitySysMsg.class);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zu8
    /* renamed from: n */
    public UnSupportedMsg g(TbSysMsg tbMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMsg)) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            return new UnSupportedMsg();
        }
        return (UnSupportedMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zu8
    /* renamed from: o */
    public TbSysMsg h(int i, UnSupportedMsg sdkMsg, Map<String, ? extends Object> sdkMsgMap) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, sdkMsg, sdkMsgMap)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            Intrinsics.checkNotNullParameter(sdkMsgMap, "sdkMsgMap");
            Class<Object> i2 = i(i);
            if (i2 == null) {
                i = TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS;
                i2 = l(TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS);
            }
            TbSysMsg tbSysMsg = (TbSysMsg) DataExt.toEntity(sdkMsgMap, i2);
            tbSysMsg.setType(i);
            return tbSysMsg;
        }
        return (TbSysMsg) invokeILL.objValue;
    }
}

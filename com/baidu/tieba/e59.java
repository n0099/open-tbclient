package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tieba.immessagecenter.msgtab.data.NotifyType;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class e59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-880021501, "Lcom/baidu/tieba/e59$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-880021501, "Lcom/baidu/tieba/e59$a;");
                    return;
                }
            }
            int[] iArr = new int[NotifyType.values().length];
            iArr[NotifyType.AT_ME.ordinal()] = 1;
            iArr[NotifyType.AGREE_ME.ordinal()] = 2;
            iArr[NotifyType.REPLY_ME.ordinal()] = 3;
            iArr[NotifyType.FANS.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public e59() {
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

    public final void a(x39 x39Var) {
        NotifyType notifyType;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, x39Var) == null) {
            if (x39Var != null) {
                notifyType = x39Var.c();
            } else {
                notifyType = null;
            }
            if (notifyType == null) {
                i = -1;
            } else {
                i = a.$EnumSwitchMapping$0[notifyType.ordinal()];
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            oq8.b().g(4, 0);
                            PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
                            y95.p0().l();
                            y95.p0().j0(0);
                            DefaultLog.getInstance().i("MsgTabNotifyRemind", "clearNotifyRemind: [粉丝] 重置(内存/缓存)消息未读数为0，清理粉丝通知");
                            return;
                        }
                        return;
                    }
                    oq8.b().g(2, 0);
                    y95.p0().o();
                    y95.p0().m0(0);
                    DefaultLog.getInstance().i("MsgTabNotifyRemind", "clearNotifyRemind: [回复] 重置(内存/缓存)消息未读数为0，清理回复通知");
                    return;
                }
                oq8.b().g(1, 0);
                y95.p0().h();
                y95.p0().f0(0);
                DefaultLog.getInstance().i("MsgTabNotifyRemind", "clearNotifyRemind: [点赞] 重置(内存/缓存)消息未读数为0，清理点赞通知");
                return;
            }
            oq8.b().g(3, 0);
            y95.p0().j();
            y95.p0().g0(0);
            DefaultLog.getInstance().i("MsgTabNotifyRemind", "clearNotifyRemind: [@我] 重置(内存/缓存)消息未读数为0，清理@我通知");
        }
    }

    public final void b(BaseFragment frag, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frag, i) == null) {
            Intrinsics.checkNotNullParameter(frag, "frag");
            AgreeMeActivityConfig agreeMeActivityConfig = new AgreeMeActivityConfig(frag.getContext());
            BdUniqueId uniqueId = frag.getUniqueId();
            if (uniqueId != null) {
                agreeMeActivityConfig.setLastUniqueId(uniqueId.getId());
            }
            agreeMeActivityConfig.setAgreeNumber(i);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, agreeMeActivityConfig));
        }
    }

    public final void c(BaseFragment frag, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, frag, i) == null) {
            Intrinsics.checkNotNullParameter(frag, "frag");
            AtMeActivityConfig atMeActivityConfig = new AtMeActivityConfig(frag.getContext());
            BdUniqueId uniqueId = frag.getUniqueId();
            if (uniqueId != null) {
                atMeActivityConfig.setLastUniqueId(uniqueId.getId());
            }
            atMeActivityConfig.setAtNumber(i);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atMeActivityConfig));
        }
    }

    public final void d(BaseFragment frag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, frag) == null) {
            Intrinsics.checkNotNullParameter(frag, "frag");
            PersonListActivityConfig personListActivityConfig = new PersonListActivityConfig(frag.getContext(), false, TbadkCoreApplication.getCurrentAccount(), 0);
            BdUniqueId uniqueId = frag.getUniqueId();
            if (uniqueId != null) {
                personListActivityConfig.setLastUniqueId(uniqueId.getId());
            }
            personListActivityConfig.setFansNumber(y95.p0().y());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personListActivityConfig));
        }
    }

    public final void e(BaseFragment frag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frag) == null) {
            Intrinsics.checkNotNullParameter(frag, "frag");
            ReplyMeActivityConfig replyMeActivityConfig = new ReplyMeActivityConfig(frag.getContext());
            replyMeActivityConfig.setFrom(1);
            BdUniqueId uniqueId = frag.getUniqueId();
            if (uniqueId != null) {
                replyMeActivityConfig.setLastUniqueId(uniqueId.getId());
            }
            replyMeActivityConfig.setReplyNumber(y95.p0().B());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, replyMeActivityConfig));
        }
    }
}

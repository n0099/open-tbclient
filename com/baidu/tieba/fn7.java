package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.forum.helper.ForumFullPushDialogController;
import com.baidu.tieba.oq6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public final class fn7 extends j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumFullPushDialogController a;
    public final CustomMessageListener b;
    public final CustomMessageListener c;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fn7 fn7Var) {
            super(2921825);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                ForumFullPushDialogController forumFullPushDialogController = this.a.a;
                if (forumFullPushDialogController != null) {
                    forumFullPushDialogController.i();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn7 a;

        public b(fn7 fn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn7Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
                return (CustomResponsedMessage) invokeL.objValue;
            }
            ForumFullPushDialogController forumFullPushDialogController = this.a.a;
            if (forumFullPushDialogController != null) {
                z = forumFullPushDialogController.j();
            } else {
                z = false;
            }
            return new CustomResponsedMessage<>(2921826, Boolean.valueOf(z));
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fn7 fn7Var) {
            super(2001304);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                ForumFullPushDialogController forumFullPushDialogController = this.a.a;
                if (forumFullPushDialogController != null) {
                    forumFullPushDialogController.k();
                }
            }
        }
    }

    public fn7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new c(this);
        this.c = new a(this);
    }

    public static final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            YunDialogManager.unMarkShowingDialogName("frsFullPush");
            MessageManager.getInstance().unRegisterTask(2921826);
        }
    }

    @Override // com.baidu.tieba.j15
    public void a(Context context, x05 data) {
        String str;
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (context instanceof f25) {
                f25 f25Var = (f25) context;
                if (f25Var.i1() != null) {
                    e25 i1 = f25Var.i1();
                    ForumData a1 = i1.a1();
                    String str2 = null;
                    if (a1 != null) {
                        str = a1.getId();
                    } else {
                        str = null;
                    }
                    if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示全员推送弹窗失败：吧id为空");
                        YunDialogManager.unMarkShowingDialogName("frsFullPush");
                    }
                    if (context instanceof BaseFragmentActivity) {
                        baseFragmentActivity = (BaseFragmentActivity) context;
                    } else {
                        baseFragmentActivity = null;
                    }
                    if (baseFragmentActivity == null) {
                        YunDialogManager.unMarkShowingDialogName("frsFullPush");
                        return;
                    }
                    ForumData a12 = i1.a1();
                    if (a12 != null) {
                        str2 = a12.getId();
                    }
                    FrsSpriteNewUserGuide F0 = i1.F0();
                    if (F0 != null) {
                        ForumFullPushDialogController forumFullPushDialogController = new ForumFullPushDialogController(baseFragmentActivity);
                        this.a = forumFullPushDialogController;
                        Intrinsics.checkNotNull(forumFullPushDialogController);
                        forumFullPushDialogController.n(String.valueOf(str2));
                        ForumFullPushDialogController forumFullPushDialogController2 = this.a;
                        Intrinsics.checkNotNull(forumFullPushDialogController2);
                        forumFullPushDialogController2.o(new oq6.e() { // from class: com.baidu.tieba.an7
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.baidu.tieba.oq6.e
                            public final void onDismiss() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    fn7.c();
                                }
                            }
                        });
                        ForumFullPushDialogController forumFullPushDialogController3 = this.a;
                        Intrinsics.checkNotNull(forumFullPushDialogController3);
                        forumFullPushDialogController3.q(F0);
                        YunDialogManager.markShowingDialogName("frsFullPush");
                        i1.u1(false);
                    }
                    baseFragmentActivity.registerListener(this.b);
                    baseFragmentActivity.registerListener(this.c);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2921826, new b(this));
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                    MessageManager.getInstance().registerTask(customMessageTask);
                    return;
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示全员推送弹窗失败：获取到的IForumDialogExtSupport为空");
            YunDialogManager.unMarkShowingDialogName("frsFullPush");
        }
    }
}

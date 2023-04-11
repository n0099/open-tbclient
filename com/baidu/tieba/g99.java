package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogReqNetMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PushDialogActivity a;
    public String b;
    public long c;

    /* loaded from: classes4.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g99 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g99 g99Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g99Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g99Var;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof PushDialogHttpResMsg) {
                    this.a.f((PushDialogHttpResMsg) responsedMessage);
                } else if (responsedMessage instanceof PushDialogSocketResMsg) {
                    this.a.g((PushDialogSocketResMsg) responsedMessage);
                }
            }
        }
    }

    public g99(PushDialogActivity pushDialogActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pushDialogActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pushDialogActivity;
        pushDialogActivity.registerListener(new a(this, CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614));
        Intent intent = this.a.getIntent();
        if (intent != null) {
            this.b = intent.getStringExtra("thread_id");
            this.c = intent.getLongExtra("task_id", 0L);
            if (StringUtils.isNull(this.b)) {
                this.a.finish();
            }
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long g = gg.g(this.b, 0L);
            if (g == 0) {
                PushDialogActivity pushDialogActivity = this.a;
                if (pushDialogActivity != null) {
                    pushDialogActivity.B1(false, null);
                    return;
                }
                return;
            }
            PushDialogReqNetMsg pushDialogReqNetMsg = new PushDialogReqNetMsg();
            pushDialogReqNetMsg.setTask_id(this.c);
            pushDialogReqNetMsg.setTid(g);
            MessageManager.getInstance().sendMessage(pushDialogReqNetMsg);
        }
    }

    public final void f(PushDialogHttpResMsg pushDialogHttpResMsg) {
        PushDialogActivity pushDialogActivity;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, pushDialogHttpResMsg) == null) && (pushDialogActivity = this.a) != null) {
            if (pushDialogHttpResMsg.getError() == 0) {
                z = true;
            } else {
                z = false;
            }
            pushDialogActivity.B1(z, pushDialogHttpResMsg.getData());
        }
    }

    public final void g(PushDialogSocketResMsg pushDialogSocketResMsg) {
        PushDialogActivity pushDialogActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, pushDialogSocketResMsg) == null) && (pushDialogActivity = this.a) != null) {
            pushDialogActivity.B1(!pushDialogSocketResMsg.hasError(), pushDialogSocketResMsg.getData());
        }
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class c16 extends ActivityDelegation implements fo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public f16 b;
    public Activity c;
    public Map<String, String> d;
    public CustomMessageListener e;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c16 c16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c16Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof rk5)) {
                    return;
                }
                rk5 rk5Var = (rk5) data;
                if (getTag() != rk5Var.a && !rk5Var.g) {
                    return;
                }
                this.a.mResult.putInt("result_code", rk5Var.b);
                this.a.mResult.putString("result_msg", rk5Var.c);
                if (this.a.b != null) {
                    this.a.b.a(this.a.mResult);
                }
                this.a.finish();
            }
        }
    }

    public c16() {
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
        this.a = BdUniqueId.gen();
        this.e = new a(this, 2921393);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = null;
            MessageManager.getInstance().unRegisterListener(this.e);
            super.finish();
        }
    }

    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.c = activity;
        }
    }

    public void e(f16 f16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f16Var) == null) {
            this.b = f16Var;
        }
    }

    @Override // com.baidu.tieba.fo1
    public void onResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mResult.putInt("result_code", i);
            this.mResult.putString("result_msg", "");
            finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.e.setTag(this.a);
            MessageManager.getInstance().registerListener(this.e);
            int i = this.mParams.getInt("type");
            String string = this.mParams.getString("orderInfo");
            rk5 rk5Var = new rk5();
            rk5Var.a = this.a;
            rk5Var.b = i;
            rk5Var.c = string;
            rk5Var.e = (Map) this.mParams.getSerializable("params");
            rk5Var.f = this.d;
            if (getAgent() != null) {
                rk5Var.d = getAgent();
            } else {
                Activity activity = this.c;
                if (activity != null) {
                    rk5Var.d = activity;
                } else {
                    rk5Var.d = TbadkCoreApplication.getInst().getCurrentActivity();
                }
            }
            CustomMessage customMessage = new CustomMessage(2921393, rk5Var);
            customMessage.setTag(this.a);
            boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
            Bundle bundle = this.mResult;
            int i2 = 1;
            if (sendMessage) {
                i2 = 0;
            }
            bundle.putInt("result_code", i2);
            Bundle bundle2 = this.mResult;
            bundle2.putString("result_msg", "" + sendMessage);
            return false;
        }
        return invokeV.booleanValue;
    }
}

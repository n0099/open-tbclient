package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i57 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsActivity a;
    public ue7 b;
    public ve7 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i57(FrsActivity frsActivity) {
        super(2921728);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
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
        this.a = frsActivity;
        ue7 ue7Var = new ue7(frsActivity);
        this.b = ue7Var;
        ue7Var.F(true);
        ve7 ve7Var = new ve7(frsActivity);
        this.c = ve7Var;
        ve7Var.F(true);
        PriorityOrganizer.r(this.b, this.c);
        setPriority(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921728) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            BdUniqueId bdUniqueId = null;
            if (currentActivity instanceof BdBaseFragmentActivity) {
                bdUniqueId = ((BdBaseFragmentActivity) currentActivity).getUniqueId();
            }
            if (getTag() == bdUniqueId && !this.b.v(true)) {
                this.b.E(true);
                this.a.s0().w(this.b);
            }
        }
    }
}

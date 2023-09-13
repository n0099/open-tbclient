package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.bj7;
import com.baidu.tieba.cg7;
import com.baidu.tieba.cj7;
import com.baidu.tieba.eg7;
import com.baidu.tieba.fg7;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.gg7;
import com.baidu.tieba.hg7;
import com.baidu.tieba.ig7;
import com.baidu.tieba.ii7;
import com.baidu.tieba.jg7;
import com.baidu.tieba.kg7;
import com.baidu.tieba.vf7;
import com.baidu.tieba.wf7;
import com.baidu.tieba.xf7;
import com.baidu.tieba.yf7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsMemberStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                absDelegateAdapterList.add(new fg7(null, gg7.d));
                absDelegateAdapterList.add(new hg7(null, ig7.c));
                absDelegateAdapterList.add(new eg7(null, ii7.c));
                absDelegateAdapterList.add(new vf7(null, wf7.b));
                absDelegateAdapterList.add(new xf7(null, yf7.g));
                absDelegateAdapterList.add(new jg7(null, kg7.e));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof bj7)) {
                bj7 bj7Var = (bj7) customResponsedMessage.getData();
                cg7 cg7Var = new cg7();
                cg7Var.C(bj7Var.a);
                bj7Var.a(3, cg7Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390998753, "Lcom/baidu/tieba/forumMember/member/FrsMemberStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-390998753, "Lcom/baidu/tieba/forumMember/member/FrsMemberStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(ForumMemberActivityConfig.class, ForumMemberActivity.class);
        cj7.a().c(3);
        MessageManager.getInstance().registerListener(new a(2003008));
        MessageManager.getInstance().registerListener(new b(2003011));
    }

    public FrsMemberStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

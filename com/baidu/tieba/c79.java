package com.baidu.tieba;

import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment a;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c79 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c79 c79Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c79Var, Integer.valueOf(i)};
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
            this.a = c79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] iArr;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof int[]) && (iArr = (int[]) customResponsedMessage.getData()) != null && iArr.length == 2) {
                int i = iArr[0];
                int i2 = iArr[1];
                if (this.a.a.getPageContext() != null) {
                    this.a.d(i2);
                }
            }
        }
    }

    public c79(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseFragment;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a == null) {
            return;
        }
        this.a.registerListener(new a(this, 2921700));
    }

    public final void d(int i) {
        BaseFragment baseFragment;
        dga j;
        dga j2;
        dga j3;
        dga j4;
        dga j5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (baseFragment = this.a) == null) {
            return;
        }
        FragmentActivity fragmentActivity = baseFragment.getFragmentActivity();
        TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
        if (fragmentActivity != null && pageContext != null) {
            if (i == 3 && (j5 = PushGuideManager.j("reply_message_bar")) != null) {
                j5.j(pageContext);
            }
            if (i == 6 && (j4 = PushGuideManager.j("at_message_bar")) != null) {
                j4.j(pageContext);
            }
            if (i == 7 && (j3 = PushGuideManager.j("agree_message_bar")) != null) {
                j3.j(pageContext);
            }
            if (i == 8 && (j2 = PushGuideManager.j("fan_message_bar")) != null) {
                j2.j(pageContext);
            }
            if (i == 2 && (j = PushGuideManager.j("im")) != null) {
                j.j(pageContext);
            }
        }
    }
}

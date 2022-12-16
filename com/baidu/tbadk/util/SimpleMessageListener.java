package com.baidu.tbadk.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class SimpleMessageListener implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public CustomMessageListener a;
    public boolean b;

    /* loaded from: classes3.dex */
    public interface b<T> {
        void call(@Nullable T t);
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SimpleMessageListener simpleMessageListener, int i, b bVar) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleMessageListener, Integer.valueOf(i), bVar};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.call(customResponsedMessage.getData());
        }
    }

    public SimpleMessageListener(int i, boolean z, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = z;
        this.a = new a(this, i, bVar);
    }

    public static <T> void b(int i, @Nullable TbPageContext<?> tbPageContext, @Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65537, null, i, tbPageContext, t) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(i, t);
            if (tbPageContext != null) {
                CustomMessage customMessage = new CustomMessage(i, tbPageContext.getUniqueId());
                customMessage.setData(t);
                customResponsedMessage.setOrginalMessage(customMessage);
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public static <T> void c(int i, @Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i, t) == null) {
            b(i, null, t);
        }
    }

    public void a(@NonNull TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.a.setSelfListener(true);
            this.a.setTag(tbPageContext.getUniqueId());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.b) {
            MessageManager.getInstance().registerListener(this.a);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.b) {
            MessageManager.getInstance().unRegisterListener(this.a);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b) {
            MessageManager.getInstance().unRegisterListener(this.a);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b) {
            MessageManager.getInstance().registerListener(this.a);
        }
    }
}

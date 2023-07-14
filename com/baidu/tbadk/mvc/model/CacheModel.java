package com.baidu.tbadk.mvc.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.as5;
import com.baidu.tieba.bs5;
import com.baidu.tieba.l9;
import com.baidu.tieba.ns5;
import com.baidu.tieba.os5;
import com.baidu.tieba.zu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class CacheModel<T extends as5, ActivityType> extends BdBaseModel<ActivityType> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageListener<CustomResponsedMessage<?>> a;
    public MessageListener<CustomResponsedMessage<?>> b;
    public c<T> c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* loaded from: classes4.dex */
    public interface c<T> {
        void m(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);

        void r(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);
    }

    public abstract String U();

    public abstract Class<T> h0();

    public abstract int i0();

    public abstract int j0();

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    public final boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(ReadCacheMessage<T> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, readCacheMessage) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CacheModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CacheModel cacheModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheModel, Integer.valueOf(i)};
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
            this.a = cacheModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.h = false;
                if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                    ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                    ReadCacheMessage readCacheMessage = null;
                    if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                        readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                    }
                    if (this.a.c != null) {
                        this.a.c.r(readCacheRespMsg, readCacheMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CacheModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CacheModel cacheModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheModel, Integer.valueOf(i)};
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
            this.a = cacheModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.i = false;
                if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                    WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                    WriteCacheMessage writeCacheMessage = null;
                    if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                        writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                    }
                    if (this.a.c != null) {
                        this.a.c.m(writeCacheRespMsg, writeCacheMessage);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheModel(TbPageContext<ActivityType> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
    }

    public final void m0(bs5 bs5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bs5Var) == null) {
            b0();
            ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(i0());
            readCacheMessage.setTag(getUniqueId());
            readCacheMessage.setRequestData(bs5Var);
            readCacheMessage.setNeedUid(k0());
            n0(readCacheMessage);
            c0();
            sendMessage(readCacheMessage);
        }
    }

    public final void Y(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            d0();
            Z(t);
        }
    }

    public final void Z(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            WriteCacheMessage writeCacheMessage = new WriteCacheMessage(j0());
            writeCacheMessage.setTag(getUniqueId());
            writeCacheMessage.setData(t);
            e0();
            sendMessage(writeCacheMessage);
        }
    }

    public final void a0(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            Z(t);
        }
    }

    public void o0(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.c = cVar;
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.f) {
            if (this.a == null) {
                a aVar = new a(this, i0());
                this.a = aVar;
                aVar.setSelfListener(true);
                this.a.setTag(this.unique_id);
            }
            registerListener(this.a);
            this.f = true;
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.d && MessageManager.getInstance().findTask(i0()) == null) {
            MessageManager.getInstance().registerTask(new zu5(i0(), new ns5(i0(), U(), h0())));
            this.d = true;
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.g) {
            if (this.b == null) {
                b bVar = new b(this, j0());
                this.b = bVar;
                bVar.setSelfListener(true);
                this.b.setTag(this.unique_id);
            }
            registerListener(this.b);
            this.g = true;
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.e && MessageManager.getInstance().findTask(j0()) == null) {
            MessageManager.getInstance().registerTask(new zu5(j0(), new os5(j0(), U(), h0())));
            this.e = true;
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b0();
            ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(i0());
            readCacheMessage.setTag(getUniqueId());
            readCacheMessage.setNeedUid(k0());
            n0(readCacheMessage);
            c0();
            sendMessage(readCacheMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            MessageManager.getInstance().removeCustomMessage(getUniqueId());
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d0();
            g0();
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            WriteCacheMessage writeCacheMessage = new WriteCacheMessage(j0());
            writeCacheMessage.setClear(true);
            writeCacheMessage.setTag(getUniqueId());
            e0();
            sendMessage(writeCacheMessage);
        }
    }
}

package com.baidu.tbadk.mvc.model;

import c.a.e.a.f;
import c.a.q0.k0.b.c;
import c.a.q0.k0.e.d;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class CacheModel<T extends c.a.q0.k0.b.c, ActivityType> extends BdBaseModel<ActivityType> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MessageListener<CustomResponsedMessage<?>> f48422e;

    /* renamed from: f  reason: collision with root package name */
    public MessageListener<CustomResponsedMessage<?>> f48423f;

    /* renamed from: g  reason: collision with root package name */
    public c<T> f48424g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48425h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48426i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f48427j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CacheModel f48428a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CacheModel cacheModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48428a = cacheModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f48428a.l = false;
                if (customResponsedMessage == null || !(customResponsedMessage instanceof ReadCacheRespMsg)) {
                    return;
                }
                ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                ReadCacheMessage readCacheMessage = null;
                if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                    readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                }
                if (this.f48428a.f48424g != null) {
                    this.f48428a.f48424g.onCacheDataGet(readCacheRespMsg, readCacheMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CacheModel f48429a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CacheModel cacheModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48429a = cacheModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f48429a.m = false;
                if (customResponsedMessage == null || !(customResponsedMessage instanceof WriteCacheRespMsg)) {
                    return;
                }
                WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                WriteCacheMessage writeCacheMessage = null;
                if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                    writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                }
                if (this.f48429a.f48424g != null) {
                    this.f48429a.f48424g.onCacheDataWrite(writeCacheRespMsg, writeCacheMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48425h = false;
        this.f48426i = false;
        this.f48427j = false;
        this.k = false;
    }

    public final void A(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            z(t);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f48427j) {
            return;
        }
        if (this.f48422e == null) {
            a aVar = new a(this, I());
            this.f48422e = aVar;
            aVar.setSelfListener(true);
            this.f48422e.setTag(this.unique_id);
        }
        registerListener(this.f48422e);
        this.f48427j = true;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.f48425h && MessageManager.getInstance().findTask(I()) == null) {
            MessageManager.getInstance().registerTask(new c.a.q0.z0.a(I(), new c.a.q0.k0.e.c(I(), v(), H())));
            this.f48425h = true;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.k) {
            return;
        }
        if (this.f48423f == null) {
            b bVar = new b(this, J());
            this.f48423f = bVar;
            bVar.setSelfListener(true);
            this.f48423f.setTag(this.unique_id);
        }
        registerListener(this.f48423f);
        this.k = true;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.f48426i && MessageManager.getInstance().findTask(J()) == null) {
            MessageManager.getInstance().registerTask(new c.a.q0.z0.a(J(), new d(J(), v(), H())));
            this.f48426i = true;
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            D();
            G();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WriteCacheMessage writeCacheMessage = new WriteCacheMessage(J());
            writeCacheMessage.setClear(true);
            writeCacheMessage.setTag(getUniqueId());
            E();
            sendMessage(writeCacheMessage);
        }
    }

    public abstract Class<T> H();

    public abstract int I();

    public abstract int J();

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            B();
            ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(I());
            readCacheMessage.setTag(getUniqueId());
            readCacheMessage.setNeedUid(K());
            N(readCacheMessage);
            C();
            sendMessage(readCacheMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    public final boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void M(c.a.q0.k0.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            B();
            ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(I());
            readCacheMessage.setTag(getUniqueId());
            readCacheMessage.setRequestData(dVar);
            readCacheMessage.setNeedUid(K());
            N(readCacheMessage);
            C();
            sendMessage(readCacheMessage);
        }
    }

    public void N(ReadCacheMessage<T> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, readCacheMessage) == null) {
        }
    }

    public void O(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.f48424g = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            MessageManager.getInstance().removeCustomMessage(getUniqueId());
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract String v();

    public final void z(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, t) == null) {
            WriteCacheMessage writeCacheMessage = new WriteCacheMessage(J());
            writeCacheMessage.setTag(getUniqueId());
            writeCacheMessage.setData(t);
            E();
            sendMessage(writeCacheMessage);
        }
    }
}

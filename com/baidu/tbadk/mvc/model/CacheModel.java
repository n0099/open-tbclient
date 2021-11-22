package com.baidu.tbadk.mvc.model;

import b.a.e.a.f;
import b.a.q0.k0.b.c;
import b.a.q0.k0.e.d;
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
/* loaded from: classes8.dex */
public abstract class CacheModel<T extends b.a.q0.k0.b.c, ActivityType> extends BdBaseModel<ActivityType> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MessageListener<CustomResponsedMessage<?>> f46832e;

    /* renamed from: f  reason: collision with root package name */
    public MessageListener<CustomResponsedMessage<?>> f46833f;

    /* renamed from: g  reason: collision with root package name */
    public c<T> f46834g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46835h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46836i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CacheModel f46837a;

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
            this.f46837a = cacheModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f46837a.l = false;
                if (customResponsedMessage == null || !(customResponsedMessage instanceof ReadCacheRespMsg)) {
                    return;
                }
                ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                ReadCacheMessage readCacheMessage = null;
                if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                    readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                }
                if (this.f46837a.f46834g != null) {
                    this.f46837a.f46834g.onCacheDataGet(readCacheRespMsg, readCacheMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CacheModel f46838a;

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
            this.f46838a = cacheModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f46838a.m = false;
                if (customResponsedMessage == null || !(customResponsedMessage instanceof WriteCacheRespMsg)) {
                    return;
                }
                WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                WriteCacheMessage writeCacheMessage = null;
                if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                    writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                }
                if (this.f46838a.f46834g != null) {
                    this.f46838a.f46834g.onCacheDataWrite(writeCacheRespMsg, writeCacheMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f46835h = false;
        this.f46836i = false;
        this.j = false;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.j) {
            return;
        }
        if (this.f46832e == null) {
            a aVar = new a(this, I());
            this.f46832e = aVar;
            aVar.setSelfListener(true);
            this.f46832e.setTag(this.unique_id);
        }
        registerListener(this.f46832e);
        this.j = true;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.f46835h && MessageManager.getInstance().findTask(I()) == null) {
            MessageManager.getInstance().registerTask(new b.a.q0.y0.a(I(), new b.a.q0.k0.e.c(I(), v(), H())));
            this.f46835h = true;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.k) {
            return;
        }
        if (this.f46833f == null) {
            b bVar = new b(this, J());
            this.f46833f = bVar;
            bVar.setSelfListener(true);
            this.f46833f.setTag(this.unique_id);
        }
        registerListener(this.f46833f);
        this.k = true;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.f46836i && MessageManager.getInstance().findTask(J()) == null) {
            MessageManager.getInstance().registerTask(new b.a.q0.y0.a(J(), new d(J(), v(), H())));
            this.f46836i = true;
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

    public final void M(b.a.q0.k0.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048589, this, readCacheMessage) == null) {
        }
    }

    public void O(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.f46834g = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            MessageManager.getInstance().removeCustomMessage(getUniqueId());
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

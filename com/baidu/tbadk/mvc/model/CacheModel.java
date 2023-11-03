package com.baidu.tbadk.mvc.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
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
import com.baidu.tieba.bq5;
import com.baidu.tieba.nn5;
import com.baidu.tieba.on5;
import com.baidu.tieba.wn5;
import com.baidu.tieba.xn5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class CacheModel<T extends nn5, ActivityType> extends BdBaseModel<ActivityType> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CacheModelCallback<T> callback;
    public boolean hadCheckReadListener;
    public boolean hadCheckReadTask;
    public boolean hadCheckWriteListener;
    public boolean hadCheckWriteTask;
    public boolean isReading;
    public boolean isWriting;
    public MessageListener<CustomResponsedMessage<?>> readListener;
    public MessageListener<CustomResponsedMessage<?>> writeListener;

    /* loaded from: classes5.dex */
    public interface CacheModelCallback<T> {
        void onCacheDataGet(ReadCacheRespMsg<List<T>> readCacheRespMsg, ReadCacheMessage<T> readCacheMessage);

        void onCacheDataWrite(WriteCacheRespMsg<List<T>> writeCacheRespMsg, WriteCacheMessage<T> writeCacheMessage);
    }

    public abstract Class<T> getCacheDataClassName();

    public abstract String getCacheTableName();

    public abstract int getReadCacheCmd();

    public abstract int getWriteCacheCmd();

    public boolean isUidNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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

    public void processReadCacheMessage(ReadCacheMessage<T> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, readCacheMessage) == null) {
        }
    }

    public void processWriteCacheMessage(WriteCacheMessage<T> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, writeCacheMessage) == null) {
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.isReading = false;
                if (customResponsedMessage != null && (customResponsedMessage instanceof ReadCacheRespMsg)) {
                    ReadCacheRespMsg readCacheRespMsg = (ReadCacheRespMsg) customResponsedMessage;
                    ReadCacheMessage readCacheMessage = null;
                    if (readCacheRespMsg.getOrginalMessage() != null && (readCacheRespMsg.getOrginalMessage() instanceof ReadCacheMessage)) {
                        readCacheMessage = (ReadCacheMessage) readCacheRespMsg.getOrginalMessage();
                    }
                    if (this.a.callback != null) {
                        this.a.callback.onCacheDataGet(readCacheRespMsg, readCacheMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.isWriting = false;
                if (customResponsedMessage != null && (customResponsedMessage instanceof WriteCacheRespMsg)) {
                    WriteCacheRespMsg writeCacheRespMsg = (WriteCacheRespMsg) customResponsedMessage;
                    WriteCacheMessage writeCacheMessage = null;
                    if (writeCacheRespMsg.getOrginalMessage() != null && (writeCacheRespMsg.getOrginalMessage() instanceof WriteCacheMessage)) {
                        writeCacheMessage = (WriteCacheMessage) writeCacheRespMsg.getOrginalMessage();
                    }
                    if (this.a.callback != null) {
                        this.a.callback.onCacheDataWrite(writeCacheRespMsg, writeCacheMessage);
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
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hadCheckReadTask = false;
        this.hadCheckWriteTask = false;
        this.hadCheckReadListener = false;
        this.hadCheckWriteListener = false;
        this.isReading = false;
        this.isWriting = false;
    }

    public final void loadSingleCache(on5 on5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, on5Var) == null) {
            this.isReading = true;
            checkReadListener();
            ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(getReadCacheCmd());
            readCacheMessage.setTag(getUniqueId());
            readCacheMessage.setRequestData(on5Var);
            readCacheMessage.setNeedUid(isUidNeed());
            processReadCacheMessage(readCacheMessage);
            checkReadTask();
            sendMessage(readCacheMessage);
        }
    }

    private final void addCacheInner(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, t) == null) {
            WriteCacheMessage writeCacheMessage = new WriteCacheMessage(getWriteCacheCmd());
            writeCacheMessage.setTag(getUniqueId());
            writeCacheMessage.setData(t);
            checkWriteTask();
            sendMessage(writeCacheMessage);
        }
    }

    private final void deleteCacheInner(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, t) == null) {
            WriteCacheMessage writeCacheMessage = new WriteCacheMessage(getWriteCacheCmd());
            writeCacheMessage.setClear(true);
            writeCacheMessage.setTag(getUniqueId());
            writeCacheMessage.setData(t);
            checkWriteTask();
            sendMessage(writeCacheMessage);
        }
    }

    public final void addCache(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            this.isWriting = true;
            checkWriteListener();
            addCacheInner(t);
        }
    }

    public final void addCacheNoListener(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            addCacheInner(t);
        }
    }

    public final void deleteCache(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
            this.isWriting = true;
            checkWriteListener();
            deleteCacheInner(t);
        }
    }

    public final void deleteCacheNoListener(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            deleteCacheInner(t);
        }
    }

    public void setCallback(CacheModelCallback<T> cacheModelCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cacheModelCallback) == null) {
            this.callback = cacheModelCallback;
        }
    }

    private void checkReadListener() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && !this.hadCheckReadListener) {
            if (this.readListener == null) {
                a aVar = new a(this, getReadCacheCmd());
                this.readListener = aVar;
                aVar.setSelfListener(true);
                this.readListener.setTag(this.unique_id);
            }
            registerListener(this.readListener);
            this.hadCheckReadListener = true;
        }
    }

    private void checkReadTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && !this.hadCheckReadTask && MessageManager.getInstance().findTask(getReadCacheCmd()) == null) {
            MessageManager.getInstance().registerTask(new bq5(getReadCacheCmd(), new wn5(getReadCacheCmd(), getCacheTableName(), getCacheDataClassName())));
            this.hadCheckReadTask = true;
        }
    }

    private void checkWriteListener() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && !this.hadCheckWriteListener) {
            if (this.writeListener == null) {
                b bVar = new b(this, getWriteCacheCmd());
                this.writeListener = bVar;
                bVar.setSelfListener(true);
                this.writeListener.setTag(this.unique_id);
            }
            registerListener(this.writeListener);
            this.hadCheckWriteListener = true;
        }
    }

    private void checkWriteTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && !this.hadCheckWriteTask && MessageManager.getInstance().findTask(getWriteCacheCmd()) == null) {
            MessageManager.getInstance().registerTask(new bq5(getWriteCacheCmd(), new xn5(getWriteCacheCmd(), getCacheTableName(), getCacheDataClassName())));
            this.hadCheckWriteTask = true;
        }
    }

    public final void loadCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.isReading = true;
            checkReadListener();
            ReadCacheMessage<T> readCacheMessage = new ReadCacheMessage<>(getReadCacheCmd());
            readCacheMessage.setTag(getUniqueId());
            readCacheMessage.setNeedUid(isUidNeed());
            processReadCacheMessage(readCacheMessage);
            checkReadTask();
            sendMessage(readCacheMessage);
            this.isReading = true;
        }
    }

    private final void clearCacheInner() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            WriteCacheMessage writeCacheMessage = new WriteCacheMessage(getWriteCacheCmd());
            writeCacheMessage.setClear(true);
            writeCacheMessage.setTag(getUniqueId());
            checkWriteTask();
            sendMessage(writeCacheMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MessageManager.getInstance().removeCustomMessage(getUniqueId());
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void clearCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.isWriting = true;
            checkWriteListener();
            clearCacheInner();
        }
    }

    public final void clearCacheNoListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            clearCacheInner();
        }
    }

    public CacheModelCallback<T> getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.callback;
        }
        return (CacheModelCallback) invokeV.objValue;
    }

    public boolean isReading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isReading;
        }
        return invokeV.booleanValue;
    }

    public boolean isWriting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.isWriting;
        }
        return invokeV.booleanValue;
    }
}

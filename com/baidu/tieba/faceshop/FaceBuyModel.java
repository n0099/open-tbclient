package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.faceshop.FaceBuyQueryData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class FaceBuyModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f14889e;

    /* renamed from: f  reason: collision with root package name */
    public b f14890f;

    /* renamed from: g  reason: collision with root package name */
    public int f14891g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14895a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceBuyModel f14896b;

        public c(FaceBuyModel faceBuyModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14896b = faceBuyModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceBuyData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String obj = objArr[0].toString();
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.BUY_FACE_PACKAGE_URL);
                    this.f14895a = netWork;
                    netWork.addPostData("pid", obj);
                    return (FaceBuyData) OrmObject.objectWithJsonStr(this.f14895a.postNetData(), FaceBuyData.class);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    return null;
                }
            }
            return (FaceBuyData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FaceBuyData faceBuyData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, faceBuyData) == null) {
                super.onPostExecute(faceBuyData);
                this.f14896b.f14889e = null;
                this.f14896b.mLoadDataCallBack.c(faceBuyData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f14895a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f14896b.f14889e = null;
                this.f14896b.mLoadDataCallBack.c(null);
            }
        }

        public /* synthetic */ c(FaceBuyModel faceBuyModel, a aVar) {
            this(faceBuyModel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceBuyModel(Context context) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f14891g = 3;
        this.f14889e = null;
        this.f14890f = null;
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f14889e == null) {
            c cVar = new c(this, null);
            this.f14889e = cVar;
            cVar.setPriority(3);
            this.f14889e.execute(str);
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f14890f == null) {
            b bVar = new b(this, null);
            this.f14890f = bVar;
            bVar.setPriority(3);
            this.f14890f.execute(str);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = this.f14889e;
            if (cVar != null) {
                cVar.cancel();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14892a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f14893b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceBuyModel f14894c;

        public b(FaceBuyModel faceBuyModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceBuyModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14894c = faceBuyModel;
            this.f14893b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceBuyQueryData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            FaceBuyQueryData.BuyResult buyResult;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String obj = objArr[0].toString();
                FaceBuyQueryData faceBuyQueryData = null;
                if (!k.isEmpty(obj)) {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.QUERY_BUY_RESULT_URL);
                    this.f14892a = netWork;
                    netWork.addPostData("order_id", obj);
                    for (int i2 = 0; !this.f14893b && i2 < this.f14894c.f14891g; i2++) {
                        faceBuyQueryData = (FaceBuyQueryData) OrmObject.objectWithJsonStr(this.f14892a.postNetData(), FaceBuyQueryData.class);
                        if (faceBuyQueryData != null && (buyResult = faceBuyQueryData.buy_result) != null) {
                            if (buyResult.status == 2) {
                                break;
                            }
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e2) {
                                BdLog.detailException(e2);
                            }
                        } else {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e3) {
                                BdLog.detailException(e3);
                            }
                        }
                    }
                }
                return faceBuyQueryData;
            }
            return (FaceBuyQueryData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FaceBuyQueryData faceBuyQueryData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, faceBuyQueryData) == null) {
                super.onPostExecute(faceBuyQueryData);
                this.f14894c.f14890f = null;
                this.f14893b = true;
                this.f14894c.mLoadDataCallBack.c(faceBuyQueryData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f14892a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f14894c.f14890f = null;
                this.f14894c.mLoadDataCallBack.c(null);
            }
        }

        public /* synthetic */ b(FaceBuyModel faceBuyModel, a aVar) {
            this(faceBuyModel);
        }
    }
}

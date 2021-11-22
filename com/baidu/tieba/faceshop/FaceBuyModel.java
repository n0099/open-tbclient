package com.baidu.tieba.faceshop;

import android.content.Context;
import b.a.e.a.f;
import b.a.e.f.p.k;
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
/* loaded from: classes9.dex */
public class FaceBuyModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f48738e;

    /* renamed from: f  reason: collision with root package name */
    public b f48739f;

    /* renamed from: g  reason: collision with root package name */
    public int f48740g;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<Object, FaceBuyData, FaceBuyData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f48744a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceBuyModel f48745b;

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
            this.f48745b = faceBuyModel;
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
                    this.f48744a = netWork;
                    netWork.addPostData("pid", obj);
                    return (FaceBuyData) OrmObject.objectWithJsonStr(this.f48744a.postNetData(), FaceBuyData.class);
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
                this.f48745b.f48738e = null;
                this.f48745b.mLoadDataCallBack.c(faceBuyData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f48744a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f48745b.f48738e = null;
                this.f48745b.mLoadDataCallBack.c(null);
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
        this.f48740g = 3;
        this.f48738e = null;
        this.f48739f = null;
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f48738e == null) {
            c cVar = new c(this, null);
            this.f48738e = cVar;
            cVar.setPriority(3);
            this.f48738e.execute(str);
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f48739f == null) {
            b bVar = new b(this, null);
            this.f48739f = bVar;
            bVar.setPriority(3);
            this.f48739f.execute(str);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = this.f48738e;
            if (cVar != null) {
                cVar.cancel();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, FaceBuyQueryData, FaceBuyQueryData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f48741a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f48742b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FaceBuyModel f48743c;

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
            this.f48743c = faceBuyModel;
            this.f48742b = false;
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
                    this.f48741a = netWork;
                    netWork.addPostData("order_id", obj);
                    for (int i2 = 0; !this.f48742b && i2 < this.f48743c.f48740g; i2++) {
                        faceBuyQueryData = (FaceBuyQueryData) OrmObject.objectWithJsonStr(this.f48741a.postNetData(), FaceBuyQueryData.class);
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
                this.f48743c.f48739f = null;
                this.f48742b = true;
                this.f48743c.mLoadDataCallBack.c(faceBuyQueryData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f48741a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f48743c.f48739f = null;
                this.f48743c.mLoadDataCallBack.c(null);
            }
        }

        public /* synthetic */ b(FaceBuyModel faceBuyModel, a aVar) {
            this(faceBuyModel);
        }
    }
}

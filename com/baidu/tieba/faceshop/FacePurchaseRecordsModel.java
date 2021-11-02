package com.baidu.tieba.faceshop;

import android.app.Application;
import android.content.Context;
import b.a.e.a.f;
import b.a.e.e.p.l;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FacePurchaseRecordsModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f47928e;

    /* renamed from: f  reason: collision with root package name */
    public String f47929f;

    /* renamed from: g  reason: collision with root package name */
    public int f47930g;

    /* renamed from: h  reason: collision with root package name */
    public int f47931h;

    /* renamed from: i  reason: collision with root package name */
    public float f47932i;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f47933a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsModel f47934b;

        public b(FacePurchaseRecordsModel facePurchaseRecordsModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePurchaseRecordsModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47934b = facePurchaseRecordsModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePurchaseRecordsData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_PURCHASE_RECORDS);
                    this.f47933a = netWork;
                    netWork.addPostData("st_type", this.f47934b.f47929f);
                    this.f47933a.addPostData("scr_w", String.valueOf(this.f47934b.f47930g));
                    this.f47933a.addPostData("scr_h", String.valueOf(this.f47934b.f47931h));
                    this.f47933a.addPostData("scr_dip", String.valueOf(this.f47934b.f47932i));
                    return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.f47933a.postNetData(), FacePurchaseRecordsData.class);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    return null;
                }
            }
            return (FacePurchaseRecordsData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePurchaseRecordsData facePurchaseRecordsData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, facePurchaseRecordsData) == null) {
                this.f47934b.f47928e = null;
                this.f47934b.mLoadDataCallBack.c(facePurchaseRecordsData);
                super.onPostExecute(facePurchaseRecordsData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f47933a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f47934b.f47928e = null;
            }
        }

        public /* synthetic */ b(FacePurchaseRecordsModel facePurchaseRecordsModel, a aVar) {
            this(facePurchaseRecordsModel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacePurchaseRecordsModel(Context context) {
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
        this.f47930g = 0;
        this.f47931h = 0;
        Application app = TbadkApplication.getInst().getApp();
        this.f47930g = l.k(app);
        this.f47931h = l.i(app);
        this.f47932i = app.getResources().getDisplayMetrics().density;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = this.f47928e;
            if (bVar != null) {
                bVar.cancel();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f47928e == null) {
                b bVar = new b(this, null);
                this.f47928e = bVar;
                bVar.setPriority(3);
                this.f47928e.execute(new Object[0]);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f47929f = str;
        }
    }
}

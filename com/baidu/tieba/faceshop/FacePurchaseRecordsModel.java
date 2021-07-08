package com.baidu.tieba.faceshop;

import android.app.Application;
import android.content.Context;
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
import d.a.c.a.f;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FacePurchaseRecordsModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f14981e;

    /* renamed from: f  reason: collision with root package name */
    public String f14982f;

    /* renamed from: g  reason: collision with root package name */
    public int f14983g;

    /* renamed from: h  reason: collision with root package name */
    public int f14984h;

    /* renamed from: i  reason: collision with root package name */
    public float f14985i;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, FacePurchaseRecordsData, FacePurchaseRecordsData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14986a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsModel f14987b;

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
            this.f14987b = facePurchaseRecordsModel;
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
                    this.f14986a = netWork;
                    netWork.addPostData("st_type", this.f14987b.f14982f);
                    this.f14986a.addPostData("scr_w", String.valueOf(this.f14987b.f14983g));
                    this.f14986a.addPostData("scr_h", String.valueOf(this.f14987b.f14984h));
                    this.f14986a.addPostData("scr_dip", String.valueOf(this.f14987b.f14985i));
                    return (FacePurchaseRecordsData) OrmObject.objectWithJsonStr(this.f14986a.postNetData(), FacePurchaseRecordsData.class);
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
                this.f14987b.f14981e = null;
                this.f14987b.mLoadDataCallBack.c(facePurchaseRecordsData);
                super.onPostExecute(facePurchaseRecordsData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f14986a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f14987b.f14981e = null;
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
        this.f14983g = 0;
        this.f14984h = 0;
        Application app = TbadkApplication.getInst().getApp();
        this.f14983g = l.k(app);
        this.f14984h = l.i(app);
        this.f14985i = app.getResources().getDisplayMetrics().density;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f14981e == null) {
            b bVar = new b(this, null);
            this.f14981e = bVar;
            bVar.setPriority(3);
            this.f14981e.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.f14981e;
            if (bVar != null) {
                bVar.cancel();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f14982f = str;
        }
    }
}

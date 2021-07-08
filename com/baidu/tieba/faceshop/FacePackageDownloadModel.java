package com.baidu.tieba.faceshop;

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
public class FacePackageDownloadModel extends BdBaseModel<FacePackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f14965e;

    /* renamed from: f  reason: collision with root package name */
    public FacePackageDownloadData f14966f;

    /* renamed from: g  reason: collision with root package name */
    public int f14967g;

    /* renamed from: h  reason: collision with root package name */
    public int f14968h;

    /* renamed from: i  reason: collision with root package name */
    public float f14969i;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14970a;

        /* renamed from: b  reason: collision with root package name */
        public String f14971b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FacePackageDownloadModel f14972c;

        public a(FacePackageDownloadModel facePackageDownloadModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDownloadModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14972c = facePackageDownloadModel;
            this.f14971b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    if (this.f14971b != null && this.f14971b.length() > 0) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                        this.f14970a = netWork;
                        netWork.addPostData("pid", this.f14971b);
                        this.f14970a.addPostData("scr_w", String.valueOf(this.f14972c.f14967g));
                        this.f14970a.addPostData("scr_h", String.valueOf(this.f14972c.f14968h));
                        this.f14970a.addPostData("scr_dip", String.valueOf(this.f14972c.f14969i));
                        this.f14972c.f14966f = (FacePackageDownloadData) OrmObject.objectWithJsonStr(this.f14970a.postNetData(), FacePackageDownloadData.class);
                    }
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                return this.f14972c.f14966f;
            }
            return (FacePackageDownloadData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, facePackageDownloadData) == null) {
                this.f14972c.f14965e = null;
                this.f14972c.mLoadDataCallBack.c(facePackageDownloadData);
                super.onPostExecute(facePackageDownloadData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f14970a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f14970a = null;
                }
                this.f14972c.f14965e = null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacePackageDownloadModel(Context context) {
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
        this.f14966f = null;
        this.f14967g = 0;
        this.f14968h = 0;
        this.f14965e = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f14967g = l.k(inst);
        this.f14968h = l.i(inst);
        this.f14969i = inst.getResources().getDisplayMetrics().density;
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f14965e == null) {
            a aVar = new a(this, str);
            this.f14965e = aVar;
            aVar.setPriority(3);
            this.f14965e.execute(new Object[0]);
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
            a aVar = this.f14965e;
            if (aVar != null) {
                aVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}

package com.baidu.tieba.faceshop;

import android.content.Context;
import c.a.d.a.f;
import c.a.d.f.p.l;
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
/* loaded from: classes10.dex */
public class FacePackageDownloadModel extends BdBaseModel<FacePackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f43762e;

    /* renamed from: f  reason: collision with root package name */
    public FacePackageDownloadData f43763f;

    /* renamed from: g  reason: collision with root package name */
    public int f43764g;

    /* renamed from: h  reason: collision with root package name */
    public int f43765h;

    /* renamed from: i  reason: collision with root package name */
    public float f43766i;

    /* loaded from: classes10.dex */
    public class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f43767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FacePackageDownloadModel f43768c;

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
            this.f43768c = facePackageDownloadModel;
            this.f43767b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    if (this.f43767b != null && this.f43767b.length() > 0) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                        this.a = netWork;
                        netWork.addPostData("pid", this.f43767b);
                        this.a.addPostData("scr_w", String.valueOf(this.f43768c.f43764g));
                        this.a.addPostData("scr_h", String.valueOf(this.f43768c.f43765h));
                        this.a.addPostData("scr_dip", String.valueOf(this.f43768c.f43766i));
                        this.f43768c.f43763f = (FacePackageDownloadData) OrmObject.objectWithJsonStr(this.a.postNetData(), FacePackageDownloadData.class);
                    }
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                return this.f43768c.f43763f;
            }
            return (FacePackageDownloadData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, facePackageDownloadData) == null) {
                this.f43768c.f43762e = null;
                this.f43768c.mLoadDataCallBack.c(facePackageDownloadData);
                super.onPostExecute(facePackageDownloadData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                this.f43768c.f43762e = null;
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
        this.f43763f = null;
        this.f43764g = 0;
        this.f43765h = 0;
        this.f43762e = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f43764g = l.k(inst);
        this.f43765h = l.i(inst);
        this.f43766i = inst.getResources().getDisplayMetrics().density;
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f43762e == null) {
            a aVar = new a(this, str);
            this.f43762e = aVar;
            aVar.setPriority(3);
            this.f43762e.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f43762e;
            if (aVar != null) {
                aVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}

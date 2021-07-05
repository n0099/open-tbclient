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
/* loaded from: classes5.dex */
public class FacePackageDownloadModel extends BdBaseModel<FacePackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f14926e;

    /* renamed from: f  reason: collision with root package name */
    public FacePackageDownloadData f14927f;

    /* renamed from: g  reason: collision with root package name */
    public int f14928g;

    /* renamed from: h  reason: collision with root package name */
    public int f14929h;

    /* renamed from: i  reason: collision with root package name */
    public float f14930i;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Object, FacePackageDownloadData, FacePackageDownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14931a;

        /* renamed from: b  reason: collision with root package name */
        public String f14932b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FacePackageDownloadModel f14933c;

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
            this.f14933c = facePackageDownloadModel;
            this.f14932b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FacePackageDownloadData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    if (this.f14932b != null && this.f14932b.length() > 0) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DOWNLOAD_URL);
                        this.f14931a = netWork;
                        netWork.addPostData("pid", this.f14932b);
                        this.f14931a.addPostData("scr_w", String.valueOf(this.f14933c.f14928g));
                        this.f14931a.addPostData("scr_h", String.valueOf(this.f14933c.f14929h));
                        this.f14931a.addPostData("scr_dip", String.valueOf(this.f14933c.f14930i));
                        this.f14933c.f14927f = (FacePackageDownloadData) OrmObject.objectWithJsonStr(this.f14931a.postNetData(), FacePackageDownloadData.class);
                    }
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                return this.f14933c.f14927f;
            }
            return (FacePackageDownloadData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FacePackageDownloadData facePackageDownloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, facePackageDownloadData) == null) {
                this.f14933c.f14926e = null;
                this.f14933c.mLoadDataCallBack.c(facePackageDownloadData);
                super.onPostExecute(facePackageDownloadData);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f14931a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f14931a = null;
                }
                this.f14933c.f14926e = null;
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
        this.f14927f = null;
        this.f14928g = 0;
        this.f14929h = 0;
        this.f14926e = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f14928g = l.k(inst);
        this.f14929h = l.i(inst);
        this.f14930i = inst.getResources().getDisplayMetrics().density;
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f14926e == null) {
            a aVar = new a(this, str);
            this.f14926e = aVar;
            aVar.setPriority(3);
            this.f14926e.execute(new Object[0]);
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
            a aVar = this.f14926e;
            if (aVar != null) {
                aVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}

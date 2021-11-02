package com.baidu.tieba.faceshop;

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
public class FaceShopModel extends BdBaseModel<FaceShopActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_NEXT = 2;
    public static final int LOAD_REFRESH = 1;
    public static final int PAGE_MAX_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FaceShopData f47947e;

    /* renamed from: f  reason: collision with root package name */
    public b f47948f;

    /* renamed from: g  reason: collision with root package name */
    public int f47949g;

    /* renamed from: h  reason: collision with root package name */
    public String f47950h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47951i;
    public int j;
    public int k;
    public float l;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceShopModel(FaceShopActivity faceShopActivity) {
        super(faceShopActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {faceShopActivity};
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
        this.f47948f = null;
        this.j = 0;
        this.k = 0;
        this.f47947e = null;
        this.f47951i = false;
        this.f47949g = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.j = l.k(inst);
        this.k = l.i(inst);
        this.l = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int y(FaceShopModel faceShopModel) {
        int i2 = faceShopModel.f47949g;
        faceShopModel.f47949g = i2 + 1;
        return i2;
    }

    public FaceShopData I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47947e : (FaceShopData) invokeV.objValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47951i : invokeV.booleanValue;
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f47948f == null) {
            b bVar = new b(this, null);
            this.f47948f = bVar;
            bVar.setPriority(3);
            this.f47948f.execute(Integer.valueOf(i2));
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f47950h = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b bVar = this.f47948f;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f47952a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f47953b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f47954c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FaceShopModel f47955d;

        public b(FaceShopModel faceShopModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47955d = faceShopModel;
            this.f47954c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                this.f47952a = ((Integer) objArr[0]).intValue();
                try {
                    if (this.f47954c) {
                        return null;
                    }
                    this.f47953b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                    if (this.f47952a == 1) {
                        this.f47955d.f47949g = 0;
                    } else if (this.f47952a == 2) {
                        FaceShopModel.y(this.f47955d);
                    }
                    this.f47953b.addPostData("scr_w", String.valueOf(this.f47955d.j));
                    this.f47953b.addPostData("scr_h", String.valueOf(this.f47955d.k));
                    this.f47953b.addPostData("scr_dip", String.valueOf(this.f47955d.l));
                    this.f47953b.addPostData("offset", String.valueOf(this.f47955d.f47949g));
                    this.f47953b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                    this.f47953b.addPostData("st_type", this.f47955d.f47950h);
                    return (FaceShopData) OrmObject.objectWithJsonStr(this.f47953b.postNetData(), FaceShopData.class);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    return null;
                }
            }
            return (FaceShopData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(FaceShopData faceShopData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, faceShopData) == null) {
                super.onPostExecute(faceShopData);
                this.f47955d.f47948f = null;
                if (faceShopData != null) {
                    this.f47955d.f47951i = faceShopData.has_more == 1;
                    int i2 = this.f47952a;
                    if (i2 == 1) {
                        this.f47955d.f47947e = faceShopData;
                    } else if (i2 == 2) {
                        this.f47955d.f47947e.add(faceShopData);
                    }
                }
                this.f47955d.mLoadDataCallBack.c(this.f47955d.f47947e);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                this.f47954c = true;
                NetWork netWork = this.f47953b;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f47953b = null;
                }
                this.f47955d.f47948f = null;
            }
        }

        public /* synthetic */ b(FaceShopModel faceShopModel, a aVar) {
            this(faceShopModel);
        }
    }
}

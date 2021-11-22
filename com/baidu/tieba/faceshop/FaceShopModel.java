package com.baidu.tieba.faceshop;

import b.a.e.a.f;
import b.a.e.f.p.l;
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
    public FaceShopData f48810e;

    /* renamed from: f  reason: collision with root package name */
    public b f48811f;

    /* renamed from: g  reason: collision with root package name */
    public int f48812g;

    /* renamed from: h  reason: collision with root package name */
    public String f48813h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48814i;
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
        this.f48811f = null;
        this.j = 0;
        this.k = 0;
        this.f48810e = null;
        this.f48814i = false;
        this.f48812g = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.j = l.k(inst);
        this.k = l.i(inst);
        this.l = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int y(FaceShopModel faceShopModel) {
        int i2 = faceShopModel.f48812g;
        faceShopModel.f48812g = i2 + 1;
        return i2;
    }

    public FaceShopData I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48810e : (FaceShopData) invokeV.objValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48814i : invokeV.booleanValue;
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f48811f == null) {
            b bVar = new b(this, null);
            this.f48811f = bVar;
            bVar.setPriority(3);
            this.f48811f.execute(Integer.valueOf(i2));
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f48813h = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b bVar = this.f48811f;
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
        public int f48815a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f48816b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f48817c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FaceShopModel f48818d;

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
            this.f48818d = faceShopModel;
            this.f48817c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                this.f48815a = ((Integer) objArr[0]).intValue();
                try {
                    if (this.f48817c) {
                        return null;
                    }
                    this.f48816b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                    if (this.f48815a == 1) {
                        this.f48818d.f48812g = 0;
                    } else if (this.f48815a == 2) {
                        FaceShopModel.y(this.f48818d);
                    }
                    this.f48816b.addPostData("scr_w", String.valueOf(this.f48818d.j));
                    this.f48816b.addPostData("scr_h", String.valueOf(this.f48818d.k));
                    this.f48816b.addPostData("scr_dip", String.valueOf(this.f48818d.l));
                    this.f48816b.addPostData("offset", String.valueOf(this.f48818d.f48812g));
                    this.f48816b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                    this.f48816b.addPostData("st_type", this.f48818d.f48813h);
                    return (FaceShopData) OrmObject.objectWithJsonStr(this.f48816b.postNetData(), FaceShopData.class);
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
                this.f48818d.f48811f = null;
                if (faceShopData != null) {
                    this.f48818d.f48814i = faceShopData.has_more == 1;
                    int i2 = this.f48815a;
                    if (i2 == 1) {
                        this.f48818d.f48810e = faceShopData;
                    } else if (i2 == 2) {
                        this.f48818d.f48810e.add(faceShopData);
                    }
                }
                this.f48818d.mLoadDataCallBack.c(this.f48818d.f48810e);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                this.f48817c = true;
                NetWork netWork = this.f48816b;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f48816b = null;
                }
                this.f48818d.f48811f = null;
            }
        }

        public /* synthetic */ b(FaceShopModel faceShopModel, a aVar) {
            this(faceShopModel);
        }
    }
}

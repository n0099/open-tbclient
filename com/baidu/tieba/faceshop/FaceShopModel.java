package com.baidu.tieba.faceshop;

import c.a.d.a.f;
import c.a.d.f.p.n;
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
/* loaded from: classes5.dex */
public class FaceShopModel extends BdBaseModel<FaceShopActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_NEXT = 2;
    public static final int LOAD_REFRESH = 1;
    public static final int PAGE_MAX_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public FaceShopData a;

    /* renamed from: b  reason: collision with root package name */
    public b f32065b;

    /* renamed from: c  reason: collision with root package name */
    public int f32066c;

    /* renamed from: d  reason: collision with root package name */
    public String f32067d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32068e;

    /* renamed from: f  reason: collision with root package name */
    public int f32069f;

    /* renamed from: g  reason: collision with root package name */
    public int f32070g;

    /* renamed from: h  reason: collision with root package name */
    public float f32071h;

    /* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32065b = null;
        this.f32069f = 0;
        this.f32070g = 0;
        this.a = null;
        this.f32068e = false;
        this.f32066c = 0;
        TbadkApplication inst = TbadkApplication.getInst();
        this.f32069f = n.k(inst);
        this.f32070g = n.i(inst);
        this.f32071h = inst.getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ int A(FaceShopModel faceShopModel) {
        int i = faceShopModel.f32066c;
        faceShopModel.f32066c = i + 1;
        return i;
    }

    public FaceShopData K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (FaceShopData) invokeV.objValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32068e : invokeV.booleanValue;
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.f32065b == null) {
            b bVar = new b(this, null);
            this.f32065b = bVar;
            bVar.setPriority(3);
            this.f32065b.execute(Integer.valueOf(i));
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f32067d = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b bVar = this.f32065b;
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

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f32072b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f32073c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FaceShopModel f32074d;

        public b(FaceShopModel faceShopModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32074d = faceShopModel;
            this.f32073c = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public FaceShopData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                this.a = ((Integer) objArr[0]).intValue();
                try {
                    if (this.f32073c) {
                        return null;
                    }
                    this.f32072b = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_LIST);
                    if (this.a == 1) {
                        this.f32074d.f32066c = 0;
                    } else if (this.a == 2) {
                        FaceShopModel.A(this.f32074d);
                    }
                    this.f32072b.addPostData("scr_w", String.valueOf(this.f32074d.f32069f));
                    this.f32072b.addPostData("scr_h", String.valueOf(this.f32074d.f32070g));
                    this.f32072b.addPostData("scr_dip", String.valueOf(this.f32074d.f32071h));
                    this.f32072b.addPostData("offset", String.valueOf(this.f32074d.f32066c));
                    this.f32072b.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(10));
                    this.f32072b.addPostData("st_type", this.f32074d.f32067d);
                    return (FaceShopData) OrmObject.objectWithJsonStr(this.f32072b.postNetData(), FaceShopData.class);
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
                this.f32074d.f32065b = null;
                if (faceShopData != null) {
                    this.f32074d.f32068e = faceShopData.has_more == 1;
                    int i = this.a;
                    if (i == 1) {
                        this.f32074d.a = faceShopData;
                    } else if (i == 2) {
                        this.f32074d.a.add(faceShopData);
                    }
                }
                this.f32074d.mLoadDataCallBack.c(this.f32074d.a);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                this.f32073c = true;
                NetWork netWork = this.f32072b;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f32072b = null;
                }
                this.f32074d.f32065b = null;
            }
        }

        public /* synthetic */ b(FaceShopModel faceShopModel, a aVar) {
            this(faceShopModel);
        }
    }
}

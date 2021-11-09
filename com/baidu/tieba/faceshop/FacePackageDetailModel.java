package com.baidu.tieba.faceshop;

import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.e.d.l;
import b.a.e.e.p.k;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FacePackageDetailModel extends BdBaseModel<FacePackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47903e;

    /* renamed from: f  reason: collision with root package name */
    public int f47904f;

    /* renamed from: g  reason: collision with root package name */
    public String f47905g;

    /* renamed from: h  reason: collision with root package name */
    public String f47906h;

    /* renamed from: i  reason: collision with root package name */
    public String f47907i;
    public String j;
    public FacePackageDetailData k;
    public b l;
    public int m;
    public int n;
    public float o;
    public ProxyAdkBaseActivity.LoadDataCallBack p;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, String, FacePackageDetailData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f47908a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f47909b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FacePackageDetailModel f47910c;

        public b(FacePackageDetailModel facePackageDetailModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47910c = facePackageDetailModel;
            this.f47909b = false;
        }

        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.q0.s.r.a.f();
                l<String> g2 = b.a.q0.s.r.a.g("tb_face_package");
                if (g2 != null) {
                    g2.e(TbadkCoreApplication.getCurrentAccount() + this.f47910c.f47906h, str, 604800000L);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public FacePackageDetailData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) != null) {
                return (FacePackageDetailData) invokeL.objValue;
            }
            FacePackageDetailData facePackageDetailData = null;
            try {
                if (this.f47910c.f47906h == null || this.f47910c.f47906h.length() <= 0 || this.f47909b) {
                    return null;
                }
                b.a.q0.s.r.a.f();
                l<String> g2 = b.a.q0.s.r.a.g("tb_face_package");
                if (g2 != null) {
                    String str = g2.get(TbadkCoreApplication.getCurrentAccount() + this.f47910c.f47906h);
                    if (!k.isEmpty(str)) {
                        publishProgress(str);
                    }
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DETAIL);
                this.f47908a = netWork;
                netWork.addPostData("scr_w", String.valueOf(this.f47910c.m));
                this.f47908a.addPostData("scr_h", String.valueOf(this.f47910c.n));
                this.f47908a.addPostData("scr_dip", String.valueOf(this.f47910c.o));
                this.f47908a.addPostData("pid", this.f47910c.f47906h);
                this.f47908a.addPostData("st_type", this.f47910c.f47905g);
                String postNetData = this.f47908a.postNetData();
                FacePackageDetailData facePackageDetailData2 = (FacePackageDetailData) OrmObject.objectWithJsonStr(postNetData, FacePackageDetailData.class);
                if (facePackageDetailData2 != null) {
                    try {
                        if (facePackageDetailData2.faces_list != null) {
                            b(postNetData);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        facePackageDetailData = facePackageDetailData2;
                        BdLog.detailException(e);
                        return facePackageDetailData;
                    }
                }
                return facePackageDetailData2;
            } catch (Exception e3) {
                e = e3;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                this.f47909b = true;
                NetWork netWork = this.f47908a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f47908a = null;
                }
                this.f47910c.l = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(FacePackageDetailData facePackageDetailData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, facePackageDetailData) == null) {
                super.onPostExecute(facePackageDetailData);
                this.f47910c.l = null;
                if (facePackageDetailData != null) {
                    this.f47910c.k = facePackageDetailData;
                }
                this.f47910c.p.callback(facePackageDetailData, Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, strArr) == null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(strArr[0], FacePackageDetailData.class);
                this.f47910c.k = facePackageDetailData;
                this.f47910c.p.callback(facePackageDetailData, Boolean.TRUE);
                super.onProgressUpdate((Object[]) strArr);
            }
        }

        public /* synthetic */ b(FacePackageDetailModel facePackageDetailModel, a aVar) {
            this(facePackageDetailModel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacePackageDetailModel(FacePackageDetailActivity facePackageDetailActivity) {
        super(facePackageDetailActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {facePackageDetailActivity};
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
        this.f47907i = null;
        this.m = 0;
        this.n = 0;
        this.p = null;
        this.l = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.m = b.a.e.e.p.l.k(inst);
        this.n = b.a.e.e.p.l.i(inst);
        this.o = inst.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (FacePackageDetailData) invokeV.objValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47907i : (String) invokeV.objValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47903e : invokeV.booleanValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f47904f : invokeV.intValue;
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f47907i = str;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f47903e = z;
        }
    }

    public void L(ProxyAdkBaseActivity.LoadDataCallBack loadDataCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, loadDataCallBack) == null) {
            this.p = loadDataCallBack;
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }

    public void N(FacePackageData facePackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, facePackageData) == null) || facePackageData == null) {
            return;
        }
        int i2 = facePackageData.buy_status;
        int i3 = facePackageData.can_download;
        int i4 = facePackageData.downloading;
        int i5 = facePackageData.downloaded;
        if (i4 == 1) {
            this.f47904f = 5;
        } else if (i5 == 1) {
            this.f47904f = 1;
        } else if (i2 == 2) {
            this.f47904f = 6;
        } else if (i2 == 1) {
            if (i3 == 1) {
                this.f47904f = 2;
            }
        } else if (i2 == 0) {
            if (i3 == 1) {
                this.f47904f = 3;
            } else {
                this.f47904f = 4;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.cancel();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f47906h : (String) invokeV.objValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f47905g : (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.l == null) {
                b bVar = new b(this, null);
                this.l = bVar;
                bVar.setPriority(3);
                this.l.execute(new Object[0]);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setPid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f47906h = str;
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f47905g = str;
        }
    }
}

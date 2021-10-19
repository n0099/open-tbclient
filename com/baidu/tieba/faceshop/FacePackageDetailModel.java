package com.baidu.tieba.faceshop;

import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.d.l;
import c.a.e.e.p.k;
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
/* loaded from: classes7.dex */
public class FacePackageDetailModel extends BdBaseModel<FacePackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50523e;

    /* renamed from: f  reason: collision with root package name */
    public int f50524f;

    /* renamed from: g  reason: collision with root package name */
    public String f50525g;

    /* renamed from: h  reason: collision with root package name */
    public String f50526h;

    /* renamed from: i  reason: collision with root package name */
    public String f50527i;

    /* renamed from: j  reason: collision with root package name */
    public String f50528j;
    public FacePackageDetailData k;
    public b l;
    public int m;
    public int n;
    public float o;
    public ProxyAdkBaseActivity.LoadDataCallBack p;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, String, FacePackageDetailData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f50529a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f50530b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FacePackageDetailModel f50531c;

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
            this.f50531c = facePackageDetailModel;
            this.f50530b = false;
        }

        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.q0.s.r.a.f();
                l<String> g2 = c.a.q0.s.r.a.g("tb_face_package");
                if (g2 != null) {
                    g2.e(TbadkCoreApplication.getCurrentAccount() + this.f50531c.f50526h, str, 604800000L);
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
                if (this.f50531c.f50526h == null || this.f50531c.f50526h.length() <= 0 || this.f50530b) {
                    return null;
                }
                c.a.q0.s.r.a.f();
                l<String> g2 = c.a.q0.s.r.a.g("tb_face_package");
                if (g2 != null) {
                    String str = g2.get(TbadkCoreApplication.getCurrentAccount() + this.f50531c.f50526h);
                    if (!k.isEmpty(str)) {
                        publishProgress(str);
                    }
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_PACKAGE_DETAIL);
                this.f50529a = netWork;
                netWork.addPostData("scr_w", String.valueOf(this.f50531c.m));
                this.f50529a.addPostData("scr_h", String.valueOf(this.f50531c.n));
                this.f50529a.addPostData("scr_dip", String.valueOf(this.f50531c.o));
                this.f50529a.addPostData("pid", this.f50531c.f50526h);
                this.f50529a.addPostData("st_type", this.f50531c.f50525g);
                String postNetData = this.f50529a.postNetData();
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
                this.f50530b = true;
                NetWork netWork = this.f50529a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f50529a = null;
                }
                this.f50531c.l = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(FacePackageDetailData facePackageDetailData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, facePackageDetailData) == null) {
                super.onPostExecute(facePackageDetailData);
                this.f50531c.l = null;
                if (facePackageDetailData != null) {
                    this.f50531c.k = facePackageDetailData;
                }
                this.f50531c.p.callback(facePackageDetailData, Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, strArr) == null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) OrmObject.objectWithJsonStr(strArr[0], FacePackageDetailData.class);
                this.f50531c.k = facePackageDetailData;
                this.f50531c.p.callback(facePackageDetailData, Boolean.TRUE);
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
        this.f50527i = null;
        this.m = 0;
        this.n = 0;
        this.p = null;
        this.l = null;
        TbadkApplication inst = TbadkApplication.getInst();
        this.m = c.a.e.e.p.l.k(inst);
        this.n = c.a.e.e.p.l.i(inst);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50527i : (String) invokeV.objValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50523e : invokeV.booleanValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50528j : (String) invokeV.objValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50524f : invokeV.intValue;
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f50527i = str;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f50523e = z;
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
            this.f50528j = str;
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
            this.f50524f = 5;
        } else if (i5 == 1) {
            this.f50524f = 1;
        } else if (i2 == 2) {
            this.f50524f = 6;
        } else if (i2 == 1) {
            if (i3 == 1) {
                this.f50524f = 2;
            }
        } else if (i2 == 0) {
            if (i3 == 1) {
                this.f50524f = 3;
            } else {
                this.f50524f = 4;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f50526h : (String) invokeV.objValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f50525g : (String) invokeV.objValue;
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
            this.f50526h = str;
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f50525g = str;
        }
    }
}

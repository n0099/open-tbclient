package com.baidu.tbadk.widget.multidelmenu.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.vx5;
import com.baidu.tieba.wx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MultiDelPostNetModel<T> extends BdBaseModel<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId UNIQUE_ID_MULTI_DEL_POST_TASK;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiDelPostNetModel<T>.b a;
    public vx5 b;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, wx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ MultiDelPostNetModel b;

        public b(MultiDelPostNetModel multiDelPostNetModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiDelPostNetModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = multiDelPostNetModel;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(wx5 wx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wx5Var) == null) {
                super.onPostExecute(wx5Var);
                this.b.a = null;
                if (this.b.mLoadDataCallBack != null) {
                    this.b.mLoadDataCallBack.c(wx5Var);
                }
            }
        }

        public /* synthetic */ b(MultiDelPostNetModel multiDelPostNetModel, a aVar) {
            this(multiDelPostNetModel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public wx5 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (this.b.b == null) {
                    return null;
                }
                NetWork netWork = new NetWork(MultiDelPostNetModel.c);
                this.a = netWork;
                netWork.addPostData("forum_id", this.b.b.a);
                this.a.addPostData("thread_id", this.b.b.b);
                this.a.addPostData("post_ids", TextUtils.join(",", this.b.b.c));
                this.a.addPostData("reason", this.b.b.d);
                this.a.addPostData("type", this.b.b.e);
                this.a.getNetContext().getRequest().mIsNeedTbs = true;
                String postNetData = this.a.postNetData();
                wx5 wx5Var = new wx5();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    wx5Var.a = true;
                    wx5Var.a(postNetData);
                } else {
                    wx5Var.a = false;
                    wx5Var.b = this.a.getErrorString();
                    this.a.getServerErrorCode();
                }
                return wx5Var;
            }
            return (wx5) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.b.a = null;
                super.cancel(true);
                if (this.b.mLoadDataCallBack != null) {
                    this.b.mLoadDataCallBack.c(null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(565931009, "Lcom/baidu/tbadk/widget/multidelmenu/model/MultiDelPostNetModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(565931009, "Lcom/baidu/tbadk/widget/multidelmenu/model/MultiDelPostNetModel;");
                return;
            }
        }
        c = TbConfig.SERVER_ADDRESS + TbConfig.MULTI_DEL_POST_ADDRESS;
        UNIQUE_ID_MULTI_DEL_POST_TASK = BdUniqueId.gen();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MultiDelPostNetModel<T>.b bVar = this.a;
            if (bVar != null) {
                bVar.cancel();
                this.a = null;
            }
            MultiDelPostNetModel<T>.b bVar2 = new b(this, null);
            this.a = bVar2;
            bVar2.setTag(UNIQUE_ID_MULTI_DEL_POST_TASK);
            this.a.setPriority(2);
            this.a.execute(new String[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    public MultiDelPostNetModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MultiDelPostNetModel<T>.b bVar = this.a;
            if (bVar != null) {
                bVar.cancel();
                this.a = null;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void V(vx5 vx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vx5Var) == null) {
            this.b = vx5Var;
        }
    }
}

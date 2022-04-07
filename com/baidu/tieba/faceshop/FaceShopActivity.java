package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.b96;
import com.repackage.du4;
import com.repackage.i96;
import com.repackage.j96;
import com.repackage.mi;
import com.repackage.ni;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class FaceShopActivity extends BaseActivity<FaceShopActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_BUY = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public FaceBuyModel mBuyModel;
    public final CustomMessageListener mListener;
    public final a9 mLoadDataCallBack;
    public FaceShopModel mModel;
    public final NoNetworkView.b mNetworkChangeListener;
    public j96 mView;
    public final HashMap<String, DownloadData> map;

    /* loaded from: classes3.dex */
    public class a implements du4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceShopActivity a;

        public a(FaceShopActivity faceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceShopActivity;
        }

        @Override // com.repackage.du4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.refresh(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceShopActivity a;

        public b(FaceShopActivity faceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceShopActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.loadNext();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceShopActivity a;

        public c(FaceShopActivity faceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceShopActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.mView != null) {
                this.a.mView.s();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceShopActivity a;

        public d(FaceShopActivity faceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceShopActivity;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                if (obj != null && (obj instanceof FaceShopData)) {
                    if (this.a.mView != null) {
                        FaceShopData faceShopData = (FaceShopData) obj;
                        if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                            if (this.a.mModel.L()) {
                                this.a.mView.r();
                            } else {
                                this.a.mView.f();
                            }
                            this.a.mView.j(faceShopData);
                            return;
                        }
                        String str = faceShopData.usermsg;
                        if (str != null) {
                            this.a.showToast(str);
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                        }
                        this.a.mView.b();
                        return;
                    }
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                this.a.mView.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ FaceShopActivity b;

        public e(FaceShopActivity faceShopActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = faceShopActivity;
            this.a = i;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj != null && (obj instanceof FaceBuyQueryData)) {
                    FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                    if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                        if (faceBuyQueryData.buy_result.status == 2) {
                            this.b.onBuySuccess(this.a);
                            return;
                        } else {
                            this.b.onBuyFail();
                            return;
                        }
                    }
                    this.b.onBuyFail();
                    return;
                }
                this.b.onBuyFail();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceShopActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FaceShopActivity faceShopActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData K;
            i96 c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.mModel == null || this.a.mView == null || (K = this.a.mModel.K()) == null || K.pack_list == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001118) {
                if (customResponsedMessage instanceof DownloadMessage) {
                    this.a.map.clear();
                    List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                    if (data == null || (c = this.a.mView.c()) == null) {
                        return;
                    }
                    for (DownloadData downloadData : data) {
                        this.a.map.put(downloadData.getId(), downloadData);
                    }
                    Iterator<FacePackageData> it = K.pack_list.iterator();
                    while (it.hasNext()) {
                        FacePackageData next = it.next();
                        DownloadData downloadData2 = (DownloadData) this.a.map.get(String.valueOf(next.pid));
                        if (downloadData2 != null) {
                            int status = downloadData2.getStatus();
                            if (status == 3 || status == 0) {
                                next.downloaded = 1;
                                next.downloading = 0;
                            } else if (status == 2 || status == 4) {
                                if (!ni.isEmpty(downloadData2.getStatusMsg())) {
                                    this.a.showToast(downloadData2.getStatusMsg());
                                }
                                c.h();
                                next.downloaded = 0;
                                next.downloading = 0;
                            } else if (status == 1) {
                                next.downloading = 1;
                                next.downloaded = 0;
                                next.downloadTotal = downloadData2.getSize();
                                next.downloadNow = downloadData2.getLength();
                            }
                        }
                    }
                    c.n(K);
                }
            } else if (customResponsedMessage.getCmd() == 2001117) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<FacePackageData> it2 = K.pack_list.iterator();
                while (it2.hasNext()) {
                    FacePackageData next2 = it2.next();
                    if (next2.downloaded == 1) {
                        next2.downloaded = 0;
                    }
                    arrayList.add(String.valueOf(next2.pid));
                }
                this.a.mView.i(arrayList);
            }
        }
    }

    public FaceShopActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.map = new HashMap<>();
        this.mNetworkChangeListener = new c(this);
        this.mLoadDataCallBack = new d(this);
        this.mListener = new f(this, 0);
    }

    private void addNetWorkStateChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mView.a(this.mNetworkChangeListener);
        }
    }

    private void initData(Bundle bundle) {
        String st_type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bundle) == null) {
            this.mModel = new FaceShopModel(this);
            if (bundle != null) {
                st_type = FaceShopActivityConfig.getST_TYPE(bundle);
            } else {
                st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
                TiebaStatic.log(st_type);
            }
            this.mModel.N(st_type);
            this.mModel.setLoadDataCallBack(this.mLoadDataCallBack);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            j96 j96Var = new j96(getPageContext());
            this.mView = j96Var;
            j96Var.o(new a(this));
            this.mView.p(new b(this));
            this.mView.m(this);
            addNetWorkStateChangeListener();
            registerListener(2001118, this.mListener);
            registerListener(2001117, this.mListener);
            b96.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNext() {
        FaceShopModel faceShopModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (faceShopModel = this.mModel) == null || this.mView == null || !faceShopModel.L()) {
            return;
        }
        this.mView.n();
        this.mModel.M(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            if (mi.z()) {
                if (z) {
                    showProgressBar();
                }
                this.mModel.M(1);
                return;
            }
            this.mView.b();
        }
    }

    private void removeNetWorkStateChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mView.k(this.mNetworkChangeListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        j96 j96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || (j96Var = this.mView) == null || j96Var.c() == null) {
                return;
            }
            if (i == 10000) {
                int intExtra = intent.getIntExtra(FaceBuyWebViewActivity.TAG_POSITION, -1);
                String stringExtra = intent.getStringExtra(FaceBuyWebViewActivity.TAG_ORDER_ID);
                FacePackageData facePackageData = (FacePackageData) this.mView.c().getItem(intExtra);
                if (facePackageData == null) {
                    return;
                }
                if (ni.isEmpty(stringExtra)) {
                    stringExtra = facePackageData.orderId;
                }
                this.mView.q();
                FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
                this.mBuyModel = faceBuyModel;
                faceBuyModel.setLoadDataCallBack(new e(this, intExtra));
                this.mBuyModel.G(stringExtra);
            } else if (i != 11003) {
                if (i == 11037) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902012, new IntentConfig(getActivity())));
                }
            } else {
                i96 c2 = this.mView.c();
                int e2 = c2.e();
                if (e2 < 0) {
                    return;
                }
                if (((FacePackageData) c2.getItem(e2)).can_download == 1) {
                    c2.i(e2);
                } else {
                    c2.g(e2);
                }
            }
        }
    }

    public void onBuyFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mView.l();
        }
    }

    public void onBuySuccess(int i) {
        j96 j96Var;
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (j96Var = this.mView) == null || j96Var.c() == null || (facePackageData = (FacePackageData) this.mView.c().getItem(i)) == null) {
            return;
        }
        this.mView.e();
        facePackageData.buy_status = 1;
        facePackageData.can_download = 1;
        this.mView.c().notifyDataSetChanged();
        this.mView.c().i(i);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            j96 j96Var = this.mView;
            if (j96Var != null) {
                j96Var.g(i);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        j96 j96Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || (j96Var = this.mView) == null) {
            return;
        }
        if (view2 == j96Var.d()) {
            if (!TbadkCoreApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getActivity(), true, 11037)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902012, new IntentConfig(getActivity())));
        }
        super.onClick(view2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            initUI();
            initData(bundle);
            this.mView.s();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            FaceShopModel faceShopModel = this.mModel;
            if (faceShopModel != null) {
                faceShopModel.cancelLoadData();
            }
            j96 j96Var = this.mView;
            if (j96Var != null) {
                j96Var.c().h();
            }
            FaceBuyModel faceBuyModel = this.mBuyModel;
            if (faceBuyModel != null) {
                faceBuyModel.cancelLoadData();
            }
            removeNetWorkStateChangeListener();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        j96 j96Var;
        i96 c2;
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.mModel == null || (j96Var = this.mView) == null || (c2 = j96Var.c()) == null) {
            return;
        }
        if (i < c2.getCount() && i >= 0 && (facePackageData = (FacePackageData) c2.getItem(i)) != null) {
            sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
        }
        super.onItemClick(adapterView, view2, i, j);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            j96 j96Var = this.mView;
            if (j96Var != null) {
                j96Var.h();
            }
        }
    }
}

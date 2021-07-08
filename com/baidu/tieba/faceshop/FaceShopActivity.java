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
import com.baidu.tbadk.ProxyAdkBaseActivity;
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
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.o0.r.f0.f;
import d.a.p0.p0.m;
import d.a.p0.p0.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FaceShopActivity extends ProxyAdkBaseActivity<FaceShopActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public n f14988e;

    /* renamed from: f  reason: collision with root package name */
    public FaceShopModel f14989f;

    /* renamed from: g  reason: collision with root package name */
    public FaceBuyModel f14990g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, DownloadData> f14991h;

    /* renamed from: i  reason: collision with root package name */
    public final NoNetworkView.b f14992i;
    public final d.a.c.a.e j;
    public final CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceShopActivity f14993e;

        public a(FaceShopActivity faceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14993e = faceShopActivity;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f14993e.q(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceShopActivity f14994e;

        public b(FaceShopActivity faceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14994e = faceShopActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14994e.n();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceShopActivity f14995e;

        public c(FaceShopActivity faceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14995e = faceShopActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f14995e.f14988e != null) {
                this.f14995e.f14988e.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceShopActivity f14996a;

        public d(FaceShopActivity faceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14996a = faceShopActivity;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f14996a.hideProgressBar();
                if (obj != null && (obj instanceof FaceShopData)) {
                    if (this.f14996a.f14988e != null) {
                        FaceShopData faceShopData = (FaceShopData) obj;
                        if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                            if (this.f14996a.f14989f.J()) {
                                this.f14996a.f14988e.r();
                            } else {
                                this.f14996a.f14988e.f();
                            }
                            this.f14996a.f14988e.j(faceShopData);
                            return;
                        }
                        String str = faceShopData.usermsg;
                        if (str != null) {
                            this.f14996a.showToast(str);
                        } else {
                            this.f14996a.showToast(R.string.neterror);
                        }
                        this.f14996a.f14988e.b();
                        return;
                    }
                    return;
                }
                this.f14996a.showToast(R.string.neterror);
                this.f14996a.f14988e.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f14997a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceShopActivity f14998b;

        public e(FaceShopActivity faceShopActivity, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14998b = faceShopActivity;
            this.f14997a = i2;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj != null && (obj instanceof FaceBuyQueryData)) {
                    FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                    if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                        if (faceBuyQueryData.buy_result.status == 2) {
                            this.f14998b.p(this.f14997a);
                            return;
                        } else {
                            this.f14998b.o();
                            return;
                        }
                    }
                    this.f14998b.o();
                    return;
                }
                this.f14998b.o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceShopActivity f14999a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FaceShopActivity faceShopActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceShopActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14999a = faceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData I;
            m c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f14999a.f14989f == null || this.f14999a.f14988e == null || (I = this.f14999a.f14989f.I()) == null || I.pack_list == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001118) {
                if (customResponsedMessage instanceof DownloadMessage) {
                    this.f14999a.f14991h.clear();
                    List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                    if (data == null || (c2 = this.f14999a.f14988e.c()) == null) {
                        return;
                    }
                    for (DownloadData downloadData : data) {
                        this.f14999a.f14991h.put(downloadData.getId(), downloadData);
                    }
                    Iterator<FacePackageData> it = I.pack_list.iterator();
                    while (it.hasNext()) {
                        FacePackageData next = it.next();
                        DownloadData downloadData2 = (DownloadData) this.f14999a.f14991h.get(String.valueOf(next.pid));
                        if (downloadData2 != null) {
                            int status = downloadData2.getStatus();
                            if (status == 3 || status == 0) {
                                next.downloaded = 1;
                                next.downloading = 0;
                            } else if (status == 2 || status == 4) {
                                if (!k.isEmpty(downloadData2.getStatusMsg())) {
                                    this.f14999a.showToast(downloadData2.getStatusMsg());
                                }
                                c2.h();
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
                    c2.n(I);
                }
            } else if (customResponsedMessage.getCmd() == 2001117) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<FacePackageData> it2 = I.pack_list.iterator();
                while (it2.hasNext()) {
                    FacePackageData next2 = it2.next();
                    if (next2.downloaded == 1) {
                        next2.downloaded = 0;
                    }
                    arrayList.add(String.valueOf(next2.pid));
                }
                this.f14999a.f14988e.i(arrayList);
            }
        }
    }

    public FaceShopActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14991h = new HashMap<>();
        this.f14992i = new c(this);
        this.j = new d(this);
        this.k = new f(this, 0);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14988e.a(this.f14992i);
        }
    }

    public final void l(Bundle bundle) {
        String st_type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.f14989f = new FaceShopModel(this);
            if (bundle != null) {
                st_type = FaceShopActivityConfig.getST_TYPE(bundle);
            } else {
                st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
                TiebaStatic.log(st_type);
            }
            this.f14989f.L(st_type);
            this.f14989f.setLoadDataCallBack(this.j);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n nVar = new n(getPageContext());
            this.f14988e = nVar;
            nVar.o(new a(this));
            this.f14988e.p(new b(this));
            this.f14988e.m(this);
            k();
            registerListener(2001118, this.k);
            registerListener(2001117, this.k);
            d.a.p0.p0.f.f();
        }
    }

    public final void n() {
        FaceShopModel faceShopModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (faceShopModel = this.f14989f) == null || this.f14988e == null || !faceShopModel.J()) {
            return;
        }
        this.f14988e.n();
        this.f14989f.K(2);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14988e.l();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1 || (nVar = this.f14988e) == null || nVar.c() == null) {
                return;
            }
            if (i2 == 10000) {
                int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.f14988e.c().getItem(intExtra);
                if (facePackageData == null) {
                    return;
                }
                if (k.isEmpty(stringExtra)) {
                    stringExtra = facePackageData.orderId;
                }
                this.f14988e.q();
                FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
                this.f14990g = faceBuyModel;
                faceBuyModel.setLoadDataCallBack(new e(this, intExtra));
                this.f14990g.E(stringExtra);
            } else if (i2 != 11003) {
                if (i2 == 11037) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902012, new IntentConfig(getActivity())));
                }
            } else {
                m c2 = this.f14988e.c();
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

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            n nVar = this.f14988e;
            if (nVar != null) {
                nVar.g(i2);
            }
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (nVar = this.f14988e) == null) {
            return;
        }
        if (view == nVar.d()) {
            if (!TbadkCoreApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getActivity(), true, 11037)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902012, new IntentConfig(getActivity())));
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            m();
            l(bundle);
            this.f14988e.s();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            FaceShopModel faceShopModel = this.f14989f;
            if (faceShopModel != null) {
                faceShopModel.cancelLoadData();
            }
            n nVar = this.f14988e;
            if (nVar != null) {
                nVar.c().h();
            }
            FaceBuyModel faceBuyModel = this.f14990g;
            if (faceBuyModel != null) {
                faceBuyModel.cancelLoadData();
            }
            r();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        n nVar;
        m c2;
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f14989f == null || (nVar = this.f14988e) == null || (c2 = nVar.c()) == null) {
            return;
        }
        if (i2 < c2.getCount() && i2 >= 0 && (facePackageData = (FacePackageData) c2.getItem(i2)) != null) {
            sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
        }
        super.onItemClick(adapterView, view, i2, j);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            n nVar = this.f14988e;
            if (nVar != null) {
                nVar.h();
            }
        }
    }

    public void p(int i2) {
        n nVar;
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (nVar = this.f14988e) == null || nVar.c() == null || (facePackageData = (FacePackageData) this.f14988e.c().getItem(i2)) == null) {
            return;
        }
        this.f14988e.e();
        facePackageData.buy_status = 1;
        facePackageData.can_download = 1;
        this.f14988e.c().notifyDataSetChanged();
        this.f14988e.c().i(i2);
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (j.z()) {
                if (z) {
                    showProgressBar();
                }
                this.f14989f.K(1);
                return;
            }
            this.f14988e.b();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f14988e.k(this.f14992i);
        }
    }
}

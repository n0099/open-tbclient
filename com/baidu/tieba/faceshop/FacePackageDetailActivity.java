package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.r0.r0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FaceBuyData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class FacePackageDetailActivity extends ProxyAdkBaseActivity<FacePackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FacePackageDetailModel f50583e;

    /* renamed from: f  reason: collision with root package name */
    public h f50584f;

    /* renamed from: g  reason: collision with root package name */
    public FacePackageDownloadModel f50585g;

    /* renamed from: h  reason: collision with root package name */
    public FaceBuyModel f50586h;

    /* renamed from: i  reason: collision with root package name */
    public float f50587i;

    /* renamed from: j  reason: collision with root package name */
    public float f50588j;
    public boolean k;
    public final Rect l;
    public final NoNetworkView.b m;
    public final ProxyAdkBaseActivity<FacePackageDetailActivity>.LoadDataCallBack n;
    public final CustomMessageListener o;

    /* loaded from: classes7.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FacePackageDetailActivity f50589e;

        public a(FacePackageDetailActivity facePackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50589e = facePackageDetailActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f50589e.s();
                }
                this.f50589e.f50584f.c(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ProxyAdkBaseActivity<FacePackageDetailActivity>.LoadDataCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageDetailActivity f50590a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FacePackageDetailActivity facePackageDetailActivity) {
            super(facePackageDetailActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ProxyAdkBaseActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50590a = facePackageDetailActivity;
        }

        @Override // com.baidu.tbadk.ProxyAdkBaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
                this.f50590a.hideProgressBar();
                Object obj = objArr[0];
                Boolean bool = (Boolean) objArr[1];
                if (obj != null && (obj instanceof FacePackageDetailData)) {
                    if (this.f50590a.f50584f != null) {
                        FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                        if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                            this.f50590a.f50584f.o(this.f50590a.f50583e);
                            if (!bool.booleanValue()) {
                                this.f50590a.k = true;
                                return;
                            } else {
                                this.f50590a.showProgressBar();
                                return;
                            }
                        }
                        String str = facePackageDetailData.usermsg;
                        if (str != null) {
                            this.f50590a.showToast(str);
                            return;
                        } else {
                            this.f50590a.showToast(R.string.neterror);
                            return;
                        }
                    }
                    return;
                }
                this.f50590a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DownloadData f50591a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FacePackageDetailActivity f50592b;

        public c(FacePackageDetailActivity facePackageDetailActivity, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity, downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50592b = facePackageDetailActivity;
            this.f50591a = downloadData;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj != null && (obj instanceof FacePackageDownloadData)) {
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        String str = facePackageDownloadData.pack_url;
                        this.f50592b.f50583e.K(str);
                        if (this.f50592b.f50583e.E() == null || this.f50592b.f50583e.E().faces_list == null) {
                            return;
                        }
                        FacePackageDetailActivity facePackageDetailActivity = this.f50592b;
                        facePackageDetailActivity.l(facePackageDetailActivity.f50583e.getPid(), this.f50592b.f50583e.E().faces_list.pname, str);
                        return;
                    }
                    String str2 = facePackageDownloadData.usermsg;
                    if (str2 != null) {
                        this.f50592b.showToast(str2);
                        return;
                    } else {
                        c.a.r0.r0.f.f().i(this.f50591a);
                        return;
                    }
                }
                c.a.r0.r0.f.f().i(this.f50591a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageDetailActivity f50593a;

        public d(FacePackageDetailActivity facePackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50593a = facePackageDetailActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f50593a.hideProgressBar();
                if (obj != null && (obj instanceof FaceBuyData)) {
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        FaceBuyData.BuyInfo buyInfo = faceBuyData.buy_info;
                        String str = buyInfo.buy_url;
                        String str2 = buyInfo.return_url;
                        if (buyInfo.buy_status != 2) {
                            this.f50593a.f50583e.N(String.valueOf(faceBuyData.buy_info.order_id));
                            IntentConfig intentConfig = new IntentConfig(this.f50593a.getActivity());
                            intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_URL, str);
                            intentConfig.getIntent().putExtra("tag_hook_url", str2);
                            intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_TITLE, this.f50593a.getString(R.string.buy_book));
                            intentConfig.getIntent().putExtra("tag_position", 0);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2902013, intentConfig));
                            return;
                        }
                        this.f50593a.showToast(R.string.has_buy_book);
                        FacePackageData facePackageData = this.f50593a.f50583e.E().faces_list;
                        facePackageData.buy_status = 1;
                        facePackageData.can_download = 1;
                        this.f50593a.f50583e.O(facePackageData);
                        this.f50593a.f50584f.z();
                        return;
                    }
                    String str3 = faceBuyData.usermsg;
                    if (str3 != null) {
                        this.f50593a.showToast(str3);
                        return;
                    } else {
                        this.f50593a.showToast(R.string.neterror);
                        return;
                    }
                }
                this.f50593a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageDetailActivity f50594a;

        public e(FacePackageDetailActivity facePackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50594a = facePackageDetailActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj != null && (obj instanceof FaceBuyQueryData)) {
                    FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                    if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                        if (faceBuyQueryData.buy_result.status == 2) {
                            this.f50594a.r();
                            return;
                        } else {
                            this.f50594a.q();
                            return;
                        }
                    }
                    this.f50594a.q();
                    return;
                }
                this.f50594a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePackageDetailActivity f50595a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FacePackageDetailActivity facePackageDetailActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity, Integer.valueOf(i2)};
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
            this.f50595a = facePackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f50595a.f50583e == null || this.f50595a.f50583e.E() == null || this.f50595a.f50584f == null || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            FacePackageData facePackageData = this.f50595a.f50583e.E().faces_list;
            if (data.size() >= 1 && (downloadData = data.get(0)) != null && downloadData.getId().equals(this.f50595a.f50583e.getPid())) {
                int status = downloadData.getStatus();
                if (status == 3 || status == 0) {
                    facePackageData.downloaded = 1;
                    facePackageData.downloading = 0;
                } else if (status == 2 || status == 4) {
                    if (!k.isEmpty(downloadData.getStatusMsg())) {
                        this.f50595a.showToast(downloadData.getStatusMsg());
                    }
                    if (this.f50595a.f50585g != null) {
                        this.f50595a.f50585g.cancelLoadData();
                    }
                    facePackageData.downloaded = 0;
                    facePackageData.downloading = 0;
                } else if (status == 1) {
                    facePackageData.downloading = 1;
                    facePackageData.downloaded = 0;
                    facePackageData.downloadTotal = downloadData.getSize();
                    facePackageData.downloadNow = downloadData.getLength();
                }
            }
            this.f50595a.f50583e.O(facePackageData);
            this.f50595a.f50584f.w(this.f50595a.f50583e);
        }
    }

    public FacePackageDetailActivity() {
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
        this.k = false;
        this.l = new Rect();
        this.m = new a(this);
        this.n = new b(this);
        this.o = new f(this, 2001118);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r0 != 3) goto L19;
     */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.f50587i = motionEvent.getX();
                this.f50588j = motionEvent.getY();
            }
            h hVar = this.f50584f;
            if (hVar == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (hVar.j()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        this.l.set(x, y, x + 1, y + 1);
                        GridView g2 = this.f50584f.g();
                        ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(g2, this.l);
                        Rect rect = this.l;
                        int pointToPosition = g2.pointToPosition(rect.left, rect.top);
                        if (pointToPosition != -1) {
                            View childAt = g2.getChildAt(pointToPosition - g2.getFirstVisiblePosition());
                            if (p(x, y)) {
                                u(childAt, pointToPosition);
                            }
                        }
                    }
                    return true;
                }
                this.f50584f.d();
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f50584f.b(this.m);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            showProgressBar();
            String pid = this.f50583e.getPid();
            FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
            this.f50586h = faceBuyModel;
            faceBuyModel.setLoadDataCallBack(new d(this));
            this.f50586h.D(pid);
        }
    }

    public void l(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            c.a.r0.r0.f.f().j(str, str2, str3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FacePackageDownloadModel facePackageDownloadModel = new FacePackageDownloadModel(getActivity());
            this.f50585g = facePackageDownloadModel;
            facePackageDownloadModel.D(this.f50583e.getPid());
            DownloadData downloadData = new DownloadData(this.f50583e.getPid());
            downloadData.setType(11);
            downloadData.setStatus(2);
            downloadData.setStatusMsg(getResources().getString(R.string.neterror));
            this.f50585g.setLoadDataCallBack(new c(this, downloadData));
        }
    }

    public final void n(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            FacePackageDetailModel facePackageDetailModel = new FacePackageDetailModel(this);
            this.f50583e = facePackageDetailModel;
            if (bundle != null) {
                facePackageDetailModel.setStType(bundle.getString("st_type"));
                this.f50583e.setPid(bundle.getString(IntentConfig.PKG_ID));
                this.f50583e.L(bundle.getBoolean(IntentConfig.IS_DOWNLOADING));
            } else {
                facePackageDetailModel.setStType(getIntent().getStringExtra("st_type"));
                this.f50583e.setPid(getIntent().getStringExtra(IntentConfig.PKG_ID));
                this.f50583e.L(getIntent().getBooleanExtra(IntentConfig.IS_DOWNLOADING, false));
                TiebaStatic.log(getIntent().getStringExtra("st_type"));
            }
            this.f50583e.M(this.n);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f50584f = new h(getPageContext());
            j();
            registerListener(this.o);
            c.a.r0.r0.f.f();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        FacePackageDetailModel facePackageDetailModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1 || this.f50584f == null || (facePackageDetailModel = this.f50583e) == null || facePackageDetailModel.E() == null) {
                return;
            }
            if (i2 != 10001) {
                if (i2 == 11003) {
                    if (this.f50583e.E().faces_list.can_download == 1) {
                        m();
                        return;
                    } else {
                        k();
                        return;
                    }
                }
                return;
            }
            String stringExtra = intent.getStringExtra("tag_order_id");
            if (this.f50583e.E().faces_list == null) {
                return;
            }
            if (k.isEmpty(stringExtra)) {
                stringExtra = this.f50583e.H();
            }
            this.f50584f.y();
            FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
            this.f50586h = faceBuyModel;
            faceBuyModel.setLoadDataCallBack(new e(this));
            this.f50586h.E(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            h hVar = this.f50584f;
            if (hVar != null) {
                hVar.l(i2);
            }
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || this.f50583e == null || (hVar = this.f50584f) == null) {
            return;
        }
        if (view == hVar.e()) {
            if (!TbadkCoreApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
                return;
            } else if (!this.k) {
                return;
            } else {
                int I = this.f50583e.I();
                if (I == 2 || I == 3) {
                    TiebaStatic.log("emotion_package_detail_free");
                    String F = this.f50583e.F();
                    DownloadData downloadData = new DownloadData(this.f50583e.getPid());
                    downloadData.setStatus(1);
                    downloadData.setStatusMsg(null);
                    downloadData.setType(11);
                    c.a.r0.r0.f.f().i(downloadData);
                    if (!k.isEmpty(F)) {
                        if (this.f50583e.E() == null || this.f50583e.E().faces_list == null) {
                            return;
                        }
                        l(this.f50583e.getPid(), this.f50583e.E().faces_list.pname, F);
                    } else {
                        m();
                    }
                } else if (I == 4) {
                    TiebaStatic.log("emotion_package_detail_buy");
                    k();
                }
            }
        } else if (view == this.f50584f.f()) {
            DownloadData downloadData2 = new DownloadData(this.f50583e.getPid());
            downloadData2.setStatus(4);
            downloadData2.setStatusMsg(null);
            downloadData2.setType(11);
            c.a.r0.r0.f.f().i(downloadData2);
            this.f50583e.L(false);
            c.a.r0.r0.f.f().e(this.f50583e.getPid());
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            n(bundle);
            o();
            s();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            FacePackageDetailModel facePackageDetailModel = this.f50583e;
            if (facePackageDetailModel != null) {
                facePackageDetailModel.cancelLoadData();
            }
            FacePackageDownloadModel facePackageDownloadModel = this.f50585g;
            if (facePackageDownloadModel != null) {
                facePackageDownloadModel.cancelLoadData();
            }
            FaceBuyModel faceBuyModel = this.f50586h;
            if (faceBuyModel != null) {
                faceBuyModel.cancelLoadData();
            }
            t();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            h hVar = this.f50584f;
            if (hVar != null) {
                hVar.p();
            }
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            u(view, i2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            h hVar = this.f50584f;
            if (hVar != null) {
                hVar.m();
            }
            super.onResume();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            FacePackageDetailModel facePackageDetailModel = this.f50583e;
            if (facePackageDetailModel != null) {
                bundle.putString("st_type", facePackageDetailModel.getStType());
                bundle.putString(IntentConfig.PKG_ID, this.f50583e.getPid());
                bundle.putBoolean(IntentConfig.IS_DOWNLOADING, this.f50583e.G());
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public final boolean p(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f2 - this.f50587i;
            float f5 = f3 - this.f50588j;
            return Math.sqrt((double) ((f4 * f4) + (f5 * f5))) > ((double) getResources().getDimensionPixelSize(R.dimen.ds22));
        }
        return invokeCommon.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f50584f.r();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f50584f.h();
            m();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            showProgressBar();
            this.f50583e.J();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f50584f.q(this.m);
        }
    }

    public final void u(View view, int i2) {
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048597, this, view, i2) == null) || view == null) {
            return;
        }
        view.getDrawingRect(this.l);
        ((ViewGroup) getWindow().getDecorView()).offsetDescendantRectToMyCoords(view, this.l);
        if (this.f50583e.E() == null || (facePackageData = this.f50583e.E().faces_list) == null) {
            return;
        }
        this.f50584f.C(i2, this.l, facePackageData);
    }
}

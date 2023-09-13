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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ei;
import com.baidu.tieba.faceshop.FaceBuyData;
import com.baidu.tieba.i9;
import com.baidu.tieba.q47;
import com.baidu.tieba.t47;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class FacePackageDetailActivity extends BaseActivity<FacePackageDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FacePackageDetailModel a;
    public t47 b;
    public FacePackageDownloadModel c;
    public FaceBuyModel d;
    public float e;
    public float f;
    public boolean g;
    public final Rect h;
    public final NoNetworkView.b i;
    public final BaseActivity<FacePackageDetailActivity>.LoadDataCallBack j;
    public final CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePackageDetailActivity a;

        public a(FacePackageDetailActivity facePackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = facePackageDetailActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.refresh();
                }
                this.a.b.c(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BaseActivity<FacePackageDetailActivity>.LoadDataCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePackageDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FacePackageDetailActivity facePackageDetailActivity) {
            super(facePackageDetailActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((BaseActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = facePackageDetailActivity;
        }

        @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
                this.a.hideProgressBar();
                Object obj = objArr[0];
                Boolean bool = (Boolean) objArr[1];
                if (obj != null && (obj instanceof FacePackageDetailData)) {
                    if (this.a.b != null) {
                        FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                        if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                            this.a.b.o(this.a.a);
                            if (bool.booleanValue()) {
                                this.a.showProgressBar();
                                return;
                            } else {
                                this.a.g = true;
                                return;
                            }
                        }
                        String str = facePackageDetailData.usermsg;
                        if (str != null) {
                            this.a.showToast(str);
                            return;
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
                            return;
                        }
                    }
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends i9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;
        public final /* synthetic */ FacePackageDetailActivity b;

        public c(FacePackageDetailActivity facePackageDetailActivity, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity, downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = facePackageDetailActivity;
            this.a = downloadData;
        }

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj != null && (obj instanceof FacePackageDownloadData)) {
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        String str = facePackageDownloadData.pack_url;
                        this.b.a.Z(str);
                        if (this.b.a.U() != null && this.b.a.U().faces_list != null) {
                            FacePackageDetailActivity facePackageDetailActivity = this.b;
                            facePackageDetailActivity.w1(facePackageDetailActivity.a.getPid(), this.b.a.U().faces_list.pname, str);
                            return;
                        }
                        return;
                    }
                    String str2 = facePackageDownloadData.usermsg;
                    if (str2 != null) {
                        this.b.showToast(str2);
                        return;
                    } else {
                        q47.f().i(this.a);
                        return;
                    }
                }
                q47.f().i(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends i9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePackageDetailActivity a;

        public d(FacePackageDetailActivity facePackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = facePackageDetailActivity;
        }

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                if (obj != null && (obj instanceof FaceBuyData)) {
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        FaceBuyData.BuyInfo buyInfo = faceBuyData.buy_info;
                        String str = buyInfo.buy_url;
                        String str2 = buyInfo.return_url;
                        if (buyInfo.buy_status != 2) {
                            this.a.a.c0(String.valueOf(faceBuyData.buy_info.order_id));
                            IntentConfig intentConfig = new IntentConfig(this.a.getActivity());
                            intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_URL, str);
                            intentConfig.getIntent().putExtra("tag_hook_url", str2);
                            intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_TITLE, this.a.getString(R.string.buy_book));
                            intentConfig.getIntent().putExtra("tag_position", 0);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2902013, intentConfig));
                            return;
                        }
                        this.a.showToast(R.string.has_buy_book);
                        FacePackageData facePackageData = this.a.a.U().faces_list;
                        facePackageData.buy_status = 1;
                        facePackageData.can_download = 1;
                        this.a.a.d0(facePackageData);
                        this.a.b.z();
                        return;
                    }
                    String str3 = faceBuyData.usermsg;
                    if (str3 != null) {
                        this.a.showToast(str3);
                        return;
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
                        return;
                    }
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends i9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePackageDetailActivity a;

        public e(FacePackageDetailActivity facePackageDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = facePackageDetailActivity;
        }

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj != null && (obj instanceof FaceBuyQueryData)) {
                    FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                    if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                        if (faceBuyQueryData.buy_result.status == 2) {
                            this.a.C1();
                            return;
                        } else {
                            this.a.B1();
                            return;
                        }
                    }
                    this.a.B1();
                    return;
                }
                this.a.B1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePackageDetailActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FacePackageDetailActivity facePackageDetailActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePackageDetailActivity, Integer.valueOf(i)};
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
            this.a = facePackageDetailActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.a == null || this.a.a.U() == null || this.a.b == null || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            FacePackageData facePackageData = this.a.a.U().faces_list;
            if (data.size() >= 1 && (downloadData = data.get(0)) != null && downloadData.getId().equals(this.a.a.getPid())) {
                int status = downloadData.getStatus();
                if (status != 3 && status != 0) {
                    if (status != 2 && status != 4) {
                        if (status == 1) {
                            facePackageData.downloading = 1;
                            facePackageData.downloaded = 0;
                            facePackageData.downloadTotal = downloadData.getSize();
                            facePackageData.downloadNow = downloadData.getLength();
                        }
                    } else {
                        if (!ei.isEmpty(downloadData.getStatusMsg())) {
                            this.a.showToast(downloadData.getStatusMsg());
                        }
                        if (this.a.c != null) {
                            this.a.c.cancelLoadData();
                        }
                        facePackageData.downloaded = 0;
                        facePackageData.downloading = 0;
                    }
                } else {
                    facePackageData.downloaded = 1;
                    facePackageData.downloading = 0;
                }
            }
            this.a.a.d0(facePackageData);
            this.a.b.w(this.a.a);
        }
    }

    public FacePackageDetailActivity() {
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
        this.g = false;
        this.h = new Rect();
        this.i = new a(this);
        this.j = new b(this);
        this.k = new f(this, 2001118);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            t47 t47Var = this.b;
            if (t47Var != null) {
                t47Var.l(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            y1(bundle);
            z1();
            refresh();
        }
    }

    public final boolean A1(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f2 - this.e;
            float f5 = f3 - this.f;
            if (Math.sqrt((f4 * f4) + (f5 * f5)) > getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07039d)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.r();
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.h();
            x1();
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.q(this.i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            FacePackageDetailModel facePackageDetailModel = this.a;
            if (facePackageDetailModel != null) {
                facePackageDetailModel.cancelLoadData();
            }
            FacePackageDownloadModel facePackageDownloadModel = this.c;
            if (facePackageDownloadModel != null) {
                facePackageDownloadModel.cancelLoadData();
            }
            FaceBuyModel faceBuyModel = this.d;
            if (faceBuyModel != null) {
                faceBuyModel.cancelLoadData();
            }
            D1();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            t47 t47Var = this.b;
            if (t47Var != null) {
                t47Var.p();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            t47 t47Var = this.b;
            if (t47Var != null) {
                t47Var.m();
            }
            super.onResume();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            showProgressBar();
            this.a.loadData();
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.b(this.i);
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            showProgressBar();
            String pid = this.a.getPid();
            FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
            this.d = faceBuyModel;
            faceBuyModel.setLoadDataCallBack(new d(this));
            this.d.T(pid);
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.b = new t47(getPageContext());
            t1();
            registerListener(this.k);
            q47.f();
        }
    }

    public final void E1(View view2, int i) {
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048580, this, view2, i) != null) || view2 == null) {
            return;
        }
        view2.getDrawingRect(this.h);
        ((ViewGroup) getWindow().getDecorView()).offsetDescendantRectToMyCoords(view2, this.h);
        if (this.a.U() != null && (facePackageData = this.a.U().faces_list) != null) {
            this.b.C(i, this.h, facePackageData);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r0 != 3) goto L19;
     */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
            }
            t47 t47Var = this.b;
            if (t47Var == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (t47Var.j()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        this.h.set(x, y, x + 1, y + 1);
                        GridView g = this.b.g();
                        ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(g, this.h);
                        Rect rect = this.h;
                        int pointToPosition = g.pointToPosition(rect.left, rect.top);
                        if (pointToPosition != -1) {
                            View childAt = g.getChildAt(pointToPosition - g.getFirstVisiblePosition());
                            if (A1(x, y)) {
                                E1(childAt, pointToPosition);
                            }
                        }
                    }
                    return true;
                }
                this.b.d();
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void y1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            FacePackageDetailModel facePackageDetailModel = new FacePackageDetailModel(this);
            this.a = facePackageDetailModel;
            if (bundle != null) {
                facePackageDetailModel.setStType(bundle.getString("st_type"));
                this.a.setPid(bundle.getString(IntentConfig.PKG_ID));
                this.a.a0(bundle.getBoolean(IntentConfig.IS_DOWNLOADING));
            } else {
                facePackageDetailModel.setStType(getIntent().getStringExtra("st_type"));
                this.a.setPid(getIntent().getStringExtra(IntentConfig.PKG_ID));
                this.a.a0(getIntent().getBooleanExtra(IntentConfig.IS_DOWNLOADING, false));
                TiebaStatic.log(getIntent().getStringExtra("st_type"));
            }
            this.a.b0(this.j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        FacePackageDetailModel facePackageDetailModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && this.b != null && (facePackageDetailModel = this.a) != null && facePackageDetailModel.U() != null) {
                if (i == 10001) {
                    String stringExtra = intent.getStringExtra("tag_order_id");
                    if (this.a.U().faces_list == null) {
                        return;
                    }
                    if (ei.isEmpty(stringExtra)) {
                        stringExtra = this.a.X();
                    }
                    this.b.y();
                    FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
                    this.d = faceBuyModel;
                    faceBuyModel.setLoadDataCallBack(new e(this));
                    this.d.U(stringExtra);
                } else if (i == 11003) {
                    if (this.a.U().faces_list.can_download == 1) {
                        x1();
                    } else {
                        v1();
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        t47 t47Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && this.a != null && (t47Var = this.b) != null) {
            if (view2 == t47Var.e()) {
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
                    return;
                } else if (!this.g) {
                    return;
                } else {
                    int Y = this.a.Y();
                    if (Y != 2 && Y != 3) {
                        if (Y == 4) {
                            TiebaStatic.log("emotion_package_detail_buy");
                            v1();
                        }
                    } else {
                        TiebaStatic.log("emotion_package_detail_free");
                        String V = this.a.V();
                        DownloadData downloadData = new DownloadData(this.a.getPid());
                        downloadData.setStatus(1);
                        downloadData.setStatusMsg(null);
                        downloadData.setType(11);
                        q47.f().i(downloadData);
                        if (!ei.isEmpty(V)) {
                            if (this.a.U() != null && this.a.U().faces_list != null) {
                                w1(this.a.getPid(), this.a.U().faces_list.pname, V);
                            } else {
                                return;
                            }
                        } else {
                            x1();
                        }
                    }
                }
            } else if (view2 == this.b.f()) {
                DownloadData downloadData2 = new DownloadData(this.a.getPid());
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                downloadData2.setType(11);
                q47.f().i(downloadData2);
                this.a.a0(false);
                q47.f().e(this.a.getPid());
            }
            super.onClick(view2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            E1(view2, i);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            FacePackageDetailModel facePackageDetailModel = this.a;
            if (facePackageDetailModel != null) {
                bundle.putString("st_type", facePackageDetailModel.getStType());
                bundle.putString(IntentConfig.PKG_ID, this.a.getPid());
                bundle.putBoolean(IntentConfig.IS_DOWNLOADING, this.a.W());
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void w1(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, str2, str3) == null) {
            q47.f().j(str, str2, str3);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            FacePackageDownloadModel facePackageDownloadModel = new FacePackageDownloadModel(getActivity());
            this.c = facePackageDownloadModel;
            facePackageDownloadModel.T(this.a.getPid());
            DownloadData downloadData = new DownloadData(this.a.getPid());
            downloadData.setType(11);
            downloadData.setStatus(2);
            downloadData.setStatusMsg(getResources().getString(R.string.obfuscated_res_0x7f0f0e40));
            this.c.setLoadDataCallBack(new c(this, downloadData));
        }
    }
}

package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsH5ItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42172e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42173f;

    /* renamed from: g  reason: collision with root package name */
    public final BaseWebView.f f42174g;

    /* renamed from: h  reason: collision with root package name */
    public final BaseWebView.e f42175h;

    /* renamed from: i  reason: collision with root package name */
    public final BaseWebView.h f42176i;

    /* renamed from: j  reason: collision with root package name */
    public final BaseWebView f42177j;
    public final LinearLayout k;
    public final View l;
    public boolean m;

    /* loaded from: classes5.dex */
    public class a implements BaseWebView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsH5ItemView f42178e;

        public a(FrsH5ItemView frsH5ItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsH5ItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42178e = frsH5ItemView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void a(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                if (!this.f42178e.f42172e) {
                    this.f42178e.j();
                    ViewGroup.LayoutParams layoutParams = this.f42178e.getLayoutParams();
                    layoutParams.height = (n.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
                    this.f42178e.setLayoutParams(layoutParams);
                }
                this.f42178e.m = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsH5ItemView f42179e;

        public b(FrsH5ItemView frsH5ItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsH5ItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42179e = frsH5ItemView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f42179e.f42173f = false;
                if (!this.f42179e.m) {
                    this.f42179e.i();
                    ViewGroup.LayoutParams layoutParams = this.f42179e.getLayoutParams();
                    layoutParams.height = -2;
                    this.f42179e.setLayoutParams(layoutParams);
                }
                this.f42179e.f42172e = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsH5ItemView a;

        public c(FrsH5ItemView frsH5ItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsH5ItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsH5ItemView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                this.a.k();
                this.a.m = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsH5ItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42172e = false;
        this.f42173f = false;
        this.f42174g = new a(this);
        this.f42175h = new b(this);
        this.f42176i = new c(this);
        this.m = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (n.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90)));
        BaseWebView baseWebView = new BaseWebView(TbadkCoreApplication.getInst());
        this.f42177j = baseWebView;
        baseWebView.setOnPageStartedListener(this.f42174g);
        this.f42177j.setOnPageFinishedListener(this.f42175h);
        this.f42177j.setOnReceivedErrorListener(this.f42176i);
        addView(this.f42177j);
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_no_list_item_view, (ViewGroup) this, false);
        this.l = inflate;
        inflate.setVisibility(8);
        addView(this.l);
        this.k = (LinearLayout) FrameLayout.inflate(getContext(), R.layout.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds140);
        addView(this.k, layoutParams);
    }

    public BaseWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42177j : (BaseWebView) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f42177j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
    }

    public boolean isWebViewLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42173f : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l.setVisibility(8);
            this.k.setVisibility(0);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (n.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
            setLayoutParams(layoutParams);
            this.f42177j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public void setWebViewLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f42173f = z;
        }
    }
}

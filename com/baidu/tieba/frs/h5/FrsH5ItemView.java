package com.baidu.tieba.frs.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import b.a.e.e.p.l;
import b.a.r0.x0.c1;
import b.a.r0.x0.f1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FrsH5ItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48758e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48759f;

    /* renamed from: g  reason: collision with root package name */
    public final BaseWebView.f f48760g;

    /* renamed from: h  reason: collision with root package name */
    public final BaseWebView.e f48761h;

    /* renamed from: i  reason: collision with root package name */
    public final BaseWebView.h f48762i;
    public final BaseWebView j;
    public final LinearLayout k;
    public final View l;
    public boolean m;

    /* loaded from: classes9.dex */
    public class a implements BaseWebView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsH5ItemView f48763e;

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
            this.f48763e = frsH5ItemView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void a(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                if (!this.f48763e.f48758e) {
                    this.f48763e.j();
                    ViewGroup.LayoutParams layoutParams = this.f48763e.getLayoutParams();
                    layoutParams.height = (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c1.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c1.ds90);
                    this.f48763e.setLayoutParams(layoutParams);
                }
                this.f48763e.m = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsH5ItemView f48764e;

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
            this.f48764e = frsH5ItemView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f48764e.f48759f = false;
                if (!this.f48764e.m) {
                    this.f48764e.i();
                    ViewGroup.LayoutParams layoutParams = this.f48764e.getLayoutParams();
                    layoutParams.height = -2;
                    this.f48764e.setLayoutParams(layoutParams);
                }
                this.f48764e.f48758e = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsH5ItemView f48765a;

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
            this.f48765a = frsH5ItemView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                this.f48765a.k();
                this.f48765a.m = true;
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
        this.f48758e = false;
        this.f48759f = false;
        this.f48760g = new a(this);
        this.f48761h = new b(this);
        this.f48762i = new c(this);
        this.m = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c1.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c1.ds90)));
        BaseWebView baseWebView = new BaseWebView(TbadkCoreApplication.getInst());
        this.j = baseWebView;
        baseWebView.setOnPageStartedListener(this.f48760g);
        this.j.setOnPageFinishedListener(this.f48761h);
        this.j.setOnReceivedErrorListener(this.f48762i);
        addView(this.j);
        View inflate = LayoutInflater.from(context).inflate(f1.frs_no_list_item_view, (ViewGroup) this, false);
        this.l = inflate;
        inflate.setVisibility(8);
        addView(this.l);
        this.k = (LinearLayout) FrameLayout.inflate(getContext(), f1.custom_loading_toast, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(context.getResources().getDimensionPixelSize(c1.ds220), -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(c1.ds140);
        addView(this.k, layoutParams);
    }

    public BaseWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (BaseWebView) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
    }

    public boolean isWebViewLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48759f : invokeV.booleanValue;
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
            layoutParams.height = (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c1.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c1.ds90);
            setLayoutParams(layoutParams);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public void setWebViewLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f48759f = z;
        }
    }
}

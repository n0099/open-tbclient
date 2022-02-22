package com.baidu.tbadk.widget.tiejia;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.u0.a4.d;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaNodeJNIBase;
/* loaded from: classes12.dex */
public class TiePlusDownloadDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f41787e;

    /* renamed from: f  reason: collision with root package name */
    public View f41788f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f41789g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41790h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41791i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41792j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public ProgressButton o;
    public final TiePlusHelper p;
    public final boolean q;
    public String r;
    public String s;
    public String t;
    public String u;
    public c v;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiePlusDownloadDialog f41793e;

        public a(TiePlusDownloadDialog tiePlusDownloadDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusDownloadDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41793e = tiePlusDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41793e.p.onClick(view);
                if (this.f41793e.v != null) {
                    this.f41793e.v.a();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiePlusDownloadDialog f41794e;

        public b(TiePlusDownloadDialog tiePlusDownloadDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusDownloadDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41794e = tiePlusDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41794e.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiePlusDownloadDialog(@NonNull Context context, TiePlusHelper tiePlusHelper, boolean z) {
        super(context, true, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tiePlusHelper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = tiePlusHelper;
        this.q = z;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int k = n.k(getContext());
            if (k < 975.0d) {
                return 759;
            }
            return (k * 322) / 414;
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f41788f = findViewById(g.divider);
            this.f41789g = (TbImageView) findViewById(g.app_icon);
            this.f41790h = (TextView) findViewById(g.app_title);
            this.f41791i = (TextView) findViewById(g.app_version);
            this.f41792j = (TextView) findViewById(g.app_company);
            this.k = (TextView) findViewById(g.app_permisson);
            this.l = (TextView) findViewById(g.app_privacy);
            this.m = (TextView) findViewById(g.download_cancel);
            this.o = (ProgressButton) findViewById(g.download_btn);
            this.n = (ImageView) findViewById(g.window_close);
            this.f41789g.setPlaceHolder(2);
            this.f41789g.setConrers(15);
            onSkinChanged();
            this.l.setTag(Byte.valueOf((byte) YogaNodeJNIBase.HAS_NEW_LAYOUT));
            this.k.setTag((byte) 17);
            this.m.setTag((byte) 18);
            if (!StringUtils.isNull(this.r)) {
                this.f41790h.setText(this.r);
            }
            if (!StringUtils.isNull(this.u)) {
                this.f41789g.startLoad(this.u, 10, false);
            }
            if (!StringUtils.isNull(this.s)) {
                this.f41791i.setText(String.format(getContext().getString(j.app_version_long), this.s));
            }
            if (!StringUtils.isNull(this.t)) {
                this.f41792j.setText(String.format(getContext().getString(j.developer_name), this.t));
            }
            this.k.setOnClickListener(this.p);
            this.l.setOnClickListener(this.p);
            this.m.setOnClickListener(this.p);
            this.o.setOnClickListener(new a(this));
            this.o.setUseLongText(true);
            this.n.setOnClickListener(new b(this));
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            this.p.f(this.o);
            if (this.q) {
                MessageManager.getInstance().registerListener(this.p);
            }
            if (StringUtils.isNull(this.p.p()) || StringUtils.isNull(this.p.m())) {
                return;
            }
            TiePlusHelper tiePlusHelper = this.p;
            tiePlusHelper.Y(tiePlusHelper.p(), this.p.m(), getContext(), this.o);
            TiePlusHelper tiePlusHelper2 = this.p;
            tiePlusHelper2.X(tiePlusHelper2.p(), getContext(), this.m);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawableResource(d.transparent);
            View inflate = getLayoutInflater().inflate(h.tie_plus_download_dialog, (ViewGroup) null);
            this.f41787e = inflate;
            setContentView(inflate);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = c();
            getWindow().setAttributes(attributes);
            d();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            this.p.B(this.o);
            if (this.q) {
                MessageManager.getInstance().unRegisterListener(this.p);
            }
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.f41787e);
            d2.n(j.J_X06);
            d2.f(d.CAM_X0201);
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.f41790h);
            d3.A(j.F_X02);
            d3.v(d.CAM_X0105);
            c.a.t0.s.v.c.d(this.f41791i).v(d.CAM_X0108);
            c.a.t0.s.v.c.d(this.f41792j).v(d.CAM_X0108);
            c.a.t0.s.v.c.d(this.k).v(d.CAM_X0304);
            c.a.t0.s.v.c.d(this.l).v(d.CAM_X0304);
            c.a.t0.s.v.c.d(this.m).v(d.CAM_X0107);
            c.a.t0.s.v.c.d(this.f41788f).f(d.CAM_X0107);
            WebPManager.setPureDrawable(this.n, f.icon_pure_dialog_close22, d.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.o.onSkinChanged();
        }
    }

    public TiePlusDownloadDialog setAppCompany(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.t = str;
            return this;
        }
        return (TiePlusDownloadDialog) invokeL.objValue;
    }

    public TiePlusDownloadDialog setAppIcon(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.u = str;
            return this;
        }
        return (TiePlusDownloadDialog) invokeL.objValue;
    }

    public TiePlusDownloadDialog setAppTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.r = str;
            return this;
        }
        return (TiePlusDownloadDialog) invokeL.objValue;
    }

    public TiePlusDownloadDialog setAppVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.s = str;
            return this;
        }
        return (TiePlusDownloadDialog) invokeL.objValue;
    }

    public void setDownloadClickCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.v = cVar;
        }
    }
}

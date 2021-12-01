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
import c.a.d.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaNodeJNIBase;
/* loaded from: classes9.dex */
public class TiePlusDownloadDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f42386e;

    /* renamed from: f  reason: collision with root package name */
    public View f42387f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f42388g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42389h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42390i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42391j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f42392k;
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

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiePlusDownloadDialog f42393e;

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
            this.f42393e = tiePlusDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42393e.p.onClick(view);
                if (this.f42393e.v != null) {
                    this.f42393e.v.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiePlusDownloadDialog f42394e;

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
            this.f42394e = tiePlusDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42394e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
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
            int k2 = l.k(getContext());
            if (k2 < 975.0d) {
                return 759;
            }
            return (k2 * 322) / 414;
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f42387f = findViewById(R.id.divider);
            this.f42388g = (TbImageView) findViewById(R.id.app_icon);
            this.f42389h = (TextView) findViewById(R.id.app_title);
            this.f42390i = (TextView) findViewById(R.id.app_version);
            this.f42391j = (TextView) findViewById(R.id.app_company);
            this.f42392k = (TextView) findViewById(R.id.app_permisson);
            this.l = (TextView) findViewById(R.id.app_privacy);
            this.m = (TextView) findViewById(R.id.download_cancel);
            this.o = (ProgressButton) findViewById(R.id.download_btn);
            this.n = (ImageView) findViewById(R.id.window_close);
            this.f42388g.setPlaceHolder(2);
            this.f42388g.setConrers(15);
            onSkinChanged();
            this.l.setTag(Byte.valueOf((byte) YogaNodeJNIBase.HAS_NEW_LAYOUT));
            this.f42392k.setTag((byte) 17);
            this.m.setTag((byte) 18);
            if (!StringUtils.isNull(this.r)) {
                this.f42389h.setText(this.r);
            }
            if (!StringUtils.isNull(this.u)) {
                this.f42388g.startLoad(this.u, 10, false);
            }
            if (!StringUtils.isNull(this.s)) {
                this.f42390i.setText(String.format(getContext().getString(R.string.app_version_long), this.s));
            }
            if (!StringUtils.isNull(this.t)) {
                this.f42391j.setText(String.format(getContext().getString(R.string.developer_name), this.t));
            }
            this.f42392k.setOnClickListener(this.p);
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
            tiePlusHelper.a0(tiePlusHelper.p(), this.p.m(), getContext(), this.o);
            TiePlusHelper tiePlusHelper2 = this.p;
            tiePlusHelper2.Z(tiePlusHelper2.p(), getContext(), this.m);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            View inflate = getLayoutInflater().inflate(R.layout.tie_plus_download_dialog, (ViewGroup) null);
            this.f42386e = inflate;
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
            this.p.z(this.o);
            if (this.q) {
                MessageManager.getInstance().unRegisterListener(this.p);
            }
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f42386e);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.f42389h);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            c.a.q0.s.u.c.d(this.f42390i).v(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.f42391j).v(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.f42392k).v(R.color.CAM_X0304);
            c.a.q0.s.u.c.d(this.l).v(R.color.CAM_X0304);
            c.a.q0.s.u.c.d(this.m).v(R.color.CAM_X0107);
            c.a.q0.s.u.c.d(this.f42387f).f(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_dialog_close22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
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

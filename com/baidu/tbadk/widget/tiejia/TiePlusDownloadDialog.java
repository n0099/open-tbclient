package com.baidu.tbadk.widget.tiejia;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.q0;
import c.a.q0.s.u.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TiePlusDownloadDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f49051e;

    /* renamed from: f  reason: collision with root package name */
    public View f49052f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f49053g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49054h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49055i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f49056j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ProgressButton n;
    public final q0 o;
    public final boolean p;
    public String q;
    public String r;
    public String s;
    public String t;
    public b u;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TiePlusDownloadDialog f49057e;

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
            this.f49057e = tiePlusDownloadDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49057e.o.onClick(view);
                if (this.f49057e.u != null) {
                    this.f49057e.u.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiePlusDownloadDialog(@NonNull Context context, q0 q0Var, boolean z) {
        super(context, true, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, q0Var, Boolean.valueOf(z)};
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
        this.o = q0Var;
        this.p = z;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f49052f = findViewById(R.id.divider);
            this.f49053g = (TbImageView) findViewById(R.id.app_icon);
            this.f49054h = (TextView) findViewById(R.id.app_title);
            this.f49055i = (TextView) findViewById(R.id.app_version);
            this.f49056j = (TextView) findViewById(R.id.app_company);
            this.k = (TextView) findViewById(R.id.app_permisson);
            this.l = (TextView) findViewById(R.id.app_privacy);
            this.m = (TextView) findViewById(R.id.download_cancel);
            this.n = (ProgressButton) findViewById(R.id.download_btn);
            this.f49053g.setPlaceHolder(2);
            this.f49053g.setConrers(15);
            onSkinChanged();
            this.l.setTag((byte) 16);
            this.k.setTag((byte) 17);
            this.m.setTag((byte) 18);
            if (!StringUtils.isNull(this.q)) {
                this.f49054h.setText(this.q);
            }
            if (!StringUtils.isNull(this.t)) {
                this.f49053g.startLoad(this.t, 10, false);
            }
            if (!StringUtils.isNull(this.r)) {
                this.f49055i.setText(String.format(getContext().getString(R.string.app_version_long), this.r));
            }
            if (!StringUtils.isNull(this.s)) {
                this.f49056j.setText(String.format(getContext().getString(R.string.developer_name), this.s));
            }
            this.k.setOnClickListener(this.o);
            this.l.setOnClickListener(this.o);
            this.m.setOnClickListener(this.o);
            this.n.setOnClickListener(new a(this));
            this.n.setUseLongText(true);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            this.o.d(this.n);
            if (this.p) {
                MessageManager.getInstance().registerListener(this.o);
            }
            if (StringUtils.isNull(this.o.h()) || StringUtils.isNull(this.o.g())) {
                return;
            }
            q0 q0Var = this.o;
            q0Var.y(q0Var.h(), this.o.g(), getContext(), this.n);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            View inflate = getLayoutInflater().inflate(R.layout.tie_plus_download_dialog, (ViewGroup) null);
            this.f49051e = inflate;
            setContentView(inflate);
            c();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.o.o(this.n);
            if (this.p) {
                MessageManager.getInstance().unRegisterListener(this.o);
            }
        }
    }

    public void onSkinChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c d2 = c.d(this.f49051e);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            c d3 = c.d(this.f49054h);
            d3.B(R.string.F_X02);
            d3.w(R.color.CAM_X0105);
            c.d(this.f49055i).w(R.color.CAM_X0108);
            c.d(this.f49056j).w(R.color.CAM_X0108);
            c.d(this.k).w(R.color.CAM_X0304);
            c.d(this.l).w(R.color.CAM_X0304);
            c.d(this.m).w(R.color.CAM_X0107);
            c.d(this.f49052f).f(R.color.CAM_X0107);
            this.n.onSkinChanged();
        }
    }

    public TiePlusDownloadDialog setAppCompany(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.s = str;
            return this;
        }
        return (TiePlusDownloadDialog) invokeL.objValue;
    }

    public TiePlusDownloadDialog setAppIcon(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.t = str;
            return this;
        }
        return (TiePlusDownloadDialog) invokeL.objValue;
    }

    public TiePlusDownloadDialog setAppTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.q = str;
            return this;
        }
        return (TiePlusDownloadDialog) invokeL.objValue;
    }

    public TiePlusDownloadDialog setAppVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.r = str;
            return this;
        }
        return (TiePlusDownloadDialog) invokeL.objValue;
    }

    public void setDownloadClickCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.u = bVar;
        }
    }
}

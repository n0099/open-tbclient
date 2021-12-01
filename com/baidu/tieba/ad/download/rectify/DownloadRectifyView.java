package com.baidu.tieba.ad.download.rectify;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.l;
import c.a.q0.s.q.c;
import c.a.r0.h3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DownloadRectifyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f42591e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f42592f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42593g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42594h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42595i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42596j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f42597k;
    public TextView l;
    public TextView m;
    public FrameLayout n;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.b f42598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadRectifyView f42599f;

        public a(DownloadRectifyView downloadRectifyView, c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadRectifyView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42599f = downloadRectifyView;
            this.f42598e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f42599f.getContext();
                c.b bVar = this.f42598e;
                z.d(context, bVar.f12880b, null, null, bVar.f12881c);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a f42600e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadRectifyView f42601f;

        public b(DownloadRectifyView downloadRectifyView, c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadRectifyView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42601f = downloadRectifyView;
            this.f42600e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f42601f.getContext();
                c.a aVar = this.f42600e;
                z.d(context, aVar.f12878b, null, null, aVar.f12879c);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadRectifyView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.webview_download_audit_view, this);
            this.f42591e = (ImageView) inflate.findViewById(R.id.im_close);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_app_logo);
            this.f42592f = tbImageView;
            tbImageView.setRadius(l.d(context, 9.0f));
            this.f42592f.setConrers(15);
            this.f42593g = (TextView) inflate.findViewById(R.id.tv_app_name);
            this.f42594h = (TextView) inflate.findViewById(R.id.tv_app_size);
            this.f42595i = (TextView) inflate.findViewById(R.id.tv_version);
            this.f42596j = (TextView) inflate.findViewById(R.id.tv_company_name);
            this.f42597k = (TextView) inflate.findViewById(R.id.tv_privacy);
            this.l = (TextView) inflate.findViewById(R.id.tv_permission);
            this.m = (TextView) inflate.findViewById(R.id.tv_download_tip);
            this.n = (FrameLayout) inflate.findViewById(R.id.download_view_container);
        }
    }

    public void bindData(c.a.r0.v.g.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null && aVar.f24630b != null) {
                this.m.setText(aVar.f24631c);
                this.m.setVisibility(aVar.a != 2 ? 0 : 8);
                c cVar = aVar.f24630b;
                this.f42592f.startLoad(cVar.f12869b, 30, false);
                this.f42593g.setText(cVar.f12870c);
                this.f42594h.setText(cVar.f12876i);
                this.f42596j.setText(cVar.f12871d);
                this.f42595i.setText(cVar.f12873f);
                c.b bVar = cVar.f12874g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f12880b) && !TextUtils.isEmpty(bVar.a)) {
                    this.f42597k.setText(bVar.a);
                    this.f42597k.setOnClickListener(new a(this, bVar));
                }
                c.a aVar2 = cVar.f12875h;
                if (aVar2 == null || TextUtils.isEmpty(aVar2.f12878b) || TextUtils.isEmpty(aVar2.a)) {
                    return;
                }
                this.l.setText(aVar2.a);
                this.l.setOnClickListener(new b(this, aVar2));
                return;
            }
            setVisibility(8);
        }
    }

    public void setDownloadView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.n.addView(view);
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f42591e.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadRectifyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }
}

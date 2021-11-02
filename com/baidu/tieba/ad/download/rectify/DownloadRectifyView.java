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
import b.a.e.e.p.l;
import b.a.q0.s.q.c;
import b.a.r0.z2.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class DownloadRectifyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f46686e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f46687f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46688g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46689h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46690i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public FrameLayout n;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.b f46691e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadRectifyView f46692f;

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
            this.f46692f = downloadRectifyView;
            this.f46691e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                z.d(this.f46692f.getContext(), this.f46691e.f13250b, null, null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a f46693e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadRectifyView f46694f;

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
            this.f46694f = downloadRectifyView;
            this.f46693e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                z.d(this.f46694f.getContext(), this.f46693e.f13248b, null, null);
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
            this.f46686e = (ImageView) inflate.findViewById(R.id.im_close);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_app_logo);
            this.f46687f = tbImageView;
            tbImageView.setRadius(l.e(context, 9.0f));
            this.f46687f.setConrers(15);
            this.f46688g = (TextView) inflate.findViewById(R.id.tv_app_name);
            this.f46689h = (TextView) inflate.findViewById(R.id.tv_app_size);
            this.f46690i = (TextView) inflate.findViewById(R.id.tv_version);
            this.j = (TextView) inflate.findViewById(R.id.tv_company_name);
            this.k = (TextView) inflate.findViewById(R.id.tv_privacy);
            this.l = (TextView) inflate.findViewById(R.id.tv_permission);
            this.m = (TextView) inflate.findViewById(R.id.tv_download_tip);
            this.n = (FrameLayout) inflate.findViewById(R.id.download_view_container);
        }
    }

    public void bindData(b.a.r0.r.e.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar != null && aVar.f22998b != null) {
                this.m.setText(aVar.f22999c);
                this.m.setVisibility(aVar.f22997a != 2 ? 0 : 8);
                c cVar = aVar.f22998b;
                this.f46687f.startLoad(cVar.f13239b, 30, false);
                this.f46688g.setText(cVar.f13240c);
                this.f46689h.setText(cVar.f13246i);
                this.j.setText(cVar.f13241d);
                this.f46690i.setText(cVar.f13243f);
                c.b bVar = cVar.f13244g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f13250b) && !TextUtils.isEmpty(bVar.f13249a)) {
                    this.k.setText(bVar.f13249a);
                    this.k.setOnClickListener(new a(this, bVar));
                }
                c.a aVar2 = cVar.f13245h;
                if (aVar2 == null || TextUtils.isEmpty(aVar2.f13248b) || TextUtils.isEmpty(aVar2.f13247a)) {
                    return;
                }
                this.l.setText(aVar2.f13247a);
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
            this.f46686e.setOnClickListener(onClickListener);
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

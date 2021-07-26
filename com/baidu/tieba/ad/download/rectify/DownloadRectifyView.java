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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.q.c;
import d.a.q0.w2.x;
/* loaded from: classes3.dex */
public class DownloadRectifyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13805e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f13806f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13807g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13808h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13809i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public FrameLayout n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.b f13810e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadRectifyView f13811f;

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
            this.f13811f = downloadRectifyView;
            this.f13810e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                x.d(this.f13811f.getContext(), this.f13810e.f53267b, null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a f13812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadRectifyView f13813f;

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
            this.f13813f = downloadRectifyView;
            this.f13812e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                x.d(this.f13813f.getContext(), this.f13812e.f53265b, null, null);
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

    public void a(d.a.q0.q.d.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null && aVar.f62092b != null) {
                this.m.setText(aVar.f62093c);
                this.m.setVisibility(aVar.f62091a != 2 ? 0 : 8);
                c cVar = aVar.f62092b;
                this.f13806f.M(cVar.f53256b, 30, false);
                this.f13807g.setText(cVar.f53257c);
                this.f13808h.setText(cVar.f53263i);
                this.j.setText(cVar.f53258d);
                this.f13809i.setText(cVar.f53260f);
                c.b bVar = cVar.f53261g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f53267b) && !TextUtils.isEmpty(bVar.f53266a)) {
                    this.k.setText(bVar.f53266a);
                    this.k.setOnClickListener(new a(this, bVar));
                }
                c.a aVar2 = cVar.f53262h;
                if (aVar2 == null || TextUtils.isEmpty(aVar2.f53265b) || TextUtils.isEmpty(aVar2.f53264a)) {
                    return;
                }
                this.l.setText(aVar2.f53264a);
                this.l.setOnClickListener(new b(this, aVar2));
                return;
            }
            setVisibility(8);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.webview_download_audit_view, this);
            this.f13805e = (ImageView) inflate.findViewById(R.id.im_close);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv_app_logo);
            this.f13806f = tbImageView;
            tbImageView.setRadius(l.e(context, 9.0f));
            this.f13806f.setConrers(15);
            this.f13807g = (TextView) inflate.findViewById(R.id.tv_app_name);
            this.f13808h = (TextView) inflate.findViewById(R.id.tv_app_size);
            this.f13809i = (TextView) inflate.findViewById(R.id.tv_version);
            this.j = (TextView) inflate.findViewById(R.id.tv_company_name);
            this.k = (TextView) inflate.findViewById(R.id.tv_privacy);
            this.l = (TextView) inflate.findViewById(R.id.tv_permission);
            this.m = (TextView) inflate.findViewById(R.id.tv_download_tip);
            this.n = (FrameLayout) inflate.findViewById(R.id.download_view_container);
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
            this.f13805e.setOnClickListener(onClickListener);
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
        b(context);
    }
}

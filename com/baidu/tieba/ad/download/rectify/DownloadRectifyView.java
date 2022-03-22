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
import c.a.d.f.p.n;
import c.a.o0.r.r.c;
import c.a.p0.l3.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DownloadRectifyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f31134b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31135c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31136d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31137e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f31138f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31139g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f31140h;
    public TextView i;
    public FrameLayout j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DownloadRectifyView f31141b;

        public a(DownloadRectifyView downloadRectifyView, c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadRectifyView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31141b = downloadRectifyView;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f31141b.getContext();
                c.b bVar = this.a;
                a0.d(context, bVar.f10820b, null, null, bVar.f10821c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DownloadRectifyView f31142b;

        public b(DownloadRectifyView downloadRectifyView, c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadRectifyView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31142b = downloadRectifyView;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f31142b.getContext();
                c.a aVar = this.a;
                a0.d(context, aVar.f10818b, null, null, aVar.f10819c);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(c.a.p0.x.g.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null && aVar.f20621b != null) {
                this.i.setText(aVar.f20622c);
                this.i.setVisibility(aVar.a != 2 ? 0 : 8);
                c cVar = aVar.f20621b;
                this.f31134b.J(cVar.f10811b, 30, false);
                this.f31135c.setText(cVar.f10812c);
                this.f31136d.setText(cVar.i);
                this.f31138f.setText(cVar.f10813d);
                this.f31137e.setText(cVar.f10815f);
                c.b bVar = cVar.f10816g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f10820b) && !TextUtils.isEmpty(bVar.a)) {
                    this.f31139g.setText(bVar.a);
                    this.f31139g.setOnClickListener(new a(this, bVar));
                }
                c.a aVar2 = cVar.f10817h;
                if (aVar2 == null || TextUtils.isEmpty(aVar2.f10818b) || TextUtils.isEmpty(aVar2.a)) {
                    return;
                }
                this.f31140h.setText(aVar2.a);
                this.f31140h.setOnClickListener(new b(this, aVar2));
                return;
            }
            setVisibility(8);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08bd, this);
            this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e59);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090fc1);
            this.f31134b = tbImageView;
            tbImageView.setRadius(n.d(context, 9.0f));
            this.f31134b.setConrers(15);
            this.f31135c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092183);
            this.f31136d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092185);
            this.f31137e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09222a);
            this.f31138f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092193);
            this.f31139g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921fc);
            this.f31140h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921ed);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921a3);
            this.j = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09082c);
        }
    }

    public void setDownloadView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.j.addView(view);
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

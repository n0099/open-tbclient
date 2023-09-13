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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d15;
import com.baidu.tieba.j3a;
import com.baidu.tieba.l66;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DownloadRectifyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public FrameLayout j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d15.c a;
        public final /* synthetic */ DownloadRectifyView b;

        public a(DownloadRectifyView downloadRectifyView, d15.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadRectifyView, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = downloadRectifyView;
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.b.getContext();
                d15.c cVar = this.a;
                j3a.a(context, cVar.b, null, null, cVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d15.b a;
        public final /* synthetic */ DownloadRectifyView b;

        public b(DownloadRectifyView downloadRectifyView, d15.b bVar) {
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
            this.b = downloadRectifyView;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.b.getContext();
                d15.b bVar = this.a;
                j3a.a(context, bVar.b, null, null, bVar.c);
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

    public void a(l66 l66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l66Var) == null) {
            int i = 8;
            if (l66Var != null && l66Var.b != null) {
                this.i.setText(l66Var.c);
                TextView textView = this.i;
                if (l66Var.a != 2) {
                    i = 0;
                }
                textView.setVisibility(i);
                d15 d15Var = l66Var.b;
                this.b.startLoad(d15Var.b, 30, false);
                this.c.setText(d15Var.c);
                this.d.setText(d15Var.j);
                this.f.setText(d15Var.d);
                this.e.setText(d15Var.f);
                d15.c cVar = d15Var.g;
                if (cVar != null && !TextUtils.isEmpty(cVar.b) && !TextUtils.isEmpty(cVar.a)) {
                    this.g.setText(cVar.a);
                    this.g.setOnClickListener(new a(this, cVar));
                }
                d15.b bVar = d15Var.h;
                if (bVar != null && !TextUtils.isEmpty(bVar.b) && !TextUtils.isEmpty(bVar.a)) {
                    this.h.setText(bVar.a);
                    this.h.setOnClickListener(new b(this, bVar));
                    return;
                }
                return;
            }
            setVisibility(8);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0a34, this);
            this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091054);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09120e);
            this.b = tbImageView;
            tbImageView.setRadius(BdUtilHelper.dip2px(context, 9.0f));
            this.b.setConrers(15);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09272c);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09272e);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0927fb);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092743);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0927c3);
            this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0927b3);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092757);
            this.j = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09094b);
        }
    }

    public void setDownloadView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.j.addView(view2);
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }
}

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
import com.baidu.tieba.nx9;
import com.baidu.tieba.s05;
import com.baidu.tieba.y46;
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
        public final /* synthetic */ s05.b a;
        public final /* synthetic */ DownloadRectifyView b;

        public a(DownloadRectifyView downloadRectifyView, s05.b bVar) {
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
                s05.b bVar = this.a;
                nx9.a(context, bVar.b, null, null, bVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s05.a a;
        public final /* synthetic */ DownloadRectifyView b;

        public b(DownloadRectifyView downloadRectifyView, s05.a aVar) {
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
            this.b = downloadRectifyView;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.b.getContext();
                s05.a aVar = this.a;
                nx9.a(context, aVar.b, null, null, aVar.c);
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

    public void a(y46 y46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, y46Var) == null) {
            int i = 8;
            if (y46Var != null && y46Var.b != null) {
                this.i.setText(y46Var.c);
                TextView textView = this.i;
                if (y46Var.a != 2) {
                    i = 0;
                }
                textView.setVisibility(i);
                s05 s05Var = y46Var.b;
                this.b.startLoad(s05Var.b, 30, false);
                this.c.setText(s05Var.c);
                this.d.setText(s05Var.i);
                this.f.setText(s05Var.d);
                this.e.setText(s05Var.f);
                s05.b bVar = s05Var.g;
                if (bVar != null && !TextUtils.isEmpty(bVar.b) && !TextUtils.isEmpty(bVar.a)) {
                    this.g.setText(bVar.a);
                    this.g.setOnClickListener(new a(this, bVar));
                }
                s05.a aVar = s05Var.h;
                if (aVar != null && !TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(aVar.a)) {
                    this.h.setText(aVar.a);
                    this.h.setOnClickListener(new b(this, aVar));
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0a19, this);
            this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091044);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0911f2);
            this.b = tbImageView;
            tbImageView.setRadius(BdUtilHelper.dip2px(context, 9.0f));
            this.b.setConrers(15);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0926ca);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0926cc);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092797);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0926e1);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09275f);
            this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09274f);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0926f5);
            this.j = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090947);
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

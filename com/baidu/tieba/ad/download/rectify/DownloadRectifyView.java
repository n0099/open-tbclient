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
import com.baidu.tieba.b36;
import com.baidu.tieba.hw4;
import com.baidu.tieba.wha;
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
        public final /* synthetic */ hw4.c a;
        public final /* synthetic */ DownloadRectifyView b;

        public a(DownloadRectifyView downloadRectifyView, hw4.c cVar) {
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
                hw4.c cVar = this.a;
                wha.a(context, cVar.b, null, null, cVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw4.b a;
        public final /* synthetic */ DownloadRectifyView b;

        public b(DownloadRectifyView downloadRectifyView, hw4.b bVar) {
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
                hw4.b bVar = this.a;
                wha.a(context, bVar.b, null, null, bVar.c);
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

    public void a(b36 b36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b36Var) == null) {
            int i = 8;
            if (b36Var != null && b36Var.b != null) {
                this.i.setText(b36Var.c);
                TextView textView = this.i;
                if (b36Var.a != 2) {
                    i = 0;
                }
                textView.setVisibility(i);
                hw4 hw4Var = b36Var.b;
                this.b.startLoad(hw4Var.b, 30, false);
                this.c.setText(hw4Var.c);
                this.d.setText(hw4Var.j);
                this.f.setText(hw4Var.d);
                this.e.setText(hw4Var.f);
                hw4.c cVar = hw4Var.g;
                if (cVar != null && !TextUtils.isEmpty(cVar.b) && !TextUtils.isEmpty(cVar.a)) {
                    this.g.setText(cVar.a);
                    this.g.setOnClickListener(new a(this, cVar));
                }
                hw4.b bVar = hw4Var.h;
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0a4f, this);
            this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0910c1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09127f);
            this.b = tbImageView;
            tbImageView.setRadius(BdUtilHelper.dip2px(context, 9.0f));
            this.b.setConrers(15);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0927d7);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0927d8);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0928a0);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0927ec);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092868);
            this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09285a);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0927ff);
            this.j = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09099c);
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

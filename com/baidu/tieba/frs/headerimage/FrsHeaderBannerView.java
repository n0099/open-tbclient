package com.baidu.tieba.frs.headerimage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsHeaderBannerView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f45162e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45163f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45164g;

    /* renamed from: h  reason: collision with root package name */
    public View f45165h;

    /* renamed from: i  reason: collision with root package name */
    public View f45166i;

    /* renamed from: j  reason: collision with root package name */
    public String f45167j;

    /* renamed from: k  reason: collision with root package name */
    public TbPageContext f45168k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsHeaderBannerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    private TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            TbPageContext tbPageContext = this.f45168k;
            if (tbPageContext != null) {
                return tbPageContext;
            }
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.f45168k = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.f45168k = ((BaseFragmentActivity) context).getPageContext();
            }
            return this.f45168k;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void hideTitle() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = this.f45165h) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(g1.frs_header_banner, (ViewGroup) this, true);
            this.f45165h = inflate.findViewById(f1.frs_header_title_container);
            this.f45162e = (TbImageView) inflate.findViewById(f1.frs_head_image);
            this.f45163f = (TextView) inflate.findViewById(f1.frs_header_title);
            this.f45164g = (TextView) inflate.findViewById(f1.frs_header_title_lable);
            this.f45166i = inflate.findViewById(f1.frs_image_header_contianer);
            this.f45162e.setOnClickListener(this);
            this.f45165h.setOnClickListener(this);
            this.f45166i.setOnClickListener(this);
            this.f45162e.setDefaultResource(0);
            this.f45162e.setRadius(n.f(getContext(), d1.tbds20));
            this.f45162e.setConrers(15);
            this.f45162e.setPlaceHolder(2);
            this.f45164g.setText(getContext().getString(i1.frs_header_image_lable));
            this.f45168k = getTbPageContext();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            TextView textView = this.f45164g;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, c1.CAM_X0107, i2);
                SkinManager.setBackgroundResource(this.f45164g, e1.frs_header_text_bg, i2);
            }
            TextView textView2 = this.f45163f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, c1.CAM_X0101, i2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            TbPageContext<?> tbPageContext = getTbPageContext();
            if (TextUtils.isEmpty(this.f45167j) || tbPageContext == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.f45167j}, true);
        }
    }

    public void setSchemaUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f45167j = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f45163f == null || this.f45164g == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f45163f.setText(str);
            this.f45164g.setVisibility(0);
            this.f45163f.setVisibility(0);
            return;
        }
        this.f45164g.setVisibility(8);
        this.f45163f.setVisibility(8);
    }

    public void startLoad(String str) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (tbImageView = this.f45162e) == null) {
            return;
        }
        tbImageView.startLoad(str, 33, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsHeaderBannerView(Context context, AttributeSet attributeSet) {
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
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsHeaderBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init();
    }
}

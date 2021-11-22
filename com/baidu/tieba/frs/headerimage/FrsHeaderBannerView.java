package com.baidu.tieba.frs.headerimage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
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
/* loaded from: classes9.dex */
public class FrsHeaderBannerView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f49630e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49631f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49632g;

    /* renamed from: h  reason: collision with root package name */
    public View f49633h;

    /* renamed from: i  reason: collision with root package name */
    public View f49634i;
    public String j;
    public TbPageContext k;

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
            TbPageContext tbPageContext = this.k;
            if (tbPageContext != null) {
                return tbPageContext;
            }
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.k = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.k = ((BaseFragmentActivity) context).getPageContext();
            }
            return this.k;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void hideTitle() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = this.f49633h) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(g1.frs_header_banner, (ViewGroup) this, true);
            this.f49633h = inflate.findViewById(f1.frs_header_title_container);
            this.f49630e = (TbImageView) inflate.findViewById(f1.frs_head_image);
            this.f49631f = (TextView) inflate.findViewById(f1.frs_header_title);
            this.f49632g = (TextView) inflate.findViewById(f1.frs_header_title_lable);
            this.f49634i = inflate.findViewById(f1.frs_image_header_contianer);
            this.f49630e.setOnClickListener(this);
            this.f49633h.setOnClickListener(this);
            this.f49634i.setOnClickListener(this);
            this.f49630e.setDefaultResource(0);
            this.f49630e.setRadius(l.g(getContext(), d1.tbds20));
            this.f49630e.setConrers(15);
            this.f49630e.setPlaceHolder(2);
            this.f49632g.setText(getContext().getString(i1.frs_header_image_lable));
            this.k = getTbPageContext();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            TextView textView = this.f49632g;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, c1.CAM_X0107, i2);
                SkinManager.setBackgroundResource(this.f49632g, e1.frs_header_text_bg, i2);
            }
            TextView textView2 = this.f49631f;
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
            if (TextUtils.isEmpty(this.j) || tbPageContext == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.j}, true);
        }
    }

    public void setSchemaUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.j = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f49631f == null || this.f49632g == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f49631f.setText(str);
            this.f49632g.setVisibility(0);
            this.f49631f.setVisibility(0);
            return;
        }
        this.f49632g.setVisibility(8);
        this.f49631f.setVisibility(8);
    }

    public void startLoad(String str) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (tbImageView = this.f49630e) == null) {
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

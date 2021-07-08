package com.baidu.tieba.frs.headerimage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FrsHeaderBannerView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f15901e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15902f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15903g;

    /* renamed from: h  reason: collision with root package name */
    public View f15904h;

    /* renamed from: i  reason: collision with root package name */
    public View f15905i;
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
        a();
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.frs_header_banner, (ViewGroup) this, true);
            this.f15904h = inflate.findViewById(R.id.frs_header_title_container);
            this.f15901e = (TbImageView) inflate.findViewById(R.id.frs_head_image);
            this.f15902f = (TextView) inflate.findViewById(R.id.frs_header_title);
            this.f15903g = (TextView) inflate.findViewById(R.id.frs_header_title_lable);
            this.f15905i = inflate.findViewById(R.id.frs_image_header_contianer);
            this.f15901e.setOnClickListener(this);
            this.f15904h.setOnClickListener(this);
            this.f15905i.setOnClickListener(this);
            this.f15901e.setDefaultResource(0);
            this.f15901e.setRadius(l.g(getContext(), R.dimen.tbds20));
            this.f15901e.setConrers(15);
            this.f15901e.setPlaceHolder(2);
            this.f15903g.setText(getContext().getString(R.string.frs_header_image_lable));
            this.k = getTbPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            TbPageContext<?> tbPageContext = getTbPageContext();
            if (TextUtils.isEmpty(this.j) || tbPageContext == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.j}, true);
        }
    }

    public void setSchemaUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.j = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f15902f == null || this.f15903g == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f15902f.setText(str);
            this.f15903g.setVisibility(0);
            this.f15902f.setVisibility(0);
            return;
        }
        this.f15903g.setVisibility(8);
        this.f15902f.setVisibility(8);
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
        a();
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
        a();
    }
}

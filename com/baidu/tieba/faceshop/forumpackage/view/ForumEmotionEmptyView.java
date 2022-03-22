package com.baidu.tieba.faceshop.forumpackage.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ForumEmotionEmptyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public NoDataView f32154b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f32155c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32156d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f32157e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32158f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionEmptyView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02b3, this);
            this.f32156d = (TextView) findViewById(R.id.obfuscated_res_0x7f090a2f);
            this.f32157e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090a30);
            this.f32158f = (TextView) findViewById(R.id.obfuscated_res_0x7f090a2b);
            this.f32155c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090a34);
            NoDataView b2 = NoDataViewFactory.b(this.a.getPageActivity(), this.f32155c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, 0), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0938), null, true);
            this.f32154b = b2;
            b2.setVisibility(0);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            NoDataView noDataView = this.f32154b;
            if (noDataView != null) {
                noDataView.f(this.a, i);
            }
            SkinManager.setViewTextColor(this.f32157e.getChildAt(0), (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f32157e.getChildAt(0), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f32157e.getChildAt(1), (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f32157e.getChildAt(1), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f32158f, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f32156d, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        }
    }

    public ViewGroup getFilterDropDownView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32157e : (ViewGroup) invokeV.objValue;
    }

    public TextView getFilterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32156d : (TextView) invokeV.objValue;
    }
}

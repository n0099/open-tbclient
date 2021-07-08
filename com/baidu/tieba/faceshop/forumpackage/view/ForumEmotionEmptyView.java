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
/* loaded from: classes4.dex */
public class ForumEmotionEmptyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15172e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f15173f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f15174g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15175h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f15176i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionEmptyView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.f15172e = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_empty_layout, this);
            this.f15175h = (TextView) findViewById(R.id.forum_emotion_filter);
            this.f15176i = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
            this.j = (TextView) findViewById(R.id.forum_emotion_board_title);
            this.f15174g = (LinearLayout) findViewById(R.id.forum_emotion_no_data_container);
            NoDataView b2 = NoDataViewFactory.b(this.f15172e.getPageActivity(), this.f15174g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, 0), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, true);
            this.f15173f = b2;
            b2.setVisibility(0);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            NoDataView noDataView = this.f15173f;
            if (noDataView != null) {
                noDataView.f(this.f15172e, i2);
            }
            SkinManager.setViewTextColor(this.f15176i.getChildAt(0), R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f15176i.getChildAt(0), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f15176i.getChildAt(1), R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f15176i.getChildAt(1), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f15175h, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        }
    }

    public ViewGroup getFilterDropDownView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15176i : (ViewGroup) invokeV.objValue;
    }

    public TextView getFilterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15175h : (TextView) invokeV.objValue;
    }
}

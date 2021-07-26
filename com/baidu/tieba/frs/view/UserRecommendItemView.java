package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class UserRecommendItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ClickableHeaderImageView f16296e;

    /* renamed from: f  reason: collision with root package name */
    public CardUserLikeButton f16297f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16298g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16299h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16300i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserRecommendItemView f16301e;

        public a(UserRecommendItemView userRecommendItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userRecommendItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16301e = userRecommendItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16301e.f16296e.onClick(this.f16301e.f16296e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserRecommendItemView(Context context) {
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
        this.f16300i = false;
        this.j = -1;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_user_recommend_item, (ViewGroup) this, true);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
            this.f16296e = clickableHeaderImageView;
            clickableHeaderImageView.setAutoChangeStyle(true);
            this.f16296e.setDefaultResource(17170445);
            this.f16296e.setIsRound(true);
            this.f16296e.setScaleType(ImageView.ScaleType.FIT_XY);
            CardUserLikeButton cardUserLikeButton = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
            this.f16297f = cardUserLikeButton;
            cardUserLikeButton.setGravity(17);
            this.f16298g = (TextView) findViewById(R.id.user_recommend_username);
            this.f16299h = (TextView) findViewById(R.id.user_recommend_fans_num);
            setOrientation(1);
            setFocusable(true);
            setClickable(true);
            setDescendantFocusability(262144);
            setOnClickListener(new a(this));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.j) {
            return;
        }
        this.j = i2;
        this.f16299h.setTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
        if (this.f16300i) {
            this.f16298g.setTextColor(SkinManager.getColor(i2, R.color.cp_cont_r));
        } else {
            this.f16298g.setTextColor(SkinManager.getColor(i2, R.color.CAM_X0105));
        }
        setBackgroundColor(SkinManager.getColor(i2, R.color.CAM_X0201));
        this.f16297f.g(i2);
        this.f16296e.setPlaceHolder(1);
    }

    public TextView getFansNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16299h : (TextView) invokeV.objValue;
    }

    public ClickableHeaderImageView getHeaderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16296e : (ClickableHeaderImageView) invokeV.objValue;
    }

    public CommonUserLikeButton getLikeBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16297f : (CommonUserLikeButton) invokeV.objValue;
    }

    public TextView getUsername() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16298g : (TextView) invokeV.objValue;
    }

    public void setIsGod(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f16300i == z) {
            return;
        }
        this.f16300i = z;
        if (z) {
            this.f16298g.setTextColor(SkinManager.getColor(this.j, R.color.cp_cont_r));
        } else {
            this.f16298g.setTextColor(SkinManager.getColor(this.j, R.color.CAM_X0105));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserRecommendItemView(Context context, AttributeSet attributeSet) {
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
        this.f16300i = false;
        this.j = -1;
        b(context);
    }
}

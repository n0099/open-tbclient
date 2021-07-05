package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f14458e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14459f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14460g;

    /* renamed from: h  reason: collision with root package name */
    public int f14461h;

    /* renamed from: i  reason: collision with root package name */
    public String f14462i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardFrsGameRecommendGameItemView f14463e;

        public a(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardFrsGameRecommendGameItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14463e = cardFrsGameRecommendGameItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof String)) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 10).param("fid", this.f14463e.f14462i));
                d.a.r0.l.a.l(this.f14463e.getContext(), (String) view.getTag());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameRecommendGameItemView(Context context) {
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
        this.f14461h = 3;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
            this.f14458e = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.f14458e.setDefaultResource(17170445);
            this.f14458e.setDefaultBgResource(R.color.CAM_X0205);
            this.f14458e.setDrawerType(1);
            this.f14458e.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
            this.f14458e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14458e.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.f14458e.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
            this.f14459f = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
            this.f14460g = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
            setOrientation(1);
            setFocusable(true);
            setClickable(true);
            setDescendantFocusability(262144);
            setOnClickListener(new a(this));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.f14461h) {
            return;
        }
        this.f14461h = i2;
        SkinManager.setViewTextColor(this.f14459f, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.f14460g, R.color.CAM_X0109, 1);
    }

    public TextView getGameDscView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14460g : (TextView) invokeV.objValue;
    }

    public TextView getGameNameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14459f : (TextView) invokeV.objValue;
    }

    public TbImageView getGamePicView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14458e : (TbImageView) invokeV.objValue;
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f14462i = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f14461h = 3;
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f14461h = 3;
        b(context);
    }
}

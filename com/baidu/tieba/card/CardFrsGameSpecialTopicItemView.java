package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.e.a.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CardFrsGameSpecialTopicItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f49831e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f49832f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49833g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49834h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49835i;

    /* renamed from: j  reason: collision with root package name */
    public View f49836j;
    public View k;
    public String l;
    public int mSkinType;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardFrsGameSpecialTopicItemView f49837e;

        public a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardFrsGameSpecialTopicItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49837e = cardFrsGameSpecialTopicItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof String)) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 5).param("fid", this.f49837e.l));
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f49837e.getContext()), new String[]{(String) view.getTag()}, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameSpecialTopicItemView(Context context) {
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
        this.mSkinType = 3;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.card_frs_game_special_topic_view_item, (ViewGroup) this, true);
            this.f49831e = (RelativeLayout) findViewById(R.id.card_frs_game_special_topic_layout);
            this.f49832f = (TbImageView) findViewById(R.id.card_frs_game_special_topic_img);
            this.f49833g = (TextView) findViewById(R.id.card_frs_game_special_topic_title);
            this.f49834h = (TextView) findViewById(R.id.card_frs_game_special_topic_dsc);
            this.f49835i = (TextView) findViewById(R.id.card_frs_game_special_topic_update_time);
            this.f49836j = findViewById(R.id.divider_line_1);
            this.k = findViewById(R.id.divider_line_2);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f49831e.getLayoutParams();
            layoutParams.width = (dimensionPixelSize * 21) / 9;
            layoutParams.height = dimensionPixelSize;
            this.f49831e.setLayoutParams(layoutParams);
            setOrientation(1);
            setFocusable(true);
            setClickable(true);
            setDescendantFocusability(262144);
            setOnClickListener(new a(this));
        }
    }

    public TextView getSpecialTopicDscView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49834h : (TextView) invokeV.objValue;
    }

    public TextView getSpecialTopicNameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49833g : (TextView) invokeV.objValue;
    }

    public TbImageView getSpecialTopicPicView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49832f : (TbImageView) invokeV.objValue;
    }

    public TextView getSpecialTopicUpdateTimeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49835i : (TextView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        SkinManager.setBackgroundResource(this.f49836j, R.color.CAM_X0205);
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f49833g, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f49834h, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f49835i, R.color.CAM_X0101, 1);
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameSpecialTopicItemView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.mSkinType = 3;
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameSpecialTopicItemView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.mSkinType = 3;
        b(context);
    }
}

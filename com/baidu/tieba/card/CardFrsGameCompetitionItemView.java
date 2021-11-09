package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.a.e.a.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f47392e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f47393f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f47394g;

    /* renamed from: h  reason: collision with root package name */
    public ClickableHeaderImageView f47395h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47396i;
    public RelativeLayout j;
    public TextView k;
    public ClickableHeaderImageView l;
    public TextView m;
    public int mSkinType;
    public ClickableHeaderImageView n;
    public TextView o;
    public TextView p;
    public String q;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardFrsGameCompetitionItemView f47397e;

        public a(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardFrsGameCompetitionItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47397e = cardFrsGameCompetitionItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof String)) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 7).param("fid", this.f47397e.q));
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f47397e.getContext()), new String[]{(String) view.getTag()}, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameCompetitionItemView(Context context) {
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
            LayoutInflater.from(context).inflate(R.layout.card_frs_game_competition_view_item, (ViewGroup) this, true);
            this.f47392e = (RelativeLayout) findViewById(R.id.card_competition_layout);
            this.f47393f = (TbImageView) findViewById(R.id.card_competition_bg);
            this.f47394g = (LinearLayout) findViewById(R.id.card_competition_title_layout);
            this.f47395h = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
            this.f47396i = (TextView) findViewById(R.id.card_competition_title);
            this.j = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
            this.k = (TextView) findViewById(R.id.card_competition_vs);
            this.l = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
            this.m = (TextView) findViewById(R.id.card_competition_left_name);
            this.n = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
            this.o = (TextView) findViewById(R.id.card_competition_right_name);
            this.p = (TextView) findViewById(R.id.card_competition_btn_discuss);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
            int i2 = (dimensionPixelSize * 21) / 9;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f47393f.getLayoutParams();
            layoutParams.height = dimensionPixelSize;
            layoutParams.width = i2;
            this.f47393f.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f47392e.getLayoutParams();
            layoutParams2.height = dimensionPixelSize;
            layoutParams2.width = i2;
            this.f47392e.setLayoutParams(layoutParams2);
            this.f47393f.setDefaultBgResource(R.drawable.icon_morenpic);
            this.f47395h.setDrawBorder(true);
            this.f47395h.setDrawerType(1);
            this.f47395h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
            this.f47395h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f47395h.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.f47395h.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.l.setDefaultResource(17170445);
            this.l.setDefaultBgResource(R.color.CAM_X0205);
            this.l.setIsRound(true);
            this.l.setDrawBorder(true);
            this.l.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.l.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.n.setDefaultResource(17170445);
            this.n.setDefaultBgResource(R.color.CAM_X0205);
            this.n.setIsRound(true);
            this.n.setDrawBorder(true);
            this.n.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.n.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
            setOnClickListener(new a(this));
        }
    }

    public void bindDataToView(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, featureCardCompetitionSubNode) == null) {
            this.f47395h.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
            this.f47393f.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
            this.f47396i.setText(featureCardCompetitionSubNode.title);
            this.l.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
            this.m.setText(featureCardCompetitionSubNode.team1_name);
            this.n.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
            this.o.setText(featureCardCompetitionSubNode.team2_name);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.mSkinType != i2) {
                SkinManager.setViewTextColor(this.f47396i, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0101, 1);
            }
            this.mSkinType = i2;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.q = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameCompetitionItemView(Context context, @Nullable AttributeSet attributeSet) {
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
    public CardFrsGameCompetitionItemView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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

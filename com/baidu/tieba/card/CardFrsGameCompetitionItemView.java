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
import d.a.c.a.j;
/* loaded from: classes5.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f14446e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f14447f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f14448g;

    /* renamed from: h  reason: collision with root package name */
    public ClickableHeaderImageView f14449h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14450i;
    public RelativeLayout j;
    public TextView k;
    public ClickableHeaderImageView l;
    public TextView m;
    public ClickableHeaderImageView n;
    public TextView o;
    public TextView p;
    public String q;
    public int r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardFrsGameCompetitionItemView f14451e;

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
            this.f14451e = cardFrsGameCompetitionItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof String)) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 7).param("fid", this.f14451e.q));
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f14451e.getContext()), new String[]{(String) view.getTag()}, true);
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
        this.r = 3;
        c(context);
    }

    public void b(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, featureCardCompetitionSubNode) == null) {
            this.f14449h.M(featureCardCompetitionSubNode.competition_logo, 10, false);
            this.f14447f.M(featureCardCompetitionSubNode.competition_image, 10, false);
            this.f14450i.setText(featureCardCompetitionSubNode.title);
            this.l.M(featureCardCompetitionSubNode.team1_image, 10, false);
            this.m.setText(featureCardCompetitionSubNode.team1_name);
            this.n.M(featureCardCompetitionSubNode.team2_image, 10, false);
            this.o.setText(featureCardCompetitionSubNode.team2_name);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.card_frs_game_competition_view_item, (ViewGroup) this, true);
            this.f14446e = (RelativeLayout) findViewById(R.id.card_competition_layout);
            this.f14447f = (TbImageView) findViewById(R.id.card_competition_bg);
            this.f14448g = (LinearLayout) findViewById(R.id.card_competition_title_layout);
            this.f14449h = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
            this.f14450i = (TextView) findViewById(R.id.card_competition_title);
            this.j = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
            this.k = (TextView) findViewById(R.id.card_competition_vs);
            this.l = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
            this.m = (TextView) findViewById(R.id.card_competition_left_name);
            this.n = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
            this.o = (TextView) findViewById(R.id.card_competition_right_name);
            this.p = (TextView) findViewById(R.id.card_competition_btn_discuss);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
            int i2 = (dimensionPixelSize * 21) / 9;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14447f.getLayoutParams();
            layoutParams.height = dimensionPixelSize;
            layoutParams.width = i2;
            this.f14447f.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f14446e.getLayoutParams();
            layoutParams2.height = dimensionPixelSize;
            layoutParams2.width = i2;
            this.f14446e.setLayoutParams(layoutParams2);
            this.f14447f.setDefaultBgResource(R.drawable.icon_morenpic);
            this.f14449h.setDrawBorder(true);
            this.f14449h.setDrawerType(1);
            this.f14449h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
            this.f14449h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14449h.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.f14449h.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
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

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.r != i2) {
                SkinManager.setViewTextColor(this.f14450i, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0101, 1);
            }
            this.r = i2;
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
        this.r = 3;
        c(context);
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
        this.r = 3;
        c(context);
    }
}

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
import com.baidu.tieba.m9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public TbImageView b;
    public LinearLayout c;
    public ClickableHeaderImageView d;
    public TextView e;
    public RelativeLayout f;
    public TextView g;
    public ClickableHeaderImageView h;
    public TextView i;
    public ClickableHeaderImageView j;
    public TextView k;
    public TextView l;
    public String m;
    public int n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardFrsGameCompetitionItemView a;

        public a(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardFrsGameCompetitionItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardFrsGameCompetitionItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof String)) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 7).param("fid", this.a.m));
                UrlManager.getInstance().dealOneLink((TbPageContext) m9.a(this.a.getContext()), new String[]{(String) view2.getTag()}, true);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 3;
        c(context);
    }

    public void b(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, featureCardCompetitionSubNode) == null) {
            this.d.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
            this.b.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
            this.e.setText(featureCardCompetitionSubNode.title);
            this.h.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
            this.i.setText(featureCardCompetitionSubNode.team1_name);
            this.j.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
            this.k.setText(featureCardCompetitionSubNode.team2_name);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 3;
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameCompetitionItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = 3;
        c(context);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.n != i) {
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0101, 1);
            }
            this.n = i;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01b6, (ViewGroup) this, true);
            this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090583);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090580);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09058a);
            this.d = (ClickableHeaderImageView) findViewById(R.id.obfuscated_res_0x7f090589);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090588);
            this.f = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090582);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09058b);
            this.h = (ClickableHeaderImageView) findViewById(R.id.obfuscated_res_0x7f090584);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090585);
            this.j = (ClickableHeaderImageView) findViewById(R.id.obfuscated_res_0x7f090586);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f090587);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090581);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
            int i = (dimensionPixelSize * 21) / 9;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.height = dimensionPixelSize;
            layoutParams.width = i;
            this.b.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams2.height = dimensionPixelSize;
            layoutParams2.width = i;
            this.a.setLayoutParams(layoutParams2);
            this.b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080a79);
            this.d.setDrawBorder(true);
            this.d.setDrawerType(1);
            this.d.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
            this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.d.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.h.setDefaultResource(17170445);
            this.h.setDefaultBgResource(R.color.CAM_X0205);
            this.h.setIsRound(true);
            this.h.setDrawBorder(true);
            this.h.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.h.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.j.setDefaultResource(17170445);
            this.j.setDefaultBgResource(R.color.CAM_X0205);
            this.j.setIsRound(true);
            this.j.setDrawBorder(true);
            this.j.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.j.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
            setOnClickListener(new a(this));
        }
    }
}

package com.baidu.tieba.frs.gamepaltform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15768e;

    /* renamed from: f  reason: collision with root package name */
    public b f15769f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.x0.a f15770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15771f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ GameRankHorizontalLayout f15772g;

        public a(GameRankHorizontalLayout gameRankHorizontalLayout, d.a.q0.x0.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRankHorizontalLayout, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15772g = gameRankHorizontalLayout;
            this.f15770e = aVar;
            this.f15771f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15772g.f15769f == null) {
                return;
            }
            this.f15772g.f15769f.a(this.f15770e, this.f15771f);
            if (d.a.p0.s.d0.b.j().k("game_rank_list_show_times", 0) != 0) {
                d.a.p0.s.d0.b.j().v("game_rank_list_show_times", 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.a.q0.x0.a aVar, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRankHorizontalLayout(Context context) {
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
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setFillViewport(true);
            setHorizontalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f15768e = linearLayout;
            addView(linearLayout, -1, -1);
        }
    }

    public final View c(d.a.q0.x0.a aVar, int i2) {
        InterceptResult invokeLI;
        RoundAngleRelativeLayout roundAngleRelativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2)) == null) {
            if (aVar == null) {
                return null;
            }
            if (!StringUtils.isNull(aVar.b())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.game_rank_week_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.head_img);
                headImageView.setIsRound(true);
                headImageView.M(aVar.b(), 10, false);
                ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.week_card_bg)).M(aVar.b(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.game_rank_normal_card, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.head_img);
                headImageView2.setIsRound(true);
                headImageView2.M(aVar.f(), 10, false);
                ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.normal_card_bg)).M(aVar.f(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.user_name)).setText(aVar.e());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.rank_title)).setText(aVar.g());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.user_rank)).setText(getContext().getString(R.string.game_rank_no, aVar.d()));
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.rank_des)).setText(aVar.a());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new a(this, aVar, i2));
            }
            return roundAngleRelativeLayout;
        }
        return (View) invokeLI.objValue;
    }

    public void setData(d.a.q0.x0.b bVar) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (linearLayout = this.f15768e) == null || bVar == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (ListUtils.isEmpty(bVar.c())) {
            return;
        }
        for (int i2 = 0; i2 < bVar.c().size(); i2++) {
            View c2 = c(bVar.c().get(i2), i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.ds468), l.g(getContext(), R.dimen.ds190));
            if (i2 != 0) {
                layoutParams.leftMargin = l.g(getContext(), R.dimen.ds8);
            } else {
                layoutParams.leftMargin = l.g(getContext(), R.dimen.ds40);
            }
            if (i2 == bVar.c().size() - 1) {
                layoutParams.rightMargin = l.g(getContext(), R.dimen.ds40);
            } else {
                layoutParams.rightMargin = 0;
            }
            c2.setLayoutParams(layoutParams);
            this.f15768e.addView(c2);
        }
    }

    public void setOnCardClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f15769f = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet) {
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
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet, int i2) {
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
        b(context);
    }
}

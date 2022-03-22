package com.baidu.tieba.frs.gamepaltform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes5.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public b f32564b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.i1.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f32565b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GameRankHorizontalLayout f32566c;

        public a(GameRankHorizontalLayout gameRankHorizontalLayout, c.a.p0.i1.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRankHorizontalLayout, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32566c = gameRankHorizontalLayout;
            this.a = aVar;
            this.f32565b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f32566c.f32564b == null) {
                return;
            }
            this.f32566c.f32564b.a(this.a, this.f32565b);
            if (c.a.o0.r.j0.b.k().l("game_rank_list_show_times", 0) != 0) {
                c.a.o0.r.j0.b.k().w("game_rank_list_show_times", 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(c.a.p0.i1.a aVar, int i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.a = linearLayout;
            addView(linearLayout, -1, -1);
        }
    }

    public final View c(c.a.p0.i1.a aVar, int i) {
        InterceptResult invokeLI;
        RoundAngleRelativeLayout roundAngleRelativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i)) == null) {
            if (aVar == null) {
                return null;
            }
            if (!StringUtils.isNull(aVar.b())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d037a, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f090d21);
                headImageView.setIsRound(true);
                headImageView.J(aVar.b(), 10, false);
                ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f09245f)).J(aVar.b(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0379, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f090d21);
                headImageView2.setIsRound(true);
                headImageView2.J(aVar.f(), 10, false);
                ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0915b1)).J(aVar.f(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0922bb)).setText(aVar.e());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0919b8)).setText(aVar.g());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0922ca)).setText(getContext().getString(R.string.obfuscated_res_0x7f0f077a, aVar.d()));
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0919b1)).setText(aVar.a());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new a(this, aVar, i));
            }
            return roundAngleRelativeLayout;
        }
        return (View) invokeLI.objValue;
    }

    public void setData(c.a.p0.i1.b bVar) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (linearLayout = this.a) == null || bVar == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (ListUtils.isEmpty(bVar.b())) {
            return;
        }
        for (int i = 0; i < bVar.b().size(); i++) {
            View c2 = c(bVar.b().get(i), i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c2), n.f(getContext(), R.dimen.obfuscated_res_0x7f07025e));
            if (i != 0) {
                layoutParams.leftMargin = n.f(getContext(), R.dimen.obfuscated_res_0x7f0702fb);
            } else {
                layoutParams.leftMargin = n.f(getContext(), R.dimen.obfuscated_res_0x7f070225);
            }
            if (i == bVar.b().size() - 1) {
                layoutParams.rightMargin = n.f(getContext(), R.dimen.obfuscated_res_0x7f070225);
            } else {
                layoutParams.rightMargin = 0;
            }
            c2.setLayoutParams(layoutParams);
            this.a.addView(c2);
        }
    }

    public void setOnCardClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f32564b = bVar;
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
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet, int i) {
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
        b(context);
    }
}

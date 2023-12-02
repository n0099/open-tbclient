package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CardLiveLabelView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Context b;
    public LinearLayout c;
    public TBLottieAnimationView d;
    public View e;
    public TextView f;
    public RelativeLayout g;
    public TBLottieAnimationView h;
    public TextView i;
    public View j;
    public RelativeLayout k;
    public View l;

    /* loaded from: classes5.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardLiveLabelView a;

        public a(CardLiveLabelView cardLiveLabelView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardLiveLabelView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardLiveLabelView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.d.cancelAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardLiveLabelView a;

        public b(CardLiveLabelView cardLiveLabelView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardLiveLabelView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardLiveLabelView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.h.cancelAnimation();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardLiveLabelView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a == 1) {
            if (TextUtils.isEmpty(str)) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
                return;
            }
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.f.setText(str);
        }
    }

    public void setViewType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
            if (i == 1 || i == 2) {
                this.l = LayoutInflater.from(this.b).inflate(R.layout.layout_ala_live_card_label_a, (ViewGroup) null, false);
                e();
            }
            View view2 = this.l;
            if (view2 != null) {
                this.k.addView(view2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardLiveLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardLiveLabelView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 1;
        this.l = null;
        this.b = context;
        d();
    }

    public void h(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (textView = this.i) != null) {
            textView.setText(str);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.a;
            if (i != 1) {
                if (i == 2) {
                    EMManager.from(this.c).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0605);
                    EMManager.from(this.j).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0310);
                    SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
                    EMManager.from(this.i).setTextSize(R.dimen.T_X09);
                    return;
                }
                return;
            }
            float dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds31);
            SkinManager.setBackgroundEndColorToAutoColor(this.c, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = (RelativeLayout) LayoutInflater.from(this.b).inflate(R.layout.layout_ala_live_card_label, this).findViewById(R.id.obfuscated_res_0x7f092083);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = this.a;
            if (i == 1 || i == 2) {
                c();
            }
        }
    }

    public int getViewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = (LinearLayout) this.l.findViewById(R.id.ala_live_lottie_bg);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.l.findViewById(R.id.ala_live_lottie);
            this.d = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.d, R.raw.ala_live2);
            this.d.addOnAttachStateChangeListener(new a(this));
            this.e = this.l.findViewById(R.id.play_count_line);
            this.f = (TextView) this.l.findViewById(R.id.play_count);
            this.g = (RelativeLayout) this.l.findViewById(R.id.ala_live_lottie_container_home);
            this.h = (TBLottieAnimationView) this.l.findViewById(R.id.ala_live_lottie_home);
            this.i = (TextView) this.l.findViewById(R.id.ala_live_state_home);
            this.j = this.l.findViewById(R.id.ala_live_lottie_view_home);
            this.h.loop(true);
            this.h.setLifecycleEnable(true);
            SkinManager.setLottieAnimation(this.h, R.raw.lottie_ala_live);
            this.h.addOnAttachStateChangeListener(new b(this));
            int i = this.a;
            if (i != 1) {
                if (i == 2) {
                    this.g.setVisibility(0);
                    this.i.setVisibility(0);
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                    this.f.setVisibility(8);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            this.i.setVisibility(8);
        }
    }
}

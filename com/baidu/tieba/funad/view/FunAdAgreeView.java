package com.baidu.tieba.funad.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.f0.f;
import d.a.r0.r.q.b2;
import d.a.s0.h3.h0.e;
/* loaded from: classes5.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16225e;

    /* renamed from: f  reason: collision with root package name */
    public TBLottieAnimationView f16226f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16227g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f16228h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16229i;
    public AgreeData j;
    public e k;
    public ScaleAnimation l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public LinearLayout t;
    public LinearLayout u;
    public boolean v;
    public boolean w;
    public d x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdAgreeView f16230a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FunAdAgreeView funAdAgreeView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdAgreeView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16230a = funAdAgreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f61216b;
                if (this.f16230a.j == null || agreeData == null || this.f16230a.k == null || this.f16230a.j.isInPost || this.f16230a.k.f61215a == eVar.f61215a) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (this.f16230a.j.baijiahaoData == null || !TextUtils.equals(str, this.f16230a.j.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f16230a.m(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f16230a.j.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f16230a.m(agreeData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdAgreeView f16231a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FunAdAgreeView funAdAgreeView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdAgreeView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16231a = funAdAgreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f61216b;
                if (this.f16231a.j == null || TextUtils.isEmpty(this.f16231a.j.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.f16231a.j.postId.equals(agreeData.postId) || this.f16231a.j.isInThread) {
                    return;
                }
                if (this.f16231a.m) {
                    if (this.f16231a.j.indexOfPic == agreeData.indexOfPic) {
                        return;
                    }
                } else if (this.f16231a.k.f61215a == eVar.f61215a) {
                    return;
                }
                this.f16231a.m(agreeData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunAdAgreeView f16232e;

        public c(FunAdAgreeView funAdAgreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdAgreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16232e = funAdAgreeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16232e.l(view);
                View.OnClickListener onClickListener = this.f16232e.s;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(View view, boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdAgreeView(Context context) {
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
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.v = false;
        this.w = false;
        this.y = new a(this, 2016528);
        this.z = new b(this, 2016530);
        this.A = new c(this);
        i(context);
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, textView) == null) {
            if (this.n) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.m) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.q));
            }
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                k(l.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.v);
                return;
            }
            k(l.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.v);
        }
    }

    public final String g(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, agreeData)) == null) {
            long j = agreeData != null ? agreeData.agreeNum : 0L;
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 == 0) {
                return getContext().getString(R.string.fun_ad_agree_view_c_agree);
            }
            if (i2 > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16227g : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16229i : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16226f : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16228h : (TBLottieAnimationView) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TbPageContext tbPageContext = getTbPageContext();
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.l == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.l = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.l;
        }
        return (Animation) invokeV.objValue;
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f16225e == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.f16225e = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.f16225e = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.f16225e;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final String h(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, agreeData)) == null) ? g(agreeData) : (String) invokeL.objValue;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            setOrientation(0);
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
            this.f16226f = tBLottieAnimationView;
            tBLottieAnimationView.setId(R.id.img_agree);
            this.f16226f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f16226f.setOnClickListener(this.A);
            this.f16226f.addAnimatorListener(this);
            TextView textView = new TextView(context);
            this.f16227g = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X09));
            this.f16227g.setOnClickListener(this.A);
            TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
            this.f16228h = tBLottieAnimationView2;
            tBLottieAnimationView2.setId(R.id.img_disagree);
            this.f16228h.addAnimatorListener(this);
            this.f16228h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f16228h.setOnClickListener(this.A);
            TextView textView2 = new TextView(context);
            this.f16229i = textView2;
            textView2.setText(R.string.fun_ad_agree_view_c_disagree);
            this.f16229i.setTextSize(0, l.g(context, R.dimen.T_X09));
            this.f16229i.setOnClickListener(this.A);
            e eVar = new e();
            this.k = eVar;
            eVar.f61215a = getPageId();
            j();
            setAgreeAnimationResource();
            setAgreeAlone(true);
            setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.u = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.addView(this.f16226f);
            linearLayout.addView(this.f16227g);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.t = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.addView(this.f16228h);
            linearLayout2.addView(this.f16229i);
            f(true);
        }
    }

    public final void k(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            int i6 = -l.g(getContext(), R.dimen.tbds24);
            int g2 = l.g(getContext(), R.dimen.tbds34);
            this.u.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f2 = i4;
            layoutParams.weight = f2;
            this.u.setLayoutParams(layoutParams);
            this.f16226f.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.f16227g.setLayoutParams(layoutParams2);
            this.t.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f2;
            this.t.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = g2;
            this.f16228h.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.f16229i.setLayoutParams(layoutParams5);
        }
    }

    public final void l(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || this.j == null) {
            return;
        }
        if (!this.m || f.a(getContext())) {
            if (this.m || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f16227g || this.w) {
                    if (view.getId() != this.f16226f.getId() && (!this.w || view.getId() != this.f16227g.getId())) {
                        if (view.getId() == this.f16228h.getId()) {
                            this.f16228h.cancelAnimation();
                            AgreeData agreeData = this.j;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    n();
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    o(false);
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                o(false);
                            }
                            d.a.r0.i0.c f2 = TbPageExtraHelper.f(this);
                            if (f2 != null) {
                                this.j.objSource = f2.a();
                            }
                        }
                    } else {
                        this.f16226f.cancelAnimation();
                        AgreeData agreeData2 = this.j;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                n();
                            } else {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                o(true);
                                d.a.s0.v2.a.g().l(getTbPageContext());
                            }
                        } else {
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            o(true);
                            d.a.s0.v2.a.g().l(getTbPageContext());
                        }
                        d.a.r0.i0.c f3 = TbPageExtraHelper.f(this);
                        if (f3 != null) {
                            this.j.objSource = f3.a();
                        }
                    }
                    View.OnClickListener onClickListener = this.r;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            }
        }
    }

    public final void m(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, agreeData) == null) || agreeData == null || (agreeData2 = this.j) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        n();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f16227g.setText(h(this.j));
            AgreeData agreeData = this.j;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f16228h.setProgress(0.0f);
                    this.f16226f.setProgress(1.0f);
                    this.f16227g.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.f16229i);
                    return;
                }
                this.f16226f.setProgress(0.0f);
                this.f16228h.setProgress(1.0f);
                setTextNormalColor(this.f16227g);
                this.f16229i.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                return;
            }
            this.f16226f.setProgress(0.0f);
            this.f16228h.setProgress(0.0f);
            setTextNormalColor(this.f16227g);
            setTextNormalColor(this.f16229i);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f16226f.setMinAndMaxProgress(0.0f, 1.0f);
            this.f16228h.setMinAndMaxProgress(0.0f, 1.0f);
            this.f16227g.setText(h(this.j));
            this.f16226f.clearColorFilter();
            this.f16228h.clearColorFilter();
            if (z) {
                this.f16226f.playAnimation();
                this.f16228h.cancelAnimation();
                this.f16228h.setFrame(0);
            } else {
                this.f16228h.playAnimation();
                this.f16226f.cancelAnimation();
                this.f16226f.setFrame(0);
            }
            AgreeData agreeData = this.j;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f16227g.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.f16229i);
                    return;
                }
                setTextNormalColor(this.f16227g);
                this.f16229i.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                return;
            }
            setTextNormalColor(this.f16227g);
            setTextNormalColor(this.f16229i);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.y);
            MessageManager.getInstance().registerListener(this.z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.y);
            MessageManager.getInstance().unRegisterListener(this.z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.r = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f16228h.setVisibility(z ? 8 : 0);
            this.f16229i.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.t) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.v != z && (dVar = this.x) != null) {
                dVar.a(this.f16228h, z);
            }
            this.v = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            SkinManager.setLottieAnimation(this.f16226f, this.o);
            SkinManager.setLottieAnimation(this.f16228h, this.p);
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.j = agreeData;
        n();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f16228h.setVisibility(z ? 8 : 0);
            this.f16229i.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.t;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.v = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.q = i2;
            setTextNormalColor(this.f16227g);
            setTextNormalColor(this.f16229i);
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) {
            this.o = i2;
            this.p = i3;
            setAgreeAnimationResource();
        }
    }

    public void setThreadData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, b2Var) == null) {
        }
    }

    public void setVisibilityListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, dVar) == null) {
            this.x = dVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet) {
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
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.v = false;
        this.w = false;
        this.y = new a(this, 2016528);
        this.z = new b(this, 2016530);
        this.A = new c(this);
        i(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.v = false;
        this.w = false;
        this.y = new a(this, 2016528);
        this.z = new b(this, 2016530);
        this.A = new c(this);
        i(context);
    }
}

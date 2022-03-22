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
import c.a.d.f.p.n;
import c.a.o0.j0.f;
import c.a.o0.r.l0.h;
import c.a.p0.a4.k0.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes5.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f33074b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33075c;

    /* renamed from: d  reason: collision with root package name */
    public TBLottieAnimationView f33076d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33077e;

    /* renamed from: f  reason: collision with root package name */
    public TBLottieAnimationView f33078f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33079g;

    /* renamed from: h  reason: collision with root package name */
    public AgreeData f33080h;
    public e i;
    public ScaleAnimation j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public LinearLayout r;
    public LinearLayout s;
    public boolean t;
    public boolean u;
    public d v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public View.OnClickListener y;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdAgreeView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FunAdAgreeView funAdAgreeView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdAgreeView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = funAdAgreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f12234b;
                if (this.a.f33080h == null || agreeData == null || this.a.i == null || this.a.f33080h.isInPost || this.a.i.a == eVar.a) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (this.a.f33080h.baijiahaoData == null || !TextUtils.equals(str, this.a.f33080h.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.a.o(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.f33080h.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.o(agreeData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdAgreeView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FunAdAgreeView funAdAgreeView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdAgreeView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = funAdAgreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f12234b;
                if (this.a.f33080h == null || TextUtils.isEmpty(this.a.f33080h.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.f33080h.postId.equals(agreeData.postId) || this.a.f33080h.isInThread) {
                    return;
                }
                if (this.a.k) {
                    if (this.a.f33080h.indexOfPic == agreeData.indexOfPic) {
                        return;
                    }
                } else if (this.a.i.a == eVar.a) {
                    return;
                }
                this.a.o(agreeData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdAgreeView a;

        public c(FunAdAgreeView funAdAgreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdAgreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = funAdAgreeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.n(view);
                View.OnClickListener onClickListener = this.a.q;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.m = R.raw.lottie_agree;
        this.n = R.raw.lottie_disagree;
        this.o = R.color.CAM_X0107;
        this.t = false;
        this.u = false;
        this.w = new a(this, 2016528);
        this.x = new b(this, 2016530);
        this.y = new c(this);
        i(context);
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, textView) == null) {
            if (this.l) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.k) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.o));
            }
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                k(n.f(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.t);
                return;
            }
            k(n.f(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.t);
        }
    }

    public final String g(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, agreeData)) == null) {
            long j = agreeData != null ? agreeData.agreeNum : 0L;
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i == 0) {
                return getContext().getString(R.string.obfuscated_res_0x7f0f0754);
            }
            if (i > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33077e : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33080h : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33079g : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33076d : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33078f : (TBLottieAnimationView) invokeV.objValue;
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
            if (this.j == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.j = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.j;
        }
        return (Animation) invokeV.objValue;
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f33074b == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.f33074b = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.f33074b = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.f33074b;
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
            this.f33076d = tBLottieAnimationView;
            tBLottieAnimationView.setId(R.id.obfuscated_res_0x7f090e9b);
            this.f33076d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f33076d.setOnClickListener(this.y);
            this.f33076d.addAnimatorListener(this);
            TextView textView = new TextView(context);
            this.f33077e = textView;
            textView.setTextSize(0, n.f(context, R.dimen.T_X09));
            this.f33077e.setOnClickListener(this.y);
            TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
            this.f33078f = tBLottieAnimationView2;
            tBLottieAnimationView2.setId(R.id.obfuscated_res_0x7f090eb1);
            this.f33078f.addAnimatorListener(this);
            this.f33078f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f33078f.setOnClickListener(this.y);
            TextView textView2 = new TextView(context);
            this.f33079g = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f0755);
            this.f33079g.setTextSize(0, n.f(context, R.dimen.T_X09));
            this.f33079g.setOnClickListener(this.y);
            e eVar = new e();
            this.i = eVar;
            eVar.a = getPageId();
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
            this.s = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.addView(this.f33076d);
            linearLayout.addView(this.f33077e);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.r = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.addView(this.f33078f);
            linearLayout2.addView(this.f33079g);
            f(true);
        }
    }

    public final void k(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i, i2, i3, i4) == null) {
            int i5 = -n.f(getContext(), R.dimen.tbds24);
            int f2 = n.f(getContext(), R.dimen.tbds34);
            this.s.setGravity(i4);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
            float f3 = i3;
            layoutParams.weight = f3;
            this.s.setLayoutParams(layoutParams);
            this.f33076d.setLayoutParams(new LinearLayout.LayoutParams(i, i));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i5;
            this.f33077e.setLayoutParams(layoutParams2);
            this.r.setGravity(i4);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
            layoutParams3.weight = f3;
            this.r.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
            layoutParams4.leftMargin = f2;
            this.f33078f.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i5;
            this.f33079g.setLayoutParams(layoutParams5);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f33075c = z;
            if (z) {
                h.f(this.f33076d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || this.f33080h == null || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setLottieAnimation(this.f33076d, this.m);
        SkinManager.setLottieAnimation(this.f33078f, this.n);
        if (this.f33075c) {
            h.f(this.f33076d, i);
        }
        p();
    }

    public final void n(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || this.f33080h == null) {
            return;
        }
        if (!this.k || f.a(getContext())) {
            if (this.k || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f33077e || this.u) {
                    if (view.getId() != this.f33076d.getId() && (!this.u || view.getId() != this.f33077e.getId())) {
                        if (view.getId() == this.f33078f.getId()) {
                            this.f33078f.cancelAnimation();
                            AgreeData agreeData = this.f33080h;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    p();
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    q(false);
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                q(false);
                            }
                            c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView != null) {
                                this.f33080h.objSource = findPageExtraByView.a();
                            }
                        }
                    } else {
                        this.f33076d.cancelAnimation();
                        AgreeData agreeData2 = this.f33080h;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                p();
                            } else {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                q(true);
                                c.a.p0.k3.a.g().l(getTbPageContext());
                            }
                        } else {
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            q(true);
                            c.a.p0.k3.a.g().l(getTbPageContext());
                        }
                        c.a.o0.n0.c findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                        if (findPageExtraByView2 != null) {
                            this.f33080h.objSource = findPageExtraByView2.a();
                        }
                    }
                    View.OnClickListener onClickListener = this.p;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            }
        }
    }

    public final void o(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, agreeData) == null) || agreeData == null || (agreeData2 = this.f33080h) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        p();
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
            MessageManager.getInstance().registerListener(this.w);
            MessageManager.getInstance().registerListener(this.x);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.w);
            MessageManager.getInstance().unRegisterListener(this.x);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f33077e.setText(h(this.f33080h));
            AgreeData agreeData = this.f33080h;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f33078f.setProgress(0.0f);
                    this.f33076d.setProgress(1.0f);
                    this.f33077e.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.f33079g);
                } else {
                    this.f33076d.setProgress(0.0f);
                    this.f33078f.setProgress(1.0f);
                    setTextNormalColor(this.f33077e);
                    this.f33079g.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    if (this.f33075c) {
                        h.c(this.f33077e);
                    }
                }
            } else {
                this.f33076d.setProgress(0.0f);
                this.f33078f.setProgress(0.0f);
                setTextNormalColor(this.f33077e);
                setTextNormalColor(this.f33079g);
            }
            if (this.f33075c) {
                h.d(this.f33077e);
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f33076d.setMinAndMaxProgress(0.0f, 1.0f);
            this.f33078f.setMinAndMaxProgress(0.0f, 1.0f);
            this.f33077e.setText(h(this.f33080h));
            this.f33076d.clearColorFilter();
            this.f33078f.clearColorFilter();
            if (z) {
                this.f33076d.playAnimation();
                this.f33078f.cancelAnimation();
                this.f33078f.setFrame(0);
            } else {
                this.f33078f.playAnimation();
                this.f33076d.cancelAnimation();
                this.f33076d.setFrame(0);
            }
            AgreeData agreeData = this.f33080h;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f33077e.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.f33079g);
                } else {
                    setTextNormalColor(this.f33077e);
                    this.f33079g.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    if (this.f33075c) {
                        h.c(this.f33077e);
                    }
                }
            } else {
                setTextNormalColor(this.f33077e);
                setTextNormalColor(this.f33079g);
                if (this.f33075c) {
                    h.c(this.f33077e);
                }
            }
            if (this.f33075c) {
                h.d(this.f33077e);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f33078f.setVisibility(z ? 8 : 0);
            this.f33079g.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.r) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.t != z && (dVar = this.v) != null) {
                dVar.a(this.f33078f, z);
            }
            this.t = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            SkinManager.setLottieAnimation(this.f33076d, this.m);
            SkinManager.setLottieAnimation(this.f33078f, this.n);
            if (this.f33075c) {
                h.f(this.f33076d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.f33080h = agreeData;
        p();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f33078f.setVisibility(z ? 8 : 0);
            this.f33079g.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.r;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.t = z;
        }
    }

    public void setNormalColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.o = i;
            setTextNormalColor(this.f33077e);
            setTextNormalColor(this.f33079g);
        }
    }

    public void setResourceId(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i, i2) == null) {
            this.m = i;
            this.n = i2;
            setAgreeAnimationResource();
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, threadData) == null) {
        }
    }

    public void setVisibilityListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, dVar) == null) {
            this.v = dVar;
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
        this.a = 3;
        this.m = R.raw.lottie_agree;
        this.n = R.raw.lottie_disagree;
        this.o = R.color.CAM_X0107;
        this.t = false;
        this.u = false;
        this.w = new a(this, 2016528);
        this.x = new b(this, 2016530);
        this.y = new c(this);
        i(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdAgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 3;
        this.m = R.raw.lottie_agree;
        this.n = R.raw.lottie_disagree;
        this.o = R.color.CAM_X0107;
        this.t = false;
        this.u = false;
        this.w = new a(this, 2016528);
        this.x = new b(this, 2016530);
        this.y = new c(this);
        i(context);
    }
}

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
import b.a.e.f.p.l;
import b.a.q0.j0.f;
import b.a.q0.s.g0.h;
import b.a.q0.s.q.d2;
import b.a.r0.m3.j0.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes9.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_AGREE = 1;
    public static final int TYPE_AGREE_AND_DISAGREE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public View.OnClickListener B;

    /* renamed from: e  reason: collision with root package name */
    public int f50118e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f50119f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50120g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f50121h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50122i;
    public TBLottieAnimationView j;
    public TextView k;
    public AgreeData l;
    public e m;
    public View.OnClickListener mAfterManualClickListener;
    public ScaleAnimation n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public View.OnClickListener t;
    public LinearLayout u;
    public LinearLayout v;
    public boolean w;
    public boolean x;
    public d y;
    public CustomMessageListener z;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdAgreeView f50123a;

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
            this.f50123a = funAdAgreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f22452b;
                if (this.f50123a.l == null || agreeData == null || this.f50123a.m == null || this.f50123a.l.isInPost || this.f50123a.m.f22451a == eVar.f22451a) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (this.f50123a.l.baijiahaoData == null || !TextUtils.equals(str, this.f50123a.l.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f50123a.l(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f50123a.l.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f50123a.l(agreeData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdAgreeView f50124a;

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
            this.f50124a = funAdAgreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f22452b;
                if (this.f50124a.l == null || TextUtils.isEmpty(this.f50124a.l.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.f50124a.l.postId.equals(agreeData.postId) || this.f50124a.l.isInThread) {
                    return;
                }
                if (this.f50124a.o) {
                    if (this.f50124a.l.indexOfPic == agreeData.indexOfPic) {
                        return;
                    }
                } else if (this.f50124a.m.f22451a == eVar.f22451a) {
                    return;
                }
                this.f50124a.l(agreeData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunAdAgreeView f50125e;

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
            this.f50125e = funAdAgreeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50125e.k(view);
                View.OnClickListener onClickListener = this.f50125e.mAfterManualClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f50118e = 3;
        this.q = R.raw.lottie_agree;
        this.r = R.raw.lottie_disagree;
        this.s = R.color.CAM_X0107;
        this.w = false;
        this.x = false;
        this.z = new a(this, 2016528);
        this.A = new b(this, 2016530);
        this.B = new c(this);
        h(context);
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, textView) == null) {
            if (this.p) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.o) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.s));
            }
        }
    }

    public void adjustLayoutForWeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                j(l.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.w);
                return;
            }
            j(l.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.w);
        }
    }

    public final String f(AgreeData agreeData) {
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

    public final String g(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, agreeData)) == null) ? f(agreeData) : (String) invokeL.objValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50122i : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50121h : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (TBLottieAnimationView) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.n == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.n = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.n;
        }
        return (Animation) invokeV.objValue;
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f50119f == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.f50119f = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.f50119f = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.f50119f;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            setOrientation(0);
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
            this.f50121h = tBLottieAnimationView;
            tBLottieAnimationView.setId(R.id.img_agree);
            this.f50121h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f50121h.setOnClickListener(this.B);
            this.f50121h.addAnimatorListener(this);
            TextView textView = new TextView(context);
            this.f50122i = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X09));
            this.f50122i.setOnClickListener(this.B);
            TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
            this.j = tBLottieAnimationView2;
            tBLottieAnimationView2.setId(R.id.img_disagree);
            this.j.addAnimatorListener(this);
            this.j.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.j.setOnClickListener(this.B);
            TextView textView2 = new TextView(context);
            this.k = textView2;
            textView2.setText(R.string.fun_ad_agree_view_c_disagree);
            this.k.setTextSize(0, l.g(context, R.dimen.T_X09));
            this.k.setOnClickListener(this.B);
            e eVar = new e();
            this.m = eVar;
            eVar.f22451a = getPageId();
            i();
            setAgreeAnimationResource();
            setAgreeAlone(true);
            setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.v = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.addView(this.f50121h);
            linearLayout.addView(this.f50122i);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.u = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.addView(this.j);
            linearLayout2.addView(this.k);
            adjustLayoutForWeight(true);
        }
    }

    public boolean isAgreeAlone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public void isUseHomePageStyleAb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f50120g = z;
            if (z) {
                h.f(this.f50121h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void j(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i2, i3, i4, i5) == null) {
            int i6 = -l.g(getContext(), R.dimen.tbds24);
            int g2 = l.g(getContext(), R.dimen.tbds34);
            this.v.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f2 = i4;
            layoutParams.weight = f2;
            this.v.setLayoutParams(layoutParams);
            this.f50121h.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.f50122i.setLayoutParams(layoutParams2);
            this.u.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f2;
            this.u.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = g2;
            this.j.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.k.setLayoutParams(layoutParams5);
        }
    }

    public final void k(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || this.l == null) {
            return;
        }
        if (!this.o || f.a(getContext())) {
            if (this.o || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f50122i || this.x) {
                    if (view.getId() != this.f50121h.getId() && (!this.x || view.getId() != this.f50122i.getId())) {
                        if (view.getId() == this.j.getId()) {
                            this.j.cancelAnimation();
                            AgreeData agreeData = this.l;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    updateUI();
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    updateUiWithAnimation(false);
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                updateUiWithAnimation(false);
                            }
                            b.a.q0.m0.c f2 = TbPageExtraHelper.f(this);
                            if (f2 != null) {
                                this.l.objSource = f2.a();
                            }
                        }
                    } else {
                        this.f50121h.cancelAnimation();
                        AgreeData agreeData2 = this.l;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                updateUI();
                            } else {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                updateUiWithAnimation(true);
                                b.a.r0.z2.a.g().l(getTbPageContext());
                            }
                        } else {
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            updateUiWithAnimation(true);
                            b.a.r0.z2.a.g().l(getTbPageContext());
                        }
                        b.a.q0.m0.c f3 = TbPageExtraHelper.f(this);
                        if (f3 != null) {
                            this.l.objSource = f3.a();
                        }
                    }
                    View.OnClickListener onClickListener = this.t;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            }
        }
    }

    public final void l(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, agreeData) == null) || agreeData == null || (agreeData2 = this.l) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        updateUI();
    }

    public void onAgreeClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            k(this.f50121h);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.A);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || this.l == null || this.f50118e == i2) {
            return;
        }
        this.f50118e = i2;
        SkinManager.setLottieAnimation(this.f50121h, this.q);
        SkinManager.setLottieAnimation(this.j, this.r);
        if (this.f50120g) {
            h.f(this.f50121h, i2);
        }
        updateUI();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.A);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.j.setVisibility(z ? 8 : 0);
            this.k.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.u) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.w != z && (dVar = this.y) != null) {
                dVar.a(this.j, z);
            }
            this.w = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            SkinManager.setLottieAnimation(this.f50121h, this.q);
            SkinManager.setLottieAnimation(this.j, this.r);
            if (this.f50120g) {
                h.f(this.f50121h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.l = agreeData;
        updateUI();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.j.setVisibility(z ? 8 : 0);
            this.k.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.u;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.w = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.s = i2;
            setTextNormalColor(this.f50122i);
            setTextNormalColor(this.k);
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
            this.q = i2;
            this.r = i3;
            setAgreeAnimationResource();
        }
    }

    public void setThreadData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, d2Var) == null) {
        }
    }

    public void setVisibilityListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, dVar) == null) {
            this.y = dVar;
        }
    }

    public void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f50122i.setText(g(this.l));
            AgreeData agreeData = this.l;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.j.setProgress(0.0f);
                    this.f50121h.setProgress(1.0f);
                    this.f50122i.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.k);
                } else {
                    this.f50121h.setProgress(0.0f);
                    this.j.setProgress(1.0f);
                    setTextNormalColor(this.f50122i);
                    this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    if (this.f50120g) {
                        h.c(this.f50122i);
                    }
                }
            } else {
                this.f50121h.setProgress(0.0f);
                this.j.setProgress(0.0f);
                setTextNormalColor(this.f50122i);
                setTextNormalColor(this.k);
            }
            if (this.f50120g) {
                h.d(this.f50122i);
            }
        }
    }

    public void updateUiWithAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f50121h.setMinAndMaxProgress(0.0f, 1.0f);
            this.j.setMinAndMaxProgress(0.0f, 1.0f);
            this.f50122i.setText(g(this.l));
            this.f50121h.clearColorFilter();
            this.j.clearColorFilter();
            if (z) {
                this.f50121h.playAnimation();
                this.j.cancelAnimation();
                this.j.setFrame(0);
            } else {
                this.j.playAnimation();
                this.f50121h.cancelAnimation();
                this.f50121h.setFrame(0);
            }
            AgreeData agreeData = this.l;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f50122i.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.k);
                } else {
                    setTextNormalColor(this.f50122i);
                    this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    if (this.f50120g) {
                        h.c(this.f50122i);
                    }
                }
            } else {
                setTextNormalColor(this.f50122i);
                setTextNormalColor(this.k);
                if (this.f50120g) {
                    h.c(this.f50122i);
                }
            }
            if (this.f50120g) {
                h.d(this.f50122i);
            }
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
        this.f50118e = 3;
        this.q = R.raw.lottie_agree;
        this.r = R.raw.lottie_disagree;
        this.s = R.color.CAM_X0107;
        this.w = false;
        this.x = false;
        this.z = new a(this, 2016528);
        this.A = new b(this, 2016530);
        this.B = new c(this);
        h(context);
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
        this.f50118e = 3;
        this.q = R.raw.lottie_agree;
        this.r = R.raw.lottie_disagree;
        this.s = R.color.CAM_X0107;
        this.w = false;
        this.x = false;
        this.z = new a(this, 2016528);
        this.A = new b(this, 2016530);
        this.B = new c(this);
        h(context);
    }
}

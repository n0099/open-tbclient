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
import com.baidu.adp.lib.util.StringUtils;
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
import com.repackage.f98;
import com.repackage.fu4;
import com.repackage.g05;
import com.repackage.h05;
import com.repackage.lk8;
import com.repackage.m55;
import com.repackage.oi;
import com.repackage.p75;
/* loaded from: classes3.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public View.OnClickListener B;
    public int a;
    public TbPageContext b;
    public boolean c;
    public TBLottieAnimationView d;
    public TextView e;
    public TBLottieAnimationView f;
    public TextView g;
    public AgreeData h;
    public lk8 i;
    public ScaleAnimation j;
    public boolean k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public View.OnClickListener s;
    public View.OnClickListener t;
    public LinearLayout u;
    public LinearLayout v;
    public boolean w;
    public boolean x;
    public e y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lk8)) {
                lk8 lk8Var = (lk8) customResponsedMessage.getData();
                AgreeData agreeData = lk8Var.b;
                if (this.a.h == null || agreeData == null || this.a.i == null || this.a.h.isInPost || this.a.i.a == lk8Var.a) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (this.a.h.baijiahaoData == null || !TextUtils.equals(str, this.a.h.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.a.p(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.h.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.p(agreeData);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lk8)) {
                lk8 lk8Var = (lk8) customResponsedMessage.getData();
                AgreeData agreeData = lk8Var.b;
                if (this.a.h == null || TextUtils.isEmpty(this.a.h.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.h.postId.equals(agreeData.postId) || this.a.h.isInThread) {
                    return;
                }
                if (this.a.n) {
                    if (this.a.h.indexOfPic == agreeData.indexOfPic) {
                        return;
                    }
                } else if (this.a.i.a == lk8Var.a) {
                    return;
                }
                this.a.p(agreeData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements g05 {
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

        @Override // com.repackage.g05
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.d.setAnimation(i);
                if (!StringUtils.isNull(str)) {
                    this.a.d.setImageAssetsFolder(str);
                }
                this.a.d.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
            }
        }

        @Override // com.repackage.g05
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.d.setAnimationDir(str);
                this.a.d.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdAgreeView a;

        public d(FunAdAgreeView funAdAgreeView) {
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o(view2);
                View.OnClickListener onClickListener = this.a.t;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(View view2, boolean z);
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
        this.p = R.raw.lottie_agree;
        this.q = R.raw.lottie_disagree;
        this.r = R.color.CAM_X0107;
        this.w = false;
        this.x = false;
        this.z = new a(this, 2016528);
        this.A = new b(this, 2016530);
        this.B = new d(this);
        j(context);
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, textView) == null) {
            if (this.o) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.n) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.r));
            }
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                l(oi.f(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.w);
                return;
            }
            l(oi.f(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.w);
        }
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (TBLottieAnimationView) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.b == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.b = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.b = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.b;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final String h(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, agreeData)) == null) {
            long j = agreeData != null ? agreeData.agreeNum : 0L;
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i == 0) {
                return getContext().getString(R.string.obfuscated_res_0x7f0f0759);
            }
            if (i > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }

    public final String i(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, agreeData)) == null) ? h(agreeData) : (String) invokeL.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            setOrientation(0);
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
            this.d = tBLottieAnimationView;
            tBLottieAnimationView.setId(R.id.obfuscated_res_0x7f090e96);
            this.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.d.setOnClickListener(this.B);
            this.d.addAnimatorListener(this);
            TextView textView = new TextView(context);
            this.e = textView;
            textView.setTextSize(0, oi.f(context, R.dimen.T_X09));
            this.e.setOnClickListener(this.B);
            TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
            this.f = tBLottieAnimationView2;
            tBLottieAnimationView2.setId(R.id.obfuscated_res_0x7f090eac);
            this.f.addAnimatorListener(this);
            this.f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f.setOnClickListener(this.B);
            TextView textView2 = new TextView(context);
            this.g = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f075a);
            this.g.setTextSize(0, oi.f(context, R.dimen.T_X09));
            this.g.setOnClickListener(this.B);
            lk8 lk8Var = new lk8();
            this.i = lk8Var;
            lk8Var.a = getPageId();
            k();
            setAgreeAnimationResource();
            setAgreeAlone(true);
            setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.v = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.addView(this.d);
            linearLayout.addView(this.e);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.u = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.addView(this.f);
            linearLayout2.addView(this.g);
            g(true);
        }
    }

    public final void l(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i, i2, i3, i4) == null) {
            int i5 = -oi.f(getContext(), R.dimen.tbds24);
            int f = oi.f(getContext(), R.dimen.tbds34);
            this.v.setGravity(i4);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
            float f2 = i3;
            layoutParams.weight = f2;
            this.v.setLayoutParams(layoutParams);
            this.d.setLayoutParams(new LinearLayout.LayoutParams(i, i));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i5;
            this.e.setLayoutParams(layoutParams2);
            this.u.setGravity(i4);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
            layoutParams3.weight = f2;
            this.u.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
            layoutParams4.leftMargin = f;
            this.f.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i5;
            this.g.setLayoutParams(layoutParams5);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.c = z;
            if (z) {
                fu4.f(this.d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || this.h == null || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setLottieAnimation(this.f, this.q);
        if (this.k) {
            s();
        } else {
            SkinManager.setLottieAnimation(this.d, this.p);
            if (this.c) {
                fu4.f(this.d, i);
            }
        }
        q();
    }

    public final void o(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view2) == null) || this.h == null) {
            return;
        }
        if (!this.n || m55.a(getContext())) {
            if (this.n || ViewHelper.checkUpIsLogin(getContext())) {
                if (view2 != this.e || this.x) {
                    if (view2.getId() != this.d.getId() && (!this.x || view2.getId() != this.e.getId())) {
                        if (view2.getId() == this.f.getId()) {
                            this.f.cancelAnimation();
                            AgreeData agreeData = this.h;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    q();
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    r(false);
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                r(false);
                            }
                            p75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView != null) {
                                this.h.objSource = findPageExtraByView.a();
                            }
                        }
                    } else {
                        this.d.cancelAnimation();
                        AgreeData agreeData2 = this.h;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                q();
                            } else {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                r(true);
                                f98.g().l(getTbPageContext());
                            }
                        } else {
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            r(true);
                            f98.g().l(getTbPageContext());
                        }
                        p75 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                        if (findPageExtraByView2 != null) {
                            this.h.objSource = findPageExtraByView2.a();
                        }
                    }
                    View.OnClickListener onClickListener = this.s;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                }
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.A);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.A);
        }
    }

    public final void p(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, agreeData) == null) || agreeData == null || (agreeData2 = this.h) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        q();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.e.setText(i(this.h));
            AgreeData agreeData = this.h;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f.setProgress(0.0f);
                    this.d.setProgress(1.0f);
                    this.e.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.g);
                } else {
                    this.d.setProgress(0.0f);
                    this.f.setProgress(1.0f);
                    setTextNormalColor(this.e);
                    this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    if (this.c) {
                        fu4.c(this.e);
                    }
                }
            } else {
                this.d.setProgress(0.0f);
                this.f.setProgress(0.0f);
                setTextNormalColor(this.e);
                setTextNormalColor(this.g);
            }
            if (this.c) {
                fu4.d(this.e);
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.d.setMinAndMaxProgress(0.0f, 1.0f);
            this.f.setMinAndMaxProgress(0.0f, 1.0f);
            this.e.setText(i(this.h));
            this.d.clearColorFilter();
            this.f.clearColorFilter();
            if (z) {
                this.d.playAnimation();
                this.f.cancelAnimation();
                this.f.setFrame(0);
            } else {
                this.f.playAnimation();
                this.d.cancelAnimation();
                this.d.setFrame(0);
            }
            AgreeData agreeData = this.h;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.e.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.g);
                } else {
                    setTextNormalColor(this.e);
                    this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    if (this.c) {
                        fu4.c(this.e);
                    }
                }
            } else {
                setTextNormalColor(this.e);
                setTextNormalColor(this.g);
                if (this.c) {
                    fu4.c(this.e);
                }
            }
            if (this.c) {
                fu4.d(this.e);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            h05.f().d(this.m, "", this.l, new c(this));
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        e eVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f.setVisibility(z ? 8 : 0);
            this.g.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.u) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.w != z && (eVar = this.y) != null) {
                eVar.a(this.f, z);
            }
            this.w = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            SkinManager.setLottieAnimation(this.d, this.p);
            SkinManager.setLottieAnimation(this.f, this.q);
            if (this.c) {
                fu4.f(this.d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.h = agreeData;
        q();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f.setVisibility(z ? 8 : 0);
            this.g.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.u;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.w = z;
        }
    }

    public void setNormalColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.r = i;
            setTextNormalColor(this.e);
            setTextNormalColor(this.g);
        }
    }

    public void setResourceId(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i, i2) == null) {
            this.p = i;
            this.q = i2;
            setAgreeAnimationResource();
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, threadData) == null) {
        }
    }

    public void setUseDynamicLikeRes(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, str2) == null) {
            this.k = true;
            this.l = str;
            this.m = str2;
        }
    }

    public void setVisibilityListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            this.y = eVar;
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
        this.p = R.raw.lottie_agree;
        this.q = R.raw.lottie_disagree;
        this.r = R.color.CAM_X0107;
        this.w = false;
        this.x = false;
        this.z = new a(this, 2016528);
        this.A = new b(this, 2016530);
        this.B = new d(this);
        j(context);
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
        this.p = R.raw.lottie_agree;
        this.q = R.raw.lottie_disagree;
        this.r = R.color.CAM_X0107;
        this.w = false;
        this.x = false;
        this.z = new a(this, 2016528);
        this.A = new b(this, 2016530);
        this.B = new d(this);
        j(context);
    }
}

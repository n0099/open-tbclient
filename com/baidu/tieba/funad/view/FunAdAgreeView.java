package com.baidu.tieba.funad.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
import com.baidu.tieba.cd9;
import com.baidu.tieba.fp9;
import com.baidu.tieba.hd5;
import com.baidu.tieba.id5;
import com.baidu.tieba.ii;
import com.baidu.tieba.r55;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tj5;
import com.baidu.tieba.zl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FunAdAgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public g B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public View.OnClickListener E;
    public int a;
    public TbPageContext b;
    public boolean c;
    public TBLottieAnimationView d;
    public TextView e;
    public TBLottieAnimationView f;
    public TextView g;
    public AgreeData h;
    public fp9 i;
    public ScaleAnimation j;
    public boolean k;
    public boolean l;
    public String m;
    public String n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public View.OnClickListener t;
    public View.OnClickListener u;
    public boolean v;
    public h w;
    public LinearLayout x;
    public LinearLayout y;
    public boolean z;

    /* loaded from: classes4.dex */
    public interface g {
        void a(View view2, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void onLongPress();

        void onRelease();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, animator) == null) {
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, threadData) == null) {
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof fp9)) {
                fp9 fp9Var = (fp9) customResponsedMessage.getData();
                AgreeData agreeData = fp9Var.b;
                if (this.a.h != null && agreeData != null && this.a.i != null && !this.a.h.isInPost && this.a.i.a != fp9Var.a) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (this.a.h.baijiahaoData == null || !TextUtils.equals(str, this.a.h.baijiahaoData.oriUgcNid)) {
                            return;
                        }
                        this.a.v(agreeData);
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = this.a.h.threadId;
                    if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                        return;
                    }
                    this.a.v(agreeData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof fp9)) {
                fp9 fp9Var = (fp9) customResponsedMessage.getData();
                AgreeData agreeData = fp9Var.b;
                if (this.a.h == null || TextUtils.isEmpty(this.a.h.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.h.postId.equals(agreeData.postId) || this.a.h.isInThread) {
                    return;
                }
                if (this.a.o) {
                    if (this.a.h.indexOfPic == agreeData.indexOfPic) {
                        return;
                    }
                } else if (this.a.i.a == fp9Var.a) {
                    return;
                }
                this.a.v(agreeData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements hd5 {
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

        @Override // com.baidu.tieba.hd5
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.d.cancelAnimation();
                this.a.d.setAnimationDir(str);
                this.a.d.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
            }
        }

        @Override // com.baidu.tieba.hd5
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.d.cancelAnimation();
                this.a.d.setAnimation(i);
                if (!StringUtils.isNull(str)) {
                    this.a.d.setImageAssetsFolder(str);
                }
                this.a.d.setColorFilter(SkinManager.getColor(R.color.CAM_X0107));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.a.v = true;
            this.a.s();
            if (this.a.w != null && TbadkCoreApplication.isLogin()) {
                this.a.w.onLongPress();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdAgreeView a;

        public e(FunAdAgreeView funAdAgreeView) {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 3) || !this.a.v) {
                    return false;
                }
                if (this.a.w != null && TbadkCoreApplication.isLogin()) {
                    this.a.w.onRelease();
                }
                this.a.v = false;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdAgreeView a;

        public f(FunAdAgreeView funAdAgreeView) {
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.u(view2);
            View.OnClickListener onClickListener = this.a.u;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
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
        this.q = R.raw.lottie_agree;
        this.r = R.raw.lottie_disagree;
        this.s = R.color.CAM_X0107;
        this.v = false;
        this.z = false;
        this.A = false;
        this.C = new a(this, 2016528);
        this.D = new b(this, 2016530);
        this.E = new f(this);
        n(context);
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
        this.q = R.raw.lottie_agree;
        this.r = R.raw.lottie_disagree;
        this.s = R.color.CAM_X0107;
        this.v = false;
        this.z = false;
        this.A = false;
        this.C = new a(this, 2016528);
        this.D = new b(this, 2016530);
        this.E = new f(this);
        n(context);
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
        this.q = R.raw.lottie_agree;
        this.r = R.raw.lottie_disagree;
        this.s = R.color.CAM_X0107;
        this.v = false;
        this.z = false;
        this.A = false;
        this.C = new a(this, 2016528);
        this.D = new b(this, 2016530);
        this.E = new f(this);
        n(context);
    }

    public final String m(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, agreeData)) == null) {
            return l(agreeData);
        }
        return (String) invokeL.objValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.c = z;
            if (z) {
                r55.f(this.d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setAgreeLongClickListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, hVar) == null) {
            this.w = hVar;
            this.d.setOnLongClickListener(new d(this));
            this.d.setOnTouchListener(new e(this));
        }
    }

    public void setAgreeNumViewIsShow(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && (textView = this.e) != null) {
            if (z) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, agreeData) != null) || agreeData == null) {
            return;
        }
        this.h = agreeData;
        w();
    }

    public void setNormalColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.s = i;
            setTextNormalColor(this.e);
            setTextNormalColor(this.g);
        }
    }

    public void setVisibilityListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, gVar) == null) {
            this.B = gVar;
        }
    }

    public final void v(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, agreeData) == null) && agreeData != null && (agreeData2 = this.h) != null) {
            agreeData2.agreeType = agreeData.agreeType;
            agreeData2.hasAgree = agreeData.hasAgree;
            agreeData2.agreeNum = agreeData.agreeNum;
            w();
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            id5.g().e(this.n, "", this.m, z, new c(this));
        }
    }

    public void setResourceId(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048607, this, i, i2) == null) {
            this.q = i;
            this.r = i2;
            setAgreeAnimationResource();
        }
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, textView) == null) {
            if (this.p) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.o) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.s));
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                p(ii.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.z);
                return;
            }
            p(ii.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.z);
        }
    }

    public void setAgreeAlone(boolean z) {
        int i;
        g gVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.f;
            int i2 = 0;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            tBLottieAnimationView.setVisibility(i);
            TextView textView = this.g;
            if (z) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            if (z && (linearLayout = this.x) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.z != z && (gVar = this.B) != null) {
                gVar.a(this.f, z);
            }
            this.z = z;
        }
    }

    public void setDisagreeShow(boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.f;
            int i3 = 8;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            tBLottieAnimationView.setVisibility(i);
            TextView textView = this.g;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            textView.setVisibility(i2);
            LinearLayout linearLayout = this.x;
            if (linearLayout != null) {
                if (!z) {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
            }
            this.z = z;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && this.h != null && this.a != i) {
            this.a = i;
            SkinManager.setLottieAnimation(this.f, this.r);
            if (this.k) {
                y(this.l);
            } else {
                SkinManager.setLottieAnimation(this.d, this.q);
                if (this.c) {
                    r55.f(this.d, i);
                }
            }
            w();
        }
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbPageContext tbPageContext = getTbPageContext();
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.C);
            MessageManager.getInstance().registerListener(this.D);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.C);
            MessageManager.getInstance().unRegisterListener(this.D);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SkinManager.setLottieAnimation(this.d, this.q);
            SkinManager.setLottieAnimation(this.f, this.r);
            if (this.c) {
                r55.f(this.d, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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

    public final String l(AgreeData agreeData) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, agreeData)) == null) {
            if (agreeData != null) {
                j = agreeData.agreeNum;
            } else {
                j = 0;
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i == 0) {
                return getContext().getString(R.string.obfuscated_res_0x7f0f07dd);
            }
            if (i > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            setOrientation(0);
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
            this.d = tBLottieAnimationView;
            tBLottieAnimationView.setId(R.id.img_agree);
            this.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.d.setOnClickListener(this.E);
            this.d.addAnimatorListener(this);
            TextView textView = new TextView(context);
            this.e = textView;
            textView.setTextSize(0, ii.g(context, R.dimen.T_X09));
            this.e.setOnClickListener(this.E);
            TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
            this.f = tBLottieAnimationView2;
            tBLottieAnimationView2.setId(R.id.img_disagree);
            this.f.addAnimatorListener(this);
            this.f.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f.setOnClickListener(this.E);
            TextView textView2 = new TextView(context);
            this.g = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f07de);
            this.g.setTextSize(0, ii.g(context, R.dimen.T_X09));
            this.g.setOnClickListener(this.E);
            fp9 fp9Var = new fp9();
            this.i = fp9Var;
            fp9Var.a = getPageId();
            o();
            setAgreeAnimationResource();
            setAgreeAlone(true);
            setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.d.setMinAndMaxProgress(0.0f, 1.0f);
            this.f.setMinAndMaxProgress(0.0f, 1.0f);
            this.e.setText(m(this.h));
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
                        r55.c(this.e);
                    }
                }
            } else {
                setTextNormalColor(this.e);
                setTextNormalColor(this.g);
                if (this.c) {
                    r55.c(this.e);
                }
            }
            if (this.c) {
                r55.d(this.e);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.y = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.addView(this.d);
            linearLayout.addView(this.e);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.x = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.addView(this.f);
            linearLayout2.addView(this.g);
            k(true);
        }
    }

    public final void p(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048595, this, i, i2, i3, i4) == null) {
            int i5 = -ii.g(getContext(), R.dimen.tbds24);
            int g2 = ii.g(getContext(), R.dimen.tbds34);
            this.y.setGravity(i4);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
            float f2 = i3;
            layoutParams.weight = f2;
            this.y.setLayoutParams(layoutParams);
            this.d.setLayoutParams(new LinearLayout.LayoutParams(i, i));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i5;
            this.e.setLayoutParams(layoutParams2);
            this.x.setGravity(i4);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
            layoutParams3.weight = f2;
            this.x.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
            layoutParams4.leftMargin = g2;
            this.f.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i5;
            this.g.setLayoutParams(layoutParams5);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.h != null && this.d != null) {
            if (this.o && !tj5.a(getContext())) {
                return;
            }
            if (!this.o && !ViewHelper.checkUpIsLogin(getContext())) {
                return;
            }
            this.d.cancelAnimation();
            AgreeData agreeData = this.h;
            if (agreeData.agreeType != 2 || !agreeData.hasAgree) {
                this.h.agreeNum++;
            }
            AgreeData agreeData2 = this.h;
            agreeData2.agreeType = 2;
            agreeData2.hasAgree = true;
            w();
            zl5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                this.h.objSource = findPageExtraByView.a();
            }
            View.OnClickListener onClickListener = this.t;
            if (onClickListener != null) {
                onClickListener.onClick(this.d);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.e.setText(m(this.h));
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
                        r55.c(this.e);
                    }
                }
            } else {
                this.d.setProgress(0.0f);
                this.f.setProgress(0.0f);
                setTextNormalColor(this.e);
                setTextNormalColor(this.g);
            }
            if (this.c) {
                r55.d(this.e);
            }
        }
    }

    public void setUseDynamicLikeRes(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048609, this, str, str2, z) == null) {
            this.k = true;
            this.l = z;
            this.m = str;
            this.n = str2;
            y(z);
        }
    }

    public final void u(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, view2) != null) || this.h == null) {
            return;
        }
        if (this.o && !tj5.a(getContext())) {
            return;
        }
        if (!this.o && !ViewHelper.checkUpIsLogin(getContext())) {
            return;
        }
        if (view2 == this.e && !this.A) {
            return;
        }
        if (view2.getId() != this.d.getId() && (!this.A || view2.getId() != this.e.getId())) {
            if (view2.getId() == this.f.getId()) {
                this.f.cancelAnimation();
                AgreeData agreeData = this.h;
                if (agreeData.hasAgree) {
                    if (agreeData.agreeType == 5) {
                        agreeData.agreeType = 5;
                        agreeData.hasAgree = false;
                        w();
                    } else {
                        agreeData.agreeType = 5;
                        agreeData.hasAgree = true;
                        agreeData.agreeNum--;
                        x(false);
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    x(false);
                }
                zl5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
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
                    w();
                } else {
                    agreeData2.agreeType = 2;
                    agreeData2.hasAgree = true;
                    agreeData2.agreeNum++;
                    x(true);
                    cd9.g().l(getTbPageContext());
                }
            } else {
                agreeData2.agreeType = 2;
                agreeData2.hasAgree = true;
                agreeData2.agreeNum++;
                x(true);
                cd9.g().l(getTbPageContext());
            }
            zl5 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView2 != null) {
                this.h.objSource = findPageExtraByView2.a();
            }
        }
        View.OnClickListener onClickListener = this.t;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }
}
